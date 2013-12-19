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

package com.liferay.contenttargeting.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserSegmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentService
 * @generated
 */
public class UserSegmentServiceWrapper implements UserSegmentService,
	ServiceWrapper<UserSegmentService> {
	public UserSegmentServiceWrapper(UserSegmentService userSegmentService) {
		_userSegmentService = userSegmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userSegmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userSegmentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userSegmentService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.contenttargeting.model.UserSegment addUserSegment(
		long userId, java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentService.addUserSegment(userId, name, description,
			serviceContext);
	}

	@Override
	public com.liferay.contenttargeting.model.UserSegment deleteUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentService.deleteUserSegment(userSegmentId);
	}

	@Override
	public java.util.List<com.liferay.contenttargeting.model.UserSegment> getUserSegments(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentService.getUserSegments(groupId);
	}

	@Override
	public long getUserSegmentsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentService.getUserSegmentsCount(groupId);
	}

	@Override
	public com.liferay.contenttargeting.model.UserSegment updateUserSegment(
		long userSegmentId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentService.updateUserSegment(userSegmentId, name,
			description, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserSegmentService getWrappedUserSegmentService() {
		return _userSegmentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserSegmentService(
		UserSegmentService userSegmentService) {
		_userSegmentService = userSegmentService;
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