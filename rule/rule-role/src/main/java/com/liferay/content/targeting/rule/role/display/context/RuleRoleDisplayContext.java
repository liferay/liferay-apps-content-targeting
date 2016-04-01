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

package com.liferay.content.targeting.rule.role.display.context;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleRoleDisplayContext {

	public RuleRoleDisplayContext(HttpServletRequest request) {
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

	public long getRoleId() {
		if (_roleId != null) {
			return _roleId;
		}

		_roleId = GetterUtil.getLong(_displayContext.get("roleId"));

		return _roleId;
	}

	public List<Role> getRoles() {
		if (_roles != null) {
			return _roles;
		}

		_roles = (List<Role>)_displayContext.get("roles");

		return _roles;
	}

	public long getSiteId() {
		if (_siteId != null) {
			return _siteId;
		}

		_siteId = GetterUtil.getLong(_displayContext.get("siteId"));

		return _siteId;
	}

	public List<Group> getSites() {
		if (_sites != null) {
			return _sites;
		}

		_sites = (List<Group>)_displayContext.get("sites");

		return _sites;
	}

	public String getSitesAdminURL() {
		if (_sitesAdminURL != null) {
			return _sitesAdminURL;
		}

		_sitesAdminURL = GetterUtil.getString(
			_displayContext.get("sitesAdminURL"));

		return _sitesAdminURL;
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
	private Long _roleId;
	private List<Role> _roles;
	private Long _siteId;
	private List<Group> _sites;
	private String _sitesAdminURL;
	private String _usersAdminURL;

}