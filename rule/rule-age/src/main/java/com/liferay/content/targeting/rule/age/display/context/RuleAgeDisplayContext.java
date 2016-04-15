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

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleAgeDisplayContext extends BaseRuleDisplayContext {

	public RuleAgeDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public int getOlderThan() {
		if (_olderThan != null) {
			return _olderThan;
		}

		_olderThan = GetterUtil.getInteger(
			displayContext.get("olderThan"), 100);

		return _olderThan;
	}

	@Override
	public String getPortalSettingsURL() {
		if (_portalSettingsUsersURL != null) {
			return _portalSettingsUsersURL;
		}

		_portalSettingsUsersURL = StringPool.BLANK;

		if (isBirthDayEnabled()) {
			return _portalSettingsUsersURL;
		}

		_portalSettingsUsersURL = super.getPortalSettingsURL();

		return _portalSettingsUsersURL;
	}

	public int getYoungerThan() {
		if (_youngerThan != null) {
			return _youngerThan;
		}

		_youngerThan = GetterUtil.getInteger(displayContext.get("youngerThan"));

		return _youngerThan;
	}

	public boolean isBirthDayEnabled() {
		if (_birthdayEnabled != null) {
			return _birthdayEnabled;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_birthdayEnabled = PrefsPropsUtil.getBoolean(
			themeDisplay.getCompanyId(),
			PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY);

		return _birthdayEnabled;
	}

	private Boolean _birthdayEnabled;
	private Integer _olderThan;
	private String _portalSettingsUsersURL;
	private Integer _youngerThan;

}