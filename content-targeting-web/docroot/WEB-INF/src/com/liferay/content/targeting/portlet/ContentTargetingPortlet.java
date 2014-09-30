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

import com.liferay.content.targeting.InvalidDateRangeException;
import com.liferay.content.targeting.InvalidNameException;
import com.liferay.content.targeting.InvalidRuleException;
import com.liferay.content.targeting.InvalidRulesException;
import com.liferay.content.targeting.InvalidTrackingActionException;
import com.liferay.content.targeting.InvalidTrackingActionsException;
import com.liferay.content.targeting.UsedUserSegmentException;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RuleCategoriesRegistry;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.content.targeting.api.model.TrackingActionsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.util.BreadcrumbUtil;
import com.liferay.content.targeting.portlet.util.RuleTemplate;
import com.liferay.content.targeting.portlet.util.TrackingActionTemplate;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.CampaignService;
import com.liferay.content.targeting.service.ReportInstanceService;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.RuleInstanceService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.UserSegmentService;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.service.permission.ContentTargetingPermission;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.CampaignConstants;
import com.liferay.content.targeting.util.CampaignSearchContainerIterator;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.ReportSearchContainerIterator;
import com.liferay.content.targeting.util.UserSegmentSearchContainerIterator;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.taglib.aui.ValidatorTag;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.spring.transaction.TransactionAttributeBuilder;
import com.liferay.portal.spring.transaction.TransactionalCallableUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderResponse;
import javax.portlet.UnavailableException;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.springframework.transaction.interceptor.TransactionAttribute;

/**
 * @author Eduardo Garcia
 * @author Carlos Sierra Andrés
 */
public class ContentTargetingPortlet extends FreeMarkerPortlet {

	public void deleteCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		try {
			long[] deleteCampaignsIds = null;

			long campaignId = ParamUtil.getLong(request, "campaignId");

			if (campaignId > 0) {
				deleteCampaignsIds = new long[] {campaignId};
			}
			else {
				deleteCampaignsIds = StringUtil.split(
					ParamUtil.getString(request, "campaignsIds"), 0L);
			}

			for (long deleteCampaignId : deleteCampaignsIds) {
				_campaignService.deleteCampaign(deleteCampaignId);
			}

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName(), e);

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

	public void deleteUserSegment(
			ActionRequest request, ActionResponse response)
		throws Exception {

		try {
			long[] deleteUserSegmentIds = null;

			long userSegmentId = ParamUtil.getLong(request, "userSegmentId");

			if (userSegmentId > 0) {
				deleteUserSegmentIds = new long[] {userSegmentId};
			}
			else {
				deleteUserSegmentIds = StringUtil.split(
					ParamUtil.getString(request, "userSegmentIds"), 0L);
			}

			for (long deleteUserSegmentId : deleteUserSegmentIds) {
				_userSegmentService.deleteUserSegment(deleteUserSegmentId);
			}

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName(), e);

			if (e instanceof UsedUserSegmentException) {
				SessionMessages.add(
					request,
					PortalUtil.getPortletId(request) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.VIEW);
				response.setRenderParameter("tabs1", "user-segments");
			}
			else {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
		}
	}

	@Override
	public void init() throws PortletException {
		super.init();

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, bundle.getBundleContext());
		_campaignService = ServiceTrackerUtil.getService(
			CampaignService.class, bundle.getBundleContext());
		_reportInstanceService = ServiceTrackerUtil.getService(
			ReportInstanceService.class, bundle.getBundleContext());
		_reportsRegistry = ServiceTrackerUtil.getService(
			ReportsRegistry.class, bundle.getBundleContext());
		_ruleCategoriesRegistry = ServiceTrackerUtil.getService(
			RuleCategoriesRegistry.class, bundle.getBundleContext());
		_ruleInstanceLocalService = ServiceTrackerUtil.getService(
			RuleInstanceLocalService.class, bundle.getBundleContext());
		_ruleInstanceService = ServiceTrackerUtil.getService(
			RuleInstanceService.class, bundle.getBundleContext());
		_rulesRegistry = ServiceTrackerUtil.getService(
			RulesRegistry.class, bundle.getBundleContext());
		_trackingActionInstanceService = ServiceTrackerUtil.getService(
			TrackingActionInstanceService.class, bundle.getBundleContext());
		_trackingActionInstanceLocalService = ServiceTrackerUtil.getService(
			TrackingActionInstanceLocalService.class,
			bundle.getBundleContext());
		_trackingActionsRegistry = ServiceTrackerUtil.getService(
			TrackingActionsRegistry.class, bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, bundle.getBundleContext());
		_userSegmentService = ServiceTrackerUtil.getService(
			UserSegmentService.class, bundle.getBundleContext());
	}

	public void updateCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		long campaignId = ParamUtil.getLong(request, "campaignId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			request, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(request, "description");

		Date startDate = _getDate(request, "startDate");
		Date endDate = _getDate(request, "endDate");

		int priority = ParamUtil.getInteger(request, "priority");

		boolean active = ParamUtil.getBoolean(request, "active");

		// Initially, only one user segment per campaign is supported

		long[] userSegmentIds = null;

		long userSegmentId = ParamUtil.getLong(request, "userSegmentId");

		if (userSegmentId > 0) {
			userSegmentIds = new long[] {userSegmentId};
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			UserSegment.class.getName(), request);

		serviceContext.setScopeGroupId(
			themeDisplay.getSiteGroupIdOrLiveGroupId());

		try {
			Callable<Campaign> campaignCallable =
				new CampaignCallable(
					request, response, themeDisplay.getUserId(), campaignId,
					nameMap, descriptionMap, startDate, endDate, priority,
					active, userSegmentIds, serviceContext);

			TransactionalCallableUtil.call(
				_transactionAttribute, campaignCallable);

			sendRedirect(request, response);
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(request, response);

			SessionErrors.add(request, e.getClass().getName(), e);

			if (e instanceof InvalidDateRangeException ||
				e instanceof InvalidNameException ||
				e instanceof InvalidTrackingActionsException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					request,
					PortalUtil.getPortletId(request) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_CAMPAIGN);
			}
			else {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
		}
		catch (Throwable t) {
			_log.error(t);

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

	public void updateReport(ActionRequest request, ActionResponse response)
		throws Exception {

		long classPK = ParamUtil.getLong(request, "classPK");
		String reportKey = ParamUtil.getString(request, "reportKey");

		try {
			Report report = _reportsRegistry.getReport(reportKey);

			String typeSettings = report.updateReport(classPK);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ReportInstance.class.getName(), request);

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			serviceContext.setScopeGroupId(
				themeDisplay.getSiteGroupIdOrLiveGroupId());

			_reportInstanceService.addReportInstance(
				themeDisplay.getUserId(), reportKey, report.getReportType(),
				classPK, typeSettings, serviceContext);

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName(), e);

			if (e instanceof PrincipalException) {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.VIEW_REPORT);
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

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			UserSegment.class.getName(), request);

		serviceContext.setScopeGroupId(
			themeDisplay.getSiteGroupIdOrLiveGroupId());

		try {
			Callable<UserSegment> userSegmentCallable =
				new UserSegmentCallable(
					request, response, themeDisplay.getUserId(), userSegmentId,
					nameMap, descriptionMap, serviceContext);

			TransactionalCallableUtil.call(
				_transactionAttribute, userSegmentCallable);

			sendRedirect(request, response);
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(request, response);

			SessionErrors.add(request, e.getClass().getName(), e);

			if (e instanceof InvalidNameException ||
				e instanceof InvalidRulesException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					request,
					PortalUtil.getPortletId(request) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_USER_SEGMENT);
			}
			else {
				_log.error(e);

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
		}
		catch (Throwable t) {
			_log.error(t);

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

	protected void deleteRuleInstances(List<RuleInstance> ruleInstances)
		throws Exception {

		for (RuleInstance ruleInstance : ruleInstances) {
			_ruleInstanceService.deleteRuleInstance(
				ruleInstance.getRuleInstanceId());
		}
	}

	protected InvalidTrackingActionsException
		getInvalidTrackingActionsException(
			PortletRequest portletRequest) {

		if (SessionErrors.contains(
				portletRequest,
			InvalidTrackingActionsException.class.getName())) {

			return (InvalidTrackingActionsException)SessionErrors.get(
				portletRequest,
				InvalidTrackingActionsException.class.getName());
		}
		else {
			return new InvalidTrackingActionsException();
		}
	}

	protected void deleteTrackingActionInstances(
			List<TrackingActionInstance> trackingActionInstances)
		throws Exception {

		for (TrackingActionInstance trackingActionInstance :
				trackingActionInstances) {

			_trackingActionInstanceService.deleteTrackingActionInstance(
				trackingActionInstance.getTrackingActionInstanceId());
		}
	}

	protected InvalidRulesException getInvalidRulesException(
		PortletRequest portletRequest) {

		if (SessionErrors.contains(
				portletRequest, InvalidRulesException.class.getName())) {

			return (InvalidRulesException)SessionErrors.get(
				portletRequest, InvalidRulesException.class.getName());
		}
		else {
			return new InvalidRulesException();
		}
	}

	protected Map<String, String> getJSONValues(
		JSONArray data, String namespace, String id) {

		Map<String, String> values = new HashMap<String, String>(data.length());

		for (int i = 0; i < data.length(); i++) {
			JSONObject jsonObject = data.getJSONObject(i);

			String name = jsonObject.getString("name");

			name = StringUtil.replace(
				name, new String[] {namespace, id},
				new String[] {StringPool.BLANK, StringPool.BLANK});

			values.put(name, jsonObject.getString("value"));
		}

		return values;
	}

	protected String getRuleHtml(
		Rule rule, RuleInstance ruleInstance, Template template,
		Map<String, String> values, List<InvalidRuleException> exceptions) {

		Map<String, Object> context = cloneTemplateContext(template);

		String html = StringPool.BLANK;

		if ((exceptions != null) && !exceptions.isEmpty()) {
			try {
				context.put("exceptions", exceptions);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_exceptions.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		HttpServletRequest request = (HttpServletRequest)context.get("request");

		Map<String, List<ValidatorTag>> validatorTagsMap =
			new HashMap<String, List<ValidatorTag>>();

		request.setAttribute("aui:form:validatorTagsMap", validatorTagsMap);

		if (values == null) {
			values = Collections.emptyMap();
		}

		html += rule.getFormHTML(ruleInstance, context, values);

		if (!validatorTagsMap.isEmpty()) {
			try {
				context.put("validatorTagsMap", validatorTagsMap);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_validators.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		return html;
	}

	protected List<RuleInstance> getRulesFromRequest(
			PortletRequest request, PortletResponse response)
		throws Exception {

		List<RuleInstance> ruleInstances = new ArrayList<RuleInstance>();

		String userSegmentRules = ParamUtil.getString(
			request, "userSegmentRules");

		if (Validator.isNull(userSegmentRules)) {
			return ruleInstances;
		}

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			userSegmentRules);

		String rules = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(rules);

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectRule = jSONArray.getJSONObject(i);

			long ruleInstanceId = 0;
			String type = jSONObjectRule.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				ruleInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			String id = jSONObjectRule.getString("id");

			Map<String, String> ruleValues = getJSONValues(
				jSONObjectRule.getJSONArray("data"), response.getNamespace(),
				id);

			RuleInstance ruleInstance =
				_ruleInstanceLocalService.createRuleInstance(ruleInstanceId);

			ruleInstance.setRuleKey(type);
			ruleInstance.setValues(ruleValues);
			ruleInstance.setRuleGuid(id);

			ruleInstances.add(ruleInstance);
		}

		return ruleInstances;
	}

	protected String getTrackingActionHtml(
		TrackingAction trackingAction,
		TrackingActionInstance trackingActionInstance, Template template,
		Map<String, String> values,
		List<InvalidTrackingActionException> exceptions) {

		Map<String, Object> context = cloneTemplateContext(template);

		String html = StringPool.BLANK;

		if ((exceptions != null) && !exceptions.isEmpty()) {
			try {
				context.put("exceptions", exceptions);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_exceptions.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		HttpServletRequest request = (HttpServletRequest)context.get("request");

		Map<String, List<ValidatorTag>> validatorTagsMap =
			new HashMap<String, List<ValidatorTag>>();

		request.setAttribute("aui:form:validatorTagsMap", validatorTagsMap);

		if (values == null) {
			values = Collections.emptyMap();
		}

		html += trackingAction.getFormHTML(
			trackingActionInstance, context, values);

		if (!validatorTagsMap.isEmpty()) {
			try {
				context.put("validatorTagsMap", validatorTagsMap);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_validators.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		return html;
	}

	protected List<TrackingActionInstance> getTrackingActionsFromRequest(
			PortletRequest request, PortletResponse response)
		throws Exception {

		List<TrackingActionInstance> trackingActionsInstances =
			new ArrayList<TrackingActionInstance>();

		String campaignTrackingActions = ParamUtil.getString(
			request, "campaignTrackingActions");

		if (Validator.isNull(campaignTrackingActions)) {
			return trackingActionsInstances;
		}

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			campaignTrackingActions);

		String trackingActions = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(trackingActions);

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectTrackingAction = jSONArray.getJSONObject(i);

			long trackingActionInstanceId = 0;
			String type = jSONObjectTrackingAction.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				trackingActionInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			String id = jSONObjectTrackingAction.getString("id");

			Map<String, String> trackingActionValues = getJSONValues(
				jSONObjectTrackingAction.getJSONArray("data"),
				response.getNamespace(), id);

			TrackingActionInstance trackingActionInstance =
				_trackingActionInstanceLocalService.
					createTrackingActionInstance(trackingActionInstanceId);

			trackingActionInstance.setTrackingActionKey(type);
			trackingActionInstance.setValues(trackingActionValues);
			trackingActionInstance.setTrackingActionGuid(id);

			trackingActionsInstances.add(trackingActionInstance);
		}

		return trackingActionsInstances;
	}

	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put("backURL", ParamUtil.getString(portletRequest, "backURL"));
		template.put("campaignClass", Campaign.class);
		template.put(
			"campaignConstants",
			staticModels.get(CampaignConstants.class.getName()));
		template.put(
			"contentTargetingPath",
			staticModels.get(ContentTargetingPath.class.getName()));
		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put("liferayWindowStatePopUp", LiferayWindowState.POP_UP);
		template.put("portletContext", getPortletContext());
		template.put(
			"redirect", ParamUtil.getString(portletRequest, "redirect"));
		template.put(
			"tabs1",
			ParamUtil.getString(portletRequest, "tabs1", "user-segments"));
		template.put(
			"userInfo", portletRequest.getAttribute(PortletRequest.USER_INFO));
		template.put("userSegmentClass", UserSegment.class);

		populateViewContext(
			path, portletRequest, portletResponse, template, staticModels);
	}

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template,
			TemplateHashModel staticModels)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (Validator.isNull(path) || path.equals(ContentTargetingPath.VIEW) ||
			path.equals(ContentTargetingPath.VIEW_CAMPAIGNS_RESOURCES) ||
			path.equals(ContentTargetingPath.VIEW_USER_SEGMENTS_RESOURCES)) {

			template.put(
				"actionKeys", staticModels.get(ActionKeys.class.getName()));
			template.put(
				"campaignPermission",
				staticModels.get(CampaignPermission.class.getName()));
			template.put(
				"contentTargetingPermission",
				staticModels.get(ContentTargetingPermission.class.getName()));
			template.put(
				"userSegmentPermission",
				staticModels.get(UserSegmentPermission.class.getName()));

			PermissionChecker permissionChecker =
				(PermissionChecker)template.get("permissionChecker");

			long scopeGroupId = (Long)template.get("scopeGroupId");

			if (UserSegmentPermission.contains(
					permissionChecker, scopeGroupId, scopeGroupId,
					ActionKeys.DELETE)) {

				template.put(
					"userSegmentsRowChecker", new RowChecker(portletResponse));
			}

			if (CampaignPermission.contains(
					permissionChecker, scopeGroupId, scopeGroupId,
					ActionKeys.DELETE)) {

				template.put(
					"campaignsRowChecker", new RowChecker(portletResponse));
			}

			String keywords = ParamUtil.getString(portletRequest, "keywords");

			template.put(
				"campaignSearchContainerIterator",
				new CampaignSearchContainerIterator(
					themeDisplay.getSiteGroupIdOrLiveGroupId(), keywords));
			template.put(
				"userSegmentSearchContainerIterator",
				new UserSegmentSearchContainerIterator(
					themeDisplay.getSiteGroupIdOrLiveGroupId(), keywords));
		}
		else if (path.equals(ContentTargetingPath.EDIT_CAMPAIGN)) {
			long campaignId = ParamUtil.getLong(portletRequest, "campaignId");

			template.put("campaignId", campaignId);

			int priority = 1;
			long userSegmentId = -1;

			Calendar endDate = Calendar.getInstance();
			Calendar startDate = Calendar.getInstance();

			if (campaignId > 0) {
				Campaign campaign = _campaignLocalService.getCampaign(
					campaignId);

				template.put("campaign", campaign);

				List<UserSegment> campaignUserSegments =
					_userSegmentLocalService.getCampaignUserSegments(
						campaignId);

				priority = campaign.getPriority();

				// Initially, only one user segment per campaign is supported

				if ((campaignUserSegments != null) &&
					!campaignUserSegments.isEmpty()) {

					UserSegment campaignUserSegment = campaignUserSegments.get(
						0);

					userSegmentId = campaignUserSegment.getUserSegmentId();
				}

				endDate.setTime(campaign.getEndDate());
				startDate.setTime(campaign.getStartDate());
			}
			else {
				Date now = new Date();

				endDate.setTime(now);
				endDate.add(Calendar.DATE, 1);

				startDate.setTime(now);
			}

			template.put("endDate", endDate);
			template.put("priority", priority);
			template.put("startDate", startDate);
			template.put("userSegmentId", userSegmentId);

			long[] groupIds =
				ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
					themeDisplay.getScopeGroupId());

			List<UserSegment> userSegments =
				_userSegmentService.getUserSegments(groupIds);

			template.put("userSegments", userSegments);

			template.put("trackingActionsRegistry", _trackingActionsRegistry);

			Map<String, TrackingAction> trackingActions =
				_trackingActionsRegistry.getTrackingActions();

			boolean isolated = themeDisplay.isIsolated();

			try {
				themeDisplay.setIsolated(true);

				template.put("trackingActions", trackingActions.values());

				List<TrackingActionInstance> trackingActionInstances =
					getTrackingActionsFromRequest(
						portletRequest, portletResponse);

				if (trackingActionInstances.isEmpty() && (campaignId > 0)) {
					trackingActionInstances =
						_trackingActionInstanceService.
							getTrackingActionInstances(campaignId);
				}

				List<TrackingActionTemplate> addedTrackingActionTemplates =
					new ArrayList<TrackingActionTemplate>();

				if (!trackingActionInstances.isEmpty()) {
					template.put(
						"trackingActionInstances", trackingActionInstances);

					InvalidTrackingActionsException itae =
						getInvalidTrackingActionsException(portletRequest);

					for (TrackingActionInstance instance :
							trackingActionInstances) {

						TrackingAction trackingAction =
							_trackingActionsRegistry.getTrackingAction(
								instance.getTrackingActionKey());

						TrackingActionTemplate trackingActionTemplate =
							new TrackingActionTemplate();

						if (instance.getTrackingActionInstanceId() > 0) {
							trackingActionTemplate.setInstanceId(
								String.valueOf(
									instance.getTrackingActionInstanceId()));
						}
						else {
							trackingActionTemplate.setInstanceId(
								instance.getTrackingActionGuid());
						}

						trackingActionTemplate.setTrackingAction(
							trackingAction);

						String html = getTrackingActionHtml(
							trackingAction, instance, template,
							instance.getValues(),
							itae.getExceptions(
								instance.getTrackingActionGuid()));

						trackingActionTemplate.setTemplate(
							HtmlUtil.escapeAttribute(html));

						addedTrackingActionTemplates.add(
							trackingActionTemplate);
					}
				}

				template.put(
					"addedTrackingActionTemplates",
					addedTrackingActionTemplates);

				List<TrackingActionTemplate> trackingActionTemplates =
					new ArrayList<TrackingActionTemplate>();

				for (TrackingAction trackingAction : trackingActions.values()) {
					TrackingActionTemplate trackingActionTemplate =
						new TrackingActionTemplate();

					trackingActionTemplate.setTrackingAction(trackingAction);

					String html = getTrackingActionHtml(
						trackingAction, null, template, null, null);

					trackingActionTemplate.setTemplate(
						HtmlUtil.escapeAttribute(html));

					trackingActionTemplates.add(trackingActionTemplate);
				}

				template.put(
					"trackingActionTemplates", trackingActionTemplates);
			}
			finally {
				themeDisplay.setIsolated(isolated);
			}
		}
		else if (path.equals(ContentTargetingPath.EDIT_USER_SEGMENT)) {
			long userSegmentId = ParamUtil.getLong(
				portletRequest, "userSegmentId");

			template.put("ruleCategoriesRegistry", _ruleCategoriesRegistry);
			template.put("rulesRegistry", _rulesRegistry);
			template.put("userSegmentId", userSegmentId);

			Map<String, Rule> rules = _rulesRegistry.getRules();

			boolean isolated = themeDisplay.isIsolated();

			try {
				themeDisplay.setIsolated(true);

				template.put("rules", rules.values());

				List<RuleInstance> ruleInstances = getRulesFromRequest(
					portletRequest, portletResponse);

				if (ruleInstances.isEmpty() && (userSegmentId > 0)) {
					ruleInstances = _ruleInstanceService.getRuleInstances(
						userSegmentId);
				}

				List<RuleTemplate> addedRuleTemplates =
					new ArrayList<RuleTemplate>();

				if (!ruleInstances.isEmpty()) {
					template.put("ruleInstances", ruleInstances);

					InvalidRulesException ire = getInvalidRulesException(
						portletRequest);

					for (RuleInstance ruleInstance : ruleInstances) {
						Rule rule = _rulesRegistry.getRule(
							ruleInstance.getRuleKey());

						RuleTemplate ruleTemplate = new RuleTemplate();

						if (ruleInstance.getRuleInstanceId() > 0) {
							ruleTemplate.setInstanceId(
								String.valueOf(
									ruleInstance.getRuleInstanceId()));
						}
						else {
							ruleTemplate.setInstanceId(
								ruleInstance.getRuleGuid());
						}

						ruleTemplate.setRule(rule);

						String html = getRuleHtml(
							rule, ruleInstance, template,
							ruleInstance.getValues(),
							ire.getRuleExceptions(ruleInstance.getRuleGuid()));

						ruleTemplate.setTemplate(
							HtmlUtil.escapeAttribute(html));

						addedRuleTemplates.add(ruleTemplate);
					}
				}

				template.put("addedRuleTemplates", addedRuleTemplates);

				if (userSegmentId > 0) {
					UserSegment userSegment =
						_userSegmentLocalService.getUserSegment(userSegmentId);

					template.put("userSegment", userSegment);
				}

				List<RuleTemplate> ruleTemplates =
					new ArrayList<RuleTemplate>();

				for (Rule rule : rules.values()) {
					RuleTemplate ruleTemplate = new RuleTemplate();

					ruleTemplate.setRule(rule);

					String html = getRuleHtml(rule, null, template, null, null);

					ruleTemplate.setTemplate(HtmlUtil.escapeAttribute(html));

					ruleTemplates.add(ruleTemplate);
				}

				template.put("ruleTemplates", ruleTemplates);
			}
			finally {
				themeDisplay.setIsolated(isolated);
			}
		}
		else if (path.equals(ContentTargetingPath.VIEW_REPORT) ||
				 path.equals(ContentTargetingPath.VIEW_REPORTS)) {

			String className = ParamUtil.getString(portletRequest, "className");
			long classPK = ParamUtil.getLong(portletRequest, "classPK");

			template.put("className", className);
			template.put("classPK", classPK);
			template.put("reportInstanceService", _reportInstanceService);

			String name = StringPool.BLANK;

			if (className.equals(Campaign.class.getName())) {
				Campaign campaign = _campaignLocalService.getCampaign(classPK);

				name = campaign.getName(themeDisplay.getLocale());

				BreadcrumbUtil.addPortletBreadcrumbEntries(
					request, (RenderResponse)portletResponse, campaign);
			}
			else if (className.equals(UserSegment.class.getName())) {
				UserSegment userSegment =
					_userSegmentLocalService.getUserSegment(classPK);

				name = userSegment.getName(themeDisplay.getLocale());

				BreadcrumbUtil.addPortletBreadcrumbEntries(
					request, (RenderResponse)portletResponse, userSegment);
			}

			if (path.equals(ContentTargetingPath.VIEW_REPORT)) {
				template.put("name", name);

				String reportKey = ParamUtil.getString(
					portletRequest, "reportKey");

				Report report = _reportsRegistry.getReport(reportKey);

				template.put("report", report);
				template.put(
					"reportHtml",
					report.getHTML(cloneTemplateContext(template)));

				BreadcrumbUtil.addPortletBreadcrumbEntries(
					request, (RenderResponse)portletResponse, report);
			}

			if (path.equals(ContentTargetingPath.VIEW_REPORTS)) {
				PortletConfig portletConfig =
					(PortletConfig)portletRequest.getAttribute(
						JavaConstants.JAVAX_PORTLET_CONFIG);

				String title = LanguageUtil.format(
					portletConfig, themeDisplay.getLocale(),
					"reports-for-the-x-x",
					new Object[] {
						ResourceActionsUtil.getModelResource(
							themeDisplay.getLocale(), className),
						name});

				template.put("title", title);

				template.put(
					"reportSearchContainerIterator",
					new ReportSearchContainerIterator(
						themeDisplay.getScopeGroupId(), null, className));
			}
		}
	}

	protected List<InvalidRuleException> updateRules(
			long userSegmentId, PortletRequest request,
			PortletResponse response)
		throws Exception {

		List<RuleInstance> requestRuleInstances = getRulesFromRequest(
			request, response);

		List<RuleInstance> ruleInstances = ListUtil.copy(
			_ruleInstanceService.getRuleInstances(userSegmentId));

		List<InvalidRuleException> ruleExceptions =
			new ArrayList<InvalidRuleException>();

		if (requestRuleInstances.isEmpty()) {
			deleteRuleInstances(ruleInstances);

			return ruleExceptions;
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			RuleInstance.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		for (RuleInstance requestRuleInstance : requestRuleInstances) {
			Rule rule = _rulesRegistry.getRule(
				requestRuleInstance.getRuleKey());

			String typeSettings = null;

			try {
				typeSettings = rule.processRule(
					request, response, requestRuleInstance.getRuleGuid(),
					requestRuleInstance.getValues());
			}
			catch (InvalidRuleException ire) {
				ire.setRuleGuid(requestRuleInstance.getRuleGuid());

				ruleExceptions.add(ire);
			}
			catch (Exception e) {
				ruleExceptions.add(new InvalidRuleException(e.getMessage()));
			}

			try {
				if (requestRuleInstance.getRuleInstanceId() > 0) {
					RuleInstance ruleInstance =
						_ruleInstanceService.updateRuleInstance(
							requestRuleInstance.getRuleInstanceId(),
							typeSettings, serviceContext);

					ruleInstances.remove(ruleInstance);
				}
				else {
					_ruleInstanceService.addRuleInstance(
						themeDisplay.getUserId(),
						requestRuleInstance.getRuleKey(), userSegmentId,
						typeSettings, serviceContext);
				}
			}
			catch (PortalException pe) {
				_log.error("Cannot update rule", pe);
			}
		}

		// Delete removed rules

		deleteRuleInstances(ruleInstances);

		return ruleExceptions;
	}

	protected List<InvalidTrackingActionException> updateTrackingActions(
			long campaignId, PortletRequest request, PortletResponse response)
		throws Exception {

		List<TrackingActionInstance> requestTrackingActionInstances =
			getTrackingActionsFromRequest(request, response);

		List<TrackingActionInstance> trackingActionInstances = ListUtil.copy(
			_trackingActionInstanceService.getTrackingActionInstances(
				campaignId));

		List<InvalidTrackingActionException> trackingActionExceptions =
			new ArrayList<InvalidTrackingActionException>();

		if (requestTrackingActionInstances.isEmpty()) {
			deleteTrackingActionInstances(trackingActionInstances);

			return trackingActionExceptions;
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			TrackingActionInstance.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		for (TrackingActionInstance requestTrackingActionInstance :
				requestTrackingActionInstances) {

			TrackingAction trackingAction =
				_trackingActionsRegistry.getTrackingAction(
					requestTrackingActionInstance.getTrackingActionKey());

			String typeSettings = null;

			Map<String, String> trackingActionValues =
				requestTrackingActionInstance.getValues();

			try {
				typeSettings = trackingAction.processTrackingAction(
					request, response,
					requestTrackingActionInstance.getTrackingActionGuid(),
					trackingActionValues);
			}
			catch (InvalidTrackingActionException itae) {
				itae.setTrackingActionGuid(
					requestTrackingActionInstance.getTrackingActionGuid());

				trackingActionExceptions.add(itae);
			}
			catch (Exception e) {
				trackingActionExceptions.add(
					new InvalidTrackingActionException(e.getMessage()));
			}

			String alias = trackingActionValues.get("alias");
			String referrerClassName = trackingActionValues.get(
				"referrerClassName");
			long referrerClassPK = GetterUtil.getLong(
				trackingActionValues.get("referrerClassPK"));
			String elementId = trackingActionValues.get("elementId");
			String eventType = trackingActionValues.get("eventType");

			long trackingActionInstanceId =
				requestTrackingActionInstance. getTrackingActionInstanceId();

			try {
				if (trackingActionInstanceId > 0) {
					TrackingActionInstance trackingActionInstance =
						_trackingActionInstanceService.
							updateTrackingActionInstance(
								trackingActionInstanceId, alias,
								referrerClassName, referrerClassPK, elementId,
								eventType, typeSettings, serviceContext);

					trackingActionInstances.remove(trackingActionInstance);
				}
				else {
					_trackingActionInstanceService.addTrackingActionInstance(
						themeDisplay.getUserId(),
						requestTrackingActionInstance.getTrackingActionKey(),
						campaignId, alias, referrerClassName, referrerClassPK,
						elementId, eventType, typeSettings, serviceContext);
				}
			}
			catch (PortalException pe) {
				_log.error("Cannot update tracking action", pe);
			}
		}

		// Delete removed Tracking Actions

		deleteTrackingActionInstances(trackingActionInstances);

		return trackingActionExceptions;
	}

	private Date _getDate(PortletRequest portletRequest, String paramPrefix) {
		int dateMonth = ParamUtil.getInteger(
			portletRequest, paramPrefix + "Month");
		int dateDay = ParamUtil.getInteger(portletRequest, paramPrefix + "Day");
		int dateYear = ParamUtil.getInteger(
			portletRequest, paramPrefix + "Year");
		int dateHour = ParamUtil.getInteger(
			portletRequest, paramPrefix + "Hour");
		int dateMinute = ParamUtil.getInteger(
			portletRequest, paramPrefix + "Minute");
		int dateAmPm = ParamUtil.getInteger(
			portletRequest, paramPrefix + "AmPm");

		if (dateAmPm == Calendar.PM) {
			dateHour += 12;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Calendar calendar = CalendarFactoryUtil.getCalendar(
			themeDisplay.getTimeZone(), themeDisplay.getLocale());

		calendar.set(Calendar.MONTH, dateMonth);
		calendar.set(Calendar.DATE, dateDay);
		calendar.set(Calendar.YEAR, dateYear);
		calendar.set(Calendar.HOUR_OF_DAY, dateHour);
		calendar.set(Calendar.MINUTE, dateMinute);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	private static Log _log = LogFactoryUtil.getLog(
		ContentTargetingPortlet.class);

	private CampaignLocalService _campaignLocalService;
	private CampaignService _campaignService;
	private ReportInstanceService _reportInstanceService;
	private ReportsRegistry _reportsRegistry;
	private RuleCategoriesRegistry _ruleCategoriesRegistry;
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RuleInstanceService _ruleInstanceService;
	private RulesRegistry _rulesRegistry;
	private TrackingActionInstanceLocalService
		_trackingActionInstanceLocalService;
	private TrackingActionInstanceService _trackingActionInstanceService;
	private TrackingActionsRegistry _trackingActionsRegistry;
	private TransactionAttribute _transactionAttribute =
		TransactionAttributeBuilder.build(
			Propagation.REQUIRED, new Class<?>[]{Exception.class});
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentService _userSegmentService;

	private class CampaignCallable implements Callable<Campaign> {

		private CampaignCallable(
			PortletRequest portletRequest, PortletResponse portletResponse,
			long userId, long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			int priority, boolean active, long[] userSegmentIds,
			ServiceContext serviceContext) {

			_portletRequest = portletRequest;
			_portletResponse = portletResponse;
			_userId = userId;
			_campaignId = campaignId;
			_nameMap = nameMap;
			_descriptionMap = descriptionMap;
			_startDate = startDate;
			_endDate = endDate;
			_priority = priority;
			_active = active;
			_userSegmentIds = userSegmentIds;
			_serviceContext = serviceContext;
		}

		@Override
		public Campaign call() throws Exception {
			Campaign campaign = null;

			if (_campaignId > 0) {
				campaign = _campaignService.updateCampaign(
					_campaignId, _nameMap, _descriptionMap, _startDate,
					_endDate, _priority, _active, _userSegmentIds,
					_serviceContext);
			}
			else {
				campaign = _campaignService.addCampaign(
					_userId, _nameMap, _descriptionMap, _startDate, _endDate,
					_priority, _active, _userSegmentIds, _serviceContext);
			}

			List<InvalidTrackingActionException> trackingActionExceptions =
				updateTrackingActions(
					campaign.getCampaignId(), _portletRequest,
					_portletResponse);

			if (!trackingActionExceptions.isEmpty()) {
				throw new InvalidTrackingActionsException(
					trackingActionExceptions);
			}

			return campaign;
		}

		private PortletRequest _portletRequest;
		private PortletResponse _portletResponse;
		private long _userId;
		private long _campaignId;
		private Map<Locale, String> _nameMap;
		private Map<Locale, String> _descriptionMap;
		private Date _startDate;
		private Date _endDate;
		private int _priority;
		private boolean _active;
		private long[] _userSegmentIds;
		private ServiceContext _serviceContext;

	}

	private class UserSegmentCallable implements Callable<UserSegment> {

		private UserSegmentCallable(
			PortletRequest portletRequest, PortletResponse portletResponse,
			long userId, long userSegmentId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext) {

			_portletRequest = portletRequest;
			_portletResponse = portletResponse;
			_userId = userId;
			_userSegmentId = userSegmentId;
			_nameMap = nameMap;
			_descriptionMap = descriptionMap;
			_serviceContext = serviceContext;
		}

		@Override
		public UserSegment call() throws Exception {
			UserSegment userSegment = null;

			if (_userSegmentId > 0) {
				userSegment = _userSegmentService.updateUserSegment(
					_userSegmentId, _nameMap, _descriptionMap, _serviceContext);
			}
			else {
				userSegment = _userSegmentService.addUserSegment(
					_userId, _nameMap, _descriptionMap, _serviceContext);
			}

			List<InvalidRuleException> ruleExceptions = updateRules(
				userSegment.getUserSegmentId(), _portletRequest,
				_portletResponse);

			if (!ruleExceptions.isEmpty()) {
				throw new InvalidRulesException(ruleExceptions);
			}

			return userSegment;
		}

		private PortletRequest _portletRequest;
		private PortletResponse _portletResponse;
		private long _userId;
		private long _userSegmentId;
		private Map<Locale, String> _nameMap;
		private Map<Locale, String> _descriptionMap;
		private ServiceContext _serviceContext;

	}

}