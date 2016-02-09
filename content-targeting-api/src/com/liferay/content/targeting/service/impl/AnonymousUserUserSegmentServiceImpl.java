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
import com.liferay.content.targeting.model.AnonymousUserUserSegment;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.base.AnonymousUserUserSegmentServiceBaseImpl;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the anonymous user user segment remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.AnonymousUserUserSegmentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.AnonymousUserUserSegmentServiceBaseImpl
 * @see com.liferay.content.targeting.service.AnonymousUserUserSegmentServiceUtil
 */
public class AnonymousUserUserSegmentServiceImpl
	extends AnonymousUserUserSegmentServiceBaseImpl {

	@Override
	public AnonymousUserUserSegment addAnonymousUserUserSegment(
			long anonymousUserId, long userSegmentId, boolean manual,
			boolean active, ServiceContext serviceContext)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.UPDATE);

		return anonymousUserUserSegmentLocalService.addAnonymousUserUserSegment(
			anonymousUserId, userSegmentId, manual, active, serviceContext);
	}

	@Override
	public List<AnonymousUser> getAnonymousUsersByUserSegmentId(
			long userSegmentId, boolean active, ServiceContext serviceContext)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.VIEW);

		return anonymousUserUserSegmentLocalService.
			getAnonymousUsersByUserSegmentId(userSegmentId, active);
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdCount(
			long userSegmentId, boolean active, ServiceContext serviceContext)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.VIEW);

		return anonymousUserUserSegmentLocalService.
			getAnonymousUsersByUserSegmentIdCount(userSegmentId, active);
	}

	@Override
	public List<AnonymousUser> getAnonymousUsersByUserSegmentIds(
			long[] userSegmentIds, boolean active,
			ServiceContext serviceContext)
		throws PortalException {

		for (long userSegmentId : userSegmentIds) {
			UserSegmentPermission.check(
				getPermissionChecker(), userSegmentId, ActionKeys.VIEW);
		}

		return anonymousUserUserSegmentLocalService.
			getAnonymousUsersByUserSegmentIds(userSegmentIds, active);
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdsCount(
			long[] userSegmentIds, boolean active,
			ServiceContext serviceContext)
		throws PortalException {

		for (long userSegmentId : userSegmentIds) {
			UserSegmentPermission.check(
				getPermissionChecker(), userSegmentId, ActionKeys.VIEW);
		}

		return anonymousUserUserSegmentLocalService.
			getAnonymousUsersByUserSegmentIdsCount(userSegmentIds, active);
	}

	@Override
	public List<UserSegment> getUserSegmentsByAnonymousUserId(
			long anonymousUserId, boolean active, ServiceContext serviceContext)
		throws PortalException {

		return anonymousUserUserSegmentLocalService.
			getUserSegmentsByAnonymousUserId(anonymousUserId, active);
	}

	@Override
	public int getUserSegmentsByAnonymousUserIdCount(
			long anonymousUserId, boolean active, ServiceContext serviceContext)
		throws PortalException {

		return anonymousUserUserSegmentLocalService.
			getUserSegmentsByAnonymousUserIdCount(anonymousUserId, active);
	}

	@Override
	public List<UserSegment> getUserSegmentsByUserId(
			long userId, boolean active)
		throws PortalException {

		return anonymousUserUserSegmentLocalService.getUserSegmentsByUserId(
			userId, active);
	}

	@Override
	public int getUserSegmentsByUserIdCount(long userId, boolean active)
		throws PortalException {

		return anonymousUserUserSegmentLocalService.
			getUserSegmentsByUserIdCount(userId, active);
	}

	@Override
	public AnonymousUserUserSegment updateAnonymousUserUserSegment(
			long anonymousUserUserSegmentId, ServiceContext serviceContext)
		throws PortalException {

		return anonymousUserUserSegmentLocalService.
			updateAnonymousUserUserSegment(
				anonymousUserUserSegmentId, serviceContext);
	}

}