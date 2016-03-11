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

package com.liferay.content.targeting.api.model;

import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Julio Camarero
 */
public abstract class BaseRuleCategory implements RuleCategory {

	@Activate
	public void activate() {
		if (_log.isDebugEnabled()) {
			Class<?> clazz = getClass();

			_log.debug("Rule Category activate: " + clazz.getSimpleName());
		}
	}

	@Deactivate
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			Class<?> clazz = getClass();

			_log.debug("Rule Category deactivate: " + clazz.getSimpleName());
		}
	}

	@Override
	public String getCategoryKey() {
		return StringPool.BLANK;
	}

	@Override
	public String getDescription(Locale locale) {
		return ContentTargetingUtil.getDescription(getClass(), locale);
	}

	@Override
	public String getIcon() {
		return "icon-archive";
	}

	@Override
	public String getName(Locale locale) {
		return ContentTargetingUtil.getName(getClass(), locale);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseRuleCategory.class);

}