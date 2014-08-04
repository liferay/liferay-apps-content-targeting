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

package com.liferay.contenttargeting.rulecategories;

import com.liferay.contenttargeting.api.model.BaseRuleCategory;
import com.liferay.contenttargeting.api.model.RuleCategory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = RuleCategory.class)
public class TestRuleCategory extends BaseRuleCategory {

	public static final String KEY = "test";

	@Override
	public String getCategoryKey() {
		return KEY;
	}

	@Override
	public String getIcon() {
		return "icon-ok-sign";
	}

}