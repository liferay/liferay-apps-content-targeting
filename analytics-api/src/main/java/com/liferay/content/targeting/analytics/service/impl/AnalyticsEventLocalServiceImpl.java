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

import com.liferay.content.targeting.analytics.configuration.AnalyticsServiceConfigurationUtil;
import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.model.AnalyticsReferrer;
import com.liferay.content.targeting.analytics.service.base.AnalyticsEventLocalServiceBaseImpl;
import com.liferay.content.targeting.analytics.util.PortletPropsKeys;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the analytics event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.analytics.service.base.AnalyticsEventLocalServiceBaseImpl
 * @see com.liferay.content.targeting.analytics.service.AnalyticsEventLocalServiceUtil
 */
public class AnalyticsEventLocalServiceImpl
	extends AnalyticsEventLocalServiceBaseImpl {

	@Override
	public AnalyticsEvent addAnalyticsEvent(
			long userId, long anonymousUserId, String className, long classPK,
			Map<String, long[]> referrers, String elementId, String eventType,
			String clientIP, String userAgent, String languageId, String URL,
			String additionalInfo, ServiceContext serviceContext)
		throws PortalException {

		AnalyticsEvent analyticsEvent = addAnalyticsEvent(
			userId, anonymousUserId, className, classPK, elementId, eventType,
			clientIP, userAgent, languageId, URL, additionalInfo,
			serviceContext);

		for (Map.Entry<String, long[]> entry : referrers.entrySet()) {
			String referrerClassName = entry.getKey();

			for (long referrerClassPK : entry.getValue()) {
				analyticsReferrerLocalService.addAnalyticsReferrer(
					analyticsEvent.getAnalyticsEventId(), referrerClassName,
					referrerClassPK);
			}
		}

		return analyticsEvent;
	}

	@Override
	public AnalyticsEvent addAnalyticsEvent(
			long userId, long anonymousUserId, String className, long classPK,
			String referrerClassName, long[] referrerClassPKs, String elementId,
			String eventType, String clientIP, String userAgent,
			String languageId, String URL, String additionalInfo,
			ServiceContext serviceContext)
		throws PortalException {

		AnalyticsEvent analyticsEvent = addAnalyticsEvent(
			userId, anonymousUserId, className, classPK, elementId, eventType,
			clientIP, userAgent, languageId, URL, additionalInfo,
			serviceContext);

		for (long referrerClassPK : referrerClassPKs) {
			analyticsReferrerLocalService.addAnalyticsReferrer(
				analyticsEvent.getAnalyticsEventId(), referrerClassName,
				referrerClassPK);
		}

		return analyticsEvent;
	}

	@Override
	public AnalyticsEvent addAnalyticsEvent(
			long userId, long anonymousUserId, String className, long classPK,
			String elementId, String eventType, String clientIP,
			String userAgent, String languageId, String URL,
			String additionalInfo, ServiceContext serviceContext)
		throws PortalException {

		long analyticsEventId = counterLocalService.increment();

		AnalyticsEvent analyticsEvent = analyticsEventPersistence.create(
			analyticsEventId);

		analyticsEvent.setCompanyId(serviceContext.getCompanyId());

		User user = userLocalService.fetchUser(userId);

		if (user != null) {
			analyticsEvent.setUserId(user.getUserId());
		}

		analyticsEvent.setCreateDate(serviceContext.getCreateDate(new Date()));

		analyticsEvent.setAnonymousUserId(anonymousUserId);
		analyticsEvent.setClassName(className);
		analyticsEvent.setClassPK(classPK);
		analyticsEvent.setElementId(elementId);
		analyticsEvent.setEventType(eventType);
		analyticsEvent.setClientIP(clientIP);
		analyticsEvent.setUserAgent(userAgent);
		analyticsEvent.setLanguageId(languageId);
		analyticsEvent.setURL(URL);
		analyticsEvent.setAdditionalInfo(additionalInfo);

		analyticsEventPersistence.update(analyticsEvent);

		return analyticsEvent;
	}

	@Override
	public void checkAnalyticsEvents() throws PortalException {
		ActionableDynamicQuery actionableDynamicQuery =
			companyLocalService.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Company>() {

				@Override
				public void performAction(Company company)
					throws PortalException {

					deleteAnalyticsEvents(company.getCompanyId(), getMaxAge());
				}

			}
		);

		actionableDynamicQuery.performActions();
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public AnalyticsEvent deleteAnalyticsEvent(AnalyticsEvent analyticsEvent) {
		analyticsEventPersistence.remove(analyticsEvent);

		// Analytic referrers

		for (AnalyticsReferrer analyticsReferrer :
				analyticsReferrerLocalService.getAnalyticsReferrers(
					analyticsEvent.getAnalyticsEventId())) {

			analyticsReferrerLocalService.deleteAnalyticsReferrer(
				analyticsReferrer);
		}

		return analyticsEvent;
	}

	@Override
	public void deleteAnalyticsEvents(long companyId, Date createDate)
		throws PortalException {

		List<AnalyticsEvent> analyticsEvents =
			analyticsEventPersistence.findByC_LtD(companyId, createDate);

		for (AnalyticsEvent analyticsEvent : analyticsEvents) {
			deleteAnalyticsEvent(analyticsEvent);
		}
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			long companyId, Date createDate)
		throws PortalException {

		return analyticsEventPersistence.findByC_GtD(companyId, createDate);
	}

	@Override
	public List<Object[]> getAnalyticsEvents(
			long companyId, String referrerClassName, long referrerClassPK,
			Date createDate)
		throws PortalException {

		return analyticsEventFinder.findByC_GtC_R_R(
			companyId, referrerClassName, referrerClassPK, createDate);
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			long anonymousUserId, String className, long classPK,
			String eventType)
		throws PortalException {

		return analyticsEventPersistence.findByA_C_C_E(
			anonymousUserId, className, classPK, eventType);
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			String className, long classPK, String eventType)
		throws PortalException {

		return analyticsEventPersistence.findByC_C_E(
			className, classPK, eventType);
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			String className, long classPK, String eventType, Date createDate)
		throws PortalException {

		return analyticsEventPersistence.findByC_C_E_GtD(
			className, classPK, eventType, createDate);
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEvents(
			String elementId, String eventType, Date createDate)
		throws PortalException {

		return analyticsEventPersistence.findByE_E_GtD(
			elementId, eventType, createDate);
	}

	@Override
	public List<AnalyticsEvent> getAnalyticsEventsContent(Date createDate)
		throws PortalException {

		return analyticsEventPersistence.findByNotC_GtD(0, createDate);
	}

	@Override
	public long[] getAnalyticsEventsContentIds(Date createDate)
		throws PortalException {

		List<AnalyticsEvent> analyticsEvents =
			analyticsEventPersistence.findByNotC_GtD(0, createDate);

		return getAnalyticsEventsIds(analyticsEvents);
	}

	@Override
	public int getAnalyticsEventsCount(long companyId, Date createDate)
		throws PortalException {

		return analyticsEventPersistence.countByC_GtD(companyId, createDate);
	}

	@Override
	public int getAnalyticsEventsCount(
			long anonymousUserId, String className, long classPK,
			String eventType)
		throws PortalException {

		return analyticsEventPersistence.countByA_C_C_E(
			anonymousUserId, className, classPK, eventType);
	}

	@Override
	public int getAnalyticsEventsCount(
			String className, long classPK, String eventType)
		throws PortalException {

		return analyticsEventPersistence.countByC_C_E(
			className, classPK, eventType);
	}

	@Override
	public int getAnalyticsEventsCount(
			String className, long classPK, String eventType, Date createDate)
		throws PortalException {

		return analyticsEventPersistence.countByC_C_E_GtD(
			className, classPK, eventType, createDate);
	}

	@Override
	public int getAnalyticsEventsCount(
			String className, long classPK, String referrerClassName,
			long referrerClassPK, String eventType, Date createDate)
		throws PortalException {

		long[] analyticsEventsIds = getAnalyticsEventsIds(
			className, classPK, eventType, createDate);

		return analyticsReferrerPersistence.countByA_R_R(
			analyticsEventsIds, referrerClassName, referrerClassPK);
	}

	@Override
	public int getAnalyticsEventsCount(
			String referrerClassName, long referrerClassPK, String elementId,
			String eventType, Date createDate)
		throws PortalException {

		long[] analyticsEventsIds = getAnalyticsEventsIds(
			elementId, eventType, createDate);

		return analyticsReferrerPersistence.countByA_R_R(
			analyticsEventsIds, referrerClassName, referrerClassPK);
	}

	@Override
	public int getAnalyticsEventsCount(
			String elementId, String eventType, Date createDate)
		throws PortalException {

		return analyticsEventPersistence.countByE_E_GtD(
			elementId, eventType, createDate);
	}

	@Override
	public long[] getAnalyticsEventsIds(
			String className, long classPK, String eventType, Date createDate)
		throws PortalException {

		List<AnalyticsEvent> analyticsEvents =
			analyticsEventPersistence.findByC_C_E_GtD(
				className, classPK, eventType, createDate);

		return getAnalyticsEventsIds(analyticsEvents);
	}

	@Override
	public long[] getAnalyticsEventsIds(
			String elementId, String eventType, Date createDate)
		throws PortalException {

		List<AnalyticsEvent> analyticsEvents =
			analyticsEventPersistence.findByE_E_GtD(
				elementId, eventType, createDate);

		return getAnalyticsEventsIds(analyticsEvents);
	}

	@Override
	public Date getMaxAge() throws PortalException {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());

		int maxAge = AnalyticsServiceConfigurationUtil.getInteger(
			PortletPropsKeys.ANALYTICS_EVENTS_MAX_AGE);

		calendar.add(Calendar.DAY_OF_YEAR, -maxAge);

		return calendar.getTime();
	}

	protected long[] getAnalyticsEventsIds(
		List<AnalyticsEvent> analyticsEvents) {

		return StringUtil.split(
			ListUtil.toString(
				analyticsEvents, AnalyticsEvent.ANALYTICS_EVENT_ID_ACCESSOR),
			0L);
	}

}