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

package com.liferay.content.targeting.report.campaign.tracking.action.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalServiceUtil;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

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
public class CTActionReportTest {

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
	public void testCTActionReport() throws Exception {
		long userId = TestPropsValues.getUserId();

		long campaignId = 1;
		String className = Layout.class.getName();
		long classPK = 2;
		String elementId = "form_id";
		String eventType = "view";

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		// Obtain report from registry

		Report report = _reportsRegistry.getReport("CTActionReport");

		ReportInstance reportInstance =
			ReportInstanceLocalServiceUtil.addReportInstance(
				userId, report.getReportKey(), Campaign.class.getName(),
				campaignId, nameMap, null, "", _serviceContext);

		long reportInstanceId = reportInstance.getReportInstanceId();

		int initialCTActionCount = CTActionLocalServiceUtil.getCTActionsCount(
			reportInstanceId);

		// Add tracking actions

		TrackingActionInstanceLocalServiceUtil.addTrackingActionInstance(
			userId, reportInstanceId, "FormTrackingAction", campaignId,
			"Form alias1", null, -1, elementId, eventType, null,
			_serviceContext);

		TrackingActionInstanceLocalServiceUtil.addTrackingActionInstance(
			userId, reportInstanceId, "PageTrackingAction", campaignId,
			"Page alias1", className, classPK, null, eventType,
			StringPool.BLANK, _serviceContext);

		// Test update report without analytics

		report.updateReport(reportInstance);

		Assert.assertEquals(
			initialCTActionCount,
			CTActionLocalServiceUtil.getCTActionsCount(reportInstanceId));

		// Add analytics

		AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
			userId, 1, null, -1, UserSegment.class.getName(), new long[] {1},
			elementId, eventType, "127.0.0.1", "ES", "User Agent",
			"http://localhost", null, _serviceContext);

		AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
			userId, 1, className, classPK, UserSegment.class.getName(),
			new long[] {1}, null, eventType, "127.0.0.1", "ES", "User Agent",
			"http://localhost", null, _serviceContext);

		Assert.assertEquals(
			initialCTActionCount,
			CTActionLocalServiceUtil.getCTActionsCount(reportInstanceId));

		// Test update report with analytics

		report.updateReport(reportInstance);

		Assert.assertEquals(
			initialCTActionCount + 2,
			CTActionLocalServiceUtil.getCTActionsCount(reportInstanceId));

		ReportInstanceLocalServiceUtil.deleteReportInstance(reportInstanceId);
	}

	@DeleteAfterTestRun
	private Group _group;

	private ReportsRegistry _reportsRegistry;
	private ServiceContext _serviceContext;

}