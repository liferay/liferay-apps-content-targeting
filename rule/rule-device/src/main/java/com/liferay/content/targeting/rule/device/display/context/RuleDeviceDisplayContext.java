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

package com.liferay.content.targeting.rule.device.display.context;

import com.liferay.mobile.device.rules.constants.MDRPortletKeys;
import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.service.MDRRuleGroupLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleDeviceDisplayContext {

	public RuleDeviceDisplayContext(
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request) {

		_liferayPortletResponse = liferayPortletResponse;
		_request = request;

		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public long getMDRGroupId() {
		if (_mdrGroupId != null) {
			return _mdrGroupId;
		}

		_mdrGroupId = GetterUtil.getLong(_displayContext.get("mdrGroupId"));

		return _mdrGroupId;
	}

	public List<MDRRuleGroup> getMDRRuleGroups() {
		if (_mdrRuleGroups != null) {
			return _mdrRuleGroups;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("includeGlobalScope", Boolean.TRUE);

		// See LPS-55480

		_mdrRuleGroups = MDRRuleGroupLocalServiceUtil.searchByKeywords(
			themeDisplay.getScopeGroupId(), null, params, false,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		return _mdrRuleGroups;
	}

	public String getMDRURL() {
		if (_mDRURL != null) {
			return _mDRURL;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_mDRURL = StringPool.BLANK;

		try {
			if (!PortletPermissionUtil.hasControlPanelAccessPermission(
					themeDisplay.getPermissionChecker(),
					themeDisplay.getScopeGroupId(),
					MDRPortletKeys.MOBILE_DEVICE_RULES)) {

				return _mDRURL;
			}

			PortletURL portletURL =
				_liferayPortletResponse.createLiferayPortletURL(
					PortalUtil.getControlPanelPlid(themeDisplay.getCompanyId()),
					MDRPortletKeys.MOBILE_DEVICE_RULES,
					PortletRequest.RENDER_PHASE, false);

			_mDRURL = portletURL.toString();
		}
		catch (PortalException pe) {
		}

		return _mDRURL;
	}

	private final Map<String, Object> _displayContext;
	private final LiferayPortletResponse _liferayPortletResponse;
	private Long _mdrGroupId;
	private List<MDRRuleGroup> _mdrRuleGroups;
	private String _mDRURL;
	private final HttpServletRequest _request;

}