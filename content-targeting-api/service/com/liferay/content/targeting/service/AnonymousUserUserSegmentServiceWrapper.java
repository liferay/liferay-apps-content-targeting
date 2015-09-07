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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnonymousUserUserSegmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentService
 * @generated
 */
public class AnonymousUserUserSegmentServiceWrapper
	implements AnonymousUserUserSegmentService,
		ServiceWrapper<AnonymousUserUserSegmentService> {
	public AnonymousUserUserSegmentServiceWrapper(
		AnonymousUserUserSegmentService anonymousUserUserSegmentService) {
		_anonymousUserUserSegmentService = anonymousUserUserSegmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _anonymousUserUserSegmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_anonymousUserUserSegmentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _anonymousUserUserSegmentService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.content.targeting.model.AnonymousUserUserSegment addAnonymousUserUserSegment(
		long anonymousUserId, long userSegmentId, boolean manual,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegmentService.addAnonymousUserUserSegment(anonymousUserId,
			userSegmentId, manual, active, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentId(
		long userSegmentId, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegmentService.getAnonymousUsersByUserSegmentId(userSegmentId,
			active, serviceContext);
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdCount(long userSegmentId,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegmentService.getAnonymousUsersByUserSegmentIdCount(userSegmentId,
			active, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentIds(
		long[] userSegmentIds, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegmentService.getAnonymousUsersByUserSegmentIds(userSegmentIds,
			active, serviceContext);
	}

	@Override
	public int getAnonymousUsersByUserSegmentIdsCount(long[] userSegmentIds,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegmentService.getAnonymousUsersByUserSegmentIdsCount(userSegmentIds,
			active, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByAnonymousUserId(
		long anonymousUserId, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegmentService.getUserSegmentsByAnonymousUserId(anonymousUserId,
			active, serviceContext);
	}

	@Override
	public int getUserSegmentsByAnonymousUserIdCount(long anonymousUserId,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegmentService.getUserSegmentsByAnonymousUserIdCount(anonymousUserId,
			active, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.AnonymousUserUserSegment updateAnonymousUserUserSegment(
		long anonymousUserUserSegmentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegmentService.updateAnonymousUserUserSegment(anonymousUserUserSegmentId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AnonymousUserUserSegmentService getWrappedAnonymousUserUserSegmentService() {
		return _anonymousUserUserSegmentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAnonymousUserUserSegmentService(
		AnonymousUserUserSegmentService anonymousUserUserSegmentService) {
		_anonymousUserUserSegmentService = anonymousUserUserSegmentService;
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