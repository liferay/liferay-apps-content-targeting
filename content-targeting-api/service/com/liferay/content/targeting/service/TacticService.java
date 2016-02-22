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

import com.liferay.content.targeting.model.Tactic;

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
 * Provides the remote service interface for Tactic. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TacticServiceUtil
 * @see com.liferay.content.targeting.service.base.TacticServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.TacticServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=ct", "json.web.service.context.path=Tactic"}, service = TacticService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TacticService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TacticServiceUtil} to access the tactic remote service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.TacticServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Tactic addTactic(long userId, long campaignId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, long[] userSegmentsIds,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getTactics(long campaignId) throws PortalException;

	public Tactic updateTactic(long tacticId, long campaignId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, long[] userSegmentsIds,
		ServiceContext serviceContext) throws PortalException;
}