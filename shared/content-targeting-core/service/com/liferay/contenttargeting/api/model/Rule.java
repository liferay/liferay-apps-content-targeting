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

package com.liferay.contenttargeting.api.model;

import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.model.RuleInstance;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * Provides the Rule interface, allowing creating custom rules for the Content
 * Targeting Portlet.
 *
 * @author Eudaldo Alonso
 */
public interface Rule {

	/**
	 * Returns <code>true</code> if the rule instance is complied by the user.
	 *
	 * @param  ruleInstance the instance of the rule storing its specific
	 *         configuration
	 * @param  ctUser the user for whom the rule is evaluated
	 * @return <code>true</code> if the rule instance is complied by the user;
	 *         <code>false</code> otherwise
	 */
	public boolean evaluate(RuleInstance ruleInstance, CTUser ctUser);

	/**
	 * Returns the HTML code containing the form fields required to edit the
	 * configuration of the rule instance, based on the given context.
	 *
	 * @param  ruleInstance the instance of the rule storing its specific
	 *         configuration
	 * @param  context the map defining the context in which the form is
	 *         evaluated
	 * @return the HTML code containing the form fields required to edit the
	 *         configuration of the rule instance, based on the given context
	 */
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context);

	/**
	 * Returns the Font Awesome css class of the icon for this rule.
	 *
	 * @return the Font Awesome css class of the icon for this rule
	 * @see    <a href="http://fortawesome.github.io/Font-Awesome/3.2.1/">Font
	 *         Awesome documentation</a>
	 */
	public String getIcon();

	/**
	 * Returns the name of the rule.
	 *
	 * @param  locale the local of the language
	 * @return the name of the rule
	 */
	public String getName(Locale locale);

	/**
	 * Returns the key that identifies the rule. The rule instances of this rule
	 * will be identified by their rule key.
	 *
	 * @return the key that identifies the rule
	 */
	public String getRuleKey();

	/**
	 * Returns the localized summary of an specific rule instance.
	 *
	 * @param  ruleInstance the instance of the rule storing its specific
	 *         configuration
	 * @param  locale the local of the language
	 * @return the localized summary of an specific rule instance
	 */
	public String getSummary(RuleInstance ruleInstance, Locale locale);

	/**
	 * Returns the result of evaluating the rule form fields in the context of
	 * the given request and response.
	 *
	 * @param  request the request from which to get the request parameters
	 * @param  response the response to receive the render parameters
	 * @return the result of evaluating the rule form fields in the context of
	 *         the given request and response
	 */
	public String processRule(PortletRequest request, PortletResponse response);

}