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
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
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
 * @author Carlos Sierra Andrés
 */
@RunWith(Arquillian.class)
public class UserSegmentLocalServiceImplTest {

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
	public void testAddAndDeleteUserSegment() throws Exception {
		int initUserSegmentsCount =
			UserSegmentLocalServiceUtil.getUserSegmentsCount(
				_group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		UserSegment userSegment = UserSegmentLocalServiceUtil.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);

		Assert.assertEquals(
			initUserSegmentsCount + 1,
			UserSegmentLocalServiceUtil.getUserSegmentsCount(
				_group.getGroupId()));

		AssetCategory assetCategory =
			AssetCategoryLocalServiceUtil.fetchAssetCategory(
				userSegment.getAssetCategoryId());

		Assert.assertNotNull(assetCategory);

		UserSegmentLocalServiceUtil.deleteUserSegment(
			userSegment.getUserSegmentId());

		Assert.assertEquals(
			initUserSegmentsCount,
			UserSegmentLocalServiceUtil.getUserSegmentsCount(
				_group.getGroupId()));

		assetCategory = AssetCategoryLocalServiceUtil.fetchAssetCategory(
			userSegment.getAssetCategoryId());

		Assert.assertNull(assetCategory);
	}

	@Test
	public void testDeleteGroup() throws Exception {
		Group group = GroupTestUtil.addGroup();

		int initUserSegmentsCount =
			UserSegmentLocalServiceUtil.getUserSegmentsCount(
				group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				group.getGroupId(), TestPropsValues.getUserId());

		UserSegmentLocalServiceUtil.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, serviceContext);

		GroupLocalServiceUtil.deleteGroup(group.getGroupId());

		Assert.assertEquals(
			initUserSegmentsCount,
			UserSegmentLocalServiceUtil.getUserSegmentsCount(
				group.getGroupId()));
	}

	@Test
	public void testGetNameWithGroup() throws Exception {
		Group anotherGroup = GroupTestUtil.addGroup();

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		UserSegment userSegment = UserSegmentLocalServiceUtil.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);

		String nameWithGroupName = userSegment.getNameWithGroupName(
			_serviceContext.getLocale(), anotherGroup.getGroupId());

		Assert.assertTrue(
			nameWithGroupName.contains(
				userSegment.getName(LocaleUtil.getDefault())));

		Assert.assertTrue(
			nameWithGroupName.contains(
				_group.getDescriptiveName(LocaleUtil.getDefault())));

		GroupLocalServiceUtil.deleteGroup(anotherGroup);
	}

	@DeleteAfterTestRun
	private Group _group;

	private ServiceContext _serviceContext;

}