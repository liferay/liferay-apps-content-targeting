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

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.base.UserSegmentServiceBaseImpl;
import com.liferay.content.targeting.service.permission.ContentTargetingPermission;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the user segment remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.UserSegmentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Eudaldo Alonso
 * @author Julio Camarero
 * @see com.liferay.content.targeting.service.base.UserSegmentServiceBaseImpl
 * @see com.liferay.content.targeting.service.UserSegmentServiceUtil
 */
public class UserSegmentServiceImpl extends UserSegmentServiceBaseImpl {

	@Override
	public UserSegment addUserSegment(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException {

		ContentTargetingPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_USER_SEGMENT);

		return userSegmentLocalService.addUserSegment(
			userId, nameMap, descriptionMap, serviceContext);
	}

	@Override
	public UserSegment deleteUserSegment(long userSegmentId)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.DELETE);

		return userSegmentLocalService.deleteUserSegment(userSegmentId);
	}

	@Override
	public List<UserSegment> getUserSegments(long groupId)
		throws PortalException {

		return userSegmentPersistence.filterFindByGroupId(groupId);
	}

	@Override
	public List<UserSegment> getUserSegments(long[] groupIds)
		throws PortalException {

		return userSegmentPersistence.filterFindByGroupId(groupIds);
	}

	@Override
	public int getUserSegmentsCount(long groupId) throws PortalException {
		return userSegmentPersistence.filterCountByGroupId(groupId);
	}

	@Override
	public int getUserSegmentsCount(long[] groupIds) throws PortalException {
		return userSegmentPersistence.filterCountByGroupId(groupIds);
	}

	@Override
	public UserSegment updateUserSegment(
			long userSegmentId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.UPDATE);

		return userSegmentLocalService.updateUserSegment(
			userSegmentId, nameMap, descriptionMap, serviceContext);
	}

}