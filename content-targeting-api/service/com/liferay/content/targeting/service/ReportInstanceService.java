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

import com.liferay.content.targeting.model.ReportInstance;

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
import java.util.Locale;
import java.util.Map;

/**
 * Provides the remote service interface for ReportInstance. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstanceServiceUtil
 * @see com.liferay.content.targeting.service.base.ReportInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.ReportInstanceServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=ct", "json.web.service.context.path=ReportInstance"}, service = ReportInstanceService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ReportInstanceService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReportInstanceServiceUtil} to access the report instance remote service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.ReportInstanceServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public ReportInstance addReportInstance(long userId,
		java.lang.String reportKey, java.lang.String className, long classPK,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings, ServiceContext serviceContext)
		throws PortalException;

	/**
	* @deprecated As of 2.0.0
	*/
	@java.lang.Deprecated
	public ReportInstance addReportInstance(long userId,
		java.lang.String reportKey, java.lang.String className, long classPK,
		java.lang.String typeSettings, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ReportInstance fetchReportInstance(long reportInstanceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ReportInstance fetchReportInstance(java.lang.String reportKey,
		java.lang.String className, long classPK);

	public List<ReportInstance> findReportInstances(
		java.lang.String reportKey, java.lang.String className, long classPK);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReportInstance> getReportInstances(java.lang.String className,
		long classPK);

	public ReportInstance updateReportInstance(ReportInstance reportInstance);

	public ReportInstance updateReportInstance(long reportInstanceId,
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK, Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings, ServiceContext serviceContext)
		throws PortalException;
}