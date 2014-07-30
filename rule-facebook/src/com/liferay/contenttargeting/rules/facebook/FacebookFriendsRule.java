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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.WebKeys;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.json.JsonObject;
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
public class FacebookFriendsRule extends BaseRule {

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

		JSONObject typeSettings = JSONFactoryUtil.createJSONObject(
			anonymousUser.getTypeSettings());

		FacebookClient facebookClient = new DefaultFacebookClient(
			typeSettings.getString(WebKeys.FACEBOOK_ACCESS_TOKEN));

		int numberOfFriends = GetterUtil.getInteger(
			ruleInstance.getTypeSettings());

		User user = facebookClient.fetchObject("me", User.class);

		String query =
			"SELECT friend_count FROM user WHERE uid = " + user.getId();

		List<JsonObject> jsonObjects = facebookClient.executeFqlQuery(
			query, JsonObject.class);

		JsonObject jsonObject = jsonObjects.get(0);

		long friendCount = GetterUtil.getLong(jsonObject.get("friend_count"));

		if (friendCount >= numberOfFriends) {
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

		return values.get("numberOfFriends");
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_FRIENDS;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		int numberOfFriends = 0;

		if (ruleInstance != null) {
			numberOfFriends = GetterUtil.getInteger(
				ruleInstance.getTypeSettings());
		}

		context.put("numberOfFriends", numberOfFriends);
	}

	protected static final String _FORM_TEMPLATE_PATH_FRIENDS =
		"templates/ct_fields_friends.ftl";

}