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

package com.liferay.content.targeting.messaging.config;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.config.PluginMessagingConfigurator;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Eduardo Garcia
 */
public class AnonymousUserUserSegmentsPluginMessagingConfigurator
	extends PluginMessagingConfigurator {

	public void setAnonymousUserSegmentsMessageDestination(
		String anonymousUserSegmentsMessageDestination) {

		_anonymousUserSegmentsMessageDestination =
			anonymousUserSegmentsMessageDestination;
	}

	@Override
	public void setMessageListeners(
		Map<String, List<MessageListener>> messageListeners) {

		Collection<String> destinationNames =
			getMessageBus().getDestinationNames();

		if (!destinationNames.contains(
				_anonymousUserSegmentsMessageDestination)) {

			messageListeners.remove(_anonymousUserSegmentsMessageDestination);

			if (_log.isWarnEnabled()) {
				_log.warn(
					"Cannot register anonymous users segments API message " +
						"listener because destination " +
						_anonymousUserSegmentsMessageDestination +
						" does not exist yet");
			}
		}

		super.setMessageListeners(messageListeners);

		if (_log.isInfoEnabled()) {
			_log.info("Registering message listeners");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
AnonymousUserUserSegmentsPluginMessagingConfigurator.class);

	private String _anonymousUserSegmentsMessageDestination;

}