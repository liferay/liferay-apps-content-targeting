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
 * Provides a wrapper for {@link AnonymousUserUserSegmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentService
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentServiceWrapper
	implements AnonymousUserUserSegmentService,
		ServiceWrapper<AnonymousUserUserSegmentService> {
	public AnonymousUserUserSegmentServiceWrapper(
		AnonymousUserUserSegmentService anonymousUserUserSegmentService) {
		_anonymousUserUserSegmentService = anonymousUserUserSegmentService;
	}

	@Override
	public com.liferay.content.targeting.model.AnonymousUserUserSegment addAnonymousUserUserSegment(
		long anonymousUserId, long userSegmentId, boolean manual,
		boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.addAnonymousUserUserSegment(anonymousUserId,
			userSegmentId, manual, active, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentId(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.getAnonymousUsersByUserSegmentId(userSegmentId,
			active, serviceContext);
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdCount(long userSegmentId,
		boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.getAnonymousUsersByUserSegmentIdCount(userSegmentId,
			active, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentIds(
		long[] userSegmentIds, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.getAnonymousUsersByUserSegmentIds(userSegmentIds,
			active, serviceContext);
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdsCount(long[] userSegmentIds,
		boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.getAnonymousUsersByUserSegmentIdsCount(userSegmentIds,
			active, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _anonymousUserUserSegmentService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByAnonymousUserId(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.getUserSegmentsByAnonymousUserId(anonymousUserId,
			active, serviceContext);
	}

	@Override
	public int getUserSegmentsByAnonymousUserIdCount(long anonymousUserId,
		boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.getUserSegmentsByAnonymousUserIdCount(anonymousUserId,
			active, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUserId(
		long userId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.getUserSegmentsByUserId(userId,
			active);
	}

	@Override
	public int getUserSegmentsByUserIdCount(long userId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.getUserSegmentsByUserIdCount(userId,
			active);
	}

	@Override
	public com.liferay.content.targeting.model.AnonymousUserUserSegment updateAnonymousUserUserSegment(
		long anonymousUserUserSegmentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anonymousUserUserSegmentService.updateAnonymousUserUserSegment(anonymousUserUserSegmentId,
			serviceContext);
	}

	@Override
	public AnonymousUserUserSegmentService getWrappedService() {
		return _anonymousUserUserSegmentService;
	}

	@Override
	public void setWrappedService(
		AnonymousUserUserSegmentService anonymousUserUserSegmentService) {
		_anonymousUserUserSegmentService = anonymousUserUserSegmentService;
	}

	private AnonymousUserUserSegmentService _anonymousUserUserSegmentService;
}