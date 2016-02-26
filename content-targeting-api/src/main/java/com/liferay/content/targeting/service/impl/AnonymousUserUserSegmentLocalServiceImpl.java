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

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.configuration.AnonymousUserUserSegmentServiceConfigurationUtil;
import com.liferay.content.targeting.model.AnonymousUserUserSegment;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.base.AnonymousUserUserSegmentLocalServiceBaseImpl;
import com.liferay.content.targeting.util.PortletPropsKeys;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the anonymous user user segment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.AnonymousUserUserSegmentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalServiceUtil
 */
public class AnonymousUserUserSegmentLocalServiceImpl
	extends AnonymousUserUserSegmentLocalServiceBaseImpl {

	@Override
	public AnonymousUserUserSegment addAnonymousUserUserSegment(
			long anonymousUserId, long userSegmentId, boolean manual,
			boolean active, ServiceContext serviceContext)
		throws PortalException {

		long anonymousUserUserSegmentId = counterLocalService.increment();

		Date now = new Date();

		AnonymousUserUserSegment anonymousUserUserSegment =
			anonymousUserUserSegmentPersistence.create(
				anonymousUserUserSegmentId);

		anonymousUserUserSegment.setCompanyId(serviceContext.getCompanyId());
		anonymousUserUserSegment.setModifiedDate(
			serviceContext.getModifiedDate(now));

		anonymousUserUserSegment.setActive(active);
		anonymousUserUserSegment.setAnonymousUserId(anonymousUserId);
		anonymousUserUserSegment.setManual(manual);
		anonymousUserUserSegment.setUserSegmentId(userSegmentId);

		anonymousUserUserSegmentPersistence.update(anonymousUserUserSegment);

		return anonymousUserUserSegment;
	}

	@Override
	public void checkAnonymousUserUserSegments() throws PortalException {
		ActionableDynamicQuery actionableDynamicQuery =
			companyLocalService.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Company>() {

				@Override
				public void performAction(Company company)
					throws PortalException {

					updateAnonymousUserUserSegments(
						company.getCompanyId(), getMaxAge());
				}

			}
		);

		actionableDynamicQuery.performActions();
	}

	@Override
	public List<AnonymousUser> getAnonymousUsersByUserSegmentId(
			long userSegmentId, boolean active)
		throws PortalException {

		return getAnonymousUsersByUserSegmentIds(
			new long[] {userSegmentId}, active);
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdCount(
			long userSegmentId, boolean active)
		throws PortalException {

		return getAnonymousUsersByUserSegmentIdsCount(
			new long[] {userSegmentId}, active);
	}

	@Override
	public List<AnonymousUser> getAnonymousUsersByUserSegmentIds(
			long[] userSegmentIds, boolean active)
		throws PortalException {

		List<AnonymousUser> anonymousUsers = new ArrayList<>();

		List<AnonymousUserUserSegment> anonymousUserUserSegments =
			anonymousUserUserSegmentPersistence.findByUserSegmentIds(
				userSegmentIds, active);

		for (AnonymousUserUserSegment anonymousUserUserSegment
				: anonymousUserUserSegments) {

			AnonymousUser anonymousUser =
				anonymousUserLocalService.getAnonymousUser(
					anonymousUserUserSegment.getAnonymousUserId());

			anonymousUsers.add(anonymousUser);
		}

		return anonymousUsers;
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdsCount(
			long[] userSegmentIds, boolean active)
		throws PortalException {

		return anonymousUserUserSegmentPersistence.countByUserSegmentIds(
			userSegmentIds, active);
	}

	@Override
	public List<AnonymousUserUserSegment> getAnonymousUserUserSegments(
			long anonymousUserId, long userSegmentId)
		throws PortalException {

		return anonymousUserUserSegmentPersistence.findByA_U(
			anonymousUserId, userSegmentId);
	}

	@Override
	public Date getMaxAge() throws PortalException {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());

		int maxAge =
			AnonymousUserUserSegmentServiceConfigurationUtil.getInteger(
				PortletPropsKeys.ANONYMOUS_USER_USER_SEGMENTS_MAX_AGE);

		calendar.add(Calendar.DAY_OF_YEAR, -maxAge);

		return calendar.getTime();
	}

	@Override
	public List<UserSegment> getUserSegmentsByAnonymousUserId(
			long anonymousUserId, boolean active)
		throws PortalException {

		List<UserSegment> userSegments = new ArrayList<>();

		List<AnonymousUserUserSegment> anonymousUserUserSegments =
			anonymousUserUserSegmentPersistence.findByAnonymousUserId(
				anonymousUserId, active);

		for (AnonymousUserUserSegment anonymousUserUserSegment
				: anonymousUserUserSegments) {

			UserSegment userSegment = userSegmentLocalService.getUserSegment(
				anonymousUserUserSegment.getUserSegmentId());

			userSegments.add(userSegment);
		}

		return userSegments;
	}

	@Override
	public int getUserSegmentsByAnonymousUserIdCount(
			long anonymousUserId, boolean active)
		throws PortalException {

		return anonymousUserUserSegmentPersistence.countByAnonymousUserId(
			anonymousUserId, active);
	}

	@Override
	public List<UserSegment> getUserSegmentsByUserId(
			long userId, boolean active)
		throws PortalException {

		List<UserSegment> userSegments = new ArrayList<>();

		AnonymousUser anonymousUser =
			anonymousUserLocalService.fetchAnonymousUserByUserId(userId);

		if (anonymousUser == null) {
			return userSegments;
		}

		return getUserSegmentsByAnonymousUserId(
			anonymousUser.getAnonymousUserId(), active);
	}

	@Override
	public int getUserSegmentsByUserIdCount(long userId, boolean active)
		throws PortalException {

		AnonymousUser anonymousUser =
			anonymousUserLocalService.fetchAnonymousUserByUserId(userId);

		if (anonymousUser == null) {
			return 0;
		}

		return getUserSegmentsByAnonymousUserIdCount(
			anonymousUser.getAnonymousUserId(), active);
	}

	@Override
	public AnonymousUserUserSegment updateAnonymousUserUserSegment(
			long anonymousUserUserSegmentId, ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		AnonymousUserUserSegment anonymousUserUserSegment =
			anonymousUserUserSegmentPersistence.fetchByPrimaryKey(
				anonymousUserUserSegmentId);

		if (anonymousUserUserSegment == null) {
			return anonymousUserUserSegment;
		}

		anonymousUserUserSegment.setModifiedDate(
			serviceContext.getModifiedDate(now));

		anonymousUserUserSegmentPersistence.update(anonymousUserUserSegment);

		return anonymousUserUserSegment;
	}

	@Override
	public void updateAnonymousUserUserSegments(
			long companyId, Date modifiedDate)
		throws PortalException {

		List<AnonymousUserUserSegment> anonymousUserUserSegments =
			anonymousUserUserSegmentPersistence.findByC_LtD_M(
				companyId, modifiedDate, false);

		for (AnonymousUserUserSegment anonymousUserUserSegment
				: anonymousUserUserSegments) {

			if (anonymousUserUserSegment.isManual()) {
				continue;
			}

			anonymousUserUserSegment.setActive(false);

			anonymousUserUserSegmentPersistence.update(
				anonymousUserUserSegment);
		}
	}

	@ServiceReference(type = AnonymousUserLocalService.class)
	protected AnonymousUserLocalService anonymousUserLocalService;

}