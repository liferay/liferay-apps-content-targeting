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
import com.liferay.contenttargeting.service.base.TrackingActionInstanceLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the tracking action instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.TrackingActionInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.service.base.TrackingActionInstanceLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.TrackingActionInstanceLocalServiceUtil
 */
public class TrackingActionInstanceLocalServiceImpl
	extends TrackingActionInstanceLocalServiceBaseImpl {

	@Override
	public TrackingActionInstance addTrackingActionInstance(
			long userId, String trackingActionKey, long campaignId,
			String alias, String referrerClassName, long referrerClassPK,
			String elementId, String eventType, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long trackingActionInstanceId = CounterLocalServiceUtil.increment();

		TrackingActionInstance trackingActionInstance =
			trackingActionInstancePersistence.create(trackingActionInstanceId);

		trackingActionInstance.setGroupId(groupId);

		trackingActionInstance.setCompanyId(user.getCompanyId());
		trackingActionInstance.setUserId(user.getUserId());
		trackingActionInstance.setUserName(user.getFullName());
		trackingActionInstance.setCreateDate(serviceContext.getCreateDate(now));
		trackingActionInstance.setModifiedDate(
			serviceContext.getModifiedDate(now));
		trackingActionInstance.setTrackingActionKey(trackingActionKey);
		trackingActionInstance.setCampaignId(campaignId);
		trackingActionInstance.setAlias(alias);
		trackingActionInstance.setReferrerClassName(referrerClassName);
		trackingActionInstance.setReferrerClassPK(referrerClassPK);
		trackingActionInstance.setElementId(elementId);
		trackingActionInstance.setEventType(eventType);

		trackingActionInstancePersistence.update(trackingActionInstance);

		return trackingActionInstance;
	}

	@Override
	public List<TrackingActionInstance> getTrackingActionInstances(
			long campaignId)
		throws SystemException {

		return trackingActionInstancePersistence.findByCampaignId(campaignId);
	}

	@Override
	public int getTrackingActionInstancesCount(long campaignId)
		throws SystemException {

		return trackingActionInstancePersistence.countByCampaignId(campaignId);
	}

	@Override
	public TrackingActionInstance updateTrackingActionInstance(
			long trackingActionInstanceId, String alias,
			String referrerClassName, long referrerClassPK, String elementId,
			String eventType, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		TrackingActionInstance trackingActionInstance =
			trackingActionInstancePersistence.findByPrimaryKey(
				trackingActionInstanceId);

		trackingActionInstance.setModifiedDate(
			serviceContext.getModifiedDate(now));
		trackingActionInstance.setAlias(alias);
		trackingActionInstance.setReferrerClassName(referrerClassName);
		trackingActionInstance.setReferrerClassPK(referrerClassPK);
		trackingActionInstance.setElementId(elementId);
		trackingActionInstance.setEventType(eventType);

		trackingActionInstancePersistence.update(trackingActionInstance);

		return trackingActionInstance;
	}

}