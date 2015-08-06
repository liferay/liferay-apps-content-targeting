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

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 */
public class ReportSearchContainerIterator
	extends SearchContainerIterator<Report> {

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

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_reportsRegistry = ServiceTrackerUtil.getService(
			ReportsRegistry.class, bundle.getBundleContext());
	}

	@Override
	public List<Report> getResults(int start, int end)
		throws PortalException, SystemException {

		return ListUtil.subList(getResults(), start, end);
	}

	@Override
	public int getTotal() throws PortalException, SystemException {
		return getResults().size();
	}

	protected List<Report> getResults() {
		Map<String, Report> reportMap = _reportsRegistry.getReports(_className);

		List<Report> reports = new ArrayList<Report>();

		for (Report report : reportMap.values()) {
			if ((_classPK <= 0) || report.isVisible(_classPK)) {
				reports.add(report);
			}
		}

		return reports;
	}

	private String _className;
	private long _classPK;
	private ReportsRegistry _reportsRegistry;

}