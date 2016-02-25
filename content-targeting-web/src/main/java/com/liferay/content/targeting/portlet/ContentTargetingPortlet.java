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

import com.liferay.content.targeting.api.model.Channel;
import com.liferay.content.targeting.api.model.ChannelsRegistry;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 * @author Carlos Sierra Andrés
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=content-targeting-portlet",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/content_targeting/main.css",
		"com.liferay.portlet.header-portlet-css=/css/content_targeting/rules_panel.css",
		"com.liferay.portlet.header-portlet-css=/css/content_targeting/warning_restart.css",
		"com.liferay.portlet.header-portlet-javascript=/js/content_targeting/input_slider.js",
		"com.liferay.portlet.header-portlet-javascript=/js/content_targeting/search.js",
		"com.liferay.portlet.header-portlet-javascript=/js/content_targeting/ct_form_builder.js",
		"com.liferay.portlet.icon=/icons/icon.png",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Audience Targeting",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.copy-request-parameters=true",
		"javax.portlet.init-param.mvc-action-command-package-prefix=com.liferay.content.targeting.portlet.action",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/content_targeting/view.jsp",
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class ContentTargetingPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		Map<String, Channel> channels = _channelsRegistry.getChannels();

		Map<String, Report> reports = _reportsRegistry.getReports();

		renderRequest.setAttribute("channelsCount", channels.size());
		renderRequest.setAttribute("reportsCount", reports.size());

		super.render(renderRequest, renderResponse);
	}

	@Reference(unbind = "unsetChannelsRegistry")
	protected void setChannelsRegistry(ChannelsRegistry channelsRegistry) {
		_channelsRegistry = channelsRegistry;
	}

	@Reference(unbind = "unsetReportsRegistry")
	protected void setReportsRegistry(ReportsRegistry reportsRegistry) {
		_reportsRegistry = reportsRegistry;
	}

	protected void unsetChannelsRegistry() {
		_channelsRegistry = null;
	}

	protected void unsetReportsRegistry() {
		_reportsRegistry = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ContentTargetingPortlet.class);

	private ChannelsRegistry _channelsRegistry;
	private ReportsRegistry _reportsRegistry;

}