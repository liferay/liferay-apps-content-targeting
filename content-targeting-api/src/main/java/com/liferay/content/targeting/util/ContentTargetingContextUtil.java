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

package com.liferay.content.targeting.util;

import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateManager;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import freemarker.cache.ClassTemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			if (_log.isWarnEnabled()) {
				_log.warn(e);
			}
		}

		return false;
	}

	public static String parseTemplate(
			Class clazz, String templatePath, Map<String, Object> context)
		throws Exception {

		if (!templatePath.startsWith("/")) {
			templatePath = "/" + templatePath;
		}

		URLTemplateResource urlTemplateResource = new URLTemplateResource(
			templatePath, clazz.getResource(templatePath));

		com.liferay.portal.kernel.template.Template template =
			TemplateManagerUtil.getTemplate(
				TemplateConstants.LANG_TYPE_FTL, urlTemplateResource, false);

		HttpServletRequest request = (HttpServletRequest)context.get("request");
		HttpServletResponse response = (HttpServletResponse)context.get(
			"response");

		// Default template context

		template.prepare(request);

		// Custom template context

		template.putAll(context);

		// Aggregate language bundles

		ResourceBundleLoader resourceBundleLoader = getResourceBundleLoader(
			request, clazz);

		request.setAttribute(
			WebKeys.RESOURCE_BUNDLE_LOADER,
			getResourceBundleLoader(request, clazz));

		String languageId = LanguageUtil.getLanguageId(request);

		ResourceBundle resourceBundle = resourceBundleLoader.loadResourceBundle(
			languageId);

		template.put("resourceBundle", resourceBundle);

		// Taglib support

		TemplateManager templateManager =
			TemplateManagerUtil.getTemplateManager(
				TemplateConstants.LANG_TYPE_FTL);

		templateManager.addTaglibSupport(template, request, response);

		// Render template with custom configuration to support includes

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

		Configuration configuration = new Configuration();

		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setTemplateLoader(
			new ClassTemplateLoader(clazz, StringPool.SLASH));
		configuration.setTemplateUpdateDelay(Integer.MAX_VALUE);

		Template freemarkerTemplate = configuration.getTemplate(templatePath);

		freemarkerTemplate.process(template, unsyncStringWriter);

		return unsyncStringWriter.toString();
	}

	public static void populateContextAnalyticsSettingsURLs(
		Map<String, Object> context) {

		Map<String, String> params = new HashMap<>();

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
				context, PortletKeys.PORTAL_SETTINGS);

		if (hasSiteSettingsViewPermission) {
			context.put(
				"siteSettingsURL",
				getSiteAdministrationPortletURL(
					context, PortletKeys.PORTAL_SETTINGS, params));
		}
	}

	protected static ResourceBundleLoader getResourceBundleLoader(
		HttpServletRequest request, Class clazz) {

		ResourceBundleLoader resourceBundleLoader =
			(ResourceBundleLoader)request.getAttribute(
				WebKeys.RESOURCE_BUNDLE_LOADER);

		if (resourceBundleLoader != null) {
			resourceBundleLoader = new AggregateResourceBundleLoader(
				resourceBundleLoader,
				new ClassResourceBundleLoader("content.Language", clazz));
		}

		return resourceBundleLoader;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ContentTargetingContextUtil.class);

}