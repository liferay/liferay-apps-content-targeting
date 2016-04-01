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

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleSiteMemberDisplayContext {

	public RuleSiteMemberDisplayContext(HttpServletRequest request) {
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

	private final Map<String, Object> _displayContext;
	private Long _siteId;
	private List<Group> _sites;
	private String _sitesAdminURL;

}