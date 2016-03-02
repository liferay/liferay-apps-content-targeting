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

import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true,
	property = {"model.class.name=om.liferay.content.targeting.model.ReportInstance"},
	service = BaseModelPermissionChecker.class
)
public class ReportPermission implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, long userId, long companyId,
			long groupId, String className, long classPK, String actionId)
		throws PortalException {

		if (!contains(
				permissionChecker, userId, companyId, groupId, className,
				classPK, actionId)) {

			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long userId, long companyId,
		long groupId, String className, long classPK, String actionId) {

		if (permissionChecker.hasOwnerPermission(
				companyId, className, classPK, userId, actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			groupId, className, classPK, actionId);
	}

	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(primaryKey);

		if (!contains(
				permissionChecker, reportInstance.getUserId(),
				reportInstance.getCompanyId(), reportInstance.getGroupId(),
				reportInstance.getClassName(), reportInstance.getClassPK(),
				actionId)) {

			throw new PrincipalException.MustHavePermission(
				permissionChecker, ReportInstance.class.getName(), primaryKey,
				actionId);
		}
	}

	@Reference(unbind = "-")
	protected void setReportInstanceLocalService(
		ReportInstanceLocalService reportInstanceLocalService) {

		_reportInstanceLocalService = reportInstanceLocalService;
	}

	private ReportInstanceLocalService _reportInstanceLocalService;

}