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

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true, property = {"destination.name=liferay/analytics"},
	service = MessageListener.class
)
public class AnalyticsMessageListener extends BaseMessageListener {

	@Override
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

		if (Validator.isNull(className) && Validator.isNull(elementId)) {
			return;
		}

		Map<String, long[]> referrers = (Map<String, long[]>)message.get(
			"referrers");

		if ((referrers == null) || referrers.isEmpty()) {
			referrers = new HashMap<>();

			referrers.put(
				Layout.class.getName(), new long[] {message.getLong("plid")});
		}

		String URL = message.getString("layoutURL");
		String userAgent = message.getString("userAgent");
		long userId = message.getLong("userId");

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(companyId);

		_analyticsEventLocalService.addAnalyticsEvent(
			userId, anonymousUserId, className, classPK, referrers, elementId,
			eventType, clientIP, userAgent, languageId, URL, additionalInfo,
			serviceContext);
	}

	@Reference(unbind = "-")
	protected void setAnalyticsEventLocalService(
		AnalyticsEventLocalService analyticsEventLocalService) {

		_analyticsEventLocalService = analyticsEventLocalService;
	}

	@Reference(target = "(destination.name=liferay/analytics)", unbind = "-")
	protected void setDestination(Destination destination) {
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AnalyticsMessageListener.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;

}