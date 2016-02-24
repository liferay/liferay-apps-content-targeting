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

package com.liferay.content.targeting.internal;

import com.liferay.content.targeting.api.model.Channel;
import com.liferay.content.targeting.api.model.ChannelsRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * @author Pavel Savinov
 */
@Component
public class DefaultChannelsRegistryImpl implements ChannelsRegistry {

	@Override
	public Channel getChannel(String channelKey) {
		return _channels.get(channelKey);
	}

	@Override
	public Map<String, Channel> getChannels() {
		return _channels;
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC, unbind = "unregisterChannel"
	)
	public void registerChannnel(Channel channel) {
		_channels.put(channel.getChannelKey(), channel);
	}

	public void unregisterChannel(Channel channel) {
		_channels.remove(channel);
	}

	private final Map<String, Channel> _channels = new ConcurrentHashMap<>();

}