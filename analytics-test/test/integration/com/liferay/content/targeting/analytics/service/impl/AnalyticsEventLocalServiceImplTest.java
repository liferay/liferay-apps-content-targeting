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

package com.liferay.content.targeting.analytics.service.impl;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.service.test.util.TestUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portlet.journal.model.JournalArticle;

import java.util.Date;

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
public class AnalyticsEventLocalServiceImplTest {

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
	}

	@Test
	public void testAddAndDeleteAnalyticsEvent() throws Exception {
		int initAnalyticsEventsCount =
			_analyticsEventLocalService.getAnalyticsEventsCount();

		AnalyticsEvent analyticsEvent =
			_analyticsEventLocalService.addAnalyticsEvent(
				1, 1, JournalArticle.class.getName(), 1, Layout.class.getName(),
				1, null, "view", "127.0.0.1", "User Agent", "ES",
				"http://localhost", null, TestUtil.getServiceContext());

		Assert.assertEquals(
			initAnalyticsEventsCount + 1,
			_analyticsEventLocalService.getAnalyticsEventsCount());

		_analyticsEventLocalService.deleteAnalyticsEvent(analyticsEvent);

		Assert.assertEquals(
			initAnalyticsEventsCount,
			_analyticsEventLocalService.getAnalyticsEventsCount());
	}

	@Test
	public void testAddAndDeleteAnalyticsEvents() throws Exception {
		int initAnalyticsEventsCount =
			_analyticsEventLocalService.getAnalyticsEventsCount();

		_analyticsEventLocalService.addAnalyticsEvent(
			1, 1, JournalArticle.class.getName(), 1, Layout.class.getName(),
			new long[] {1, 2}, null, "view", "127.0.0.1", "User Agent",
			"ES", "http://localhost", StringPool.BLANK,
			TestUtil.getServiceContext());

		Assert.assertEquals(
			initAnalyticsEventsCount + 2,
			_analyticsEventLocalService.getAnalyticsEventsCount());

		Thread.sleep(1000);

		_analyticsEventLocalService.deleteAnalyticsEvents(
			TestUtil.getCompanyId(), new Date());

		Assert.assertEquals(
			0, _analyticsEventLocalService.getAnalyticsEventsCount());
	}

	private AnalyticsEventLocalService _analyticsEventLocalService;

	@ArquillianResource
	private Bundle _bundle;

}