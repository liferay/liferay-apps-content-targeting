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

package com.liferay.content.targeting.messaging;

import com.liferay.content.targeting.model.AnonymousUserUserSegment;
import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.service.ServiceContext;

import java.util.Calendar;
import java.util.List;

/**
 * @author Pavel Savinov
 */
public class AnonymousUserUserSegmentsMessageListener
	extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		long anonymousUserId = message.getLong("anonymousUserId");
		long companyId = message.getLong("companyId");
		long timeInMillis = message.getLong("date");
		long userSegmentId = message.getLong("userSegmentId");

		List<AnonymousUserUserSegment> anonymousUserUserSegments =
			AnonymousUserUserSegmentLocalServiceUtil.
				getAnonymousUserUserSegments(anonymousUserId, userSegmentId);

		boolean hasActiveUserSegment = false;

		Calendar calendar = CalendarFactoryUtil.getCalendar();
		calendar.setTimeInMillis(timeInMillis);

		for (AnonymousUserUserSegment anonymousUserUserSegment
				: anonymousUserUserSegments) {

			if (anonymousUserUserSegment.isActive()) {
				anonymousUserUserSegment.setModifiedDate(calendar.getTime());

				AnonymousUserUserSegmentLocalServiceUtil.
					updateAnonymousUserUserSegment(anonymousUserUserSegment);

				hasActiveUserSegment = true;
			}
		}

		if (!hasActiveUserSegment) {
			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setCompanyId(companyId);

			AnonymousUserUserSegmentLocalServiceUtil.
				addAnonymousUserUserSegment(
					anonymousUserId, userSegmentId, false, true,
					serviceContext);
		}
	}

}