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

package com.liferay.content.targeting.report.user.segment.content.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalServiceUtil;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
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
public class UserSegmentContentReportTest {

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
	public void testUserSegmentContentReport() throws Exception {
		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		UserSegment userSegment = UserSegmentLocalServiceUtil.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);

		int initialUserSegmentContentCount =
			UserSegmentContentLocalServiceUtil.getUserSegmentContentsCount(
				userSegment.getUserSegmentId());

		// Obtain report from registry

		Report report = _reportsRegistry.getReport("UserSegmentContentReport");

		// Test update report without analytics

		ReportInstance reportInstance =
			ReportInstanceLocalServiceUtil.addReportInstance(
				TestPropsValues.getUserId(), report.getReportKey(),
				UserSegment.class.getName(), userSegment.getUserSegmentId(),
				nameMap, null, "type-settings", _serviceContext);

		report.updateReport(reportInstance);

		Assert.assertEquals(
			initialUserSegmentContentCount,
			UserSegmentContentLocalServiceUtil.getUserSegmentContentsCount(
				userSegment.getUserSegmentId()));

		// Add analytics

		AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
			TestPropsValues.getUserId(), 1, JournalArticle.class.getName(), 2,
			UserSegment.class.getName(),
			new long[] {userSegment.getUserSegmentId()}, null, "view",
			"127.0.0.1", "ES", "User Agent", "http://localhost", null,
			_serviceContext);

		// Test update report with analytics

		report.updateReport(reportInstance);

		Assert.assertEquals(
			initialUserSegmentContentCount + 1,
			UserSegmentContentLocalServiceUtil.getUserSegmentContentsCount(
				userSegment.getUserSegmentId()));
	}

	@DeleteAfterTestRun
	private Group _group;

	private ReportsRegistry _reportsRegistry;
	private ServiceContext _serviceContext;

}