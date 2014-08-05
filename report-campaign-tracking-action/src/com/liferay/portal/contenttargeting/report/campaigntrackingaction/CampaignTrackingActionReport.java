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

package com.liferay.portal.contenttargeting.report.campaigntrackingaction;

import com.liferay.portal.contenttargeting.api.model.BaseReport;
import com.liferay.portal.contenttargeting.api.model.Report;
import com.liferay.portal.contenttargeting.model.Campaign;
import com.liferay.portal.contenttargeting.report.campaigntrackingaction.model.CampaignTrackingAction;
import com.liferay.portal.contenttargeting.report.campaigntrackingaction.service.CampaignTrackingActionLocalServiceUtil;
import com.liferay.portal.contenttargeting.report.campaigntrackingaction.util.comparator.CampaignTrackingActionCountComparator;
import com.liferay.portal.contenttargeting.util.SearchContainerIterator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MapUtil;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = Report.class)
public class CampaignTrackingActionReport extends BaseReport {

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

	@Override
	public void updateReport() {
		try {
			CampaignTrackingActionLocalServiceUtil.
				checkCampaignTrackingActionEvents();
		}
		catch (Exception e) {
			_log.error("Cannot update report", e);
		}
	}

	@Override
	protected void populateContext(Map<String, Object> context) {
		final long campaignId = MapUtil.getLong(context, "campaignId", 0);

		context.put(
			"searchContainerIterator",
			new SearchContainerIterator<CampaignTrackingAction>() {

				@Override
				public List<CampaignTrackingAction> getResults(
						int start, int end)
					throws PortalException, SystemException {

					return CampaignTrackingActionLocalServiceUtil.
							getCampaignTrackingActions(
								campaignId, start, end,
								new CampaignTrackingActionCountComparator());
				}

				@Override
				public int getTotal() throws PortalException, SystemException {
					return CampaignTrackingActionLocalServiceUtil.
						getCampaignTrackingActionsCount(campaignId);
				}
			}
		);
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignTrackingActionReport.class);

}