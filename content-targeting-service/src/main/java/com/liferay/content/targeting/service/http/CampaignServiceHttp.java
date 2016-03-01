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

import com.liferay.content.targeting.service.CampaignServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link CampaignServiceUtil} service utility. The
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
 * @see CampaignServiceSoap
 * @see HttpPrincipal
 * @see CampaignServiceUtil
 * @generated
 */
@ProviderType
public class CampaignServiceHttp {
	public static com.liferay.content.targeting.model.Campaign addCampaign(
		HttpPrincipal httpPrincipal, long userId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CampaignServiceUtil.class,
					"addCampaign", _addCampaignParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					nameMap, descriptionMap, startDate, endDate, priority,
					active, userSegmentIds, serviceContext);

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

			return (com.liferay.content.targeting.model.Campaign)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.Campaign addCampaign(
		HttpPrincipal httpPrincipal, long userId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CampaignServiceUtil.class,
					"addCampaign", _addCampaignParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					nameMap, descriptionMap, startDate, endDate, timeZoneId,
					priority, active, userSegmentIds, serviceContext);

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

			return (com.liferay.content.targeting.model.Campaign)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.Campaign deleteCampaign(
		HttpPrincipal httpPrincipal, long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CampaignServiceUtil.class,
					"deleteCampaign", _deleteCampaignParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					campaignId);

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

			return (com.liferay.content.targeting.model.Campaign)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.Campaign fetchCurrentMaxPriorityCampaign(
		HttpPrincipal httpPrincipal, long[] groupIds, long[] userSegmentIds) {
		try {
			MethodKey methodKey = new MethodKey(CampaignServiceUtil.class,
					"fetchCurrentMaxPriorityCampaign",
					_fetchCurrentMaxPriorityCampaignParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					groupIds, userSegmentIds);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.content.targeting.model.Campaign)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		HttpPrincipal httpPrincipal, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CampaignServiceUtil.class,
					"getCampaigns", _getCampaignsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

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

			return (java.util.List<com.liferay.content.targeting.model.Campaign>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getCampaignsCount(HttpPrincipal httpPrincipal,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CampaignServiceUtil.class,
					"getCampaignsCount", _getCampaignsCountParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

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

	public static com.liferay.content.targeting.model.Campaign updateCampaign(
		HttpPrincipal httpPrincipal, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CampaignServiceUtil.class,
					"updateCampaign", _updateCampaignParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					campaignId, nameMap, descriptionMap, startDate, endDate,
					priority, active, userSegmentIds, serviceContext);

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

			return (com.liferay.content.targeting.model.Campaign)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.content.targeting.model.Campaign updateCampaign(
		HttpPrincipal httpPrincipal, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CampaignServiceUtil.class,
					"updateCampaign", _updateCampaignParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					campaignId, nameMap, descriptionMap, startDate, endDate,
					timeZoneId, priority, active, userSegmentIds, serviceContext);

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

			return (com.liferay.content.targeting.model.Campaign)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CampaignServiceHttp.class);
	private static final Class<?>[] _addCampaignParameterTypes0 = new Class[] {
			long.class, java.util.Map.class, java.util.Map.class,
			java.util.Date.class, java.util.Date.class, int.class, boolean.class,
			long[].class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _addCampaignParameterTypes1 = new Class[] {
			long.class, java.util.Map.class, java.util.Map.class,
			java.util.Date.class, java.util.Date.class, java.lang.String.class,
			int.class, boolean.class, long[].class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteCampaignParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _fetchCurrentMaxPriorityCampaignParameterTypes3 =
		new Class[] { long[].class, long[].class };
	private static final Class<?>[] _getCampaignsParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCampaignsCountParameterTypes5 = new Class[] {
			long.class
		};
	private static final Class<?>[] _updateCampaignParameterTypes6 = new Class[] {
			long.class, java.util.Map.class, java.util.Map.class,
			java.util.Date.class, java.util.Date.class, int.class, boolean.class,
			long[].class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateCampaignParameterTypes7 = new Class[] {
			long.class, java.util.Map.class, java.util.Map.class,
			java.util.Date.class, java.util.Date.class, java.lang.String.class,
			int.class, boolean.class, long[].class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}