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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

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

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.content.targeting.service.TrackingActionInstanceServiceUtil} to access the tracking action instance remote service.
	 */

	@Override
	public TrackingActionInstance addTrackingActionInstance(
			long userId, String trackingActionKey, long campaignId,
			String alias, String referrerClassName, long referrerClassPK,
			String elementId, String eventType, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

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
		throws PortalException, SystemException {

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
			long campaignId)
		throws SystemException {

		return trackingActionInstanceLocalService.getTrackingActionInstances(
			campaignId);
	}

	@Override
	public int getTrackingActionInstancesCount(long campaignId)
		throws SystemException {

		return
			trackingActionInstanceLocalService.getTrackingActionInstancesCount(
				campaignId);
	}

	@Override
	public TrackingActionInstance updateTrackingActionInstance(
			long trackingActionInstanceId, String alias,
			String referrerClassName, long referrerClassPK, String elementId,
			String eventType, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		TrackingActionInstance trackingActionInstance =
			trackingActionInstanceLocalService.getTrackingActionInstance(
				trackingActionInstanceId);

		CampaignPermission.check(
			getPermissionChecker(), trackingActionInstance.getCampaignId(),
			ActionKeys.UPDATE);

		return trackingActionInstanceLocalService.updateTrackingActionInstance(
			trackingActionInstanceId, alias, referrerClassName, referrerClassPK,
			elementId, eventType, typeSettings, serviceContext);
	}

}