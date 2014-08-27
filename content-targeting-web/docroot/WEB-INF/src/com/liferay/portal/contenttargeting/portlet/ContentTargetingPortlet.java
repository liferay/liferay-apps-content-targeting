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

package com.liferay.portal.contenttargeting.portlet;

import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.contenttargeting.UsedUserSegmentException;
import com.liferay.portal.contenttargeting.api.model.Report;
import com.liferay.portal.contenttargeting.api.model.ReportsRegistry;
import com.liferay.portal.contenttargeting.api.model.Rule;
import com.liferay.portal.contenttargeting.api.model.RulesRegistry;
import com.liferay.portal.contenttargeting.api.model.TrackingAction;
import com.liferay.portal.contenttargeting.api.model.TrackingActionsRegistry;
import com.liferay.portal.contenttargeting.model.Campaign;
import com.liferay.portal.contenttargeting.model.ReportInstance;
import com.liferay.portal.contenttargeting.model.RuleInstance;
import com.liferay.portal.contenttargeting.model.TrackingActionInstance;
import com.liferay.portal.contenttargeting.model.UserSegment;
import com.liferay.portal.contenttargeting.portlet.util.RuleTemplate;
import com.liferay.portal.contenttargeting.portlet.util.TrackingActionTemplate;
import com.liferay.portal.contenttargeting.service.CampaignLocalService;
import com.liferay.portal.contenttargeting.service.CampaignService;
import com.liferay.portal.contenttargeting.service.ReportInstanceService;
import com.liferay.portal.contenttargeting.service.RuleInstanceService;
import com.liferay.portal.contenttargeting.service.TrackingActionInstanceService;
import com.liferay.portal.contenttargeting.service.UserSegmentLocalService;
import com.liferay.portal.contenttargeting.service.UserSegmentService;
import com.liferay.portal.contenttargeting.service.permission.CampaignPermission;
import com.liferay.portal.contenttargeting.service.permission.ContentTargetingPermission;
import com.liferay.portal.contenttargeting.service.permission.UserSegmentPermission;
import com.liferay.portal.contenttargeting.util.ActionKeys;
import com.liferay.portal.contenttargeting.util.CampaignConstants;
import com.liferay.portal.contenttargeting.util.CampaignSearchContainerIterator;
import com.liferay.portal.contenttargeting.util.ContentTargetingContextUtil;
import com.liferay.portal.contenttargeting.util.ContentTargetingUtil;
import com.liferay.portal.contenttargeting.util.ReportSearchContainerIterator;
import com.liferay.portal.contenttargeting.util.UserSegmentSearchContainerIterator;
import com.liferay.portal.kernel.dao.search.RowChecker;
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
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.UnavailableException;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

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
			SessionErrors.add(request, e.getClass().getName());

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
		_ruleInstanceService = ServiceTrackerUtil.getService(
			RuleInstanceService.class, bundle.getBundleContext());
		_rulesRegistry = ServiceTrackerUtil.getService(
			RulesRegistry.class, bundle.getBundleContext());
		_trackingActionInstanceService = ServiceTrackerUtil.getService(
			TrackingActionInstanceService.class, bundle.getBundleContext());
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
			Campaign campaign = null;

			if (campaignId > 0) {
				campaign = _campaignService.updateCampaign(
					campaignId, nameMap, descriptionMap, startDate, endDate,
					priority, active, userSegmentIds, serviceContext);
			}
			else {
				campaign = _campaignService.addCampaign(
					themeDisplay.getUserId(), nameMap, descriptionMap,
					startDate, endDate, priority, active, userSegmentIds,
					serviceContext);
			}

			updateTrackingActions(campaign.getCampaignId(), request, response);

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			if (e instanceof NoSuchModelException ||
				e instanceof PrincipalException) {

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_CAMPAIGN);
			}
			else {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
		}
	}

	public void updateReport(ActionRequest request, ActionResponse response)
		throws Exception {

		long classPK = ParamUtil.getLong(request, "classPK");
		String reportKey = ParamUtil.getString(request, "reportKey");

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

		UserSegment userSegment = null;

		try {
			if (userSegmentId > 0) {
				userSegment = _userSegmentService.updateUserSegment(
					userSegmentId, nameMap, descriptionMap, serviceContext);
			}
			else {
				userSegment = _userSegmentService.addUserSegment(
					themeDisplay.getUserId(), nameMap, descriptionMap,
					serviceContext);
			}

			updateRules(userSegment.getUserSegmentId(), request, response);

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			if (e instanceof NoSuchModelException ||
				e instanceof PrincipalException) {

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_USER_SEGMENT);
			}
			else {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
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
		Rule rule, RuleInstance ruleInstance, Template template) {

		Map<String, Object> ruleContext = cloneTemplateContext(template);

		HttpServletRequest request = (HttpServletRequest)ruleContext.get(
			"request");

		Map<String, List<ValidatorTag>> validatorTagsMap =
			new HashMap<String, List<ValidatorTag>>();

		request.setAttribute("aui:form:validatorTagsMap", validatorTagsMap);

		String html = rule.getFormHTML(ruleInstance, ruleContext);

		if (!validatorTagsMap.isEmpty()) {
			try {
				ruleContext.put("validatorTagsMap", validatorTagsMap);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_validators.ftl", ruleContext);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		return html;
	}

	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

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
			template.put(
				"usedUserSegmentExceptionClass",
				UsedUserSegmentException.class);
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

				if (campaignId > 0) {
					List<TrackingActionInstance> instances =
						_trackingActionInstanceService.
							getTrackingActionInstances(campaignId);

					template.put("trackingActionInstances", instances);

					List<TrackingActionTemplate> addedTrackingActionTemplates =
						new ArrayList<TrackingActionTemplate>();

					for (TrackingActionInstance instance : instances) {
						TrackingAction trackingAction =
							_trackingActionsRegistry.getTrackingAction(
								instance.getTrackingActionKey());

						TrackingActionTemplate trackingActionTemplate =
							new TrackingActionTemplate();

						String html = trackingAction.getFormHTML(
							instance, cloneTemplateContext(template));

						trackingActionTemplate.setInstanceId(
							instance.getTrackingActionInstanceId());
						trackingActionTemplate.setTrackingAction(
							trackingAction);
						trackingActionTemplate.setTemplate(
							HtmlUtil.escapeAttribute(html));

						addedTrackingActionTemplates.add(
							trackingActionTemplate);
					}

					template.put(
						"addedTrackingActionTemplates",
						addedTrackingActionTemplates);
				}

				List<TrackingActionTemplate> trackingActionTemplates =
					new ArrayList<TrackingActionTemplate>();

				for (TrackingAction trackingAction : trackingActions.values()) {
					TrackingActionTemplate trackingActionTemplate =
						new TrackingActionTemplate();

					String html = trackingAction.getFormHTML(
						null, cloneTemplateContext(template));

					trackingActionTemplate.setTrackingAction(trackingAction);
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

			template.put("userSegmentId", userSegmentId);

			template.put("rulesRegistry", _rulesRegistry);

			Map<String, Rule> rules = _rulesRegistry.getRules();

			boolean isolated = themeDisplay.isIsolated();

			try {
				themeDisplay.setIsolated(true);

				template.put("rules", rules.values());

				if (userSegmentId > 0) {
					List<RuleInstance> ruleInstances =
						_ruleInstanceService.getRuleInstances(userSegmentId);

					template.put("ruleInstances", ruleInstances);

					List<RuleTemplate> addedRuleTemplates =
						new ArrayList<RuleTemplate>();

					for (RuleInstance ruleInstance : ruleInstances) {
						Rule rule = _rulesRegistry.getRule(
							ruleInstance.getRuleKey());

						RuleTemplate ruleTemplate = new RuleTemplate();

						ruleTemplate.setInstanceId(
							ruleInstance.getRuleInstanceId());
						ruleTemplate.setRule(rule);

						String html = getRuleHtml(rule, ruleInstance, template);

						ruleTemplate.setTemplate(
							HtmlUtil.escapeAttribute(html));

						addedRuleTemplates.add(ruleTemplate);
					}

					template.put("addedRuleTemplates", addedRuleTemplates);

					UserSegment userSegment =
						_userSegmentLocalService.getUserSegment(userSegmentId);

					template.put("userSegment", userSegment);
				}

				List<RuleTemplate> ruleTemplates =
					new ArrayList<RuleTemplate>();

				for (Rule rule : rules.values()) {
					RuleTemplate ruleTemplate = new RuleTemplate();

					ruleTemplate.setRule(rule);

					String html = getRuleHtml(rule, null, template);

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

			if (path.equals(ContentTargetingPath.VIEW_REPORT)) {
				String reportKey = ParamUtil.getString(
					portletRequest, "reportKey");

				Report report = _reportsRegistry.getReport(reportKey);

				template.put("report", report);
				template.put(
					"reportHtml",
					report.getHTML(cloneTemplateContext(template)));
			}

			if (path.equals(ContentTargetingPath.VIEW_REPORTS)) {
				PortletConfig portletConfig =
					(PortletConfig)portletRequest.getAttribute(
						JavaConstants.JAVAX_PORTLET_CONFIG);

				String title = "reports";

				if (className.equals(Campaign.class.getName())) {
					Campaign campaign = _campaignLocalService.getCampaign(
						classPK);

					title = LanguageUtil.format(
						portletConfig, themeDisplay.getLocale(),
						"reports-for-campaign-x",
						campaign.getName(themeDisplay.getLocale()));
				}
				else if (className.equals(UserSegment.class.getName())) {
					UserSegment userSegment =
						_userSegmentLocalService.getUserSegment(classPK);

					title = LanguageUtil.format(
						portletConfig, themeDisplay.getLocale(),
						"reports-for-user-segment-x",
						userSegment.getName(themeDisplay.getLocale()), false);
				}

				template.put("title", title);

				template.put(
					"reportSearchContainerIterator",
					new ReportSearchContainerIterator(
						themeDisplay.getScopeGroupId(), null, className));
			}
		}
	}

	protected void updateRules(
			long userSegmentId, ActionRequest request, ActionResponse response)
		throws Exception {

		String userSegmentRules = ParamUtil.getString(
			request, "userSegmentRules");

		if (Validator.isNull(userSegmentRules)) {
			return;
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			RuleInstance.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			userSegmentRules);

		String rules = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(rules);

		List<RuleInstance> ruleInstances = ListUtil.copy(
			_ruleInstanceService.getRuleInstances(userSegmentId));

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectRule = jSONArray.getJSONObject(i);

			long ruleInstanceId = 0;
			String type = jSONObjectRule.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				ruleInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			Rule rule = _rulesRegistry.getRule(type);

			String id = jSONObjectRule.getString("id");

			Map<String, String> ruleValues = getJSONValues(
				jSONObjectRule.getJSONArray("data"), response.getNamespace(),
				id);

			String typeSettings = rule.processRule(
				request, response, id, ruleValues);

			try {
				if (ruleInstanceId > 0) {
					RuleInstance ruleInstance =
						_ruleInstanceService.updateRuleInstance(
							ruleInstanceId, typeSettings, serviceContext);

					ruleInstances.remove(ruleInstance);
				}
				else {
					_ruleInstanceService.addRuleInstance(
						themeDisplay.getUserId(), type, userSegmentId,
						typeSettings, serviceContext);
				}
			}
			catch (Exception e) {
				_log.error("Cannot update rule", e);
			}
		}

		// Delete removed rules

		for (RuleInstance ruleInstance : ruleInstances) {
			_ruleInstanceService.deleteRuleInstance(
				ruleInstance.getRuleInstanceId());
		}
	}

	protected void updateTrackingActions(
			long campaignId, ActionRequest request, ActionResponse response)
		throws Exception {

		String campaignTrackingActions = ParamUtil.getString(
			request, "campaignTrackingActions");

		if (Validator.isNull(campaignTrackingActions)) {
			return;
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			TrackingActionInstance.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			campaignTrackingActions);

		String trackingActions = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(trackingActions);

		List<TrackingActionInstance> trackingActionInstances = ListUtil.copy(
			_trackingActionInstanceService.getTrackingActionInstances(
					campaignId));

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectTrackingAction = jSONArray.getJSONObject(i);

			long trackingActionInstanceId = 0;
			String type = jSONObjectTrackingAction.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				trackingActionInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			TrackingAction trackingAction =
				_trackingActionsRegistry.getTrackingAction(type);

			String id = jSONObjectTrackingAction.getString("id");

			Map<String, String> trackingActionValues = getJSONValues(
				jSONObjectTrackingAction.getJSONArray("data"),
				response.getNamespace(), id);

			String typeSettings = trackingAction.processTrackingAction(
				request, response, id, trackingActionValues);

			String alias = trackingActionValues.get("alias");
			String referrerClassName = trackingActionValues.get(
				"referrerClassName");
			long referrerClassPK = GetterUtil.getLong(
				trackingActionValues.get("referrerClassPK"));
			String elementId = trackingActionValues.get("elementId");
			String eventType = trackingActionValues.get("eventType");

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
							themeDisplay.getUserId(), type, campaignId, alias,
							referrerClassName, referrerClassPK, elementId,
							eventType, typeSettings, serviceContext);
				}
			}
			catch (Exception e) {
				_log.error("Cannot update tracking action", e);
			}
		}

		// Delete removed Tracking Actions

		for (TrackingActionInstance trackingActionInstance :
				trackingActionInstances) {

			_trackingActionInstanceService.deleteTrackingActionInstance(
					trackingActionInstance.getTrackingActionInstanceId());
		}
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
	private RuleInstanceService _ruleInstanceService;
	private RulesRegistry _rulesRegistry;
	private TrackingActionInstanceService _trackingActionInstanceService;
	private TrackingActionsRegistry _trackingActionsRegistry;
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentService _userSegmentService;

}