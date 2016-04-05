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
import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleScorePointsDisplayContext extends BaseRuleDisplayContext {

	public RuleScorePointsDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public String getPortalSettingsAnalyticsURL() {
		if (_portalSettingsAnalyticsURL != null) {
			return _portalSettingsAnalyticsURL;
		}

		_portalSettingsAnalyticsURL = StringPool.BLANK;

		PortletURL portletURL = getPortalSettingsURL();

		if (portletURL == null) {
			return _portalSettingsAnalyticsURL;
		}

		portletURL.setParameter("historyKey", "_130_contentTargetingAnalytics");

		_portalSettingsAnalyticsURL = portletURL.toString();

		return _portalSettingsAnalyticsURL;
	}

	public int getScorePoints() {
		if (_scorePoints != null) {
			return _scorePoints;
		}

		_scorePoints = GetterUtil.getInteger(displayContext.get("scorePoints"));

		return _scorePoints;
	}

	public String getSiteSettingsAnalyticsURL() {
		if (_siteSettingsAnalyticsURL != null) {
			return _siteSettingsAnalyticsURL;
		}

		_siteSettingsAnalyticsURL = StringPool.BLANK;

		PortletURL portletURL = getPortalSettingsURL();

		if (portletURL == null) {
			return _siteSettingsAnalyticsURL;
		}

		portletURL.setParameter("historyKey", "_165_contentTargetingAnalytics");

		_siteSettingsAnalyticsURL = portletURL.toString();

		return _siteSettingsAnalyticsURL;
	}

	public UserSegment getUserSegment() {
		if (_userSegment != null) {
			return _userSegment;
		}

		_userSegment = (UserSegment)displayContext.get("userSegment");

		return _userSegment;
	}

	public boolean isTrackingContentEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsContentEnabled(
			themeDisplay.getScopeGroupId());
	}

	public boolean isTrackingPageEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsPageEnabled(
			themeDisplay.getScopeGroupId());
	}

	private String _portalSettingsAnalyticsURL;
	private Integer _scorePoints;
	private String _siteSettingsAnalyticsURL;
	private UserSegment _userSegment;

}