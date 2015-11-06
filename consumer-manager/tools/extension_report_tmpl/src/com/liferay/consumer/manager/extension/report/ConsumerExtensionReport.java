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

package com.liferay.consumer.manager.extension.report.@extension.report.java.package.name@;

import com.liferay.consumer.manager.api.model.BaseConsumerExtensionReport;
import com.liferay.consumer.manager.api.model.ConsumerExtension;
import com.liferay.consumer.manager.model.ConsumerExtensionReportInstance;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Brian Chan
 */
@Component(
	immediate = true, service = ConsumerExtensionReport.class)
public class @extension.report.java.class.name@ConsumerExtensionReport
	extends BaseConsumerExtensionReport {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public String getIcon() {
		return "icon-puzzle";
	}

	@Override
	public String getReportType() {
		return ConsumerExtension.class.getName();
	}

	@Override
	public void updateReport(ConsumerExtensionReportInstance reportInstance) {
	}

	@Override
	protected void populateContext(
		ConsumerExtensionReportInstance reportInstance,
		Map<String, Object> context) {
	}

}