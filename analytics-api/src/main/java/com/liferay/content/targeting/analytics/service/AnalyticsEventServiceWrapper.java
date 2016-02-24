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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnalyticsEventService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventService
 * @generated
 */
@ProviderType
public class AnalyticsEventServiceWrapper implements AnalyticsEventService,
	ServiceWrapper<AnalyticsEventService> {
	public AnalyticsEventServiceWrapper(
		AnalyticsEventService analyticsEventService) {
		_analyticsEventService = analyticsEventService;
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analyticsEventService.getAnalyticsEvents(className, classPK,
			eventType, createDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analyticsEventService.getAnalyticsEvents(companyId, createDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		java.lang.String elementId, java.lang.String eventType,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analyticsEventService.getAnalyticsEvents(elementId, eventType,
			createDate);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _analyticsEventService.getOSGiServiceIdentifier();
	}

	@Override
	public AnalyticsEventService getWrappedService() {
		return _analyticsEventService;
	}

	@Override
	public void setWrappedService(AnalyticsEventService analyticsEventService) {
		_analyticsEventService = analyticsEventService;
	}

	private AnalyticsEventService _analyticsEventService;
}