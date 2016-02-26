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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
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
public class FacebookLikeRule extends BaseFacebookRule {

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

		String accessToken = typeSettings.getString(
			FacebookConnectWebKeys.FACEBOOK_ACCESS_TOKEN);

		return FacebookUtil.isUserLikes(
			accessToken, ruleInstance.getTypeSettings());
	}

	@Override
	public String getIcon() {
		return "icon-facebook-sign";
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

		return values.get("facebookName");
	}

	@Override
	protected void doPopulateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String name = StringPool.BLANK;

		if (!values.isEmpty()) {
			name = values.get("facebookName");
		}
		else if (ruleInstance != null) {
			name = ruleInstance.getTypeSettings();
		}

		context.put("facebookName", name);
	}

	@Override
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_LIKE;
	}

	private static final String _FORM_TEMPLATE_PATH_LIKE =
		"templates/ct_fields_like.ftl";

}