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
 *
 * @author Eudaldo Alonso
 */
public interface Rule {

	/**
	 *
	 * @param  ruleInstance
	 * @param  ctUser
	 * @return
	 */
	public boolean evaluate(RuleInstance ruleInstance, CTUser ctUser);

	/**
	 *
	 * @param  ruleInstance
	 * @param  context
	 * @return
	 */
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context);

	/**
	 *
	 * @return
	 */
	public String getIcon();

	/**
	 *
	 * @param  locale
	 * @return
	 */
	public String getName(Locale locale);

	/**
	 *
	 * @return
	 */
	public String getRuleKey();

	/**
	 *
	 * @param  ruleInstance
	 * @param  locale
	 * @return
	 */
	public String getSummary(RuleInstance ruleInstance, Locale locale);

	/**
	 *
	 * @param  request
	 * @param  response
	 * @return
	 */
	public String processRule(PortletRequest request, PortletResponse response);

}