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
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.Calendar;
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
public class CampaignLocalServiceImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), TestPropsValues.getUserId());
	}

	@Test
	public void testAddAndDeleteCampaign() throws Exception {
		int initCampaignsCount = CampaignLocalServiceUtil.getCampaignsCount(
			_group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		Campaign campaign = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, _serviceContext);

		Assert.assertEquals(
			initCampaignsCount + 1,
			CampaignLocalServiceUtil.getCampaignsCount(_group.getGroupId()));

		CampaignLocalServiceUtil.deleteCampaign(campaign.getCampaignId());

		Assert.assertEquals(
			initCampaignsCount,
			CampaignLocalServiceUtil.getCampaignsCount(_group.getGroupId()));
	}

	@Test
	public void testDeleteGroup() throws Exception {
		Group group = GroupTestUtil.addGroup();

		int initUserSegmentsCount = CampaignLocalServiceUtil.getCampaignsCount(
			group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				group.getGroupId(), TestPropsValues.getUserId());

		CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, serviceContext);

		GroupLocalServiceUtil.deleteGroup(group.getGroupId());

		Assert.assertEquals(
			initUserSegmentsCount,
			CampaignLocalServiceUtil.getCampaignsCount(group.getGroupId()));
	}

	@Test
	public void testFetchCurrentMaxPriorityCampaign() throws Exception {
		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		Date now = new Date();

		long[] userSegmentIds = new long[] {1, 2};

		Campaign campaign1 = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 1, true, userSegmentIds, _serviceContext);
		Campaign campaign2 = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 2, true, userSegmentIds, _serviceContext);
		Campaign campaign3 = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 1, false, userSegmentIds, _serviceContext);
		Campaign campaign4 = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, getDate(now, -2),
			getDate(now, -1), 1, true, userSegmentIds, _serviceContext);

		Campaign currentMaxPriorityCampaign =
			CampaignLocalServiceUtil.fetchCurrentMaxPriorityCampaign(
				new long[] {_group.getGroupId()}, userSegmentIds);

		Assert.assertEquals(
			campaign1.getCampaignId(),
			currentMaxPriorityCampaign.getCampaignId());
	}

	@Test
	public void testGetNameWithGroupName() throws Exception {
		Group anotherGroup = GroupTestUtil.addGroup();

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		Campaign campaign = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, _serviceContext);

		String nameWithGroupName = campaign.getNameWithGroupName(
			_serviceContext.getLocale(), anotherGroup.getGroupId());

		Assert.assertTrue(
			nameWithGroupName.contains(
				campaign.getName(LocaleUtil.getDefault())));

		Assert.assertTrue(
			nameWithGroupName.contains(
				_group.getDescriptiveName(LocaleUtil.getDefault())));

		GroupLocalServiceUtil.deleteGroup(anotherGroup);
	}

	protected Date getDate(Date date, int amount) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.HOUR, amount);

		return calendar.getTime();
	}

	@DeleteAfterTestRun
	private Group _group;

	private ServiceContext _serviceContext;

}