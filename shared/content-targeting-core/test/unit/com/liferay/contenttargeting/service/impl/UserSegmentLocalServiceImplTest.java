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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Carlos Sierra Andrés
 */
@RunWith(Arquillian.class)
public class UserSegmentLocalServiceImplTest extends BaseOsgiTestPlugin {

	@Before
	public void setUp() throws PortalException, SystemException {
		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		defaultUser = userLocalService.getDefaultUser(defaultCompanyId);
	}

	@Test
	public void testAddUserSegment() throws Exception {
		int initUserSegmentsCount =
			userSegmentLocalService.getUserSegmentsCount();

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		UserSegment userSegment = userSegmentLocalService.addUserSegment(
			defaultUser.getUserId(), nameMap, null, new ServiceContext());

		Assert.assertEquals(
			initUserSegmentsCount + 1,
			userSegmentLocalService.getUserSegmentsCount());

		AssetCategory assetCategory =
			assetCategoryLocalService.fetchAssetCategory(
				userSegment.getAssetCategoryId());

		Assert.assertNotNull(assetCategory);

		userSegmentLocalService.deleteUserSegment(
			userSegment.getUserSegmentId());

		Assert.assertEquals(
			initUserSegmentsCount,
			userSegmentLocalService.getUserSegmentsCount());
	}

	private User defaultUser;

	@OSGi private AssetCategoryLocalService assetCategoryLocalService;
	@OSGi private UserLocalService userLocalService;
	@OSGi private UserSegmentLocalService userSegmentLocalService;

}