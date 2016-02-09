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

import com.liferay.content.targeting.service.AnonymousUserUserSegmentServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link AnonymousUserUserSegmentServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.content.targeting.model.AnonymousUserUserSegmentSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.content.targeting.model.AnonymousUserUserSegment}, that is translated to a
 * {@link com.liferay.content.targeting.model.AnonymousUserUserSegmentSoap}. Methods that SOAP cannot
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
 * @see AnonymousUserUserSegmentServiceHttp
 * @see com.liferay.content.targeting.model.AnonymousUserUserSegmentSoap
 * @see AnonymousUserUserSegmentServiceUtil
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentServiceSoap {
	public static com.liferay.content.targeting.model.AnonymousUserUserSegmentSoap addAnonymousUserUserSegment(
		long anonymousUserId, long userSegmentId, boolean manual,
		boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.content.targeting.model.AnonymousUserUserSegment returnValue =
				AnonymousUserUserSegmentServiceUtil.addAnonymousUserUserSegment(anonymousUserId,
					userSegmentId, manual, active, serviceContext);

			return com.liferay.content.targeting.model.AnonymousUserUserSegmentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.anonymous.users.model.AnonymousUserSoap[] getAnonymousUsersByUserSegmentId(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> returnValue =
				AnonymousUserUserSegmentServiceUtil.getAnonymousUsersByUserSegmentId(userSegmentId,
					active, serviceContext);

			return com.liferay.content.targeting.anonymous.users.model.AnonymousUserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getAnonymousUsersByUserSegmentIdCount(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = AnonymousUserUserSegmentServiceUtil.getAnonymousUsersByUserSegmentIdCount(userSegmentId,
					active, serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.anonymous.users.model.AnonymousUserSoap[] getAnonymousUsersByUserSegmentIds(
		long[] userSegmentIds, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> returnValue =
				AnonymousUserUserSegmentServiceUtil.getAnonymousUsersByUserSegmentIds(userSegmentIds,
					active, serviceContext);

			return com.liferay.content.targeting.anonymous.users.model.AnonymousUserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getAnonymousUsersByUserSegmentIdsCount(
		long[] userSegmentIds, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = AnonymousUserUserSegmentServiceUtil.getAnonymousUsersByUserSegmentIdsCount(userSegmentIds,
					active, serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.model.UserSegmentSoap[] getUserSegmentsByAnonymousUserId(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.content.targeting.model.UserSegment> returnValue =
				AnonymousUserUserSegmentServiceUtil.getUserSegmentsByAnonymousUserId(anonymousUserId,
					active, serviceContext);

			return com.liferay.content.targeting.model.UserSegmentSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getUserSegmentsByAnonymousUserIdCount(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = AnonymousUserUserSegmentServiceUtil.getUserSegmentsByAnonymousUserIdCount(anonymousUserId,
					active, serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.model.UserSegmentSoap[] getUserSegmentsByUserId(
		long userId, boolean active) throws RemoteException {
		try {
			java.util.List<com.liferay.content.targeting.model.UserSegment> returnValue =
				AnonymousUserUserSegmentServiceUtil.getUserSegmentsByUserId(userId,
					active);

			return com.liferay.content.targeting.model.UserSegmentSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getUserSegmentsByUserIdCount(long userId, boolean active)
		throws RemoteException {
		try {
			int returnValue = AnonymousUserUserSegmentServiceUtil.getUserSegmentsByUserIdCount(userId,
					active);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.content.targeting.model.AnonymousUserUserSegmentSoap updateAnonymousUserUserSegment(
		long anonymousUserUserSegmentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.content.targeting.model.AnonymousUserUserSegment returnValue =
				AnonymousUserUserSegmentServiceUtil.updateAnonymousUserUserSegment(anonymousUserUserSegmentId,
					serviceContext);

			return com.liferay.content.targeting.model.AnonymousUserUserSegmentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AnonymousUserUserSegmentServiceSoap.class);
}