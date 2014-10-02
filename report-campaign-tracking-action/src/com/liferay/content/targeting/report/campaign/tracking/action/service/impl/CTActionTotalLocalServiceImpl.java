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
import com.liferay.content.targeting.report.campaign.tracking.action.CTActionReport;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.service.base.CTActionTotalLocalServiceBaseImpl;
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
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.base.CTActionTotalLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalServiceUtil
 */
public class CTActionTotalLocalServiceImpl
	extends CTActionTotalLocalServiceBaseImpl {

	public CTActionTotalLocalServiceImpl() {
		_initServices();
	}

	@Override
	public CTActionTotal addCTActionTotal(
			long campaignId, String alias, String referrerClassName,
			long referrerClassPK, String eventType, int count)
		throws PortalException, SystemException {

		return addCTActionTotal(
			campaignId, alias, referrerClassName, referrerClassPK,
			StringPool.BLANK, eventType, count);
	}

	@Override
	public CTActionTotal addCTActionTotal(
			long campaignId, String alias, String referrerClassName,
			long referrerClassPK, String elementId, String eventType, int count)
		throws PortalException, SystemException {

		CTActionTotal ctActionTotal = getCTActionTotal(
			campaignId, referrerClassName, referrerClassPK, elementId,
			eventType);

		if (ctActionTotal == null) {
			long ctActionTotalId = CounterLocalServiceUtil.increment();

			ctActionTotal = ctActionTotalPersistence.create(ctActionTotalId);

			ctActionTotal.setCampaignId(campaignId);
			ctActionTotal.setAlias(alias);
			ctActionTotal.setReferrerClassName(referrerClassName);
			ctActionTotal.setReferrerClassPK(referrerClassPK);
			ctActionTotal.setElementId(elementId);
			ctActionTotal.setEventType(eventType);
		}

		ctActionTotal.setCount(ctActionTotal.getCount() + count);
		ctActionTotal.setModifiedDate(new Date());

		ctActionTotalPersistence.update(ctActionTotal);

		return ctActionTotal;
	}

	@Override
	public CTActionTotal addCTActionTotal(
			long campaignId, String alias, String elementId, String eventType,
			int count)
		throws PortalException, SystemException {

		return addCTActionTotal(
			campaignId, alias, StringPool.BLANK, -1, elementId, eventType,
			count);
	}

	@Override
	public void checkCTActionTotalEvents()
		throws PortalException, SystemException {

		try {
			List<Campaign> campaigns = _campaignLocalService.getCampaigns(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			ServiceContext serviceContext = new ServiceContext();

			for (Campaign campaign : campaigns) {
				checkCTActionTotalEvents(campaign.getCampaignId());

				serviceContext.setScopeGroupId(campaign.getGroupId());

				_reportInstanceLocalService.addReportInstance(
					campaign.getUserId(), CTActionReport.class.getSimpleName(),
					Campaign.class.getName(), campaign.getCampaignId(),
					StringPool.BLANK, serviceContext);
			}
		}
		catch (NullPointerException npe) {
			_log.error("Content Targeting API Services are not available");
		}
	}

	@Override
	public void checkCTActionTotalEvents(long campaignId)
		throws PortalException, SystemException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				CTActionReport.class.getSimpleName(), Campaign.class.getName(),
				campaignId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		addCTActionsTotalFromAnalyticsWithElementId(campaignId, modifiedDate);
		addCTActionsTotalFromAnalyticsWithClassName(campaignId, modifiedDate);
	}

	@Override
	public List<CTActionTotal> getCTActionsTotal(long campaignId)
		throws PortalException, SystemException {

		return ctActionTotalPersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<CTActionTotal> getCTActionsTotal(
			long campaignId, Date modifiedDate)
		throws PortalException, SystemException {

		return ctActionTotalPersistence.findByC_GtD(campaignId, modifiedDate);
	}

	@Override
	public List<CTActionTotal> getCTActionsTotal(
			long campaignId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException, SystemException {

		return ctActionTotalPersistence.findByCampaignId(
			campaignId, start, end, orderByComparator);
	}

	@Override
	public int getCTActionsTotalCount(long campaignId)
		throws PortalException, SystemException {

		return ctActionTotalPersistence.countByCampaignId(campaignId);
	}

	@Override
	public CTActionTotal getCTActionTotal(
			long campaignId, String referrerClassName, long referrerClassPK,
			String elementId, String eventType)
		throws PortalException, SystemException {

		return ctActionTotalPersistence.fetchByC_R_R_E_E(
			campaignId, referrerClassName, referrerClassPK, elementId,
			eventType);
	}

	protected void addCTActionsTotalFromAnalyticsWithClassName(
			long campaignId, Date date)
		throws PortalException, SystemException {

		List<Object[]> ctActionTotalAnalyticsList =
			ctActionTotalFinder.findByAnalyticsWithClassName(date);

		for (Object[] ctActionTotalAnalytics : ctActionTotalAnalyticsList) {
			String className = (String)ctActionTotalAnalytics[0];
			long classPK = (Long)ctActionTotalAnalytics[1];
			String eventType = (String)ctActionTotalAnalytics[2];
			int count = (Integer)ctActionTotalAnalytics[3];

			List<TrackingActionInstance> trackingActionInstances =
				_trackingActionInstaceLocalService.getTrackingActionInstances(
					campaignId, className, classPK, eventType);

			if (trackingActionInstances.isEmpty()) {
				continue;
			}

			TrackingActionInstance trackingActionInstance =
				trackingActionInstances.get(0);

			addCTActionTotal(
				campaignId, trackingActionInstance.getAlias(), className,
				classPK, eventType, count);
		}
	}

	protected void addCTActionsTotalFromAnalyticsWithElementId(
			long campaignId, Date date)
		throws PortalException, SystemException {

		if (date == null) {
			date = _analyticsEventLocalService.getMaxAge();
		}

		List<Object[]> ctActionTotalAnalyticsList =
			ctActionTotalFinder.findByAnalyticsWithElementId(date);

		for (Object[] ctActionTotalAnalytics : ctActionTotalAnalyticsList) {
			String elementId = (String)ctActionTotalAnalytics[0];
			String eventType = (String)ctActionTotalAnalytics[1];
			int count = (Integer)ctActionTotalAnalytics[2];

			List<TrackingActionInstance> trackingActionInstances =
				_trackingActionInstaceLocalService.getTrackingActionInstances(
					campaignId, elementId, eventType);

			if (trackingActionInstances.isEmpty()) {
				continue;
			}

			TrackingActionInstance trackingActionInstance =
				trackingActionInstances.get(0);

			addCTActionTotal(
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
		CTActionTotalLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;
	private TrackingActionInstanceLocalService
		_trackingActionInstaceLocalService;

}