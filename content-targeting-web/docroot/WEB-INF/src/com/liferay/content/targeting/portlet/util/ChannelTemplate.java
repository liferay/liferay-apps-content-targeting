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

package com.liferay.content.targeting.portlet.util;

import com.liferay.content.targeting.api.model.Channel;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Pavel Savinov
 */
public class ChannelTemplate {

	public Channel getChannel() {
		return _channel;
	}

	public String getInstanceId() {
		return _instanceId;
	}

	public String getTemplate() {
		return _template;
	}

	public String getTemplateKey() {
		String templateKey = _channel.getChannelKey();

		if (Validator.isNotNull(_instanceId)) {
			templateKey = templateKey.concat(StringPool.UNDERLINE).concat(
				String.valueOf(_instanceId));
		}

		return templateKey;
	}

	public void setChannel(Channel channel) {
		_channel = channel;
	}

	public void setInstanceId(String instanceId) {
		_instanceId = instanceId;
	}

	public void setTemplate(String template) {
		_template = template;
	}

	private Channel _channel;
	private String _instanceId;
	private String _template;

}