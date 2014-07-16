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

package com.liferay.contenttargeting.reports.campaigntrackingaction.service.impl;

import com.liferay.analytics.service.AnalyticsEventLocalService;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.reports.campaigntrackingaction.model.CampaignTrackingAction;
import com.liferay.contenttargeting.reports.campaigntrackingaction.service.base.CampaignTrackingActionLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the campaign tracking action local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.reports.campaigntrackingaction.service.CampaignTrackingActionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.reports.campaigntrackingaction.service.base.CampaignTrackingActionLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.reports.campaigntrackingaction.service.CampaignTrackingActionLocalServiceUtil
 */
public class CampaignTrackingActionLocalServiceImpl
	extends CampaignTrackingActionLocalServiceBaseImpl {

	public CampaignTrackingActionLocalServiceImpl() {
		_initServices();
	}

	@Override
	public CampaignTrackingAction addCampaignTrackingAction(
			long campaignId, long userSegmentId, String alias, long plid,
			String elementId, String eventType, int count)
		throws PortalException, SystemException {

		CampaignTrackingAction campaignTrackingAction =
			getCampaignTrackingAction(
				campaignId, userSegmentId, plid, elementId, eventType);

		if (campaignTrackingAction == null) {
			long campaignTrackingActionId = CounterLocalServiceUtil.increment();

			campaignTrackingAction =
				campaignTrackingActionPersistence.create(
					campaignTrackingActionId);

			campaignTrackingAction.setCampaignId(campaignId);
			campaignTrackingAction.setUserSegmentId(userSegmentId);
			campaignTrackingAction.setAlias(alias);
			campaignTrackingAction.setPlid(plid);
			campaignTrackingAction.setElementId(elementId);
			campaignTrackingAction.setEventType(eventType);
			campaignTrackingAction.setCount(count);
		}

		campaignTrackingAction.setCount(
			campaignTrackingAction.getCount() + count);
		campaignTrackingAction.setModifiedDate(new Date());

		campaignTrackingActionPersistence.update(campaignTrackingAction);

		return campaignTrackingAction;
	}

	@Override
	public void checkCampaignTrackingActionEvents()
		throws PortalException, SystemException {

		// Process analytics from last date

		addCampaignTrackingActionsFromAnalytics(
			getLastCampaignTrackingActionDate());
	}

	@Override
	public CampaignTrackingAction getCampaignTrackingAction(
			long campaignId, long userSegmentId, long plid, String elementId,
			String eventType)
		throws PortalException, SystemException {

		return campaignTrackingActionPersistence.fetchByC_U_P_E_E(
				campaignId, userSegmentId, plid, elementId, eventType);
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

	@Override
	public Date getLastCampaignTrackingActionDate() {
		try {
			List<CampaignTrackingAction> campaignTrackingActionList =
				campaignTrackingActionPersistence.findAll(0, 1);

			if (!campaignTrackingActionList.isEmpty()) {
				CampaignTrackingAction campaignTrackingAction =
					campaignTrackingActionList.get(0);

				return campaignTrackingAction.getModifiedDate();
			}
			else {
				return _analyticsEventLocalService.getMaxAge();
			}
		}
		catch (Exception e) {
		}

		return null;
	}

	protected void addCampaignTrackingActionsFromAnalytics(Date date)
		throws PortalException, SystemException {

		List<Object[]> campaignTrackingActionAnalyticsList =
			campaignTrackingActionFinder.findByAnalytics(date);

		for (Object[] campaignTrackingActionAnalytics :
				campaignTrackingActionAnalyticsList) {

			long plid = (Long)campaignTrackingActionAnalytics[0];
			long userSegmentId = (Long)campaignTrackingActionAnalytics[1];
			String elementId = (String)campaignTrackingActionAnalytics[2];
			String eventType = (String)campaignTrackingActionAnalytics[3];
			long campaignId = (Long)campaignTrackingActionAnalytics[4];
			String alias = (String)campaignTrackingActionAnalytics[5];

			int count = _analyticsEventLocalService.getAnalyticsEventsCount(
				UserSegment.class.getName(), userSegmentId, elementId,
				eventType, date);

			if (count == 0) {
				continue;
			}

			addCampaignTrackingAction(
				campaignId, userSegmentId, alias, plid, elementId, eventType,
				count);
		}
	}

	private void _initServices() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignTrackingActionLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;

}