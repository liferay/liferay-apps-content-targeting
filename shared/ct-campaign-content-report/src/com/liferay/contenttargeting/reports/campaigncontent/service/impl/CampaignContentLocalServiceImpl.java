/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.reports.campaigncontent.service.impl;

import com.liferay.analytics.service.AnalyticsEventLocalService;
import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent;
import com.liferay.contenttargeting.reports.campaigncontent.service.base.CampaignContentLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

import java.util.Date;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the campaign content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.reports.campaigncontent.service.CampaignContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.reports.campaigncontent.service.base.CampaignContentLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.reports.campaigncontent.service.CampaignContentLocalServiceUtil
 */
public class CampaignContentLocalServiceImpl
	extends CampaignContentLocalServiceBaseImpl {

	public CampaignContentLocalServiceImpl() {
		_initAnalyticsEventService();
	}

	@Override
	public CampaignContent addCampaignContent(
			long campaignId, String className, long classPK, String eventType,
			int count)
		throws PortalException, SystemException {

		CampaignContent campaignContent = getCampaignContent(
			campaignId, className, classPK, eventType);

		if (campaignContent == null) {
			long campaignContentId = CounterLocalServiceUtil.increment();

			campaignContent = campaignContentPersistence.create(
				campaignContentId);

			campaignContent.setCampaignId(campaignId);
			campaignContent.setClassName(className);
			campaignContent.setClassPK(classPK);
			campaignContent.setEventType(eventType);
			campaignContent.setCount(count);
		}

		campaignContent.setCount(campaignContent.getCount() + count);
		campaignContent.setCreateDate(new Date());

		campaignContentPersistence.update(campaignContent);

		return campaignContent;
	}

	@Override
	public void checkCampaignContentEvents()
		throws PortalException, SystemException {

		// Process analytics from last date

		addCampaignContentsFromAnalytics(getLastCampaignContentDate());
	}

	@Override
	public CampaignContent getCampaignContent(
			long campaignId, String className, long classPK, String eventType)
		throws PortalException, SystemException {

		return campaignContentPersistence.fetchByC_C_C_E(
				campaignId, className, classPK, eventType);
	}

	@Override
	public List<CampaignContent> getCampaignContents(long campaignId)
		throws PortalException, SystemException {

		return campaignContentPersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<CampaignContent> getCampaignContents(
			long campaignId, Date createDate)
		throws PortalException, SystemException {

		return campaignContentPersistence.findByC_GtD(campaignId, createDate);
	}

	@Override
	public Date getLastCampaignContentDate() {
		try {
			List<CampaignContent> campaignContentList =
				campaignContentPersistence.findAll(0, 1);

			if (!campaignContentList.isEmpty()) {
				return campaignContentList.get(0).getCreateDate();
			}
			else {
				return _analyticsEventLocalService.getMaxAge();
			}
		}
		catch (Exception e) {
		}

		return null;
	}

	protected void addCampaignContentsFromAnalytics(Date date)
		throws PortalException, SystemException {

		// Get the portlet preferences of all Campaign Content Display portlets

		DynamicQuery dynamicQuery =
			PortletPreferencesLocalServiceUtil.dynamicQuery();

		Property portletIdProperty = PropertyFactoryUtil.forName("portletId");

		dynamicQuery.add(
			portletIdProperty.like(
				"%campaigncontentdisplay_WAR_contenttargetingportlet%"));

		List<PortletPreferences> portletPreferencesList =
			PortletPreferencesLocalServiceUtil.dynamicQuery(dynamicQuery);

		// Obtain the contents configured in the portlet preferences

		for (PortletPreferences preferences : portletPreferencesList) {
			javax.portlet.PortletPreferences jxPortletPreferences =
				PortletPreferencesFactoryUtil.fromDefaultXML(
					preferences.getPreferences());

			int[] queryRulesIndexes = GetterUtil.getIntegerValues(
					jxPortletPreferences.getValues("queryLogicIndexes", null));

			for (int queryRulesIndex : queryRulesIndexes) {
				try {
					long campaignId = GetterUtil.getLong(
						jxPortletPreferences.getValue(
							"campaignId" + queryRulesIndex, null));

					long assetEntryId = GetterUtil.getLong(
						jxPortletPreferences.getValue(
							"assetEntryId" + queryRulesIndex, null));

					// Obtain analytics and register data

					int campaignContentViewCount =
						_analyticsEventLocalService.getAnalyticsEventsCount(
							AssetEntry.class.getName(), assetEntryId,
							Campaign.class.getName(), campaignId, "view", date);

					if (campaignContentViewCount == 0) {
						continue;
					}

					AssetEntry assetEntry =
						AssetEntryLocalServiceUtil.getAssetEntry(assetEntryId);

					addCampaignContent(
						campaignId, assetEntry.getClassName(),
						assetEntry.getClassPK(), "view",
						campaignContentViewCount);
				}
				catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.debug(
							"Error retrieving analytics for portlet " +
								preferences.getPortletId() + " in plid " +
									preferences.getPlid());
					}

					continue;
				}
			}
		}
	}

	private void _initAnalyticsEventService() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignContentLocalServiceImpl.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;

}