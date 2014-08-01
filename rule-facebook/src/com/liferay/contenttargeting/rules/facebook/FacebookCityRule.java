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
import com.liferay.contenttargeting.rules.facebook.util.FacebookUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.WebKeys;

import com.restfb.types.NamedFacebookType;
import com.restfb.types.User;

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
public class FacebookCityRule extends BaseRule {

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

		String cityName = ruleInstance.getTypeSettings();

		if (Validator.isNull(cityName)) {
			return false;
		}

		JSONObject typeSettings = JSONFactoryUtil.createJSONObject(
			anonymousUser.getTypeSettings());

		User user = FacebookUtil.getFacebookUser(
			typeSettings.getString(WebKeys.FACEBOOK_ACCESS_TOKEN));

		NamedFacebookType location = user.getLocation();

		if (StringUtil.toLowerCase(location.getName()).contains(
				StringUtil.toLowerCase(cityName))) {

			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-globe";
	}

	@Override
	public String getRuleCategoryKey() {
		return SocialRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		return ruleInstance.getTypeSettings();
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		return values.get("cityName");
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_CITY;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		String cityName = StringPool.BLANK;

		if (ruleInstance != null) {
			cityName = ruleInstance.getTypeSettings();
		}

		context.put("cityName", cityName);
	}

	protected static final String _FORM_TEMPLATE_PATH_CITY =
		"templates/ct_fields_city.ftl";

}