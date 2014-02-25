/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
import com.liferay.contenttargeting.service.base.RuleInstanceLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the rule instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.RuleInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.service.base.RuleInstanceLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.RuleInstanceLocalServiceUtil
 */
public class RuleInstanceLocalServiceImpl
	extends RuleInstanceLocalServiceBaseImpl {

	@Override
	public RuleInstance addRuleInstance(
			long userId, String ruleKey, long userSegmentId,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long ruleInstanceId = CounterLocalServiceUtil.increment();

		RuleInstance ruleInstance = ruleInstancePersistence.create(
			ruleInstanceId);

		ruleInstance.setGroupId(groupId);

		ruleInstance.setCompanyId(user.getCompanyId());
		ruleInstance.setUserId(user.getUserId());
		ruleInstance.setUserName(user.getFullName());
		ruleInstance.setCreateDate(serviceContext.getCreateDate(now));
		ruleInstance.setModifiedDate(serviceContext.getModifiedDate(now));
		ruleInstance.setRuleKey(ruleKey);
		ruleInstance.setUserSegmentId(userSegmentId);
		ruleInstance.setTypeSettings(typeSettings);

		ruleInstancePersistence.update(ruleInstance);

		return ruleInstance;
	}

	@Override
	public List<RuleInstance> getRuleInstances(long userSegmentId)
		throws SystemException {

		return ruleInstancePersistence.findByUserSegmentId(userSegmentId);
	}

	@Override
	public List<RuleInstance> getRuleInstances(
			String ruleKey, long userSegmentId)
		throws SystemException {

		return ruleInstancePersistence.findByR_U(ruleKey, userSegmentId);
	}

	@Override
	public long getRuleInstancesCount(long userSegmentId)
		throws PortalException, SystemException {

		return ruleInstancePersistence.countByUserSegmentId(userSegmentId);
	}

	@Override
	public long getRuleInstancesCount(String ruleKey, long userSegmentId)
		throws PortalException, SystemException {

		return ruleInstancePersistence.countByR_U(ruleKey, userSegmentId);
	}

	@Override
	public RuleInstance updateRuleInstance(
			long ruleInstanceId, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		RuleInstance ruleInstance = ruleInstancePersistence.findByPrimaryKey(
			ruleInstanceId);

		ruleInstance.setModifiedDate(serviceContext.getModifiedDate(now));
		ruleInstance.setTypeSettings(typeSettings);

		ruleInstancePersistence.update(ruleInstance);

		return ruleInstance;
	}

}