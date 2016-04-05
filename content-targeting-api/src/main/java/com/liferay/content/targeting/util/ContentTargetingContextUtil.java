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
import com.liferay.portal.kernel.servlet.BufferCacheServletResponse;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateManager;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import freemarker.cache.ClassTemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Julio Camarero
 */
public class ContentTargetingContextUtil {

	public static String includeJSP(
			ServletContext servletContext, String path,
			Map<String, Object> context)
		throws Exception {

		if (Validator.isNull(path)) {
			_log.error("Cannot find path " + path);

			return StringPool.BLANK;
		}

		HttpServletRequest request = (HttpServletRequest)context.get("request");
		HttpServletResponse response = (HttpServletResponse)context.get(
			"response");

		request.setAttribute("displayContext", context);

		ResourceBundleLoader resourceBundleLoader = getResourceBundleLoader(
			request, servletContext.getClassLoader());

		request.setAttribute(
			WebKeys.RESOURCE_BUNDLE_LOADER, resourceBundleLoader);

		RequestDispatcher requestDispatcher =
			servletContext.getRequestDispatcher(path);

		BufferCacheServletResponse bufferResponse =
			new BufferCacheServletResponse(response);

		try {
			requestDispatcher.include(request, bufferResponse);

			return bufferResponse.getString();
		}
		catch (ServletException se) {
			_log.error("Unable to include " + path, se);
		}

		return StringPool.BLANK;
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
			request, clazz.getClassLoader());

		request.setAttribute(
			WebKeys.RESOURCE_BUNDLE_LOADER, resourceBundleLoader);

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

	protected static ResourceBundleLoader getResourceBundleLoader(
		HttpServletRequest request, ClassLoader classLoader) {

		ResourceBundleLoader resourceBundleLoader =
			(ResourceBundleLoader)request.getAttribute(
				WebKeys.RESOURCE_BUNDLE_LOADER);

		if (resourceBundleLoader != null) {
			resourceBundleLoader = new AggregateResourceBundleLoader(
				resourceBundleLoader,
				new ClassResourceBundleLoader("content.Language", classLoader));
		}

		return resourceBundleLoader;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ContentTargetingContextUtil.class);

}