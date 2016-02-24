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

package com.liferay.content.targeting.portlet.action;

import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.api.model.TrackingActionsRegistry;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.VIEW_REPORT
	},
	service = MVCRenderCommand.class
)
public class ViewReportMVCActionCommand extends BaseMVCRenderCommand {

	@Override
	public String doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		renderRequest.setAttribute("reportsRegistry", _reportsRegistry);

		renderRequest.setAttribute(
			"trackingActionsRegistry", _trackingActionsRegistry);

		Map<String, Object> templateContext = cloneRequestContext(
			renderRequest, renderResponse);

		renderRequest.setAttribute("templateContext", templateContext);

		return ContentTargetingPath.VIEW_REPORT;
	}

	@Reference(unbind = "unsetReportsRegistry")
	protected void setReportsRegistry(ReportsRegistry reportsRegistry) {
		_reportsRegistry = reportsRegistry;
	}

	@Reference(unbind = "unsetTrackingActionsRegistry")
	protected void setTrackingActionsRegistry(
		TrackingActionsRegistry trackingActionsRegistry) {

		_trackingActionsRegistry = trackingActionsRegistry;
	}

	protected void unsetReportsRegistry() {
		_reportsRegistry = null;
	}

	protected void unsetTrackingActionsRegistry() {
		_trackingActionsRegistry = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ViewReportMVCActionCommand.class);

	private ReportsRegistry _reportsRegistry;
	private TrackingActionsRegistry _trackingActionsRegistry;

}