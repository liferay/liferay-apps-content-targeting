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

package com.liferay.portal.contenttargeting.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortletPermissionUtil;

import java.util.Map;

/**
 * @author Julio Camarero
 */
public class ContentTargetingRuleUtil {

	public static boolean hasControlPanelPortletViewPermission(
		Map<String, Object> context, String portletId) {

		PermissionChecker permissionChecker = (PermissionChecker)context.get(
			"permissionChecker");

		try {
			return PortletPermissionUtil.contains(
				permissionChecker, 0, LayoutConstants.DEFAULT_PLID, portletId,
				ActionKeys.ACCESS_IN_CONTROL_PANEL, true);
		}
		catch (Exception e) {
			_log.error(e);
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ContentTargetingRuleUtil.class);

}