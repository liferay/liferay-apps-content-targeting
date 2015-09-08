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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnalyticsReferrerService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrerService
 * @generated
 */
public class AnalyticsReferrerServiceWrapper implements AnalyticsReferrerService,
	ServiceWrapper<AnalyticsReferrerService> {
	public AnalyticsReferrerServiceWrapper(
		AnalyticsReferrerService analyticsReferrerService) {
		_analyticsReferrerService = analyticsReferrerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _analyticsReferrerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_analyticsReferrerService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _analyticsReferrerService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> getAnalyticsReferrers(
		long analyticsEventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsReferrerService.getAnalyticsReferrers(analyticsEventId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AnalyticsReferrerService getWrappedAnalyticsReferrerService() {
		return _analyticsReferrerService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAnalyticsReferrerService(
		AnalyticsReferrerService analyticsReferrerService) {
		_analyticsReferrerService = analyticsReferrerService;
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