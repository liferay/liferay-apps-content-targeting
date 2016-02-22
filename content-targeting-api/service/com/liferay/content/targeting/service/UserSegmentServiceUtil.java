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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for UserSegment. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.UserSegmentServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentService
 * @see com.liferay.content.targeting.service.base.UserSegmentServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.UserSegmentServiceImpl
 * @generated
 */
@ProviderType
public class UserSegmentServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.UserSegmentServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.content.targeting.model.UserSegment addUserSegment(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addUserSegment(userId, nameMap, descriptionMap,
			serviceContext);
	}

	public static com.liferay.content.targeting.model.UserSegment deleteUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserSegment(userSegmentId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegments(groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegments(groupIds);
	}

	public static int getUserSegmentsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentsCount(groupId);
	}

	public static int getUserSegmentsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentsCount(groupIds);
	}

	public static com.liferay.content.targeting.model.UserSegment updateUserSegment(
		long userSegmentId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateUserSegment(userSegmentId, nameMap, descriptionMap,
			serviceContext);
	}

	public static UserSegmentService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserSegmentService, UserSegmentService> _serviceTracker =
		ServiceTrackerFactory.open(UserSegmentService.class);
}