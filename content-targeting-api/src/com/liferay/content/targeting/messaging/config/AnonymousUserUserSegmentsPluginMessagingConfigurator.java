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

import com.liferay.portal.kernel.concurrent.DiscardOldestPolicy;
import com.liferay.portal.kernel.concurrent.RejectedExecutionHandler;
import com.liferay.portal.kernel.concurrent.ThreadPoolExecutor;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.config.PluginMessagingConfigurator;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true,
	service = AnonymousUserUserSegmentsPluginMessagingConfigurator.class
)
public class AnonymousUserUserSegmentsPluginMessagingConfigurator
	extends PluginMessagingConfigurator {

	@Activate
	protected void activate(ComponentContext componentContext) {
		_bundleContext = componentContext.getBundleContext();

		Dictionary<String, Object> properties =
			componentContext.getProperties();

		DestinationConfiguration destinationConfiguration =
			new DestinationConfiguration(
				DestinationConfiguration.DESTINATION_TYPE_PARALLEL,
				"liferay/anonymous_user_segments");

		/* TODO: replace with max queue size from configuration instance */
		destinationConfiguration.setMaximumQueueSize(200);

		RejectedExecutionHandler rejectedExecutionHandler =
			new DiscardOldestPolicy() {

				@Override
				public void rejectedExecution(
					Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {

					if (_log.isWarnEnabled()) {
						_log.warn(
							"Maximum capacity reached, rejecting request");
					}

					super.rejectedExecution(runnable, threadPoolExecutor);
				}

			};

		destinationConfiguration.setRejectedExecutionHandler(
			rejectedExecutionHandler);

		Destination destination = _destinationFactory.createDestination(
			destinationConfiguration);

		Dictionary<String, Object> destinationProperties =
			new HashMapDictionary<>();

		destinationProperties.put("destination.name", destination.getName());

		_destinationServiceRegistration = _bundleContext.registerService(
			Destination.class, destination, destinationProperties);
	}

	@Deactivate
	protected void deactivate() {
		if (_destinationServiceRegistration != null) {
			Destination destination = _bundleContext.getService(
				_destinationServiceRegistration.getReference());

			_destinationServiceRegistration.unregister();

			destination.destroy();
		}

		_bundleContext = null;
	}

	@Reference(unbind = "-")
	protected void setDestinationFactory(
		DestinationFactory destinationFactory) {

		_destinationFactory = destinationFactory;
	}

	@Reference(unbind = "-")
	protected void setMessageBus(MessageBus messageBus) {
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AnonymousUserUserSegmentsPluginMessagingConfigurator.class);

	private volatile BundleContext _bundleContext;
	private DestinationFactory _destinationFactory;
	private volatile ServiceRegistration<Destination>
		_destinationServiceRegistration;

}