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
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.tests.util.TestUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Carlos Sierra Andrés
 */
@RunWith(Arquillian.class)
public class UserSegmentLocalServiceImplTest extends BaseOsgiTestPlugin {

	@Test
	public void testAddAndDeleteUserSegment() throws Exception {
		Group group = TestUtil.addGroup();

		int initUserSegmentsCount =
			_userSegmentLocalService.getUserSegmentsCount(group.getGroupId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		ServiceContext serviceContext = TestUtil.getServiceContext(
			group.getGroupId(), TestUtil.getUserId());

		UserSegment userSegment = _userSegmentLocalService.addUserSegment(
			TestUtil.getUserId(), nameMap, null, serviceContext);

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
	}

	@OSGi private AssetCategoryLocalService _assetCategoryLocalService;
	@OSGi private UserSegmentLocalService _userSegmentLocalService;

}