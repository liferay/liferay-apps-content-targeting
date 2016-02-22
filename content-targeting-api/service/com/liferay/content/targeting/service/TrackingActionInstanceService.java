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

import com.liferay.content.targeting.model.TrackingActionInstance;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

/**
 * Provides the remote service interface for TrackingActionInstance. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceServiceUtil
 * @see com.liferay.content.targeting.service.base.TrackingActionInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.TrackingActionInstanceServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=ct", "json.web.service.context.path=TrackingActionInstance"}, service = TrackingActionInstanceService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TrackingActionInstanceService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrackingActionInstanceServiceUtil} to access the tracking action instance remote service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.TrackingActionInstanceServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public TrackingActionInstance addTrackingActionInstance(long userId,
		long reportInstanceId, java.lang.String trackingActionKey,
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings, ServiceContext serviceContext)
		throws PortalException;

	/**
	* @deprecated As of 2.0.0
	*/
	@java.lang.Deprecated
	public TrackingActionInstance addTrackingActionInstance(long userId,
		java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		ServiceContext serviceContext) throws PortalException;

	public TrackingActionInstance deleteTrackingActionInstance(
		long trackingActionInstanceId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrackingActionInstance fetchTrackingActionInstance(long campaignId,
		java.lang.String alias) throws java.lang.Exception;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstances(
		long campaignId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTrackingActionInstancesCount(long campaignId);

	public TrackingActionInstance updateTrackingActionInstance(
		long trackingActionInstanceId, long reportInstanceId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		ServiceContext serviceContext) throws PortalException;
}