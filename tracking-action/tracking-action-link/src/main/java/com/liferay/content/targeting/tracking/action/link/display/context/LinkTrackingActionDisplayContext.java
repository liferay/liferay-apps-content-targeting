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

package com.liferay.content.targeting.tracking.action.link.display.context;

import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class LinkTrackingActionDisplayContext {

	public LinkTrackingActionDisplayContext(HttpServletRequest request) {
		_request = request;

		_displayContext = (Map<String, Object>)_request.getAttribute(
			"displayContext");
	}

	public String getAlias() {
		if (_alias != null) {
			return _alias;
		}

		_alias = GetterUtil.getString(
			_displayContext.get("alias"), StringPool.BLANK);

		return _alias;
	}

	public String getElementId() {
		if (_elementId != null) {
			return _elementId;
		}

		_elementId = GetterUtil.getString(
			_displayContext.get("elementId"), StringPool.BLANK);

		return _elementId;
	}

	public String getEventType() {
		if (_eventType != null) {
			return _eventType;
		}

		_eventType = GetterUtil.getString(
			_displayContext.get("eventType"), "view");

		return _eventType;
	}

	public String[] getEventTypes() {
		return GetterUtil.getStringValues(
			_displayContext.get("eventTypes"), new String[] {"view"});
	}

	public String getPortalSettingsURL() {
		if (_portalSettingsURL != null) {
			return _portalSettingsURL;
		}

		_portalSettingsURL = GetterUtil.getString(
			_displayContext.get("portalSettingsURL"));

		return _portalSettingsURL;
	}

	public String getSiteSettingsURL() {
		if (_siteSettingsURL != null) {
			return _siteSettingsURL;
		}

		_siteSettingsURL = GetterUtil.getString(
			_displayContext.get("siteSettingsURL"));

		return _siteSettingsURL;
	}

	public boolean isTrackingLinkEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsLinkEnabled(
			themeDisplay.getScopeGroupId());
	}

	private String _alias;
	private final Map<String, Object> _displayContext;
	private String _elementId;
	private String _eventType;
	private String _portalSettingsURL;
	private final HttpServletRequest _request;
	private String _siteSettingsURL;

}