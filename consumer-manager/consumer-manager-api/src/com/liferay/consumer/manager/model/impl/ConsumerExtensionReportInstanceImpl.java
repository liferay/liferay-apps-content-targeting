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

import com.liferay.consumer.manager.api.model.ConsumerExtensionReport;
import com.liferay.consumer.manager.api.model.ConsumerExtensionReportsRegistry;
import com.liferay.osgi.util.service.ServiceTrackerUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The extended model implementation for the ConsumerExtensionReportInstance service. Represents a row in the &quot;CM_ConsumerExtensionReportInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consumer.manager.model.ConsumerExtensionReportInstance} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ConsumerExtensionReportInstanceImpl
	extends ConsumerExtensionReportInstanceBaseImpl {

	public ConsumerExtensionReportInstanceImpl() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_consumerExtensionReportsRegistry = ServiceTrackerUtil.getService(
			ConsumerExtensionReportsRegistry.class, bundle.getBundleContext());
	}

	public boolean isInstantiable() {
		ConsumerExtensionReport report =
			_consumerExtensionReportsRegistry.getReport(getReportKey());

		if (report == null) {
			return false;
		}

		return report.isInstantiable();
	}

	private ConsumerExtensionReportsRegistry _consumerExtensionReportsRegistry;

}