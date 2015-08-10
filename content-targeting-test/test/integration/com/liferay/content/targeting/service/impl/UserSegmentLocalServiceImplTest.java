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

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalService;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalService;

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
 * @author Carlos Sierra Andrés
 */
@RunWith(Arquillian.class)
public class UserSegmentLocalServiceImplTest {

	@Before
	public void setUp() {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_assetCategoryLocalService = ServiceTrackerUtil.getService(
			AssetCategoryLocalService.class, _bundle.getBundleContext());
		_groupLocalService = ServiceTrackerUtil.getService(
			GroupLocalService.class, _bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, _bundle.getBundleContext());
	}

	@Test
	public void testAddAndDeleteUserSegment() throws Exception {
		Group group = GroupTestUtil.addGroup();

		int initUserSegmentsCount =
			_userSegmentLocalService.getUserSegmentsCount(group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		UserSegment userSegment = _userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, serviceContext);

		Assert.assertEquals(
			initUserSegmentsCount + 1,
			_userSegmentLocalService.getUserSegmentsCount(group.getGroupId()));

		AssetCategory assetCategory =
			_assetCategoryLocalService.fetchAssetCategory(
				userSegment.getAssetCategoryId());

		Assert.assertNotNull(assetCategory);

		_userSegmentLocalService.deleteUserSegment(
			userSegment.getUserSegmentId());

		Assert.assertEquals(
			initUserSegmentsCount,
			_userSegmentLocalService.getUserSegmentsCount(group.getGroupId()));

		assetCategory = _assetCategoryLocalService.fetchAssetCategory(
			userSegment.getAssetCategoryId());

		Assert.assertNull(assetCategory);
	}

	@Test
	public void testDeleteGroup() throws Exception {
		Group group = GroupTestUtil.addGroup();

		int initUserSegmentsCount =
			_userSegmentLocalService.getUserSegmentsCount(group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		_userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, serviceContext);

		_groupLocalService.deleteGroup(group.getGroupId());

		Assert.assertEquals(
			initUserSegmentsCount,
			_userSegmentLocalService.getUserSegmentsCount(group.getGroupId()));
	}

	@Test
	public void testGetNameWithGroup() throws Exception {
		Group group = GroupTestUtil.addGroup();
		Group anotherGroup = GroupTestUtil.addGroup();

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		UserSegment userSegment = _userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, serviceContext);

		String nameWithGroupName = userSegment.getNameWithGroupName(
			serviceContext.getLocale(), anotherGroup.getGroupId());

		Assert.assertTrue(
			nameWithGroupName.contains(
				userSegment.getName(LocaleUtil.getDefault())));

		Assert.assertTrue(
			nameWithGroupName.contains(
				group.getDescriptiveName(LocaleUtil.getDefault())));
	}

	private AssetCategoryLocalService _assetCategoryLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private GroupLocalService _groupLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}