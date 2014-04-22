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

		long anonymousUserId = CounterLocalServiceUtil.increment();

		AnonymousUser anonymousUser = anonymousUserPersistence.create(
			anonymousUserId);

		anonymousUser.setCompanyId(serviceContext.getCompanyId());

		if (user != null) {
			anonymousUser.setUserId(user.getUserId());
			anonymousUser.setUserName(user.getFullName());
		}

		anonymousUser.setCreateDate(serviceContext.getCreateDate(now));
		anonymousUser.setModifiedDate(serviceContext.getModifiedDate(now));
		anonymousUser.setLastIp(lastIp);
		anonymousUser.setTypeSettings(typeSettings);

		anonymousUserPersistence.update(anonymousUser);

		return anonymousUser;
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

		AnonymousUser anonymousUser = anonymousUserPersistence.findByPrimaryKey(
			userId);

		anonymousUser.setModifiedDate(serviceContext.getModifiedDate(now));
		anonymousUser.setLastIp(lastIp);
		anonymousUser.setTypeSettings(typeSettings);

		anonymousUserPersistence.update(anonymousUser);

		return anonymousUser;
	}

	@Override
	public AnonymousUser updateLastIp(long anonymousUserId, String lastIp)
		throws PortalException, SystemException {

		AnonymousUser anonymousUser =
			anonymousUserPersistence.fetchByPrimaryKey(anonymousUserId);

		anonymousUser.setLastIp(lastIp);
		anonymousUser.setModifiedDate(new Date());

		anonymousUserPersistence.update(anonymousUser);

		return anonymousUser;
	}

}