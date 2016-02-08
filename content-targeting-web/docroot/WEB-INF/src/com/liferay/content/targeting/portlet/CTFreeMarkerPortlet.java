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

import com.liferay.content.targeting.portlet.util.UnavailableServiceException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * This class contains specific logic for the Content Targeting FreeMarker
 * portlets
 *
 * @author Eduardo Garcia
 */
public class CTFreeMarkerPortlet extends FreeMarkerPortlet {

	protected Map<String, Object> cloneTemplateContext(Template template) {
		Map<String, Object> context = new HashMap<>();

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

		if (path.equals(ContentTargetingPath.ADD_ASSET_REDIRECT)) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)portletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			Portlet selPortlet = PortletLocalServiceUtil.getPortletById(
				themeDisplay.getCompanyId(), portletDisplay.getId());

			template.put("selPortlet", selPortlet);
			template.put(
				"redirect", ParamUtil.getString(portletRequest, "redirect"));
		}
		else if (!path.equals(ContentTargetingPath.ERROR) &&
				 !path.equals(ContentTargetingPath.WARNING_RESTART)) {

			try {
				doPopulateContext(
					path, portletRequest, portletResponse, template);
			}
			catch (UnavailableServiceException use) {
				HttpServletResponse response =
					PortalUtil.getHttpServletResponse(portletResponse);

				PortletURL portletURL =
					((RenderResponse)portletResponse).createRenderURL();

				portletURL.setParameter(
					"mvcPath", ContentTargetingPath.WARNING_RESTART);

				response.sendRedirect(portletURL.toString());
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CTFreeMarkerPortlet.class);

}