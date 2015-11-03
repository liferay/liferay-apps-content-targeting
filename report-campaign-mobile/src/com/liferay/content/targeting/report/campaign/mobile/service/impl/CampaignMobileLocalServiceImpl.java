/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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

package com.liferay.content.targeting.report.campaign.mobile.service.impl;

import com.liferay.consumer.manager.extension.screens.model.Placeholder;
import com.liferay.consumer.manager.extension.screens.service.PlaceholderLocalService;
import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.service.ConsumerLocalService;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.campaign.mobile.CampaignMobileReport;
import com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile;
import com.liferay.content.targeting.report.campaign.mobile.service.base.CampaignMobileLocalServiceBaseImpl;
import com.liferay.content.targeting.report.campaign.mobile.service.persistence.CampaignMobileFinderUtil;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the campaign mobile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.mobile.service.CampaignMobileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignMobileLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.mobile.service.CampaignMobileLocalServiceUtil
 */
public class CampaignMobileLocalServiceImpl
	extends CampaignMobileLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.content.targeting.report.campaign.mobile.service.CampaignMobileLocalServiceUtil} to access the campaign mobile local service.
	 */

	public CampaignMobileLocalServiceImpl() {
		_initServices();
	}

	public CampaignMobile addCampaignMobile(
			long campaignId, long consumerId, long placeholderId, String elementId, long userSegmentId,
			String className, long classPK, String eventType, int count)
		throws PortalException, SystemException {

		CampaignMobile campaignContent = getCampaignMobile(
			campaignId, consumerId, placeholderId, userSegmentId, className, classPK, eventType);

		if (campaignContent == null) {
			long campaignContentId = CounterLocalServiceUtil.increment();

			campaignContent = campaignMobilePersistence.create(
				campaignContentId);

			campaignContent.setCampaignId(campaignId);
			campaignContent.setEventType(eventType);
			campaignContent.setCount(count);
			campaignContent.setConsumerId(consumerId);
			campaignContent.setClassName(className);
			campaignContent.setClassPK(classPK);
			campaignContent.setPlaceholderId(placeholderId);
			campaignContent.setUserSegmentId(userSegmentId);
			campaignContent.setElementId(String.valueOf(elementId));
		}
		else {
			campaignContent.setCount(campaignContent.getCount() + count);
		}

		campaignContent.setModifiedDate(new Date());

		campaignMobilePersistence.update(campaignContent);

		return campaignContent;
	}

	@Override
	public void checkCampaignContentEvents(long campaignId)
		throws PortalException, SystemException {

		Date modifiedDate = _analyticsEventLocalService.getMaxAge();

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				CampaignMobileReport.class.getSimpleName(),
				Campaign.class.getName(), campaignId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		addCampaignMobileFromAnalytics(campaignId, modifiedDate);
	}

	@Override
	public void checkCampaignContentEvents() throws PortalException, SystemException {
		try {
			List<ReportInstance> reportInstances =
				_reportInstanceLocalService.getReportInstances(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			ServiceContext serviceContext = new ServiceContext();

			for (ReportInstance reportInstance : reportInstances) {
				checkCampaignContentEvents(reportInstance.getReportInstanceId());

				serviceContext.setScopeGroupId(reportInstance.getGroupId());
			}
		}
		catch (NullPointerException npe) {
			if (_log.isWarnEnabled()) {
				_log.warn("Content Targeting API Services are not available");
			}
		}
	}

	public CampaignMobile getCampaignMobile(
			long campaignId, long consumerId, long placeholderId, long userSegmentId, String className, long classPK, String eventType)
		throws PortalException, SystemException {

		return campaignMobilePersistence.fetchByC_C_P_U_C_C_E(
			campaignId, consumerId, placeholderId, userSegmentId, className, classPK, eventType);
	}

	protected void addCampaignMobileFromAnalytics(long campaignId, Date date)
		throws PortalException, SystemException {

		Campaign campaign = _campaignLocalService.getCampaign(campaignId);

		List<Object[]> analyticsEvents = CampaignMobileFinderUtil.findBy(campaign.getCompanyId(), campaign.getCampaignId(), date);

		_addCampaignMobileElements(campaignId, analyticsEvents);

		List<Object[]> timeOnScreenEvents =
			CampaignMobileFinderUtil.countTimeATOnScreen(CampaignMobileReport.AT_ON_SCREEN, campaign.getCompanyId(),
				campaign.getCampaignId(), date);

		_addCampaignMobileElements(campaignId, timeOnScreenEvents);
	}

	private void _addCampaignMobileElements(long campaignId, List<Object[]> timeOnScreen)
		throws PortalException, SystemException {

		for (Object[] analyticsEvent : timeOnScreen) {

			String className = (String) analyticsEvent[0];
			long classPK = (Long) analyticsEvent[1];
			String elementId = (String) analyticsEvent[2];
			String eventType = (String) analyticsEvent[3];
			long consumerId = (Long) analyticsEvent[5];
			long placeholderId = (Long) analyticsEvent[6];
			long userSegmentId = (Long) analyticsEvent[7];

			int count = (Integer) analyticsEvent[8];

			addCampaignMobile(
				campaignId, consumerId, placeholderId, elementId, userSegmentId, className, classPK, eventType, count);
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
		CampaignMobileLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;
}