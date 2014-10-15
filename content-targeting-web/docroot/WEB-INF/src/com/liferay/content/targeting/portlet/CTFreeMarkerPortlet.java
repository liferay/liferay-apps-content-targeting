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

package com.liferay.content.targeting.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * This class contains specific logic for the Content Targeting FreeMarker
 * portlets
 *
 * @author Eduardo Garcia
 */
public class CTFreeMarkerPortlet extends FreeMarkerPortlet {

	protected Map<String, Object> cloneTemplateContext(Template template) {
		Map<String, Object> context = new HashMap<String, Object>();

		for (String key : template.getKeys()) {
			context.put(key, template.get(key));
		}

		return context;
	}

	protected void doPopulateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {
	}

	@Override
	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		doPopulateContext(path, portletRequest, portletResponse, template);
	}

	private static Log _log = LogFactoryUtil.getLog(CTFreeMarkerPortlet.class);

}