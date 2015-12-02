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

import com.liferay.content.targeting.DuplicateChannelInstanceException;
import com.liferay.content.targeting.InvalidChannelException;
import com.liferay.content.targeting.InvalidChannelsException;
import com.liferay.content.targeting.InvalidDateRangeException;
import com.liferay.content.targeting.InvalidNameException;
import com.liferay.content.targeting.InvalidReportException;
import com.liferay.content.targeting.InvalidRuleException;
import com.liferay.content.targeting.InvalidRulesException;
import com.liferay.content.targeting.InvalidTrackingActionsException;
import com.liferay.content.targeting.UsedUserSegmentException;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.Channel;
import com.liferay.content.targeting.api.model.ChannelsRegistry;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RuleCategoriesRegistry;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.api.model.TrackingActionsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.util.BreadcrumbUtil;
import com.liferay.content.targeting.portlet.util.ChannelTemplate;
import com.liferay.content.targeting.portlet.util.ReportInstanceRowChecker;
import com.liferay.content.targeting.portlet.util.RuleTemplate;
import com.liferay.content.targeting.portlet.util.UnavailableServiceException;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.CampaignService;
import com.liferay.content.targeting.service.ChannelInstanceLocalService;
import com.liferay.content.targeting.service.ChannelInstanceService;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.ReportInstanceService;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.RuleInstanceService;
import com.liferay.content.targeting.service.TacticLocalService;
import com.liferay.content.targeting.service.TacticService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
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
import com.liferay.content.targeting.util.TacticSearchContainerIterator;
import com.liferay.content.targeting.util.UserSegmentSearchContainerIterator;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
import com.liferay.portal.kernel.util.ArrayUtil;
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
import com.liferay.portal.model.Group;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.permission.UserPermissionUtil;
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
import java.util.TimeZone;
import java.util.concurrent.Callable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
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
public class ContentTargetingPortlet extends CTFreeMarkerPortlet {

	public void deleteCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		try {
			long[] deleteCampaignsIds = null;

			long campaignId = ParamUtil.getLong(request, "campaignId");

			if (campaignId > 0) {
				deleteCampaignsIds = new long[]{campaignId};
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

	public void deleteReportInstance(
			ActionRequest request, ActionResponse response)
		throws Exception {

		try {
			long[] deleteReportInstanceIds = null;

			long reportInstanceId = ParamUtil.getLong(
				request, "reportInstanceId");

			if (reportInstanceId > 0) {
				deleteReportInstanceIds = new long[]{reportInstanceId};
			}
			else {
				deleteReportInstanceIds = StringUtil.split(
					ParamUtil.getString(request, "reportInstanceIds"), 0L);
			}

			for (long deleteReportInstanceId : deleteReportInstanceIds) {
				_reportInstanceLocalService.deleteReportInstance(
					deleteReportInstanceId);
			}

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName(), e);

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

	public void deleteTactic(ActionRequest request, ActionResponse response)
		throws Exception {

		try {
			long tacticId = ParamUtil.getLong(request, "tacticId");

			long[] deleteTacticsIds = null;

			if (tacticId > 0) {
				deleteTacticsIds = new long[]{tacticId};
			}
			else {
				deleteTacticsIds = StringUtil.split(
					ParamUtil.getString(request, "tacticsIds"), 0L);
			}

			for (long deleteTacticId : deleteTacticsIds) {
				_tacticLocalService.deleteTactic(deleteTacticId);
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

		long[] deleteUserSegmentIds = null;

		long userSegmentId = ParamUtil.getLong(request, "userSegmentId");

		if (userSegmentId > 0) {
			deleteUserSegmentIds = new long[]{userSegmentId};
		}
		else {
			deleteUserSegmentIds = StringUtil.split(
				ParamUtil.getString(request, "userSegmentIds"), 0L);
		}

		List<UserSegment> usedUserSegments = new ArrayList<UserSegment>();

		for (long deleteUserSegmentId : deleteUserSegmentIds) {
			try {
				_userSegmentService.deleteUserSegment(deleteUserSegmentId);
			}
			catch (Exception e) {
				if (!SessionErrors.contains(request, e.getClass().getName())) {
					SessionErrors.add(request, e.getClass().getName(), e);
				}

				if (e instanceof UsedUserSegmentException) {
					UserSegment userSegment =
						_userSegmentLocalService.fetchUserSegment(
							deleteUserSegmentId);

					if (userSegment != null) {
						usedUserSegments.add(userSegment);
					}
				}
				else {
					response.setRenderParameter(
						"mvcPath", ContentTargetingPath.ERROR);

					return;
				}
			}
		}

		if (!usedUserSegments.isEmpty()) {
			SessionMessages.add(
				request,
				PortalUtil.getPortletId(request) +
					SessionMessages. KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			SessionMessages.add(request, "usedUserSegments", usedUserSegments);

			response.setRenderParameter("mvcPath", ContentTargetingPath.VIEW);
			response.setRenderParameter("tabs1", "user-segments");
		}
		else {
			sendRedirect(request, response);
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

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, bundle.getBundleContext());
		_anonymousUserLocalService = ServiceTrackerUtil.getService(
			AnonymousUserLocalService.class, bundle.getBundleContext());
		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, bundle.getBundleContext());
		_campaignService = ServiceTrackerUtil.getService(
			CampaignService.class, bundle.getBundleContext());
		_channelInstanceService = ServiceTrackerUtil.getService(
			ChannelInstanceService.class, bundle.getBundleContext());
		_channelInstanceLocalService = ServiceTrackerUtil.getService(
			ChannelInstanceLocalService.class, bundle.getBundleContext());
		_channelsRegistry = ServiceTrackerUtil.getService(
			ChannelsRegistry.class, bundle.getBundleContext());
		_reportInstanceLocalService = ServiceTrackerUtil.getService(
			ReportInstanceLocalService.class, bundle.getBundleContext());
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
		_tacticService = ServiceTrackerUtil.getService(
			TacticService.class, bundle.getBundleContext());
		_tacticLocalService = ServiceTrackerUtil.getService(
			TacticLocalService.class, bundle.getBundleContext());
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

		String timeZoneId = ParamUtil.getString(request, "timeZoneId");

		Date startDate = _getDate(request, "startDate", timeZoneId);
		Date endDate = _getDate(request, "endDate", timeZoneId);

		int priority = ParamUtil.getInteger(request, "priority");

		boolean active = ParamUtil.getBoolean(request, "active");

		long[] userSegmentIds = null;
		long[] userSegmentAssetCategoryIds = ParamUtil.getLongValues(
			request, "userSegmentAssetCategoryIds");

		if (!ArrayUtil.isEmpty(userSegmentAssetCategoryIds)) {
			userSegmentIds = new long[userSegmentAssetCategoryIds.length];

			int userSegmentCount = 0;

			for (long userSegmentAssetCategoryId
				: userSegmentAssetCategoryIds) {

				UserSegment userSegment =
					UserSegmentLocalServiceUtil.
						fetchUserSegmentByAssetCategoryId(
							userSegmentAssetCategoryId);

				userSegmentIds[userSegmentCount++] =
					userSegment.getUserSegmentId();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Campaign.class.getName(), request);

		try {
			Callable<Campaign> campaignCallable =
				new CampaignCallable(
					request, response, themeDisplay.getUserId(), campaignId,
					nameMap, descriptionMap, startDate, endDate, timeZoneId,
					priority, active, userSegmentIds, serviceContext);

			Campaign campaign = TransactionalCallableUtil.call(
				_transactionAttribute, campaignCallable);

			boolean saveAndContinue = ParamUtil.get(
				request, "saveAndContinue", false);

			if (saveAndContinue) {
				String redirect = ParamUtil.get(request, "redirect", "");

				response.setRenderParameter(
					"campaignId", String.valueOf(campaign.getCampaignId()));
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_CAMPAIGN);
				response.setRenderParameter(
					"p_p_mode", PortletMode.VIEW.toString());
				response.setRenderParameter("redirect", redirect);

				addSuccessMessage(request, response);
			}
			else {
				sendRedirect(request, response);
			}
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

		long reportInstanceId = ParamUtil.getLong(request, "reportInstanceId");
		String reportKey = ParamUtil.getString(request, "reportKey");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ReportInstance.class.getName(), request);

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			serviceContext.setScopeGroupId(
				themeDisplay.getSiteGroupIdOrLiveGroupId());

			ReportInstance reportInstance =
				_reportInstanceLocalService.fetchReportInstance(
					reportInstanceId);

			if (reportInstance != null) {
				Report report = _reportsRegistry.getReport(reportKey);

				report.updateReport(reportInstance);

				reportInstance.setModifiedDate(new Date());

				_reportInstanceLocalService.updateReportInstance(
					reportInstance);
			}

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

	public void updateReportInstance(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long reportInstanceId = ParamUtil.getLong(request, "reportInstanceId");
		String reportKey = ParamUtil.getString(request, "reportKey");
		String className = ParamUtil.getString(request, "className");
		long classPK = ParamUtil.getLong(request, "classPK");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			request, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(request, "description");

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		try {
			Callable<ReportInstance> reportInstanceCallable =
				new ReportInstanceCallable(
					request, response, themeDisplay.getUserId(),
					reportInstanceId, reportKey, className, classPK, nameMap,
					descriptionMap, serviceContext);

			ReportInstance reportInstance = TransactionalCallableUtil.call(
				_transactionAttribute, reportInstanceCallable);

			boolean saveAndContinue = ParamUtil.get(
				request, "saveAndContinue", false);

			if (saveAndContinue) {
				String redirect = ParamUtil.get(request, "redirect", "");

				response.setRenderParameter("className", className);
				response.setRenderParameter("classPK", String.valueOf(classPK));
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_REPORT);
				response.setRenderParameter("redirect", redirect);
				response.setRenderParameter(
					"p_p_mode", PortletMode.VIEW.toString());
				response.setRenderParameter(
					"reportInstanceId",
					String.valueOf(reportInstance.getReportInstanceId()));
				response.setRenderParameter("reportKey", reportKey);

				addSuccessMessage(request, response);
			}
			else {
				sendRedirect(request, response);
			}
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(request, response);

			SessionErrors.add(request, e.getClass().getName(), e);

			if (e instanceof InvalidDateRangeException ||
				e instanceof InvalidNameException ||
				e instanceof InvalidReportException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					request,
					PortalUtil.getPortletId(request) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_REPORT);
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

	public void updateTactic(ActionRequest request, ActionResponse response)
		throws Exception {

		long campaignId = ParamUtil.getLong(request, "campaignId");

		long tacticId = ParamUtil.getLong(request, "tacticId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			request, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(request, "description");

		long[] userSegmentIds = null;
		long[] userSegmentAssetCategoryIds = ParamUtil.getLongValues(
			request, "userSegmentAssetCategoryIds");

		if (!ArrayUtil.isEmpty(userSegmentAssetCategoryIds)) {
			userSegmentIds = new long[userSegmentAssetCategoryIds.length];
			int userSegmentCount = 0;

			for (long userSegmentAssetCategoryId
					: userSegmentAssetCategoryIds) {

				UserSegment userSegment =
					UserSegmentLocalServiceUtil.
						fetchUserSegmentByAssetCategoryId(
							userSegmentAssetCategoryId);

				userSegmentIds[userSegmentCount++] =
					userSegment.getUserSegmentId();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Campaign.class.getName(), request);

		try {
			Callable<Tactic> tacticCallable =
				new TacticCallable(
					request, response, themeDisplay.getUserId(), tacticId,
					campaignId, nameMap, descriptionMap, userSegmentIds,
					serviceContext);

			Tactic tactic = TransactionalCallableUtil.call(
				_transactionAttribute, tacticCallable);

			boolean saveAndContinue = ParamUtil.get(
				request, "saveAndContinue", false);

			if (saveAndContinue) {
				String redirect = ParamUtil.get(request, "redirect", "");

				response.setRenderParameter(
					"campaignId", String.valueOf(campaignId));
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_TACTIC);
				response.setRenderParameter("redirect", redirect);
				response.setRenderParameter(
					"p_p_mode", PortletMode.VIEW.toString());
				response.setRenderParameter(
					"tacticId", String.valueOf(tactic.getTacticId()));

				addSuccessMessage(request, response);
			}
			else {
				sendRedirect(request, response);
			}
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(request, response);

			SessionErrors.add(request, e.getClass().getName(), e);

			if (e instanceof InvalidDateRangeException ||
				e instanceof InvalidNameException ||
				e instanceof InvalidChannelsException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					request,
					PortalUtil.getPortletId(request) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_TACTIC);
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
			request);

		try {
			Callable<UserSegment> userSegmentCallable =
				new UserSegmentCallable(
					request, response, themeDisplay.getUserId(), userSegmentId,
					nameMap, descriptionMap, serviceContext);

			UserSegment userSegment = TransactionalCallableUtil.call(
				_transactionAttribute, userSegmentCallable);

			boolean saveAndContinue = ParamUtil.get(
				request, "saveAndContinue", false);

			if (saveAndContinue) {
				String redirect = ParamUtil.get(request, "redirect", "");

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_USER_SEGMENT);
				response.setRenderParameter("redirect", redirect);
				response.setRenderParameter(
					"p_p_mode", PortletMode.VIEW.toString());
				response.setRenderParameter(
					"userSegmentId",
					String.valueOf(userSegment.getUserSegmentId()));

				addSuccessMessage(request, response);
			}
			else {
				sendRedirect(request, response);
			}
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

	protected void deleteChannelInstances(
			List<ChannelInstance> channelInstances)
		throws Exception {

		for (ChannelInstance channelInstance : channelInstances) {
			_channelInstanceService.deleteChannelInstance(
				channelInstance.getChannelInstanceId());
		}
	}

	protected void deleteRuleInstances(List<RuleInstance> ruleInstances)
		throws Exception {

		for (RuleInstance ruleInstance : ruleInstances) {
			_ruleInstanceService.deleteRuleInstance(
				ruleInstance.getRuleInstanceId());
		}
	}

	@Override
	protected void doPopulateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		_checkServices();

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put(
			"actionKeys", staticModels.get(ActionKeys.class.getName()));
		template.put("campaignClass", Campaign.class);
		template.put(
			"campaignConstants",
			staticModels.get(CampaignConstants.class.getName()));
		template.put(
			"campaignPermission",
			staticModels.get(CampaignPermission.class.getName()));
		template.put(
			"contentTargetingPath",
			staticModels.get(ContentTargetingPath.class.getName()));
		template.put(
			"contentTargetingPermission",
			staticModels.get(ContentTargetingPermission.class.getName()));
		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put("liferayWindowStatePopUp", LiferayWindowState.POP_UP);
		template.put("portletClass", getClass());
		template.put("portletContext", getPortletContext());
		template.put("reportInstanceClass", ReportInstance.class);
		template.put(
			"tabs1",
			ParamUtil.getString(portletRequest, "tabs1", "user-segments"));
		template.put("tacticClass", Tactic.class);
		template.put(
			"userInfo", portletRequest.getAttribute(PortletRequest.USER_INFO));
		template.put("userSegmentClass", UserSegment.class);
		template.put(
			"userSegmentPermission",
			staticModels.get(UserSegmentPermission.class.getName()));
		template.put(
			"userPermissionUtil",
			staticModels.get(UserPermissionUtil.class.getName()));

		populateViewContext(
			path, portletRequest, portletResponse, template, staticModels);
	}

	protected String getChannelHtml(
		Channel channel, ChannelInstance channelInstance, Template template,
		Map<String, String> values, List<InvalidChannelException> exceptions) {

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

		html += channel.getFormHTML(channelInstance, context, values);

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

	protected List<ChannelInstance> getChannelsFromRequest(
			PortletRequest request, PortletResponse response)
		throws Exception {

		List<ChannelInstance> channelInstances =
			new ArrayList<ChannelInstance>();

		String tacticChannels = ParamUtil.getString(request, "tacticChannels");

		if (Validator.isNull(tacticChannels)) {
			return channelInstances;
		}

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			tacticChannels);

		String channels = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(channels);

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectChannel = jSONArray.getJSONObject(i);

			long channelInstanceId = 0;

			String type = jSONObjectChannel.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				channelInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			String id = jSONObjectChannel.getString("id");

			Map<String, String> channelValues = getJSONValues(
				jSONObjectChannel.getJSONArray("data"), response.getNamespace(),
				id);

			ChannelInstance channelInstance =
				_channelInstanceLocalService.createChannelInstance(
					channelInstanceId);

			channelInstance.setChannelGuid(id);
			channelInstance.setChannelKey(type);
			channelInstance.setValues(channelValues);

			channelInstances.add(channelInstance);
		}

		return channelInstances;
	}

	protected InvalidChannelsException getInvalidChannelsException(
		PortletRequest portletRequest) {

		if (SessionErrors.contains(
				portletRequest, InvalidChannelsException.class.getName())) {

			return (InvalidChannelsException)SessionErrors.get(
				portletRequest, InvalidChannelsException.class.getName());
		}
		else {
			return new InvalidChannelsException();
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
				name, new String[]{namespace, id},
				new String[]{StringPool.BLANK, StringPool.BLANK});

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

			ruleInstance.setRuleGuid(id);
			ruleInstance.setRuleKey(type);
			ruleInstance.setValues(ruleValues);

			ruleInstances.add(ruleInstance);
		}

		return ruleInstances;
	}

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template,
			TemplateHashModel staticModels)
		throws Exception {

		String redirect = ParamUtil.getString(portletRequest, "redirect");
		String backURL = ParamUtil.getString(
			portletRequest, "backURL", redirect);

		template.put("redirect", redirect);
		template.put("backURL", backURL);

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Group scopeGroup = themeDisplay.getScopeGroup();

		template.put("scopeGroup", scopeGroup);

		long scopeGroupId = themeDisplay.getScopeGroupId();

		PermissionChecker permissionChecker = (PermissionChecker)template.get(
			"permissionChecker");

		if (Validator.isNull(path) || path.equals(ContentTargetingPath.VIEW) ||
			path.equals(ContentTargetingPath.VIEW_CAMPAIGNS_RESOURCES) ||
			path.equals(ContentTargetingPath.VIEW_USER_SEGMENTS_RESOURCES)) {

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

			String campaignKeywords = ParamUtil.getString(
				portletRequest, "campaignKeywords");

			String userSegmentKeywords = ParamUtil.getString(
				portletRequest, "userSegmentKeywords");

			template.put(
				"campaignSearchContainerIterator",
				new CampaignSearchContainerIterator(
					scopeGroupId, campaignKeywords));
			template.put(
				"userSegmentSearchContainerIterator",
				new UserSegmentSearchContainerIterator(
					scopeGroupId, userSegmentKeywords));
			template.put(
				"usedUserSegments",
				SessionMessages.get(portletRequest, "usedUserSegments"));

			Map<String, Channel> channels = _channelsRegistry.getChannels();
			Map<String, Report> reports = _reportsRegistry.getReports();

			template.put("channelsCount", channels.size());
			template.put("reportsCount", reports.size());
		}
		else if (path.equals(ContentTargetingPath.EDIT_CAMPAIGN) ||
				 path.equals(ContentTargetingPath.EDIT_TACTIC) ||
				 path.equals(ContentTargetingPath.VIEW_TACTICS_RESOURCES)) {

			long campaignId = ParamUtil.getLong(portletRequest, "campaignId");

			template.put("campaignId", campaignId);
			template.put("className", Campaign.class.getName());
			template.put("classPK", campaignId);
			template.put(
				"tabs2",
				ParamUtil.getString(portletRequest, "tabs2", "details"));

			Calendar endDate = Calendar.getInstance();
			int priority = 1;
			Calendar startDate = Calendar.getInstance();
			String userSegmentAssetCategoryIdsAsString = StringPool.BLANK;
			String userSegmentAssetCategoryNames = StringPool.BLANK;
			String timeZoneId = StringPool.BLANK;
			List<UserSegment> campaignUserSegments = null;

			Campaign campaign = null;

			if (campaignId > 0) {
				campaign = _campaignLocalService.getCampaign(campaignId);

				template.put("campaign", campaign);

				startDate = Calendar.getInstance(
					TimeZone.getTimeZone(campaign.getTimeZoneId()));
				endDate = Calendar.getInstance(
					TimeZone.getTimeZone(campaign.getTimeZoneId()));

				endDate.setTime(campaign.getEndDate());
				startDate.setTime(campaign.getStartDate());

				timeZoneId = campaign.getTimeZoneId();

				if (Validator.isBlank(timeZoneId)) {
					timeZoneId = themeDisplay.getTimeZone().getID();
				}

				campaignUserSegments =
					_userSegmentLocalService.getCampaignUserSegments(
						campaignId);

				long[] userSegmentAssetCategoryIds =
					ContentTargetingUtil.getAssetCategoryIds(
						campaignUserSegments);

				userSegmentAssetCategoryIdsAsString = StringUtil.merge(
					userSegmentAssetCategoryIds);

				userSegmentAssetCategoryNames =
					ContentTargetingUtil.getAssetCategoryNames(
						userSegmentAssetCategoryIds, themeDisplay.getLocale());
			}
			else {
				Date now = new Date();

				endDate.setTime(now);
				endDate.add(Calendar.YEAR, 1);

				startDate.setTime(now);

				timeZoneId = themeDisplay.getTimeZone().getID();
			}

			template.put(
				"campaignUserSegmentsIds", userSegmentAssetCategoryIdsAsString);
			template.put("endDate", endDate);
			template.put("priority", priority);
			template.put("startDate", startDate);
			template.put("timeZoneId", timeZoneId);
			template.put(
				"userSegmentAssetCategoryIdsAsString",
				userSegmentAssetCategoryIdsAsString);
			template.put(
				"userSegmentAssetCategoryNames", userSegmentAssetCategoryNames);

			long[] groupIds =
				ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
					scopeGroupId);

			List<UserSegment> userSegments =
				_userSegmentService.getUserSegments(groupIds);

			template.put("userSegments", userSegments);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

			long[] vocabularyGroupIds = new long[1];
			long[] vocabularyIds = new long[1];

			if (themeDisplay.getScopeGroupId() ==
					themeDisplay.getCompanyGroupId()) {

				vocabularyGroupIds[0] = themeDisplay.getCompanyGroupId();

				vocabularyIds[0] = UserSegmentUtil.getAssetVocabularyId(
					themeDisplay.getUserId(), serviceContext);
			}
			else {
				vocabularyGroupIds =
					ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
						themeDisplay.getSiteGroupId());
				vocabularyIds = UserSegmentUtil.getAssetVocabularyIds(
					vocabularyGroupIds);
			}

			template.put(
				"vocabularyGroupIds", StringUtil.merge(vocabularyGroupIds));
			template.put("vocabularyIds", StringUtil.merge(vocabularyIds));

			if (path.equals(ContentTargetingPath.EDIT_CAMPAIGN) &&
				(campaignId > 0)) {

				// Tactics

				if (CampaignPermission.contains(
						permissionChecker, scopeGroupId, scopeGroupId,
					ActionKeys.DELETE)) {

					template.put(
						"tacticsRowChecker", new RowChecker(portletResponse));
				}

				String keywords = ParamUtil.getString(
					portletRequest, "tacticKeywords");

				template.put(
					"tacticSearchContainerIterator",
					new TacticSearchContainerIterator(
						campaignId, scopeGroupId, keywords));

				// Reports

				Map<String, Report> reports = _reportsRegistry.getReports(
					Campaign.class.getName());

				template.put("reports",reports.values());
				template.put(
					"reportsRowChecker",
					new ReportInstanceRowChecker(
						portletRequest, portletResponse));

				String reportKeywords = ParamUtil.getString(
					portletRequest, "reportKeywords");

				template.put(
					"reportSearchContainerIterator",
					new ReportSearchContainerIterator(
						themeDisplay.getScopeGroupId(), reportKeywords,
						Campaign.class.getName(), campaignId));

				for (Report report : reports.values()) {
					if (report.isInstantiable()) {
						continue;
					}

					if (_reportInstanceLocalService.getReportInstanceCount(
							report.getReportKey(), Campaign.class.getName(),
							campaignId)
						> 0) {

						continue;
					}

					_reportInstanceLocalService.addReportInstance(
						themeDisplay.getUserId(), report.getReportKey(),
						Campaign.class.getName(), campaignId, StringPool.BLANK,
						serviceContext);
				}
			}
			else if (path.equals(ContentTargetingPath.EDIT_TACTIC)) {
				long tacticId = ParamUtil.getLong(portletRequest, "tacticId");

				template.put("tacticId", tacticId);

				Tactic tactic = null;

				if (tacticId > 0) {
					tactic = _tacticLocalService.getTactic(tacticId);

					template.put("tactic", tactic);

					List<UserSegment> tacticUserSegments =
						_userSegmentLocalService.getTacticUserSegments(
							tacticId);

					long[] userSegmentAssetCategoryIds =
						ContentTargetingUtil.getAssetCategoryIds(
							tacticUserSegments);

					template.put(
						"userSegmentAssetCategoryIdsAsString",
						StringUtil.merge(userSegmentAssetCategoryIds));
					template.put(
						"userSegmentAssetCategoryNames",
						ContentTargetingUtil.getAssetCategoryNames(
							userSegmentAssetCategoryIds,
							themeDisplay.getLocale()));
				}

				boolean isolated = themeDisplay.isIsolated();

				try {
					themeDisplay.setIsolated(true);

					Map<String, Channel> channels =
						_channelsRegistry.getChannels();

					template.put("channels", channels.values());

					List<ChannelInstance> channelInstances =
						getChannelsFromRequest(portletRequest, portletResponse);

					if (channelInstances.isEmpty() && (tacticId > 0)) {
						channelInstances =
							_channelInstanceLocalService.getChannelInstances(
								tacticId);
					}

					List<ChannelTemplate> addedChannelTemplates =
						new ArrayList<ChannelTemplate>();

					if (!channelInstances.isEmpty()) {
						template.put("channelInstances", channelInstances);

						InvalidChannelsException ice =
							getInvalidChannelsException(portletRequest);

						for (ChannelInstance channelInstance :
								channelInstances) {

							Channel channel =
								_channelsRegistry.getChannel(
									channelInstance.getChannelKey());

							if (channel == null) {
								continue;
							}

							ChannelTemplate channelTemplate =
								new ChannelTemplate();

							if (channelInstance.getChannelInstanceId() > 0) {
								channelTemplate.setInstanceId(
									String.valueOf(
										channelInstance.
											getChannelInstanceId()));
							}
							else {
								channelTemplate.setInstanceId(
									channelInstance.getChannelGuid());
							}

							channelTemplate.setChannel(channel);

							String html = getChannelHtml(
								channel, channelInstance, template,
								channelInstance.getValues(),
								ice.getExceptions(
									channelInstance.getChannelGuid()));

							channelTemplate.setTemplate(
								HtmlUtil.escapeAttribute(html));

							addedChannelTemplates.add(channelTemplate);
						}
					}

					template.put(
						"addedChannelTemplates", addedChannelTemplates);

					List<ChannelTemplate> channelTemplates =
						new ArrayList<ChannelTemplate>();

					for (Channel channel : channels.values()) {
						if (!channel.isVisible()) {
							continue;
						}

						ChannelTemplate channelTemplate = new ChannelTemplate();

						channelTemplate.setChannel(channel);

						String html = getChannelHtml(
							channel, null, template, null, null);

						channelTemplate.setTemplate(
							HtmlUtil.escapeAttribute(html));

						channelTemplates.add(channelTemplate);
					}

					template.put("channelTemplates", channelTemplates);
				}
				finally {
					themeDisplay.setIsolated(isolated);
				}

				if (campaignUserSegments != null) {
					template.put("userSegments", campaignUserSegments);
				}

				template.put("channelsRegistry", _channelsRegistry);

				if (campaign != null) {
					BreadcrumbUtil.addPortletBreadcrumbEntries(
						request, (RenderResponse)portletResponse, campaign,
						"promotions");

					if (tactic != null) {
						BreadcrumbUtil.addPortletBreadcrumbEntries(
							request, (RenderResponse)portletResponse, tactic);
					}
				}
			}

			if (Validator.isNull(backURL) &&
				(path.equals(ContentTargetingPath.EDIT_CAMPAIGN) ||
				 path.equals(ContentTargetingPath.EDIT_TACTIC))) {

				PortletURL portletURL =
						((RenderResponse)portletResponse).createRenderURL();

				portletURL.setParameter("mvcPath", ContentTargetingPath.VIEW);
				portletURL.setParameter("tabs1", "campaigns");

				template.put("backURL", portletURL.toString());
			}
		}
		else if (path.equals(ContentTargetingPath.EDIT_USER_SEGMENT)) {
			long userSegmentId = ParamUtil.getLong(
				portletRequest, "userSegmentId");

			template.put("className", UserSegment.class.getName());
			template.put("classPK", userSegmentId);
			template.put(
				"tabs2",
				ParamUtil.getString(portletRequest, "tabs2", "details"));
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

						if (rule == null) {
							continue;
						}

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

				List<RuleTemplate> ruleTemplates =
					new ArrayList<RuleTemplate>();

				for (Rule rule : rules.values()) {
					if (!rule.isVisible()) {
						continue;
					}

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

			if (userSegmentId > 0) {
				UserSegment userSegment =
					_userSegmentLocalService.getUserSegment(userSegmentId);

				template.put("userSegment", userSegment);

				// Reports

				Map<String, Report> reports = _reportsRegistry.getReports(
					UserSegment.class.getName());

				template.put("reports", reports.values());

				String reportKeywords = ParamUtil.getString(
					portletRequest, "reportKeywords");

				template.put(
					"reportSearchContainerIterator",
					new ReportSearchContainerIterator(
						themeDisplay.getScopeGroupId(), reportKeywords,
						UserSegment.class.getName(), userSegmentId));

				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(request);

				for (Report report : reports.values()) {
					if (report.isInstantiable()) {
						continue;
					}

					if (_reportInstanceLocalService.getReportInstanceCount(
							report.getReportKey(), UserSegment.class.getName(),
							userSegmentId)
						> 0) {

						continue;
					}

					_reportInstanceLocalService.addReportInstance(
						themeDisplay.getUserId(), report.getReportKey(),
						UserSegment.class.getName(), userSegmentId,
						StringPool.BLANK, serviceContext);
				}
			}
		}
		else if (path.equals(ContentTargetingPath.EDIT_REPORT) ||
				 path.equals(ContentTargetingPath.VIEW_REPORT) ||
				 path.equals(ContentTargetingPath.VIEW_REPORTS) ||
				 path.equals(ContentTargetingPath.VIEW_REPORTS_RESOURCES)) {

			String className = ParamUtil.getString(portletRequest, "className");
			long classPK = ParamUtil.getLong(portletRequest, "classPK");

			template.put("className", className);
			template.put("reportInstanceService", _reportInstanceService);

			String name = StringPool.BLANK;

			if (className.equals(Campaign.class.getName())) {
				Campaign campaign = _campaignLocalService.getCampaign(classPK);

				name = campaign.getName(themeDisplay.getLocale());

				BreadcrumbUtil.addPortletBreadcrumbEntries(
					request, (RenderResponse)portletResponse, campaign,
					"reports");

				classPK = _getCampaignClassPK(campaign, scopeGroup);
			}
			else if (className.equals(UserSegment.class.getName())) {
				UserSegment userSegment =
					_userSegmentLocalService.getUserSegment(classPK);

				name = userSegment.getName(themeDisplay.getLocale());

				BreadcrumbUtil.addPortletBreadcrumbEntries(
					request, (RenderResponse)portletResponse, userSegment);

				classPK = _getUserSegmentClassPK(userSegment, scopeGroup);
			}

			template.put("classPK", classPK);

			if (path.equals(ContentTargetingPath.EDIT_REPORT) ||
				path.equals(ContentTargetingPath.VIEW_REPORT)) {

				template.put("name", name);

				long reportInstanceId = ParamUtil.getLong(
					portletRequest, "reportInstanceId");
				String reportKey = ParamUtil.getString(
					portletRequest, "reportKey");

				Report report = _reportsRegistry.getReport(reportKey);

				ReportInstance reportInstance =
					_reportInstanceService.fetchReportInstance(
						reportInstanceId);

				template.put("report", report);
				template.put("reportInstance", reportInstance);
				template.put("reportInstanceId", reportInstanceId);
				template.put("reportKey", reportKey);

				BreadcrumbUtil.addPortletBreadcrumbEntries(
					request, (RenderResponse)portletResponse, report);

				if (path.equals(ContentTargetingPath.EDIT_REPORT)) {
					template.put(
						"reportEditHtml",
						report.getEditHTML(
							reportInstance, cloneTemplateContext(template)));
				}
				else if (path.equals(ContentTargetingPath.VIEW_REPORT)) {
					template.put(
						"reportHtml",
						report.getHTML(
							reportInstance, cloneTemplateContext(template)));
				}

				if (Validator.isNull(backURL)) {
					PortletURL portletURL =
						((RenderResponse)portletResponse).createRenderURL();

					if (className.equals(Campaign.class.getName())) {
						portletURL.setParameter(
							"mvcPath", ContentTargetingPath.EDIT_CAMPAIGN);
						portletURL.setParameter(
							"campaignId", String.valueOf(classPK));
						portletURL.setParameter("tabs2", "reports");
					}
					else {
						portletURL.setParameter(
							"mvcPath", ContentTargetingPath.EDIT_USER_SEGMENT);
						portletURL.setParameter(
							"userSegmentId", String.valueOf(classPK));
					}

					portletURL.setParameter("className", className);
					portletURL.setParameter("classPK", String.valueOf(classPK));

					template.put("backURL", portletURL.toString());
				}
			}
			else if (path.equals(ContentTargetingPath.VIEW_REPORTS) ||
					 path.equals(ContentTargetingPath.VIEW_REPORTS_RESOURCES)) {

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

				Map<String, Report> reports = _reportsRegistry.getReports(
					className);

				template.put("reports", reports.values());
				template.put(
					"reportsRowChecker",
					new ReportInstanceRowChecker(
						portletRequest, portletResponse));

				String reportKeywords = ParamUtil.getString(
					portletRequest, "reportKeywords");

				template.put(
					"reportSearchContainerIterator",
					new ReportSearchContainerIterator(
						themeDisplay.getScopeGroupId(), reportKeywords,
						className, classPK));

				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(request);

				for (Report report : reports.values()) {
					if (report.isInstantiable()) {
						continue;
					}

					if (_reportInstanceLocalService.getReportInstanceCount(
							report.getReportKey(), className, classPK)
						> 0) {

						continue;
					}

					_reportInstanceLocalService.addReportInstance(
						themeDisplay.getUserId(), report.getReportKey(),
						className, classPK, StringPool.BLANK, serviceContext);
				}
			}
		}
	}

	protected List<InvalidChannelException> updateChannels(
			long tacticId, long campaignId, PortletRequest request,
			PortletResponse response)
		throws Exception {

		List<ChannelInstance> requestChannelInstances = getChannelsFromRequest(
			request, response);

		List<ChannelInstance> channelInstances = ListUtil.copy(
			_channelInstanceService.getChannelInstances(campaignId, tacticId));

		List<InvalidChannelException> channelExceptions =
			new ArrayList<InvalidChannelException>();

		if (requestChannelInstances.isEmpty()) {
			deleteChannelInstances(channelInstances);

			return channelExceptions;
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ChannelInstance.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		for (ChannelInstance requestChannelInstance : requestChannelInstances) {
			Channel channel =
				_channelsRegistry.getChannel(
					requestChannelInstance.getChannelKey());

			if (channel == null) {
				continue;
			}

			String typeSettings = null;

			Map<String, String> channelValues =
				requestChannelInstance.getValues();
			channelValues.put("tacticId", String.valueOf(tacticId));

			try {
				typeSettings = channel.processChannel(
					request, response, requestChannelInstance.getChannelGuid(),
					channelValues);
			}
			catch (InvalidChannelException ice) {
				channelExceptions.add(ice);
			}
			catch (Exception e) {
				channelExceptions.add(
					new InvalidChannelException(e.getMessage()));
			}

			String alias = channelValues.get("alias");

			long channelInstanceId =
				requestChannelInstance.getChannelInstanceId();

			try {
				if (channelInstanceId > 0) {
					ChannelInstance channelInstance =
						_channelInstanceService.updateChannelInstance(
							channelInstanceId, alias, typeSettings,
							serviceContext);

					channelInstances.remove(channelInstance);
				}
				else {
					_channelInstanceService.addChannelInstance(
						themeDisplay.getUserId(), tacticId,
						requestChannelInstance.getChannelKey(), campaignId,
						alias, typeSettings, serviceContext);
				}
			}
			catch (DuplicateChannelInstanceException dcie) {
				InvalidChannelException ice = new InvalidChannelException(
					"please-use-a-unique-alias");

				ice.setChannelGuid(requestChannelInstance.getChannelGuid());

				channelExceptions.add(ice);
			}
			catch (PortalException pe) {
				_log.error("Cannot update channel", pe);
			}
		}

		deleteChannelInstances(channelInstances);

		return channelExceptions;
	}

	protected void updateReportElements(
			ReportInstance reportInstance, PortletRequest request,
			PortletResponse response)
		throws InvalidReportException {

		Report report = _reportsRegistry.getReport(
			reportInstance.getReportKey());

		try {
			String typeSettings = report.processEditReport(
				request, response, reportInstance);

			reportInstance.setTypeSettings(typeSettings);

			_reportInstanceService.updateReportInstance(reportInstance);
		}
		catch (Exception e) {
			throw new InvalidReportException(e);
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
			request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		for (RuleInstance requestRuleInstance : requestRuleInstances) {
			Rule rule = _rulesRegistry.getRule(
				requestRuleInstance.getRuleKey());

			if (rule == null) {
				continue;
			}

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

	private void _checkServices()
		throws SystemException, UnavailableServiceException {

		try {
			_analyticsEventLocalService.getAnalyticsEvents(0, 1);
			_anonymousUserLocalService.getAnonymousUsers(0, 1);
			_campaignLocalService.getCampaigns(0, 1);
		}
		catch (Exception e) {
			throw new UnavailableServiceException();
		}
	}

	private long _getCampaignClassPK(Campaign campaign, Group scopeGroup)
		throws Exception {

		if (!scopeGroup.isStagingGroup()) {
			return campaign.getCampaignId();
		}

		Campaign liveCampaign =
			_campaignLocalService.fetchCampaignByUuidAndGroupId(
				campaign.getUuid(), scopeGroup.getLiveGroupId());

		if (liveCampaign != null) {
			return liveCampaign.getCampaignId();
		}
		else {
			return 0;
		}
	}

	private Date _getDate(
		PortletRequest portletRequest, String paramPrefix, String timeZoneId) {

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
			TimeZone.getTimeZone(timeZoneId), themeDisplay.getLocale());

		calendar.set(Calendar.MONTH, dateMonth);
		calendar.set(Calendar.DATE, dateDay);
		calendar.set(Calendar.YEAR, dateYear);
		calendar.set(Calendar.HOUR_OF_DAY, dateHour);
		calendar.set(Calendar.MINUTE, dateMinute);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	private long _getUserSegmentClassPK(
			UserSegment userSegment, Group scopeGroup)
		throws Exception {

		if (!scopeGroup.isStagingGroup()) {
			return userSegment.getUserSegmentId();
		}

		UserSegment liveUserSegment =
			_userSegmentLocalService.fetchUserSegmentByUuidAndGroupId(
				userSegment.getUuid(), scopeGroup.getLiveGroupId());

		if (liveUserSegment != null) {
			return liveUserSegment.getUserSegmentId();
		}
		else {
			return 0;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ContentTargetingPortlet.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private AnonymousUserLocalService _anonymousUserLocalService;
	private CampaignLocalService _campaignLocalService;
	private CampaignService _campaignService;
	private ChannelInstanceLocalService _channelInstanceLocalService;
	private ChannelInstanceService _channelInstanceService;
	private ChannelsRegistry _channelsRegistry;
	private ReportInstanceLocalService _reportInstanceLocalService;
	private ReportInstanceService _reportInstanceService;
	private ReportsRegistry _reportsRegistry;
	private RuleCategoriesRegistry _ruleCategoriesRegistry;
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RuleInstanceService _ruleInstanceService;
	private RulesRegistry _rulesRegistry;
	private TacticLocalService _tacticLocalService;
	private TacticService _tacticService;
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
			String timeZoneId, int priority, boolean active,
			long[] userSegmentIds, ServiceContext serviceContext) {

			_portletRequest = portletRequest;
			_portletResponse = portletResponse;
			_userId = userId;
			_campaignId = campaignId;
			_nameMap = nameMap;
			_descriptionMap = descriptionMap;
			_startDate = startDate;
			_endDate = endDate;
			_timeZoneId = timeZoneId;
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
					_endDate, _timeZoneId, _priority, _active, _userSegmentIds,
					_serviceContext);
			}
			else {
				campaign = _campaignService.addCampaign(
					_userId, _nameMap, _descriptionMap, _startDate, _endDate,
					_timeZoneId, _priority, _active, _userSegmentIds,
					_serviceContext);
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
		private String _timeZoneId;
		private int _priority;
		private boolean _active;
		private long[] _userSegmentIds;
		private ServiceContext _serviceContext;

	}

	private class ReportInstanceCallable implements Callable<ReportInstance> {

		private ReportInstanceCallable(
			PortletRequest portletRequest, PortletResponse portletResponse,
			long userId, long reportInstanceId, String reportKey,
			String className, long classPK, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext) {

			_portletRequest = portletRequest;
			_portletResponse = portletResponse;
			_userId = userId;
			_reportInstanceId = reportInstanceId;
			_reportKey = reportKey;
			_className = className;
			_classPK = classPK;
			_nameMap = nameMap;
			_descriptionMap = descriptionMap;
			_serviceContext = serviceContext;
		}

		@Override
		public ReportInstance call() throws Exception {
			ReportInstance reportInstance = null;

			if (_reportInstanceId > 0) {
				reportInstance = _reportInstanceService.updateReportInstance(
					_reportInstanceId, _userId, _reportKey, _className,
					_classPK, _nameMap, _descriptionMap, "", _serviceContext);
			}
			else {
				reportInstance = _reportInstanceService.addReportInstance(
					_userId, _reportKey, _className, _classPK, _nameMap,
					_descriptionMap, "", _serviceContext);
			}

			updateReportElements(
				reportInstance, _portletRequest, _portletResponse);

			return reportInstance;
		}

		private PortletRequest _portletRequest;
		private PortletResponse _portletResponse;
		private long _userId;
		private long _reportInstanceId;
		private String _reportKey;
		private String _className;
		private long _classPK;
		private Map<Locale, String> _nameMap;
		private Map<Locale, String> _descriptionMap;
		private ServiceContext _serviceContext;

	}

	private class TacticCallable implements Callable<Tactic> {

		private TacticCallable(
			PortletRequest portletRequest, PortletResponse portletResponse,
			long userId, long tacticId, long campaignId,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			long[] userSegmentIds, ServiceContext serviceContext) {

			_portletRequest = portletRequest;
			_portletResponse = portletResponse;
			_userId = userId;
			_campaignId = campaignId;
			_tacticId = tacticId;
			_nameMap = nameMap;
			_descriptionMap = descriptionMap;
			_userSegmentIds = userSegmentIds;
			_serviceContext = serviceContext;
		}

		@Override
		public Tactic call() throws Exception {
			Tactic tactic = null;

			if (_tacticId > 0) {
				tactic = _tacticService.updateTactic(
					_tacticId, _campaignId, _nameMap, _descriptionMap,
					_userSegmentIds, _serviceContext);
			}
			else {
				tactic = _tacticService.addTactic(
					_userId, _campaignId, _nameMap, _descriptionMap,
					_userSegmentIds, _serviceContext);
			}

			List<InvalidChannelException> channelExceptions =
				updateChannels(
					tactic.getTacticId(), _campaignId, _portletRequest,
					_portletResponse);

			if (!channelExceptions.isEmpty()) {
				throw new InvalidChannelsException(channelExceptions);
			}

			return tactic;
		}

		private PortletRequest _portletRequest;
		private PortletResponse _portletResponse;
		private long _userId;
		private long _campaignId;
		private long _tacticId;
		private Map<Locale, String> _nameMap;
		private Map<Locale, String> _descriptionMap;
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