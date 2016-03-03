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

package com.liferay.content.targeting.report.campaign.content.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.report.campaign.content.service.CampaignContentLocalServiceUtil;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class CampaignContentReportTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), TestPropsValues.getUserId());

		Registry registry = RegistryUtil.getRegistry();

		_reportsRegistry = registry.getService(ReportsRegistry.class);
	}

	@Test
	public void testCampaignContentReport() throws Exception {
		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		Campaign campaign = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, _serviceContext);

		int initialCampaignContentCount =
			CampaignContentLocalServiceUtil.getCampaignContentsCount(
				campaign.getCampaignId());

		// Obtain report from registry

		Report report = _reportsRegistry.getReport("CampaignContentReport");

		// Test update report without analytics

		ReportInstance reportInstance =
			ReportInstanceLocalServiceUtil.addReportInstance(
				TestPropsValues.getUserId(), report.getReportKey(),
				Campaign.class.getName(), campaign.getCampaignId(), nameMap,
				null, "type-settings", _serviceContext);

		report.updateReport(reportInstance);

		Assert.assertEquals(
			initialCampaignContentCount,
			CampaignContentLocalServiceUtil.getCampaignContentsCount(
				campaign.getCampaignId()));

		// Add analytics

		AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
			TestPropsValues.getUserId(), 1, JournalArticle.class.getName(), 2,
			Campaign.class.getName(), new long[] {campaign.getCampaignId()},
			null, "view", "127.0.0.1", "ES", "User Agent", "http://localhost",
			null, _serviceContext);

		// Test update report with analytics

		report.updateReport(reportInstance);

		Assert.assertEquals(
			initialCampaignContentCount + 1,
			CampaignContentLocalServiceUtil.getCampaignContentsCount(
				campaign.getCampaignId()));
	}

	@DeleteAfterTestRun
	private Group _group;

	private ReportsRegistry _reportsRegistry;
	private ServiceContext _serviceContext;

}