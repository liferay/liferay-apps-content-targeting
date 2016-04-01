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

package com.liferay.content.targeting.report.user.segment.content.display.context;

import com.liferay.content.targeting.display.context.BaseReportDisplayContext;
import com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent;
import com.liferay.content.targeting.util.SearchContainerIterator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public class UserSegmentContentReportDisplayContext
	extends BaseReportDisplayContext {

	public UserSegmentContentReportDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public SearchContainerIterator<UserSegmentContent>
		getSearchContainerIterator() {

		if (_searchContainerIterator == null) {
			_searchContainerIterator =
				(SearchContainerIterator<UserSegmentContent>)displayContext.get(
					"searchContainerIterator");
		}

		return _searchContainerIterator;
	}

	private SearchContainerIterator<UserSegmentContent>
		_searchContainerIterator;

}