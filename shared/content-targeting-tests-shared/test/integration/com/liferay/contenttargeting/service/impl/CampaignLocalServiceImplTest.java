/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service.impl;

import com.liferay.arquillian.container.enrichers.OSGi;
import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.service.CampaignLocalService;
import com.liferay.contenttargeting.tests.util.TestUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class CampaignLocalServiceImplTest extends BaseOsgiTestPlugin {

	@Test
	public void fetchCurrentMaxPriorityCampaign() throws Exception {
		Group group = TestUtil.addGroup();

		ServiceContext serviceContext = TestUtil.getServiceContext(
			group.getGroupId(), TestUtil.getUserId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		Date now = new Date();

		long[] userSegmentIds = new long[] {1, 2};

		Campaign campaign1 = _campaignLocalService.addCampaign(
			TestUtil.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 1, true, userSegmentIds, serviceContext);
		Campaign campaign2 = _campaignLocalService.addCampaign(
			TestUtil.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 2, true, userSegmentIds, serviceContext);
		Campaign campaign3 = _campaignLocalService.addCampaign(
			TestUtil.getUserId(), nameMap, null, getDate(now, -1),
			getDate(now, 1), 1, false, userSegmentIds, serviceContext);
		Campaign campaign4 = _campaignLocalService.addCampaign(
			TestUtil.getUserId(), nameMap, null, getDate(now, -2),
			getDate(now, -1), 1, true, userSegmentIds, serviceContext);

		Campaign currentMaxPriorityCampaign =
			_campaignLocalService.fetchCurrentMaxPriorityCampaign(
				new long[] {group.getGroupId()}, userSegmentIds);

		Assert.assertEquals(
			campaign1.getCampaignId(),
			currentMaxPriorityCampaign.getCampaignId());
	}

	@Test
	public void testAddAndDeleteCampaign() throws Exception {
		Group group = TestUtil.addGroup();

		int initCampaignsCount = _campaignLocalService.getCampaignsCount(
			group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		ServiceContext serviceContext = TestUtil.getServiceContext(
			group.getGroupId(), TestUtil.getUserId());

		Campaign campaign = _campaignLocalService.addCampaign(
			TestUtil.getUserId(), nameMap, null, new Date(), new Date(), 1,
			true, new long[] {1, 2}, serviceContext);

		Assert.assertEquals(
			initCampaignsCount + 1,
			_campaignLocalService.getCampaignsCount(group.getGroupId()));

		_campaignLocalService.deleteCampaign(campaign.getCampaignId());

		Assert.assertEquals(
			initCampaignsCount,
			_campaignLocalService.getCampaignsCount(group.getGroupId()));
	}

	protected Date getDate(Date date, int amount) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.HOUR, amount);

		return calendar.getTime();
	}

	@OSGi private CampaignLocalService _campaignLocalService;

}