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
 * Provides a wrapper for {@link TrackingActionInstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceService
 * @generated
 */
@ProviderType
public class TrackingActionInstanceServiceWrapper
	implements TrackingActionInstanceService,
		ServiceWrapper<TrackingActionInstanceService> {
	public TrackingActionInstanceServiceWrapper(
		TrackingActionInstanceService trackingActionInstanceService) {
		_trackingActionInstanceService = trackingActionInstanceService;
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, long reportInstanceId, java.lang.String trackingActionKey,
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _trackingActionInstanceService.addTrackingActionInstance(userId,
			reportInstanceId, trackingActionKey, campaignId, alias,
			referrerClassName, referrerClassPK, elementId, eventType,
			typeSettings, serviceContext);
	}

	/**
	* @deprecated As of 2.0.0
	*/
	@Deprecated
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _trackingActionInstanceService.addTrackingActionInstance(userId,
			trackingActionKey, campaignId, alias, referrerClassName,
			referrerClassPK, elementId, eventType, typeSettings, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _trackingActionInstanceService.deleteTrackingActionInstance(trackingActionInstanceId);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		long campaignId, java.lang.String alias) throws java.lang.Exception {
		return _trackingActionInstanceService.fetchTrackingActionInstance(campaignId,
			alias);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _trackingActionInstanceService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId) {
		return _trackingActionInstanceService.getTrackingActionInstances(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId) {
		return _trackingActionInstanceService.getTrackingActionInstancesByReportInstanceId(reportInstanceId);
	}

	@Override
	public int getTrackingActionInstancesCount(long campaignId) {
		return _trackingActionInstanceService.getTrackingActionInstancesCount(campaignId);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		long trackingActionInstanceId, long reportInstanceId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _trackingActionInstanceService.updateTrackingActionInstance(trackingActionInstanceId,
			reportInstanceId, alias, referrerClassName, referrerClassPK,
			elementId, eventType, typeSettings, serviceContext);
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