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

package com.liferay.contenttargeting.reports.usersegmentcontent;

import aQute.bnd.annotation.component.Component;

import com.liferay.contenttargeting.api.model.BaseReport;
import com.liferay.contenttargeting.api.model.Report;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, provide = Report.class)
public class UserSegmentContentReport extends BaseReport {

	@Override
	public String getIcon() {
		return "icon-eye-open";
	}

	@Override
	public String getReportType() {
		return UserSegment.class.getName();
	}

	@Override
	public void updateReport() {
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserSegmentContentReport.class);

}