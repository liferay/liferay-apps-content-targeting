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
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.util.UnavailableServiceException;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

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
		"javax.portlet.init-param.view-template=/html/ct_simulator/view.ftl",
		"javax.portlet.name=", "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = {SimulatorPortlet.class, Portlet.class}
)
public class SimulatorPortlet extends CTFreeMarkerPortlet {

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

			return;
		}

		long[] selectedUserSegmentIds = StringUtil.split(
			ParamUtil.getString(request, "selectedUserSegmentIds"), 0L);

		_userSegmentSimulator.setUserSegmentIds(
			selectedUserSegmentIds, httpServletRequest, httpServletResponse);
	}

	@Override
	protected void doPopulateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		try {
			_campaignLocalService.getCampaigns(0, 1);
		}
		catch (Exception e) {
			throw new UnavailableServiceException(CampaignLocalService.class);
		}

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put(
			"redirect", ParamUtil.getString(portletRequest, "redirect"));
		template.put(
			"tabs1",
			ParamUtil.getString(portletRequest, "tabs1", "user-segments"));

		populateViewContext(
			path, portletRequest, portletResponse, template, staticModels);
	}

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template,
			TemplateHashModel staticModels)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long[] originalUserSegmentIds = (long[])portletRequest.getAttribute(
			WebKeys.ORIGINAL_USER_SEGMENT_IDS);

		long[] groupIds = ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
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

		template.put("simulatedUserSegmentIds", simulatedUserSegmentIds);

		List<Campaign> campaigns = _campaignLocalService.getCampaigns(
			groupIds, simulatedUserSegmentIds);

		template.put("campaigns", campaigns);

		List<Campaign> availableCampaigns = _campaignLocalService.getCampaigns(
			groupIds);

		List<Campaign> notMatchedCampaigns = new ArrayList<>();

		for (Campaign campaign : availableCampaigns) {
			if (!campaigns.contains(campaign)) {
				notMatchedCampaigns.add(campaign);
			}
		}

		template.put("notMatchedCampaigns", notMatchedCampaigns);

		boolean showCampaignsSearch = false;

		if ((notMatchedCampaigns.size() + campaigns.size()) >
				_SHOW_SEARCH_LIMIT) {

			showCampaignsSearch = true;
		}

		template.put("showCampaignsSearch", showCampaignsSearch);

		template.put("originalUserSegmentIds", originalUserSegmentIds);

		boolean isSimulatedUserSegments = GetterUtil.getBoolean(
			portletRequest.getAttribute(WebKeys.IS_SIMULATED_USER_SEGMENTS));

		template.put("isSimulatedUserSegments", isSimulatedUserSegments);

		List<UserSegment> userSegments = new ArrayList<>();

		if (originalUserSegmentIds != null) {
			for (long userSegmentId : originalUserSegmentIds) {
				userSegments.add(
					_userSegmentLocalService.getUserSegment(userSegmentId));
			}
		}

		template.put("userSegments", userSegments);

		List<UserSegment> availableUserSegments =
			_userSegmentLocalService.getUserSegments(groupIds);

		List<UserSegment> notMatchedUserSegments = new ArrayList<>();

		for (UserSegment userSegment : availableUserSegments) {
			if (!userSegments.contains(userSegment)) {
				notMatchedUserSegments.add(userSegment);
			}
		}

		template.put("notMatchedUserSegments", notMatchedUserSegments);

		boolean showUserSegmentSearch = false;

		if ((notMatchedUserSegments.size() + userSegments.size()) >
				_SHOW_SEARCH_LIMIT) {

			showUserSegmentSearch = true;
		}

		template.put("showUserSegmentSearch", showUserSegmentSearch);

		String refreshURL = PortalUtil.getLayoutURL(
			themeDisplay.getLayout(), themeDisplay);

		template.put("refreshURL", HtmlUtil.escapeJS(refreshURL));
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

	private static Log _log = LogFactoryUtil.getLog(SimulatorPortlet.class);

	private volatile CampaignLocalService _campaignLocalService;
	private volatile UserSegmentLocalService _userSegmentLocalService;
	private volatile UserSegmentSimulator _userSegmentSimulator;

}