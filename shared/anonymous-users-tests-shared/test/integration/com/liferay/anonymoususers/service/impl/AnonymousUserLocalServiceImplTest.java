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

package com.liferay.anonymoususers.service.impl;

import com.liferay.anonymoususers.service.AnonymousUserLocalService;
import com.liferay.anonymoususers.tests.util.TestUtil;
import com.liferay.arquillian.container.enrichers.OSGi;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class AnonymousUserLocalServiceImplTest extends BaseOsgiTestPlugin {

	@Test
	public void testAddAnonymousUser() throws Exception {
		int initAnonymousUsersCount =
			_anonymousUserLocalService.getAnonymousUsersCount();

		ServiceContext serviceContext = TestUtil.getServiceContext();

		_anonymousUserLocalService.addAnonymousUser(
			1, "127.0.0.1", StringPool.BLANK, serviceContext);

		Assert.assertEquals(
			initAnonymousUsersCount + 1,
			_anonymousUserLocalService.getAnonymousUsersCount());
	}

	@OSGi private AnonymousUserLocalService _anonymousUserLocalService;

}