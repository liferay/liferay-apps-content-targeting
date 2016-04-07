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
public class RuleGenderDisplayContext extends BaseRuleDisplayContext {

	public RuleGenderDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public String getGender() {
		if (_gender != null) {
			return _gender;
		}

		_gender = GetterUtil.getString(displayContext.get("gender"));

		return _gender;
	}

	@Override
	public String getPortalSettingsURL() {
		if (_portalSettingsUsersURL != null) {
			return _portalSettingsUsersURL;
		}

		_portalSettingsUsersURL = StringPool.BLANK;

		if (isGenderEnabled()) {
			return StringPool.BLANK;
		}

		_portalSettingsUsersURL = super.getPortalSettingsURL();

		return _portalSettingsUsersURL;
	}

	public boolean isGenderEnabled() {
		if (_genderEnabled != null) {
			return _genderEnabled;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_genderEnabled = PrefsPropsUtil.getBoolean(
			themeDisplay.getCompanyId(),
			PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_MALE);

		return _genderEnabled;
	}

	private String _gender;
	private Boolean _genderEnabled;
	private String _portalSettingsUsersURL;

}