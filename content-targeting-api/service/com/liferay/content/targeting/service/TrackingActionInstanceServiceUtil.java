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
 * Provides the remote service utility for TrackingActionInstance. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.TrackingActionInstanceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceService
 * @see com.liferay.content.targeting.service.base.TrackingActionInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.TrackingActionInstanceServiceImpl
 * @generated
 */
@ProviderType
public class TrackingActionInstanceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.TrackingActionInstanceServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, long reportInstanceId, java.lang.String trackingActionKey,
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTrackingActionInstance(userId, reportInstanceId,
			trackingActionKey, campaignId, alias, referrerClassName,
			referrerClassPK, elementId, eventType, typeSettings, serviceContext);
	}

	/**
	* @deprecated As of 2.0.0
	*/
	@Deprecated
	public static com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTrackingActionInstance(userId, trackingActionKey,
			campaignId, alias, referrerClassName, referrerClassPK, elementId,
			eventType, typeSettings, serviceContext);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteTrackingActionInstance(trackingActionInstanceId);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		long campaignId, java.lang.String alias) throws java.lang.Exception {
		return getService().fetchTrackingActionInstance(campaignId, alias);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId) {
		return getService().getTrackingActionInstances(campaignId);
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId) {
		return getService()
				   .getTrackingActionInstancesByReportInstanceId(reportInstanceId);
	}

	public static int getTrackingActionInstancesCount(long campaignId) {
		return getService().getTrackingActionInstancesCount(campaignId);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		long trackingActionInstanceId, long reportInstanceId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateTrackingActionInstance(trackingActionInstanceId,
			reportInstanceId, alias, referrerClassName, referrerClassPK,
			elementId, eventType, typeSettings, serviceContext);
	}

	public static TrackingActionInstanceService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TrackingActionInstanceService, TrackingActionInstanceService> _serviceTracker =
		ServiceTrackerFactory.open(TrackingActionInstanceService.class);
}