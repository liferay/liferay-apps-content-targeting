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

package com.liferay.contenttargeting.rules.time;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;

import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Julio Camarero
 */
@Component(immediate = true, provide = Rule.class)
public class GenderRule extends BaseRule {

	@Activate
	public void activate() {
	}

	@Deactivate
	public void deActivate() {
	}

	@Override
	public boolean evaluate(RuleInstance ruleInstance, CTUser ctUser)
		throws Exception {

		if (ruleInstance == null) {
			return false;
		}

		User user = ctUser.getUser();

		if (user == null) {
			return false;
		}

		String gender = ruleInstance.getTypeSettings();

		if ((user.isMale() && gender.equals("male")) ||
			!user.isMale() && gender.equals("female")) {

			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-female";
	}

	@Override
	public String getName(Locale locale) {
		return LanguageUtil.get(locale, "gender");
	}

	@Override
	public String getRuleKey() {
		return "genderRule";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		return ruleInstance.getTypeSettings();
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response) {

		return ParamUtil.getString(request, "gender");
	}

	@Override
	protected Map<String, Object> getContext(RuleInstance ruleInstance) {
		Map<String, Object> context = new HashMap<String, Object>();

		String gender = StringPool.BLANK;

		if (ruleInstance != null) {
			gender = ruleInstance.getTypeSettings();
		}

		context.put("gender", gender);

		return context;
	}

}