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

import com.liferay.content.targeting.service.ReportInstanceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link ReportInstanceServiceUtil} service utility. The
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
 * @see ReportInstanceServiceSoap
 * @see HttpPrincipal
 * @see ReportInstanceServiceUtil
 * @generated
 */
@ProviderType
public class ReportInstanceServiceHttp {
	public static com.liferay.content.targeting.model.ReportInstance addReportInstance(
		HttpPrincipal httpPrincipal, long userId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ReportInstanceServiceUtil.class,
					"addReportInstance", _addReportInstanceParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					reportKey, className, classPK, nameMap, descriptionMap,
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

			return (com.liferay.content.targeting.model.ReportInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.ReportInstance addReportInstance(
		HttpPrincipal httpPrincipal, long userId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ReportInstanceServiceUtil.class,
					"addReportInstance", _addReportInstanceParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					reportKey, className, classPK, typeSettings, serviceContext);

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

			return (com.liferay.content.targeting.model.ReportInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		HttpPrincipal httpPrincipal, long reportInstanceId) {
		try {
			MethodKey methodKey = new MethodKey(ReportInstanceServiceUtil.class,
					"fetchReportInstance", _fetchReportInstanceParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					reportInstanceId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.ReportInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		HttpPrincipal httpPrincipal, java.lang.String reportKey,
		java.lang.String className, long classPK) {
		try {
			MethodKey methodKey = new MethodKey(ReportInstanceServiceUtil.class,
					"fetchReportInstance", _fetchReportInstanceParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					reportKey, className, classPK);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.ReportInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> findReportInstances(
		HttpPrincipal httpPrincipal, java.lang.String reportKey,
		java.lang.String className, long classPK) {
		try {
			MethodKey methodKey = new MethodKey(ReportInstanceServiceUtil.class,
					"findReportInstances", _findReportInstancesParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					reportKey, className, classPK);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.content.targeting.model.ReportInstance>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		HttpPrincipal httpPrincipal, java.lang.String className, long classPK) {
		try {
			MethodKey methodKey = new MethodKey(ReportInstanceServiceUtil.class,
					"getReportInstances", _getReportInstancesParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					className, classPK);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.content.targeting.model.ReportInstance>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		HttpPrincipal httpPrincipal, long reportInstanceId, long userId,
		java.lang.String reportKey, java.lang.String className, long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ReportInstanceServiceUtil.class,
					"updateReportInstance", _updateReportInstanceParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					reportInstanceId, userId, reportKey, className, classPK,
					nameMap, descriptionMap, typeSettings, serviceContext);

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

			return (com.liferay.content.targeting.model.ReportInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		HttpPrincipal httpPrincipal,
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		try {
			MethodKey methodKey = new MethodKey(ReportInstanceServiceUtil.class,
					"updateReportInstance", _updateReportInstanceParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					reportInstance);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.ReportInstance)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ReportInstanceServiceHttp.class);
	private static final Class<?>[] _addReportInstanceParameterTypes0 = new Class[] {
			long.class, java.lang.String.class, java.lang.String.class,
			long.class, java.util.Map.class, java.util.Map.class,
			java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _addReportInstanceParameterTypes1 = new Class[] {
			long.class, java.lang.String.class, java.lang.String.class,
			long.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _fetchReportInstanceParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _fetchReportInstanceParameterTypes3 = new Class[] {
			java.lang.String.class, java.lang.String.class, long.class
		};
	private static final Class<?>[] _findReportInstancesParameterTypes4 = new Class[] {
			java.lang.String.class, java.lang.String.class, long.class
		};
	private static final Class<?>[] _getReportInstancesParameterTypes5 = new Class[] {
			java.lang.String.class, long.class
		};
	private static final Class<?>[] _updateReportInstanceParameterTypes6 = new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class, long.class, java.util.Map.class,
			java.util.Map.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateReportInstanceParameterTypes7 = new Class[] {
			com.liferay.content.targeting.model.ReportInstance.class
		};
}