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

package com.liferay.content.targeting.portlet.application.list;

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
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.product.navigation.simulation.application.list.SimulationPanelCategory;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

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
		"panel.category.key=" + SimulationPanelCategory.SIMULATION,
		"service.ranking:Integer=110"
	},
	service = PanelApp.class
)
public class ContentTargetingSimulatorPanelApp extends BaseJSPPanelApp {

	@Override
	public String getJspPath() {
		return "/ct_simulator/view.jsp";
	}

	@Override
	public String getPortletId() {
		return PortletKeys.CT_SIMULATOR;
	}

	@Override
	public boolean include(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		PortletRequest portletRequest = (PortletRequest)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST);

		PortletResponse portletResponse = (PortletResponse)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_RESPONSE);

		try {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)portletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			long[] originalUserSegmentIds = (long[])portletRequest.getAttribute(
				WebKeys.ORIGINAL_USER_SEGMENT_IDS);

			long[] groupIds =
				ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
					themeDisplay.getSiteGroupId());

			HttpServletRequest httpServletRequest =
				PortalUtil.getHttpServletRequest(portletRequest);

			HttpServletResponse httpServletResponse =
				PortalUtil.getHttpServletResponse(portletResponse);

			long[] simulatedUserSegmentIds =
				_userSegmentSimulator.getUserSegmentIds(
					httpServletRequest, httpServletResponse);

			if (simulatedUserSegmentIds == null) {
				simulatedUserSegmentIds = originalUserSegmentIds;
			}

			portletRequest.setAttribute(
				"simulatedUserSegmentIds", simulatedUserSegmentIds);

			List<Campaign> campaigns = _campaignLocalService.getCampaigns(
				groupIds, simulatedUserSegmentIds);

			portletRequest.setAttribute("campaigns", campaigns);

			List<Campaign> availableCampaigns =
				_campaignLocalService.getCampaigns(groupIds);

			List<Campaign> notMatchedCampaigns = new ArrayList<>();

			for (Campaign campaign : availableCampaigns) {
				if (!campaigns.contains(campaign)) {
					notMatchedCampaigns.add(campaign);
				}
			}

			portletRequest.setAttribute(
				"notMatchedCampaigns", notMatchedCampaigns);

			boolean showCampaignsSearch = false;

			if ((notMatchedCampaigns.size() + campaigns.size()) >
					_SHOW_SEARCH_LIMIT) {

				showCampaignsSearch = true;
			}

			portletRequest.setAttribute(
				"showCampaignsSearch", showCampaignsSearch);

			portletRequest.setAttribute(
				"originalUserSegmentIds", originalUserSegmentIds);

			boolean isSimulatedUserSegments = GetterUtil.getBoolean(
				portletRequest.getAttribute(
					WebKeys.IS_SIMULATED_USER_SEGMENTS));

			portletRequest.setAttribute(
				"isSimulatedUserSegments", isSimulatedUserSegments);

			List<UserSegment> userSegments = new ArrayList<>();

			if (originalUserSegmentIds != null) {
				for (long userSegmentId : originalUserSegmentIds) {
					userSegments.add(
						_userSegmentLocalService.getUserSegment(userSegmentId));
				}
			}

			portletRequest.setAttribute("userSegments", userSegments);

			List<UserSegment> availableUserSegments =
				_userSegmentLocalService.getUserSegments(groupIds);

			List<UserSegment> notMatchedUserSegments = new ArrayList<>();

			for (UserSegment userSegment : availableUserSegments) {
				if (!userSegments.contains(userSegment)) {
					notMatchedUserSegments.add(userSegment);
				}
			}

			portletRequest.setAttribute(
				"notMatchedUserSegments", notMatchedUserSegments);

			boolean showUserSegmentSearch = false;

			if ((notMatchedUserSegments.size() + userSegments.size()) >
					_SHOW_SEARCH_LIMIT) {

				showUserSegmentSearch = true;
			}

			portletRequest.setAttribute(
				"showUserSegmentSearch", showUserSegmentSearch);

			String refreshURL = PortalUtil.getLayoutURL(
				themeDisplay.getLayout(), themeDisplay);

			portletRequest.setAttribute(
				"refreshURL", HtmlUtil.escapeJS(refreshURL));

			portletRequest.setAttribute(
				"simulatorServletContext", _simulatorServletContext);
		}
		catch (Exception e) {
			_log.error("Error rendering CT simulator panel app", e);
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
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.web-portlet)",
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
			permissionChecker, group, ActionKeys.ACCESS_IN_CONTROL_PANEL);
	}

	@Reference(unbind = "unsetCampaignLocalService")
	protected void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		_campaignLocalService = campaignLocalService;
	}

	@Reference(unbind = "unsetUserSegmentLocalService")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	@Reference(unbind = "unsetUserSegmentSimulator")
	protected void setUserSegmentSimulator(
		UserSegmentSimulator userSegmentSimulator) {

		_userSegmentSimulator = userSegmentSimulator;
	}

	protected void unsetCampaignLocalService() {
		_campaignLocalService = null;
	}

	protected void unsetUserSegmentLocalService() {
		_userSegmentLocalService = null;
	}

	protected void unsetUserSegmentSimulator() {
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