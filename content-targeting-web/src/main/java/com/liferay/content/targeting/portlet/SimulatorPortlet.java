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

import com.liferay.content.targeting.api.model.UserSegmentSimulator;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;

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
		"com.liferay.portlet.control-panel-entry-category=site_administration.configuration",
		"com.liferay.portlet.control-panel-entry-class=com.liferay.content.targeting.portlet.SimulatorControlPanelEntry",
		"com.liferay.portlet.control-panel-entry-weight=100",
		"com.liferay.portlet.css-class-wrapper=content-targeting-simulator-portlet",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/content_targeting/warning_restart.css",
		"com.liferay.portlet.header-portlet-css=/css/ct_simulator/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/ct_simulator/simulator.js",
		"com.liferay.portlet.icon=/icons/icon.png",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Audience Targeting Simulator" + PortletKeys.CT_SIMULATOR,
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ct_simulator/view.jsp",
		"javax.portlet.name=", "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = {SimulatorPortlet.class, Portlet.class}
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

		if (stopSimulation) {
			_userSegmentSimulator.removeAllUserSegmentIds(
				httpServletRequest, httpServletResponse);

			request.setAttribute(WebKeys.USER_SEGMENT_IDS, null);

			return;
		}

		long[] selectedUserSegmentIds = StringUtil.split(
			ParamUtil.getString(request, "selectedUserSegmentIds"), 0L);

		_userSegmentSimulator.setUserSegmentIds(
			selectedUserSegmentIds, httpServletRequest, httpServletResponse);
	}

	@Reference(unbind = "unsetUserSegmentSimulator")
	protected void setUserSegmentSimulator(
		UserSegmentSimulator userSegmentSimulator) {

		_userSegmentSimulator = userSegmentSimulator;
	}

	protected void unsetUserSegmentSimulator() {
		_userSegmentSimulator = null;
	}

	private UserSegmentSimulator _userSegmentSimulator;

}