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

package com.liferay.contenttargeting.reports.campaigncontent.service.impl;

import com.liferay.analytics.service.AnalyticsEventLocalService;
import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent;
import com.liferay.contenttargeting.reports.campaigncontent.service.base.CampaignContentLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
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
 * The implementation of the campaign content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.reports.campaigncontent.service.CampaignContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.reports.campaigncontent.service.base.CampaignContentLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.reports.campaigncontent.service.CampaignContentLocalServiceUtil
 */
public class CampaignContentLocalServiceImpl
	extends CampaignContentLocalServiceBaseImpl {

	public CampaignContentLocalServiceImpl() {
		_initAnalyticsEventService();
	}

	@Override
	public CampaignContent addCampaignContent(
			long campaignId, String className, long classPK, String eventType,
			int count)
		throws PortalException, SystemException {

		CampaignContent campaignContent = getCampaignContent(
			campaignId, className, classPK, eventType);

		if (campaignContent == null) {
			long campaignContentId = CounterLocalServiceUtil.increment();

			campaignContent = campaignContentPersistence.create(
				campaignContentId);

			campaignContent.setCampaignId(campaignId);
			campaignContent.setClassName(className);
			campaignContent.setClassPK(classPK);
			campaignContent.setEventType(eventType);
			campaignContent.setCount(count);
		}

		campaignContent.setCount(campaignContent.getCount() + count);
		campaignContent.setModifiedDate(new Date());

		campaignContentPersistence.update(campaignContent);

		return campaignContent;
	}

	@Override
	public void checkCampaignContentEvents()
		throws PortalException, SystemException {

		// Process analytics from last date

		addCampaignContentsFromAnalytics(getLastCampaignContentDate());
	}

	@Override
	public CampaignContent getCampaignContent(
			long campaignId, String className, long classPK, String eventType)
		throws PortalException, SystemException {

		return campaignContentPersistence.fetchByC_C_C_E(
			campaignId, className, classPK, eventType);
	}

	@Override
	public List<CampaignContent> getCampaignContents(long campaignId)
		throws PortalException, SystemException {

		return campaignContentPersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<CampaignContent> getCampaignContents(
			long campaignId, Date modifiedDate)
		throws PortalException, SystemException {

		return campaignContentPersistence.findByC_GtD(campaignId, modifiedDate);
	}

	@Override
	public List<CampaignContent> getCampaignContents(
			long campaignId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException, SystemException {

		return campaignContentPersistence.findByCampaignId(
				campaignId, start, end, orderByComparator);
	}

	@Override
	public int getCampaignContentsCount(long campaignId)
		throws PortalException, SystemException {

		return campaignContentPersistence.countByCampaignId(campaignId);
	}

	@Override
	public Date getLastCampaignContentDate() {
		try {
			List<CampaignContent> campaignContentList =
				campaignContentPersistence.findAll(0, 1);

			if (!campaignContentList.isEmpty()) {
				CampaignContent campaignContent = campaignContentList.get(0);

				return campaignContent.getModifiedDate();
			}
			else {
				return _analyticsEventLocalService.getMaxAge();
			}
		}
		catch (Exception e) {
		}

		return null;
	}

	protected void addCampaignContentsFromAnalytics(Date date)
		throws PortalException, SystemException {

		// Retrieve analytics

		DynamicQuery dynamicQuery = _analyticsEventLocalService.dynamicQuery();

		Property referrerClassNameProperty = PropertyFactoryUtil.forName(
			"referrerClassName");

		dynamicQuery.add(
			referrerClassNameProperty.eq(Campaign.class.getName()));

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
					className, classPK, Campaign.class.getName(),
					referrerClassPK, "view", date);

			if (contentViewCount == 0) {
				continue;
			}

			addCampaignContent(
				referrerClassPK, className, classPK, "view", contentViewCount);
		}
	}

	private void _initAnalyticsEventService() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignContentLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;

}