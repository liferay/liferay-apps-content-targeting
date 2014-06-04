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

package com.liferay.contenttargeting.rules.scorepoints.service;

import com.liferay.arquillian.container.enrichers.OSGi;
import com.liferay.contenttargeting.service.impl.BaseOsgiTestPlugin;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.util.PortalUtil;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Carlos Sierra Andrés
 */
@RunWith(Arquillian.class)
public class ScorePointsAssignerTest extends BaseOsgiTestPlugin {

	@Before
	public void setUp() throws PortalException, SystemException {
		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		defaultUser = userLocalService.getDefaultUser(defaultCompanyId);
	}

	@Test
	public void testCallUtil() throws SystemException {
		ScorePointLocalServiceUtil.incrementPoints(
			defaultUser.getUserId(), 1, 1);
	}

	private User defaultUser;

	@OSGi private UserLocalService userLocalService;

}