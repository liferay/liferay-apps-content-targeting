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

package com.liferay.portal.contenttargeting.rule.scorepoints.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.HotDeployMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;

import java.util.Map;

/**
 * @author Eduardo Garcia
 */
public class AnalyticsHotDeployMessageListener
	extends HotDeployMessageListener {

	public AnalyticsHotDeployMessageListener(
		Map<String, Object> properties, String... servletContextNames) {

		super(servletContextNames);

		_analyticsMessageDestination = (String)properties.get(
			"analyticsMessageDestination");
		_analyticsMessageListener = (MessageListener)properties.get(
			"analyticsMessageListener");
	}

	@Override
	protected void onDeploy(Message message) throws Exception {
		MessageBus messageBus = MessageBusUtil.getMessageBus();

		try {
			messageBus.registerMessageListener(
				_analyticsMessageDestination, _analyticsMessageListener);

			if (_log.isInfoEnabled()) {
				_log.info(
					"Registering message listener for " +
						_analyticsMessageDestination);
			}
		}
		catch (Exception e) {
			_log.error(
				"Cannot register message listener for" +
					_analyticsMessageDestination);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		AnalyticsHotDeployMessageListener.class);

	private String _analyticsMessageDestination;
	private MessageListener _analyticsMessageListener;

}