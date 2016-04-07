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

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleRoleDisplayContext extends BaseRuleDisplayContext {

	public RuleRoleDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public long getOrganizationId() {
		if (_organizationId != null) {
			return _organizationId;
		}

		_organizationId = GetterUtil.getLong(
			displayContext.get("organizationId"));

		return _organizationId;
	}

	public List<Role> getOrganizationRoles() {
		return getRoles(
			new int[] {RoleConstants.TYPE_ORGANIZATION},
			RoleConstants.ORGANIZATION_USER);
	}

	public List<Organization> getOrganizations() {
		if (_organizations != null) {
			return _organizations;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		// See LPS-50218

		_organizations = OrganizationLocalServiceUtil.getOrganizations(
			themeDisplay.getCompanyId(),
			OrganizationConstants.ANY_PARENT_ORGANIZATION_ID);

		return _organizations;
	}

	public List<Role> getRegularRoles() {
		return getRoles(new int[] {RoleConstants.TYPE_REGULAR}, null);
	}

	public long getRoleId() {
		if (_roleId != null) {
			return _roleId;
		}

		_roleId = GetterUtil.getLong(displayContext.get("roleId"));

		return _roleId;
	}

	public long getSiteId() {
		if (_siteId != null) {
			return _siteId;
		}

		_siteId = GetterUtil.getLong(displayContext.get("siteId"));

		return _siteId;
	}

	public List<Role> getSiteRoles() {
		return getRoles(
			new int[] {RoleConstants.TYPE_SITE}, RoleConstants.SITE_MEMBER);
	}

	public List<Group> getSites() {
		if (_sites != null) {
			return _sites;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			_sites = GroupServiceUtil.getGroups(
				themeDisplay.getCompanyId(), GroupConstants.ANY_PARENT_GROUP_ID,
				true);
		}
		catch (PortalException pe) {
			return Collections.emptyList();
		}

		return _sites;
	}

	public String getSitesAdminURL() {
		if (_sitesAdminURL != null) {
			return _sitesAdminURL;
		}

		_sitesAdminURL = StringPool.BLANK;

		if (ListUtil.isNotEmpty(getSites())) {
			return _sitesAdminURL;
		}

		PortletURL portletURL = getControlPanelURL(PortletKeys.SITE_ADMIN);

		_sitesAdminURL = portletURL.toString();

		return _sitesAdminURL;
	}

	public String getUsersAdminURL() {
		if (_usersAdminURL != null) {
			return _usersAdminURL;
		}

		_usersAdminURL = StringPool.BLANK;

		if (ListUtil.isNotEmpty(getOrganizations())) {
			return _usersAdminURL;
		}

		PortletURL portletURL = getControlPanelURL(PortletKeys.USERS_ADMIN);

		_usersAdminURL = portletURL.toString();

		return _usersAdminURL;
	}

	protected List<Role> getRoles(int[] types, String name) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		List<Role> roles = RoleLocalServiceUtil.getRoles(
			themeDisplay.getCompanyId(), types);

		if (Validator.isNull(name)) {
			return roles;
		}

		Role role = RoleLocalServiceUtil.fetchRole(
			themeDisplay.getCompanyId(), name);

		List<Role> removeRoles = new ArrayList<>();

		removeRoles.add(role);

		return ListUtil.remove(roles, removeRoles);
	}

	private Long _organizationId;
	private List<Organization> _organizations;
	private Long _roleId;
	private Long _siteId;
	private List<Group> _sites;
	private String _sitesAdminURL;
	private String _usersAdminURL;

}