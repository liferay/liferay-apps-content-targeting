/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.internal;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.liferay.contenttargeting.api.model.Report;
import com.liferay.contenttargeting.api.model.ReportsRegistry;
import com.liferay.portal.kernel.util.PredicateFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eduardo Garcia
 */
@Component
public class DefaultReportsRegistryImpl implements ReportsRegistry {

	@Override
	public Report getReport(String reportKey) {
		return _reports.get(reportKey);
	}

	@Override
	public Map<String, Report> getReports() {
		return _reports;
	}

	@Override
	public Map<String, Report> getReports(final String reportType) {
		return _filter(
			_reports, new HashMap<String, Report>(),
			new PredicateFilter<Report>() {

				@Override
				public boolean filter(Report report) {
					return report.getReportType().equals(reportType);
				}

			});
	}

	@Reference(type = '*', unbind = "unregisterReport")
	public void registerReport(Report report) {
		_reports.put(report.getReportKey(), report);
	}

	public void unregisterReport(Report report) {
		_reports.remove(report);
	}

	private <K, V> Map<K, V> _filter(
		Map<? extends K, ? extends V> inputMap, Map<K, V> outputMap,
		PredicateFilter<V> predicateFilter) {

		for (Map.Entry<? extends K, ? extends V> entry : inputMap.entrySet()) {
			if (predicateFilter.filter(entry.getValue())) {
				outputMap.put(entry.getKey(), entry.getValue());
			}
		}

		return outputMap;
	}

	private Map<String, Report> _reports =
		new ConcurrentHashMap<String, Report>();

}