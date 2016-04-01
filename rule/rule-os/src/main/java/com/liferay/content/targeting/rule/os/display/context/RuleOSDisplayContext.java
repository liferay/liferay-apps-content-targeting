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

package com.liferay.content.targeting.rule.os.display.context;

import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleOSDisplayContext {

	public RuleOSDisplayContext(HttpServletRequest request) {
		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public String[] getOperatingSystems() {
		if (_operatingSystems != null) {
			return _operatingSystems;
		}

		_operatingSystems = GetterUtil.getStringValues(
			_displayContext.get("operatingSystems"));

		return _operatingSystems;
	}

	public String getOs() {
		if (_os != null) {
			return _os;
		}

		_os = GetterUtil.getString(_displayContext.get("os"));

		return _os;
	}

	private final Map<String, Object> _displayContext;
	private String[] _operatingSystems;
	private String _os;

}