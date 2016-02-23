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
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.ChannelInstanceLocalService;
import com.liferay.content.targeting.service.TacticLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.service.ServiceContext;

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
 * @author Pavel Savinov
 */
@RunWith(Arquillian.class)
public class ChannelInstanceLocalServiceImplTest {

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
		_channelInstanceLocalService = ServiceTrackerUtil.getService(
			ChannelInstanceLocalService.class, _bundle.getBundleContext());
		_tacticLocalService = ServiceTrackerUtil.getService(
			TacticLocalService.class, _bundle.getBundleContext());
	}

	@Test
	public void testAddAndDeleteChannelInstance() throws Exception {
		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			TestPropsValues.getGroupId(), TestPropsValues.getUserId());

		Tactic tactic = createTactic();

		int initChannelInstanceCount =
			_channelInstanceLocalService.getChannelInstances(
				tactic.getTacticId()).size();

		ChannelInstance channelInstance =
			_channelInstanceLocalService.addChannelInstance(
			TestPropsValues.getUserId(), tactic.getTacticId(), "test-channel",
			tactic.getCampaignId(), "test-channel", "{}",
			serviceContext);

		Assert.assertEquals(
			initChannelInstanceCount + 1,
			_channelInstanceLocalService.getChannelInstances(
				tactic.getTacticId()).size());

		_channelInstanceLocalService.deleteChannelInstance(
			channelInstance.getChannelInstanceId());

		Assert.assertEquals(
			initChannelInstanceCount,
			_channelInstanceLocalService.getChannelInstances(
				tactic.getTacticId()).size());

		_tacticLocalService.deleteTactic(tactic.getTacticId());
	}

	@Test
	public void testDeleteTactic() throws Exception {
		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			TestPropsValues.getGroupId(), TestPropsValues.getUserId());

		Tactic tactic = createTactic();

		int initChannelInstanceCount =
			_channelInstanceLocalService.getChannelInstances(
				tactic.getTacticId()).size();

		_channelInstanceLocalService.addChannelInstance(
			TestPropsValues.getUserId(), tactic.getTacticId(), "test-channel",
			tactic.getCampaignId(), "test-channel", "{}",
			serviceContext);

		Assert.assertEquals(
			initChannelInstanceCount + 1,
			_channelInstanceLocalService.getChannelInstances(
				tactic.getTacticId()).size());

		_tacticLocalService.deleteTactic(tactic.getTacticId());

		Assert.assertEquals(
			initChannelInstanceCount,
			_channelInstanceLocalService.getChannelInstances(
				tactic.getTacticId()).size());
	}

	protected Tactic createTactic() throws Exception {
		Map<Locale, String> campaignNameMap = new HashMap<Locale, String>();

		campaignNameMap.put(LocaleUtil.getDefault(), "test-campaign");

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			TestPropsValues.getGroupId(), TestPropsValues.getUserId());

		Campaign campaign = _campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), campaignNameMap, null, new Date(),
			new Date(), 1, true, new long[] {1, 2},
			serviceContext);

		Map<Locale, String> tacticNameMap = new HashMap<Locale, String>();

		tacticNameMap.put(LocaleUtil.getDefault(), "test-tactic");

		Tactic tactic = _tacticLocalService.addTactic(
			TestPropsValues.getUserId(), campaign.getCampaignId(),
			tacticNameMap, null, new long[] {1, 2, 3}, serviceContext);

		return tactic;
	}

	@ArquillianResource
	private Bundle _bundle;

	private CampaignLocalService _campaignLocalService;
	private ChannelInstanceLocalService _channelInstanceLocalService;
	private TacticLocalService _tacticLocalService;

}