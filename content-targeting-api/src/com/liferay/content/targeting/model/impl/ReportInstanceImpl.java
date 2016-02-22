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
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;

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

	public String getReportName(Locale locale) {
		Report report = ReportInstanceLocalServiceUtil.getReport(
			getReportKey());

		if (report == null) {
			return StringPool.BLANK;
		}

		String reportName = report.getName(locale);

		if (Campaign.class.getName().equals(getClassName())) {
			Campaign campaign = CampaignLocalServiceUtil.fetchCampaign(
				getClassPK());

			if (campaign != null) {
				reportName = String.format(
					"%s %s", campaign.getName(locale), report.getName(locale));
			}
		}
		else if (UserSegment.class.getName().equals(getClassName())) {
			UserSegment userSegment =
				UserSegmentLocalServiceUtil.fetchUserSegment(getClassPK());

			if (userSegment != null) {
				reportName = String.format(
					"%s %s", userSegment.getName(locale),
					report.getName(locale));
			}
		}

		return reportName;
	}

	public String getTypeName(Locale locale) {
		Report report = ReportInstanceLocalServiceUtil.getReport(
			getReportKey());

		if (report == null) {
			return StringPool.BLANK;
		}

		if (!report.isInstantiable()) {
			return LanguageUtil.get(locale, "system-report");
		}

		return report.getName(locale);
	}

	public boolean isInstantiable() {
		Report report = ReportInstanceLocalServiceUtil.getReport(
			getReportKey());

		if (report == null) {
			return false;
		}

		return report.isInstantiable();
	}

}