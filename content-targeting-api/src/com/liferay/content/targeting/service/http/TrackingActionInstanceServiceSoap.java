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

package com.liferay.content.targeting.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.service.TrackingActionInstanceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link TrackingActionInstanceServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.content.targeting.model.TrackingActionInstanceSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.content.targeting.model.TrackingActionInstance}, that is translated to a
 * {@link com.liferay.content.targeting.model.TrackingActionInstanceSoap}. Methods that SOAP cannot
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
 * @see TrackingActionInstanceServiceHttp
 * @see com.liferay.content.targeting.model.TrackingActionInstanceSoap
 * @see TrackingActionInstanceServiceUtil
 * @generated
 */
@ProviderType
public class TrackingActionInstanceServiceSoap {
	public static com.liferay.content.targeting.model.TrackingActionInstanceSoap addTrackingActionInstance(
		long userId, long reportInstanceId, java.lang.String trackingActionKey,
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.content.targeting.model.TrackingActionInstance returnValue =
				TrackingActionInstanceServiceUtil.addTrackingActionInstance(userId,
					reportInstanceId, trackingActionKey, campaignId, alias,
					referrerClassName, referrerClassPK, elementId, eventType,
					typeSettings, serviceContext);

			return com.liferay.content.targeting.model.TrackingActionInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* @deprecated As of 2.0.0
	*/
	@Deprecated
	public static com.liferay.content.targeting.model.TrackingActionInstanceSoap addTrackingActionInstance(
		long userId, java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.content.targeting.model.TrackingActionInstance returnValue =
				TrackingActionInstanceServiceUtil.addTrackingActionInstance(userId,
					trackingActionKey, campaignId, alias, referrerClassName,
					referrerClassPK, elementId, eventType, typeSettings,
					serviceContext);

			return com.liferay.content.targeting.model.TrackingActionInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstanceSoap deleteTrackingActionInstance(
		long trackingActionInstanceId) throws RemoteException {
		try {
			com.liferay.content.targeting.model.TrackingActionInstance returnValue =
				TrackingActionInstanceServiceUtil.deleteTrackingActionInstance(trackingActionInstanceId);

			return com.liferay.content.targeting.model.TrackingActionInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstanceSoap fetchTrackingActionInstance(
		long campaignId, java.lang.String alias) throws RemoteException {
		try {
			com.liferay.content.targeting.model.TrackingActionInstance returnValue =
				TrackingActionInstanceServiceUtil.fetchTrackingActionInstance(campaignId,
					alias);

			return com.liferay.content.targeting.model.TrackingActionInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstanceSoap[] getTrackingActionInstances(
		long campaignId) throws RemoteException {
		try {
			java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> returnValue =
				TrackingActionInstanceServiceUtil.getTrackingActionInstances(campaignId);

			return com.liferay.content.targeting.model.TrackingActionInstanceSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstanceSoap[] getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId) throws RemoteException {
		try {
			java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> returnValue =
				TrackingActionInstanceServiceUtil.getTrackingActionInstancesByReportInstanceId(reportInstanceId);

			return com.liferay.content.targeting.model.TrackingActionInstanceSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getTrackingActionInstancesCount(long campaignId)
		throws RemoteException {
		try {
			int returnValue = TrackingActionInstanceServiceUtil.getTrackingActionInstancesCount(campaignId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstanceSoap updateTrackingActionInstance(
		long trackingActionInstanceId, long reportInstanceId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.content.targeting.model.TrackingActionInstance returnValue =
				TrackingActionInstanceServiceUtil.updateTrackingActionInstance(trackingActionInstanceId,
					reportInstanceId, alias, referrerClassName,
					referrerClassPK, elementId, eventType, typeSettings,
					serviceContext);

			return com.liferay.content.targeting.model.TrackingActionInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TrackingActionInstanceServiceSoap.class);
}