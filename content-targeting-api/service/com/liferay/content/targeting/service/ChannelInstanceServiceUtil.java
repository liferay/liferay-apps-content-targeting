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

package com.liferay.content.targeting.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ChannelInstance. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.ChannelInstanceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstanceService
 * @see com.liferay.content.targeting.service.base.ChannelInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.ChannelInstanceServiceImpl
 * @generated
 */
@ProviderType
public class ChannelInstanceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.ChannelInstanceServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.content.targeting.model.ChannelInstance addChannelInstance(
		long userId, long tacticId, java.lang.String channelKey,
		long campaignId, java.lang.String alias, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addChannelInstance(userId, tacticId, channelKey,
			campaignId, alias, typeSettings, serviceContext);
	}

	public static com.liferay.content.targeting.model.ChannelInstance deleteChannelInstance(
		long channelInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteChannelInstance(channelInstanceId);
	}

	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		long campaignId, long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getChannelInstances(campaignId, tacticId);
	}

	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		long tacticId, java.lang.String channelKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getChannelInstances(tacticId, channelKey);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.content.targeting.model.ChannelInstance updateChannelInstance(
		long channelInstanceId, java.lang.String alias,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateChannelInstance(channelInstanceId, alias,
			typeSettings, serviceContext);
	}

	public static ChannelInstanceService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ChannelInstanceService, ChannelInstanceService> _serviceTracker =
		ServiceTrackerFactory.open(ChannelInstanceService.class);
}