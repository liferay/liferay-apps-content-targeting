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

import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.base.RuleInstanceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the rule instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.RuleInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.RuleInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil
 */
public class RuleInstanceLocalServiceImpl
	extends RuleInstanceLocalServiceBaseImpl {

	@Override
	public RuleInstance addRuleInstance(
			long userId, String ruleKey, long userSegmentId,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		Date now = new Date();

		long ruleInstanceId = counterLocalService.increment();

		RuleInstance ruleInstance = ruleInstancePersistence.create(
			ruleInstanceId);

		ruleInstance.setUuid(serviceContext.getUuid());
		ruleInstance.setGroupId(serviceContext.getScopeGroupId());
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

	@Indexable(type = IndexableType.DELETE)
	@Override
	public RuleInstance deleteRuleInstance(long ruleInstanceId)
		throws PortalException {

		RuleInstance ruleInstance = ruleInstancePersistence.findByPrimaryKey(
			ruleInstanceId);

		return deleteRuleInstance(ruleInstance);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public RuleInstance deleteRuleInstance(RuleInstance ruleInstance)
		throws PortalException {

		ruleInstancePersistence.remove(ruleInstance);

		// System event

		systemEventLocalService.addSystemEvent(
			0, ruleInstance.getGroupId(), RuleInstance.class.getName(),
			ruleInstance.getRuleInstanceId(), ruleInstance.getUuid(), null,
			SystemEventConstants.TYPE_DELETE, StringPool.BLANK);

		// Rule data

		Rule rule = rulesRegistry.getRule(ruleInstance.getRuleKey());

		if (rule != null) {
			try {
				rule.deleteData(ruleInstance);
			}
			catch (Exception e) {
				_log.error(
					"Cannot delete custom data for rule " +
						rule.getName(LocaleUtil.getDefault()),
					e);
			}
		}

		return ruleInstance;
	}

	@Override
	public List<RuleInstance> getRuleInstances(long userSegmentId) {
		return ruleInstancePersistence.findByUserSegmentId(userSegmentId);
	}

	@Override
	public List<RuleInstance> getRuleInstances(
		String ruleKey, long userSegmentId) {

		return ruleInstancePersistence.findByR_U(ruleKey, userSegmentId);
	}

	@Override
	public long getRuleInstancesCount(long userSegmentId)
		throws PortalException {

		return ruleInstancePersistence.countByUserSegmentId(userSegmentId);
	}

	@Override
	public long getRuleInstancesCount(String ruleKey, long userSegmentId)
		throws PortalException {

		return ruleInstancePersistence.countByR_U(ruleKey, userSegmentId);
	}

	@Override
	public RuleInstance updateRuleInstance(
			long ruleInstanceId, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		RuleInstance ruleInstance = ruleInstancePersistence.findByPrimaryKey(
			ruleInstanceId);

		ruleInstance.setModifiedDate(serviceContext.getModifiedDate(now));
		ruleInstance.setTypeSettings(typeSettings);

		ruleInstancePersistence.update(ruleInstance);

		return ruleInstance;
	}

	@ServiceReference(type = RulesRegistry.class)
	protected RulesRegistry rulesRegistry;

	private static final Log _log = LogFactoryUtil.getLog(
		RuleInstanceLocalServiceImpl.class);

}