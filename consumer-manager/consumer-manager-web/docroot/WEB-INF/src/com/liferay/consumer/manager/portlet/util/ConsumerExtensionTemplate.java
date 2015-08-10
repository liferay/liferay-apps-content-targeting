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

package com.liferay.consumer.manager.portlet.util;

import com.liferay.consumer.manager.api.model.ConsumerExtension;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Eduardo Garcia
 */
public class ConsumerExtensionTemplate {

	public ConsumerExtension getConsumerExtension() {
		return _consumerExtension;
	}

	public String getInstanceId() {
		return _instanceId;
	}

	public String getTemplate() {
		return _template;
	}

	public String getTemplateKey() {
		String templateKey = _consumerExtension.getConsumerExtensionKey();

		if (Validator.isNotNull(_instanceId)) {
			templateKey = templateKey.concat(StringPool.UNDERLINE).concat(
				String.valueOf(_instanceId));
		}

		return templateKey;
	}

	public void setConsumerExtension(ConsumerExtension consumerExtension) {
		_consumerExtension = consumerExtension;
	}

	public void setInstanceId(String instanceId) {
		_instanceId = instanceId;
	}

	public void setTemplate(String template) {
		_template = template;
	}

	private ConsumerExtension _consumerExtension;
	private String _instanceId;
	private String _template;

}