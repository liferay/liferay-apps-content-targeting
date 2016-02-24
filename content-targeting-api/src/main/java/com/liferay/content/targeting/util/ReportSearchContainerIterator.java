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

import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;

/**
 * @author Eduardo Garcia
 */
public class ReportSearchContainerIterator
	extends SearchContainerIterator<ReportInstance> {

	public ReportSearchContainerIterator() {
		_className = StringPool.BLANK;
		_classPK = 0;
	}

	/**
	 * @deprecated As of Audience Targeting 2.0, replaced by {@link
	 *             #ReportSearchContainerIterator(long, String, String, long)}
	 */
	public ReportSearchContainerIterator(
			long groupId, String keywords, String className)
		throws PortletException {

		this(groupId, keywords, className, 0);
	}

	public ReportSearchContainerIterator(
			long groupId, String keywords, String className, long classPK)
		throws PortletException {

		super(groupId, keywords);

		_className = className;
		_classPK = classPK;
	}

	@Override
	public List<ReportInstance> getResults(int start, int end)
		throws PortalException {

		if (Validator.isBlank(keywords)) {
			return ReportInstanceLocalServiceUtil.getReportInstances(
				_className, _classPK, start, end);
		}

		return ReportInstanceLocalServiceUtil.searchReportInstances(
			groupId, _className, _classPK, keywords, start, end);
	}

	@Override
	public int getTotal() throws PortalException {
		return getResults().size();
	}

	protected List<ReportInstance> getResults() throws PortalException {
		return getResults(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	private final String _className;
	private final long _classPK;

}