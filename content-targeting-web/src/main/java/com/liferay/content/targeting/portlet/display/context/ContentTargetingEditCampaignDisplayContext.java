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

package com.liferay.content.targeting.portlet.display.context;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.ServiceContext;
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
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingEditCampaignDisplayContext {

	public ContentTargetingEditCampaignDisplayContext(
		LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
		UserSegmentLocalService userSegmentLocalService) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_userSegmentLocalService = userSegmentLocalService;

		_request = PortalUtil.getHttpServletRequest(_liferayPortletRequest);

		_themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(_request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = _liferayPortletResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", "/view.jsp");
		backURLObject.setParameter("tabs1", "campaigns");

		return backURLObject.toString();
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

		_campaignId = ParamUtil.getLong(_request, "campaignId", 0);

		return _campaignId;
	}

	public String getCampaignTitle() {
		if (Validator.isNotNull(_campaignTitle)) {
			return _campaignTitle;
		}

		Campaign campaign = getCampaign();

		if (campaign != null) {
			_campaignTitle = campaign.getName(_themeDisplay.getLocale());
		}
		else {
			PortletConfig portletConfig =
				(PortletConfig) _liferayPortletRequest.getAttribute(
					JavaConstants.JAVAX_PORTLET_CONFIG);

			_campaignTitle = LanguageUtil.get(
				portletConfig.getResourceBundle(_themeDisplay.getLocale()),
				"new-campaign");
		}

		return _campaignTitle;
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

	public String getRedirect() {
		if (Validator.isNotNull(_redirect)) {
			return _redirect;
		}

		_redirect = ParamUtil.getString(_request, "redirect");

		return _redirect;
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
					userSegmentAssetCategoryIds, _themeDisplay.getLocale());
		}

		_userSegmentAssetCategoryNames = userSegmentAssetCategoryNames;

		return _userSegmentAssetCategoryNames;
	}

	public String getVocabularyGroupIds() throws PortalException {
		if (Validator.isNotNull(_vocabularyGroupIds)) {
			return _vocabularyGroupIds;
		}

		long[] vocabularyGroupIds = new long[1];

		if (_themeDisplay.getScopeGroupId() ==
				_themeDisplay.getCompanyGroupId()) {

			vocabularyGroupIds[0] = _themeDisplay.getCompanyGroupId();
		}
		else {
			vocabularyGroupIds =
				ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
					_themeDisplay.getSiteGroupId());
		}

		_vocabularyGroupIds = StringUtil.merge(vocabularyGroupIds);

		return _vocabularyGroupIds;
	}

	public String getVocabularyIds() throws PortalException {
		if (Validator.isNotNull(_vocabularyIds)) {
			return _vocabularyIds;
		}

		long[] vocabularyIds = new long[1];

		if (_themeDisplay.getScopeGroupId() ==
				_themeDisplay.getCompanyGroupId()) {

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(_themeDisplay.getScopeGroupId());

			vocabularyIds[0] = UserSegmentUtil.getAssetVocabularyId(
				_themeDisplay.getUserId(), serviceContext);
		}
		else {
			long[] vocabularyGroupsIds = StringUtil.split(
				getVocabularyGroupIds(), 0L);

			vocabularyIds = UserSegmentUtil.getAssetVocabularyIds(
				vocabularyGroupsIds);
		}

		_vocabularyIds = StringUtil.merge(vocabularyIds);

		return _vocabularyIds;
	}

	public boolean isActiveCampaign() {
		Campaign campaign = getCampaign();

		if (campaign != null) {
			return campaign.isActive();
		}

		return true;
	}

	private Campaign _campaign;
	private Long _campaignId;
	private String _campaignTitle;
	private Calendar _endDate;
	private Integer _priority;
	private String _redirect;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final HttpServletRequest _request;
	private Calendar _startDate;
	private final ThemeDisplay _themeDisplay;
	private String _timeZoneId;
	private String _userSegmentAssetCategoryIdsAsString;
	private String _userSegmentAssetCategoryNames;
	private final UserSegmentLocalService _userSegmentLocalService;
	private String _vocabularyGroupIds;
	private String _vocabularyIds;

}