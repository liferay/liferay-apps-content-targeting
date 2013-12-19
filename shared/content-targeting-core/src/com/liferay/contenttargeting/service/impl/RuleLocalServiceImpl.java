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

import com.liferay.contenttargeting.model.Rule;
import com.liferay.contenttargeting.service.base.RuleLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;

/**
 * The implementation of the rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.RuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.service.base.RuleLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.RuleLocalServiceUtil
 */
public class RuleLocalServiceImpl extends RuleLocalServiceBaseImpl {

	@Override
	public Rule addRule(
			long userId, String type, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long ruleId = CounterLocalServiceUtil.increment();

		Rule rule = rulePersistence.create(ruleId);

		rule.setGroupId(groupId);
		rule.setCompanyId(user.getCompanyId());
		rule.setUserId(user.getUserId());
		rule.setUserName(user.getFullName());
		rule.setCreateDate(serviceContext.getCreateDate(now));
		rule.setModifiedDate(serviceContext.getModifiedDate(now));
		rule.setType(type);
		rule.setTypeSettings(typeSettings);

		rulePersistence.update(rule);

		return rule;
	}

	@Override
	public Rule deleteRule(long ruleId)
		throws PortalException, SystemException {

		return rulePersistence.remove(ruleId);
	}

	@Override
	public Rule updateRule(
			long ruleId, String type, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		Rule rule = rulePersistence.findByPrimaryKey(ruleId);

		rule.setModifiedDate(serviceContext.getModifiedDate(now));
		rule.setType(type);
		rule.setTypeSettings(typeSettings);

		rulePersistence.update(rule);

		return rule;
	}

}