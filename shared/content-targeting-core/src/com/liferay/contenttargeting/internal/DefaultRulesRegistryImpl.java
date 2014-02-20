/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.internal;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.api.model.RulesRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eudaldo Alonso
 */
@Component
public class DefaultRulesRegistryImpl implements RulesRegistry {

	@Override
	public Rule getRule(String ruleKey) {
		return _rules.get(ruleKey);
	}

	@Override
	public Map<String, Rule> getRules() {
		return _rules;
	}

	@Reference(type = '*', unbind = "unregisterRule")
	public void registerRule(Rule rule) {
		_rules.put(rule.getRuleKey(), rule);
	}

	public void unregisterRule(Rule rule) {
		_rules.remove(rule);
	}

	private Map<String, Rule> _rules = new ConcurrentHashMap<String, Rule>();

}