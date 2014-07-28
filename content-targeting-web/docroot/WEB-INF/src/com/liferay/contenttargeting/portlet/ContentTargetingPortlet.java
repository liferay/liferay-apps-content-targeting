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

package com.liferay.contenttargeting.portlet;

import com.liferay.contenttargeting.UsedUserSegmentException;
import com.liferay.contenttargeting.api.model.Report;
import com.liferay.contenttargeting.api.model.ReportsRegistry;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.api.model.TrackingAction;
import com.liferay.contenttargeting.api.model.TrackingActionsRegistry;
import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.model.TrackingActionInstance;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.portlet.util.ReportTemplate;
import com.liferay.contenttargeting.portlet.util.RuleTemplate;
import com.liferay.contenttargeting.portlet.util.TrackingActionTemplate;
import com.liferay.contenttargeting.service.CampaignLocalService;
import com.liferay.contenttargeting.service.CampaignService;
import com.liferay.contenttargeting.service.RuleInstanceService;
import com.liferay.contenttargeting.service.TrackingActionInstanceService;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.service.UserSegmentService;
import com.liferay.contenttargeting.util.CampaignSearchContainerIterator;
import com.liferay.contenttargeting.util.ContentTargetingUtil;
import com.liferay.contenttargeting.util.UserSegmentSearchContainerIterator;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
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
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.UnavailableException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 * @author Carlos Sierra Andrés
 */
public class ContentTargetingPortlet extends CTFreeMarkerPortlet {

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

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			UserSegment.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

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

		String reportKey = ParamUtil.getString(request, "reportKey");

		Report report = _reportsRegistry.getReport(reportKey);

		report.updateReport();

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

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			UserSegment.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

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

	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put("campaignClass", Campaign.class);
		template.put(
			"campaignConstants",
			staticModels.get(
				"com.liferay.contenttargeting.util.CampaignConstants"));
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
				"actionKeys",
				staticModels.get(
					"com.liferay.contenttargeting.util.ActionKeys"));

			template.put(
				"campaignPermission",
				staticModels.get(
					"com.liferay.contenttargeting.service.permission." +
						"CampaignPermission"));
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

			template.put("rowChecker", new RowChecker(portletResponse));

			String keywords = ParamUtil.getString(portletRequest, "keywords");

			template.put(
				"campaignSearchContainerIterator",
				new CampaignSearchContainerIterator(
					themeDisplay.getScopeGroupId(), keywords));
			template.put(
				"userSegmentSearchContainerIterator",
				new UserSegmentSearchContainerIterator(
					themeDisplay.getScopeGroupId(), keywords));
			template.put(
				"usedUserSegmentExceptionClass",
				UsedUserSegmentException.class);
		}
		else if (path.equals(ContentTargetingPath.EDIT_CAMPAIGN) ||
				 path.equals(ContentTargetingPath.VIEW_CAMPAIGN_REPORTS)) {

			long campaignId = ParamUtil.getLong(portletRequest, "campaignId");

			template.put("campaignId", campaignId);

			int priority = 1;
			long userSegmentId = -1;

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
			}

			template.put("priority", priority);
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
							instance, _cloneTemplateContext(template));

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
						null, _cloneTemplateContext(template));

					trackingActionTemplate.setTrackingAction(trackingAction);
					trackingActionTemplate.setTemplate(
						HtmlUtil.escapeAttribute(html));

					trackingActionTemplates.add(trackingActionTemplate);
				}

				template.put(
					"trackingActionTemplates", trackingActionTemplates);

				if (path.equals(ContentTargetingPath.VIEW_CAMPAIGN_REPORTS)) {
					template.put(
						"tabs2", ParamUtil.getString(portletRequest, "tabs2"));

					Map<String, Report> campaignReports =
						_reportsRegistry.getReports(Campaign.class.getName());

					List<ReportTemplate> campaignReportsTemplates =
						new ArrayList<ReportTemplate>();

					for (Report report : campaignReports.values()) {
						ReportTemplate reportTemplate = new ReportTemplate();

						String html = report.getHTML(
							_cloneTemplateContext(template));

						reportTemplate.setReport(report);
						reportTemplate.setTemplate(html);

						campaignReportsTemplates.add(reportTemplate);
					}

					template.put(
						"campaignReportsTabNames",
						ListUtil.toString(campaignReportsTemplates, "name"));
					template.put(
						"campaignReportsTemplates", campaignReportsTemplates);
				}
			}
			finally {
				themeDisplay.setIsolated(isolated);
			}
		}
		else if (path.equals(ContentTargetingPath.EDIT_USER_SEGMENT) ||
				 path.equals(ContentTargetingPath.VIEW_USER_SEGMENT_REPORTS)) {

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

						String html = rule.getFormHTML(
							ruleInstance, _cloneTemplateContext(template));

						ruleTemplate.setInstanceId(
							ruleInstance.getRuleInstanceId());
						ruleTemplate.setRule(rule);
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

					String html = rule.getFormHTML(
						null, _cloneTemplateContext(template));

					ruleTemplate.setRule(rule);
					ruleTemplate.setTemplate(HtmlUtil.escapeAttribute(html));

					ruleTemplates.add(ruleTemplate);
				}

				template.put("ruleTemplates", ruleTemplates);

				if (path.equals(
						ContentTargetingPath.VIEW_USER_SEGMENT_REPORTS)) {

					template.put(
						"tabs2", ParamUtil.getString(portletRequest, "tabs2"));

					Map<String, Report> userSegmentReports =
						_reportsRegistry.getReports(
							UserSegment.class.getName());

					List<ReportTemplate> userSegmentReportsTemplates =
						new ArrayList<ReportTemplate>();

					for (Report report : userSegmentReports.values()) {
						ReportTemplate reportTemplate = new ReportTemplate();

						String html = report.getHTML(
							_cloneTemplateContext(template));

						reportTemplate.setReport(report);
						reportTemplate.setTemplate(html);

						userSegmentReportsTemplates.add(reportTemplate);
					}

					template.put(
						"userSegmentReportsTabNames",
						ListUtil.toString(userSegmentReportsTemplates, "name"));
					template.put(
						"userSegmentReportsTemplates",
						userSegmentReportsTemplates);
				}
			}
			finally {
				themeDisplay.setIsolated(isolated);
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

	private Map<String, Object> _cloneTemplateContext(Template template) {
		Map<String, Object> context = new HashMap<String, Object>();

		for (String key : template.getKeys()) {
			context.put(key, template.get(key));
		}

		return context;
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
	private ReportsRegistry _reportsRegistry;
	private RuleInstanceService _ruleInstanceService;
	private RulesRegistry _rulesRegistry;
	private TrackingActionInstanceService _trackingActionInstanceService;
	private TrackingActionsRegistry _trackingActionsRegistry;
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentService _userSegmentService;

}