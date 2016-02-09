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

package com.liferay.content.targeting.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Campaign. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.CampaignServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignService
 * @see com.liferay.content.targeting.service.base.CampaignServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.CampaignServiceImpl
 * @generated
 */
@ProviderType
public class CampaignServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.CampaignServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.content.targeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCampaign(userId, nameMap, descriptionMap, startDate,
			endDate, priority, active, userSegmentIds, serviceContext);
	}

	public static com.liferay.content.targeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCampaign(userId, nameMap, descriptionMap, startDate,
			endDate, timeZoneId, priority, active, userSegmentIds,
			serviceContext);
	}

	public static com.liferay.content.targeting.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCampaign(campaignId);
	}

	public static com.liferay.content.targeting.model.Campaign fetchCurrentMaxPriorityCampaign(
		long[] groupIds, long[] userSegmentIds) {
		return getService()
				   .fetchCurrentMaxPriorityCampaign(groupIds, userSegmentIds);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaigns(groupId);
	}

	public static int getCampaignsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaignsCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.content.targeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCampaign(campaignId, nameMap, descriptionMap,
			startDate, endDate, priority, active, userSegmentIds, serviceContext);
	}

	public static com.liferay.content.targeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCampaign(campaignId, nameMap, descriptionMap,
			startDate, endDate, timeZoneId, priority, active, userSegmentIds,
			serviceContext);
	}

	public static CampaignService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampaignService, CampaignService> _serviceTracker =
		ServiceTrackerFactory.open(CampaignService.class);
}