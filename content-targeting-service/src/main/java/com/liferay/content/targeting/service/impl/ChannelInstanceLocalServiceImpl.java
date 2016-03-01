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
import com.liferay.content.targeting.exception.DuplicateChannelInstanceException;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.service.base.ChannelInstanceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Date;
import java.util.List;

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

	@Override
	public ChannelInstance addChannelInstance(
			long userId, long tacticId, String channelKey, long campaignId,
			String alias, String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		validate(0, tacticId, alias);

		User user = userLocalService.getUser(userId);

		Date now = new Date();

		long channelInstanceId = counterLocalService.increment();

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
		throws PortalException {

		channelInstancePersistence.remove(channelInstance);

		// System event

		systemEventLocalService.addSystemEvent(
			0, channelInstance.getGroupId(), ChannelInstance.class.getName(),
			channelInstance.getChannelInstanceId(), channelInstance.getUuid(),
			null, SystemEventConstants.TYPE_DELETE, StringPool.BLANK);

		// Channel instance data

		Channel channel = channelsRegistry.getChannel(
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
		throws PortalException {

		ChannelInstance channelInstance =
			channelInstancePersistence.findByPrimaryKey(channelInstanceId);

		return deleteChannelInstance(channelInstance);
	}

	@Override
	public List<ChannelInstance> getCampaignChannelInstances(long campaignId)
		throws PortalException {

		return channelInstancePersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<ChannelInstance> getCampaignChannelInstances(
			long campaignId, String channelKey)
		throws PortalException {

		return channelInstancePersistence.findByC_K(campaignId, channelKey);
	}

	@Override
	public List<ChannelInstance> getChannelInstances(long tacticId)
		throws PortalException {

		return channelInstancePersistence.findByTacticId(tacticId);
	}

	@Override
	public List<ChannelInstance> getChannelInstances(
			long tacticId, String channelKey)
		throws PortalException {

		if (tacticId > 0) {
			return channelInstancePersistence.findByT_K(tacticId, channelKey);
		}

		return channelInstancePersistence.findByChannelKey(channelKey);
	}

	@Override
	public ChannelInstance updateChannelInstance(
			long channelInstanceId, String alias, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		ChannelInstance channelInstance =
			channelInstancePersistence.findByPrimaryKey(channelInstanceId);

		validate(channelInstanceId, channelInstance.getTacticId(), alias);

		Date now = new Date();

		channelInstance.setModifiedDate(serviceContext.getModifiedDate(now));
		channelInstance.setAlias(alias);
		channelInstance.setTypeSettings(typeSettings);

		channelInstancePersistence.update(channelInstance);

		return channelInstance;
	}

	protected void validate(long channelInstanceId, long tacticId, String alias)
		throws PortalException {

		ChannelInstance channelInstance = channelInstancePersistence.fetchByT_A(
			tacticId, alias);

		if ((channelInstance != null) &&
			(channelInstance.getChannelInstanceId() != channelInstanceId)) {

			throw new DuplicateChannelInstanceException(
				"A channel instance with the alias " + alias + " already " +
					"exists in tactic " + tacticId);
		}
	}

	@ServiceReference(type = ChannelsRegistry.class)
	protected ChannelsRegistry channelsRegistry;

	private static final Log _log = LogFactoryUtil.getLog(
		ChannelInstanceLocalServiceImpl.class);

}