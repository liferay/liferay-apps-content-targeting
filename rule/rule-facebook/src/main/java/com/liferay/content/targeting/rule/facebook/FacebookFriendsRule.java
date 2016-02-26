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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.sso.facebook.connect.constants.FacebookConnectWebKeys;

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
public class FacebookFriendsRule extends BaseFacebookRule {

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

		int numberOfFriends = jsonObj.getInt("numberOfFriends");
		String selector = jsonObj.getString("selector");

		JSONObject typeSettings = JSONFactoryUtil.createJSONObject(
			anonymousUser.getTypeSettings());

		long friendsCount = FacebookUtil.getFriendsCount(
			typeSettings.getString(
				FacebookConnectWebKeys.FACEBOOK_ACCESS_TOKEN));

		if (selector.equals("more") && (friendsCount >= numberOfFriends)) {
			return true;
		}

		if (selector.equals("less") && (friendsCount < numberOfFriends)) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-group";
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

		int numberOfFriends = GetterUtil.getInteger(
			values.get("numberOfFriends"));
		String selector = GetterUtil.getString(values.get("selector"), "more");

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("numberOfFriends", numberOfFriends);
		jsonObj.put("selector", selector);

		return jsonObj.toString();
	}

	@Override
	protected void doPopulateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		int numberOfFriends = 0;
		String selector = "more";

		if (!values.isEmpty()) {
			numberOfFriends = GetterUtil.getInteger(
				values.get("numberOfFriends"));
			selector = GetterUtil.getString(values.get("selector"), "more");
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				numberOfFriends = GetterUtil.getInteger(
					jsonObj.getInt("numberOfFriends"));
				selector = GetterUtil.getString(
					jsonObj.getString("selector"), "more");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("numberOfFriends", numberOfFriends);
		context.put("selector", selector);
	}

	@Override
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_FRIENDS;
	}

	private static final String _FORM_TEMPLATE_PATH_FRIENDS =
		"templates/ct_fields_friends.ftl";

}