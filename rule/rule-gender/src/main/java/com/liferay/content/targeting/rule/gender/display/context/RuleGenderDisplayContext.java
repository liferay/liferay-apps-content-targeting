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

package com.liferay.content.targeting.rule.gender.display.context;

import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleGenderDisplayContext {

	public RuleGenderDisplayContext(HttpServletRequest request) {
		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public String getGender() {
		if (_gender != null) {
			return _gender;
		}

		_gender = GetterUtil.getString(_displayContext.get("gender"));

		return _gender;
	}

	public String getPortalSettingsURL() {
		if (_portalSettingsURL != null) {
			return _portalSettingsURL;
		}

		_portalSettingsURL = GetterUtil.getString(
			_displayContext.get("portalSettingsURL"));

		return _portalSettingsURL;
	}

	public boolean isGenderEnabled() {
		if (_genderEnabled != null) {
			return _genderEnabled;
		}

		_genderEnabled = GetterUtil.getBoolean(
			_displayContext.get("genderEnabled"), false);

		return _genderEnabled;
	}

	private final Map<String, Object> _displayContext;
	private String _gender;
	private Boolean _genderEnabled;
	private String _portalSettingsURL;

}