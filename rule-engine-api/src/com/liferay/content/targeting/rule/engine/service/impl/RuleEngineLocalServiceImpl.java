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

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.api.model.RulesEngine;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.engine.service.base.RuleEngineLocalServiceBaseImpl;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the rule engine local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.rule.engine.service.RuleEngineLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.engine.service.base.RuleEngineLocalServiceBaseImpl
 * @see com.liferay.content.targeting.rule.engine.service.RuleEngineLocalServiceUtil
 */
public class RuleEngineLocalServiceImpl extends RuleEngineLocalServiceBaseImpl {

	public RuleEngineLocalServiceImpl() {
		_initRulesEngine();
	}

	@Override
	public long[] getMatchesUserSegmentIds(
			HttpServletRequest request, long groupId, long anonymousUserId)
		throws Exception {

		long[] groupIds = ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
			groupId);

		return getMatchesUserSegmentIds(request, groupIds, anonymousUserId);
	}

	@Override
	public long[] getMatchesUserSegmentIds(
			HttpServletRequest request, long[] groupIds, long anonymousUserId)
		throws Exception {

		if (ArrayUtil.isEmpty(groupIds)) {
			return null;
		}

		// TODO: try to find in cache

		List<Long> userSegmentIds = new ArrayList<Long>();

		List<UserSegment> userSegments =
			UserSegmentLocalServiceUtil.getUserSegments(groupIds);

		for (UserSegment userSegment : userSegments) {
			if (matches(request, anonymousUserId, userSegment)) {
				userSegmentIds.add(userSegment.getUserSegmentId());
			}
		}

		// TODO: add to cache

		return ArrayUtil.toLongArray(userSegmentIds);
	}

	@Override
	public boolean matches(
			HttpServletRequest request, long anonymousUserId,
			UserSegment userSegment)
		throws Exception {

		AnonymousUser anonymousUser =
			AnonymousUserLocalServiceUtil.getAnonymousUser(anonymousUserId);

		return _rulesEngine.matches(
			request, anonymousUser, userSegment.getRuleInstances());
	}

	private void _initRulesEngine() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_rulesEngine = ServiceTrackerUtil.getService(
			RulesEngine.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		RuleEngineLocalServiceImpl.class);

	private RulesEngine _rulesEngine;

}