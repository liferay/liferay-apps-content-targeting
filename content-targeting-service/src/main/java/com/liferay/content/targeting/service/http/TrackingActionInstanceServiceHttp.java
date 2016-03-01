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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link TrackingActionInstanceServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceServiceSoap
 * @see HttpPrincipal
 * @see TrackingActionInstanceServiceUtil
 * @generated
 */
@ProviderType
public class TrackingActionInstanceServiceHttp {
	public static com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		HttpPrincipal httpPrincipal, long userId, long reportInstanceId,
		java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TrackingActionInstanceServiceUtil.class,
					"addTrackingActionInstance",
					_addTrackingActionInstanceParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					reportInstanceId, trackingActionKey, campaignId, alias,
					referrerClassName, referrerClassPK, elementId, eventType,
					typeSettings, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.TrackingActionInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		HttpPrincipal httpPrincipal, long userId,
		java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TrackingActionInstanceServiceUtil.class,
					"addTrackingActionInstance",
					_addTrackingActionInstanceParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					trackingActionKey, campaignId, alias, referrerClassName,
					referrerClassPK, elementId, eventType, typeSettings,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.TrackingActionInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		HttpPrincipal httpPrincipal, long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TrackingActionInstanceServiceUtil.class,
					"deleteTrackingActionInstance",
					_deleteTrackingActionInstanceParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					trackingActionInstanceId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.TrackingActionInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		HttpPrincipal httpPrincipal, long campaignId, java.lang.String alias)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(TrackingActionInstanceServiceUtil.class,
					"fetchTrackingActionInstance",
					_fetchTrackingActionInstanceParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					campaignId, alias);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.TrackingActionInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		HttpPrincipal httpPrincipal, long campaignId) {
		try {
			MethodKey methodKey = new MethodKey(TrackingActionInstanceServiceUtil.class,
					"getTrackingActionInstances",
					_getTrackingActionInstancesParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					campaignId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.content.targeting.model.TrackingActionInstance>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		HttpPrincipal httpPrincipal, long reportInstanceId) {
		try {
			MethodKey methodKey = new MethodKey(TrackingActionInstanceServiceUtil.class,
					"getTrackingActionInstancesByReportInstanceId",
					_getTrackingActionInstancesByReportInstanceIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					reportInstanceId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.content.targeting.model.TrackingActionInstance>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTrackingActionInstancesCount(
		HttpPrincipal httpPrincipal, long campaignId) {
		try {
			MethodKey methodKey = new MethodKey(TrackingActionInstanceServiceUtil.class,
					"getTrackingActionInstancesCount",
					_getTrackingActionInstancesCountParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					campaignId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		HttpPrincipal httpPrincipal, long trackingActionInstanceId,
		long reportInstanceId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TrackingActionInstanceServiceUtil.class,
					"updateTrackingActionInstance",
					_updateTrackingActionInstanceParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					trackingActionInstanceId, reportInstanceId, alias,
					referrerClassName, referrerClassPK, elementId, eventType,
					typeSettings, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.TrackingActionInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TrackingActionInstanceServiceHttp.class);
	private static final Class<?>[] _addTrackingActionInstanceParameterTypes0 = new Class[] {
			long.class, long.class, java.lang.String.class, long.class,
			java.lang.String.class, java.lang.String.class, long.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _addTrackingActionInstanceParameterTypes1 = new Class[] {
			long.class, java.lang.String.class, long.class,
			java.lang.String.class, java.lang.String.class, long.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteTrackingActionInstanceParameterTypes2 =
		new Class[] { long.class };
	private static final Class<?>[] _fetchTrackingActionInstanceParameterTypes3 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _getTrackingActionInstancesParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getTrackingActionInstancesByReportInstanceIdParameterTypes5 =
		new Class[] { long.class };
	private static final Class<?>[] _getTrackingActionInstancesCountParameterTypes6 =
		new Class[] { long.class };
	private static final Class<?>[] _updateTrackingActionInstanceParameterTypes7 =
		new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class, long.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}