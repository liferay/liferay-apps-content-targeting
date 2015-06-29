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
 * Provides a wrapper for {@link TrackingActionInstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceService
 * @generated
 */
public class TrackingActionInstanceServiceWrapper
	implements TrackingActionInstanceService,
		ServiceWrapper<TrackingActionInstanceService> {
	public TrackingActionInstanceServiceWrapper(
		TrackingActionInstanceService trackingActionInstanceService) {
		_trackingActionInstanceService = trackingActionInstanceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _trackingActionInstanceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trackingActionInstanceService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _trackingActionInstanceService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.content.targeting.service.TrackingActionInstanceServiceUtil} to access the tracking action instance remote service.
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceService.addTrackingActionInstance(userId,
			trackingActionKey, campaignId, alias, referrerClassName,
			referrerClassPK, elementId, eventType, typeSettings, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceService.deleteTrackingActionInstance(trackingActionInstanceId);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		long campaignId, java.lang.String alias) throws java.lang.Exception {
		return _trackingActionInstanceService.fetchTrackingActionInstance(campaignId,
			alias);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceService.getTrackingActionInstances(campaignId);
	}

	@Override
	public int getTrackingActionInstancesCount(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceService.getTrackingActionInstancesCount(campaignId);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		long trackingActionInstanceId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceService.updateTrackingActionInstance(trackingActionInstanceId,
			alias, referrerClassName, referrerClassPK, elementId, eventType,
			typeSettings, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TrackingActionInstanceService getWrappedTrackingActionInstanceService() {
		return _trackingActionInstanceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTrackingActionInstanceService(
		TrackingActionInstanceService trackingActionInstanceService) {
		_trackingActionInstanceService = trackingActionInstanceService;
	}

	@Override
	public TrackingActionInstanceService getWrappedService() {
		return _trackingActionInstanceService;
	}

	@Override
	public void setWrappedService(
		TrackingActionInstanceService trackingActionInstanceService) {
		_trackingActionInstanceService = trackingActionInstanceService;
	}

	private TrackingActionInstanceService _trackingActionInstanceService;
}