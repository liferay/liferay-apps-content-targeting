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

package com.liferay.content.targeting.util.comparator;

import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;

import java.io.Serializable;

import java.util.Comparator;
import java.util.Locale;

/**
 * @author Jürgen Kappler
 */
public class RuleInstanceNameComparator
	implements Comparator<RuleInstance>, Serializable {

	public RuleInstanceNameComparator(
		Locale locale, RulesRegistry rulesRegistry) {

		_locale = locale;
		_rulesRegistry = rulesRegistry;
	}

	@Override
	public int compare(RuleInstance ruleInstance1, RuleInstance ruleInstance2) {
		Rule rule1 = _rulesRegistry.getRule(ruleInstance1.getRuleKey());
		Rule rule2 = _rulesRegistry.getRule(ruleInstance2.getRuleKey());

		String ruleStr1 = rule1.getName(_locale);
		String ruleStr2 = rule2.getName(_locale);

		return ruleStr1.compareTo(ruleStr2);
	}

	private final Locale _locale;
	private final RulesRegistry _rulesRegistry;

}