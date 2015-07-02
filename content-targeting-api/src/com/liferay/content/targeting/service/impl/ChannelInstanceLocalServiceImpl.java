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

import com.liferay.content.targeting.api.model.Channel;
import com.liferay.content.targeting.api.model.ChannelsRegistry;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.service.base.ChannelInstanceLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.SystemEventConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the channel instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.ChannelInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.ChannelInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.ChannelInstanceLocalServiceUtil
 */
public class ChannelInstanceLocalServiceImpl
	extends ChannelInstanceLocalServiceBaseImpl {

	public ChannelInstanceLocalServiceImpl() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_channelsRegistry = ServiceTrackerUtil.getService(
			ChannelsRegistry.class, bundle.getBundleContext());
	}

	@Override
	public ChannelInstance addChannelInstance(
			long userId, long tacticId, String channelKey, long campaignId,
			String alias, String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);

		Date now = new Date();

		long channelInstanceId = CounterLocalServiceUtil.increment();

		ChannelInstance channelInstance = channelInstancePersistence.create(
			channelInstanceId);

		channelInstance.setUuid(serviceContext.getUuid());
		channelInstance.setGroupId(serviceContext.getScopeGroupId());
		channelInstance.setCompanyId(user.getCompanyId());
		channelInstance.setUserId(user.getUserId());
		channelInstance.setUserName(user.getFullName());
		channelInstance.setCreateDate(serviceContext.getCreateDate(now));
		channelInstance.setModifiedDate(serviceContext.getModifiedDate(now));
		channelInstance.setChannelKey(channelKey);
		channelInstance.setCampaignId(campaignId);
		channelInstance.setTacticId(tacticId);
		channelInstance.setAlias(alias);
		channelInstance.setTypeSettings(typeSettings);

		channelInstancePersistence.update(channelInstance);

		return channelInstance;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public ChannelInstance deleteChannelInstance(
			ChannelInstance channelInstance)
		throws PortalException, SystemException {

		channelInstancePersistence.remove(channelInstance);

		// System event

		systemEventLocalService.addSystemEvent(
			0, channelInstance.getGroupId(), ChannelInstance.class.getName(),
			channelInstance.getChannelInstanceId(), channelInstance.getUuid(),
			null, SystemEventConstants.TYPE_DELETE, StringPool.BLANK);

		// Channel instance data

		Channel channel = _channelsRegistry.getChannel(
			channelInstance.getChannelKey());

		if (channel != null) {
			try {
				channel.deleteData(channelInstance);
			}
			catch (Exception e) {
				_log.error(
					"Cannot delete custom data for channel " +
						channel.getName(LocaleUtil.getDefault()),
					e);
			}
		}

		return channelInstance;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public ChannelInstance deleteChannelInstance(long channelInstanceId)
		throws PortalException, SystemException {

		ChannelInstance channelInstance =
			channelInstancePersistence.findByPrimaryKey(channelInstanceId);

		return deleteChannelInstance(channelInstance);
	}

	@Override
	public List<ChannelInstance> getChannelInstances(long tacticId)
		throws PortalException, SystemException {

		return channelInstancePersistence.findByTacticId(tacticId);
	}

	@Override
	public ChannelInstance updateChannelInstance(
			long channelInstanceId, String alias, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		ChannelInstance channelInstance =
			channelInstancePersistence.findByPrimaryKey(channelInstanceId);

		channelInstance.setModifiedDate(serviceContext.getModifiedDate(now));
		channelInstance.setAlias(alias);
		channelInstance.setTypeSettings(typeSettings);

		channelInstancePersistence.update(channelInstance);

		return channelInstance;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ChannelInstanceLocalServiceImpl.class);

	private ChannelsRegistry _channelsRegistry;

}