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

package com.liferay.content.targeting.web.display.context;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Calendar;
import java.util.List;

import javax.portlet.PortletConfig;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class BaseContentTargetingCampaignDisplayContext {

	public BaseContentTargetingCampaignDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		UserSegmentLocalService userSegmentLocalService) {

		this.liferayPortletRequest = liferayPortletRequest;
		this.liferayPortletResponse = liferayPortletResponse;

		_userSegmentLocalService = userSegmentLocalService;

		request = PortalUtil.getHttpServletRequest(this.liferayPortletRequest);

		themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public Campaign getCampaign() {
		if (_campaign != null) {
			return _campaign;
		}

		long campaignId = getCampaignId();

		if (campaignId > 0) {
			_campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);
		}

		return _campaign;
	}

	public long getCampaignId() {
		if (_campaignId != null) {
			return _campaignId;
		}

		_campaignId = ParamUtil.getLong(request, "campaignId", 0);

		return _campaignId;
	}

	public String getCampaignTitle() {
		if (Validator.isNotNull(_campaignTitle)) {
			return _campaignTitle;
		}

		Campaign campaign = getCampaign();

		if (campaign != null) {
			_campaignTitle = campaign.getName(themeDisplay.getLocale());
		}
		else {
			PortletConfig portletConfig =
				(PortletConfig)liferayPortletRequest.getAttribute(
					JavaConstants.JAVAX_PORTLET_CONFIG);

			_campaignTitle = LanguageUtil.get(
				portletConfig.getResourceBundle(themeDisplay.getLocale()),
				"new-campaign");
		}

		return _campaignTitle;
	}

	public String getDescription() {
		if (Validator.isNotNull(_description)) {
			return _description;
		}

		_description = StringPool.BLANK;

		Campaign campaign = getCampaign();

		if (campaign != null) {
			_description = campaign.getDescription(themeDisplay.getLocale());
		}

		return _description;
	}

	public Calendar getEndDate() {
		if (_endDate != null) {
			return _endDate;
		}

		Campaign campaign = getCampaign();

		Calendar endDate = Calendar.getInstance();

		if (campaign != null) {
			endDate.setTime(campaign.getEndDate());
		}
		else {
			endDate.add(Calendar.YEAR, 1);
		}

		_endDate = endDate;

		return _endDate;
	}

	public Integer getPriority() {
		if (_priority != null) {
			return _priority;
		}

		_priority = 1;

		Campaign campaign = getCampaign();

		if (campaign != null) {
			_priority = campaign.getPriority();
		}

		return _priority;
	}

	public Calendar getStartDate() {
		if (_startDate != null) {
			return _startDate;
		}

		Campaign campaign = getCampaign();

		Calendar startDate = Calendar.getInstance();

		if (campaign != null) {
			startDate.setTime(campaign.getEndDate());
		}

		_startDate = startDate;

		return _startDate;
	}

	public String getStatus() {
		if (Validator.isNotNull(_status)) {
			return _status;
		}

		_status = StringPool.BLANK;

		Campaign campaign = getCampaign();

		if (campaign != null) {
			_status = campaign.getStatus();
		}

		return _status;
	}

	public String getTimeZoneId() {
		if (Validator.isNotNull(_timeZoneId)) {
			return _timeZoneId;
		}

		_timeZoneId = TimeZoneUtil.getDefault().getID();

		Campaign campaign = getCampaign();

		if (campaign != null) {
			_timeZoneId = campaign.getTimeZoneId();
		}

		return _timeZoneId;
	}

	public String getUserSegmentAssetCategoryIdsAsString() {
		if (Validator.isNotNull(_userSegmentAssetCategoryIdsAsString)) {
			return _userSegmentAssetCategoryIdsAsString;
		}

		String userSegmentAssetCategoryIdsAsString = StringPool.BLANK;

		long campaignId = getCampaignId();

		if (campaignId > 0) {
			List<UserSegment> campaignUserSegments = null;

			campaignUserSegments =
				_userSegmentLocalService.getCampaignUserSegments(campaignId);

			long[] userSegmentAssetCategoryIds =
				ContentTargetingUtil.getAssetCategoryIds(campaignUserSegments);

			userSegmentAssetCategoryIdsAsString = StringUtil.merge(
				userSegmentAssetCategoryIds);
		}

		_userSegmentAssetCategoryIdsAsString =
			userSegmentAssetCategoryIdsAsString;

		return _userSegmentAssetCategoryIdsAsString;
	}

	public String getUserSegmentAssetCategoryNames() {
		if (Validator.isNotNull(_userSegmentAssetCategoryNames)) {
			return _userSegmentAssetCategoryNames;
		}

		String userSegmentAssetCategoryNames = StringPool.BLANK;

		long campaignId = getCampaignId();

		if (campaignId > 0) {
			List<UserSegment> campaignUserSegments = null;

			campaignUserSegments =
				_userSegmentLocalService.getCampaignUserSegments(campaignId);

			long[] userSegmentAssetCategoryIds =
				ContentTargetingUtil.getAssetCategoryIds(campaignUserSegments);

			userSegmentAssetCategoryNames =
				ContentTargetingUtil.getAssetCategoryNames(
					userSegmentAssetCategoryIds, themeDisplay.getLocale());
		}

		_userSegmentAssetCategoryNames = userSegmentAssetCategoryNames;

		return _userSegmentAssetCategoryNames;
	}

	protected final LiferayPortletRequest liferayPortletRequest;
	protected final LiferayPortletResponse liferayPortletResponse;
	protected final HttpServletRequest request;
	protected final ThemeDisplay themeDisplay;

	private Campaign _campaign;
	private Long _campaignId;
	private String _campaignTitle;
	private String _description;
	private Calendar _endDate;
	private Integer _priority;
	private Calendar _startDate;
	private String _status;
	private String _timeZoneId;
	private String _userSegmentAssetCategoryIdsAsString;
	private String _userSegmentAssetCategoryNames;
	private final UserSegmentLocalService _userSegmentLocalService;

}