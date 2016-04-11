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

package com.liferay.content.targeting.web.portlet.action;

import com.liferay.content.targeting.exception.InvalidDateRangeException;
import com.liferay.content.targeting.exception.InvalidNameException;
import com.liferay.content.targeting.exception.InvalidTrackingActionsException;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.web.display.context.ContentTargetingEditCampaignDisplayContext;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
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
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long campaignId = ParamUtil.getLong(actionRequest, "campaignId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");

		String timeZoneId = ParamUtil.getString(actionRequest, "timeZoneId");

		Date startDate = getDate(actionRequest, "startDate", timeZoneId);
		Date endDate = getDate(actionRequest, "endDate", timeZoneId);

		int priority = ParamUtil.getInteger(actionRequest, "priority");

		boolean active = ParamUtil.getBoolean(actionRequest, "active");

		long[] userSegmentIds = null;
		long[] userSegmentAssetCategoryIds = ParamUtil.getLongValues(
			actionRequest, "userSegmentAssetCategoryIds");

		if (!ArrayUtil.isEmpty(userSegmentAssetCategoryIds)) {
			userSegmentIds = new long[userSegmentAssetCategoryIds.length];

			int userSegmentCount = 0;

			for (long userSegmentAssetCategoryId
					: userSegmentAssetCategoryIds) {

				UserSegment userSegment =
					_userSegmentLocalService.fetchUserSegmentByAssetCategoryId(
						userSegmentAssetCategoryId);

				userSegmentIds[userSegmentCount++] =
					userSegment.getUserSegmentId();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Campaign.class.getName(), actionRequest);

		try {
			Callable<Campaign> campaignCallable = new CampaignCallable(
				actionRequest, actionResponse, themeDisplay.getUserId(),
				campaignId, nameMap, descriptionMap, startDate, endDate,
				timeZoneId, priority, active, userSegmentIds, serviceContext);

			Campaign campaign = TransactionInvokerUtil.invoke(
				transactionConfig, campaignCallable);

			boolean saveAndContinue = ParamUtil.get(
				actionRequest, "saveAndContinue", false);

			if (saveAndContinue) {
				String redirect = ParamUtil.get(actionRequest, "redirect", "");

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					ContentTargetingMVCCommand.EDIT_CAMPAIGN);
				actionResponse.setRenderParameter(
					"campaignId", String.valueOf(campaign.getCampaignId()));
				actionResponse.setRenderParameter(
					"p_p_mode", PortletMode.VIEW.toString());
				actionResponse.setRenderParameter("redirect", redirect);

				addSuccessMessage(actionRequest, actionResponse);
			}
			else {
				sendRedirect(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			LiferayPortletRequest liferayPortletRequest =
				PortalUtil.getLiferayPortletRequest(actionRequest);
			LiferayPortletResponse liferayPortletResponse =
				PortalUtil.getLiferayPortletResponse(actionResponse);

			ContentTargetingEditCampaignDisplayContext
				contentTargetingEditCampaignDisplayContext =
					new ContentTargetingEditCampaignDisplayContext(
						liferayPortletRequest, liferayPortletResponse,
						_userSegmentLocalService);

			actionRequest.setAttribute(
				"contentTargetingEditCampaignDisplayContext",
				contentTargetingEditCampaignDisplayContext);

			SessionErrors.add(actionRequest, e.getClass(), e);

			if (e instanceof InvalidDateRangeException ||
				e instanceof InvalidNameException ||
				e instanceof InvalidTrackingActionsException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					actionRequest,
					PortalUtil.getPortletId(actionRequest) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					ContentTargetingMVCCommand.EDIT_CAMPAIGN);
			}
			else {
				actionResponse.setRenderParameter("mvcPath", "/error.jsp");
			}
		}
		catch (Throwable t) {
			_log.error(t);

			actionResponse.setRenderParameter("mvcPath", "/error.jsp");
		}
	}

	@Reference(unbind = "-")
	protected void setCampaignService(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UpdateCampaignMVCActionCommand.class);

	private CampaignService _campaignService;
	private UserSegmentLocalService _userSegmentLocalService;

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