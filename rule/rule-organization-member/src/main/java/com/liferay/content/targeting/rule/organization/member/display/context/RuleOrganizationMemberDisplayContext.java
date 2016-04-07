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

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
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
public class RuleOrganizationMemberDisplayContext
	extends BaseRuleDisplayContext {

	public RuleOrganizationMemberDisplayContext(HttpServletRequest request) {
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

	private Long _organizationId;
	private List<Organization> _organizations;
	private String _usersAdminURL;

}