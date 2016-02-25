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

package com.liferay.content.targeting.portlet.action;

import com.liferay.content.targeting.exception.UsedUserSegmentException;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.UserSegmentService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.DELETE_USER_SEGMENT
	},
	service = MVCActionCommand.class
)
public class DeleteUserSegmentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] deleteUserSegmentIds = null;

		long userSegmentId = ParamUtil.getLong(actionRequest, "userSegmentId");

		if (userSegmentId > 0) {
			deleteUserSegmentIds = new long[] {userSegmentId};
		}
		else {
			deleteUserSegmentIds = ParamUtil.getLongValues(
				actionRequest, "rowIds");
		}

		List<UserSegment> usedUserSegments = new ArrayList<>();

		for (long deleteUserSegmentId : deleteUserSegmentIds) {
			try {
				_userSegmentService.deleteUserSegment(deleteUserSegmentId);
			}
			catch (Exception e) {
				if (!SessionErrors.contains(actionRequest, e.getClass())) {
					SessionErrors.add(actionRequest, e.getClass(), e);
				}

				if (e instanceof UsedUserSegmentException) {
					UserSegment userSegment =
						_userSegmentLocalService.fetchUserSegment(
							deleteUserSegmentId);

					if (userSegment != null) {
						usedUserSegments.add(userSegment);
					}
				}
				else {
					_log.error("Unable to delete user segment", e);

					actionResponse.setRenderParameter(
						"mvcPath", ContentTargetingPath.ERROR);

					return;
				}
			}
		}

		if (!usedUserSegments.isEmpty()) {
			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			SessionMessages.add(
				PortalUtil.getHttpServletRequest(actionRequest),
				"usedUserSegments", usedUserSegments);

			actionResponse.setRenderParameter(
				"mvcPath", ContentTargetingPath.VIEW);
			actionResponse.setRenderParameter("tabs1", "user-segments");
		}
		else {
			sendRedirect(actionRequest, actionResponse);
		}
	}

	@Reference(unbind = "unsetUserSegmentLocalService")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	@Reference(unbind = "unsetUserSegmentService")
	protected void setUserSegmentService(
		UserSegmentService userSegmentService) {

		_userSegmentService = userSegmentService;
	}

	protected void unsetUserSegmentLocalService() {
		_userSegmentLocalService = null;
	}

	protected void unsetUserSegmentService() {
		_userSegmentService = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DeleteUserSegmentMVCActionCommand.class);

	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentService _userSegmentService;

}