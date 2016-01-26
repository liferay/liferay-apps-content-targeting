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

package com.liferay.content.targeting.rule.engine.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for RuleEngine. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RuleEngineServiceUtil
 * @see com.liferay.content.targeting.rule.engine.service.base.RuleEngineServiceBaseImpl
 * @see com.liferay.content.targeting.rule.engine.service.impl.RuleEngineServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RuleEngineService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleEngineServiceUtil} to access the rule engine remote service. Add custom service methods to {@link com.liferay.content.targeting.rule.engine.service.impl.RuleEngineServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	java.lang.Object invokeMethod(java.lang.String name,
								  java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	long[] getMatchesUserSegmentIds(
			javax.servlet.http.HttpServletRequest request, long[] groupIds,
			long anonymousUserId) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	long[] getMatchesUserSegmentIds(
			javax.servlet.http.HttpServletRequest request, long groupId,
			long anonymousUserId) throws java.lang.Exception;

	boolean matches(javax.servlet.http.HttpServletRequest request,
					long anonymousUserId,
					com.liferay.content.targeting.model.UserSegment userSegment)
		throws java.lang.Exception;
}