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

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalService;
import com.liferay.content.targeting.report.user.segment.content.test.util.TestUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.journal.model.JournalArticle;

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
public class UserSegmentContentReportTest {

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
		_userSegmentContentLocalService = ServiceTrackerUtil.getService(
			UserSegmentContentLocalService.class, _bundle.getBundleContext());
		_reportsRegistry = ServiceTrackerUtil.getService(
			ReportsRegistry.class, _bundle.getBundleContext());
	}

	@Test
	public void testUserSegmentContentReport() throws Exception {
		ServiceContext serviceContext = TestUtil.getServiceContext();

		long userSegmentId = 6;

		int initialUserSegmentContentCount =
			_userSegmentContentLocalService.getUserSegmentContentsCount(
				userSegmentId);

		// Obtain report from registry

		Report report = _reportsRegistry.getReport("UserSegmentContentReport");

		// Test update report without analytics

		report.updateReport(userSegmentId);

		Assert.assertEquals(
			initialUserSegmentContentCount,
			_userSegmentContentLocalService.getUserSegmentContentsCount(
				userSegmentId));

		// Add analytics

		_analyticsEventLocalService.addAnalyticsEvent(
			TestUtil.getUserId(), 1, JournalArticle.class.getName(), 2,
			UserSegment.class.getName(), userSegmentId, null, "view",
			"127.0.0.1", "ES", "User Agent", "http://localhost", null,
			serviceContext);

		// Test update report with analytics

		report.updateReport(userSegmentId);

		Assert.assertEquals(
			initialUserSegmentContentCount + 1,
			_userSegmentContentLocalService.getUserSegmentContentsCount(
				userSegmentId));
	}

	private AnalyticsEventLocalService _analyticsEventLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private ReportsRegistry _reportsRegistry;
	private UserSegmentContentLocalService
		_userSegmentContentLocalService;

}