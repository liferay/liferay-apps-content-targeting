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
 * Provides the remote service utility for ConsumerExtensionInstance. This utility wraps
 * {@link com.liferay.consumer.manager.service.impl.ConsumerExtensionInstanceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstanceService
 * @see com.liferay.consumer.manager.service.base.ConsumerExtensionInstanceServiceBaseImpl
 * @see com.liferay.consumer.manager.service.impl.ConsumerExtensionInstanceServiceImpl
 * @generated
 */
public class ConsumerExtensionInstanceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.consumer.manager.service.impl.ConsumerExtensionInstanceServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance addConsumerExtensionInstance(
		java.lang.String consumerExtensionKey, long consumerId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addConsumerExtensionInstance(consumerExtensionKey,
			consumerId, typeSettings, serviceContext);
	}

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance deleteConsumerExtensionInstance(
		long consumerExtensionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	public static java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
		long consumerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumerExtensionInstances(consumerId);
	}

	public static java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
		long consumerId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getConsumerExtensionInstances(consumerId,
			consumerExtensionKey);
	}

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance updateConsumerExtensionInstance(
		long consumerExtensionInstanceId,
		java.lang.String consumerExtensionKey, long consumerId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConsumerExtensionInstance(consumerExtensionInstanceId,
			consumerExtensionKey, consumerId, typeSettings, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ConsumerExtensionInstanceService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ConsumerExtensionInstanceService.class.getName());

			if (invokableService instanceof ConsumerExtensionInstanceService) {
				_service = (ConsumerExtensionInstanceService)invokableService;
			}
			else {
				_service = new ConsumerExtensionInstanceServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ConsumerExtensionInstanceServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ConsumerExtensionInstanceService service) {
	}

	private static ConsumerExtensionInstanceService _service;
}