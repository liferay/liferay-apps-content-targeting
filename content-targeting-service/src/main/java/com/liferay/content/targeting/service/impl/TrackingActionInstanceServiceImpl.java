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

import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.base.TrackingActionInstanceServiceBaseImpl;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the tracking action instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.TrackingActionInstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.TrackingActionInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.TrackingActionInstanceServiceUtil
 */
public class TrackingActionInstanceServiceImpl
	extends TrackingActionInstanceServiceBaseImpl {

	@Override
	public TrackingActionInstance addTrackingActionInstance(
			long userId, long reportInstanceId, String trackingActionKey,
			long campaignId, String alias, String referrerClassName,
			long referrerClassPK, String elementId, String eventType,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		CampaignPermission.check(
			getPermissionChecker(), campaignId, ActionKeys.UPDATE);

		return trackingActionInstanceLocalService.addTrackingActionInstance(
			userId, reportInstanceId, trackingActionKey, campaignId, alias,
			referrerClassName, referrerClassPK, elementId, eventType,
			typeSettings, serviceContext);
	}

	/**
	 * @deprecated As of 2.0.0
	 */
	@Deprecated
	@Override
	public TrackingActionInstance addTrackingActionInstance(
			long userId, String trackingActionKey, long campaignId,
			String alias, String referrerClassName, long referrerClassPK,
			String elementId, String eventType, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		CampaignPermission.check(
			getPermissionChecker(), campaignId, ActionKeys.UPDATE);

		return trackingActionInstanceLocalService.addTrackingActionInstance(
			userId, trackingActionKey, campaignId, alias, referrerClassName,
			referrerClassPK, elementId, eventType, typeSettings,
			serviceContext);
	}

	@Override
	public TrackingActionInstance deleteTrackingActionInstance(
			long trackingActionInstanceId)
		throws PortalException {

		TrackingActionInstance trackingActionInstance =
			trackingActionInstanceLocalService.getTrackingActionInstance(
				trackingActionInstanceId);

		CampaignPermission.check(
			getPermissionChecker(), trackingActionInstance.getCampaignId(),
			ActionKeys.UPDATE);

		return trackingActionInstanceLocalService.deleteTrackingActionInstance(
			trackingActionInstanceId);
	}

	@Override
	public TrackingActionInstance fetchTrackingActionInstance(
			long campaignId, String alias)
		throws Exception {

		return trackingActionInstanceLocalService.fetchTrackingActionInstance(
			campaignId, alias);
	}

	@Override
	public List<TrackingActionInstance> getTrackingActionInstances(
		long campaignId) {

		return trackingActionInstanceLocalService.getTrackingActionInstances(
			campaignId);
	}

	@Override
	public List<TrackingActionInstance>
		getTrackingActionInstancesByReportInstanceId(
			long reportInstanceId) {

		return trackingActionInstanceLocalService.
			getTrackingActionInstancesByReportInstanceId(reportInstanceId);
	}

	@Override
	public int getTrackingActionInstancesCount(long campaignId) {
		return
			trackingActionInstanceLocalService.getTrackingActionInstancesCount(
				campaignId);
	}

	@Override
	public TrackingActionInstance updateTrackingActionInstance(
			long trackingActionInstanceId, long reportInstanceId, String alias,
			String referrerClassName, long referrerClassPK, String elementId,
			String eventType, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		TrackingActionInstance trackingActionInstance =
			trackingActionInstanceLocalService.getTrackingActionInstance(
				trackingActionInstanceId);

		CampaignPermission.check(
			getPermissionChecker(), trackingActionInstance.getCampaignId(),
			ActionKeys.UPDATE);

		return trackingActionInstanceLocalService.updateTrackingActionInstance(
			trackingActionInstanceId, reportInstanceId, alias,
			referrerClassName, referrerClassPK, elementId, eventType,
			typeSettings, serviceContext);
	}

}