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

package com.liferay.consumer.manager.extension.twitter.sample;

import com.liferay.consumer.manager.InvalidConsumerExtensionException;
import com.liferay.consumer.manager.api.model.BaseConsumerExtension;
import com.liferay.consumer.manager.api.model.ConsumerExtension;
import com.liferay.consumer.manager.model.ConsumerExtensionInstance;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = ConsumerExtension.class)
public class TwitterSampleConsumerExtension extends BaseConsumerExtension {

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
	public String getSummary(
		ConsumerExtensionInstance extensionInstance, Locale locale) {

		return LanguageUtil.get(locale, extensionInstance.getTypeSettings());
	}

	@Override
	public String processConsumerExtension(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidConsumerExtensionException {

		String twitterAccessKey = values.get("twitterAccessKey");
		String twitterAccessSecret = values.get("twitterAccessSecret");
		String twitterConsumerKey = values.get("twitterConsumerKey");
		String twitterConsumerSecret = values.get("twitterConsumerSecret");

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("twitterAccessKey", twitterAccessKey);
		jsonObj.put("twitterAccessSecret", twitterAccessSecret);
		jsonObj.put("twitterConsumerKey", twitterConsumerKey);
		jsonObj.put("twitterConsumerSecret", twitterConsumerSecret);

		return jsonObj.toString();
	}

	@Override
	protected void populateContext(
		ConsumerExtensionInstance extensionInstance,
		Map<String, Object> context, Map<String, String> values) {

		String twitterAccessKey = StringPool.BLANK;
		String twitterAccessSecret = StringPool.BLANK;
		String twitterConsumerKey = StringPool.BLANK;
		String twitterConsumerSecret = StringPool.BLANK;

		if (!values.isEmpty()) {
			twitterAccessKey = values.get("twitterAccessKey");
			twitterAccessSecret = values.get("twitterAccessSecret");
			twitterConsumerKey = values.get("twitterConsumerKey");
			twitterConsumerSecret = values.get("twitterConsumerSecret");
		}
		else if (extensionInstance != null) {
			String typeSettings = extensionInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				twitterAccessKey = jsonObj.getString("twitterAccessKey");
				twitterAccessSecret = jsonObj.getString("twitterAccessSecret");
				twitterConsumerKey = jsonObj.getString("twitterConsumerKey");
				twitterConsumerSecret = jsonObj.getString(
					"twitterConsumerSecret");
			}
			catch (JSONException jse) {
			}
		}

		context.put("twitterAccessKey", twitterAccessKey);
		context.put("twitterAccessSecret", twitterAccessSecret);
		context.put("twitterConsumerKey", twitterConsumerKey);
		context.put("twitterConsumerSecret", twitterConsumerSecret);
	}

}