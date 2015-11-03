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

package com.liferay.content.targeting.report.campaign.mobile.service.impl;

import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.service.ConsumerLocalService;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.report.campaign.mobile.CampaignMobileReport;
import com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData;
import com.liferay.content.targeting.report.campaign.mobile.service.base.ConsumerDataLocalServiceBaseImpl;
import com.liferay.content.targeting.report.campaign.mobile.service.persistence.ConsumerDataFinderUtil;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
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
 * The implementation of the consumer data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.mobile.service.ConsumerDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.mobile.service.base.ConsumerDataLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.mobile.service.ConsumerDataLocalServiceUtil
 */
public class ConsumerDataLocalServiceImpl
	extends ConsumerDataLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.content.targeting.report.campaign.mobile.service.ConsumerDataLocalServiceUtil} to access the consumer data local service.
	 */

	public ConsumerDataLocalServiceImpl() {
		_initServices();
	}


	public ConsumerData addConsumerData(
		long campaignId, String elementId, long consumerId, String eventType, int count)
		throws PortalException, SystemException {

		ConsumerData consumerData = getConsumerData(
			campaignId, consumerId, eventType);

		if (consumerData == null) {
			long ConsumerDataId = CounterLocalServiceUtil.increment();

			consumerData = consumerDataPersistence.create(ConsumerDataId);

			consumerData.setConsumerId(consumerId);
			consumerData.setCampaignId(campaignId);
			consumerData.setEventType(eventType);
			consumerData.setElementId(elementId);
			consumerData.setCount(count);
		}
		else {
			consumerData.setCount(consumerData.getCount() + count);
		}

		consumerData.setModifiedDate(new Date());
		consumerDataPersistence.update(consumerData);
		return consumerData;
	}

	public void checkConsumerDataEvents(long campaignId)
		throws PortalException, SystemException {

		Date modifiedDate = _analyticsEventLocalService.getMaxAge();

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				CampaignMobileReport.class.getSimpleName(),
				Campaign.class.getName(), campaignId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		addConsumerDataFromAnalytics(campaignId, modifiedDate);
	}

	@Override
	public void checkConsumerDataEvents() throws PortalException, SystemException {
		try {
			List<ReportInstance> reportInstances =
				_reportInstanceLocalService.getReportInstances(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			ServiceContext serviceContext = new ServiceContext();

			for (ReportInstance reportInstance : reportInstances) {
				checkConsumerDataEvents(reportInstance.getReportInstanceId());

				serviceContext.setScopeGroupId(reportInstance.getGroupId());
			}
		}
		catch (NullPointerException npe) {
			if (_log.isWarnEnabled()) {
				_log.warn("Content Targeting API Services are not available");
			}
		}
	}

	public ConsumerData getConsumerData(
		long campaignId, long consumerId, String eventType)
		throws PortalException, SystemException {

		return consumerDataPersistence.fetchByC_C_E(
			campaignId, consumerId, eventType);
	}

	protected void addConsumerDataFromAnalytics(long campaignId, Date date)
		throws PortalException, SystemException {

		Campaign campaign = _campaignLocalService.getCampaign(campaignId);

		List<Object[]> analyticsEvents =
			ConsumerDataFinderUtil.findBy(campaign.getCompanyId(), date);

		_addConsumerDataElements(campaignId, analyticsEvents);

		List<Object[]> timeOnScreenEvents =
			ConsumerDataFinderUtil.sumTimeOnScreen(CampaignMobileReport.SESSION_SCREEN, campaign.getCompanyId(), date);

		_addConsumerDataElements(campaignId, timeOnScreenEvents);

	}

	private void _addConsumerDataElements(long campaignId, List<Object[]> timeOnScreen) throws PortalException, SystemException {
		for (Object[] analyticsEvent : timeOnScreen) {
			String elementId = (String) analyticsEvent[2];
			String eventType = (String) analyticsEvent[3];
			long consumerId = (Long) analyticsEvent[4];
			int count = (Integer) analyticsEvent[5];

			addConsumerData(campaignId, elementId, consumerId, eventType, count);
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
		ConsumerDataLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;

}