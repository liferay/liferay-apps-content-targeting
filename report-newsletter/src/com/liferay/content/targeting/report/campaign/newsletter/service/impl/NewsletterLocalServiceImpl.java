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

package com.liferay.content.targeting.report.campaign.newsletter.service.impl;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter;
import com.liferay.content.targeting.report.campaign.newsletter.service.base.NewsletterLocalServiceBaseImpl;
import com.liferay.content.targeting.report.newsletter.NewsletterReport;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the newsletter local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.newsletter.service.NewsletterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.newsletter.service.base.NewsletterLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.newsletter.service.NewsletterLocalServiceUtil
 */
public class NewsletterLocalServiceImpl extends NewsletterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.content.targeting.report.campaign.newsletter.service.NewsletterLocalServiceUtil} to access the newsletter local service.
	 */

	@Override
	public Newsletter addNewsletter(
			long campaignId, String alias, String elementId, String eventType, int count)
		throws PortalException, SystemException {

		Newsletter newsletter = newsletterPersistence.fetchByC_A_E_E(
			campaignId, alias, elementId, eventType);

		if (newsletter == null) {
			long newsletterId = CounterLocalServiceUtil.increment();

			newsletter = newsletterPersistence.create(newsletterId);

			newsletter.setCampaignId(campaignId);
			newsletter.setAlias(alias);
			newsletter.setElementId(elementId);
			newsletter.setEventType(eventType);
		}

		newsletter.setCount(
			newsletter.getCount() + count);
		newsletter.setModifiedDate(new Date());

		newsletterPersistence.update(newsletter);

		return newsletter;
	}

	protected void addCampaignNewsletterFromAnalyticsWithElementId(
			long campaignId, Date date)
		throws PortalException, SystemException {

		if (date == null) {
			date = _analyticsEventLocalService.getMaxAge();
		}

		List<Object[]> campaignNewsletterAnalyticsList =
			newsletterFinder.findByAnalyticsWithElementId(campaignId, date);

		for (Object[] campaignNewsletterAnalytics :
				campaignNewsletterAnalyticsList) {

			String elementId = (String)campaignNewsletterAnalytics[0];
			String eventType = (String)campaignNewsletterAnalytics[1];
			String alias = (String)campaignNewsletterAnalytics[2];

			int count = _analyticsEventLocalService.getAnalyticsEventsCount(
				elementId, eventType, date);

			if (count == 0) {
				continue;
			}

			addNewsletter(campaignId, alias, elementId, eventType, count);
		}
	}

	@Override
	public void checkNewsletters()
		throws PortalException, SystemException {

		try {
			List<Campaign> campaigns = _campaignLocalService.getCampaigns(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			ServiceContext serviceContext = new ServiceContext();

			for (Campaign campaign : campaigns) {
				Date lastReportDate = getLastReportDate(campaign.getCampaignId());

				addCampaignNewsletterFromAnalyticsWithElementId(
					campaign.getCampaignId(), lastReportDate);

				serviceContext.setScopeGroupId(campaign.getGroupId());

				_reportInstanceLocalService.addReportInstance(
					campaign.getUserId(),
					NewsletterReport.class.getSimpleName(),
					Campaign.class.getName(), campaign.getCampaignId(),
					StringPool.BLANK, serviceContext);
			}
		}
		catch (NullPointerException npe) {
			_log.error("Content Targeting API Services are not available");
		}
	}

	@Override
	public Date getLastReportDate(long campaignId)
		throws PortalException, SystemException {

		Date modifiedDate = null;

		ReportInstance reportInstance =
			_reportInstanceLocalService.fetchReportInstance(
				NewsletterReport.class.getSimpleName(),
				Campaign.class.getName(), campaignId);

		if (reportInstance != null) {
			modifiedDate = reportInstance.getModifiedDate();
		}

		return modifiedDate;
	}

	private static Log _log = LogFactoryUtil.getLog(
		NewsletterLocalServiceImpl.class);

	public NewsletterLocalServiceImpl() {
		_initServices();
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

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;

}