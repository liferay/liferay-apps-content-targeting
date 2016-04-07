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

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.mobile.device.rules.constants.MDRPortletKeys;
import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.service.MDRRuleGroupLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleDeviceDisplayContext extends BaseRuleDisplayContext {

	public RuleDeviceDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public long getMDRGroupId() {
		if (_mdrGroupId != null) {
			return _mdrGroupId;
		}

		_mdrGroupId = GetterUtil.getLong(displayContext.get("mdrGroupId"));

		return _mdrGroupId;
	}

	public List<MDRRuleGroup> getMDRRuleGroups() {
		if (_mdrRuleGroups != null) {
			return _mdrRuleGroups;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
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

		PortletURL portletURL = getControlPanelURL(
			MDRPortletKeys.MOBILE_DEVICE_RULES);

		_mDRURL = portletURL.toString();

		return _mDRURL;
	}

	private Long _mdrGroupId;
	private List<MDRRuleGroup> _mdrRuleGroups;
	private String _mDRURL;

}