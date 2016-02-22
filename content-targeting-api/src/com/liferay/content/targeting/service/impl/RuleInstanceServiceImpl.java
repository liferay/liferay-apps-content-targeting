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

import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.base.RuleInstanceServiceBaseImpl;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the rule instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.RuleInstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.RuleInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.RuleInstanceServiceUtil
 */
public class RuleInstanceServiceImpl extends RuleInstanceServiceBaseImpl {

	@Override
	public RuleInstance addRuleInstance(
			long userId, String ruleKey, long userSegmentId,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.UPDATE);

		return ruleInstanceLocalService.addRuleInstance(
			userId, ruleKey, userSegmentId, typeSettings, serviceContext);
	}

	@Override
	public RuleInstance deleteRuleInstance(long ruleInstanceId)
		throws PortalException {

		RuleInstance ruleInstance = ruleInstanceLocalService.getRuleInstance(
			ruleInstanceId);

		UserSegmentPermission.check(
			getPermissionChecker(), ruleInstance.getUserSegmentId(),
			ActionKeys.UPDATE);

		return ruleInstanceLocalService.deleteRuleInstance(ruleInstanceId);
	}

	@Override
	public List<RuleInstance> getRuleInstances(long userSegmentId) {
		return ruleInstanceLocalService.getRuleInstances(userSegmentId);
	}

	@Override
	public long getRuleInstancesCount(long userSegmentId)
		throws PortalException {

		return ruleInstanceLocalService.getRuleInstancesCount(userSegmentId);
	}

	@Override
	public RuleInstance updateRuleInstance(
			long ruleInstanceId, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		RuleInstance ruleInstance = ruleInstanceLocalService.getRuleInstance(
			ruleInstanceId);

		UserSegmentPermission.check(
			getPermissionChecker(), ruleInstance.getUserSegmentId(),
			ActionKeys.UPDATE);

		return ruleInstanceLocalService.updateRuleInstance(
			ruleInstanceId, typeSettings, serviceContext);
	}

}