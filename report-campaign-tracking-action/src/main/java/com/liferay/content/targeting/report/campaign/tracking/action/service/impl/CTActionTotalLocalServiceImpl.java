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
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.service.base.CTActionTotalLocalServiceBaseImpl;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Date;
import java.util.List;

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

	@Override
	public CTActionTotal addCTActionTotal(
			long reportInstanceId, String alias, String referrerClassName,
			long referrerClassPK, String eventType, int count)
		throws PortalException {

		return addCTActionTotal(
			reportInstanceId, alias, referrerClassName, referrerClassPK,
			StringPool.BLANK, eventType, count);
	}

	@Override
	public CTActionTotal addCTActionTotal(
			long reportInstanceId, String alias, String referrerClassName,
			long referrerClassPK, String elementId, String eventType, int count)
		throws PortalException {

		CTActionTotal ctActionTotal = getCTActionTotal(
			reportInstanceId, referrerClassName, referrerClassPK, elementId,
			eventType);

		if (ctActionTotal == null) {
			ReportInstance reportInstance =
				_reportInstanceLocalService.fetchReportInstance(
					reportInstanceId);

			long ctActionTotalId = counterLocalService.increment();

			ctActionTotal = ctActionTotalPersistence.create(ctActionTotalId);

			ctActionTotal.setCompanyId(reportInstance.getCompanyId());
			ctActionTotal.setCampaignId(reportInstance.getClassPK());
			ctActionTotal.setReportInstanceId(reportInstanceId);
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
			long reportInstanceId, String alias, String elementId,
			String eventType, int count)
		throws PortalException {

		return addCTActionTotal(
			reportInstanceId, alias, StringPool.BLANK, -1, elementId, eventType,
			count);
	}

	@Override
	public void checkCTActionTotalEvents() throws PortalException {
		try {
			List<ReportInstance> reportInstances =
				_reportInstanceLocalService.getReportInstances(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (ReportInstance reportInstance : reportInstances) {
				checkCTActionTotalEvents(reportInstance.getReportInstanceId());
			}
		}
		catch (NullPointerException npe) {
			if (_log.isWarnEnabled()) {
				_log.warn("Content Targeting API Services are not available");
			}
		}
	}

	@Override
	public void checkCTActionTotalEvents(long reportInstanceId)
		throws PortalException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(reportInstanceId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		List<CTActionTotal> ctActionTotals =
			ctActionTotalPersistence.findByReportInstanceId(reportInstanceId);

		for (CTActionTotal ctActionTotal : ctActionTotals) {
			if (_trackingActionInstaceLocalService.
					fetchTrackingActionInstanceByReportInstanceId(
						reportInstanceId, ctActionTotal.getAlias()) == null) {

				ctActionTotalPersistence.remove(
					ctActionTotal.getCTActionTotalId());
			}
		}

		addCTActionsTotalFromAnalyticsWithElementId(
			reportInstanceId, modifiedDate);
		addCTActionsTotalFromAnalyticsWithClassName(
			reportInstanceId, modifiedDate);
	}

	@Override
	public List<CTActionTotal> getCTActionsTotal(long reportInstanceId)
		throws PortalException {

		return ctActionTotalPersistence.findByReportInstanceId(
			reportInstanceId);
	}

	@Override
	public List<CTActionTotal> getCTActionsTotal(
			long reportInstanceId, Date modifiedDate)
		throws PortalException {

		return ctActionTotalPersistence.findByR_GtD(
			reportInstanceId, modifiedDate);
	}

	@Override
	public List<CTActionTotal> getCTActionsTotal(
			long reportInstanceId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException {

		return ctActionTotalPersistence.findByReportInstanceId(
			reportInstanceId, start, end, orderByComparator);
	}

	@Override
	public int getCTActionsTotalCount(long reportInstanceId)
		throws PortalException {

		return ctActionTotalPersistence.countByReportInstanceId(
			reportInstanceId);
	}

	@Override
	public CTActionTotal getCTActionTotal(
			long reportInstanceId, String referrerClassName,
			long referrerClassPK, String elementId, String eventType)
		throws PortalException {

		return ctActionTotalPersistence.fetchByR_R_R_E_E(
			reportInstanceId, referrerClassName, referrerClassPK, elementId,
			eventType);
	}

	protected void addCTActionsTotalFromAnalyticsWithClassName(
			long reportInstanceId, Date date)
		throws PortalException {

		List<Object[]> ctActionTotalAnalyticsList =
			ctActionTotalFinder.findByAnalyticsWithClassName(date);

		for (Object[] ctActionTotalAnalytics : ctActionTotalAnalyticsList) {
			String className = (String)ctActionTotalAnalytics[0];
			long classPK = (Long)ctActionTotalAnalytics[1];
			String eventType = (String)ctActionTotalAnalytics[2];
			int count = (Integer)ctActionTotalAnalytics[3];

			List<TrackingActionInstance> trackingActionInstances =
				_trackingActionInstaceLocalService.
					getTrackingActionInstancesByReportInstanceId(
						reportInstanceId, className, classPK, eventType);

			if (trackingActionInstances.isEmpty()) {
				trackingActionInstances =
					_trackingActionInstaceLocalService.
						getTrackingActionInstancesByReportInstanceId(
							reportInstanceId, className, classPK, "all");

				if (trackingActionInstances.isEmpty()) {
					continue;
				}
			}

			TrackingActionInstance trackingActionInstance =
				trackingActionInstances.get(0);

			addCTActionTotal(
				reportInstanceId, trackingActionInstance.getAlias(), className,
				classPK, eventType, count);
		}
	}

	protected void addCTActionsTotalFromAnalyticsWithElementId(
			long reportInstanceId, Date date)
		throws PortalException {

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
				_trackingActionInstaceLocalService.
					getTrackingActionInstancesByReportInstanceId(
						reportInstanceId, elementId, eventType);

			if (trackingActionInstances.isEmpty()) {
				trackingActionInstances =
					_trackingActionInstaceLocalService.
						getTrackingActionInstancesByReportInstanceId(
							reportInstanceId, elementId, "all");

				if (trackingActionInstances.isEmpty()) {
					continue;
				}
			}

			TrackingActionInstance trackingActionInstance =
				trackingActionInstances.get(0);

			addCTActionTotal(
				reportInstanceId, trackingActionInstance.getAlias(), elementId,
				eventType, count);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CTActionTotalLocalServiceImpl.class);

	@ServiceReference(type = AnalyticsEventLocalService.class)
	private AnalyticsEventLocalService _analyticsEventLocalService;

	@ServiceReference(type = ReportInstanceLocalService.class)
	private ReportInstanceLocalService _reportInstanceLocalService;

	@ServiceReference(type = TrackingActionInstanceLocalService.class)
	private TrackingActionInstanceLocalService
		_trackingActionInstaceLocalService;

}