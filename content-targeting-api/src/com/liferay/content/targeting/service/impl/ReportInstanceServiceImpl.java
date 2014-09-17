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

package com.liferay.content.targeting.service.impl;

import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.service.base.ReportInstanceServiceBaseImpl;
import com.liferay.content.targeting.service.permission.ReportPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;

/**
 * The implementation of the report instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.ReportInstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.ReportInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.ReportInstanceServiceUtil
 */
public class ReportInstanceServiceImpl extends ReportInstanceServiceBaseImpl {

	@Override
	public ReportInstance addReportInstance(
			long userId, String reportKey, String className, long classPK,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ReportPermission.check(
			getPermissionChecker(), userId, serviceContext.getCompanyId(),
			serviceContext.getScopeGroupId(), className, classPK,
			ActionKeys.UPDATE);

		return reportInstanceLocalService.addReportInstance(
			userId, reportKey, className, classPK, typeSettings,
			serviceContext);
	}

	@Override
	public ReportInstance fetchReportInstance(
			String reportKey, String className, long classPK)
		throws SystemException {

		return reportInstanceLocalService.fetchReportInstance(
			reportKey, className, classPK);
	}

	@Override
	public Date getReportInstanceModifiedDate(
			String reportKey, String className, long classPK)
		throws SystemException {

		return reportInstanceLocalService.getReportInstanceModifiedDate(
			reportKey, className, classPK);
	}

}