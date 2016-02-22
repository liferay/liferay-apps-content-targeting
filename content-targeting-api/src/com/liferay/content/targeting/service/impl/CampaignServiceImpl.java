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

package com.liferay.content.targeting.service.impl;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.service.base.CampaignServiceBaseImpl;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.service.permission.ContentTargetingPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the campaign remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.CampaignService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Eduardo Garcia
 * @see com.liferay.content.targeting.service.base.CampaignServiceBaseImpl
 * @see com.liferay.content.targeting.service.CampaignServiceUtil
 */
public class CampaignServiceImpl extends CampaignServiceBaseImpl {

	@Override
	public Campaign addCampaign(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			int priority, boolean active, long[] userSegmentIds,
			ServiceContext serviceContext)
		throws PortalException {

		ContentTargetingPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_CAMPAIGN);

		return campaignLocalService.addCampaign(
			userId, nameMap, descriptionMap, startDate, endDate, null, priority,
			active, userSegmentIds, serviceContext);
	}

	@Override
	public Campaign addCampaign(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			String timeZoneId, int priority, boolean active,
			long[] userSegmentIds, ServiceContext serviceContext)
		throws PortalException {

		ContentTargetingPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_CAMPAIGN);

		return campaignLocalService.addCampaign(
			userId, nameMap, descriptionMap, startDate, endDate, timeZoneId,
			priority, active, userSegmentIds, serviceContext);
	}

	@Override
	public Campaign deleteCampaign(long campaignId) throws PortalException {
		CampaignPermission.check(
			getPermissionChecker(), campaignId, ActionKeys.DELETE);

		return campaignLocalService.deleteCampaign(campaignId);
	}

	@Override
	public Campaign fetchCurrentMaxPriorityCampaign(
		long[] groupIds, long[] userSegmentIds) {

		Date now = new Date();

		return campaignFinder.filterFetchByG_D_A_U_First(
			groupIds, now, true, userSegmentIds);
	}

	@Override
	public List<Campaign> getCampaigns(long groupId) throws PortalException {
		return campaignPersistence.filterFindByGroupId(groupId);
	}

	@Override
	public int getCampaignsCount(long groupId) throws PortalException {
		return campaignPersistence.filterCountByGroupId(groupId);
	}

	@Override
	public Campaign updateCampaign(
			long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			int priority, boolean active, long[] userSegmentIds,
			ServiceContext serviceContext)
		throws PortalException {

		CampaignPermission.check(
			getPermissionChecker(), campaignId, ActionKeys.UPDATE);

		return campaignLocalService.updateCampaign(
			campaignId, nameMap, descriptionMap, startDate, endDate, null,
			priority, active, userSegmentIds, serviceContext);
	}

	@Override
	public Campaign updateCampaign(
			long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			String timeZoneId, int priority, boolean active,
			long[] userSegmentIds, ServiceContext serviceContext)
		throws PortalException {

		CampaignPermission.check(
			getPermissionChecker(), campaignId, ActionKeys.UPDATE);

		return campaignLocalService.updateCampaign(
			campaignId, nameMap, descriptionMap, startDate, endDate, timeZoneId,
			priority, active, userSegmentIds, serviceContext);
	}

}