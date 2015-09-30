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

package com.liferay.content.targeting.channel.twitter.sample;

import com.liferay.consumer.manager.extension.twitter.sample.provider.TwitterAPIProvider;
import com.liferay.consumer.manager.extension.twitter.sample.provider.TwitterAPISettings;
import com.liferay.consumer.manager.model.Consumer;
import com.liferay.content.targeting.InvalidChannelException;
import com.liferay.content.targeting.api.model.BaseChannel;
import com.liferay.content.targeting.api.model.Channel;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Brian Chan
 */
@Component(immediate = true, service = Channel.class)
public class TwitterSampleChannel extends BaseChannel {

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
	public String getIcon() {
		return "icon-twitter";
	}

	@Override
	public String getSummary(ChannelInstance channelInstance, Locale locale) {
		return LanguageUtil.get(locale, channelInstance.getTypeSettings());
	}

	@Override
	public boolean isInstantiable() {
		return false;
	}

	@Override
	public String processChannel(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidChannelException {

		long consumerId = GetterUtil.getLong(values.get("consumerId"));
		String message = values.get("message");

		try {
			TwitterAPISettings twitterAPISettings =
				_twitterAPIProvider.getTwitterAPISettings(consumerId);

			if (twitterAPISettings == null) {
				throw new InvalidChannelException(
					"Missing Twitter API Settings");
			}

			List<String> twitterUsers = _getTwitterUsers(request);

			if (!twitterUsers.isEmpty()) {
				_sendMessage(twitterAPISettings, twitterUsers, message);
			}
		}
		catch (Exception e) {
			throw new InvalidChannelException(
				"Cannot send twitter messages", e);
		}

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("consumerId", consumerId);
		jsonObj.put("message", message);

		return jsonObj.toString();
	}

	@Reference
	public void setAnonymousUserUserSegmentLocalService(
			AnonymousUserUserSegmentLocalService
				anonymousUserUserSegmentLocalService) {

		_anonymousUserUserSegmentLocalService =
			anonymousUserUserSegmentLocalService;
	}

	@Reference
	public void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		_campaignLocalService = campaignLocalService;
	}

	@Reference
	public void setTwitterAPIProvider(TwitterAPIProvider twitterAPIProvider) {
		_twitterAPIProvider = twitterAPIProvider;
	}

	@Reference
	public void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	@Reference
	public void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	@Override
	protected void populateContext(
		ChannelInstance channelInstance, Map<String, Object> context,
		Map<String, String> values) {

		long consumerId = 0;
		String message = StringPool.BLANK;

		if (!values.isEmpty()) {
			consumerId = GetterUtil.getLong(values.get("consumerId"));
			message = values.get("message");
		}
		else if (channelInstance != null) {
			String typeSettings = channelInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				consumerId = GetterUtil.getLong(jsonObj.getInt("consumerId"));
				message = jsonObj.getString("message");
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
		context.put("message", message);
	}

	private List<String> _getTwitterUsers(PortletRequest request)
		throws Exception {

		long campaignId = ParamUtil.getLong(request, "campaignId");

		Campaign campaign = _campaignLocalService.fetchCampaign(campaignId);

		if (!campaign.isActive()) {
			return Collections.emptyList();
		}

		long tacticId = ParamUtil.getLong(request, "tacticId");

		List<UserSegment> tacticUserSegments =
			_userSegmentLocalService.getTacticUserSegments(tacticId);

		List<User> users = _userLocalService.getGroupUsers(
			campaign.getGroupId());

		List<String> twitterUsers = new ArrayList<String>();

		for (User user : users) {
			Contact contact = user.getContact();

			String twitterScreenName = contact.getTwitterSn();

			if (Validator.isNull(twitterScreenName)) {
				continue;
			}

			List<UserSegment> userSegments =
				_anonymousUserUserSegmentLocalService.getUserSegmentsByUserId(
					user.getUserId(), true);

			if (Collections.disjoint(userSegments, tacticUserSegments)) {
				continue;
			}

			twitterUsers.add(twitterScreenName);
		}

		return twitterUsers;
	}

	private void _sendMessage(
			TwitterAPISettings twitterAPISettings, List<String> twitterUsers,
			String message)
		throws Exception {

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(twitterAPISettings.getConsumerKey());
		cb.setOAuthConsumerSecret(twitterAPISettings.getConsumerSecret());
		cb.setOAuthAccessToken(twitterAPISettings.getAccessKey());
		cb.setOAuthAccessTokenSecret(twitterAPISettings.getAccessSecret());

		TwitterFactory twitterFactory = new TwitterFactory(cb.build());

		Twitter twitter = twitterFactory.getInstance();

		for (String twitterUser : twitterUsers) {
			twitter.updateStatus("@" + twitterUser + " " + message);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TwitterSampleChannel.class);

	private AnonymousUserUserSegmentLocalService
		_anonymousUserUserSegmentLocalService;
	private CampaignLocalService _campaignLocalService;
	private TwitterAPIProvider _twitterAPIProvider;
	private UserLocalService _userLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}