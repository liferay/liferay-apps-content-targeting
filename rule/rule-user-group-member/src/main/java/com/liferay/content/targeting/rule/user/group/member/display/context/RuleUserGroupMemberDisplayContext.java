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

import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleUserGroupMemberDisplayContext {

	public RuleUserGroupMemberDisplayContext(HttpServletRequest request) {
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

		_userGroups = (List<UserGroup>)_displayContext.get("userGroups");

		return _userGroups;
	}

	public String getUserGroupsAdminURL() {
		if (_userGroupsAdminURL != null) {
			return _userGroupsAdminURL;
		}

		_userGroupsAdminURL = GetterUtil.getString(
			_displayContext.get("userGroupsAdminURL"));

		return _userGroupsAdminURL;
	}

	private final Map<String, Object> _displayContext;
	private Long _userGroupId;
	private List<UserGroup> _userGroups;
	private String _userGroupsAdminURL;

}