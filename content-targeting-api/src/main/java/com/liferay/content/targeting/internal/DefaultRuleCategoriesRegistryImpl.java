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

package com.liferay.content.targeting.internal;

import com.liferay.content.targeting.api.model.RuleCategoriesRegistry;
import com.liferay.content.targeting.api.model.RuleCategory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * @author Julio Camarero
 */
@Component
public class DefaultRuleCategoriesRegistryImpl
	implements RuleCategoriesRegistry {

	@Override
	public Map<String, RuleCategory> getRuleCategories() {
		return _ruleCategories;
	}

	@Override
	public RuleCategory getRuleCategory(String ruleCategoryKey) {
		return _ruleCategories.get(ruleCategoryKey);
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC, unbind = "unregisterRuleCategory"
	)
	public void registerRuleCategory(RuleCategory ruleCategory) {
		_ruleCategories.put(ruleCategory.getCategoryKey(), ruleCategory);
	}

	public void unregisterRuleCategory(RuleCategory ruleCategory) {
		_ruleCategories.remove(ruleCategory);
	}

	private final Map<String, RuleCategory> _ruleCategories =
		new ConcurrentHashMap<>();

}