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

package com.liferay.consumer.manager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConsumerReportInstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerReportInstanceService
 * @generated
 */
public class ConsumerReportInstanceServiceWrapper
	implements ConsumerReportInstanceService,
		ServiceWrapper<ConsumerReportInstanceService> {
	public ConsumerReportInstanceServiceWrapper(
		ConsumerReportInstanceService consumerReportInstanceService) {
		_consumerReportInstanceService = consumerReportInstanceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _consumerReportInstanceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_consumerReportInstanceService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _consumerReportInstanceService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerReportInstance addConsumerReportInstance(
		long consumerId, java.lang.String reportKey,
		java.lang.String reportCategoryKey,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerReportInstanceService.addConsumerReportInstance(consumerId,
			reportKey, reportCategoryKey, nameMap, descriptionMap,
			typeSettings, serviceContext);
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerReportInstance updateConsumerReportInstance(
		long consumerReportInstanceId, long consumerId,
		java.lang.String reportKey, java.lang.String reportCategoryKey,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerReportInstanceService.updateConsumerReportInstance(consumerReportInstanceId,
			consumerId, reportKey, reportCategoryKey, nameMap, descriptionMap,
			typeSettings, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ConsumerReportInstanceService getWrappedConsumerReportInstanceService() {
		return _consumerReportInstanceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedConsumerReportInstanceService(
		ConsumerReportInstanceService consumerReportInstanceService) {
		_consumerReportInstanceService = consumerReportInstanceService;
	}

	@Override
	public ConsumerReportInstanceService getWrappedService() {
		return _consumerReportInstanceService;
	}

	@Override
	public void setWrappedService(
		ConsumerReportInstanceService consumerReportInstanceService) {
		_consumerReportInstanceService = consumerReportInstanceService;
	}

	private ConsumerReportInstanceService _consumerReportInstanceService;
}