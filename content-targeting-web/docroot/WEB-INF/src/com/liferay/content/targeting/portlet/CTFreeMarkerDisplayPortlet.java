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
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.settings.ParameterMapSettings;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

/**
 * This class contains specific logic for the Content Targeting FreeMarker
 * display portlets
 *
 * @author Eduardo Garcia
 */
public class CTFreeMarkerDisplayPortlet extends CTFreeMarkerPortlet {

	protected void populatePortletDisplayTemplateContext(
		Template template, PortletPreferences portletPreferences,
		long defaultDisplayStyleGroupId, String defaultDisplayStyle) {

		TemplateHandler templateHandler =
			TemplateHandlerRegistryUtil.getTemplateHandler(
				AssetEntry.class.getName());

		template.put("templateHandler", templateHandler);

		String displayStyle = GetterUtil.getString(
			portletPreferences.getValue("displayStyle", defaultDisplayStyle));
		long displayStyleGroupId = GetterUtil.getLong(
			portletPreferences.getValue("displayStyleGroupId", null),
			defaultDisplayStyleGroupId);

		template.put("displayStyle", displayStyle);
		template.put("displayStyleGroupId", displayStyleGroupId);
		template.put("displayStyles", ListUtil.fromString(defaultDisplayStyle));
	}

	protected void populatePortletDisplayTemplateViewContext(
			Template template, PortletRequest portletRequest,
			ThemeDisplay themeDisplay, List<AssetEntry> results,
			List<QueryRule> queryRules)
		throws Exception {

		Map<String, Object> context = cloneTemplateContext(template);

		context.put("assetLinkBehavior", StringPool.BLANK);
		context.put("enableComments", Boolean.FALSE.toString());
		context.put("enableFlags", Boolean.FALSE.toString());
		context.put("enablePrint", Boolean.FALSE.toString());
		context.put("enableRatings", Boolean.FALSE.toString());
		context.put("enableRelatedAssets", Boolean.FALSE.toString());
		context.put("enableSocialBookmarks", Boolean.FALSE.toString());
		context.put("metadataFields", StringPool.BLANK);

		long portletDisplayDDMTemplateId =
			PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(
					(Long)template.get("displayStyleGroupId"),
					(String)template.get("displayStyle"));

		if (portletDisplayDDMTemplateId > 0) {
			String portletDisplayTemplateHtml =
				PortletDisplayTemplateUtil.renderDDMTemplate(
					portletRequest, themeDisplay, portletDisplayDDMTemplateId,
					results, context);

			template.put(
				"portletDisplayTemplateHtml", portletDisplayTemplateHtml);

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			if (Validator.isNull(queryRules) ||
				!portletDisplay.isShowConfigurationIcon()) {

				return;
			}

			for (QueryRule queryRule : queryRules) {
				List<AssetEntry> queryRuleResults = Arrays.asList(
					queryRule.getAssetEntry());

				String queryRuleTemplateHtml =
					PortletDisplayTemplateUtil.renderDDMTemplate(
						portletRequest, themeDisplay,
						portletDisplayDDMTemplateId, queryRuleResults, context);

				queryRule.setTemplate(queryRuleTemplateHtml);
			}
		}
	}

	protected boolean showPreview(ThemeDisplay themeDisplay)
		throws PortalException {

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		if (portletDisplay.isShowConfigurationIcon()) {
			return true;
		}

		Group group = themeDisplay.getScopeGroup();
		Layout layout = themeDisplay.getLayout();

		if (!group.hasStagingGroup()) {
			return false;
		}

		group = group.getStagingGroup();

		layout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(
			layout.getUuid(), group.getGroupId(), layout.isPrivateLayout());

		return PortletPermissionUtil.contains(
			themeDisplay.getPermissionChecker(), layout.getPlid(),
			portletDisplay.getPortletName(), ActionKeys.CONFIGURATION);
	}

	protected void updatePreferences(
			ActionRequest request, ActionResponse response,
			PortletPreferences portletPreferences)
		throws Exception {

		UnicodeProperties properties = PropertiesParamUtil.getProperties(
			request, ParameterMapSettings.PREFERENCES_PREFIX);

		for (Map.Entry<String, String> entry : properties.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();

			portletPreferences.setValue(name, value);
		}

		portletPreferences.store();
	}

	private static Log _log = LogFactoryUtil.getLog(
		CTFreeMarkerDisplayPortlet.class);

}