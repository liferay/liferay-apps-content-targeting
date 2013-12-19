/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service.impl;

import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.service.base.CTUserLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;

/**
 * The implementation of the c t user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.CTUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.service.base.CTUserLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.CTUserLocalServiceUtil
 */
public class CTUserLocalServiceImpl extends CTUserLocalServiceBaseImpl {

	@Override
	public CTUser addUser(
			long userId, String lastIp, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long CTUserId = CounterLocalServiceUtil.increment();

		CTUser CTUser = ctUserPersistence.create(CTUserId);

		CTUser.setGroupId(groupId);
		CTUser.setCompanyId(CTUser.getCompanyId());

		if (user != null) {
			CTUser.setUserId(user.getUserId());
			CTUser.setUserName(user.getFullName());
		}

		CTUser.setCreateDate(serviceContext.getCreateDate(now));
		CTUser.setModifiedDate(serviceContext.getModifiedDate(now));
		CTUser.setLastIp(lastIp);
		CTUser.setTypeSettings(typeSettings);

		ctUserPersistence.update(CTUser);

		return CTUser;
	}

	@Override
	public CTUser deleteUser(long CTUserId)
		throws PortalException, SystemException {

		return ctUserPersistence.remove(CTUserId);
	}

	@Override
	public CTUser updateUser(
			long userId, String lastIp, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		CTUser CTUser = ctUserPersistence.findByPrimaryKey(userId);

		CTUser.setModifiedDate(serviceContext.getModifiedDate(now));
		CTUser.setLastIp(lastIp);
		CTUser.setTypeSettings(typeSettings);

		ctUserPersistence.update(CTUser);

		return CTUser;
	}

}