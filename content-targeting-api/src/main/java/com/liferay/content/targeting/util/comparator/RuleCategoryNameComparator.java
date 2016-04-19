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

import com.liferay.content.targeting.api.model.RuleCategory;

import java.io.Serializable;

import java.util.Comparator;
import java.util.Locale;

/**
 * @author Jürgen Kappler
 */
public class RuleCategoryNameComparator
	implements Comparator<RuleCategory>, Serializable {

	public RuleCategoryNameComparator(Locale locale) {
		_locale = locale;
	}

	@Override
	public int compare(RuleCategory ruleCategory1, RuleCategory ruleCategory2) {
		String ruleCategoryStr1 = ruleCategory1.getName(_locale);
		String ruleCategoryStr2 = ruleCategory2.getName(_locale);

		return ruleCategoryStr1.compareTo(ruleCategoryStr2);
	}

	private final Locale _locale;

}