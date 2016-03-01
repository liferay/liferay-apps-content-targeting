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

package com.liferay.content.targeting.analytics.service.impl;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.service.base.AnalyticsEventServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the analytics event remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.analytics.service.AnalyticsEventService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.analytics.service.base.AnalyticsEventServiceBaseImpl
 * @see com.liferay.content.targeting.analytics.service.AnalyticsEventServiceUtil
 */
public class AnalyticsEventServiceImpl extends AnalyticsEventServiceBaseImpl {

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			long companyId, Date createDate)
		throws PortalException {

		return analyticsEventLocalService.getAnalyticsEvents(
			companyId, createDate);
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			String className, long classPK, String eventType, Date createDate)
		throws PortalException {

		return analyticsEventLocalService.getAnalyticsEvents(
			className, classPK, eventType, createDate);
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			String elementId, String eventType, Date createDate)
		throws PortalException {

		return analyticsEventLocalService.getAnalyticsEvents(
			elementId, eventType, createDate);
	}

}