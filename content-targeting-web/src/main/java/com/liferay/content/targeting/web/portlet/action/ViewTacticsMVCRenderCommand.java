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

package com.liferay.content.targeting.web.portlet.action;

import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.VIEW_TACTICS
	},
	service = MVCRenderCommand.class
)
public class ViewTacticsMVCRenderCommand extends BaseMVCRenderCommand {

	@Override
	public String doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		return "/view_tactics.jsp";
	}

}