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

package com.liferay.content.targeting.service.test.service;

import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/**
 * @author Brian Wing Shun Chan
 * @author Michael Young
 * @author Alexander Chow
 * @author Manuel de la Peña
 */
public class ServiceTestUtil {

	public static void addResourcePermission(
			Role role, String resourceName, int scope, String primKey,
			String actionId)
		throws Exception {

		ResourcePermissionLocalServiceUtil.addResourcePermission(
			role.getCompanyId(), resourceName, scope, primKey, role.getRoleId(),
			actionId);
	}

	public static void addResourcePermission(
			String roleName, String resourceName, int scope, String primKey,
			String actionId)
		throws Exception {

		Role role = RoleLocalServiceUtil.getRole(
			TestPropsValues.getCompanyId(), roleName);

		addResourcePermission(role, resourceName, scope, primKey, actionId);
	}

	public static Role addRole(String roleName, int roleType) throws Exception {
		Role role = null;

		try {
			role = RoleLocalServiceUtil.getRole(
				TestPropsValues.getCompanyId(), roleName);
		}
		catch (NoSuchRoleException nsre) {
			role = RoleLocalServiceUtil.addRole(
				TestPropsValues.getUserId(), null, 0, roleName, null, null,
				roleType, null, null);
		}

		return role;
	}

	public static Role addRole(
			String roleName, int roleType, String resourceName, int scope,
			String primKey, String actionId)
		throws Exception {

		Role role = addRole(roleName, roleType);

		addResourcePermission(role, resourceName, scope, primKey, actionId);

		return role;
	}

	public static SearchContext getSearchContext() throws Exception {
		return getSearchContext(TestPropsValues.getGroupId());
	}

	public static SearchContext getSearchContext(long groupId)
		throws Exception {

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(TestPropsValues.getCompanyId());
		searchContext.setGroupIds(new long[]{groupId});
		searchContext.setUserId(TestPropsValues.getUserId());

		return searchContext;
	}

	public static ServiceContext getServiceContext()
		throws PortalException, SystemException {

		return getServiceContext(TestPropsValues.getGroupId());
	}

	public static ServiceContext getServiceContext(long groupId)
		throws PortalException, SystemException {

		return getServiceContext(groupId, TestPropsValues.getUserId());
	}

	public static ServiceContext getServiceContext(long groupId, long userId)
		throws PortalException, SystemException {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setCompanyId(TestPropsValues.getCompanyId());
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setUserId(userId);

		return serviceContext;
	}

	public static Date newDate() throws Exception {
		return new Date();
	}

	public static Date newDate(int month, int day, int year) throws Exception {
		Calendar calendar = new GregorianCalendar();

		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, day);
		calendar.set(Calendar.YEAR, year);

		return calendar.getTime();
	}

	public static Date nextDate() throws Exception {
		return new Date();
	}

	public static double nextDouble() throws Exception {
		return CounterLocalServiceUtil.increment();
	}

	public static int nextInt() throws Exception {
		return (int)CounterLocalServiceUtil.increment();
	}

	public static long nextLong() throws Exception {
		return CounterLocalServiceUtil.increment();
	}

	public static boolean randomBoolean() throws Exception {
		return _random.nextBoolean();
	}

	public static int randomInt() throws Exception {
		int value = _random.nextInt();

		if (value > 0) {
			return value;
		}
		else if (value == 0) {
			return randomInt();
		}
		else {
			return -value;
		}
	}

	public static Map<Locale, String> randomLocaleStringMap() throws Exception {
		return randomLocaleStringMap(LocaleUtil.getDefault());
	}

	public static Map<Locale, String> randomLocaleStringMap(Locale locale)
		throws Exception {

		Map<Locale, String> map = new HashMap<Locale, String>();

		map.put(LocaleUtil.getDefault(), randomString());

		return map;
	}

	public static long randomLong() throws Exception {
		long value = _random.nextLong();

		if (value > 0) {
			return value;
		}
		else if (value == 0) {
			return randomLong();
		}
		else {
			return -value;
		}
	}

	public static String randomString() throws Exception {
		return StringUtil.randomString();
	}

	public static String randomString(int length) throws Exception {
		return StringUtil.randomString(length);
	}

	public static void setUser(User user) throws Exception {
		if (user == null) {
			return;
		}

		PrincipalThreadLocal.setName(user.getUserId());

		PermissionChecker permissionChecker =
			PermissionCheckerFactoryUtil.create(user);

		PermissionThreadLocal.setPermissionChecker(permissionChecker);
	}

	private static Random _random = new Random();

}