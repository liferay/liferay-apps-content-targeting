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

package com.liferay.content.targeting.rule.facebook.display.context;

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.portal.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleFacebookDisplayContext extends BaseRuleDisplayContext {

	public RuleFacebookDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public String getCityName() {
		if (_cityName != null) {
			return _cityName;
		}

		_cityName = GetterUtil.getString(displayContext.get("cityName"));

		return _cityName;
	}

	public String getEducationLevel() {
		if (_educationLevel != null) {
			return _educationLevel;
		}

		_educationLevel = GetterUtil.getString(
			displayContext.get("educationLevel"));

		return _educationLevel;
	}

	public String getFacebookName() {
		if (_facebookName != null) {
			return _facebookName;
		}

		_facebookName = GetterUtil.getString(
			displayContext.get("facebookName"));

		return _facebookName;
	}

	public int getFbOlderThan() {
		if (_fbOlderThan != null) {
			return _fbOlderThan;
		}

		_fbOlderThan = GetterUtil.getInteger(displayContext.get("fbOlderThan"));

		return _fbOlderThan;
	}

	public int getFbYoungerThan() {
		if (_fbYoungerThan != null) {
			return _fbYoungerThan;
		}

		_fbYoungerThan = GetterUtil.getInteger(
			displayContext.get("fbYoungerThan"));

		return _fbYoungerThan;
	}

	public String getGender() {
		if (_gender != null) {
			return _gender;
		}

		_gender = GetterUtil.getString(displayContext.get("gender"));

		return _gender;
	}

	public int getNumberOfFriends() {
		if (_numberOfFriends != null) {
			return _numberOfFriends;
		}

		_numberOfFriends = GetterUtil.getInteger(
			displayContext.get("numberOfFriends"), 0);

		return _numberOfFriends;
	}

	@Override
	public String getPortalSettingsURL() {
		if (_portalSettingsAuthenticationURL != null) {
			return _portalSettingsAuthenticationURL;
		}

		_portalSettingsAuthenticationURL = StringPool.BLANK;

		if (isFbLoginEnabled()) {
			return _portalSettingsAuthenticationURL;
		}

		_portalSettingsAuthenticationURL = super.getPortalSettingsURL();

		return _portalSettingsAuthenticationURL;
	}

	public String getSchoolName() {
		if (_schoolName != null) {
			return _schoolName;
		}

		_schoolName = GetterUtil.getString(displayContext.get("schoolName"));

		return _schoolName;
	}

	public String getSelector() {
		if (_selector != null) {
			return _selector;
		}

		_selector = GetterUtil.getString(displayContext.get("selector"));

		return _selector;
	}

	public boolean isFbLoginEnabled() {
		if (_isFbLoginEnabled != null) {
			return _isFbLoginEnabled;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_isFbLoginEnabled = FacebookConnectUtil.isEnabled(
			themeDisplay.getCompanyId());

		return _isFbLoginEnabled;
	}

	private String _cityName;
	private String _educationLevel;
	private String _facebookName;
	private Integer _fbOlderThan;
	private Integer _fbYoungerThan;
	private String _gender;
	private Boolean _isFbLoginEnabled;
	private Integer _numberOfFriends;
	private String _portalSettingsAuthenticationURL;
	private String _schoolName;
	private String _selector;

}