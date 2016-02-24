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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.facebook.connect.constants.FacebookConnectWebKeys;

import com.restfb.types.User;

import java.util.List;
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
public class FacebookEducationRule extends BaseFacebookRule {

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

		String educationLevel = jsonObj.getString("educationLevel");
		String schoolName = jsonObj.getString("schoolName");

		JSONObject typeSettings = JSONFactoryUtil.createJSONObject(
			anonymousUser.getTypeSettings());

		User user = FacebookUtil.getFacebookUser(
			typeSettings.getString(
				FacebookConnectWebKeys.FACEBOOK_ACCESS_TOKEN));

		if (matchEducationLevel(user, educationLevel) &&
			matchEducationName(user, schoolName)) {

			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-book";
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

			String educationLevel = jsonObj.getString("educationLevel");
			String schoolName = jsonObj.getString("schoolName");

			StringBundler sb = new StringBundler();

			if (Validator.isNotNull(educationLevel)) {
				sb.append(LanguageUtil.get(locale, "education-level"));
				sb.append(StringPool.COLON);
				sb.append(LanguageUtil.get(locale, educationLevel));
				sb.append(StringPool.PERIOD);
				sb.append(StringPool.SPACE);
			}

			if (Validator.isNotNull(schoolName)) {
				sb.append(LanguageUtil.get(locale, "college-high-school-name"));
				sb.append(StringPool.COLON);
				sb.append(schoolName);
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

		String educationLevel = GetterUtil.getString(
			values.get("educationLevel"));
		String schoolName = GetterUtil.getString(values.get("schoolName"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("educationLevel", educationLevel);
		jsonObj.put("schoolName", schoolName);

		return jsonObj.toString();
	}

	@Override
	protected void doPopulateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String educationLevel = StringPool.BLANK;
		String schoolName = StringPool.BLANK;

		if (!values.isEmpty()) {
			educationLevel = GetterUtil.getString(values.get("educationLevel"));
			schoolName = GetterUtil.getString(values.get("schoolName"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				educationLevel = jsonObj.getString("educationLevel");
				schoolName = jsonObj.getString("schoolName");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("educationLevel", educationLevel);
		context.put("schoolName", schoolName);
	}

	@Override
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_EDUCATION;
	}

	protected boolean hasEducation(User user, String type) {
		List<User.Education> educations = user.getEducation();

		for (User.Education education : educations) {
			if (type.equals(education.getType())) {
				return true;
			}
		}

		return false;
	}

	protected boolean matchEducationLevel(User user, String educationLevel) {
		if (Validator.isNotNull(educationLevel)) {
			if (educationLevel.equals(_EDUCATION_TYPE_HIGH_SCHOOL) &&
				!hasEducation(user, _EDUCATION_TYPE_HIGH_SCHOOL)) {

				return false;
			}

			if (educationLevel.equals(_EDUCATION_TYPE_COLLEGE) &&
				!hasEducation(user, _EDUCATION_TYPE_COLLEGE)) {

				return false;
			}
		}

		return true;
	}

	protected boolean matchEducationName(User user, String schoolName) {
		if (Validator.isNull(schoolName)) {
			return true;
		}

		for (User.Education education : user.getEducation()) {
			String educationSchoolName = education.getSchool().getName();

			if (StringUtil.toLowerCase(educationSchoolName).contains(
					StringUtil.toLowerCase(schoolName))) {

				return true;
			}
		}

		return false;
	}

	private static final String _EDUCATION_TYPE_COLLEGE = "College";

	private static final String _EDUCATION_TYPE_HIGH_SCHOOL = "High School";

	private static final String _FORM_TEMPLATE_PATH_EDUCATION =
		"templates/ct_fields_education.ftl";

}