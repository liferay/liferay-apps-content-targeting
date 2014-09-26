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

package com.liferay.content.targeting.report.campaign.tracking.action.service.impl;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.report.campaign.tracking.action.CampaignTrackingActionReport;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.service.base.CampaignTrackingActionTotalLocalServiceBaseImpl;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
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
 * The implementation of the campaign tracking action total local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.tracking.action.service.CampaignTrackingActionTotalLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.base.CampaignTrackingActionTotalLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.CampaignTrackingActionTotalLocalServiceUtil
 */
public class CampaignTrackingActionTotalLocalServiceImpl
	extends CampaignTrackingActionTotalLocalServiceBaseImpl {

	public CampaignTrackingActionTotalLocalServiceImpl() {
		_initServices();
	}

	@Override
	public CampaignTrackingActionTotal addCampaignTrackingActionTotal(
			long campaignId, String alias, String referrerClassName,
			long referrerClassPK, String eventType, int count)
		throws PortalException, SystemException {

		return addCampaignTrackingActionTotal(
			campaignId, alias, referrerClassName, referrerClassPK,
			StringPool.BLANK, eventType, count);
	}

	@Override
	public CampaignTrackingActionTotal addCampaignTrackingActionTotal(
			long campaignId, String alias, String referrerClassName,
			long referrerClassPK, String elementId, String eventType, int count)
		throws PortalException, SystemException {

		CampaignTrackingActionTotal campaignTrackingActionTotal =
			getCampaignTrackingActionTotal(
				campaignId, referrerClassName, referrerClassPK, elementId,
				eventType);

		if (campaignTrackingActionTotal == null) {
			long campaignTrackingActionTotalId =
				CounterLocalServiceUtil.increment();

			campaignTrackingActionTotal =
				campaignTrackingActionTotalPersistence.create(
					campaignTrackingActionTotalId);

			campaignTrackingActionTotal.setCampaignId(campaignId);
			campaignTrackingActionTotal.setAlias(alias);
			campaignTrackingActionTotal.setReferrerClassName(referrerClassName);
			campaignTrackingActionTotal.setReferrerClassPK(referrerClassPK);
			campaignTrackingActionTotal.setElementId(elementId);
			campaignTrackingActionTotal.setEventType(eventType);
		}

		campaignTrackingActionTotal.setCount(
			campaignTrackingActionTotal.getCount() + count);
		campaignTrackingActionTotal.setModifiedDate(new Date());

		campaignTrackingActionTotalPersistence.update(
			campaignTrackingActionTotal);

		return campaignTrackingActionTotal;
	}

	@Override
	public CampaignTrackingActionTotal addCampaignTrackingActionTotal(
			long campaignId, String alias, String elementId, String eventType,
			int count)
		throws PortalException, SystemException {

		return addCampaignTrackingActionTotal(
			campaignId, alias, StringPool.BLANK, -1, elementId, eventType,
			count);
	}

	@Override
	public void checkCampaignTrackingActionTotalEvents()
		throws PortalException, SystemException {

		try {
			List<Campaign> campaigns = _campaignLocalService.getCampaigns(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			ServiceContext serviceContext = new ServiceContext();

			for (Campaign campaign : campaigns) {
				checkCampaignTrackingActionTotalEvents(
					campaign.getCampaignId());

				serviceContext.setScopeGroupId(campaign.getGroupId());

				_reportInstanceLocalService.addReportInstance(
					campaign.getUserId(),
					CampaignTrackingActionReport.class.getSimpleName(),
					Campaign.class.getName(), campaign.getCampaignId(),
					StringPool.BLANK, serviceContext);
			}
		}
		catch (NullPointerException npe) {
			_log.error("Content Targeting API Services are not available");
		}
	}

	@Override
	public void checkCampaignTrackingActionTotalEvents(long campaignId)
		throws PortalException, SystemException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				CampaignTrackingActionReport.class.getSimpleName(),
				Campaign.class.getName(), campaignId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		addCampaignTrackingActionsTotalFromAnalyticsWithElementId(
			campaignId, modifiedDate);
		addCampaignTrackingActionsTotalFromAnalyticsWithClassName(
			campaignId, modifiedDate);
	}

	@Override
	public List<CampaignTrackingActionTotal> getCampaignTrackingActionsTotal(
			long campaignId)
		throws PortalException, SystemException {

		return campaignTrackingActionTotalPersistence.findByCampaignId(
			campaignId);
	}

	@Override
	public List<CampaignTrackingActionTotal> getCampaignTrackingActionsTotal(
			long campaignId, Date modifiedDate)
		throws PortalException, SystemException {

		return campaignTrackingActionTotalPersistence.findByC_GtD(
			campaignId, modifiedDate);
	}

	@Override
	public List<CampaignTrackingActionTotal> getCampaignTrackingActionsTotal(
			long campaignId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException, SystemException {

		return campaignTrackingActionTotalPersistence.findByCampaignId(
			campaignId, start, end, orderByComparator);
	}

	@Override
	public int getCampaignTrackingActionsTotalCount(long campaignId)
		throws PortalException, SystemException {

		return campaignTrackingActionTotalPersistence.countByCampaignId(
			campaignId);
	}

	@Override
	public CampaignTrackingActionTotal getCampaignTrackingActionTotal(
			long campaignId, String referrerClassName, long referrerClassPK,
			String elementId, String eventType)
		throws PortalException, SystemException {

		return campaignTrackingActionTotalPersistence.fetchByC_R_R_E_E(
			campaignId, referrerClassName, referrerClassPK, elementId,
			eventType);
	}

	protected void addCampaignTrackingActionsTotalFromAnalyticsWithClassName(
			long campaignId, Date date)
		throws PortalException, SystemException {

		List<Object[]> campaignTrackingActionTotalAnalyticsList =
			campaignTrackingActionTotalFinder.findByAnalyticsWithClassName(
				date);

		for (Object[] campaignTrackingActionTotalAnalytics :
				campaignTrackingActionTotalAnalyticsList) {

			String className = (String)campaignTrackingActionTotalAnalytics[0];
			long classPK = (Long)campaignTrackingActionTotalAnalytics[1];
			String eventType = (String)campaignTrackingActionTotalAnalytics[2];
			int count = (Integer)campaignTrackingActionTotalAnalytics[3];

			List<TrackingActionInstance> trackingActionInstances =
				_trackingActionInstaceLocalService.getTrackingActionInstances(
					campaignId, className, classPK, eventType);

			if (trackingActionInstances.isEmpty()) {
				continue;
			}

			TrackingActionInstance trackingActionInstance =
				trackingActionInstances.get(0);

			addCampaignTrackingActionTotal(
				campaignId, trackingActionInstance.getAlias(), className,
				classPK, eventType, count);
		}
	}

	protected void addCampaignTrackingActionsTotalFromAnalyticsWithElementId(
			long campaignId, Date date)
		throws PortalException, SystemException {

		if (date == null) {
			date = _analyticsEventLocalService.getMaxAge();
		}

		List<Object[]> campaignTrackingActionTotalAnalyticsList =
			campaignTrackingActionTotalFinder.findByAnalyticsWithElementId(
				date);

		for (Object[] campaignTrackingActionTotalAnalytics :
				campaignTrackingActionTotalAnalyticsList) {

			String elementId = (String)campaignTrackingActionTotalAnalytics[0];
			String eventType = (String)campaignTrackingActionTotalAnalytics[1];
			int count = (Integer)campaignTrackingActionTotalAnalytics[2];

			List<TrackingActionInstance> trackingActionInstances =
				_trackingActionInstaceLocalService.getTrackingActionInstances(
					campaignId, elementId, eventType);

			if (trackingActionInstances.isEmpty()) {
				continue;
			}

			TrackingActionInstance trackingActionInstance =
				trackingActionInstances.get(0);

			addCampaignTrackingActionTotal(
				campaignId, trackingActionInstance.getAlias(), elementId,
				eventType, count);
		}
	}

	private void _initServices() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, bundle.getBundleContext());
		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, bundle.getBundleContext());
		_reportInstanceLocalService = ServiceTrackerUtil.getService(
			ReportInstanceLocalService.class, bundle.getBundleContext());
		_trackingActionInstaceLocalService = ServiceTrackerUtil.getService(
			TrackingActionInstanceLocalService.class,
			bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignTrackingActionTotalLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;
	private TrackingActionInstanceLocalService
		_trackingActionInstaceLocalService;

}