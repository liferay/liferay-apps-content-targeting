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

import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.base.UserSegmentLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the user segment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.UserSegmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.service.base.UserSegmentLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.UserSegmentLocalServiceUtil
 */
public class UserSegmentLocalServiceImpl
		extends UserSegmentLocalServiceBaseImpl {

	@Override
	public UserSegment addUserSegment(
			long userId, String name, String description,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long userSegmentId = CounterLocalServiceUtil.increment();

		UserSegment userSegment = userSegmentPersistence.create(userSegmentId);

		userSegment.setGroupId(groupId);
		userSegment.setCompanyId(user.getCompanyId());
		userSegment.setUserId(user.getUserId());
		userSegment.setUserName(user.getFullName());
		userSegment.setCreateDate(serviceContext.getCreateDate(now));
		userSegment.setModifiedDate(serviceContext.getModifiedDate(now));
		userSegment.setName(name);
		userSegment.setDescription(description);

		userSegmentPersistence.update(userSegment);

		return userSegment;
	}

	@Override
	public UserSegment deleteUserSegment(long userSegmentId)
		throws PortalException, SystemException {

		return userSegmentPersistence.remove(userSegmentId);
	}

	@Override
	public List<UserSegment> getUserSegments(long groupId)
		throws PortalException, SystemException {

		return userSegmentPersistence.findByGroupId(groupId);
	}

	@Override
	public long getUserSegmentsCount(long groupId)
		throws PortalException, SystemException {

		return userSegmentPersistence.countByGroupId(groupId);
	}

	@Override
	public UserSegment updateUserSegment(
			long userSegmentId, String name, String description,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		UserSegment userSegment = userSegmentPersistence.findByPrimaryKey(
			userSegmentId);

		userSegment.setModifiedDate(serviceContext.getModifiedDate(now));
		userSegment.setName(name);
		userSegment.setDescription(description);

		userSegmentPersistence.update(userSegment);

		return userSegment;
	}

}