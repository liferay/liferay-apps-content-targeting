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

package com.liferay.contenttargeting.rules.facebook;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.rulecategories.SocialRuleCategory;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.WebKeys;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
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
public class FacebookEducationRule extends BaseRule {

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

		boolean college = jsonObj.getBoolean("college");
		boolean highSchool = jsonObj.getBoolean("highSchool");
		String schoolName = jsonObj.getString("schoolName");

		JSONObject typeSettings = JSONFactoryUtil.createJSONObject(
			anonymousUser.getTypeSettings());

		FacebookClient facebookClient = new DefaultFacebookClient(
			typeSettings.getString(WebKeys.FACEBOOK_ACCESS_TOKEN));

		User user = facebookClient.fetchObject("me", User.class);

		List<User.Education> educations = user.getEducation();

		boolean hasCollegeEducation = false;

		if (college) {
			for (User.Education education : educations) {
				if (_EDUCATION_TYPE_COLLEGE.equals(education.getType())) {
					hasCollegeEducation = true;

					break;
				}
			}
		}

		boolean hasHighSchoolEducation = false;

		if (highSchool) {
			for (User.Education education : educations) {
				if (_EDUCATION_TYPE_HIGH_SCHOOL.equals(education.getType())) {
					hasHighSchoolEducation = true;

					break;
				}
			}
		}

		boolean hasSchoolName = false;

		if (Validator.isNotNull(schoolName)) {
			for (User.Education education : educations) {
				String educationSchoolName = education.getSchool().getName();

				if (StringUtil.toLowerCase(educationSchoolName).contains(
						StringUtil.toLowerCase(schoolName))) {

					hasSchoolName = true;

					break;
				}
			}
		}

		if (((college && hasCollegeEducation) || !college) &&
			((highSchool && hasHighSchoolEducation) || !highSchool) &&
			(hasSchoolName || Validator.isNull(schoolName))) {

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

			boolean college = jsonObj.getBoolean("college");
			boolean highSchool = jsonObj.getBoolean("highSchool");
			String schoolName = jsonObj.getString("schoolName");
		}
		catch (JSONException jse) {
		}

		return summary;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		boolean highSchool = GetterUtil.getBoolean(values.get("highSchool"));
		boolean college = GetterUtil.getBoolean(values.get("college"));
		String schoolName = GetterUtil.getString(values.get("schoolName"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("highSchool", highSchool);
		jsonObj.put("college", college);
		jsonObj.put("schoolName", schoolName);

		return jsonObj.toString();
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_EDUCATION;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		boolean college = false;
		boolean highSchool = false;
		String schoolName = StringPool.BLANK;

		if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				college = jsonObj.getBoolean("college");
				highSchool = jsonObj.getBoolean("highSchool");
				schoolName = jsonObj.getString("schoolName");
			}
			catch (JSONException jse) {
			}
		}

		context.put("college", college);
		context.put("highSchool", highSchool);
		context.put("schoolName", schoolName);
	}

	protected static final String _FORM_TEMPLATE_PATH_EDUCATION =
		"templates/ct_fields_education.ftl";

	private final static String _EDUCATION_TYPE_COLLEGE = "College";

	private final static String _EDUCATION_TYPE_HIGH_SCHOOL = "High School";

}