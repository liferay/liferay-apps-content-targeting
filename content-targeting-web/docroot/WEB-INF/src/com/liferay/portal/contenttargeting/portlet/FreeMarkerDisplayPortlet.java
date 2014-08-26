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

package com.liferay.portal.contenttargeting.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

/**
 * @author Eduardo Garcia
 */
public class FreeMarkerDisplayPortlet extends FreeMarkerPortlet {

	protected void updatePreferences(
			ActionRequest request, ActionResponse response,
			PortletPreferences portletPreferences)
		throws Exception {

		UnicodeProperties properties = PropertiesParamUtil.getProperties(
			request, DefaultConfigurationAction.PREFERENCES_PREFIX);

		for (Map.Entry<String, String> entry : properties.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();

			portletPreferences.setValue(name, value);
		}

		portletPreferences.store();
	}

	private static Log _log = LogFactoryUtil.getLog(
		FreeMarkerDisplayPortlet.class);

}