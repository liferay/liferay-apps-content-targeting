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

package com.liferay.analytics.messaging;

import com.liferay.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.ServiceContext;

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
		long companyId = message.getLong("companyId");
		long userId = message.getLong("userId");
		long anonymousUserId = message.getLong("anonymousUserId");
		String eventType = message.getString("event");
		String className = message.getString("className");
		long classPK = message.getLong("classPK");
		String referrerClassName = message.getString("referrerClassName");

		String[] values = StringUtil.split(
			message.getString("referrerClassPK"));

		long[] referrerClassPKs = GetterUtil.getLongValues(values);

		if (Validator.isNull(referrerClassName) ||
			Validator.isNull(referrerClassPKs)) {

			referrerClassName = Layout.class.getName();
			referrerClassPKs = new long[] {message.getLong("plid")};
		}

		String clientIP = message.getString("clientIP");
		String userAgent = message.getString("userAgent");
		String languageId = message.getString("languageId");
		String URL = message.getString("layoutURL");

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(companyId);

		AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
			userId, anonymousUserId, className, classPK, referrerClassName,
			referrerClassPKs, eventType, clientIP, userAgent, languageId, URL,
			StringPool.BLANK, serviceContext);
	}

	private static Log _log = LogFactoryUtil.getLog(
		AnalyticsMessageListener.class);

}