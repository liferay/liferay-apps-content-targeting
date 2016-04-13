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
import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.content.targeting.api.model.TrackingActionsRegistry;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.base.CTActionLocalServiceBaseImpl;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Date;
import java.util.List;

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

	@Override
	public CTAction addCTAction(
			long reportInstanceId, long userSegmentId, String alias,
			long referrerClassNameId, long referrerClassPK, String eventType,
			int count)
		throws PortalException {

		return addCTAction(
			reportInstanceId, userSegmentId, alias, referrerClassNameId,
			referrerClassPK, StringPool.BLANK, eventType, count);
	}

	@Override
	public CTAction addCTAction(
			long reportInstanceId, long userSegmentId, String alias,
			long referrerClassNameId, long referrerClassPK, String elementId,
			String eventType, int count)
		throws PortalException {

		CTAction ctAction = getCTAction(
			reportInstanceId, userSegmentId, referrerClassNameId,
			referrerClassPK, elementId, eventType);

		if (ctAction == null) {
			ReportInstance reportInstance =
				_reportInstanceLocalService.fetchReportInstance(
					reportInstanceId);

			long ctActionId = counterLocalService.increment();

			ctAction = ctActionPersistence.create(ctActionId);

			ctAction.setCompanyId(reportInstance.getCompanyId());
			ctAction.setCampaignId(reportInstance.getClassPK());
			ctAction.setReportInstanceId(reportInstanceId);
			ctAction.setUserSegmentId(userSegmentId);
			ctAction.setAlias(alias);
			ctAction.setReferrerClassNameId(referrerClassNameId);
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
			long reportInstanceId, long userSegmentId, String alias,
			String elementId, String eventType, int count)
		throws PortalException {

		return addCTAction(
			reportInstanceId, userSegmentId, alias, -1, -1, elementId,
			eventType, count);
	}

	@Override
	public void checkCTActionEvents() throws PortalException {
		List<ReportInstance> reportInstances =
			_reportInstanceLocalService.getReportInstances(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ReportInstance reportInstance : reportInstances) {
			checkCTActionEvents(reportInstance.getReportInstanceId());
		}
	}

	@Override
	public void checkCTActionEvents(long reportInstanceId)
		throws PortalException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(reportInstanceId);

		Date reportInstanceModifiedDate = reportInstance.getModifiedDate();

		if ((reportInstance != null) &&
			reportInstanceModifiedDate.after(reportInstance.getCreateDate())) {

			modifiedDate = reportInstanceModifiedDate;
		}

		List<CTAction> ctActions = ctActionPersistence.findByReportInstanceId(
			reportInstanceId);

		for (CTAction ctAction : ctActions) {
			if (_trackingActionInstaceLocalService.
					fetchTrackingActionInstanceByReportInstanceId(
						reportInstanceId, ctAction.getAlias()) == null) {

				ctActionPersistence.remove(ctAction.getCTActionId());
			}
		}

		addCTActionsFromAnalyticsWithElementId(reportInstanceId, modifiedDate);
		addCTActionsFromAnalyticsWithClassNameId(
			reportInstanceId, modifiedDate);
	}

	@Override
	public CTAction getCTAction(
			long reportInstanceId, long userSegmentId, long referrerClassNameId,
			long referrerClassPK, String elementId, String eventType)
		throws PortalException {

		return ctActionPersistence.fetchByR_U_R_R_E_E(
			reportInstanceId, userSegmentId, referrerClassNameId,
			referrerClassPK, elementId, eventType);
	}

	@Override
	public List<CTAction> getCTActions(long reportInstanceId)
		throws PortalException {

		return ctActionPersistence.findByReportInstanceId(reportInstanceId);
	}

	@Override
	public List<CTAction> getCTActions(long reportInstanceId, Date modifiedDate)
		throws PortalException {

		return ctActionPersistence.findByR_GtD(reportInstanceId, modifiedDate);
	}

	@Override
	public List<CTAction> getCTActions(
			long reportInstanceId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException {

		return ctActionPersistence.findByReportInstanceId(
			reportInstanceId, start, end, orderByComparator);
	}

	@Override
	public List<CTAction> getCTActions(
			long reportInstanceId, long classNameId, long classPK)
		throws PortalException {

		return ctActionPersistence.findByR_R_R(
			reportInstanceId, classNameId, classPK);
	}

	@Override
	public List<CTAction> getCTActions(long reportInstanceId, String elementId)
		throws PortalException {

		return ctActionPersistence.findByR_E(reportInstanceId, elementId);
	}

	@Override
	public int getCTActionsCount(long reportInstanceId) throws PortalException {
		return ctActionPersistence.countByReportInstanceId(reportInstanceId);
	}

	protected void addCTActionsFromAnalyticsWithClassNameId(
			long reportInstanceId, Date date)
		throws PortalException {

		List<Object[]> ctActionAnalyticsList =
			ctActionFinder.findByAnalyticsWithClassNameId
				(reportInstanceId, date);

		for (Object[] ctActionAnalytics : ctActionAnalyticsList) {
			long userSegmentId = (Long)ctActionAnalytics[0];
			long classNameId = (Long)ctActionAnalytics[1];
			long classPK = (Long)ctActionAnalytics[2];
			String eventType = (String)ctActionAnalytics[3];
			String alias = (String)ctActionAnalytics[4];
			long campaignId = (Long)ctActionAnalytics[5];

			String className = PortalUtil.getClassName(classNameId);

			if (StringUtil.equalsIgnoreCase("all", eventType)) {
				TrackingActionInstance trackingActionInstance =
					_trackingActionInstaceLocalService.
						fetchTrackingActionInstance(campaignId, alias);

				if (trackingActionInstance == null) {
					continue;
				}

				TrackingAction trackingAction =
					_trackingActionsRegistry.getTrackingAction(
						trackingActionInstance.getTrackingActionKey());

				for (String trackingActionEventType
						: trackingAction.getEventTypes()) {

					int count =
						_analyticsEventLocalService.getAnalyticsEventsCount(
							className, classPK, UserSegment.class.getName(),
							userSegmentId, trackingActionEventType, date);

					if (count == 0) {
						continue;
					}

					addCTAction(
						reportInstanceId, userSegmentId, alias, classNameId,
						classPK, trackingActionEventType, count);
				}
			}
			else {
				int count = _analyticsEventLocalService.getAnalyticsEventsCount(
					className, classPK, UserSegment.class.getName(),
					userSegmentId, eventType, date);

				if (count == 0) {
					continue;
				}

				addCTAction(
					reportInstanceId, userSegmentId, alias, classNameId,
					classPK, eventType, count);
			}
		}
	}

	protected void addCTActionsFromAnalyticsWithElementId(
			long reportInstanceId, Date date)
		throws PortalException {

		if (date == null) {
			date = _analyticsEventLocalService.getMaxAge();
		}

		List<Object[]> ctActionAnalyticsList =
			ctActionFinder.findByAnalyticsWithElementId(reportInstanceId, date);

		for (Object[] ctActionAnalytics : ctActionAnalyticsList) {
			long userSegmentId = (Long)ctActionAnalytics[0];
			String elementId = (String)ctActionAnalytics[1];
			String eventType = (String)ctActionAnalytics[2];
			String alias = (String)ctActionAnalytics[3];
			long campaignId = (Long)ctActionAnalytics[4];

			if (StringUtil.equalsIgnoreCase("all", eventType)) {
				TrackingActionInstance trackingActionInstance =
					_trackingActionInstaceLocalService.
						fetchTrackingActionInstance(campaignId, alias);

				if (trackingActionInstance == null) {
					continue;
				}

				TrackingAction trackingAction =
					_trackingActionsRegistry.getTrackingAction(
						trackingActionInstance.getTrackingActionKey());

				for (String trackingActionEventType
						: trackingAction.getEventTypes()) {

					int count =
						_analyticsEventLocalService.getAnalyticsEventsCount(
							UserSegment.class.getName(), userSegmentId,
							elementId, trackingActionEventType, date);

					if (count == 0) {
						continue;
					}

					addCTAction(
						reportInstanceId, userSegmentId, alias, elementId,
						trackingActionEventType, count);
				}
			}
			else {
				int count = _analyticsEventLocalService.getAnalyticsEventsCount(
					UserSegment.class.getName(), userSegmentId, elementId,
					eventType, date);

				if (count == 0) {
					continue;
				}

				addCTAction(
					reportInstanceId, userSegmentId, alias, elementId,
					eventType, count);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CTActionLocalServiceImpl.class);

	@ServiceReference(type = AnalyticsEventLocalService.class)
	private AnalyticsEventLocalService _analyticsEventLocalService;

	@ServiceReference(type = ReportInstanceLocalService.class)
	private ReportInstanceLocalService _reportInstanceLocalService;

	@ServiceReference(type = TrackingActionInstanceLocalService.class)
	private TrackingActionInstanceLocalService
		_trackingActionInstaceLocalService;

	@ServiceReference(type = TrackingActionsRegistry.class)
	private TrackingActionsRegistry _trackingActionsRegistry;

}