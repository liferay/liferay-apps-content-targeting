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

package com.liferay.content.targeting.service.impl;

import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.service.base.ChannelInstanceServiceBaseImpl;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the channel instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.ChannelInstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.ChannelInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.ChannelInstanceServiceUtil
 */
public class ChannelInstanceServiceImpl extends ChannelInstanceServiceBaseImpl {

	@Override
	public ChannelInstance addChannelInstance(
			long userId, long tacticId, String channelKey, long campaignId,
			String alias, String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		CampaignPermission.check(
			getPermissionChecker(), campaignId, ActionKeys.UPDATE);

		return channelInstanceLocalService.addChannelInstance(
			userId, tacticId, channelKey, campaignId, alias, typeSettings,
			serviceContext);
	}

	@Override
	public ChannelInstance deleteChannelInstance(long channelInstanceId)
		throws PortalException {

		ChannelInstance channelInstance =
			channelInstanceLocalService.getChannelInstance(channelInstanceId);

		CampaignPermission.check(
			getPermissionChecker(), channelInstance.getCampaignId(),
			ActionKeys.UPDATE);

		return channelInstanceLocalService.deleteChannelInstance(
			channelInstanceId);
	}

	@Override
	public List<ChannelInstance> getChannelInstances(
			long campaignId, long tacticId)
		throws PortalException {

		return channelInstanceLocalService.getChannelInstances(tacticId);
	}

	@Override
	public List<ChannelInstance> getChannelInstances(
			long tacticId, String channelKey)
		throws PortalException {

		return channelInstanceLocalService.getChannelInstances(
			tacticId, channelKey);
	}

	@Override
	public ChannelInstance updateChannelInstance(
			long channelInstanceId, String alias, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		ChannelInstance channelInstance =
			channelInstanceLocalService.getChannelInstance(channelInstanceId);

		CampaignPermission.check(
			getPermissionChecker(), channelInstance.getCampaignId(),
			ActionKeys.UPDATE);

		return channelInstanceLocalService.updateChannelInstance(
			channelInstanceId, alias, typeSettings, serviceContext);
	}

}