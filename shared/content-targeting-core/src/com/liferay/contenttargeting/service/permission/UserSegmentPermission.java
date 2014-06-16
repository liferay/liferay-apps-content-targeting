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

package com.liferay.contenttargeting.service.permission;

import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Julio Camarero
 */
public class UserSegmentPermission {

	public static void check(
			PermissionChecker permissionChecker, long userSegmentId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, userSegmentId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, UserSegment userSegment,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, userSegment, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long userSegmentId,
			String actionId)
		throws PortalException, SystemException {

		UserSegment userSegment = UserSegmentLocalServiceUtil.getUserSegment(
			userSegmentId);

		return contains(permissionChecker, userSegment, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, UserSegment userSegment,
		String actionId) {

		if (permissionChecker.hasOwnerPermission(
				userSegment.getCompanyId(), UserSegment.class.getName(),
				userSegment.getUserSegmentId(), userSegment.getUserId(),
				actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			userSegment.getGroupId(), UserSegment.class.getName(),
			userSegment.getUserSegmentId(), actionId);
	}

}