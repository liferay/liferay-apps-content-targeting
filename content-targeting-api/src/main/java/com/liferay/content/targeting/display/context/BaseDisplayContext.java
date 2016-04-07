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

package com.liferay.content.targeting.display.context;

import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.site.admin.web.constants.SiteAdminPortletKeys;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class BaseDisplayContext {

	public BaseDisplayContext(HttpServletRequest request) {
		this.request = request;

		displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public PortletURL getControlPanelURL(String portletId) {
		if (!hasControlPanelAccessPermission(portletId)) {
			return null;
		}

		return PortalUtil.getControlPanelPortletURL(
			request, portletId, PortletRequest.RENDER_PHASE);
	}

	public String getPortalSettingsURL() {
		PortletURL portletURL = getControlPanelURL(PortletKeys.PORTAL_SETTINGS);

		return portletURL.toString();
	}

	public String getSiteSettingsURL() {
		PortletURL portletURL = getControlPanelURL(
			SiteAdminPortletKeys.SITE_SETTINGS);

		return portletURL.toString();
	}

	protected boolean hasControlPanelAccessPermission(String portletId) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (PortletPermissionUtil.hasControlPanelAccessPermission(
					themeDisplay.getPermissionChecker(),
					themeDisplay.getScopeGroupId(), portletId)) {

				return true;
			}
		}
		catch (PortalException pe) {
		}

		return false;
	}

	protected final Map<String, Object> displayContext;
	protected final HttpServletRequest request;

}