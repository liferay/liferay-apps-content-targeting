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

package com.liferay.contenttargeting.api.model;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.model.RuleInstance;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * Provides the Rule interface, allowing custom rule creation and evaluation
 * for the Content Targeting Portlet.
 *
 * @author Eudaldo Alonso
 */
public interface Rule {

	public void activate();

	public void deActivate();

	/**
	 * Returns <code>true</code> if the user complies with the rule instance.
	 *
	 * @param  ruleInstance the rule instance with stored configuration
	 * @param  anonymousUser the user who evaluates the rule
	 * @return <code>true</code> if the user complies with the rule instance;
	 *         <code>false</code> otherwise
	 */
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception;

	/**
	 * Returns the rule category.
	 *
	 * @return the rule category
	 */
	public String getCategory();

	/**
	 * Returns the rule description.
	 *
	 * @param  locale the language's locale
	 * @return the rule locale
	 */
	public String getDescription(Locale locale);

	/**
	 * Returns the HTML code containing the form fields required to edit the
	 * rule instance's configuration, based on the context.
	 *
	 * @param  ruleInstance the rule instance with stored configuration
	 * @param  context the map defining the form's evaluation context
	 * @return the HTML code containing the form fields required to edit the
	 *         rule instance's configuration, based on the context
	 */
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context);

	/**
	 * Returns the Font Awesome CSS class for the rule's icon.
	 *
	 * @return the Font Awesome CSS class for the rule's icon
	 * @see    <a href="http://fortawesome.github.io/Font-Awesome/3.2.1/">Font
	 *         Awesome documentation</a>
	 */
	public String getIcon();

	/**
	 * Returns the rule's name.
	 *
	 * @param  locale the language's locale
	 * @return the rule's name
	 */
	public String getName(Locale locale);

	/**
	 * Returns the key that identifies the rule. The rule instances of this rule
	 * are identified by their rule key.
	 *
	 * @return the key that identifies the rule
	 */
	public String getRuleKey();

	/**
	 * Returns the rule instance's localized summary.
	 *
	 * @param  ruleInstance the rule instance with stored configuration
	 * @param  locale the language's locale
	 * @return the rule instance's localized summary
	 */
	public String getSummary(RuleInstance ruleInstance, Locale locale);

	public boolean isInstantiable();

	/**
	 * Returns the result of evaluating the rule's form fields in the context of
	 * the request and response.
	 *
	 * @param  request the request from which to get the request parameters
	 * @param  response the response to receive the render parameters
	 * @param  id the identifier that differentiates between rule instances of
	 *         the same type of an instantiable rule
	 * @param  values the values configured by users for the current rule
	 *         instance based on the form controls from the HTML
	 * @return the result of evaluating the rule's form fields in the context of
	 *         the request and response
	 */
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values);

}