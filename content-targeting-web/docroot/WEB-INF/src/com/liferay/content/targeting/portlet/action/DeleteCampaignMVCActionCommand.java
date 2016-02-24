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

import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.CampaignService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.DELETE_CAMPAIGN
	},
	service = MVCActionCommand.class
)
public class DeleteCampaignMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long[] deleteCampaignsIds = null;

			long campaignId = ParamUtil.getLong(actionRequest, "campaignId");

			if (campaignId > 0) {
				deleteCampaignsIds = new long[] {campaignId};
			}
			else {
				deleteCampaignsIds = StringUtil.split(
					ParamUtil.getString(actionRequest, "campaignsIds"), 0L);
			}

			for (long deleteCampaignId : deleteCampaignsIds) {
				_campaignService.deleteCampaign(deleteCampaignId);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			_log.error("Unable to delete campaign", e);

			SessionErrors.add(actionRequest, e.getClass(), e);

			actionResponse.setRenderParameter(
				"mvcPath", ContentTargetingPath.ERROR);
		}
	}

	@Reference(unbind = "unsetCampaignService")
	protected void setCampaignService(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	protected void unsetCampaignService() {
		_campaignService = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DeleteCampaignMVCActionCommand.class);

	private CampaignService _campaignService;

}