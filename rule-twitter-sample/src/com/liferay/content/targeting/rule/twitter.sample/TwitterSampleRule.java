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

package com.liferay.content.targeting.rule.twitter.sample;

import com.liferay.consumer.manager.extension.twitter.sample.provider.TwitterAPIProvider;
import com.liferay.consumer.manager.extension.twitter.sample.provider.TwitterAPISettings;
import com.liferay.consumer.manager.model.Consumer;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = Rule.class)
public class TwitterSampleRule extends BaseRule {

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

		User user = anonymousUser.getUser();

		if (user == null) {
			return false;
		}

		Contact contact = user.getContact();

		String twitterScreenName = contact.getTwitterSn();

		if (Validator.isNull(twitterScreenName)) {
			return false;
		}

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
			ruleInstance.getTypeSettings());

		long consumerId = jsonObj.getInt("consumerId");

		TwitterAPISettings twitterAPISettings =
			_twitterAPIProvider.getTwitterAPISettings(consumerId);

		if (twitterAPISettings == null) {
			_log.error("Missing Twitter API Settings");

			return false;
		}

		int followersThreshold = jsonObj.getInt("followersThreshold");

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(twitterAPISettings.getConsumerKey());
		cb.setOAuthConsumerSecret(twitterAPISettings.getConsumerSecret());
		cb.setOAuthAccessToken(twitterAPISettings.getAccessKey());
		cb.setOAuthAccessTokenSecret(twitterAPISettings.getAccessSecret());

		try {
			TwitterFactory twitterFactory = new TwitterFactory(cb.build());

			Twitter twitter = twitterFactory.getInstance();

			IDs followerIDs = twitter.getFollowersIDs(
				twitterScreenName, -1, followersThreshold);

			long[] ids = followerIDs.getIDs();

			if (followersThreshold == ids.length) {
				return true;
			}
		}
		catch (TwitterException te) {
			_log.error("Cannot retrieve data from Twitter", te);
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-twitter";
	}

	@Override
	public String getRuleCategoryKey() {
		return TwitterSampleRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		return LanguageUtil.get(locale, ruleInstance.getTypeSettings());
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		long consumerId = GetterUtil.getLong(values.get("consumerId"));
		int followersThreshold = GetterUtil.getInteger(
			values.get("followersThreshold"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("consumerId", consumerId);
		jsonObj.put("followersThreshold", followersThreshold);

		return jsonObj.toString();
	}

	@Reference
	public void setTwitterAPIProvider(TwitterAPIProvider twitterAPIProvider) {
		_twitterAPIProvider = twitterAPIProvider;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		long consumerId = 0;
		int followersThreshold = 0;

		if (!values.isEmpty()) {
			consumerId = GetterUtil.getLong(values.get("consumerId"));
			followersThreshold = GetterUtil.getInteger(
				values.get("followersThreshold"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				consumerId = GetterUtil.getLong(jsonObj.getInt("consumerId"));
				followersThreshold = GetterUtil.getInteger(
					jsonObj.getInt("followersThreshold"));
			}
			catch (JSONException jse) {
			}
		}

		Company company = (Company)context.get("company");

		List<Consumer> consumers = Collections.emptyList();

		try {
			consumers = _twitterAPIProvider.getTwitterAPIConsumers(
				company.getCompanyId());
		}
		catch (Exception e) {
			_log.error("Missing Twitter API Settings");
		}

		context.put("consumerId", consumerId);
		context.put("consumers", consumers);
		context.put("followersThreshold", followersThreshold);
	}

	private static Log _log = LogFactoryUtil.getLog(TwitterSampleRule.class);

	private TwitterAPIProvider _twitterAPIProvider;

}