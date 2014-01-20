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
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.service.UserSegmentService;
import com.liferay.contenttargeting.util.UnavailableServiceException;
import com.liferay.osgi.util.OsgiServiceUnavailableException;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.TemplateResourceLoaderUtil;
import com.liferay.portal.kernel.template.TemplateTaglibSupportProvider;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.freemarker.FreeMarkerPortlet;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.io.IOException;
import java.io.Writer;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.naming.ServiceUnavailableException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.UnavailableException;

import org.osgi.framework.Bundle;

/**
 * @author Eduardo Garcia
 * @author Carlos Sierra Andrés
 */
public class ContentTargetingPortlet extends FreeMarkerPortlet {

	public void deleteUserSegment(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long userSegmentId = ParamUtil.getLong(request, "userSegmentId");

		try {
			UserSegmentService userSegmentService =
				_userSegmentService;

			userSegmentService.deleteUserSegment(userSegmentId);

			String redirect = ParamUtil.getString(request, "redirect");

			response.sendRedirect(redirect);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

	@Override
	public void init() throws PortletException {
		super.init();

		PortletContext portletContext = getPortletContext();

		Bundle bundle = (Bundle)portletContext.getAttribute("OSGI_BUNDLE");

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		try {
			_userSegmentService = ServiceTrackerUtil.getService(
				UserSegmentService.class, bundle.getBundleContext());
			_userSegmentLocalService = ServiceTrackerUtil.getService(
				UserSegmentLocalService.class, bundle.getBundleContext());
			_rulesRegistry = ServiceTrackerUtil.getService(
				RulesRegistry.class, bundle.getBundleContext());
		} catch (OsgiServiceUnavailableException e) {
			throw new UnavailableServiceException(
				e.getUnavailableServiceClass());
		}

	}

	public void updateUserSegment(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long userSegmentId = ParamUtil.getLong(request, "userSegmentId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			request, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(request, "description");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			UserSegment.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (userSegmentId > 0) {
				_userSegmentService.updateUserSegment(
					userSegmentId, nameMap, descriptionMap, serviceContext);
			}
			else {
				_userSegmentService.addUserSegment(
					themeDisplay.getUserId(), nameMap, descriptionMap,
					serviceContext);
			}

			String redirect = ParamUtil.getString(request, "redirect");

			response.sendRedirect(redirect);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			if (e instanceof PrincipalException) {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_USER_SEGMENT);
			}
			else {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
		}
	}

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

				// Injecting static models into the template context

				BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

				TemplateHashModel staticModels = wrapper.getStaticModels();

				template.put(
					"contentTargetingPath",
					staticModels.get(
						"com.liferay.contenttargeting.portlet." +
							"ContentTargetingPath"));

				populateViewContext(
					path, portletRequest, portletResponse, template);

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

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		if (Validator.isNull(path) || path.equals(ContentTargetingPath.VIEW)) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)portletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			List<UserSegment> userSegments =
				_userSegmentService.getUserSegments(
					themeDisplay.getScopeGroupId());

			template.put("userSegments", userSegments);
		}
		else if (path.equals(ContentTargetingPath.EDIT_RULE)) {
		}
		else if (path.equals(ContentTargetingPath.EDIT_USER_SEGMENT)) {
			template.put("userSegmentClass", UserSegment.class);

			template.put("rules", _rulesRegistry.getRules());

			UserSegment userSegment = null;

			long userSegmentId = ParamUtil.getLong(
				portletRequest, "userSegmentId");

			if (userSegmentId > 0) {
				userSegment = _userSegmentLocalService.getUserSegment(
					userSegmentId);
			}

			template.put("userSegment", userSegment);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ContentTargetingPortlet.class);

	private RulesRegistry _rulesRegistry;
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentService _userSegmentService;

}