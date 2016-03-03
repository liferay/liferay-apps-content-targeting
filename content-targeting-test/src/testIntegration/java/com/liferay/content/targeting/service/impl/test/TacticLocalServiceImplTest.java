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
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.LocaleUtil;
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
 * @author Pavel Savinov
 */
@RunWith(Arquillian.class)
public class TacticLocalServiceImplTest {

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
	public void testAddAndDeleteTactic() throws Exception {
		Map<Locale, String> campaignNameMap = new HashMap<>();

		campaignNameMap.put(LocaleUtil.getDefault(), "test-campaign");

		Campaign campaign = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), campaignNameMap, null, new Date(),
			new Date(), 1, true, new long[] {1, 2}, _serviceContext);

		int initTacticsCount = TacticLocalServiceUtil.getTacticsCount(
			campaign.getCampaignId());

		Map<Locale, String> tacticNameMap = new HashMap<>();

		tacticNameMap.put(LocaleUtil.getDefault(), "test-tactic");

		Tactic tactic = TacticLocalServiceUtil.addTactic(
			TestPropsValues.getUserId(), campaign.getCampaignId(),
			tacticNameMap, null, new long[] {1, 2, 3}, _serviceContext);

		Assert.assertEquals(
			initTacticsCount + 1,
			TacticLocalServiceUtil.getTacticsCount(campaign.getCampaignId()));

		TacticLocalServiceUtil.deleteTactic(tactic.getTacticId());

		Assert.assertEquals(
			initTacticsCount,
			TacticLocalServiceUtil.getTacticsCount(campaign.getCampaignId()));
	}

	@Test
	public void testDeleteCampaign() throws Exception {
		Map<Locale, String> campaignNameMap = new HashMap<>();

		campaignNameMap.put(LocaleUtil.getDefault(), "test-campaign");

		Campaign campaign = CampaignLocalServiceUtil.addCampaign(
			TestPropsValues.getUserId(), campaignNameMap, null, new Date(),
			new Date(), 1, true, new long[] {1, 2}, _serviceContext);

		int initTacticsCount = TacticLocalServiceUtil.getTacticsCount(
			campaign.getCampaignId());

		Map<Locale, String> tacticNameMap = new HashMap<>();

		tacticNameMap.put(LocaleUtil.getDefault(), "test-tactic");

		TacticLocalServiceUtil.addTactic(
			TestPropsValues.getUserId(), campaign.getCampaignId(),
			tacticNameMap, null, new long[] {1, 2, 3}, _serviceContext);

		CampaignLocalServiceUtil.deleteCampaign(campaign.getCampaignId());

		Assert.assertEquals(
			initTacticsCount,
			TacticLocalServiceUtil.getTacticsCount(campaign.getCampaignId()));
	}

	@DeleteAfterTestRun
	private Group _group;

	private ServiceContext _serviceContext;

}