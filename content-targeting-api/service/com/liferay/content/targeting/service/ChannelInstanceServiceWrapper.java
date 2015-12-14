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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ChannelInstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstanceService
 * @generated
 */
@ProviderType
public class ChannelInstanceServiceWrapper implements ChannelInstanceService,
	ServiceWrapper<ChannelInstanceService> {
	public ChannelInstanceServiceWrapper(
		ChannelInstanceService channelInstanceService) {
		_channelInstanceService = channelInstanceService;
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance addChannelInstance(
		long userId, long tacticId, java.lang.String channelKey,
		long campaignId, java.lang.String alias, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _channelInstanceService.addChannelInstance(userId, tacticId,
			channelKey, campaignId, alias, typeSettings, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance deleteChannelInstance(
		long channelInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _channelInstanceService.deleteChannelInstance(channelInstanceId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		long campaignId, long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _channelInstanceService.getChannelInstances(campaignId, tacticId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		long tacticId, java.lang.String channelKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _channelInstanceService.getChannelInstances(tacticId, channelKey);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _channelInstanceService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance updateChannelInstance(
		long channelInstanceId, java.lang.String alias,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _channelInstanceService.updateChannelInstance(channelInstanceId,
			alias, typeSettings, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public ChannelInstanceService getWrappedChannelInstanceService() {
		return _channelInstanceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedChannelInstanceService(
		ChannelInstanceService channelInstanceService) {
		_channelInstanceService = channelInstanceService;
	}

	@Override
	public ChannelInstanceService getWrappedService() {
		return _channelInstanceService;
	}

	@Override
	public void setWrappedService(ChannelInstanceService channelInstanceService) {
		_channelInstanceService = channelInstanceService;
	}

	private ChannelInstanceService _channelInstanceService;
}