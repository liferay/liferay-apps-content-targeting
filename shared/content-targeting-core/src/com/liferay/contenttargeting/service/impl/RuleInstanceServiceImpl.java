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

import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.service.base.RuleInstanceServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the rule instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.RuleInstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.service.base.RuleInstanceServiceBaseImpl
 * @see com.liferay.contenttargeting.service.RuleInstanceServiceUtil
 */
public class RuleInstanceServiceImpl extends RuleInstanceServiceBaseImpl {

	@Override
	public RuleInstance addRuleInstance(
			long userId, String ruleKey, long userSegmentId,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return ruleInstanceLocalService.addRuleInstance(
				userId, ruleKey, userSegmentId, typeSettings, serviceContext);
	}

	@Override
	public RuleInstance deleteRuleInstance(long ruleInstanceId)
		throws PortalException, SystemException {

		return ruleInstanceLocalService.deleteRuleInstance(ruleInstanceId);
	}

	@Override
	public List<RuleInstance> getRuleInstances(long userSegmentId)
		throws SystemException {

		return ruleInstanceLocalService.getRuleInstances(userSegmentId);
	}

	@Override
	public long getRuleInstancesCount(long userSegmentId)
		throws PortalException, SystemException {

		return ruleInstanceLocalService.getRuleInstancesCount(userSegmentId);
	}

	@Override
	public RuleInstance updateRuleInstance(
			long ruleInstanceId, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		return ruleInstanceLocalService.updateRuleInstance(
			ruleInstanceId, typeSettings, serviceContext);
	}

}