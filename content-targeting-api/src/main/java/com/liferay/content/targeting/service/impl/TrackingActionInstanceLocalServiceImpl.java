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

import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.content.targeting.api.model.TrackingActionsRegistry;
import com.liferay.content.targeting.exception.DuplicateTrackingActionInstanceException;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.base.TrackingActionInstanceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the tracking action instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.TrackingActionInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.TrackingActionInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.TrackingActionInstanceLocalServiceUtil
 */
public class TrackingActionInstanceLocalServiceImpl
	extends TrackingActionInstanceLocalServiceBaseImpl {

	@Override
	public TrackingActionInstance addTrackingActionInstance(
			long userId, long reportInstanceId, String trackingActionKey,
			long campaignId, String alias, String referrerClassName,
			long referrerClassPK, String elementId, String eventType,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		validate(0, campaignId, alias);

		User user = userLocalService.getUser(userId);

		Date now = new Date();

		long trackingActionInstanceId = counterLocalService.increment();

		TrackingActionInstance trackingActionInstance =
			trackingActionInstancePersistence.create(trackingActionInstanceId);

		trackingActionInstance.setUuid(serviceContext.getUuid());
		trackingActionInstance.setGroupId(serviceContext.getScopeGroupId());
		trackingActionInstance.setCompanyId(user.getCompanyId());
		trackingActionInstance.setUserId(user.getUserId());
		trackingActionInstance.setUserName(user.getFullName());
		trackingActionInstance.setCreateDate(serviceContext.getCreateDate(now));
		trackingActionInstance.setModifiedDate(
			serviceContext.getModifiedDate(now));
		trackingActionInstance.setTrackingActionKey(trackingActionKey);
		trackingActionInstance.setCampaignId(campaignId);
		trackingActionInstance.setAlias(alias);
		trackingActionInstance.setReportInstanceId(reportInstanceId);
		trackingActionInstance.setReferrerClassName(referrerClassName);
		trackingActionInstance.setReferrerClassPK(referrerClassPK);
		trackingActionInstance.setElementId(elementId);
		trackingActionInstance.setEventType(eventType);
		trackingActionInstance.setTypeSettings(typeSettings);

		trackingActionInstancePersistence.update(trackingActionInstance);

		return trackingActionInstance;
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

		return addTrackingActionInstance(
			userId, 0, trackingActionKey, campaignId, alias, referrerClassName,
			referrerClassPK, elementId, eventType, typeSettings,
			serviceContext);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public TrackingActionInstance deleteTrackingActionInstance(
			long trackingActionInstanceId)
		throws PortalException {

		TrackingActionInstance TrackingActionInstance =
			trackingActionInstancePersistence.findByPrimaryKey(
				trackingActionInstanceId);

		return deleteTrackingActionInstance(TrackingActionInstance);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public TrackingActionInstance deleteTrackingActionInstance(
			TrackingActionInstance trackingActionInstance)
		throws PortalException {

		trackingActionInstancePersistence.remove(trackingActionInstance);

		// System event

		systemEventLocalService.addSystemEvent(
			0, trackingActionInstance.getGroupId(),
			TrackingActionInstance.class.getName(),
			trackingActionInstance.getTrackingActionInstanceId(),
			trackingActionInstance.getUuid(), null,
			SystemEventConstants.TYPE_DELETE, StringPool.BLANK);

		// Tracking action data

		TrackingAction trackingAction =
			trackingActionsRegistry.getTrackingAction(
				trackingActionInstance.getTrackingActionKey());

		if (trackingAction != null) {
			try {
				trackingAction.deleteData(trackingActionInstance);
			}
			catch (Exception e) {
				_log.error(
					"Cannot delete custom data for tracking action " +
						trackingAction.getName(LocaleUtil.getDefault()),
					e);
			}
		}

		return trackingActionInstance;
	}

	@Override
	public TrackingActionInstance fetchTrackingActionInstance(
		long campaignId, String alias) {

		return trackingActionInstancePersistence.fetchByC_A(campaignId, alias);
	}

	@Override
	public TrackingActionInstance fetchTrackingActionInstanceByReportInstanceId(
		long reportInstanceId, String alias) {

		return trackingActionInstancePersistence.fetchByR_A(
			reportInstanceId, alias);
	}

	@Override
	public List<TrackingActionInstance> getTrackingActionInstances(
		long campaignId) {

		return trackingActionInstancePersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<TrackingActionInstance> getTrackingActionInstances(
		long campaignId, String className, long classPK, String eventType) {

		return trackingActionInstancePersistence.findByC_R_R_E(
			campaignId, className, classPK, eventType);
	}

	@Override
	public List<TrackingActionInstance> getTrackingActionInstances(
		long campaignId, String elementId, String eventType) {

		return trackingActionInstancePersistence.findByC_E_E(
			campaignId, elementId, eventType);
	}

	@Override
	public List<TrackingActionInstance>
		getTrackingActionInstancesByReportInstanceId(
			long reportInstanceId) {

		return trackingActionInstancePersistence.findByReportInstanceId(
			reportInstanceId);
	}

	@Override
	public List<TrackingActionInstance>
		getTrackingActionInstancesByReportInstanceId(
			long reportInstanceId, String className, long classPK,
			String eventType) {

		return trackingActionInstancePersistence.findByR_R_R_E(
			reportInstanceId, className, classPK, eventType);
	}

	@Override
	public List<TrackingActionInstance>
		getTrackingActionInstancesByReportInstanceId(
			long reportInstanceId, String elementId, String eventType) {

		return trackingActionInstancePersistence.findByR_E_E(
			reportInstanceId, elementId, eventType);
	}

	@Override
	public int getTrackingActionInstancesCount(long campaignId) {
		return trackingActionInstancePersistence.countByCampaignId(campaignId);
	}

	@Override
	public TrackingActionInstance updateTrackingActionInstance(
			long trackingActionInstanceId, long reportInstanceId, String alias,
			String referrerClassName, long referrerClassPK, String elementId,
			String eventType, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		TrackingActionInstance trackingActionInstance =
			trackingActionInstancePersistence.findByPrimaryKey(
				trackingActionInstanceId);

		validate(
			trackingActionInstanceId, trackingActionInstance.getCampaignId(),
			alias);

		trackingActionInstance.setModifiedDate(
			serviceContext.getModifiedDate(now));
		trackingActionInstance.setAlias(alias);
		trackingActionInstance.setReportInstanceId(reportInstanceId);
		trackingActionInstance.setReferrerClassName(referrerClassName);
		trackingActionInstance.setReferrerClassPK(referrerClassPK);
		trackingActionInstance.setElementId(elementId);
		trackingActionInstance.setEventType(eventType);
		trackingActionInstance.setTypeSettings(typeSettings);

		trackingActionInstancePersistence.update(trackingActionInstance);

		return trackingActionInstance;
	}

	protected void validate(
			long trackingInstanceId, long campaignId, String alias)
		throws PortalException {

		TrackingActionInstance trackingActionInstance =
			trackingActionInstancePersistence.fetchByC_A(campaignId, alias);

		if ((trackingActionInstance != null) &&
			(trackingActionInstance.getTrackingActionInstanceId() !=
				trackingInstanceId)) {

			throw new DuplicateTrackingActionInstanceException(
				"A tracking action instance with the alias " + alias +
					" already exists in campaign " + campaignId);
		}
	}

	@ServiceReference(type = TrackingActionsRegistry.class)
	protected TrackingActionsRegistry trackingActionsRegistry;

	private static final Log _log = LogFactoryUtil.getLog(
		TrackingActionInstanceLocalServiceImpl.class);

}