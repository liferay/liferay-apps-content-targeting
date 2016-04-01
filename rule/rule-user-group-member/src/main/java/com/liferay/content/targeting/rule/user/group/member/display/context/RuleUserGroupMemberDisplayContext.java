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

package com.liferay.content.targeting.rule.user.group.member.display.context;

import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleUserGroupMemberDisplayContext {

	public RuleUserGroupMemberDisplayContext(
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request) {

		_liferayPortletResponse = liferayPortletResponse;
		_request = request;

		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public long getUserGroupId() {
		if (_userGroupId != null) {
			return _userGroupId;
		}

		_userGroupId = GetterUtil.getLong(_displayContext.get("userGroupId"));

		return _userGroupId;
	}

	public List<UserGroup> getUserGroups() {
		if (_userGroups != null) {
			return _userGroups;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		// See LPS-55480

		_userGroups = UserGroupLocalServiceUtil.getUserGroups(
			themeDisplay.getCompanyId());

		return _userGroups;
	}

	public String getUserGroupsAdminURL() {
		if (_userGroupsAdminURL != null) {
			return _userGroupsAdminURL;
		}

		_userGroupsAdminURL = StringPool.BLANK;

		if (ListUtil.isNotEmpty(getUserGroups())) {
			return _userGroupsAdminURL;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (!PortletPermissionUtil.hasControlPanelAccessPermission(
					themeDisplay.getPermissionChecker(),
					themeDisplay.getScopeGroupId(),
					PortletKeys.USER_GROUPS_ADMIN)) {

				return _userGroupsAdminURL;
			}

			PortletURL portletURL =
				_liferayPortletResponse.createLiferayPortletURL(
					PortalUtil.getControlPanelPlid(themeDisplay.getCompanyId()),
					PortletKeys.USER_GROUPS_ADMIN, PortletRequest.RENDER_PHASE,
					false);

			_userGroupsAdminURL = portletURL.toString();
		}
		catch (PortalException pe) {
		}

		return _userGroupsAdminURL;
	}

	private final Map<String, Object> _displayContext;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final HttpServletRequest _request;
	private Long _userGroupId;
	private List<UserGroup> _userGroups;
	private String _userGroupsAdminURL;

}