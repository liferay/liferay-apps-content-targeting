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

package com.liferay.consumer.manager.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Collections;
import java.util.List;

/**
 * @author Julio Camarero
 */
public class SearchContainerIterator<R> {

	public SearchContainerIterator() {
	}

	public SearchContainerIterator(long companyId, String keywords) {
		this.companyId = companyId;
		this.keywords = keywords;
	}

	public List<R> getResults(int start, int end)
		throws PortalException, SystemException {

		return Collections.emptyList();
	}

	public int getTotal() throws PortalException, SystemException {
		return 0;
	}

	protected long companyId;
	protected String keywords;

}