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

package com.liferay.content.targeting.rule.site.member.display.context;

import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleSiteMemberDisplayContext {

	public RuleSiteMemberDisplayContext(
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request) {

		_liferayPortletResponse = liferayPortletResponse;
		_request = request;

		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
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

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
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

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (!PortletPermissionUtil.hasControlPanelAccessPermission(
					themeDisplay.getPermissionChecker(),
					themeDisplay.getScopeGroupId(), PortletKeys.SITE_ADMIN)) {

				return _sitesAdminURL;
			}

			PortletURL portletURL =
				_liferayPortletResponse.createLiferayPortletURL(
					PortalUtil.getControlPanelPlid(themeDisplay.getCompanyId()),
					PortletKeys.SITE_ADMIN, PortletRequest.RENDER_PHASE, false);

			_sitesAdminURL = portletURL.toString();
		}
		catch (PortalException pe) {
		}

		return _sitesAdminURL;
	}

	private final Map<String, Object> _displayContext;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final HttpServletRequest _request;
	private Long _siteId;
	private List<Group> _sites;
	private String _sitesAdminURL;

}