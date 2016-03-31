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

package com.liferay.content.targeting.tracking.action.page.display.context;

import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class PageTrackingActionDisplayContext {

	public PageTrackingActionDisplayContext(HttpServletRequest request) {
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

	public String getFriendlyURL() {
		if (_friendlyURL != null) {
			return _friendlyURL;
		}

		_friendlyURL = GetterUtil.getString(_displayContext.get("friendlyURL"));

		return _friendlyURL;
	}

	public String getFriendlyURLBase() throws PortalException {
		if (isPrivateLayout()) {
			return getFriendlyURLPrivateBase();
		}

		return getFriendlyURLPublicBase();
	}

	public String getFriendlyURLPrivateBase() throws PortalException {
		if (_friendlyURLPrivateBase != null) {
			return _friendlyURLPrivateBase;
		}

		_friendlyURLPrivateBase = getFriendlyURL(true);

		return _friendlyURLPrivateBase;
	}

	public String getFriendlyURLPublicBase() throws PortalException {
		if (_friendlyURLPublicBase != null) {
			return _friendlyURLPublicBase;
		}

		_friendlyURLPublicBase = getFriendlyURL(false);

		return _friendlyURLPublicBase;
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

	public boolean isPrivateLayout() {
		if (_privateLayout != null) {
			return _privateLayout;
		}

		_privateLayout = GetterUtil.getBoolean(
			_displayContext.get("privateLayout"), false);

		return _privateLayout;
	}

	public boolean isTrackingPageEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsPageEnabled(
			themeDisplay.getScopeGroupId());
	}

	protected String getFriendlyURL(boolean privateLayout)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String friendlyURL = StringPool.BLANK;

		LayoutSet layoutSet = themeDisplay.getLayoutSet();

		boolean privateLayoutSet = layoutSet.isPrivateLayout();

		try {
			layoutSet.setPrivateLayout(privateLayout);

			friendlyURL = PortalUtil.getGroupFriendlyURL(
				layoutSet, themeDisplay);
		}
		finally {
			layoutSet.setPrivateLayout(privateLayoutSet);
		}

		return friendlyURL;
	}

	private String _alias;
	private final Map<String, Object> _displayContext;
	private String _eventType;
	private String _friendlyURL;
	private String _friendlyURLPrivateBase;
	private String _friendlyURLPublicBase;
	private String _portalSettingsURL;
	private Boolean _privateLayout;
	private final HttpServletRequest _request;
	private String _siteSettingsURL;

}