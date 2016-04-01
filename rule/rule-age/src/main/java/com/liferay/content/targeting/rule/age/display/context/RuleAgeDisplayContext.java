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

package com.liferay.content.targeting.rule.age.display.context;

import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleAgeDisplayContext {

	public RuleAgeDisplayContext(HttpServletRequest request) {
		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public int getOlderThan() {
		if (_olderThan != null) {
			return _olderThan;
		}

		_olderThan = GetterUtil.getInteger(
			_displayContext.get("olderThan"), 100);

		return _olderThan;
	}

	public String getPortalSettingsURL() {
		if (_portalSettingsURL != null) {
			return _portalSettingsURL;
		}

		_portalSettingsURL = GetterUtil.getString(
			_displayContext.get("portalSettingsURL"));

		return _portalSettingsURL;
	}

	public int getYoungerThan() {
		if (_youngerThan != null) {
			return _youngerThan;
		}

		_youngerThan = GetterUtil.getInteger(
			_displayContext.get("youngerThan"), 0);

		return _youngerThan;
	}

	public boolean isBirthDayEnabled() {
		if (_birthdayEnabled != null) {
			return _birthdayEnabled;
		}

		_birthdayEnabled = GetterUtil.getBoolean(
			_displayContext.get("birthdayEnabled"));

		return _birthdayEnabled;
	}

	private Boolean _birthdayEnabled;
	private final Map<String, Object> _displayContext;
	private Integer _olderThan;
	private String _portalSettingsURL;
	private Integer _youngerThan;

}