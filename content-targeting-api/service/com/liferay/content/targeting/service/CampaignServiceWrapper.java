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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignService
 * @generated
 */
@ProviderType
public class CampaignServiceWrapper implements CampaignService,
	ServiceWrapper<CampaignService> {
	public CampaignServiceWrapper(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	@Override
	public com.liferay.content.targeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.addCampaign(userId, nameMap, descriptionMap,
			startDate, endDate, priority, active, userSegmentIds, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.addCampaign(userId, nameMap, descriptionMap,
			startDate, endDate, timeZoneId, priority, active, userSegmentIds,
			serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.deleteCampaign(campaignId);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign fetchCurrentMaxPriorityCampaign(
		long[] groupIds, long[] userSegmentIds) {
		return _campaignService.fetchCurrentMaxPriorityCampaign(groupIds,
			userSegmentIds);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.getCampaigns(groupId);
	}

	@Override
	public int getCampaignsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.getCampaignsCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _campaignService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.content.targeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.updateCampaign(campaignId, nameMap,
			descriptionMap, startDate, endDate, priority, active,
			userSegmentIds, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.updateCampaign(campaignId, nameMap,
			descriptionMap, startDate, endDate, timeZoneId, priority, active,
			userSegmentIds, serviceContext);
	}

	@Override
	public CampaignService getWrappedService() {
		return _campaignService;
	}

	@Override
	public void setWrappedService(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	private CampaignService _campaignService;
}