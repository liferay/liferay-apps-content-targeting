/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.portlet;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.content.targeting.portlet.util.PortletDisplayTemplateUtil;
import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

/**
 * @author Pavel Savinov
 */
public abstract class ContentDisplayPortlet extends MVCPortlet {

	protected void populatePortletDisplayTemplateViewContext(
			PortletRequest portletRequest, ThemeDisplay themeDisplay,
			List<AssetEntry> results, List<QueryRule> queryRules)
		throws Exception {

		Map<String, Object> context = new HashMap<>();

		Enumeration<String> attributeNames = portletRequest.getAttributeNames();

		while (attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			Object attributeValue = portletRequest.getAttribute(attributeName);

			context.put(attributeName, attributeValue);
		}

		context.put("assetLinkBehavior", StringPool.BLANK);
		context.put("enableComments", Boolean.FALSE.toString());
		context.put("enableFlags", Boolean.FALSE.toString());
		context.put("enablePrint", Boolean.FALSE.toString());
		context.put("enableRatings", Boolean.FALSE.toString());
		context.put("enableRelatedAssets", Boolean.FALSE.toString());
		context.put("enableSocialBookmarks", Boolean.FALSE.toString());
		context.put("metadataFields", StringPool.BLANK);

		context.put(
			"request", PortalUtil.getHttpServletRequest(portletRequest));

		PortletPreferences portletPreferences = portletRequest.getPreferences();

		String displayStyle = GetterUtil.getString(
			portletPreferences.getValue("displayStyle", "full-content"));
		long displayStyleGroupId = GetterUtil.getLong(
			portletPreferences.getValue("displayStyleGroupId", null),
			themeDisplay.getScopeGroupId());

		long portletDisplayDDMTemplateId =
			PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(
				displayStyleGroupId, displayStyle);

		if (portletDisplayDDMTemplateId > 0) {
			String portletDisplayTemplateHtml =
				PortletDisplayTemplateUtil.renderDDMTemplate(
					portletRequest, themeDisplay, portletDisplayDDMTemplateId,
					results, context);

			portletRequest.setAttribute(
				"portletDisplayTemplateHtml", portletDisplayTemplateHtml);

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			if (Validator.isNull(queryRules) ||
				!portletDisplay.isShowConfigurationIcon()) {

				return;
			}

			for (QueryRule campaignQueryRule : queryRules) {
				List<AssetEntry> queryRuleResults = Arrays.asList(
					campaignQueryRule.getAssetEntry());

				String queryRuleTemplateHtml =
					PortletDisplayTemplateUtil.renderDDMTemplate(
						portletRequest, themeDisplay,
						portletDisplayDDMTemplateId, queryRuleResults, context);

				campaignQueryRule.setTemplate(queryRuleTemplateHtml);
			}
		}
	}

}