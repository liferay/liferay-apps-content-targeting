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

package com.liferay.consumer.manager.report.@report.java.package.name@;

import com.liferay.consumer.manager.api.model.BaseConsumerReport;
import com.liferay.consumer.manager.api.model.ConsumerExtension;
import com.liferay.consumer.manager.api.model.ConsumerReport;
import com.liferay.consumer.manager.model.ConsumerReportInstance;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Brian Chan
 */
@Component(
	immediate = true, service = ConsumerReport.class)
public class @report.java.class.name@ConsumerReport extends BaseConsumerReport {

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
	public void updateReport(ConsumerReportInstance reportInstance) {
	}

	@Override
	protected void populateContext(
		ConsumerReportInstance reportInstance, Map<String, Object> context) {
	}

}