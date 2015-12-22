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

package com.liferay.content.targeting.anonymous.users.service.impl;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.content.targeting.service.test.util.UserTestUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;

import java.util.Date;

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
public class AnonymousUserLocalServiceImplTest {

	@Before
	public void setUp() {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_anonymousUserLocalService = ServiceTrackerUtil.getService(
			AnonymousUserLocalService.class, _bundle.getBundleContext());
		_userLocalService = ServiceTrackerUtil.getService(
			UserLocalService.class, _bundle.getBundleContext());
	}

	@Test
	public void testAddAndDeleteAnonymousUser() throws Exception {
		int initAnonymousUsersCount =
			_anonymousUserLocalService.getAnonymousUsersCount();

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				1, "127.0.0.1", StringPool.BLANK, serviceContext);

		Assert.assertEquals(
			initAnonymousUsersCount + 1,
			_anonymousUserLocalService.getAnonymousUsersCount());

		_anonymousUserLocalService.deleteAnonymousUser(anonymousUser);

		Assert.assertEquals(
			initAnonymousUsersCount,
			_anonymousUserLocalService.getAnonymousUsersCount());
	}

	@Test
	public void testAddAndDeleteAnonymousUsers() throws Exception {
		int initAnonymousUsersCount =
			_anonymousUserLocalService.getAnonymousUsersCount();

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		AnonymousUser anonymousUser1 =
			_anonymousUserLocalService.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		AnonymousUser anonymousUser2 =
			_anonymousUserLocalService.addAnonymousUser(
				1, "127.0.0.1", StringPool.BLANK, serviceContext);

		Assert.assertEquals(
			initAnonymousUsersCount + 2,
			_anonymousUserLocalService.getAnonymousUsersCount());

		_anonymousUserLocalService.deleteAnonymousUsers(
			TestPropsValues.getCompanyId(), new Date(), false);

		Assert.assertNotNull(
			_anonymousUserLocalService.fetchAnonymousUser(
				anonymousUser1.getAnonymousUserId()));

		Assert.assertNull(
			_anonymousUserLocalService.fetchAnonymousUser(
				anonymousUser2.getAnonymousUserId()));

		_anonymousUserLocalService.deleteAnonymousUsers(
			TestPropsValues.getCompanyId(), new Date(), true);

		Assert.assertEquals(
			0, _anonymousUserLocalService.getAnonymousUsersCount());
	}

	@Test
	public void testDeleteUser() throws Exception {
		int initAnonymousUsersCount =
			_anonymousUserLocalService.getAnonymousUsersCount();

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		User user = UserTestUtil.addUser();

		_anonymousUserLocalService.addAnonymousUser(
			user.getUserId(), "127.0.0.1", StringPool.BLANK, serviceContext);

		Assert.assertEquals(
			initAnonymousUsersCount + 1,
			_anonymousUserLocalService.getAnonymousUsersCount());

		_userLocalService.deleteUser(user);

		Assert.assertEquals(
			initAnonymousUsersCount,
			_anonymousUserLocalService.getAnonymousUsersCount());
	}

	private AnonymousUserLocalService _anonymousUserLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private UserLocalService _userLocalService;

}