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

package com.liferay.content.targeting.rule.score.points.messaging.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.blogs.kernel.model.BlogsEntry;
import com.liferay.blogs.kernel.service.BlogsEntryLocalServiceUtil;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.score.points.api.model.ScorePointsAssigner;
import com.liferay.content.targeting.rule.score.points.service.ScorePointLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
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
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

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
public class DefaultScorePointsAssignerImplTest {

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

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		_userSegment = UserSegmentLocalServiceUtil.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);

		Registry registry = RegistryUtil.getRegistry();

		_scorePointsAssigner = registry.getService(ScorePointsAssigner.class);
	}

	@Test
	public void testAssignPoints() throws Exception {
		int initialScorePointsCount =
			ScorePointLocalServiceUtil.getScorePointsCount();

		BlogsEntry entry = BlogsEntryLocalServiceUtil.addEntry(
			TestPropsValues.getUserId(), "title", StringPool.BLANK,
			"This is a blog entry for testing purposes", 1, 1, 1965, 0, 0, true,
			true, null, false, null, null, null, _serviceContext);

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
			BlogsEntry.class.getName(), entry.getEntryId());

		AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(
			assetEntry.getEntryId(), _userSegment.getAssetCategoryId());

		AnonymousUser anonymousUser =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				1, "127.0.0.1", StringPool.BLANK, _serviceContext);

		_scorePointsAssigner.assignPoints(
			_serviceContext.getScopeGroupId(),
			anonymousUser.getAnonymousUserId(), assetEntry.getClassName(),
			assetEntry.getClassPK());

		Assert.assertEquals(
			initialScorePointsCount + 1,
			ScorePointLocalServiceUtil.getScorePointsCount());
	}

	@DeleteAfterTestRun
	private Group _group;

	private ScorePointsAssigner _scorePointsAssigner;
	private ServiceContext _serviceContext;
	private UserSegment _userSegment;

}