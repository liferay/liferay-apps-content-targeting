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

package com.liferay.content.targeting.service.permission;

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true,
	property = {"model.class.name=om.liferay.content.targeting.model.UserSegment"},
	service = BaseModelPermissionChecker.class
)
public class UserSegmentPermission implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, long userSegmentId,
			String actionId)
		throws PortalException {

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
		PermissionChecker permissionChecker, long groupId, long userSegmentId,
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, UserSegment.class.getName(), userSegmentId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long userSegmentId,
			String actionId)
		throws PortalException {

		UserSegment userSegment = _userSegmentLocalService.getUserSegment(
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

		return contains(
			permissionChecker, userSegment.getGroupId(),
			userSegment.getUserSegmentId(), actionId);
	}

	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, primaryKey, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, UserSegment.class.getName(), primaryKey,
				actionId);
		}
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	private static UserSegmentLocalService _userSegmentLocalService;

}