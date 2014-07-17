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

package com.liferay.contenttargeting.rules.age;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 */
@Component(immediate = true, service = Rule.class)
public class AgeRule extends BaseRule {

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		User user = anonymousUser.getUser();

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
	public String getCategory() {
		return "user";
	}

	@Override
	public String getIcon() {
		return "icon-calendar-empty";
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
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		int youngerThan = GetterUtil.getInteger(values.get("youngerThan"));
		int olderThan = GetterUtil.getInteger(values.get("olderThan"));

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
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		int youngerThan = 100;
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

		boolean birthdayEnabled = false;

		Company company = (Company)context.get("company");

		try {
			birthdayEnabled = PrefsPropsUtil.getBoolean(
				company.getCompanyId(),
				PropsKeys.
					FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY);
		}
		catch (SystemException se) {
		}

		context.put("birthdayEnabled", birthdayEnabled);
	}

}