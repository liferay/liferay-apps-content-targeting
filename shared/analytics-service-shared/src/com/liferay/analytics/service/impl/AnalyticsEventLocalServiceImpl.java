/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.analytics.service.impl;

import com.liferay.analytics.model.AnalyticsEvent;
import com.liferay.analytics.service.base.AnalyticsEventLocalServiceBaseImpl;
import com.liferay.analytics.util.PortletPropsValues;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.CompanyActionableDynamicQuery;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the analytics event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.analytics.service.AnalyticsEventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.analytics.service.base.AnalyticsEventLocalServiceBaseImpl
 * @see com.liferay.analytics.service.AnalyticsEventLocalServiceUtil
 */
public class AnalyticsEventLocalServiceImpl
	extends AnalyticsEventLocalServiceBaseImpl {

	@Override
	public AnalyticsEvent addAnalyticsEvent(
			long userId, long anonymousUserId, String eventType,
			String className, long classPK, String referrerClassName,
			long referrerClassPK, String clientIP, String userAgent,
			String languageId, String URL, String additionalInfo,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		long analyticsEventId = CounterLocalServiceUtil.increment();

		AnalyticsEvent analyticsEvent = analyticsEventPersistence.create(
			analyticsEventId);

		analyticsEvent.setCompanyId(serviceContext.getCompanyId());

		User user = UserLocalServiceUtil.fetchUser(userId);

		if (user != null) {
			analyticsEvent.setUserId(user.getUserId());
		}

		analyticsEvent.setCreateDate(serviceContext.getCreateDate(new Date()));

		analyticsEvent.setAnonymousUserId(anonymousUserId);
		analyticsEvent.setEventType(eventType);
		analyticsEvent.setClassName(className);
		analyticsEvent.setClassPK(classPK);
		analyticsEvent.setReferrerClassName(referrerClassName);
		analyticsEvent.setReferrerClassPK(referrerClassPK);
		analyticsEvent.setClientIP(clientIP);
		analyticsEvent.setUserAgent(userAgent);
		analyticsEvent.setLanguageId(languageId);
		analyticsEvent.setURL(URL);
		analyticsEvent.setAdditionalInfo(additionalInfo);

		analyticsEventPersistence.update(analyticsEvent);

		return analyticsEvent;
	}

	@Override
	public void checkAnalyticsEvents() throws PortalException, SystemException {
		ActionableDynamicQuery actionableDynamicQuery =
			new CompanyActionableDynamicQuery() {

				@Override
				protected void performAction(Object object)
					throws PortalException, SystemException {

					Company company = (Company)object;

					deleteAnalyticsEvents(company.getCompanyId(), getMaxAge());
				}

			};

		actionableDynamicQuery.performActions();
	}

	@Override
	public void deleteAnalyticsEvents(long companyId, Date createDate)
		throws PortalException, SystemException {

		List<AnalyticsEvent> analyticsEvents =
			analyticsEventPersistence.findByC_LtD(companyId, createDate);

		for (AnalyticsEvent analyticsEvent : analyticsEvents) {
			deleteAnalyticsEvent(analyticsEvent);
		}
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			long companyId, Date createDate)
		throws PortalException, SystemException {

		return analyticsEventPersistence.findByC_GtD(companyId, createDate);
	}

	protected Date getMaxAge() throws PortalException, SystemException {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());

		int maxAge = PortletPropsValues.ANALYTICS_EVENTS_MAX_AGE;

		calendar.add(Calendar.MINUTE, -maxAge);

		return calendar.getTime();
	}

}