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

package com.liferay.consumer.manager.service.http;

import com.liferay.consumer.manager.service.ConsumerExtensionInstanceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.consumer.manager.service.ConsumerExtensionInstanceServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.consumer.manager.model.ConsumerExtensionInstance}, that is translated to a
 * {@link com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstanceServiceHttp
 * @see com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap
 * @see com.liferay.consumer.manager.service.ConsumerExtensionInstanceServiceUtil
 * @generated
 */
public class ConsumerExtensionInstanceServiceSoap {
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap addConsumerExtensionInstance(
		java.lang.String consumerExtensionKey, long consumerId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.consumer.manager.model.ConsumerExtensionInstance returnValue =
				ConsumerExtensionInstanceServiceUtil.addConsumerExtensionInstance(consumerExtensionKey,
					consumerId, typeSettings, serviceContext);

			return com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap deleteConsumerExtensionInstance(
		long consumerExtensionInstanceId) throws RemoteException {
		try {
			com.liferay.consumer.manager.model.ConsumerExtensionInstance returnValue =
				ConsumerExtensionInstanceServiceUtil.deleteConsumerExtensionInstance(consumerExtensionInstanceId);

			return com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap[] getConsumerExtensionInstances(
		long consumerId) throws RemoteException {
		try {
			java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> returnValue =
				ConsumerExtensionInstanceServiceUtil.getConsumerExtensionInstances(consumerId);

			return com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap[] getConsumerExtensionInstances(
		long consumerId, java.lang.String consumerExtensionKey)
		throws RemoteException {
		try {
			java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> returnValue =
				ConsumerExtensionInstanceServiceUtil.getConsumerExtensionInstances(consumerId,
					consumerExtensionKey);

			return com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap updateConsumerExtensionInstance(
		long consumerExtensionInstanceId,
		java.lang.String consumerExtensionKey, long consumerId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.consumer.manager.model.ConsumerExtensionInstance returnValue =
				ConsumerExtensionInstanceServiceUtil.updateConsumerExtensionInstance(consumerExtensionInstanceId,
					consumerExtensionKey, consumerId, typeSettings,
					serviceContext);

			return com.liferay.consumer.manager.model.ConsumerExtensionInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ConsumerExtensionInstanceServiceSoap.class);
}