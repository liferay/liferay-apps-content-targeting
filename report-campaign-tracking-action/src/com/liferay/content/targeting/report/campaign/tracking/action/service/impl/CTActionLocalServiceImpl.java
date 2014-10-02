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
import com.liferay.content.targeting.report.campaign.tracking.action.CTActionReport;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.base.CTActionLocalServiceBaseImpl;
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
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.base.CTActionLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalServiceUtil
 */
public class CTActionLocalServiceImpl extends CTActionLocalServiceBaseImpl {

	public CTActionLocalServiceImpl() {
		_initServices();
	}

	@Override
	public CTAction addCTAction(
			long campaignId, long userSegmentId, String alias,
			String referrerClassName, long referrerClassPK, String eventType,
			int count)
		throws PortalException, SystemException {

		return addCTAction(
			campaignId, userSegmentId, alias, referrerClassName,
			referrerClassPK, StringPool.BLANK, eventType, count);
	}

	@Override
	public CTAction addCTAction(
			long campaignId, long userSegmentId, String alias,
			String referrerClassName, long referrerClassPK, String elementId,
			String eventType, int count)
		throws PortalException, SystemException {

		CTAction ctAction = getCTAction(
			campaignId, userSegmentId, referrerClassName, referrerClassPK,
			elementId, eventType);

		if (ctAction == null) {
			long ctActionId = CounterLocalServiceUtil.increment();

			ctAction = ctActionPersistence.create(ctActionId);

			ctAction.setCampaignId(campaignId);
			ctAction.setUserSegmentId(userSegmentId);
			ctAction.setAlias(alias);
			ctAction.setReferrerClassName(referrerClassName);
			ctAction.setReferrerClassPK(referrerClassPK);
			ctAction.setElementId(elementId);
			ctAction.setEventType(eventType);
		}

		ctAction.setCount(ctAction.getCount() + count);
		ctAction.setModifiedDate(new Date());

		ctActionPersistence.update(ctAction);

		return ctAction;
	}

	@Override
	public CTAction addCTAction(
			long campaignId, long userSegmentId, String alias, String elementId,
			String eventType, int count)
		throws PortalException, SystemException {

		return addCTAction(
			campaignId, userSegmentId, alias, StringPool.BLANK, -1, elementId,
			eventType, count);
	}

	@Override
	public void checkCTActionEvents() throws PortalException, SystemException {
		try {
			List<Campaign> campaigns = _campaignLocalService.getCampaigns(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			ServiceContext serviceContext = new ServiceContext();

			for (Campaign campaign : campaigns) {
				checkCTActionEvents(campaign.getCampaignId());

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
	public void checkCTActionEvents(long campaignId)
		throws PortalException, SystemException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				CTActionReport.class.getSimpleName(), Campaign.class.getName(),
				campaignId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		addCTActionsFromAnalyticsWithElementId(campaignId, modifiedDate);
		addCTActionsFromAnalyticsWithClassName(campaignId, modifiedDate);
	}

	@Override
	public CTAction getCTAction(
			long campaignId, long userSegmentId, String referrerClassName,
			long referrerClassPK, String elementId, String eventType)
		throws PortalException, SystemException {

		return ctActionPersistence.fetchByC_U_R_R_E_E(
			campaignId, userSegmentId, referrerClassName, referrerClassPK,
			elementId, eventType);
	}

	@Override
	public List<CTAction> getCTActions(long campaignId)
		throws PortalException, SystemException {

		return ctActionPersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<CTAction> getCTActions(long campaignId, Date modifiedDate)
		throws PortalException, SystemException {

		return ctActionPersistence.findByC_GtD(campaignId, modifiedDate);
	}

	@Override
	public List<CTAction> getCTActions(
			long campaignId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException, SystemException {

		return ctActionPersistence.findByCampaignId(
			campaignId, start, end, orderByComparator);
	}

	@Override
	public List<CTAction> getCTActions(long campaignId, String elementId)
		throws PortalException, SystemException {

		return ctActionPersistence.findByC_E(campaignId, elementId);
	}

	@Override
	public List<CTAction> getCTActions(
			long campaignId, String className, long classPK)
		throws PortalException, SystemException {

		return ctActionPersistence.findByC_R_R(campaignId, className, classPK);
	}

	@Override
	public int getCTActionsCount(long campaignId)
		throws PortalException, SystemException {

		return ctActionPersistence.countByCampaignId(campaignId);
	}

	protected void addCTActionsFromAnalyticsWithClassName(
			long campaignId, Date date)
		throws PortalException, SystemException {

		List<Object[]> ctActionAnalyticsList =
			ctActionFinder.findByAnalyticsWithClassName(campaignId, date);

		for (Object[] ctActionAnalytics : ctActionAnalyticsList) {
			long userSegmentId = (Long)ctActionAnalytics[0];
			String className = (String)ctActionAnalytics[1];
			long classPK = (Long)ctActionAnalytics[2];
			String eventType = (String)ctActionAnalytics[3];
			String alias = (String)ctActionAnalytics[4];

			int count = _analyticsEventLocalService.getAnalyticsEventsCount(
				className, classPK, UserSegment.class.getName(), userSegmentId,
				eventType, date);

			if (count == 0) {
				continue;
			}

			addCTAction(
				campaignId, userSegmentId, alias, className, classPK, eventType,
				count);
		}
	}

	protected void addCTActionsFromAnalyticsWithElementId(
			long campaignId, Date date)
		throws PortalException, SystemException {

		if (date == null) {
			date = _analyticsEventLocalService.getMaxAge();
		}

		List<Object[]> ctActionAnalyticsList =
			ctActionFinder.findByAnalyticsWithElementId(campaignId, date);

		for (Object[] ctActionAnalytics : ctActionAnalyticsList) {
			long userSegmentId = (Long)ctActionAnalytics[0];
			String elementId = (String)ctActionAnalytics[1];
			String eventType = (String)ctActionAnalytics[2];
			String alias = (String)ctActionAnalytics[3];

			int count = _analyticsEventLocalService.getAnalyticsEventsCount(
				UserSegment.class.getName(), userSegmentId, elementId,
				eventType, date);

			if (count == 0) {
				continue;
			}

			addCTAction(
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
		CTActionLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;

}