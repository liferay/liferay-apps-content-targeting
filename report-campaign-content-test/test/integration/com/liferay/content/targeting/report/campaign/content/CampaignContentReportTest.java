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

package com.liferay.content.targeting.report.campaign.content;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.report.campaign.content.service.CampaignContentLocalService;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.journal.model.JournalArticle;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class CampaignContentReportTest {

	@Before
	public void setUp() {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, _bundle.getBundleContext());
		_campaignContentLocalService = ServiceTrackerUtil.getService(
			CampaignContentLocalService.class, _bundle.getBundleContext());
		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, _bundle.getBundleContext());
		_reportInstanceLocalService = ServiceTrackerUtil.getService(
			ReportInstanceLocalService.class, _bundle.getBundleContext());
		_reportsRegistry = ServiceTrackerUtil.getService(
			ReportsRegistry.class, _bundle.getBundleContext());
	}

	@Test
	public void testCampaignContentReport() throws Exception {
		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		Campaign campaign = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, serviceContext);

		int initialCampaignContentCount =
			_campaignContentLocalService.getCampaignContentsCount(
				campaign.getCampaignId());

		// Obtain report from registry

		Report report = _reportsRegistry.getReport("CampaignContentReport");

		// Test update report without analytics

		ReportInstance reportInstance =
			_reportInstanceLocalService.addReportInstance(
				TestPropsValues.getUserId(), report.getReportKey(),
				Campaign.class.getName(), campaign.getCampaignId(), nameMap,
				null, "type-settings", serviceContext);

		report.updateReport(reportInstance);

		Assert.assertEquals(
			initialCampaignContentCount,
			_campaignContentLocalService.getCampaignContentsCount(
				campaign.getCampaignId()));

		// Add analytics

		_analyticsEventLocalService.addAnalyticsEvent(
			TestPropsValues.getUserId(), 1, JournalArticle.class.getName(), 2,
			Campaign.class.getName(), new long[] {campaign.getCampaignId()},
			null, "view", "127.0.0.1", "ES", "User Agent", "http://localhost",
			null, serviceContext);

		// Test update report with analytics

		report.updateReport(reportInstance);

		Assert.assertEquals(
			initialCampaignContentCount + 1,
			_campaignContentLocalService.getCampaignContentsCount(
				campaign.getCampaignId()));
	}

	private AnalyticsEventLocalService _analyticsEventLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private CampaignContentLocalService
		_campaignContentLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;
	private ReportsRegistry _reportsRegistry;

}