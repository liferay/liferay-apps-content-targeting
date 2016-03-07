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
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingViewTacticsDisplayContext {

	public ContentTargetingViewTacticsDisplayContext(
		LiferayPortletResponse liferayPortletResponse,
		RenderResponse renderResponse, HttpServletRequest request) {

		_liferayPortletResponse = liferayPortletResponse;
		_renderResponse = renderResponse;
		_request = request;
	}

	public String getBackURL() {
		if (Validator.isNotNull(_backURL)) {
			return _backURL;
		}

		String backURL = ParamUtil.getString(_request, "backURL");

		if (Validator.isNull(backURL)) {
			PortletURL backURLObject =
				_liferayPortletResponse.createRenderURL();

			backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);
			backURLObject.setParameter("tabs1", "campaigns");

			backURL = backURLObject.toString();
		}

		_backURL = backURL;

		return _backURL;
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

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (campaign != null) {
			_campaignTitle = campaign.getName(themeDisplay.getLocale());
		}

		return _campaignTitle;
	}

	public String getDisplayStyle() {
		if (Validator.isNotNull(_displayStyle)) {
			return _displayStyle;
		}

		_displayStyle = ParamUtil.getString(_request, "displayStyle", "list");

		return _displayStyle;
	}

	public String getKeywords() {
		if (Validator.isNotNull(_keywords)) {
			return _keywords;
		}

		_keywords = ParamUtil.getString(_request, "keywords");

		return _keywords;
	}

	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter(
			"mvcRenderCommandName", ContentTargetingMVCCommand.VIEW_TACTICS);
		portletURL.setParameter("className", Campaign.class.getName());
		portletURL.setParameter("classPK", String.valueOf(getCampaignId()));
		portletURL.setParameter("campaignId", String.valueOf(getCampaignId()));

		return portletURL;
	}

	public boolean hasUpdatePermission() {
		if (_hasUpdatePermission != null) {
			return _hasUpdatePermission;
		}

		Campaign campaign = getCampaign();

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (campaign != null) {
			_hasUpdatePermission = CampaignPermission.contains(
				themeDisplay.getPermissionChecker(), campaign,
				ActionKeys.UPDATE);
		}
		else {
			_hasUpdatePermission = false;
		}

		return _hasUpdatePermission;
	}

	private String _backURL;
	private Campaign _campaign;
	private Long _campaignId;
	private String _campaignTitle;
	private String _displayStyle;
	private Boolean _hasUpdatePermission;
	private String _keywords;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final RenderResponse _renderResponse;
	private final HttpServletRequest _request;

}