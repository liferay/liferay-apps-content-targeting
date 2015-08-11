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

package com.liferay.consumer.manager;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Julio Camarero
 */
public class InvalidConsumerExtensionsException extends PortalException {

	public InvalidConsumerExtensionsException() {
		super();
	}

	public InvalidConsumerExtensionsException(
		List<InvalidConsumerExtensionException> exceptions) {

		super();

		if ((exceptions != null) && !exceptions.isEmpty()) {
			InvalidConsumerExtensionException exception = exceptions.get(0);

			_exceptionsMap.put(
				exception.getConsumerExtensionGuid(), exceptions);
		}
	}

	public InvalidConsumerExtensionsException(String msg) {
		super(msg);
	}

	public InvalidConsumerExtensionsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public void add(InvalidConsumerExtensionException exception) {
		List<InvalidConsumerExtensionException> exceptions = _exceptionsMap.get(
			exception.getConsumerExtensionGuid());

		if (exceptions == null) {
			exceptions = new ArrayList<InvalidConsumerExtensionException>();
		}

		exceptions.add(exception);

		_exceptionsMap.put(exception.getConsumerExtensionGuid(), exceptions);
	}

	public List<InvalidConsumerExtensionException> getExceptions(
		String trackingActionId) {

		return _exceptionsMap.get(trackingActionId);
	}

	private Map<String, List<InvalidConsumerExtensionException>>
		_exceptionsMap =
			new HashMap<String, List<InvalidConsumerExtensionException>>();

}