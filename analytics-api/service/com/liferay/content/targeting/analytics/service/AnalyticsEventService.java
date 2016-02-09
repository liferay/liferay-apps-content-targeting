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

package com.liferay.content.targeting.analytics.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Provides the remote service interface for AnalyticsEvent. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventServiceUtil
 * @see com.liferay.content.targeting.analytics.service.base.AnalyticsEventServiceBaseImpl
 * @see com.liferay.content.targeting.analytics.service.impl.AnalyticsEventServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=ct_analytics", "json.web.service.context.path=AnalyticsEvent"}, service = AnalyticsEventService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnalyticsEventService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalyticsEventServiceUtil} to access the analytics event remote service. Add custom service methods to {@link com.liferay.content.targeting.analytics.service.impl.AnalyticsEventServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(long companyId,
		Date createDate) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(java.lang.String elementId,
		java.lang.String eventType, Date createDate) throws PortalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();
}