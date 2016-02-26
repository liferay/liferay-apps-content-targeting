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
 * @author Julio Camarero
 */
public class InvalidTrackingActionsException extends PortalException {

	public InvalidTrackingActionsException() {
	}

	public InvalidTrackingActionsException(
		List<InvalidTrackingActionException> exceptions) {

		if ((exceptions != null) && !exceptions.isEmpty()) {
			InvalidTrackingActionException exception = exceptions.get(0);

			_exceptionsMap.put(exception.getTrackingActionGuid(), exceptions);
		}
	}

	public InvalidTrackingActionsException(String msg) {
		super(msg);
	}

	public InvalidTrackingActionsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public void add(InvalidTrackingActionException exception) {
		List<InvalidTrackingActionException> exceptions = _exceptionsMap.get(
			exception.getTrackingActionGuid());

		if (exceptions == null) {
			exceptions = new ArrayList<>();
		}

		exceptions.add(exception);

		_exceptionsMap.put(exception.getTrackingActionGuid(), exceptions);
	}

	public List<InvalidTrackingActionException> getExceptions(
		String trackingActionId) {

		return _exceptionsMap.get(trackingActionId);
	}

	private final Map<String, List<InvalidTrackingActionException>>
		_exceptionsMap = new HashMap<>();

}