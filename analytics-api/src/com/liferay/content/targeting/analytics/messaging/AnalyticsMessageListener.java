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

package com.liferay.content.targeting.analytics.messaging;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.ServiceContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eduardo Garcia
 */
public class AnalyticsMessageListener implements MessageListener {

	@Override
	public void receive(Message message) {
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	protected void doReceive(Message message) throws Exception {
		String additionalInfo = message.getString("additionalInfo");
		long anonymousUserId = message.getLong("anonymousUserId");
		String className = message.getString("className");
		long classPK = message.getLong("classPK");
		String clientIP = message.getString("clientIP");
		long companyId = message.getLong("companyId");
		String elementId = message.getString("elementId");
		String eventType = message.getString("event");
		String languageId = message.getString("languageId");

		Map<String, long[]> referrers = (Map<String, long[]>)message.get(
			"referrers");

		if ((referrers == null) || referrers.isEmpty()) {
			referrers = new HashMap<String, long[]>();

			referrers.put(
				Layout.class.getName(), new long[] {message.getLong("plid")});
		}

		String URL = message.getString("layoutURL");
		String userAgent = message.getString("userAgent");
		long userId = message.getLong("userId");

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(companyId);

		AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
			userId, anonymousUserId, className, classPK, referrers, elementId,
			eventType, clientIP, userAgent, languageId, URL, additionalInfo,
			serviceContext);
	}

	private static Log _log = LogFactoryUtil.getLog(
		AnalyticsMessageListener.class);

}