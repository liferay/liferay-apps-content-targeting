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

import com.liferay.content.targeting.exception.InvalidDateRangeException;
import com.liferay.content.targeting.exception.InvalidNameException;
import com.liferay.content.targeting.exception.InvalidTrackingActionsException;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.CampaignService;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.TransactionInvokerUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.UPDATE_CAMPAIGN
	},
	service = MVCActionCommand.class
)
public class UpdateCampaignMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long campaignId = ParamUtil.getLong(request, "campaignId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			request, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(request, "description");

		String timeZoneId = ParamUtil.getString(request, "timeZoneId");

		Date startDate = getDate(request, "startDate", timeZoneId);
		Date endDate = getDate(request, "endDate", timeZoneId);

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
			Callable<Campaign> campaignCallable = new CampaignCallable(
				request, response, themeDisplay.getUserId(), campaignId,
				nameMap, descriptionMap, startDate, endDate, timeZoneId,
				priority, active, userSegmentIds, serviceContext);

			Campaign campaign = TransactionInvokerUtil.invoke(
				_transactionConfig, campaignCallable);

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

			SessionErrors.add(request, e.getClass(), e);

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

	@Reference(unbind = "unsetCampaignService")
	protected void setCampaignService(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	protected void unsetCampaignService() {
		_campaignService = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UpdateCampaignMVCActionCommand.class);

	private CampaignService _campaignService;

	private class CampaignCallable implements Callable<Campaign> {

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

		private final boolean _active;
		private final long _campaignId;
		private final Map<Locale, String> _descriptionMap;
		private final Date _endDate;
		private final Map<Locale, String> _nameMap;
		private final PortletRequest _portletRequest;
		private final PortletResponse _portletResponse;
		private final int _priority;
		private final ServiceContext _serviceContext;
		private final Date _startDate;
		private final String _timeZoneId;
		private final long _userId;
		private final long[] _userSegmentIds;

	}

}