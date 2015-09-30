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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Consumer. This utility wraps
 * {@link com.liferay.consumer.manager.service.impl.ConsumerServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerService
 * @see com.liferay.consumer.manager.service.base.ConsumerServiceBaseImpl
 * @see com.liferay.consumer.manager.service.impl.ConsumerServiceImpl
 * @generated
 */
public class ConsumerServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.consumer.manager.service.impl.ConsumerServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.consumer.manager.model.Consumer addConsumer(
		java.lang.String consumerKey,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addConsumer(consumerKey, descriptionMap, nameMap,
			serviceContext);
	}

	public static com.liferay.consumer.manager.model.Consumer deleteConsumer(
		long consumerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConsumer(consumerId);
	}

	public static com.liferay.consumer.manager.model.Consumer getConsumer(
		long companyId, java.lang.String consumerKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumer(companyId, consumerKey);
	}

	public static java.util.List<com.liferay.consumer.manager.model.Consumer> getConsumers()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumers();
	}

	public static java.util.List<com.liferay.consumer.manager.model.Consumer> getConsumers(
		long companyId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumers(companyId, serviceContext);
	}

	public static java.util.List<com.liferay.consumer.manager.model.Consumer> getConsumersByConsumerExtensionKey(
		long companyId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getConsumersByConsumerExtensionKey(companyId,
			consumerExtensionKey);
	}

	public static com.liferay.consumer.manager.model.Consumer updateConsumer(
		long consumerId, java.lang.String consumerKey,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConsumer(consumerId, consumerKey, descriptionMap,
			nameMap, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ConsumerService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ConsumerService.class.getName());

			if (invokableService instanceof ConsumerService) {
				_service = (ConsumerService)invokableService;
			}
			else {
				_service = new ConsumerServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ConsumerServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ConsumerService service) {
	}

	private static ConsumerService _service;
}