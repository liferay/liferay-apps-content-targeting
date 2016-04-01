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

import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleDeviceDisplayContext {

	public RuleDeviceDisplayContext(HttpServletRequest request) {
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

		_mdrRuleGroups = (List<MDRRuleGroup>)_displayContext.get(
			"mdrRuleGroups");

		return _mdrRuleGroups;
	}

	public String getMDRURL() {
		if (_mDRURL != null) {
			return _mDRURL;
		}

		_mDRURL = GetterUtil.getString(_displayContext.get("mDRURL"));

		return _mDRURL;
	}

	private final Map<String, Object> _displayContext;
	private Long _mdrGroupId;
	private List<MDRRuleGroup> _mdrRuleGroups;
	private String _mDRURL;

}