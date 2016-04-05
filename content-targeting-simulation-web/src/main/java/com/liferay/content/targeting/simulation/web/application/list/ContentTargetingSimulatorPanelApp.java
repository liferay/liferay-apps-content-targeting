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

package com.liferay.content.targeting.simulation.web.application.list;

import com.liferay.application.list.BaseJSPPanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.content.targeting.api.model.UserSegmentSimulator;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.GroupPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.product.navigation.simulation.application.list.SimulationPanelCategory;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=110",
		"panel.category.key=" + SimulationPanelCategory.SIMULATION
	},
	service = PanelApp.class
)
public class ContentTargetingSimulatorPanelApp extends BaseJSPPanelApp {

	@Override
	public String getJspPath() {
		return "/view.jsp";
	}

	@Override
	public String getPortletId() {
		return PortletKeys.CT_SIMULATOR;
	}

	@Override
	public boolean include(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		try {
			populateContext(request, response);
		}
		catch (Exception e) {
			_log.error("Error obtaining simulation data", e);
		}

		return super.include(request, response);
	}

	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group)
		throws PortalException {

		if (group.isControlPanel()) {
			return false;
		}

		if (!hasPreviewInDevicePermission(permissionChecker, group)) {
			return false;
		}

		return super.isShow(permissionChecker, group);
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + PortletKeys.CT_SIMULATOR + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.simulation.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);

		_simulatorServletContext = servletContext;
	}

	protected boolean hasPreviewInDevicePermission(
			PermissionChecker permissionChecker, Group group)
		throws PortalException {

		return GroupPermissionUtil.contains(
			permissionChecker, group, ActionKeys.PREVIEW_IN_DEVICE);
	}

	protected void populateContext(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		long[] originalUserSegmentIds = (long[])request.getAttribute(
			WebKeys.ORIGINAL_USER_SEGMENT_IDS);

		long[] simulatedUserSegmentIds =
			_userSegmentSimulator.getUserSegmentIds(request, response);

		if (simulatedUserSegmentIds == null) {
			simulatedUserSegmentIds = originalUserSegmentIds;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		long[] groupIds = ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
			themeDisplay.getSiteGroupId());

		List<Campaign> campaigns = _campaignLocalService.getCampaigns(
			groupIds, simulatedUserSegmentIds);

		request.setAttribute("campaigns", campaigns);

		List<Campaign> availableCampaigns = _campaignLocalService.getCampaigns(
			groupIds);

		List<Campaign> notMatchedCampaigns = new ArrayList<>();

		for (Campaign campaign : availableCampaigns) {
			if (!campaigns.contains(campaign)) {
				notMatchedCampaigns.add(campaign);
			}
		}

		request.setAttribute("notMatchedCampaigns", notMatchedCampaigns);

		boolean showCampaignsSearch = false;

		if ((notMatchedCampaigns.size() + campaigns.size()) >
				_SHOW_SEARCH_LIMIT) {

			showCampaignsSearch = true;
		}

		request.setAttribute("showCampaignsSearch", showCampaignsSearch);

		boolean isSimulatedUserSegments = GetterUtil.getBoolean(
			request.getAttribute(WebKeys.IS_SIMULATED_USER_SEGMENTS));

		request.setAttribute(
			"isSimulatedUserSegments", isSimulatedUserSegments);

		List<UserSegment> userSegments = new ArrayList<>();

		if (originalUserSegmentIds != null) {
			for (long userSegmentId : originalUserSegmentIds) {
				userSegments.add(
					_userSegmentLocalService.getUserSegment(userSegmentId));
			}
		}

		request.setAttribute("userSegments", userSegments);

		List<UserSegment> availableUserSegments =
			_userSegmentLocalService.getUserSegments(groupIds);

		List<UserSegment> notMatchedUserSegments = new ArrayList<>();

		for (UserSegment userSegment : availableUserSegments) {
			if (!userSegments.contains(userSegment)) {
				notMatchedUserSegments.add(userSegment);
			}
		}

		request.setAttribute("notMatchedUserSegments", notMatchedUserSegments);

		boolean showUserSegmentSearch = false;

		if ((notMatchedUserSegments.size() + userSegments.size()) >
				_SHOW_SEARCH_LIMIT) {

			showUserSegmentSearch = true;
		}

		request.setAttribute("showUserSegmentSearch", showUserSegmentSearch);

		String refreshURL = PortalUtil.getLayoutURL(
			themeDisplay.getLayout(), themeDisplay);

		request.setAttribute("refreshURL", HtmlUtil.escapeJS(refreshURL));

		request.setAttribute(
			"simulatorServletContext", _simulatorServletContext);
	}

	@Reference(unbind = "-")
	protected void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		_campaignLocalService = campaignLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
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

	private static final int _SHOW_SEARCH_LIMIT = 10;

	private static final Log _log = LogFactoryUtil.getLog(
		ContentTargetingSimulatorPanelApp.class);

	private CampaignLocalService _campaignLocalService;
	private ServletContext _simulatorServletContext;
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentSimulator _userSegmentSimulator;

}