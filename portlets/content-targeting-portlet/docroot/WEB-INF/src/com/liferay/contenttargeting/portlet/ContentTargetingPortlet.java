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

import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.portlet.util.UnavailableServiceException;
import com.liferay.contenttargeting.service.RuleInstanceLocalService;
import com.liferay.contenttargeting.service.RuleInstanceService;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.service.UserSegmentService;
import com.liferay.osgi.util.OsgiServiceUnavailableException;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
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
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.freemarker.FreeMarkerPortlet;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.servlet.HttpRequestHashModel;

import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateHashModel;

import java.io.IOException;
import java.io.Writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.UnavailableException;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;

import org.osgi.framework.Bundle;

/**
 * @author Eduardo Garcia
 * @author Carlos Sierra Andrés
 */
public class ContentTargetingPortlet extends FreeMarkerPortlet {

	public void deleteRuleInstance(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long ruleInstanceId = ParamUtil.getLong(request, "ruleInstanceId");

		try {
			_ruleInstanceService.deleteRuleInstance(ruleInstanceId);

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

	public void deleteUserSegment(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long userSegmentId = ParamUtil.getLong(request, "userSegmentId");

		try {
			_userSegmentService.deleteUserSegment(userSegmentId);

			sendRedirect(request, response);
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
			_ruleInstanceService = ServiceTrackerUtil.getService(
				RuleInstanceService.class, bundle.getBundleContext());
			_ruleInstanceLocalService = ServiceTrackerUtil.getService(
				RuleInstanceLocalService.class, bundle.getBundleContext());
			_userSegmentService = ServiceTrackerUtil.getService(
				UserSegmentService.class, bundle.getBundleContext());
			_userSegmentLocalService = ServiceTrackerUtil.getService(
				UserSegmentLocalService.class, bundle.getBundleContext());
			_rulesRegistry = ServiceTrackerUtil.getService(
				RulesRegistry.class, bundle.getBundleContext());
		}
		catch (OsgiServiceUnavailableException osue) {
			throw new UnavailableServiceException(
				osue.getUnavailableServiceClass());
		}
	}

	public void updateRuleInstance(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long ruleInstanceId = ParamUtil.getLong(request, "ruleInstanceId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			RuleInstance.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String ruleKey = ParamUtil.getString(request, "ruleKey");

		Rule rule = _rulesRegistry.getRule(ruleKey);

		String typeSettings = rule.processRule(request, response);

		long userSegmentId = ParamUtil.getLong(request, "userSegmentId");

		try {
			if (ruleInstanceId > 0) {
				_ruleInstanceService.updateRuleInstance(
						ruleInstanceId, typeSettings, serviceContext);
			}
			else {
				_ruleInstanceService.addRuleInstance(
						themeDisplay.getUserId(), ruleKey, userSegmentId,
						typeSettings, serviceContext);
			}

			String portletId = PortalUtil.getPortletId(request);

			SessionMessages.add(
				request, portletId + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
				portletId);

			sendRedirect(request, response);
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

			sendRedirect(request, response);
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

				// LPS-43725

				HttpServletRequestWrapper httpServletRequestWrapper =
					new HttpServletRequestWrapper(
						PortalUtil.getHttpServletRequest(portletRequest));

				HttpServletResponseWrapper httpServletResponseWrapper =
					new HttpServletResponseWrapper(
						PortalUtil.getHttpServletResponse(portletResponse));

				HttpRequestHashModel httpRequestHashModel =
					new HttpRequestHashModel(
						httpServletRequestWrapper, httpServletResponseWrapper,
						ObjectWrapper.DEFAULT_WRAPPER);

				template.put("Request", httpRequestHashModel);

				BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

				TemplateHashModel staticModels = wrapper.getStaticModels();

				populateContext(
					portletRequest, portletResponse, template, staticModels);

				populateViewContext(
					path, portletRequest, portletResponse, template,
					staticModels);

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

	protected void populateContext(
			PortletRequest portletRequest, PortletResponse portletResponse,
			Template template, TemplateHashModel staticModels)
		throws Exception {

		template.put(
			"contentTargetingPath",
			staticModels.get(
				"com.liferay.contenttargeting.portlet.ContentTargetingPath"));
		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put("liferayWindowStatePopUp", LiferayWindowState.POP_UP);
		template.put("portletContext", getPortletContext());
		template.put(
			"redirect", ParamUtil.getString(portletRequest, "redirect"));
		template.put(
			"userInfo", portletRequest.getAttribute(PortletRequest.USER_INFO));
		template.put("userSegmentClass", UserSegment.class);
	}

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template,
			TemplateHashModel staticModels)
		throws Exception {

		if (Validator.isNull(path) || path.equals(ContentTargetingPath.VIEW)) {
			template.put(
				"actionKeys",
				staticModels.get(
					"com.liferay.contenttargeting.util.ActionKeys"));

			template.put(
				"contentTargetingPermission",
				staticModels.get(
					"com.liferay.contenttargeting.service.permission." +
						"ContentTargetingPermission"));
			template.put(
				"userSegmentPermission",
				staticModels.get(
					"com.liferay.contenttargeting.service.permission." +
						"UserSegmentPermission"));

			ThemeDisplay themeDisplay =
				(ThemeDisplay)portletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			List<UserSegment> userSegments =
				_userSegmentService.getUserSegments(
					themeDisplay.getScopeGroupId());

			template.put("userSegments", userSegments);
		}
		else if (path.equals(ContentTargetingPath.EDIT_RULE_INSTANCE)) {
			template.put("ruleInstanceClass", RuleInstance.class);

			RuleInstance ruleInstance = null;

			long ruleInstanceId = ParamUtil.getLong(
				portletRequest, "ruleInstanceId");

			if (ruleInstanceId > 0) {
				ruleInstance = _ruleInstanceLocalService.getRuleInstance(
					ruleInstanceId);

				template.put("ruleInstance", ruleInstance);
			}

			String ruleKey = ParamUtil.getString(portletRequest, "ruleKey");

			Rule rule = _rulesRegistry.getRule(ruleKey);

			String ruleFormHTML = rule.getFormHTML(
				ruleInstance, _cloneTemplateContext(template));

			template.put("ruleFormHTML", ruleFormHTML);
			template.put("ruleInstanceId", ruleInstanceId);
			template.put("ruleKey", ruleKey);
			template.put(
				"userSegmentId",
				ParamUtil.getLong(portletRequest, "userSegmentId"));
		}
		else if (path.equals(
					ContentTargetingPath.EDIT_RULE_INSTANCE_REDIRECT)) {

			String ruleKey = ParamUtil.getString(portletRequest, "ruleKey");

			template.put("ruleKey", ruleKey);
		}
		else if (path.equals(ContentTargetingPath.EDIT_USER_SEGMENT)) {
			template.put("rulesRegistry", _rulesRegistry);

			Map<String, Rule> rules = _rulesRegistry.getRules();

			template.put("rules", rules.values());

			UserSegment userSegment = null;

			long userSegmentId = ParamUtil.getLong(
				portletRequest, "userSegmentId");

			if (userSegmentId > 0) {
				userSegment = _userSegmentLocalService.getUserSegment(
					userSegmentId);

				List<RuleInstance> ruleInstances =
					_ruleInstanceService.getRuleInstances(userSegmentId);

				template.put("ruleInstances", ruleInstances);
			}
			else {
				template.put("ruleInstances", new ArrayList<RuleInstance>());
			}

			template.put("userSegment", userSegment);
			template.put("userSegmentId", userSegmentId);
		}
	}

	private Map<String, Object> _cloneTemplateContext(Template template) {
		Map<String, Object> context = new HashMap<String, Object>();

		for (String key : template.getKeys()) {
			context.put(key, template.get(key));
		}

		return context;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ContentTargetingPortlet.class);

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RuleInstanceService _ruleInstanceService;
	private RulesRegistry _rulesRegistry;
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentService _userSegmentService;

}