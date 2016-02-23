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

package com.liferay.content.targeting.service.impl;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalService;
import com.liferay.portal.service.ServiceContext;

import java.util.Calendar;
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
public class CampaignLocalServiceImplTest {

	@Before
	public void setUp() {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, _bundle.getBundleContext());
		_groupLocalService = ServiceTrackerUtil.getService(
			GroupLocalService.class, _bundle.getBundleContext());
	}

	@Test
	public void testAddAndDeleteCampaign() throws Exception {
		Group group = GroupTestUtil.addGroup();

		int initCampaignsCount = _campaignLocalService.getCampaignsCount(
			group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		Campaign campaign = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, serviceContext);

		Assert.assertEquals(
			initCampaignsCount + 1,
			_campaignLocalService.getCampaignsCount(group.getGroupId()));

		_campaignLocalService.deleteCampaign(campaign.getCampaignId());

		Assert.assertEquals(
			initCampaignsCount,
			_campaignLocalService.getCampaignsCount(group.getGroupId()));
	}

	@Test
	public void testDeleteGroup() throws Exception {
		Group group = GroupTestUtil.addGroup();

		int initUserSegmentsCount = _campaignLocalService.getCampaignsCount(
			group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		_campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, serviceContext);

		_groupLocalService.deleteGroup(group.getGroupId());

		Assert.assertEquals(
			initUserSegmentsCount,
			_campaignLocalService.getCampaignsCount(group.getGroupId()));
	}

	@Test
	public void testFetchCurrentMaxPriorityCampaign() throws Exception {
		Group group = GroupTestUtil.addGroup();

		ServiceContext serviceContext =
			ServiceTestUtil.getServiceContext(
				group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		Date now = new Date();

		long[] userSegmentIds = new long[] {1, 2};

		Campaign campaign1 = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 1, true, userSegmentIds, serviceContext);
		Campaign campaign2 = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 2, true, userSegmentIds, serviceContext);
		Campaign campaign3 = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 1, false, userSegmentIds, serviceContext);
		Campaign campaign4 = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, getDate(now, -2),
			getDate(now, -1), 1, true, userSegmentIds, serviceContext);

		Campaign currentMaxPriorityCampaign =
			_campaignLocalService.fetchCurrentMaxPriorityCampaign(
				new long[] {group.getGroupId()}, userSegmentIds);

		Assert.assertEquals(
			campaign1.getCampaignId(),
			currentMaxPriorityCampaign.getCampaignId());
	}

	@Test
	public void testGetNameWithGroupName() throws Exception {
		Group group = GroupTestUtil.addGroup();
		Group anotherGroup = GroupTestUtil.addGroup();

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		Campaign campaign = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, serviceContext);

		String nameWithGroupName = campaign.getNameWithGroupName(
			serviceContext.getLocale(), anotherGroup.getGroupId());

		Assert.assertTrue(
			nameWithGroupName.contains(
				campaign.getName(LocaleUtil.getDefault())));

		Assert.assertTrue(
			nameWithGroupName.contains(
				group.getDescriptiveName(LocaleUtil.getDefault())));
	}

	protected Date getDate(Date date, int amount) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.HOUR, amount);

		return calendar.getTime();
	}

	@ArquillianResource
	private Bundle _bundle;

	private CampaignLocalService _campaignLocalService;
	private GroupLocalService _groupLocalService;

}