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

package com.liferay.contenttargeting.service.impl;

import com.liferay.contenttargeting.model.TrackingActionInstance;
import com.liferay.contenttargeting.service.base.TrackingActionInstanceServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the tracking action instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.TrackingActionInstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.service.base.TrackingActionInstanceServiceBaseImpl
 * @see com.liferay.contenttargeting.service.TrackingActionInstanceServiceUtil
 */
public class TrackingActionInstanceServiceImpl
	extends TrackingActionInstanceServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.contenttargeting.service.TrackingActionInstanceServiceUtil} to access the tracking action instance remote service.
	 */

	@Override
	public TrackingActionInstance addTrackingActionInstance(
			long userId, String trackingActionKey, long campaignId,
			String referrerClassName, long referrerClassPK, String elementId,
			String eventType, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return trackingActionInstanceLocalService.addTrackingActionInstance(
			userId, trackingActionKey, campaignId, referrerClassName,
			referrerClassPK, elementId, eventType, serviceContext);
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
			long trackingActionInstanceId, String referrerClassName,
			long referrerClassPK, String elementId, String eventType,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		return trackingActionInstanceLocalService.updateTrackingActionInstance(
			trackingActionInstanceId, referrerClassName, referrerClassPK,
			elementId, eventType, serviceContext);
	}

}