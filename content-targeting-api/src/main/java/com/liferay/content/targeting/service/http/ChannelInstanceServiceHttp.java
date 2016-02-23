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

import com.liferay.content.targeting.service.ChannelInstanceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link ChannelInstanceServiceUtil} service utility. The
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
 * @see ChannelInstanceServiceSoap
 * @see HttpPrincipal
 * @see ChannelInstanceServiceUtil
 * @generated
 */
@ProviderType
public class ChannelInstanceServiceHttp {
	public static com.liferay.content.targeting.model.ChannelInstance addChannelInstance(
		HttpPrincipal httpPrincipal, long userId, long tacticId,
		java.lang.String channelKey, long campaignId, java.lang.String alias,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ChannelInstanceServiceUtil.class,
					"addChannelInstance", _addChannelInstanceParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					tacticId, channelKey, campaignId, alias, typeSettings,
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

			return (com.liferay.content.targeting.model.ChannelInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.ChannelInstance deleteChannelInstance(
		HttpPrincipal httpPrincipal, long channelInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ChannelInstanceServiceUtil.class,
					"deleteChannelInstance",
					_deleteChannelInstanceParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					channelInstanceId);

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

			return (com.liferay.content.targeting.model.ChannelInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		HttpPrincipal httpPrincipal, long campaignId, long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ChannelInstanceServiceUtil.class,
					"getChannelInstances", _getChannelInstancesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					campaignId, tacticId);

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

			return (java.util.List<com.liferay.content.targeting.model.ChannelInstance>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		HttpPrincipal httpPrincipal, long tacticId, java.lang.String channelKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ChannelInstanceServiceUtil.class,
					"getChannelInstances", _getChannelInstancesParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					tacticId, channelKey);

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

			return (java.util.List<com.liferay.content.targeting.model.ChannelInstance>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.ChannelInstance updateChannelInstance(
		HttpPrincipal httpPrincipal, long channelInstanceId,
		java.lang.String alias, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ChannelInstanceServiceUtil.class,
					"updateChannelInstance",
					_updateChannelInstanceParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					channelInstanceId, alias, typeSettings, serviceContext);

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

			return (com.liferay.content.targeting.model.ChannelInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ChannelInstanceServiceHttp.class);
	private static final Class<?>[] _addChannelInstanceParameterTypes0 = new Class[] {
			long.class, long.class, java.lang.String.class, long.class,
			java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteChannelInstanceParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getChannelInstancesParameterTypes2 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getChannelInstancesParameterTypes3 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _updateChannelInstanceParameterTypes4 = new Class[] {
			long.class, java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}