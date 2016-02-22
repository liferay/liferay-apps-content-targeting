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

package com.liferay.content.targeting.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserSegmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentService
 * @generated
 */
@ProviderType
public class UserSegmentServiceWrapper implements UserSegmentService,
	ServiceWrapper<UserSegmentService> {
	public UserSegmentServiceWrapper(UserSegmentService userSegmentService) {
		_userSegmentService = userSegmentService;
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment addUserSegment(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentService.addUserSegment(userId, nameMap,
			descriptionMap, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment deleteUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentService.deleteUserSegment(userSegmentId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userSegmentService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentService.getUserSegments(groupId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentService.getUserSegments(groupIds);
	}

	@Override
	public int getUserSegmentsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentService.getUserSegmentsCount(groupId);
	}

	@Override
	public int getUserSegmentsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentService.getUserSegmentsCount(groupIds);
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment updateUserSegment(
		long userSegmentId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentService.updateUserSegment(userSegmentId, nameMap,
			descriptionMap, serviceContext);
	}

	@Override
	public UserSegmentService getWrappedService() {
		return _userSegmentService;
	}

	@Override
	public void setWrappedService(UserSegmentService userSegmentService) {
		_userSegmentService = userSegmentService;
	}

	private UserSegmentService _userSegmentService;
}