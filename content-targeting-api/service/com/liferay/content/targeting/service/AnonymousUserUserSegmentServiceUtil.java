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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AnonymousUserUserSegment. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentService
 * @see com.liferay.content.targeting.service.base.AnonymousUserUserSegmentServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentServiceImpl
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment addAnonymousUserUserSegment(
		long anonymousUserId, long userSegmentId, boolean manual,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAnonymousUserUserSegment(anonymousUserId, userSegmentId,
			manual, active, serviceContext);
	}

	public static java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentId(
		long userSegmentId, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAnonymousUsersByUserSegmentId(userSegmentId, active,
			serviceContext);
	}

	public static int getAnonymousUsersByUserSegmentIdCount(
		long userSegmentId, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAnonymousUsersByUserSegmentIdCount(userSegmentId,
			active, serviceContext);
	}

	public static java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentIds(
		long[] userSegmentIds, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAnonymousUsersByUserSegmentIds(userSegmentIds, active,
			serviceContext);
	}

	public static int getAnonymousUsersByUserSegmentIdsCount(
		long[] userSegmentIds, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAnonymousUsersByUserSegmentIdsCount(userSegmentIds,
			active, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByAnonymousUserId(
		long anonymousUserId, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUserSegmentsByAnonymousUserId(anonymousUserId, active,
			serviceContext);
	}

	public static int getUserSegmentsByAnonymousUserIdCount(
		long anonymousUserId, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUserSegmentsByAnonymousUserIdCount(anonymousUserId,
			active, serviceContext);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUserId(
		long userId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentsByUserId(userId, active);
	}

	public static int getUserSegmentsByUserIdCount(long userId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentsByUserIdCount(userId, active);
	}

	public static com.liferay.content.targeting.model.AnonymousUserUserSegment updateAnonymousUserUserSegment(
		long anonymousUserUserSegmentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAnonymousUserUserSegment(anonymousUserUserSegmentId,
			serviceContext);
	}

	public static AnonymousUserUserSegmentService getService() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(AnonymousUserUserSegmentService service) {
	}

	private static ServiceTracker<AnonymousUserUserSegmentService, AnonymousUserUserSegmentService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AnonymousUserUserSegmentServiceUtil.class);

		_serviceTracker = new ServiceTracker<AnonymousUserUserSegmentService, AnonymousUserUserSegmentService>(bundle.getBundleContext(),
				AnonymousUserUserSegmentService.class, null);

		_serviceTracker.open();
	}
}