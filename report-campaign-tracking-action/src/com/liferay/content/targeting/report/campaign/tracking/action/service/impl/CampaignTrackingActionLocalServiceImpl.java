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
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.campaign.tracking.action.CampaignTrackingActionReport;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.base.CampaignTrackingActionLocalServiceBaseImpl;
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
 * The implementation of the campaign tracking action local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.tracking.action.service.CampaignTrackingActionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.base.CampaignTrackingActionLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.CampaignTrackingActionLocalServiceUtil
 */
public class CampaignTrackingActionLocalServiceImpl
	extends CampaignTrackingActionLocalServiceBaseImpl {

	public CampaignTrackingActionLocalServiceImpl() {
		_initServices();
	}

	@Override
	public CampaignTrackingAction addCampaignTrackingAction(
			long campaignId, long userSegmentId, String alias,
			String referrerClassName, long referrerClassPK, String eventType,
			int count)
		throws PortalException, SystemException {

		return addCampaignTrackingAction(
			campaignId, userSegmentId, alias, referrerClassName,
			referrerClassPK, StringPool.BLANK, eventType, count);
	}

	@Override
	public CampaignTrackingAction addCampaignTrackingAction(
			long campaignId, long userSegmentId, String alias,
			String referrerClassName, long referrerClassPK, String elementId,
			String eventType, int count)
		throws PortalException, SystemException {

		CampaignTrackingAction campaignTrackingAction =
			getCampaignTrackingAction(
				campaignId, userSegmentId, referrerClassName, referrerClassPK,
				elementId, eventType);

		if (campaignTrackingAction == null) {
			long campaignTrackingActionId = CounterLocalServiceUtil.increment();

			campaignTrackingAction =
				campaignTrackingActionPersistence.create(
					campaignTrackingActionId);

			campaignTrackingAction.setCampaignId(campaignId);
			campaignTrackingAction.setUserSegmentId(userSegmentId);
			campaignTrackingAction.setAlias(alias);
			campaignTrackingAction.setReferrerClassName(referrerClassName);
			campaignTrackingAction.setReferrerClassPK(referrerClassPK);
			campaignTrackingAction.setElementId(elementId);
			campaignTrackingAction.setEventType(eventType);
		}

		campaignTrackingAction.setCount(
			campaignTrackingAction.getCount() + count);
		campaignTrackingAction.setModifiedDate(new Date());

		campaignTrackingActionPersistence.update(campaignTrackingAction);

		return campaignTrackingAction;
	}

	@Override
	public CampaignTrackingAction addCampaignTrackingAction(
			long campaignId, long userSegmentId, String alias, String elementId,
			String eventType, int count)
		throws PortalException, SystemException {

		return addCampaignTrackingAction(
			campaignId, userSegmentId, alias, StringPool.BLANK, -1, elementId,
			eventType, count);
	}

	@Override
	public void checkCampaignTrackingActionEvents()
		throws PortalException, SystemException {

		try {
			List<Campaign> campaigns = _campaignLocalService.getCampaigns(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			ServiceContext serviceContext = new ServiceContext();

			for (Campaign campaign : campaigns) {
				checkCampaignTrackingActionEvents(campaign.getCampaignId());

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
	public void checkCampaignTrackingActionEvents(long campaignId)
		throws PortalException, SystemException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				CampaignTrackingActionReport.class.getSimpleName(),
				Campaign.class.getName(), campaignId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		addCampaignTrackingActionsFromAnalyticsWithElementId(
			campaignId, modifiedDate);
		addCampaignTrackingActionsFromAnalyticsWithClassName(
			campaignId, modifiedDate);
	}

	@Override
	public CampaignTrackingAction getCampaignTrackingAction(
			long campaignId, long userSegmentId, String referrerClassName,
			long referrerClassPK, String elementId, String eventType)
		throws PortalException, SystemException {

		return campaignTrackingActionPersistence.fetchByC_U_R_R_E_E(
			campaignId, userSegmentId, referrerClassName, referrerClassPK,
			elementId, eventType);
	}

	@Override
	public List<CampaignTrackingAction> getCampaignTrackingActions(
			long campaignId)
		throws PortalException, SystemException {

		return campaignTrackingActionPersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<CampaignTrackingAction> getCampaignTrackingActions(
			long campaignId, Date modifiedDate)
		throws PortalException, SystemException {

		return campaignTrackingActionPersistence.findByC_GtD(
			campaignId, modifiedDate);
	}

	@Override
	public List<CampaignTrackingAction> getCampaignTrackingActions(
			long campaignId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException, SystemException {

		return campaignTrackingActionPersistence.findByCampaignId(
			campaignId, start, end, orderByComparator);
	}

	@Override
	public int getCampaignTrackingActionsCount(long campaignId)
		throws PortalException, SystemException {

		return campaignTrackingActionPersistence.countByCampaignId(campaignId);
	}

	protected void addCampaignTrackingActionsFromAnalyticsWithClassName(
			long campaignId, Date date)
		throws PortalException, SystemException {

		List<Object[]> campaignTrackingActionAnalyticsList =
			campaignTrackingActionFinder.findByAnalyticsWithClassName(
				campaignId, date);

		for (Object[] campaignTrackingActionAnalytics :
				campaignTrackingActionAnalyticsList) {

			long userSegmentId = (Long)campaignTrackingActionAnalytics[0];
			String className = (String)campaignTrackingActionAnalytics[1];
			long classPK = (Long)campaignTrackingActionAnalytics[2];
			String eventType = (String)campaignTrackingActionAnalytics[3];
			String alias = (String)campaignTrackingActionAnalytics[4];

			int count = _analyticsEventLocalService.getAnalyticsEventsCount(
				className, classPK, UserSegment.class.getName(), userSegmentId,
				eventType, date);

			if (count == 0) {
				continue;
			}

			addCampaignTrackingAction(
				campaignId, userSegmentId, alias, className, classPK, eventType,
				count);
		}
	}

	protected void addCampaignTrackingActionsFromAnalyticsWithElementId(
			long campaignId, Date date)
		throws PortalException, SystemException {

		if (date == null) {
			date = _analyticsEventLocalService.getMaxAge();
		}

		List<Object[]> campaignTrackingActionAnalyticsList =
			campaignTrackingActionFinder.findByAnalyticsWithElementId(
				campaignId, date);

		for (Object[] campaignTrackingActionAnalytics :
				campaignTrackingActionAnalyticsList) {

			long userSegmentId = (Long)campaignTrackingActionAnalytics[0];
			String elementId = (String)campaignTrackingActionAnalytics[1];
			String eventType = (String)campaignTrackingActionAnalytics[2];
			String alias = (String)campaignTrackingActionAnalytics[3];

			int count = _analyticsEventLocalService.getAnalyticsEventsCount(
				UserSegment.class.getName(), userSegmentId, elementId,
				eventType, date);

			if (count == 0) {
				continue;
			}

			addCampaignTrackingAction(
				campaignId, userSegmentId, alias, elementId, eventType, count);
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
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignTrackingActionLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;

}