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
import com.liferay.content.targeting.service.base.ReportInstanceLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;

/**
 * The implementation of the report instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.ReportInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.ReportInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil
 */
public class ReportInstanceLocalServiceImpl
	extends ReportInstanceLocalServiceBaseImpl {

	@Override
	public ReportInstance addReportInstance(
			long userId, String reportKey, String className, long classPK,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ReportInstance reportInstance = fetchReportInstance(
			reportKey, className, classPK);

		if (reportInstance == null) {
			User user = UserLocalServiceUtil.getUser(userId);

			long groupId = serviceContext.getScopeGroupId();

			long reportInstanceId = CounterLocalServiceUtil.increment();

			reportInstance = reportInstancePersistence.create(reportInstanceId);

			reportInstance.setGroupId(groupId);
			reportInstance.setCompanyId(user.getCompanyId());
			reportInstance.setUserId(user.getUserId());
			reportInstance.setUserName(user.getFullName());
		}

		reportInstance.setModifiedDate(new Date());
		reportInstance.setReportKey(reportKey);
		reportInstance.setClassName(className);
		reportInstance.setClassPK(classPK);
		reportInstance.setTypeSettings(typeSettings);

		reportInstancePersistence.update(reportInstance);

		return reportInstance;
	}

	@Override
	public ReportInstance fetchReportInstance(
			String reportKey, String className, long classPK)
		throws SystemException {

		return reportInstancePersistence.fetchByR_C_C(
			reportKey, className, classPK);
	}

}