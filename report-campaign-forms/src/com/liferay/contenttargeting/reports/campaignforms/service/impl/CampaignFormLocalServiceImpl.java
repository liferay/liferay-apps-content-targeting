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

package com.liferay.contenttargeting.reports.campaignforms.service.impl;

import com.liferay.analytics.service.AnalyticsEventLocalService;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.reports.campaignforms.model.CampaignForm;
import com.liferay.contenttargeting.reports.campaignforms.service.base.CampaignFormLocalServiceBaseImpl;
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
 * The implementation of the campaign form local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.reports.campaignforms.service.CampaignFormLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.reports.campaignforms.service.base.CampaignFormLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.reports.campaignforms.service.CampaignFormLocalServiceUtil
 */
public class CampaignFormLocalServiceImpl
	extends CampaignFormLocalServiceBaseImpl {

	public CampaignFormLocalServiceImpl() {
		_initServices();
	}

	@Override
	public CampaignForm addCampaignForm(
			long campaignId, long userSegmentId, String alias, long plid,
			String elementId, String eventType, int count)
		throws PortalException, SystemException {

		CampaignForm campaignForm = getCampaignForm(
			campaignId, userSegmentId, plid, elementId, eventType);

		if (campaignForm == null) {
			long campaignFormId = CounterLocalServiceUtil.increment();

			campaignForm = campaignFormPersistence.create(campaignFormId);

			campaignForm.setCampaignId(campaignId);
			campaignForm.setUserSegmentId(userSegmentId);
			campaignForm.setAlias(alias);
			campaignForm.setPlid(plid);
			campaignForm.setElementId(elementId);
			campaignForm.setEventType(eventType);
			campaignForm.setCount(count);
		}

		campaignForm.setCount(campaignForm.getCount() + count);
		campaignForm.setModifiedDate(new Date());

		campaignFormPersistence.update(campaignForm);

		return campaignForm;
	}

	@Override
	public void checkCampaignFormEvents()
		throws PortalException, SystemException {

		// Process analytics from last date

		addCampaignFormsFromAnalytics(getLastCampaignFormDate());
	}

	@Override
	public CampaignForm getCampaignForm(
			long campaignId, long userSegmentId, long plid, String elementId,
			String eventType)
		throws PortalException, SystemException {

		return campaignFormPersistence.fetchByC_U_P_E_E(
				campaignId, userSegmentId, plid, elementId, eventType);
	}

	@Override
	public List<CampaignForm> getCampaignForms(long campaignId)
		throws PortalException, SystemException {

		return campaignFormPersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<CampaignForm> getCampaignForms(
			long campaignId, Date modifiedDate)
		throws PortalException, SystemException {

		return campaignFormPersistence.findByC_GtD(campaignId, modifiedDate);
	}

	@Override
	public List<CampaignForm> getCampaignForms(
			long campaignId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException, SystemException {

		return campaignFormPersistence.findByCampaignId(
				campaignId, start, end, orderByComparator);
	}

	@Override
	public int getCampaignFormsCount(long campaignId)
		throws PortalException, SystemException {

		return campaignFormPersistence.countByCampaignId(campaignId);
	}

	@Override
	public Date getLastCampaignFormDate() {
		try {
			List<CampaignForm> campaignFormList =
				campaignFormPersistence.findAll(0, 1);

			if (!campaignFormList.isEmpty()) {
				CampaignForm campaignForm = campaignFormList.get(0);

				return campaignForm.getModifiedDate();
			}
			else {
				return _analyticsEventLocalService.getMaxAge();
			}
		}
		catch (Exception e) {
		}

		return null;
	}

	protected void addCampaignFormsFromAnalytics(Date date)
		throws PortalException, SystemException {

		List<Object[]> campaignFormAnalyticsList =
			campaignFormFinder.findByAnalytics(date);

		for (Object[] campaignFormAnalytics : campaignFormAnalyticsList) {
			long plid = (Long)campaignFormAnalytics[0];
			long userSegmentId = (Long)campaignFormAnalytics[1];
			String elementId = (String)campaignFormAnalytics[2];
			String eventType = (String)campaignFormAnalytics[3];
			long campaignId = (Long)campaignFormAnalytics[4];
			String alias = (String)campaignFormAnalytics[5];

			int count = _analyticsEventLocalService.getAnalyticsEventsCount(
				UserSegment.class.getName(), userSegmentId, elementId,
				eventType, date);

			if (count == 0) {
				continue;
			}

			addCampaignForm(
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
		CampaignFormLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;

}