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

import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.TacticLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {"model.class.name=om.liferay.content.targeting.model.Tactic"},
	service = BaseModelPermissionChecker.class
)
public class TacticPermission implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, long tacticId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, tacticId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, Tactic tactic, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, tactic, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, long tacticId,
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, Tactic.class.getName(), tacticId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long tacticId, String actionId)
		throws PortalException {

		Tactic tactic = _tacticLocalService.getTactic(tacticId);

		return contains(permissionChecker, tactic, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Tactic tactic, String actionId) {

		if (permissionChecker.hasOwnerPermission(
				tactic.getCompanyId(), Tactic.class.getName(),
				tactic.getTacticId(), tactic.getUserId(), actionId)) {

			return true;
		}

		return contains(
			permissionChecker, tactic.getGroupId(), tactic.getTacticId(),
			actionId);
	}

	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, primaryKey, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Tactic.class.getName(), primaryKey,
				actionId);
		}
	}

	@Reference(unbind = "-")
	protected void setTacticLocalService(
		TacticLocalService tacticLocalService) {

		_tacticLocalService = tacticLocalService;
	}

	private static TacticLocalService _tacticLocalService;

}