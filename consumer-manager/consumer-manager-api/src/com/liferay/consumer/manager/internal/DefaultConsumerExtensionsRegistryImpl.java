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

package com.liferay.consumer.manager.internal;

import com.liferay.consumer.manager.api.model.ConsumerExtension;
import com.liferay.consumer.manager.api.model.ConsumerExtensionsRegistry;

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
public class DefaultConsumerExtensionsRegistryImpl
	implements ConsumerExtensionsRegistry {

	@Override
	public ConsumerExtension getConsumerExtension(String ruleKey) {
		return _consumerExtensions.get(ruleKey);
	}

	@Override
	public Map<String, ConsumerExtension> getConsumerExtensions() {
		return _consumerExtensions;
	}

	@Reference(
		unbind = "unregisterConsumerExtension",
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC)
	public void registerConsumerExtension(ConsumerExtension consumerExtension) {
		_consumerExtensions.put(
			consumerExtension.getConsumerExtensionKey(), consumerExtension);
	}

	public void unregisterConsumerExtension(
		ConsumerExtension consumerExtension) {

		_consumerExtensions.remove(consumerExtension);
	}

	private Map<String, ConsumerExtension> _consumerExtensions =
		new ConcurrentHashMap<String, ConsumerExtension>();

}