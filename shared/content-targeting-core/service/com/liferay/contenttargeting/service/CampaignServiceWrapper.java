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

package com.liferay.contenttargeting.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignService
 * @generated
 */
public class CampaignServiceWrapper implements CampaignService,
	ServiceWrapper<CampaignService> {
	public CampaignServiceWrapper(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _campaignService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.contenttargeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		long[] userSegmentIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.addCampaign(userId, nameMap, descriptionMap,
			startDate, endDate, priority, userSegmentIds, serviceContext);
	}

	@Override
	public com.liferay.contenttargeting.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.deleteCampaign(campaignId);
	}

	@Override
	public com.liferay.contenttargeting.model.Campaign fetchCurrentMaxPriorityCampaign(
		long groupId, long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.fetchCurrentMaxPriorityCampaign(groupId,
			userSegmentIds);
	}

	@Override
	public java.util.List<com.liferay.contenttargeting.model.Campaign> getCampaigns(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.getCampaigns(groupId);
	}

	@Override
	public long getCampaignsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.getCampaignsCount(groupId);
	}

	@Override
	public com.liferay.contenttargeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		long[] userSegmentIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.updateCampaign(campaignId, nameMap,
			descriptionMap, startDate, endDate, priority, userSegmentIds,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CampaignService getWrappedCampaignService() {
		return _campaignService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCampaignService(CampaignService campaignService) {
		_campaignService = campaignService;
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