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

package com.liferay.consumer.manager.extension.twitter.sample.provider;

import com.liferay.consumer.manager.extension.twitter.sample.TwitterSampleConsumerExtension;
import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.model.ConsumerExtensionInstance;
import com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalService;
import com.liferay.consumer.manager.service.ConsumerLocalService;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = TwitterAPIProvider.class)
public class TwitterAPIProviderImpl implements TwitterAPIProvider {

	@Activate
	public void activate() {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"Twitter API Provider activate: " + getClass().getSimpleName());
		}
	}

	@Deactivate
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"Twitter API Provider deactivate: " +
					getClass().getSimpleName());
		}
	}

	@Override
	public List<Consumer> getTwitterAPIConsumers(long companyId)
		throws Exception {

		return _consumerLocalService.getConsumersByConsumerExtensionKey(
			companyId, TwitterSampleConsumerExtension.class.getSimpleName());
	}

	@Override
	public TwitterAPISettings getTwitterAPISettings(long consumerId)
		throws Exception {

		List<ConsumerExtensionInstance> consumerExtensionInstances =
			_consumerExtensionInstanceLocalService.
				getConsumerExtensionInstances(
					consumerId,
					TwitterSampleConsumerExtension.class.getSimpleName());

		if (consumerExtensionInstances.isEmpty()) {
			return null;
		}

		ConsumerExtensionInstance consumerExtensionInstance =
			consumerExtensionInstances.get(0);

		String typeSettings = consumerExtensionInstance.getTypeSettings();

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			TwitterAPISettings twitterAPISettings = new TwitterAPISettings();

			twitterAPISettings.setAccessKey(
				jsonObj.getString("twitterAccessKey"));
			twitterAPISettings.setAccessSecret(
				jsonObj.getString("twitterAccessSecret"));
			twitterAPISettings.setConsumerKey(
				jsonObj.getString("twitterConsumerKey"));
			twitterAPISettings.setConsumerSecret(
				jsonObj.getString("twitterConsumerSecret"));

			return twitterAPISettings;
		}
		catch (JSONException jse) {
		}

		return null;
	}

	@Reference
	public void setConsumerExtensionInstanceLocalService(
		ConsumerExtensionInstanceLocalService
			consumerExtensionInstanceLocalService) {

		_consumerExtensionInstanceLocalService =
			consumerExtensionInstanceLocalService;
	}

	@Reference
	public void setConsumerLocalService(
		ConsumerLocalService consumerLocalService) {

		_consumerLocalService = consumerLocalService;
	}

	private static Log _log = LogFactoryUtil.getLog(
		TwitterAPIProviderImpl.class);

	private ConsumerExtensionInstanceLocalService
		_consumerExtensionInstanceLocalService;
	private ConsumerLocalService _consumerLocalService;

}