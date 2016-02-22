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

import com.liferay.content.targeting.service.RuleInstanceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link RuleInstanceServiceUtil} service utility. The
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
 * @see RuleInstanceServiceSoap
 * @see HttpPrincipal
 * @see RuleInstanceServiceUtil
 * @generated
 */
@ProviderType
public class RuleInstanceServiceHttp {
	public static com.liferay.content.targeting.model.RuleInstance addRuleInstance(
		HttpPrincipal httpPrincipal, long userId, java.lang.String ruleKey,
		long userSegmentId, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(RuleInstanceServiceUtil.class,
					"addRuleInstance", _addRuleInstanceParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					ruleKey, userSegmentId, typeSettings, serviceContext);

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

			return (com.liferay.content.targeting.model.RuleInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.RuleInstance deleteRuleInstance(
		HttpPrincipal httpPrincipal, long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(RuleInstanceServiceUtil.class,
					"deleteRuleInstance", _deleteRuleInstanceParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					ruleInstanceId);

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

			return (com.liferay.content.targeting.model.RuleInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		HttpPrincipal httpPrincipal, long userSegmentId) {
		try {
			MethodKey methodKey = new MethodKey(RuleInstanceServiceUtil.class,
					"getRuleInstances", _getRuleInstancesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					userSegmentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.content.targeting.model.RuleInstance>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static long getRuleInstancesCount(HttpPrincipal httpPrincipal,
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(RuleInstanceServiceUtil.class,
					"getRuleInstancesCount",
					_getRuleInstancesCountParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					userSegmentId);

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

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.RuleInstance updateRuleInstance(
		HttpPrincipal httpPrincipal, long ruleInstanceId,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(RuleInstanceServiceUtil.class,
					"updateRuleInstance", _updateRuleInstanceParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					ruleInstanceId, typeSettings, serviceContext);

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

			return (com.liferay.content.targeting.model.RuleInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RuleInstanceServiceHttp.class);
	private static final Class<?>[] _addRuleInstanceParameterTypes0 = new Class[] {
			long.class, java.lang.String.class, long.class,
			java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteRuleInstanceParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getRuleInstancesParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getRuleInstancesCountParameterTypes3 = new Class[] {
			long.class
		};
	private static final Class<?>[] _updateRuleInstanceParameterTypes4 = new Class[] {
			long.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}