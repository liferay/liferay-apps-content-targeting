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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;

import java.util.Calendar;
import java.util.Date;
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
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			int youngerThan = 0;
			int olderThan = 0;

			if (ruleInstance != null) {
				String typeSettings = ruleInstance.getTypeSettings();

				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				youngerThan = jsonObj.getInt("youngerThan");
				olderThan = jsonObj.getInt("olderThan");
			}

			context.put("youngerThan", youngerThan);
			context.put("olderThan", olderThan);

			content = parseTemplate(
				AgeRule.class, _FORM_TEMPLATE_PATH, context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing rule form template " +
					_FORM_TEMPLATE_PATH,
				e);
		}

		return content;
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

		StringBundler sb = new StringBundler(4);

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			int youngerThan = jsonObj.getInt("youngerThan");
			int olderThan = jsonObj.getInt("olderThan");

			if ((youngerThan > 0) && (olderThan > 0)) {
				sb.append("Users between ");
				sb.append(olderThan);
				sb.append(" and ");
				sb.append(youngerThan);
				sb.append(" years old");
			}
			else if (youngerThan > 0) {
				sb.append("Users younger than ");
				sb.append(youngerThan);
				sb.append(" years old");
			}
			else if (olderThan > 0) {
				sb.append("Users olderThan than ");
				sb.append(olderThan);
				sb.append(" years old");
			}
		}
		catch (JSONException jse) {
		}

		return sb.toString();
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

	private static final String _FORM_TEMPLATE_PATH =
		"templates/ct_age_rule_fields.ftl";

	private static Log _log = LogFactoryUtil.getLog(AgeRule.class);

}