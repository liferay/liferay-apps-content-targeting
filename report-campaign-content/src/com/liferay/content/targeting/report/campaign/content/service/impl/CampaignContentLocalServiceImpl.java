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

package com.liferay.content.targeting.report.campaign.content.service.impl;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalService;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.report.campaign.content.CampaignContentReport;
import com.liferay.content.targeting.report.campaign.content.model.CampaignContent;
import com.liferay.content.targeting.report.campaign.content.service.base.CampaignContentLocalServiceBaseImpl;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the campaign content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.content.service.CampaignContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.content.service.base.CampaignContentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.content.service.CampaignContentLocalServiceUtil
 */
public class CampaignContentLocalServiceImpl
	extends CampaignContentLocalServiceBaseImpl {

	public CampaignContentLocalServiceImpl() {
		_initServices();
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

		try {
			List<Campaign> campaigns = _campaignLocalService.getCampaigns(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			ServiceContext serviceContext = new ServiceContext();

			for (Campaign campaign : campaigns) {
				checkCampaignContentEvents(campaign.getCampaignId());

				serviceContext.setScopeGroupId(campaign.getGroupId());

				_reportInstanceLocalService.addReportInstance(
					campaign.getUserId(),
					CampaignContentReport.class.getSimpleName(),
					Campaign.class.getName(), campaign.getCampaignId(),
					StringPool.BLANK, serviceContext);
			}
		}
		catch (NullPointerException npe) {
			_log.error("Content Targeting API Services are not available");
		}
	}

	@Override
	public void checkCampaignContentEvents(long campaignId)
		throws PortalException, SystemException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				CampaignContentReport.class.getSimpleName(),
				Campaign.class.getName(), campaignId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		addCampaignContentsFromAnalytics(campaignId, modifiedDate);
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

	protected void addCampaignContentsFromAnalytics(long campaignId, Date date)
		throws PortalException, SystemException {

		Campaign campaign = _campaignLocalService.getCampaign(campaignId);

		List<Object[]> analyticsEvents =
			_analyticsEventLocalService.getAnalyticsEvents(
				campaign.getCompanyId(), Campaign.class.getName(), campaignId,
				date);

		// Process analytics and store data

		for (Object[] analyticsEvent : analyticsEvents) {
			String referrerClassName = (String)analyticsEvent[1];
			long referrerClassPK = (Long)analyticsEvent[1];
			int count = (Integer)analyticsEvent[2];

			addCampaignContent(
				campaignId, referrerClassName, referrerClassPK, "view", count);
		}
	}

	private void _initServices() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, bundle.getBundleContext());
		_analyticsReferrerLocalService = ServiceTrackerUtil.getService(
			AnalyticsReferrerLocalService.class, bundle.getBundleContext());
		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, bundle.getBundleContext());
		_reportInstanceLocalService = ServiceTrackerUtil.getService(
			ReportInstanceLocalService.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignContentLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private AnalyticsReferrerLocalService _analyticsReferrerLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;

}