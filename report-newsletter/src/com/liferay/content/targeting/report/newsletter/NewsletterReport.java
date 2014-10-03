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

package com.liferay.content.targeting.report.newsletter;

import com.liferay.content.targeting.api.model.BaseReport;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.report.campaign.newsletter.service.NewsletterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Chan
 */
@Component(
	immediate = true, service = Report.class)
public class NewsletterReport extends BaseReport {

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
		return Campaign.class.getName();
	}

	@Override
	public String updateReport(long classPK) {
		try {
			_newsletterLocalService.checkNewsletters();
		}
		catch (Exception e) {
			_log.error(e);
		}

		return StringPool.BLANK;
	}

	@Override
	protected void populateContext(Map<String, Object> context) {
	}

	@Reference
	public void setNewsletterLocalService(
		NewsletterLocalService	newsletterLocalService) {

		_newsletterLocalService = newsletterLocalService;
	}

	NewsletterLocalService _newsletterLocalService;

	private static Log _log = LogFactoryUtil.getLog(
		NewsletterReport.class);

}