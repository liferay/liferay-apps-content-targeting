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

import com.liferay.contenttargeting.UsedUserSegmentException;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.CampaignLocalService;
import com.liferay.contenttargeting.service.CampaignService;
import com.liferay.contenttargeting.service.RuleInstanceLocalService;
import com.liferay.contenttargeting.service.RuleInstanceService;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.service.UserSegmentService;
import com.liferay.contenttargeting.util.BaseModelSearchResult;
import com.liferay.contenttargeting.util.ContentTargetingUtil;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.text.Format;

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

		long campaignId = ParamUtil.getLong(request, "campaignId");

		try {
			_campaignService.deleteCampaign(campaignId);

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

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
		_ruleInstanceLocalService = ServiceTrackerUtil.getService(
			RuleInstanceLocalService.class, bundle.getBundleContext());
		_ruleInstanceService = ServiceTrackerUtil.getService(
			RuleInstanceService.class, bundle.getBundleContext());
		_rulesRegistry = ServiceTrackerUtil.getService(
			RulesRegistry.class, bundle.getBundleContext());
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
			if (campaignId > 0) {
				_campaignService.updateCampaign(
					campaignId, nameMap, descriptionMap, startDate, endDate,
					priority, userSegmentIds, serviceContext);
			}
			else {
				_campaignService.addCampaign(
					themeDisplay.getUserId(), nameMap, descriptionMap,
					startDate, endDate, priority, userSegmentIds,
					serviceContext);
			}

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			if (e instanceof PrincipalException) {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_CAMPAIGN);
			}
			else {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
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

	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put("campaignClass", Campaign.class);
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
			"tabs1", ParamUtil.getString(portletRequest, "tabs1", "campaigns"));
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

			List<Campaign> campaigns = null;
			List<UserSegment> userSegments = null;

			String keywords = ParamUtil.getString(portletRequest, "keywords");

			if (Validator.isNull(keywords)) {
				campaigns = _campaignService.getCampaigns(
					themeDisplay.getScopeGroupId());
				userSegments = _userSegmentService.getUserSegments(
					themeDisplay.getScopeGroupId());
			}
			else {
				BaseModelSearchResult<Campaign> campaignResults =
					_campaignLocalService.searchCampaigns(
						themeDisplay.getScopeGroupId(), keywords,
						QueryUtil.ALL_POS, QueryUtil.ALL_POS);

				campaigns = campaignResults.getBaseModels();

				BaseModelSearchResult<UserSegment> userSegmentResults =
					_userSegmentLocalService.searchUserSegments(
						themeDisplay.getScopeGroupId(), keywords,
						QueryUtil.ALL_POS, QueryUtil.ALL_POS);

				userSegments = userSegmentResults.getBaseModels();
			}

			template.put("campaigns", campaigns);
			template.put("userSegments", userSegments);
			template.put(
				"usedUserSegmentExceptionClass",
				UsedUserSegmentException.class);

			Format displayFormatDate =
				FastDateFormatFactoryUtil.getSimpleDateFormat(
					"dd/MM/yyyy hh:mm a", themeDisplay.getLocale(),
					themeDisplay.getTimeZone());

			template.put("displayFormatDate", displayFormatDate);
		}
		else if (path.equals(ContentTargetingPath.EDIT_CAMPAIGN)) {
			long campaignId = ParamUtil.getLong(portletRequest, "campaignId");

			template.put("campaignId", campaignId);

			int priority = 1;
			long userSegmentId = -1;

			if (campaignId > 0) {
				Campaign campaign = _campaignLocalService.getCampaign(
					campaignId);

				template.put(
					"campaign", _campaignLocalService.getCampaign(campaignId));

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
		}
		else if (path.equals(ContentTargetingPath.EDIT_RULE_INSTANCE)) {
			template.put("ruleInstanceClass", RuleInstance.class);

			RuleInstance ruleInstance = null;

			long ruleInstanceId = ParamUtil.getLong(
				portletRequest, "ruleInstanceId");

			String ruleKey;

			if (ruleInstanceId > 0) {
				ruleInstance = _ruleInstanceLocalService.getRuleInstance(
					ruleInstanceId);

				ruleKey = ruleInstance.getRuleKey();

				template.put("ruleInstance", ruleInstance);
			}
			else {
				ruleKey = ParamUtil.getString(portletRequest, "ruleKey");
			}

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
			long userSegmentId = ParamUtil.getLong(
				portletRequest, "userSegmentId");

			template.put("userSegmentId", userSegmentId);

			if (userSegmentId > 0) {
				template.put(
					"userSegment",
					_userSegmentLocalService.getUserSegment(userSegmentId));
			}
		}
		else if (path.equals(ContentTargetingPath.MANAGE_RULES)) {
			template.put("rulesRegistry", _rulesRegistry);

			Map<String, Rule> rules = _rulesRegistry.getRules();

			template.put("rules", rules.values());

			long userSegmentId = ParamUtil.getLong(
				portletRequest, "userSegmentId");

			if (userSegmentId > 0) {
				List<RuleInstance> ruleInstances =
					_ruleInstanceService.getRuleInstances(userSegmentId);

				template.put("ruleInstances", ruleInstances);

				UserSegment userSegment =
					_userSegmentLocalService.getUserSegment(userSegmentId);

				template.put("userSegment", userSegment);
			}
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
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RuleInstanceService _ruleInstanceService;
	private RulesRegistry _rulesRegistry;
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentService _userSegmentService;

}