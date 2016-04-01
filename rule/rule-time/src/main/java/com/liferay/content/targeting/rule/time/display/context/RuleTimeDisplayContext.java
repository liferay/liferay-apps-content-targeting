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

package com.liferay.content.targeting.rule.time.display.context;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.Format;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleTimeDisplayContext {

	public RuleTimeDisplayContext(HttpServletRequest request) {
		_request = request;

		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public int getEndTimeAmPm() {
		if (_endTimeAmPm != null) {
			return _endTimeAmPm;
		}

		_endTimeAmPm = GetterUtil.getInteger(
			_displayContext.get("endTimeAmPm"));

		return _endTimeAmPm;
	}

	public int getEndTimeHour() {
		if (_endTimeHour != null) {
			return _endTimeHour;
		}

		_endTimeHour = GetterUtil.getInteger(
			_displayContext.get("endTimeHour"));

		return _endTimeHour;
	}

	public int getEndTimeMinute() {
		if (_endTimeMinute != null) {
			return _endTimeMinute;
		}

		_endTimeMinute = GetterUtil.getInteger(
			_displayContext.get("endTimeMinute"));

		return _endTimeMinute;
	}

	public String getInfoMessage() {
		ThemeDisplay themeDisplay = (ThemeDisplay) _request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Format timeFormat = FastDateFormatFactoryUtil.getSimpleDateFormat(
			"HH:mm", themeDisplay.getLocale());

		Date now = (Date)_displayContext.get("now");

		return timeFormat.format(now.getTime());
	}

	public int getStartTimeAmPm() {
		if (_startTimeAmPm != null) {
			return _startTimeAmPm;
		}

		_startTimeAmPm = GetterUtil.getInteger(
			_displayContext.get("startTimeAmPm"));

		return _startTimeAmPm;
	}

	public int getStartTimeHour() {
		if (_startTimeHour != null) {
			return _startTimeHour;
		}

		_startTimeHour = GetterUtil.getInteger(
			_displayContext.get("startTimeHour"));

		return _startTimeHour;
	}

	public int getStartTimeMinute() {
		if (_startTimeMinute != null) {
			return _startTimeMinute;
		}

		_startTimeMinute = GetterUtil.getInteger(
			_displayContext.get("startTimeMinute"));

		return _startTimeMinute;
	}

	private final Map<String, Object> _displayContext;
	private Integer _endTimeAmPm;
	private Integer _endTimeHour;
	private Integer _endTimeMinute;
	private final HttpServletRequest _request;
	private Integer _startTimeAmPm;
	private Integer _startTimeHour;
	private Integer _startTimeMinute;

}