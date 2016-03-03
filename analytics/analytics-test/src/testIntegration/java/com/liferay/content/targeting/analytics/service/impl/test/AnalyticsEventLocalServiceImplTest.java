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

package com.liferay.content.targeting.analytics.service.impl.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.Date;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class AnalyticsEventLocalServiceImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testAddAndDeleteAnalyticsEvent() throws Exception {
		int initAnalyticsEventsCount =
			AnalyticsEventLocalServiceUtil.getAnalyticsEventsCount();
		int initAnalyticsReferrersCount =
			AnalyticsReferrerLocalServiceUtil.getAnalyticsReferrersCount();

		AnalyticsEvent analyticsEvent =
			AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
				1, 1, JournalArticle.class.getName(), 1, Layout.class.getName(),
				new long[] {1}, null, "view", "127.0.0.1", "User Agent", "ES",
				"http://localhost", null,
				ServiceContextTestUtil.getServiceContext());

		Assert.assertEquals(
			initAnalyticsEventsCount + 1,
			AnalyticsEventLocalServiceUtil.getAnalyticsEventsCount());

		Assert.assertEquals(
			initAnalyticsReferrersCount + 1,
			AnalyticsReferrerLocalServiceUtil.getAnalyticsReferrersCount());

		AnalyticsEventLocalServiceUtil.deleteAnalyticsEvent(analyticsEvent);

		Assert.assertEquals(
			initAnalyticsEventsCount,
			AnalyticsEventLocalServiceUtil.getAnalyticsEventsCount());

		Assert.assertEquals(
			initAnalyticsReferrersCount,
			AnalyticsReferrerLocalServiceUtil.getAnalyticsReferrersCount());
	}

	@Test
	public void testAddAndDeleteAnalyticsEvents() throws Exception {
		int initAnalyticsEventsCount =
			AnalyticsEventLocalServiceUtil.getAnalyticsEventsCount();
		int initAnalyticsReferrersCount =
			AnalyticsReferrerLocalServiceUtil.getAnalyticsReferrersCount();

		AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
			1, 1, JournalArticle.class.getName(), 1, Layout.class.getName(),
			new long[] {1, 2}, null, "view", "127.0.0.1", "User Agent", "ES",
			"http://localhost", StringPool.BLANK,
			ServiceContextTestUtil.getServiceContext());

		Assert.assertEquals(
			initAnalyticsEventsCount + 1,
			AnalyticsEventLocalServiceUtil.getAnalyticsEventsCount());

		Assert.assertEquals(
			initAnalyticsReferrersCount + 2,
			AnalyticsReferrerLocalServiceUtil.getAnalyticsReferrersCount());

		Thread.sleep(1000);

		AnalyticsEventLocalServiceUtil.deleteAnalyticsEvents(
			TestPropsValues.getCompanyId(), new Date());

		Assert.assertEquals(
			0, AnalyticsEventLocalServiceUtil.getAnalyticsEventsCount());

		Assert.assertEquals(
			0, AnalyticsReferrerLocalServiceUtil.getAnalyticsReferrersCount());
	}

}