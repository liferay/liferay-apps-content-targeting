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

package com.liferay.content.targeting.report.user.segment.content.service.impl;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.user.segment.content.UserSegmentContentReport;
import com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent;
import com.liferay.content.targeting.report.user.segment.content.service.base.UserSegmentContentLocalServiceBaseImpl;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the user segment content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.user.segment.content.service.base.UserSegmentContentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalServiceUtil
 */
public class UserSegmentContentLocalServiceImpl
	extends UserSegmentContentLocalServiceBaseImpl {

	public UserSegmentContentLocalServiceImpl() {
		_initServices();
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

		List<UserSegment> userSegments =
			_userSegmentLocalService.getUserSegments(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		ServiceContext serviceContext = new ServiceContext();

		for (UserSegment userSegment : userSegments) {
			checkUserSegmentContentEvents(userSegment.getUserSegmentId());

			serviceContext.setScopeGroupId(userSegment.getGroupId());

			_reportInstanceLocalService.addReportInstance(
				userSegment.getUserId(),
				UserSegmentContentReport.class.getSimpleName(),
				UserSegment.class.getName(), userSegment.getUserSegmentId(),
				StringPool.BLANK, new ServiceContext());
		}
	}

	@Override
	public void checkUserSegmentContentEvents(long userSegmentId)
		throws PortalException, SystemException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				UserSegmentContentReport.class.getSimpleName(),
				UserSegment.class.getName(), userSegmentId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		addUserSegmentContentsFromAnalytics(userSegmentId, modifiedDate);
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

	protected void addUserSegmentContentsFromAnalytics(
			long userSegmentId, Date date)
		throws PortalException, SystemException {

		// Retrieve analytics

		DynamicQuery dynamicQuery = _analyticsEventLocalService.dynamicQuery();

		Property classPKProperty = PropertyFactoryUtil.forName("classPK");
		Property referrerClassNameProperty = PropertyFactoryUtil.forName(
			"referrerClassName");
		Property referrerClassPKProperty = PropertyFactoryUtil.forName(
			"referrerClassPK");

		dynamicQuery.add(classPKProperty.gt(0L));
		dynamicQuery.add(
			referrerClassNameProperty.eq(UserSegment.class.getName()));
		dynamicQuery.add(referrerClassPKProperty.eq(userSegmentId));

		if (date == null) {
			date = _analyticsEventLocalService.getMaxAge();
		}

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

	private void _initServices() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, bundle.getBundleContext());
		_reportInstanceLocalService = ServiceTrackerUtil.getService(
			ReportInstanceLocalService.class, bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserSegmentContentLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}