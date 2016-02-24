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

package com.liferay.content.targeting.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eduardo Garcia
 */
public class InvalidChannelsException extends PortalException {

	public InvalidChannelsException() {
	}

	public InvalidChannelsException(List<InvalidChannelException> exceptions) {
		if ((exceptions != null) && !exceptions.isEmpty()) {
			InvalidChannelException exception = exceptions.get(0);

			_exceptionsMap.put(exception.getChannelGuid(), exceptions);
		}
	}

	public InvalidChannelsException(String msg) {
		super(msg);
	}

	public InvalidChannelsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public void add(InvalidChannelException exception) {
		List<InvalidChannelException> exceptions = _exceptionsMap.get(
			exception.getChannelGuid());

		if (exceptions == null) {
			exceptions = new ArrayList<>();
		}

		exceptions.add(exception);

		_exceptionsMap.put(exception.getChannelGuid(), exceptions);
	}

	public List<InvalidChannelException> getExceptions(String channelId) {
		return _exceptionsMap.get(channelId);
	}

	private final Map<String, List<InvalidChannelException>> _exceptionsMap =
		new HashMap<>();

}