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

package com.liferay.content.targeting;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Julio Camarero
 */
public class InvalidReportsException extends PortalException {

	public InvalidReportsException() {
		super();
	}

	public InvalidReportsException(List<InvalidReportException> exceptions) {
		super();

		if ((exceptions != null) && !exceptions.isEmpty()) {
			InvalidReportException exception = exceptions.get(0);

			_exceptionsMap.put(exception.getReportGuid(), exceptions);
		}
	}

	public InvalidReportsException(String msg) {
		super(msg);
	}

	public InvalidReportsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public void add(InvalidReportException exception) {
		List<InvalidReportException> exceptions = _exceptionsMap.get(
			exception.getReportGuid());

		if (exceptions == null) {
			exceptions = new ArrayList<InvalidReportException>();
		}

		exceptions.add(exception);

		_exceptionsMap.put(exception.getReportGuid(), exceptions);
	}

	public List<InvalidReportException> getExceptions(String reportId) {
		return _exceptionsMap.get(reportId);
	}

	private Map<String, List<InvalidReportException>> _exceptionsMap =
		new HashMap<String, List<InvalidReportException>>();

}