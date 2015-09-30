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

import com.liferay.consumer.manager.service.ConsumerServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.consumer.manager.service.ConsumerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.consumer.manager.model.ConsumerSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.consumer.manager.model.Consumer}, that is translated to a
 * {@link com.liferay.consumer.manager.model.ConsumerSoap}. Methods that SOAP cannot
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
 * @see ConsumerServiceHttp
 * @see com.liferay.consumer.manager.model.ConsumerSoap
 * @see com.liferay.consumer.manager.service.ConsumerServiceUtil
 * @generated
 */
public class ConsumerServiceSoap {
	public static com.liferay.consumer.manager.model.ConsumerSoap addConsumer(
		java.lang.String consumerKey,
		java.lang.String[] descriptionMapLanguageIds,
		java.lang.String[] descriptionMapValues,
		java.lang.String[] nameMapLanguageIds,
		java.lang.String[] nameMapValues,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(descriptionMapLanguageIds,
					descriptionMapValues);
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(nameMapLanguageIds,
					nameMapValues);

			com.liferay.consumer.manager.model.Consumer returnValue = ConsumerServiceUtil.addConsumer(consumerKey,
					descriptionMap, nameMap, serviceContext);

			return com.liferay.consumer.manager.model.ConsumerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerSoap deleteConsumer(
		long consumerId) throws RemoteException {
		try {
			com.liferay.consumer.manager.model.Consumer returnValue = ConsumerServiceUtil.deleteConsumer(consumerId);

			return com.liferay.consumer.manager.model.ConsumerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerSoap getConsumer(
		long companyId, java.lang.String consumerKey) throws RemoteException {
		try {
			com.liferay.consumer.manager.model.Consumer returnValue = ConsumerServiceUtil.getConsumer(companyId,
					consumerKey);

			return com.liferay.consumer.manager.model.ConsumerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerSoap[] getConsumers()
		throws RemoteException {
		try {
			java.util.List<com.liferay.consumer.manager.model.Consumer> returnValue =
				ConsumerServiceUtil.getConsumers();

			return com.liferay.consumer.manager.model.ConsumerSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerSoap[] getConsumers(
		long companyId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.consumer.manager.model.Consumer> returnValue =
				ConsumerServiceUtil.getConsumers(companyId, serviceContext);

			return com.liferay.consumer.manager.model.ConsumerSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerSoap[] getConsumersByConsumerExtensionKey(
		long companyId, java.lang.String consumerExtensionKey)
		throws RemoteException {
		try {
			java.util.List<com.liferay.consumer.manager.model.Consumer> returnValue =
				ConsumerServiceUtil.getConsumersByConsumerExtensionKey(companyId,
					consumerExtensionKey);

			return com.liferay.consumer.manager.model.ConsumerSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.consumer.manager.model.ConsumerSoap updateConsumer(
		long consumerId, java.lang.String consumerKey,
		java.lang.String[] descriptionMapLanguageIds,
		java.lang.String[] descriptionMapValues,
		java.lang.String[] nameMapLanguageIds,
		java.lang.String[] nameMapValues,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(descriptionMapLanguageIds,
					descriptionMapValues);
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(nameMapLanguageIds,
					nameMapValues);

			com.liferay.consumer.manager.model.Consumer returnValue = ConsumerServiceUtil.updateConsumer(consumerId,
					consumerKey, descriptionMap, nameMap, serviceContext);

			return com.liferay.consumer.manager.model.ConsumerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ConsumerServiceSoap.class);
}