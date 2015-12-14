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

package com.liferay.content.targeting.model.impl;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Reference;

/**
 * The extended model implementation for the ReportInstance service. Represents a row in the &quot;CT_ReportInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.model.ReportInstance} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ReportInstanceImpl extends ReportInstanceBaseImpl {

	public String getReportName(Locale locale) throws SystemException {
		Report report = _reportsRegistry.getReport(getReportKey());

		if (report == null) {
			return StringPool.BLANK;
		}

		String reportName = report.getName(locale);

		if (Campaign.class.getName().equals(getClassName())) {
			Campaign campaign = _campaignLocalService.fetchCampaign(
				getClassPK());

			if (campaign != null) {
				reportName = String.format(
					"%s %s", campaign.getName(locale), report.getName(locale));
			}
		}
		else if (UserSegment.class.getName().equals(getClassName())) {
			UserSegment userSegment = _userSegmentLocalService.fetchUserSegment(
				getClassPK());

			if (userSegment != null) {
				reportName = String.format(
					"%s %s", userSegment.getName(locale),
					report.getName(locale));
			}
		}

		return reportName;
	}

	public String getTypeName(Locale locale) {
		Report report = _reportsRegistry.getReport(getReportKey());

		if (report == null) {
			return StringPool.BLANK;
		}

		if (!report.isInstantiable()) {
			return LanguageUtil.get(locale, "system-report");
		}

		return report.getName(locale);
	}

	public boolean isInstantiable() {
		Report report = _reportsRegistry.getReport(getReportKey());

		if (report == null) {
			return false;
		}

		return report.isInstantiable();
	}

	@Reference(unbind = "-")
	protected void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		_campaignLocalService = campaignLocalService;
	}

	@Reference(unbind = "-")
	protected void setReportsRegistry(ReportsRegistry reportsRegistry) {
		_reportsRegistry = reportsRegistry;
	}

	@Reference
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	private CampaignLocalService _campaignLocalService;
	private ReportsRegistry _reportsRegistry;
	private UserSegmentLocalService _userSegmentLocalService;

}