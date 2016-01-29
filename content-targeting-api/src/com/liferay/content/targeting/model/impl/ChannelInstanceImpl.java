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

package com.liferay.content.targeting.model.impl;

import java.util.Map;

/**
 * The extended model implementation for the ChannelInstance service. Represents a row in the &quot;CT_ChannelInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.model.ChannelInstance} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ChannelInstanceImpl extends ChannelInstanceBaseImpl {

	public ChannelInstanceImpl() {
	}

	public String getChannelGuid() {
		return _channelGuid;
	}

	public Map<String, String> getValues() {
		return _values;
	}

	public void setChannelGuid(String channelGuid) {
		_channelGuid = channelGuid;
	}

	public void setValues(Map<String, String> values) {
		this._values = values;
	}

	private String _channelGuid;
	private Map<String, String> _values;

}