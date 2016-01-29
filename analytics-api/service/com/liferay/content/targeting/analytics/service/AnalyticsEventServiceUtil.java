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

package com.liferay.content.targeting.analytics.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AnalyticsEvent. This utility wraps
 * {@link com.liferay.content.targeting.analytics.service.impl.AnalyticsEventServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventService
 * @see com.liferay.content.targeting.analytics.service.base.AnalyticsEventServiceBaseImpl
 * @see com.liferay.content.targeting.analytics.service.impl.AnalyticsEventServiceImpl
 * @generated
 */
@ProviderType
public class AnalyticsEventServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.analytics.service.impl.AnalyticsEventServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getAnalyticsEvents(className, classPK, eventType, createDate);
	}

	public static java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAnalyticsEvents(companyId, createDate);
	}

	public static java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		java.lang.String elementId, java.lang.String eventType,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAnalyticsEvents(elementId, eventType, createDate);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AnalyticsEventService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnalyticsEventService, AnalyticsEventService> _serviceTracker =
		ServiceTrackerFactory.open(AnalyticsEventService.class);
}