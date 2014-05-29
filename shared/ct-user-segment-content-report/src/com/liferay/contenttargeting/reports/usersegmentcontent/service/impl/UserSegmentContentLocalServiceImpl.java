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

package com.liferay.contenttargeting.reports.usersegmentcontent.service.impl;

import com.liferay.analytics.service.AnalyticsEventLocalService;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.reports.usersegmentcontent.model.UserSegmentContent;
import com.liferay.contenttargeting.reports.usersegmentcontent.service.base.UserSegmentContentLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the user segment content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.reports.usersegmentcontent.service.UserSegmentContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.reports.usersegmentcontent.service.base.UserSegmentContentLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.reports.usersegmentcontent.service.UserSegmentContentLocalServiceUtil
 */
public class UserSegmentContentLocalServiceImpl
	extends UserSegmentContentLocalServiceBaseImpl {

	public UserSegmentContentLocalServiceImpl() {
		_initAnalyticsEventService();
	}

	@Override
	public UserSegmentContent addUserSegmentContent(
			long userSegmentId, String className, long classPK,
			String eventType, int count)
		throws PortalException, SystemException {

		UserSegmentContent userSegmentContent = getUserSegmentContent(
			userSegmentId, className, classPK, eventType);

		if (userSegmentContent == null) {
			long userSegmentContentId = CounterLocalServiceUtil.increment();

			userSegmentContent = userSegmentContentPersistence.create(
				userSegmentContentId);

			userSegmentContent.setUserSegmentId(userSegmentId);
			userSegmentContent.setClassName(className);
			userSegmentContent.setClassPK(classPK);
			userSegmentContent.setEventType(eventType);
			userSegmentContent.setCount(count);
		}

		userSegmentContent.setCount(userSegmentContent.getCount() + count);
		userSegmentContent.setModifiedDate(new Date());

		userSegmentContentPersistence.update(userSegmentContent);

		return userSegmentContent;
	}

	@Override
	public void checkUserSegmentContentEvents()
		throws PortalException, SystemException {

		// Process analytics from last date

		addUserSegmentContentsFromAnalytics(getLastUserSegmentContentDate());
	}

	@Override
	public Date getLastUserSegmentContentDate() {
		try {
			List<UserSegmentContent> userSegmentContentList =
				userSegmentContentPersistence.findAll(0, 1);

			if (!userSegmentContentList.isEmpty()) {
				return userSegmentContentList.get(0).getModifiedDate();
			}
			else {
				return _analyticsEventLocalService.getMaxAge();
			}
		}
		catch (Exception e) {
		}

		return null;
	}

	@Override
	public UserSegmentContent getUserSegmentContent(
			long userSegmentId, String className, long classPK,
			String eventType)
		throws PortalException, SystemException {

		return userSegmentContentPersistence.fetchByC_C_C_E(
				userSegmentId, className, classPK, eventType);
	}

	@Override
	public List<UserSegmentContent> getUserSegmentContents(long userSegmentId)
		throws PortalException, SystemException {

		return userSegmentContentPersistence.findByUserSegmentId(userSegmentId);
	}

	@Override
	public List<UserSegmentContent> getUserSegmentContents(
			long userSegmentId, Date modifiedDate)
		throws PortalException, SystemException {

		return userSegmentContentPersistence.findByC_GtD(
				userSegmentId, modifiedDate);
	}

	@Override
	public List<UserSegmentContent> getUserSegmentContents(
			long userSegmentId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException, SystemException {

		return userSegmentContentPersistence.findByUserSegmentId(
				userSegmentId, start, end, orderByComparator);
	}

	@Override
	public int getUserSegmentContentsCount(long userSegmentId)
		throws PortalException, SystemException {

		return userSegmentContentPersistence.countByUserSegmentId(
			userSegmentId);
	}

	protected void addUserSegmentContentsFromAnalytics(Date date)
		throws PortalException, SystemException {

		// Retrieve analytics

		DynamicQuery dynamicQuery = _analyticsEventLocalService.dynamicQuery();

		Property referrerClassNameProperty = PropertyFactoryUtil.forName(
			"referrerClassName");

		dynamicQuery.add(
			referrerClassNameProperty.eq(UserSegment.class.getName()));

		Property createDateProperty = PropertyFactoryUtil.forName("createDate");

		dynamicQuery.add(createDateProperty.gt(date));

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

		projectionList.add(ProjectionFactoryUtil.groupProperty("className"));
		projectionList.add(ProjectionFactoryUtil.groupProperty("classPK"));
		projectionList.add(
			ProjectionFactoryUtil.groupProperty("referrerClassPK"));

		dynamicQuery.setProjection(projectionList);

		List<Object[]> results = _analyticsEventLocalService.dynamicQuery(
			dynamicQuery);

		// Process analytics and store data

		for (Object[] result : results) {
			String className = GetterUtil.getString(result[0]);
			long classPK = GetterUtil.getLong(result[1]);
			long referrerClassPK = GetterUtil.getLong(result[2]);

			int contentViewCount =
				_analyticsEventLocalService.getAnalyticsEventsCount(
					className, classPK, UserSegment.class.getName(),
					referrerClassPK, "view", date);

			if (contentViewCount == 0) {
				continue;
			}

			addUserSegmentContent(
				referrerClassPK, className, classPK, "view", contentViewCount);
		}
	}

	private void _initAnalyticsEventService() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserSegmentContentLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;

}