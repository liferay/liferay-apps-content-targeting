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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RuleEngineService}.
 *
 * @author Brian Wing Shun Chan
 * @see RuleEngineService
 * @generated
 */
public class RuleEngineServiceWrapper implements RuleEngineService,
	ServiceWrapper<RuleEngineService> {
	public RuleEngineServiceWrapper(RuleEngineService ruleEngineService) {
		_ruleEngineService = ruleEngineService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ruleEngineService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ruleEngineService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ruleEngineService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public long[] getMatchesUserSegmentIds(
		javax.servlet.http.HttpServletRequest request, long[] groupIds,
		long anonymousUserId) throws java.lang.Exception {
		return _ruleEngineService.getMatchesUserSegmentIds(request, groupIds,
			anonymousUserId);
	}

	@Override
	public long[] getMatchesUserSegmentIds(
		javax.servlet.http.HttpServletRequest request, long groupId,
		long anonymousUserId) throws java.lang.Exception {
		return _ruleEngineService.getMatchesUserSegmentIds(request, groupId,
			anonymousUserId);
	}

	@Override
	public boolean matches(javax.servlet.http.HttpServletRequest request,
		long anonymousUserId,
		com.liferay.content.targeting.model.UserSegment userSegment)
		throws java.lang.Exception {
		return _ruleEngineService.matches(request, anonymousUserId, userSegment);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RuleEngineService getWrappedRuleEngineService() {
		return _ruleEngineService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRuleEngineService(RuleEngineService ruleEngineService) {
		_ruleEngineService = ruleEngineService;
	}

	@Override
	public RuleEngineService getWrappedService() {
		return _ruleEngineService;
	}

	@Override
	public void setWrappedService(RuleEngineService ruleEngineService) {
		_ruleEngineService = ruleEngineService;
	}

	private RuleEngineService _ruleEngineService;
}