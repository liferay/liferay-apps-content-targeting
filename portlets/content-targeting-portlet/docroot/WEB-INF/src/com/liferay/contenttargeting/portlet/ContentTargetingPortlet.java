/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.portlet;

import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.portlet.internal.RulesRegistryFactory;
import com.liferay.contenttargeting.service.UserSegmentService;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.TemplateResourceLoaderUtil;
import com.liferay.portal.kernel.template.TemplateTaglibSupportProvider;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.util.bridges.freemarker.FreeMarkerPortlet;

import java.io.IOException;
import java.io.Writer;

import javax.portlet.MimeResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eduardo Garcia
 */
public class ContentTargetingPortlet extends FreeMarkerPortlet {

	@Override
	protected void include(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, String lifecycle)
		throws IOException, PortletException {

		PortletContext portletContext = getPortletContext();

		String servletContextName = portletContext.getPortletContextName();

		String resourcePath = servletContextName.concat(
			TemplateConstants.SERVLET_SEPARATOR).concat(path);

		boolean resourceExists = false;

		try {
			resourceExists = TemplateResourceLoaderUtil.hasTemplateResource(
				TemplateConstants.LANG_TYPE_FTL, resourcePath);
		}
		catch (TemplateException te) {
			throw new IOException(te.getMessage());
		}

		if (!resourceExists) {
			_log.error(path + " is not a valid include");
		}
		else {
			try {
				TemplateResource templateResource =
					TemplateResourceLoaderUtil.getTemplateResource(
						TemplateConstants.LANG_TYPE_FTL, resourcePath);

				Template template = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResource, false);

				TemplateTaglibSupportProvider templateTaglibSupportProvider =
					getTaglibSupportProvider();

				if (templateTaglibSupportProvider != null) {
					templateTaglibSupportProvider.addTaglibSupport(
						template, servletContextName, portletRequest,
						portletResponse);
				}

				template.put("portletContext", getPortletContext());
				template.put(
					"userInfo",
					portletRequest.getAttribute(PortletRequest.USER_INFO));

				// Injecting services into the template context

				template.put(
					"userSegmentService",
					_findService(
							"content-targeting-core",
							UserSegmentService.class.getName())
				);

				Writer writer = null;

				if (portletResponse instanceof MimeResponse) {
					MimeResponse mimeResponse = (MimeResponse)portletResponse;

					writer = UnsyncPrintWriterPool.borrow(
						mimeResponse.getWriter());
				}
				else {
					writer = new UnsyncStringWriter();
				}

				template.processTemplate(writer);
			}
			catch (Exception e) {
				throw new PortletException(e);
			}
		}

		if (clearRequestParameters) {
			if (lifecycle.equals(PortletRequest.RENDER_PHASE)) {
				portletResponse.setProperty("clear-request-parameters", "true");
			}
		}
	}

	// This code has been copied from ServiceLocator and it's a provisional way
	// to retrieve the service beans

	private Object _findService(String servletContextName, String serviceName) {
		Object bean = null;

		try {
			bean = PortletBeanLocatorUtil.locate(
				servletContextName, _getServiceName(serviceName));
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return bean;
	}

	private String _getServiceName(String serviceName) {
		if (!serviceName.endsWith(".velocity")) {
			serviceName += ".velocity";
		}

		return serviceName;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ContentTargetingPortlet.class);

	private RulesRegistry _rulesRegistry =
		RulesRegistryFactory.getRulesRegistryFactory();

}