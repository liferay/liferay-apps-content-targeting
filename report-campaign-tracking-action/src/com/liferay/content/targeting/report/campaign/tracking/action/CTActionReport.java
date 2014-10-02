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

package com.liferay.content.targeting.report.campaign.tracking.action;

import com.liferay.content.targeting.api.model.BaseReport;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService;
import com.liferay.content.targeting.report.campaign.tracking.action.util.comparator.CTActionTotalCountComparator;
import com.liferay.content.targeting.util.SearchContainerIterator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.StringPool;

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
public class CTActionReport extends BaseReport {

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
		return "icon-list-alt";
	}

	@Override
	public String getReportType() {
		return Campaign.class.getName();
	}

	@Reference
	public void setCTActionLocalService(
		CTActionLocalService ctActionLocalService) {

		_ctActionLocalService = ctActionLocalService;
	}

	@Reference
	public void setCTActionTotalLocalService(
		CTActionTotalLocalService ctActionTotalLocalService) {

		_ctActionTotalLocalService = ctActionTotalLocalService;
	}

	@Override
	public String updateReport(long classPK) {
		try {
			_ctActionLocalService.checkCTActionEvents(classPK);

			_ctActionTotalLocalService.checkCTActionTotalEvents(classPK);
		}
		catch (Exception e) {
			_log.error("Cannot update report", e);
		}

		return StringPool.BLANK;
	}

	@Override
	protected void populateContext(Map<String, Object> context) {
		final long classPK = MapUtil.getLong(context, "classPK", 0);

		context.put(
			"searchContainerIterator",
			new SearchContainerIterator<CTActionTotal>() {

				@Override
				public List<CTActionTotal> getResults(int start, int end)
					throws PortalException, SystemException {

					return _ctActionTotalLocalService.getCTActionsTotal(
							classPK, start, end,
							new CTActionTotalCountComparator());
				}

				@Override
				public int getTotal() throws PortalException, SystemException {
					return _ctActionTotalLocalService.getCTActionsTotalCount(
						classPK);
				}
			}
		);
	}

	private static Log _log = LogFactoryUtil.getLog(CTActionReport.class);

	private CTActionLocalService _ctActionLocalService;
	private CTActionTotalLocalService _ctActionTotalLocalService;

}