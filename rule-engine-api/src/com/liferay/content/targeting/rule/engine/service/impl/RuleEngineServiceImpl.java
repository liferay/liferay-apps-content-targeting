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

package com.liferay.content.targeting.rule.engine.service.impl;

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.engine.service.base.RuleEngineServiceBaseImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * The implementation of the rule engine remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.rule.engine.service.RuleEngineService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.engine.service.base.RuleEngineServiceBaseImpl
 * @see com.liferay.content.targeting.rule.engine.service.RuleEngineServiceUtil
 */
public class RuleEngineServiceImpl extends RuleEngineServiceBaseImpl {

	@Override
	public long[] getMatchesUserSegmentIds(
			HttpServletRequest request, long groupId, long anonymousUserId)
		throws Exception {

		// TODO: Permission check

		return ruleEngineLocalService.getMatchesUserSegmentIds(
			request, groupId, anonymousUserId);
	}

	@Override
	public long[] getMatchesUserSegmentIds(
			HttpServletRequest request, long[] groupIds, long anonymousUserId)
		throws Exception {

		// TODO: Permission check

		return ruleEngineLocalService.getMatchesUserSegmentIds(
			request, groupIds, anonymousUserId);
	}

	@Override
	public boolean matches(
			HttpServletRequest request, long anonymousUserId,
			UserSegment userSegment)
		throws Exception {

		// TODO: Permission check

		return ruleEngineLocalService.matches(
			request, anonymousUserId, userSegment);
	}

}