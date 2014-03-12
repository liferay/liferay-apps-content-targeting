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

package com.liferay.anonymoususers.service.impl;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.anonymoususers.service.base.AnonymousUserLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;

/**
 * The implementation of the anonymous user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.anonymoususers.service.AnonymousUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.anonymoususers.service.base.AnonymousUserLocalServiceBaseImpl
 * @see com.liferay.anonymoususers.service.AnonymousUserLocalServiceUtil
 */
public class AnonymousUserLocalServiceImpl
	extends AnonymousUserLocalServiceBaseImpl {

	@Override
	public AnonymousUser addAnonymousUser(
			long userId, String lastIp, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.fetchUser(userId);

		Date now = new Date();

		long AnonymousUserId = CounterLocalServiceUtil.increment();

		AnonymousUser AnonymousUser = anonymousUserPersistence.create(
			AnonymousUserId);

		AnonymousUser.setCompanyId(serviceContext.getCompanyId());

		if (user != null) {
			AnonymousUser.setUserId(user.getUserId());
			AnonymousUser.setUserName(user.getFullName());
		}

		AnonymousUser.setCreateDate(serviceContext.getCreateDate(now));
		AnonymousUser.setModifiedDate(serviceContext.getModifiedDate(now));
		AnonymousUser.setLastIp(lastIp);
		AnonymousUser.setTypeSettings(typeSettings);

		anonymousUserPersistence.update(AnonymousUser);

		return AnonymousUser;
	}

	@Override
	public AnonymousUser fetchAnonymousUserByUserId(long userId)
		throws PortalException, SystemException {

		if (userId <= 0) {
			return null;
		}

		return anonymousUserPersistence.fetchByUserId_First(userId, null);
	}

	@Override
	public AnonymousUser updateAnonymousUser(
			long userId, String lastIp, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		AnonymousUser AnonymousUser = anonymousUserPersistence.findByPrimaryKey(
			userId);

		AnonymousUser.setModifiedDate(serviceContext.getModifiedDate(now));
		AnonymousUser.setLastIp(lastIp);
		AnonymousUser.setTypeSettings(typeSettings);

		anonymousUserPersistence.update(AnonymousUser);

		return AnonymousUser;
	}

	@Override
	public AnonymousUser updateLastIp(long AnonymousUserId, String lastIp)
		throws PortalException, SystemException {

		AnonymousUser AnonymousUser =
			anonymousUserPersistence.fetchByPrimaryKey(AnonymousUserId);

		AnonymousUser.setLastIp(lastIp);
		AnonymousUser.setModifiedDate(new Date());

		anonymousUserPersistence.update(AnonymousUser);

		return AnonymousUser;
	}

}