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
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Julio Camarero
 */
@Component(immediate = true, provide = Rule.class)
public class AgeRule extends BaseRule {

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

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
			ruleInstance.getTypeSettings());

		int youngerThan = jsonObj.getInt("youngerThan");
		int olderThan = jsonObj.getInt("olderThan");

		int age = getAge(user.getBirthday());

		if ((age > olderThan) && (age < youngerThan)) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-calendar-empty";
	}

	@Override
	public String getName(Locale locale) {
		return LanguageUtil.get(locale, "age");
	}

	@Override
	public String getRuleKey() {
		return "ageRule";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		String summary = StringPool.BLANK;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			int youngerThan = jsonObj.getInt("youngerThan");
			int olderThan = jsonObj.getInt("olderThan");

			if ((youngerThan > 0) && (olderThan > 0)) {
				summary = LanguageUtil.format(
					locale, "users-between-x-and-x-years-old",
					new Object[] {olderThan, youngerThan});
			}
			else if (youngerThan > 0) {
				summary = LanguageUtil.format(
					locale, "users-younger-than-x-years-old", youngerThan);
			}
			else if (olderThan > 0) {
				summary = LanguageUtil.format(
					locale, "users-older-than-x-years-old", olderThan);
			}
		}
		catch (JSONException jse) {
		}

		return summary;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response) {

		int youngerThan = ParamUtil.getInteger(request, "youngerThan");
		int olderThan = ParamUtil.getInteger(request, "olderThan");

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("youngerThan", youngerThan);
		jsonObj.put("olderThan", olderThan);

		return jsonObj.toString();
	}

	protected int getAge(Date birthday) {
		Calendar birthdayCalendar = Calendar.getInstance();

		birthdayCalendar.setTime(birthday);

		Calendar today = Calendar.getInstance();

		int age = today.get(Calendar.YEAR) - birthdayCalendar.get(
			Calendar.YEAR);

		if (today.get(Calendar.DAY_OF_YEAR) <=
				birthdayCalendar.get(Calendar.DAY_OF_YEAR)) {

			age--;
		}

		return age;
	}

	@Override
	protected Map<String, Object> getContext(RuleInstance ruleInstance) {
		Map<String, Object> context = new HashMap<String, Object>();

		int youngerThan = 0;
		int olderThan = 0;

		if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				youngerThan = jsonObj.getInt("youngerThan");
				olderThan = jsonObj.getInt("olderThan");
			}
			catch (JSONException jse) {
			}
		}

		context.put("youngerThan", youngerThan);
		context.put("olderThan", olderThan);

		return context;
	}

}