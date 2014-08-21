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

package com.liferay.portal.contenttargeting.portlet;

import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.contenttargeting.api.model.UserSegmentSimulator;
import com.liferay.portal.contenttargeting.model.Campaign;
import com.liferay.portal.contenttargeting.model.UserSegment;
import com.liferay.portal.contenttargeting.service.CampaignLocalService;
import com.liferay.portal.contenttargeting.service.UserSegmentLocalService;
import com.liferay.portal.contenttargeting.util.ContentTargetingUtil;
import com.liferay.portal.contenttargeting.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.UnavailableException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Julio Camarero
 */
public class CTSimulatorPortlet extends CTFreeMarkerPortlet {

	@Override
	public void init() throws PortletException {
		super.init();

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, bundle.getBundleContext());
		_userSegmentSimulator = ServiceTrackerUtil.getService(
			UserSegmentSimulator.class, bundle.getBundleContext());
	}

	public void simulateUserSegment(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long[] selectedUserSegmentIds = StringUtil.split(
			ParamUtil.getString(request, "selectedUserSegmentIds"), 0L);

		HttpServletRequest httpServletRequest =
			PortalUtil.getHttpServletRequest(request);

		HttpServletResponse httpServletResponse =
			PortalUtil.getHttpServletResponse(response);

		_userSegmentSimulator.removeAllUserSegmentIds(
			httpServletRequest, httpServletResponse);

		for (long selectedUserSegmentId : selectedUserSegmentIds) {
			_userSegmentSimulator.addUserSegmentId(
				selectedUserSegmentId, httpServletRequest, httpServletResponse);
		}
	}

	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

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

		if ((simulatedUserSegmentIds == null) ||
			ArrayUtil.isEmpty(simulatedUserSegmentIds)) {

			simulatedUserSegmentIds = originalUserSegmentIds;
		}

		template.put("simulatedUserSegmentIds", simulatedUserSegmentIds);

		List<Campaign> campaigns = _campaignLocalService.getCampaigns(
			groupIds, simulatedUserSegmentIds);

		template.put("campaigns", campaigns);

		List<Campaign> availableCampaigns = _campaignLocalService.getCampaigns(
			groupIds);

		List<Campaign> notMatchedCampaigns = new ArrayList<Campaign>();

		for (Campaign campaign : availableCampaigns) {
			if (!campaigns.contains(campaign)) {
				notMatchedCampaigns.add(campaign);
			}
		}

		template.put("notMatchedCampaigns", notMatchedCampaigns);

		boolean showCampaignsSearch = false;

		if ((notMatchedCampaigns.size() + campaigns.size()) >
				SHOW_SEARCH_LIMIT) {

			showCampaignsSearch = true;
		}

		template.put("showCampaignsSearch", showCampaignsSearch);

		template.put("originalUserSegmentIds", originalUserSegmentIds);

		boolean isSimulatedUserSegments = GetterUtil.getBoolean(
			portletRequest.getAttribute(WebKeys.IS_SIMULATED_USER_SEGMENTS));

		template.put("isSimulatedUserSegments", isSimulatedUserSegments);

		List<UserSegment> userSegments = new ArrayList<UserSegment>();

		if (originalUserSegmentIds != null) {
			for (long userSegmentId : originalUserSegmentIds) {
				userSegments.add(
					_userSegmentLocalService.getUserSegment(userSegmentId));
			}
		}

		template.put("userSegments", userSegments);

		List<UserSegment> availableUserSegments =
			_userSegmentLocalService.getUserSegments(groupIds);

		List<UserSegment> notMatchedUserSegments = new ArrayList<UserSegment>();

		for (UserSegment userSegment : availableUserSegments) {
			if (!userSegments.contains(userSegment)) {
				notMatchedUserSegments.add(userSegment);
			}
		}

		template.put("notMatchedUserSegments", notMatchedUserSegments);

		boolean showUserSegmentSearch = false;

		if ((notMatchedUserSegments.size() + userSegments.size()) >
				SHOW_SEARCH_LIMIT) {

			showUserSegmentSearch = true;
		}

		template.put("showUserSegmentSearch", showUserSegmentSearch);

		String refreshURL = PortalUtil.getLayoutURL(
			themeDisplay.getLayout(), themeDisplay);

		template.put("refreshURL", HtmlUtil.escapeJS(refreshURL));
	}

	private static final int SHOW_SEARCH_LIMIT = 10;

	private static Log _log = LogFactoryUtil.getLog(CTSimulatorPortlet.class);

	private CampaignLocalService _campaignLocalService;
	private UserSegmentLocalService _userSegmentLocalService;
	private UserSegmentSimulator _userSegmentSimulator;

}