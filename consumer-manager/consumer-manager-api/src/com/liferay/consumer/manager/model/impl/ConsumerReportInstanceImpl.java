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

package com.liferay.consumer.manager.model.impl;

import com.liferay.consumer.manager.api.model.ConsumerReport;
import com.liferay.consumer.manager.api.model.ConsumerReportsRegistry;
import com.liferay.osgi.util.service.ServiceTrackerUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The extended model implementation for the ConsumerReportInstance service. Represents a row in the &quot;CM_ConsumerReportInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consumer.manager.model.ConsumerReportInstance} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ConsumerReportInstanceImpl extends ConsumerReportInstanceBaseImpl {

	public ConsumerReportInstanceImpl() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_consumerReportsRegistry = ServiceTrackerUtil.getService(
			ConsumerReportsRegistry.class, bundle.getBundleContext());
	}

	public boolean isInstantiable() {
		ConsumerReport report = _consumerReportsRegistry.getReport(
			getReportKey());

		if (report == null) {
			return false;
		}

		return report.isInstantiable();
	}

	private ConsumerReportsRegistry _consumerReportsRegistry;

}