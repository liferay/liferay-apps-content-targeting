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

package com.liferay.content.targeting.rule.organization.member.display.context;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleOrganizationMemberDisplayContext {

	public RuleOrganizationMemberDisplayContext(HttpServletRequest request) {
		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public long getOrganizationId() {
		if (_organizationId != null) {
			return _organizationId;
		}

		_organizationId = GetterUtil.getLong(
			_displayContext.get("organizationId"));

		return _organizationId;
	}

	public List<Organization> getOrganizations() {
		if (_organizations != null) {
			return _organizations;
		}

		_organizations = (List<Organization>)_displayContext.get(
			"organizations");

		return _organizations;
	}

	public String getUsersAdminURL() {
		if (_usersAdminURL != null) {
			return _usersAdminURL;
		}

		_usersAdminURL = GetterUtil.getString(
			_displayContext.get("usersAdminURL"));

		return _usersAdminURL;
	}

	private final Map<String, Object> _displayContext;
	private Long _organizationId;
	private List<Organization> _organizations;
	private String _usersAdminURL;

}