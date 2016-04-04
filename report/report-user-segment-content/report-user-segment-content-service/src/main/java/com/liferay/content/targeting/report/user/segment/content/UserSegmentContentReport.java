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

package com.liferay.content.targeting.report.user.segment.content;

import com.liferay.content.targeting.api.model.BaseJSPReport;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = Report.class)
public class UserSegmentContentReport extends BaseJSPReport {

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
		return "icon-eye-open";
	}

	@Override
	public String getReportType() {
		return UserSegment.class.getName();
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.report.user.segment.content.service)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	@Reference(unbind = "-")
	public void setUserSegmentContentLocalService(
		UserSegmentContentLocalService userSegmentContentLocalService) {

		_userSegmentContentLocalService = userSegmentContentLocalService;
	}

	@Override
	public void updateReport(ReportInstance reportInstance) {
		try {
			_userSegmentContentLocalService.checkUserSegmentContentEvents(
				reportInstance.getClassPK());
		}
		catch (Exception e) {
			_log.error("Cannot update report", e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentContentReport.class);

	private UserSegmentContentLocalService _userSegmentContentLocalService;

}