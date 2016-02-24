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

package com.liferay.content.targeting.rule.facebook;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.SocialRuleCategory;
import com.liferay.content.targeting.rule.facebook.util.FacebookUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.sso.facebook.connect.constants.FacebookConnectWebKeys;

import com.restfb.types.User;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class FacebookAgeRule extends BaseFacebookRule {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
			ruleInstance.getTypeSettings());

		int youngerThan = jsonObj.getInt("fbYoungerThan");
		int olderThan = jsonObj.getInt("fbOlderThan");

		JSONObject typeSettings = JSONFactoryUtil.createJSONObject(
			anonymousUser.getTypeSettings());

		User user = FacebookUtil.getFacebookUser(
			typeSettings.getString(
				FacebookConnectWebKeys.FACEBOOK_ACCESS_TOKEN));

		int age = getAge(user.getBirthdayAsDate());

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
	public String getRuleCategoryKey() {
		return SocialRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		String summary = StringPool.BLANK;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			int youngerThan = jsonObj.getInt("fbYoungerThan");
			int olderThan = jsonObj.getInt("fbOlderThan");

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
		catch (JSONException jsone) {
		}

		return summary;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		int youngerThan = GetterUtil.getInteger(values.get("fbYoungerThan"));
		int olderThan = GetterUtil.getInteger(values.get("fbOlderThan"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("fbYoungerThan", youngerThan);
		jsonObj.put("fbOlderThan", olderThan);

		return jsonObj.toString();
	}

	@Override
	protected void doPopulateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		int youngerThan = 100;
		int olderThan = 0;

		if (!values.isEmpty()) {
			youngerThan = GetterUtil.getInteger(values.get("fbYoungerThan"));
			olderThan = GetterUtil.getInteger(values.get("fbOlderThan"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				youngerThan = jsonObj.getInt("fbYoungerThan");
				olderThan = jsonObj.getInt("fbOlderThan");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("fbYoungerThan", youngerThan);
		context.put("fbOlderThan", olderThan);
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
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_AGE;
	}

	private static final String _FORM_TEMPLATE_PATH_AGE =
		"templates/ct_fields_age.ftl";

}