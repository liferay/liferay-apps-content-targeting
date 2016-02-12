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

package com.liferay.content.targeting.portlet.action;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.content.targeting.portlet.TaglibFactoryWrapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PortletConstants;
import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.portlet.SettingsConfigurationAction;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.template.TemplateManager;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.TemplateResourceLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.Writer;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Pavel Savinov
 */
public abstract class FreemarkerConfigurationAction
	extends SettingsConfigurationAction {

	public abstract String getConfigTemplate(HttpServletRequest request);

	@Override
	public void include(
		PortletConfig portletConfig, HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		String configTemplate = getConfigTemplate(request);

		ServletContext servletContext = getServletContext(request);

		String servletContextName = servletContext.getServletContextName();

		String resourcePath = servletContextName.concat(
			TemplateConstants.SERVLET_SEPARATOR).concat(configTemplate);

		boolean resourceExists = false;

		try {
			resourceExists = TemplateResourceLoaderUtil.hasTemplateResource(
				TemplateConstants.LANG_TYPE_FTL, resourcePath);
		}
		catch (TemplateException te) {
			throw new IOException(te);
		}

		if (!resourceExists) {
			_log.error(configTemplate + " is not a valid include");
		}
		else {
			try {
				TemplateResource templateResource =
					TemplateResourceLoaderUtil.getTemplateResource(
						TemplateConstants.LANG_TYPE_FTL, resourcePath);

				TemplateManager templateManager =
					TemplateManagerUtil.getTemplateManager(
						TemplateConstants.LANG_TYPE_FTL);

				Template template = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResource, false);

				templateManager.addTaglibApplication(
					template, "Application", servletContext);
				templateManager.addTaglibRequest(
					template, "Request", request, response);

				template.put("currentURL", PortalUtil.getCurrentURL(request));
				template.put(
					"portletContext",
					getSelPortletConfig(request).getPortletContext());
				template.put(
					"PortletJspTagLibs",
					new TaglibFactoryWrapper(servletContext));
				template.put("request", request);

				TemplateHandler templateHandler =
					TemplateHandlerRegistryUtil.getTemplateHandler(
						AssetEntry.class.getName());

				template.put("templateHandler", templateHandler);

				populateContext(configTemplate, request, response, template);

				Writer writer = response.getWriter();

				template.processTemplate(writer);
			}
			catch (Exception e) {
				throw new PortletException(e);
			}
		}
	}

	protected ServletContext getServletContext(HttpServletRequest request) {
		String portletResource = ParamUtil.getString(
			request, "portletResource");

		if (Validator.isNotNull(portletResource)) {
			String rootPortletId = PortletConstants.getRootPortletId(
				portletResource);

			PortletBag portletBag = PortletBagPool.get(rootPortletId);

			return portletBag.getServletContext();
		}

		return (ServletContext)request.getAttribute(WebKeys.CTX);
	}

	protected void populateContext(
			String path, HttpServletRequest request,
			HttpServletResponse response, Template template)
		throws Exception {
	}

	private static final Log _log = LogFactoryUtil.getLog(
		FreemarkerConfigurationAction.class);

}