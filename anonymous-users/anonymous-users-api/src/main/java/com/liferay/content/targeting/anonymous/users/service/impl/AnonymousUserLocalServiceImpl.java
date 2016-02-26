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

package com.liferay.content.targeting.anonymous.users.service.impl;

import com.liferay.content.targeting.anonymous.users.configuration.AnonymousUserServiceConfigurationUtil;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.base.AnonymousUserLocalServiceBaseImpl;
import com.liferay.content.targeting.anonymous.users.util.PortletPropsKeys;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the anonymous user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.anonymous.users.service.base.AnonymousUserLocalServiceBaseImpl
 * @see com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil
 */
public class AnonymousUserLocalServiceImpl
	extends AnonymousUserLocalServiceBaseImpl {

	@Override
	public AnonymousUser addAnonymousUser(
			long userId, String lastIp, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.fetchUser(userId);

		Date now = new Date();

		long anonymousUserId = counterLocalService.increment();

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
	public void checkAnonymousUsers() throws PortalException {
		ActionableDynamicQuery actionableDynamicQuery =
			companyLocalService.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Company>() {

				@Override
				public void performAction(Company company)
					throws PortalException {

					deleteAnonymousUsers(
						company.getCompanyId(), getMaxAge(), false);
				}

			}
		);

		actionableDynamicQuery.performActions();
	}

	@Override
	public void deleteAnonymousUsers(
			long companyId, Date createDate, boolean includeUsers)
		throws PortalException {

		List<AnonymousUser> anonymousUsers =
			anonymousUserPersistence.findByC_LtD(companyId, createDate);

		for (AnonymousUser anonymousUser : anonymousUsers) {
			if (includeUsers || (anonymousUser.getUserId() <= 0)) {
				deleteAnonymousUser(anonymousUser);
			}
		}
	}

	@Override
	public AnonymousUser fetchAnonymousUserByUserId(long userId)
		throws PortalException {

		if (userId <= 0) {
			return null;
		}

		return anonymousUserPersistence.fetchByUserId_First(userId, null);
	}

	@Override
	public Date getMaxAge() throws PortalException {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());

		int maxAge = AnonymousUserServiceConfigurationUtil.getInteger(
			PortletPropsKeys.ANONYMOUS_USERS_MAX_AGE);

		calendar.add(Calendar.DAY_OF_YEAR, -maxAge);

		return calendar.getTime();
	}

	@Override
	public AnonymousUser updateAnonymousUser(
			long anonymousUserId, long userId, String lastIp,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		AnonymousUser anonymousUser = anonymousUserPersistence.findByPrimaryKey(
			anonymousUserId);

		User user = userLocalService.fetchUser(userId);

		if (user != null) {
			anonymousUser.setUserId(user.getUserId());
			anonymousUser.setUserName(user.getFullName());
		}

		anonymousUser.setModifiedDate(serviceContext.getModifiedDate(now));
		anonymousUser.setLastIp(lastIp);
		anonymousUser.setTypeSettings(typeSettings);

		anonymousUserPersistence.update(anonymousUser);

		return anonymousUser;
	}

	@Override
	public AnonymousUser updateLastIp(long anonymousUserId, String lastIp)
		throws PortalException {

		AnonymousUser anonymousUser =
			anonymousUserPersistence.fetchByPrimaryKey(anonymousUserId);

		anonymousUser.setLastIp(lastIp);
		anonymousUser.setModifiedDate(new Date());

		anonymousUserPersistence.update(anonymousUser);

		return anonymousUser;
	}

}