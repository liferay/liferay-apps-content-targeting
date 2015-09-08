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
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.model.AnonymousUserUserSegment;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.service.base.AnonymousUserUserSegmentLocalServiceBaseImpl;
import com.liferay.content.targeting.util.PortletPropsValues;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.persistence.CompanyActionableDynamicQuery;

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
		throws PortalException, SystemException {

		long anonymousUserUserSegmentId = CounterLocalServiceUtil.increment();

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
	public void checkAnonymousUserUserSegments()
		throws PortalException, SystemException {

		ActionableDynamicQuery actionableDynamicQuery =
			new CompanyActionableDynamicQuery() {

				@Override
				protected void performAction(Object object)
					throws PortalException, SystemException {

					Company company = (Company)object;

					updateAnonymousUserUserSegments(
						company.getCompanyId(), getMaxAge());
				}

			};

		actionableDynamicQuery.performActions();
	}

	@Override
	public List<AnonymousUser> getAnonymousUsersByUserSegmentId(
			long userSegmentId, boolean active)
		throws PortalException, SystemException {

		return getAnonymousUsersByUserSegmentIds(
			new long[] { userSegmentId }, active);
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdCount(
			long userSegmentId, boolean active)
		throws PortalException, SystemException {

		return getAnonymousUsersByUserSegmentIdsCount(
			new long[]{ userSegmentId }, active);
	}

	@Override
	public List<AnonymousUser> getAnonymousUsersByUserSegmentIds(
			long[] userSegmentIds, boolean active)
		throws PortalException, SystemException {

		List<AnonymousUser> anonymousUsers = new ArrayList<AnonymousUser>();

		List<AnonymousUserUserSegment> anonymousUserUserSegments =
			anonymousUserUserSegmentPersistence.findByUserSegmentIds(
				userSegmentIds, active);

		for (AnonymousUserUserSegment anonymousUserUserSegment
				: anonymousUserUserSegments) {

			AnonymousUser anonymousUser =
				AnonymousUserLocalServiceUtil.getAnonymousUser(
					anonymousUserUserSegment.getAnonymousUserId());

			anonymousUsers.add(anonymousUser);
		}

		return anonymousUsers;
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdsCount(
			long[] userSegmentIds, boolean active)
		throws PortalException, SystemException {

		return anonymousUserUserSegmentPersistence.countByUserSegmentIds(
			userSegmentIds, active);
	}

	@Override
	public List<AnonymousUserUserSegment> getAnonymousUserUserSegments(
			long anonymousUserId, long userSegmentId)
		throws PortalException, SystemException {

		return anonymousUserUserSegmentPersistence.findByA_U(
			anonymousUserId, userSegmentId);
	}

	@Override
	public Date getMaxAge() throws PortalException, SystemException {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());

		int maxAge = PortletPropsValues.ANONYMOUS_USER_USER_SEGMENTS_MAX_AGE;

		calendar.add(Calendar.DAY_OF_YEAR, -maxAge);

		return calendar.getTime();
	}

	@Override
	public List<UserSegment> getUserSegmentsByAnonymousUserId(
			long anonymousUserId, boolean active)
		throws PortalException, SystemException {

		List<UserSegment> userSegments = new ArrayList<UserSegment>();

		List<AnonymousUserUserSegment> anonymousUserUserSegments =
			anonymousUserUserSegmentPersistence.findByAnonymousUserId(
				anonymousUserId, active);

		for (AnonymousUserUserSegment anonymousUserUserSegment
				: anonymousUserUserSegments) {

			UserSegment userSegment =
				UserSegmentLocalServiceUtil.getUserSegment(
					anonymousUserUserSegment.getUserSegmentId());

			userSegments.add(userSegment);
		}

		return userSegments;
	}

	@Override
	public int getUserSegmentsByAnonymousUserIdCount(
			long anonymousUserId, boolean active)
		throws PortalException, SystemException {

		return anonymousUserUserSegmentPersistence.countByAnonymousUserId(
			anonymousUserId, active);
	}

	@Override
	public AnonymousUserUserSegment updateAnonymousUserUserSegment(
			long anonymousUserUserSegmentId, ServiceContext serviceContext)
		throws PortalException, SystemException {

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
		throws PortalException, SystemException {

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

}