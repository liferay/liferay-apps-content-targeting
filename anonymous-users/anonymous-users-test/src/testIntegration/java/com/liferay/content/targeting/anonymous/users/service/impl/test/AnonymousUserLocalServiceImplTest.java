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

package com.liferay.content.targeting.anonymous.users.service.impl.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.Date;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class AnonymousUserLocalServiceImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testAddAndDeleteAnonymousUser() throws Exception {
		int initAnonymousUsersCount =
			AnonymousUserLocalServiceUtil.getAnonymousUsersCount();

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext();

		AnonymousUser anonymousUser =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				1, "127.0.0.1", StringPool.BLANK, serviceContext);

		Assert.assertEquals(
			initAnonymousUsersCount + 1,
			AnonymousUserLocalServiceUtil.getAnonymousUsersCount());

		AnonymousUserLocalServiceUtil.deleteAnonymousUser(anonymousUser);

		Assert.assertEquals(
			initAnonymousUsersCount,
			AnonymousUserLocalServiceUtil.getAnonymousUsersCount());
	}

	@Test
	public void testAddAndDeleteAnonymousUsers() throws Exception {
		int initAnonymousUsersCount =
			AnonymousUserLocalServiceUtil.getAnonymousUsersCount();

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext();

		AnonymousUser anonymousUser1 =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		AnonymousUser anonymousUser2 =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				1, "127.0.0.1", StringPool.BLANK, serviceContext);

		Assert.assertEquals(
			initAnonymousUsersCount + 2,
			AnonymousUserLocalServiceUtil.getAnonymousUsersCount());

		AnonymousUserLocalServiceUtil.deleteAnonymousUsers(
			TestPropsValues.getCompanyId(), new Date(), false);

		Assert.assertNotNull(
			AnonymousUserLocalServiceUtil.fetchAnonymousUser(
				anonymousUser1.getAnonymousUserId()));

		Assert.assertNull(
			AnonymousUserLocalServiceUtil.fetchAnonymousUser(
				anonymousUser2.getAnonymousUserId()));

		AnonymousUserLocalServiceUtil.deleteAnonymousUsers(
			TestPropsValues.getCompanyId(), new Date(), true);

		Assert.assertEquals(
			0, AnonymousUserLocalServiceUtil.getAnonymousUsersCount());
	}

	@Test
	public void testDeleteUser() throws Exception {
		int initAnonymousUsersCount =
			AnonymousUserLocalServiceUtil.getAnonymousUsersCount();

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext();

		User user = UserTestUtil.addUser();

		AnonymousUserLocalServiceUtil.addAnonymousUser(
			user.getUserId(), "127.0.0.1", StringPool.BLANK, serviceContext);

		Assert.assertEquals(
			initAnonymousUsersCount + 1,
			AnonymousUserLocalServiceUtil.getAnonymousUsersCount());

		UserLocalServiceUtil.deleteUser(user);

		Assert.assertEquals(
			initAnonymousUsersCount,
			AnonymousUserLocalServiceUtil.getAnonymousUsersCount());
	}

}