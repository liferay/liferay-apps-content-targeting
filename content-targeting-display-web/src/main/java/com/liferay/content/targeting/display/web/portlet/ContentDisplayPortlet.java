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

package com.liferay.content.targeting.display.web.portlet;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.publisher.web.util.AssetPublisherHelper;
import com.liferay.content.targeting.display.web.util.QueryRule;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.display.template.PortletDisplayTemplateUtil;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Pavel Savinov
 */
public abstract class ContentDisplayPortlet extends MVCPortlet {

	protected void populatePortletDisplayTemplateViewContext(
			PortletRequest portletRequest, PortletResponse portletResponse,
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
		context.put("assetPublisherHelper", new AssetPublisherHelper());
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

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String displayStyle = GetterUtil.getString(
			portletPreferences.getValue("displayStyle", "full-content"));
		long displayStyleGroupId = GetterUtil.getLong(
			portletPreferences.getValue("displayStyleGroupId", null),
			themeDisplay.getScopeGroupId());

		DDMTemplate ddmTemplate =
			PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplate(
				displayStyleGroupId,
				PortalUtil.getClassNameId(AssetEntry.class), displayStyle,
				false);

		if (ddmTemplate != null) {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(
				portletRequest);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(
				portletResponse);

			String portletDisplayTemplateHtml =
				PortletDisplayTemplateUtil.renderDDMTemplate(
					request, response, ddmTemplate.getTemplateId(), results,
					context);

			portletRequest.setAttribute(
				"portletDisplayTemplateHtml", portletDisplayTemplateHtml);

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			if (Validator.isNull(queryRules) ||
				!portletDisplay.isShowConfigurationIcon()) {

				return;
			}

			for (QueryRule queryRule : queryRules) {
				AssetEntry assetEntry = queryRule.getAssetEntry();

				if (assetEntry == null) {
					continue;
				}

				List<AssetEntry> queryRuleResults = Arrays.asList(assetEntry);

				String queryRuleTemplateHtml =
					PortletDisplayTemplateUtil.renderDDMTemplate(
						request, response, ddmTemplate.getTemplateId(),
						queryRuleResults, context);

				queryRule.setTemplate(queryRuleTemplateHtml);
			}
		}
	}

}