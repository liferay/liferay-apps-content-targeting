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

package com.liferay.content.targeting.simulation.web.portlet;

import com.liferay.content.targeting.api.model.UserSegmentSimulator;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=content-targeting-simulator-portlet",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.icon=/icons/icon.png",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Audience Targeting Simulator",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PortletKeys.CT_SIMULATOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class SimulatorPortlet extends MVCPortlet {

	public void simulateUserSegment(
			ActionRequest request, ActionResponse response)
		throws Exception {

		HttpServletRequest httpServletRequest =
			PortalUtil.getHttpServletRequest(request);

		HttpServletResponse httpServletResponse =
			PortalUtil.getHttpServletResponse(response);

		boolean stopSimulation = ParamUtil.getBoolean(
			request, "stopSimulation");

		_userSegmentSimulator.removeAllUserSegmentIds(
			httpServletRequest, httpServletResponse);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		JSONPortletResponseUtil.writeJSON(request, response, jsonObject);

		if (stopSimulation) {
			request.setAttribute(WebKeys.USER_SEGMENT_IDS, null);

			return;
		}
		else {
			long[] selectedUserSegmentIds = ParamUtil.getLongValues(
				request, "selectedUserSegmentIds");

			_userSegmentSimulator.setUserSegmentIds(
				selectedUserSegmentIds, httpServletRequest,
				httpServletResponse);
		}
	}

	@Reference
	protected void setUserSegmentSimulator(
		UserSegmentSimulator userSegmentSimulator) {

		_userSegmentSimulator = userSegmentSimulator;
	}

	protected void unsetUserSegmentSimulator(
		UserSegmentSimulator userSegmentSimulator) {

		_userSegmentSimulator = null;
	}

	private UserSegmentSimulator _userSegmentSimulator;

}