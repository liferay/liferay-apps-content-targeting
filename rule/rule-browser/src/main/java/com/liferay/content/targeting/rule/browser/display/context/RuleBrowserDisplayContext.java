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

package com.liferay.content.targeting.rule.browser.display.context;

import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleBrowserDisplayContext {

	public RuleBrowserDisplayContext(HttpServletRequest request) {
		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public String getBrowser() {
		if (_browser != null) {
			return _browser;
		}

		_browser = GetterUtil.getString(_displayContext.get("browser"));

		return _browser;
	}

	public String[] getBrowsers() {
		if (_browsers != null) {
			return _browsers;
		}

		_browsers = GetterUtil.getStringValues(_displayContext.get("browsers"));

		return _browsers;
	}

	private String _browser;
	private String[] _browsers;
	private final Map<String, Object> _displayContext;

}