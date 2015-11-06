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

package com.liferay.consumer.manager.internal;

import com.liferay.consumer.manager.api.model.ConsumerExtensionReport;
import com.liferay.consumer.manager.api.model.ConsumerExtensionReportsRegistry;
import com.liferay.portal.kernel.util.PredicateFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * @author Eduardo Garcia
 */
@Component
public class DefaultConsumerExtensionReportsRegistryImpl
	implements ConsumerExtensionReportsRegistry {

	@Override
	public ConsumerExtensionReport getReport(String reportKey) {
		return _reports.get(reportKey);
	}

	@Override
	public Map<String, ConsumerExtensionReport> getReports() {
		return _reports;
	}

	@Override
	public Map<String, ConsumerExtensionReport> getReports(
		final String reportType) {

		return _filter(
			_reports, new HashMap<String, ConsumerExtensionReport>(),
			new PredicateFilter<ConsumerExtensionReport>() {

				@Override
				public boolean filter(ConsumerExtensionReport report) {
					return report.getReportType().equals(reportType);
				}

			});
	}

	@Override
	public Map<String, ConsumerExtensionReport> getReportsByCategoryKey(
		final String reportCategoryKey) {

		return _filter(
			_reports, new HashMap<String, ConsumerExtensionReport>(),
			new PredicateFilter<ConsumerExtensionReport>() {

				@Override
				public boolean filter(ConsumerExtensionReport report) {
					return report.getReportCategoryKey().equals(
						reportCategoryKey);
				}

			});
	}

	@Reference(
		unbind = "unregisterReport",
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC)
	public void registerReport(ConsumerExtensionReport report) {
		_reports.put(report.getReportKey(), report);
	}

	public void unregisterReport(ConsumerExtensionReport report) {
		_reports.remove(report);
	}

	/**
	 * @deprecated As of Liferay Portal 7.0 (Replace by MapUtil.filter)
	 */
	@Deprecated
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

	private Map<String, ConsumerExtensionReport> _reports =
		new ConcurrentHashMap<String, ConsumerExtensionReport>();

}