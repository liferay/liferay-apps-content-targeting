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

import com.liferay.content.targeting.api.model.BaseReport;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent;
import com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalService;
import com.liferay.content.targeting.report.user.segment.content.util.comparator.UserSegmentContentCountComparator;
import com.liferay.content.targeting.util.SearchContainerIterator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MapUtil;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = Report.class)
public class UserSegmentContentReport extends BaseReport {

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

	@Override
	protected void populateContext(
		ReportInstance reportInstance, Map<String, Object> context) {

		final long classPK = MapUtil.getLong(context, "classPK", 0);

		context.put(
			"searchContainerIterator",
			new SearchContainerIterator<UserSegmentContent>() {

				@Override
				public List<UserSegmentContent> getResults(int start, int end)
					throws PortalException {

					return _userSegmentContentLocalService.
						getUserSegmentContents(
							classPK, start, end,
							new UserSegmentContentCountComparator());
				}

				@Override
				public int getTotal() throws PortalException {
					return _userSegmentContentLocalService.
						getUserSegmentContentsCount(classPK);
				}

			}
		);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentContentReport.class);

	private UserSegmentContentLocalService _userSegmentContentLocalService;

}