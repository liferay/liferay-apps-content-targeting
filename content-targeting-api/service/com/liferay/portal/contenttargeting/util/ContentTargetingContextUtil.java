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

package com.liferay.portal.contenttargeting.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Julio Camarero
 */
public class ContentTargetingContextUtil {

	public static String getControlPanelPortletURL(
		Map<String, Object> context, String portletId,
		Map<String, String> params) {

		LiferayPortletResponse liferayPortletResponse =
			(LiferayPortletResponse)context.get("renderResponse");

		Company company = (Company)context.get("company");

		try {
			PortletURL portletURL =
				liferayPortletResponse.createLiferayPortletURL(
					PortalUtil.getControlPanelPlid(company.getCompanyId()),
					portletId, PortletRequest.RENDER_PHASE, false);

			if ((params != null) && !params.isEmpty()) {
				for (String param : params.keySet()) {
					portletURL.setParameter(param, params.get(param));
				}
			}

			return HttpUtil.removeParameter(
				portletURL.toString(), "controlPanelCategory");
		}
		catch (Exception e) {
			_log.error(e);
		}

		return null;
	}

	public static String getSiteAdministrationPortletURL(
		Map<String, Object> context, String portletId,
		Map<String, String> params) {

		String portletURLString = getControlPanelPortletURL(
			context, portletId, params);

		if (Validator.isNull(portletURLString)) {
			return null;
		}

		long scopeGroupId = GetterUtil.getLong(context.get("scopeGroupId"));

		portletURLString = HttpUtil.addParameter(
			portletURLString, "doAsGroupId", scopeGroupId);

		return HttpUtil.addParameter(
			portletURLString, "controlPanelCategory", "current_site");
	}

	public static boolean hasControlPanelPortletViewPermission(
		Map<String, Object> context, String portletId) {

		PermissionChecker permissionChecker = (PermissionChecker)context.get(
			"permissionChecker");

		long scopeGroupId = GetterUtil.getLong(context.get("scopeGroupId"));

		try {
			return PortletPermissionUtil.hasControlPanelAccessPermission(
				permissionChecker, scopeGroupId, portletId);
		}
		catch (Exception e) {
			_log.error(e);
		}

		return false;
	}

	public static void populateContextAnalyticsSettingsURLs(
		Map<String, Object> context) {

		Map<String, String> params = new HashMap<String, String>();

		params.put("historyKey", "_130_contentTargetingAnalytics");

		populateContextPortalSettingsURL(context, params);

		params.put("historyKey", "_165_contentTargetingAnalytics");

		populateContextSiteAdministrationURL(context, params);
	}

	public static void populateContextPortalSettingsURL(
		Map<String, Object> context, Map<String, String> params) {

		boolean hasPortalSettingsViewPermission =
			hasControlPanelPortletViewPermission(
				context, PortletKeys.PORTAL_SETTINGS);

		if (hasPortalSettingsViewPermission) {
			context.put(
				"portalSettingsURL",
				ContentTargetingContextUtil.getControlPanelPortletURL(
					context, PortletKeys.PORTAL_SETTINGS, params));
		}
	}

	public static void populateContextSiteAdministrationURL(
		Map<String, Object> context, Map<String, String> params) {

		boolean hasSiteSettingsViewPermission =
			ContentTargetingContextUtil.hasControlPanelPortletViewPermission(
				context, PortletKeys.SITE_SETTINGS);

		if (hasSiteSettingsViewPermission) {
			context.put(
				"siteSettingsURL",
				getSiteAdministrationPortletURL(
					context, PortletKeys.SITE_SETTINGS, params));
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ContentTargetingContextUtil.class);

}