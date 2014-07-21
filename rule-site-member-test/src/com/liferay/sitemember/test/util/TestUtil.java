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

package com.liferay.sitemember.test.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class TestUtil {

	public static Group addGroup() throws PortalException, SystemException {
		return addGroup(
			getCompanyId(), getUserId(), GroupConstants.DEFAULT_PARENT_GROUP_ID,
			StringUtil.randomString(), StringUtil.randomString());
	}

	public static Group addGroup(
			long companyId, long userId, long parentGroupId, String name,
			String description)
		throws PortalException, SystemException {

		Group group = GroupLocalServiceUtil.fetchGroup(companyId, name);

		if (group != null) {
			return group;
		}

		int type = GroupConstants.TYPE_SITE_OPEN;
		String friendlyURL =
			StringPool.SLASH + FriendlyURLNormalizerUtil.normalize(name);
		boolean site = true;
		boolean active = true;
		boolean manualMembership = true;
		int membershipRestriction =
			GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION;

		return GroupLocalServiceUtil.addGroup(
			userId, parentGroupId, null, 0,
			GroupConstants.DEFAULT_LIVE_GROUP_ID, name, description, type,
			manualMembership, membershipRestriction, friendlyURL, site, active,
			getServiceContext());
	}

	public static long getCompanyId() {
		return PortalUtil.getDefaultCompanyId();
	}

	public static ServiceContext getServiceContext()
		throws PortalException, SystemException {

		Group defaultGroup = GroupLocalServiceUtil.getGroup(
			getCompanyId(), GroupConstants.GUEST);

		return getServiceContext(defaultGroup.getGroupId(), getUserId());
	}

	public static ServiceContext getServiceContext(long groupId, long userId)
		throws PortalException, SystemException {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setUserId(userId);

		return serviceContext;
	}

	public static User getUser() throws PortalException, SystemException {
		if (_user == null) {
			Role role = RoleLocalServiceUtil.getRole(
				getCompanyId(), RoleConstants.ADMINISTRATOR);

			List<User> users = UserLocalServiceUtil.getRoleUsers(
					role.getRoleId(), 0, 2);

			if (!users.isEmpty()) {
				_user = users.get(0);

				_userId = _user.getUserId();
			}
		}

		return _user;
	}

	public static long getUserId() throws PortalException, SystemException {
		if (_userId == 0) {
			User user = getUser();

			if (user != null) {
				_userId = user.getUserId();
			}
		}

		return _userId;
	}

	private static User _user;
	private static long _userId;

}