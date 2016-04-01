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

import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleAgeDisplayContext {

	public RuleAgeDisplayContext(
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request) {

		_liferayPortletResponse = liferayPortletResponse;
		_request = request;

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

		_portalSettingsURL = StringPool.BLANK;

		if (isBirthDayEnabled()) {
			return _portalSettingsURL;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (!PortletPermissionUtil.hasControlPanelAccessPermission(
					themeDisplay.getPermissionChecker(),
					themeDisplay.getScopeGroupId(),
					PortletKeys.PORTAL_SETTINGS)) {

				return _portalSettingsURL;
			}

			PortletURL portletURL =
				_liferayPortletResponse.createLiferayPortletURL(
					PortalUtil.getControlPanelPlid(themeDisplay.getCompanyId()),
					PortletKeys.PORTAL_SETTINGS, PortletRequest.RENDER_PHASE,
					false);

			portletURL.setParameter("historyKey", "_130_users");

			_portalSettingsURL = portletURL.toString();
		}
		catch (PortalException pe) {
		}

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

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_birthdayEnabled = PrefsPropsUtil.getBoolean(
			themeDisplay.getCompanyId(),
			PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY);

		return _birthdayEnabled;
	}

	private Boolean _birthdayEnabled;
	private final Map<String, Object> _displayContext;
	private final LiferayPortletResponse _liferayPortletResponse;
	private Integer _olderThan;
	private String _portalSettingsURL;
	private final HttpServletRequest _request;
	private Integer _youngerThan;

}