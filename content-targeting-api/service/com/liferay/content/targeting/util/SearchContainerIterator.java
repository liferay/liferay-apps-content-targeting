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

package com.liferay.content.targeting.util;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Collections;
import java.util.List;

/**
 * @author Julio Camarero
 */
public class SearchContainerIterator<R> {

	public SearchContainerIterator() {
	}

	public SearchContainerIterator(long groupId, String keywords) {
		this.groupId = groupId;
		this.keywords = keywords;
	}

	public List<R> getResults(int start, int end) throws PortalException {
		return Collections.emptyList();
	}

	public int getTotal() throws PortalException {
		return 0;
	}

	protected long groupId;
	protected String keywords;

}