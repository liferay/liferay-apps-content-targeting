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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link AnonymousUserUserSegmentServiceUtil} service utility. The
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
 * @see AnonymousUserUserSegmentServiceSoap
 * @see HttpPrincipal
 * @see AnonymousUserUserSegmentServiceUtil
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentServiceHttp {
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment addAnonymousUserUserSegment(
		HttpPrincipal httpPrincipal, long anonymousUserId, long userSegmentId,
		boolean manual, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"addAnonymousUserUserSegment",
					_addAnonymousUserUserSegmentParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					anonymousUserId, userSegmentId, manual, active,
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

			return (com.liferay.content.targeting.model.AnonymousUserUserSegment)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentId(
		HttpPrincipal httpPrincipal, long userSegmentId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"getAnonymousUsersByUserSegmentId",
					_getAnonymousUsersByUserSegmentIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					userSegmentId, active, serviceContext);

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

			return (java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getAnonymousUsersByUserSegmentIdCount(
		HttpPrincipal httpPrincipal, long userSegmentId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"getAnonymousUsersByUserSegmentIdCount",
					_getAnonymousUsersByUserSegmentIdCountParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					userSegmentId, active, serviceContext);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentIds(
		HttpPrincipal httpPrincipal, long[] userSegmentIds, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"getAnonymousUsersByUserSegmentIds",
					_getAnonymousUsersByUserSegmentIdsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					userSegmentIds, active, serviceContext);

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

			return (java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getAnonymousUsersByUserSegmentIdsCount(
		HttpPrincipal httpPrincipal, long[] userSegmentIds, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"getAnonymousUsersByUserSegmentIdsCount",
					_getAnonymousUsersByUserSegmentIdsCountParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					userSegmentIds, active, serviceContext);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByAnonymousUserId(
		HttpPrincipal httpPrincipal, long anonymousUserId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"getUserSegmentsByAnonymousUserId",
					_getUserSegmentsByAnonymousUserIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					anonymousUserId, active, serviceContext);

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

			return (java.util.List<com.liferay.content.targeting.model.UserSegment>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getUserSegmentsByAnonymousUserIdCount(
		HttpPrincipal httpPrincipal, long anonymousUserId, boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"getUserSegmentsByAnonymousUserIdCount",
					_getUserSegmentsByAnonymousUserIdCountParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					anonymousUserId, active, serviceContext);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUserId(
		HttpPrincipal httpPrincipal, long userId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"getUserSegmentsByUserId",
					_getUserSegmentsByUserIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					active);

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

			return (java.util.List<com.liferay.content.targeting.model.UserSegment>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getUserSegmentsByUserIdCount(
		HttpPrincipal httpPrincipal, long userId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"getUserSegmentsByUserIdCount",
					_getUserSegmentsByUserIdCountParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					active);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.AnonymousUserUserSegment updateAnonymousUserUserSegment(
		HttpPrincipal httpPrincipal, long anonymousUserUserSegmentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AnonymousUserUserSegmentServiceUtil.class,
					"updateAnonymousUserUserSegment",
					_updateAnonymousUserUserSegmentParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					anonymousUserUserSegmentId, serviceContext);

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

			return (com.liferay.content.targeting.model.AnonymousUserUserSegment)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AnonymousUserUserSegmentServiceHttp.class);
	private static final Class<?>[] _addAnonymousUserUserSegmentParameterTypes0 = new Class[] {
			long.class, long.class, boolean.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getAnonymousUsersByUserSegmentIdParameterTypes1 =
		new Class[] {
			long.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getAnonymousUsersByUserSegmentIdCountParameterTypes2 =
		new Class[] {
			long.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getAnonymousUsersByUserSegmentIdsParameterTypes3 =
		new Class[] {
			long[].class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getAnonymousUsersByUserSegmentIdsCountParameterTypes4 =
		new Class[] {
			long[].class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getUserSegmentsByAnonymousUserIdParameterTypes5 =
		new Class[] {
			long.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getUserSegmentsByAnonymousUserIdCountParameterTypes6 =
		new Class[] {
			long.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getUserSegmentsByUserIdParameterTypes7 = new Class[] {
			long.class, boolean.class
		};
	private static final Class<?>[] _getUserSegmentsByUserIdCountParameterTypes8 =
		new Class[] { long.class, boolean.class };
	private static final Class<?>[] _updateAnonymousUserUserSegmentParameterTypes9 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
}