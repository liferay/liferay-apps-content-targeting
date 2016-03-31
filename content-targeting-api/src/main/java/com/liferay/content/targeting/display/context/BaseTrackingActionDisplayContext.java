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

package com.liferay.content.targeting.display.context;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class BaseTrackingActionDisplayContext {

	public BaseTrackingActionDisplayContext(HttpServletRequest request) {
		this.request = request;

		displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public String getAlias() {
		if (_alias != null) {
			return _alias;
		}

		_alias = GetterUtil.getString(
			displayContext.get("alias"), StringPool.BLANK);

		return _alias;
	}

	public String getEventType() {
		if (_eventType != null) {
			return _eventType;
		}

		_eventType = GetterUtil.getString(
			displayContext.get("eventType"), "view");

		return _eventType;
	}

	public String[] getEventTypes() {
		return GetterUtil.getStringValues(
			displayContext.get("eventTypes"), new String[] {"view"});
	}

	public String getPortalSettingsURL() {
		if (_portalSettingsURL != null) {
			return _portalSettingsURL;
		}

		_portalSettingsURL = GetterUtil.getString(
			displayContext.get("portalSettingsURL"));

		return _portalSettingsURL;
	}

	public String getSiteSettingsURL() {
		if (_siteSettingsURL != null) {
			return _siteSettingsURL;
		}

		_siteSettingsURL = GetterUtil.getString(
			displayContext.get("siteSettingsURL"));

		return _siteSettingsURL;
	}

	protected final Map<String, Object> displayContext;
	protected final HttpServletRequest request;

	private String _alias;
	private String _eventType;
	private String _portalSettingsURL;
	private String _siteSettingsURL;

}