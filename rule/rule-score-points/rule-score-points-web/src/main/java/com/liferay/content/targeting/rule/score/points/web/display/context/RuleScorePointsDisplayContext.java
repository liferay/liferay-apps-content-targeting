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

package com.liferay.content.targeting.rule.score.points.web.display.context;

import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleScorePointsDisplayContext {

	public RuleScorePointsDisplayContext(HttpServletRequest request) {
		_request = request;

		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public String getPortalSettingsURL() {
		if (_portalSettingsURL != null) {
			return _portalSettingsURL;
		}

		_portalSettingsURL = GetterUtil.getString(
			_displayContext.get("portalSettingsURL"));

		return _portalSettingsURL;
	}

	public int getScorePoints() {
		if (_scorePoints != null) {
			return _scorePoints;
		}

		_scorePoints = GetterUtil.getInteger(
			_displayContext.get("scorePoints"));

		return _scorePoints;
	}

	public String getSiteSettingsURL() {
		if (_siteSettingsURL != null) {
			return _siteSettingsURL;
		}

		_siteSettingsURL = GetterUtil.getString(
			_displayContext.get("siteSettingsURL"));

		return _siteSettingsURL;
	}

	public UserSegment getUserSegment() {
		if (_userSegment != null) {
			return _userSegment;
		}

		_userSegment = (UserSegment)_displayContext.get("userSegment");

		return _userSegment;
	}

	public boolean isTrackingContentEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsContentEnabled(
			themeDisplay.getScopeGroupId());
	}

	public boolean isTrackingPageEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsPageEnabled(
			themeDisplay.getScopeGroupId());
	}

	private final Map<String, Object> _displayContext;
	private String _portalSettingsURL;
	private final HttpServletRequest _request;
	private Integer _scorePoints;
	private String _siteSettingsURL;
	private UserSegment _userSegment;

}