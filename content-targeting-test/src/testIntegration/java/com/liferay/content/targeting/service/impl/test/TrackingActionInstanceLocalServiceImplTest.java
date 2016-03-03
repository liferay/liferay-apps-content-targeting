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

package com.liferay.content.targeting.service.impl.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

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
public class TrackingActionInstanceLocalServiceImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		_campaign = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, _serviceContext);
	}

	@Test
	public void testAddAndDeleteTrackingActionInstance() throws Exception {
		int initTrackingActionInstancesCount =
			TrackingActionInstanceLocalServiceUtil.
				getTrackingActionInstancesCount();

		TrackingActionInstance trackingActionInstance =
			TrackingActionInstanceLocalServiceUtil.addTrackingActionInstance(
				TestPropsValues.getUserId(), "tracking-action-key",
				_campaign.getCampaignId(), StringPool.BLANK, null, 1, null,
				null, null, _serviceContext);

		Assert.assertEquals(
			initTrackingActionInstancesCount + 1,
			TrackingActionInstanceLocalServiceUtil.
				getTrackingActionInstancesCount());

		TrackingActionInstanceLocalServiceUtil.deleteTrackingActionInstance(
			trackingActionInstance.getTrackingActionInstanceId());

		Assert.assertEquals(
			initTrackingActionInstancesCount,
			TrackingActionInstanceLocalServiceUtil.
				getTrackingActionInstancesCount());
	}

	@Test
	public void testDeleteCampaign() throws Exception {
		int initTrackingActionInstancesCount =
			TrackingActionInstanceLocalServiceUtil.
				getTrackingActionInstancesCount();

		TrackingActionInstanceLocalServiceUtil.addTrackingActionInstance(
			TestPropsValues.getUserId(), "tracking-action-key",
			_campaign.getCampaignId(), StringPool.BLANK, null, 1, null, null,
			null, _serviceContext);

		CampaignLocalServiceUtil.deleteCampaign(_campaign.getCampaignId());

		Assert.assertEquals(
			initTrackingActionInstancesCount,
			TrackingActionInstanceLocalServiceUtil.
				getTrackingActionInstancesCount());
	}

	private Campaign _campaign;

	@DeleteAfterTestRun
	private Group _group;

	private ServiceContext _serviceContext;

}