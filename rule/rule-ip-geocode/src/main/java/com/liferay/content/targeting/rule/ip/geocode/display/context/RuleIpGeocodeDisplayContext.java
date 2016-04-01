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

package com.liferay.content.targeting.rule.ip.geocode.display.context;

import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleIpGeocodeDisplayContext {

	public RuleIpGeocodeDisplayContext(HttpServletRequest request) {
		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public long getCountryId() {
		if (_countryId != null) {
			return _countryId;
		}

		_countryId = GetterUtil.getLong(_displayContext.get("countryId"));

		return _countryId;
	}

	public long getRegionId() {
		if (_regionId != null) {
			return _regionId;
		}

		_regionId = GetterUtil.getLong(_displayContext.get("regionId"));

		return _regionId;
	}

	private Long _countryId;
	private final Map<String, Object> _displayContext;
	private Long _regionId;

}