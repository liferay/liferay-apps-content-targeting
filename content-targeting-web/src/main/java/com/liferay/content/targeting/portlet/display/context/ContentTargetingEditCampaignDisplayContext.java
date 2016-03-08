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
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Calendar;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingEditCampaignDisplayContext {

	public ContentTargetingEditCampaignDisplayContext(
		RenderResponse renderResponse, PortletConfig portletConfig,
		HttpServletRequest request) {

		_renderResponse = renderResponse;
		_portletConfig = portletConfig;
		_request = request;
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(_request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = _renderResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);
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

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Campaign campaign = getCampaign();

		if (campaign != null) {
			_campaignTitle = campaign.getName(themeDisplay.getLocale());
		}
		else {
			_campaignTitle = LanguageUtil.get(
				_portletConfig.getResourceBundle(themeDisplay.getLocale()),
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

		_userSegmentAssetCategoryIdsAsString = GetterUtil.getString(
			_request.getAttribute("userSegmentAssetCategoryIdsAsString"));

		return _userSegmentAssetCategoryIdsAsString;
	}

	public String getUserSegmentAssetCategoryNames() {
		if (Validator.isNotNull(_userSegmentAssetCategoryNames)) {
			return _userSegmentAssetCategoryNames;
		}

		_userSegmentAssetCategoryNames = GetterUtil.getString(
			_request.getAttribute("userSegmentAssetCategoryNames"));

		return _userSegmentAssetCategoryNames;
	}

	public String getVocabularyGroupIds() {
		if (Validator.isNotNull(_vocabularyGroupIds)) {
			return _vocabularyGroupIds;
		}

		_vocabularyGroupIds = GetterUtil.getString(
			_request.getAttribute("vocabularyGroupIds"));

		return _vocabularyGroupIds;
	}

	public String getVocabularyIds() {
		if (Validator.isNotNull(_vocabularyIds)) {
			return _vocabularyIds;
		}

		_vocabularyIds = GetterUtil.getString(
			_request.getAttribute("vocabularyIds"));

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
	private final PortletConfig _portletConfig;
	private Integer _priority;
	private String _redirect;
	private final RenderResponse _renderResponse;
	private final HttpServletRequest _request;
	private Calendar _startDate;
	private String _timeZoneId;
	private String _userSegmentAssetCategoryIdsAsString;
	private String _userSegmentAssetCategoryNames;
	private String _vocabularyGroupIds;
	private String _vocabularyIds;

}