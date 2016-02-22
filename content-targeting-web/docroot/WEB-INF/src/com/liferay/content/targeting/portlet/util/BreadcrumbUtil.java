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

package com.liferay.content.targeting.portlet.util;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Julio Camarero
 */
public class BreadcrumbUtil {

	public static void addPortletBreadcrumbEntries(
		HttpServletRequest request, RenderResponse renderResponse,
		Campaign campaign, String campaignTabName) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		addPortletBreadcrumbEntries(request, renderResponse, "campaigns");

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", ContentTargetingPath.EDIT_CAMPAIGN);
		portletURL.setParameter(
			"campaignId", String.valueOf(campaign.getCampaignId()));
		portletURL.setParameter("className", Campaign.class.getName());
		portletURL.setParameter(
			"classPK", String.valueOf(campaign.getCampaignId()));
		portletURL.setParameter("tabs2", campaignTabName);

		PortalUtil.addPortletBreadcrumbEntry(
			request, campaign.getName(themeDisplay.getLocale()),
			portletURL.toString());
	}

	public static void addPortletBreadcrumbEntries(
		HttpServletRequest request, RenderResponse renderResponse,
		Report report) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortalUtil.addPortletBreadcrumbEntry(
			request, report.getName(themeDisplay.getLocale()), null);
	}

	public static void addPortletBreadcrumbEntries(
		HttpServletRequest request, RenderResponse renderResponse,
		String tabs1) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", ContentTargetingPath.VIEW);
		portletURL.setParameter("tabs1", tabs1);

		PortalUtil.addPortletBreadcrumbEntry(
			request, themeDisplay.translate(tabs1), portletURL.toString());
	}

	public static void addPortletBreadcrumbEntries(
		HttpServletRequest request, RenderResponse renderResponse,
		Tactic tactic) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortalUtil.addPortletBreadcrumbEntry(
			request, tactic.getName(themeDisplay.getLocale()), null);
	}

	public static void addPortletBreadcrumbEntries(
		HttpServletRequest request, RenderResponse renderResponse,
		UserSegment userSegment) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		addPortletBreadcrumbEntries(request, renderResponse, "user-segments");

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", ContentTargetingPath.VIEW_REPORTS);
		portletURL.setParameter("className", UserSegment.class.getName());
		portletURL.setParameter(
			"classPK", String.valueOf(userSegment.getUserSegmentId()));

		PortalUtil.addPortletBreadcrumbEntry(
			request, userSegment.getName(themeDisplay.getLocale()),
			portletURL.toString());
	}

}