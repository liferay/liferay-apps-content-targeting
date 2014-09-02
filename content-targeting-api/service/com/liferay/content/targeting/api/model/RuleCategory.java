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

import java.util.Locale;

/**
 * Provides the Rule Category interface, allowing custom rule category creation
 * for aggregation of Rules for the Content Targeting Portlet.
 *
 * @author Julio Camarero
 */
public interface RuleCategory {

	public void activate();

	public void deActivate();

	/**
	 * Returns the key that identifies the category of the rule.
	 *
	 * @return the key that identifies the category
	 */
	public String getCategoryKey();

	/**
	 * Returns the rule category description.
	 *
	 * @param  locale the language's locale
	 * @return the rule locale
	 */
	public String getDescription(Locale locale);

	/**
	 * Returns the Font Awesome CSS class for the rule catetory's icon.
	 *
	 * @return the Font Awesome CSS class for the rule category's icon
	 * @see    <a href="http://fortawesome.github.io/Font-Awesome/3.2.1/">Font
	 *         Awesome documentation</a>
	 */
	public String getIcon();

	/**
	 * Returns the rule category's name.
	 *
	 * @param  locale the language's locale
	 * @return the rule's name
	 */
	public String getName(Locale locale);

}