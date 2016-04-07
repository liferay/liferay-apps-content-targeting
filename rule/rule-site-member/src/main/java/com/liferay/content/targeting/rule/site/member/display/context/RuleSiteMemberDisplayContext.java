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

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleSiteMemberDisplayContext extends BaseRuleDisplayContext {

	public RuleSiteMemberDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public long getSiteId() {
		if (_siteId != null) {
			return _siteId;
		}

		_siteId = GetterUtil.getLong(displayContext.get("siteId"));

		return _siteId;
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

	private Long _siteId;
	private List<Group> _sites;
	private String _sitesAdminURL;

}