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
public class InvalidRulesException extends PortalException {

	public InvalidRulesException() {
	}

	public InvalidRulesException(List<InvalidRuleException> exceptions) {
		if ((exceptions != null) && !exceptions.isEmpty()) {
			InvalidRuleException exception = exceptions.get(0);

			_exceptionsMap.put(exception.getRuleGuid(), exceptions);
		}
	}

	public InvalidRulesException(String msg) {
		super(msg);
	}

	public InvalidRulesException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public void add(InvalidRuleException exception) {
		List<InvalidRuleException> exceptions = _exceptionsMap.get(
			exception.getRuleGuid());

		if (exceptions == null) {
			exceptions = new ArrayList<>();
		}

		exceptions.add(exception);

		_exceptionsMap.put(exception.getRuleGuid(), exceptions);
	}

	public List<InvalidRuleException> getRuleExceptions(String ruleId) {
		return _exceptionsMap.get(ruleId);
	}

	private final Map<String, List<InvalidRuleException>> _exceptionsMap =
		new HashMap<>();

}