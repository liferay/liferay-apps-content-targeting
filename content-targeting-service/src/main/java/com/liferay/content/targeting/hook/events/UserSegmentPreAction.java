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

package com.liferay.content.targeting.hook.events;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.util.AnonymousUsersManager;
import com.liferay.content.targeting.api.model.RulesEngine;
import com.liferay.content.targeting.api.model.UserSegmentSimulator;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = {"key=servlet.service.events.pre"},
	service = LifecycleAction.class
)
public class UserSegmentPreAction extends Action {

	public long[] getMatchingUserSegmentIds(
			HttpServletRequest request, long[] groupIds,
			AnonymousUser anonymousUser)
		throws Exception {

		if (ArrayUtil.isEmpty(groupIds)) {
			return null;
		}

		List<UserSegment> userSegments =
			_userSegmentLocalService.getUserSegments(groupIds);

		return _rulesEngine.getMatchingUserSegmentIds(
			request, anonymousUser, userSegments);
	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) {
		long[] userSegmentsIds = getUserSegmentIds(request, response);

		if (ArrayUtil.isNotEmpty(userSegmentsIds)) {
			request.setAttribute(WebKeys.USER_SEGMENT_IDS, userSegmentsIds);
		}
	}

	protected long[] getGroupIds(HttpServletRequest request)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
			themeDisplay.getScopeGroupId());
	}

	protected long[] getUserSegmentIds(
		HttpServletRequest request, HttpServletResponse response) {

		long[] userSegmentsIds = null;

		long[] simulatedUserSegmentsIds =
			_userSegmentSimulator.getUserSegmentIds(request, response);

		if (simulatedUserSegmentsIds != null) {
			request.setAttribute(WebKeys.IS_SIMULATED_USER_SEGMENTS, true);

			userSegmentsIds = simulatedUserSegmentsIds;
		}

		try {
			AnonymousUser anonymousUser =
				_anonymousUsersManager.getAnonymousUser(request, response);

			long[] groupIds = getGroupIds(request);

			long[] originalUserSegmentIds = getMatchingUserSegmentIds(
				request, groupIds, anonymousUser);

			if (userSegmentsIds == null) {
				userSegmentsIds = originalUserSegmentIds;
			}

			request.setAttribute(
				WebKeys.ORIGINAL_USER_SEGMENT_IDS, originalUserSegmentIds);
		}
		catch (Exception e) {
			_log.error(
				"Some Audience Targeting services are not available. " +
					"Please restart the server");
		}

		return userSegmentsIds;
	}

	protected void setAnonymousUsersManager() {
		_anonymousUsersManager = null;
	}

	@Reference(unbind = "unsetAnonymousUsersManager")
	protected void setAnonymousUsersManager(
		AnonymousUsersManager anonymousUsersManager) {

		_anonymousUsersManager = anonymousUsersManager;
	}

	@Reference(unbind = "unsetRulesEngine")
	protected void setRulesEngine(RulesEngine rulesEngine) {
		_rulesEngine = rulesEngine;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	@Reference(unbind = "unsetUserSegmentSimulator")
	protected void setUserSegmentSimulator(
		UserSegmentSimulator userSegmentSimulator) {

		_userSegmentSimulator = userSegmentSimulator;
	}

	protected void unsetRulesEngine() {
		_rulesEngine = null;
	}

	protected void unsetUserSegmentSimulator() {
		_userSegmentSimulator = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentPreAction.class);

	private AnonymousUsersManager _anonymousUsersManager;
	private RulesEngine _rulesEngine;
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentSimulator _userSegmentSimulator;

}