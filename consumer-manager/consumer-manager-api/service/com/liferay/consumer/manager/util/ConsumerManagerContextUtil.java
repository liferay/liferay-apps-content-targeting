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

package com.liferay.consumer.manager.util;

import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;

import freemarker.cache.ClassTemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Julio Camarero
 */
public class ConsumerManagerContextUtil {

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

	public static String parseTemplate(
			Class clazz, String templatePath, Map<String, Object> context)
		throws Exception {

		Configuration configuration = new Configuration();

		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setTemplateLoader(
			new ClassTemplateLoader(clazz, StringPool.SLASH));
		configuration.setTemplateUpdateDelay(Integer.MAX_VALUE);

		Template template = configuration.getTemplate(templatePath);

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

		template.process(context, unsyncStringWriter);

		return unsyncStringWriter.toString();
	}

	public static void populateContextPortalSettingsURL(
		Map<String, Object> context, Map<String, String> params) {

		boolean hasPortalSettingsViewPermission =
			hasControlPanelPortletViewPermission(
				context, PortletKeys.PORTAL_SETTINGS);

		if (hasPortalSettingsViewPermission) {
			context.put(
				"portalSettingsURL",
				getControlPanelPortletURL(
					context, PortletKeys.PORTAL_SETTINGS, params));
		}
	}

	public static void populateContextSiteAdministrationURL(
		Map<String, Object> context, Map<String, String> params) {

		boolean hasSiteSettingsViewPermission =
			hasControlPanelPortletViewPermission(
				context, PortletKeys.SITE_SETTINGS);

		if (hasSiteSettingsViewPermission) {
			context.put(
				"siteSettingsURL", getSiteAdministrationPortletURL(
					context, PortletKeys.SITE_SETTINGS, params));
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ConsumerManagerContextUtil.class);

}