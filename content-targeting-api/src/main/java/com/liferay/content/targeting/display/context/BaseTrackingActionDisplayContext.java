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

package com.liferay.content.targeting.display.context;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class BaseTrackingActionDisplayContext extends BaseDisplayContext {

	public BaseTrackingActionDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public String getAlias() {
		if (_alias != null) {
			return _alias;
		}

		_alias = GetterUtil.getString(
			displayContext.get("alias"), StringPool.BLANK);

		return _alias;
	}

	public String getEventType() {
		if (_eventType != null) {
			return _eventType;
		}

		_eventType = GetterUtil.getString(
			displayContext.get("eventType"), "view");

		return _eventType;
	}

	public List<String> getEventTypes() {
		if (_eventTypes != null) {
			return _eventTypes;
		}

		_eventTypes = (List<String>)displayContext.get("eventTypes");

		if (ListUtil.isEmpty(_eventTypes)) {
			_eventTypes.add("view");
		}

		return _eventTypes;
	}

	private String _alias;
	private String _eventType;
	private List<String> _eventTypes;

}