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
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;

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
public class TrackingActionInstanceLocalServiceImplTest {

	@Before
	public void setUp() throws Exception {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_trackingActionInstanceLocalService = ServiceTrackerUtil.getService(
			TrackingActionInstanceLocalService.class,
			_bundle.getBundleContext());
		_userLocalService = ServiceTrackerUtil.getService(
			UserLocalService.class, _bundle.getBundleContext());
		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, _bundle.getBundleContext());

		Group group = GroupTestUtil.addGroup();

		_serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-campaign");

		_campaign = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {1, 2}, _serviceContext);
	}

	@Test
	public void testAddAndDeleteTrackingActionInstance() throws Exception {
		int initTrackingActionInstancesCount =
			_trackingActionInstanceLocalService.
				getTrackingActionInstancesCount();

		TrackingActionInstance trackingActionInstance =
			_trackingActionInstanceLocalService.addTrackingActionInstance(
				TestPropsValues.getUserId(), "tracking-action-key",
				_campaign.getCampaignId(), StringPool.BLANK, null, 1, null,
				null, null, _serviceContext);

		Assert.assertEquals(
			initTrackingActionInstancesCount + 1,
			_trackingActionInstanceLocalService.
				getTrackingActionInstancesCount());

		_trackingActionInstanceLocalService.deleteTrackingActionInstance(
			trackingActionInstance.getTrackingActionInstanceId());

		Assert.assertEquals(
			initTrackingActionInstancesCount,
			_trackingActionInstanceLocalService.
				getTrackingActionInstancesCount());
	}

	@Test
	public void testDeleteCampaign() throws Exception {
		int initTrackingActionInstancesCount =
			_trackingActionInstanceLocalService.
				getTrackingActionInstancesCount();

		_trackingActionInstanceLocalService.addTrackingActionInstance(
			TestPropsValues.getUserId(), "tracking-action-key",
			_campaign.getCampaignId(), StringPool.BLANK, null, 1, null, null,
			null, _serviceContext);

		_campaignLocalService.deleteCampaign(_campaign.getCampaignId());

		Assert.assertEquals(
			initTrackingActionInstancesCount,
			_trackingActionInstanceLocalService.
				getTrackingActionInstancesCount());
	}

	@ArquillianResource
	private Bundle _bundle;

	private Campaign _campaign;
	private CampaignLocalService _campaignLocalService;
	private ServiceContext _serviceContext;
	private TrackingActionInstanceLocalService
		_trackingActionInstanceLocalService;
	private UserLocalService _userLocalService;

}