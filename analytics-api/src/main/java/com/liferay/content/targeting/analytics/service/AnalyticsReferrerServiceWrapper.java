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
 * Provides a wrapper for {@link AnalyticsReferrerService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrerService
 * @generated
 */
@ProviderType
public class AnalyticsReferrerServiceWrapper implements AnalyticsReferrerService,
	ServiceWrapper<AnalyticsReferrerService> {
	public AnalyticsReferrerServiceWrapper(
		AnalyticsReferrerService analyticsReferrerService) {
		_analyticsReferrerService = analyticsReferrerService;
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> getAnalyticsReferrers(
		long analyticsEventId) {
		return _analyticsReferrerService.getAnalyticsReferrers(analyticsEventId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _analyticsReferrerService.getOSGiServiceIdentifier();
	}

	@Override
	public AnalyticsReferrerService getWrappedService() {
		return _analyticsReferrerService;
	}

	@Override
	public void setWrappedService(
		AnalyticsReferrerService analyticsReferrerService) {
		_analyticsReferrerService = analyticsReferrerService;
	}

	private AnalyticsReferrerService _analyticsReferrerService;
}