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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RuleInstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstanceService
 * @generated
 */
@ProviderType
public class RuleInstanceServiceWrapper implements RuleInstanceService,
	ServiceWrapper<RuleInstanceService> {
	public RuleInstanceServiceWrapper(RuleInstanceService ruleInstanceService) {
		_ruleInstanceService = ruleInstanceService;
	}

	@Override
	public com.liferay.content.targeting.model.RuleInstance addRuleInstance(
		long userId, java.lang.String ruleKey, long userSegmentId,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceService.addRuleInstance(userId, ruleKey,
			userSegmentId, typeSettings, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.RuleInstance deleteRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceService.deleteRuleInstance(ruleInstanceId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _ruleInstanceService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		long userSegmentId) {
		return _ruleInstanceService.getRuleInstances(userSegmentId);
	}

	@Override
	public long getRuleInstancesCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceService.getRuleInstancesCount(userSegmentId);
	}

	@Override
	public com.liferay.content.targeting.model.RuleInstance updateRuleInstance(
		long ruleInstanceId, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceService.updateRuleInstance(ruleInstanceId,
			typeSettings, serviceContext);
	}

	@Override
	public RuleInstanceService getWrappedService() {
		return _ruleInstanceService;
	}

	@Override
	public void setWrappedService(RuleInstanceService ruleInstanceService) {
		_ruleInstanceService = ruleInstanceService;
	}

	private RuleInstanceService _ruleInstanceService;
}