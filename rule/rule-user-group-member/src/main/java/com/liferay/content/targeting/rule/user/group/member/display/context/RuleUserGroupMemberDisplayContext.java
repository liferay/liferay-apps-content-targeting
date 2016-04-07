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

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleUserGroupMemberDisplayContext extends BaseRuleDisplayContext {

	public RuleUserGroupMemberDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public long getUserGroupId() {
		if (_userGroupId != null) {
			return _userGroupId;
		}

		_userGroupId = GetterUtil.getLong(displayContext.get("userGroupId"));

		return _userGroupId;
	}

	public List<UserGroup> getUserGroups() {
		if (_userGroups != null) {
			return _userGroups;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
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

		PortletURL portletURL = getControlPanelURL(
			PortletKeys.USER_GROUPS_ADMIN);

		_userGroupsAdminURL = portletURL.toString();

		return _userGroupsAdminURL;
	}

	private Long _userGroupId;
	private List<UserGroup> _userGroups;
	private String _userGroupsAdminURL;

}