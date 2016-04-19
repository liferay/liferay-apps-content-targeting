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

package com.liferay.content.targeting.web.portlet.configuration.icon;

import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Objects;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"path=" + ContentTargetingMVCCommand.VIEW_CAMPAIGN
	},
	service = PortletConfigurationIcon.class
)
public class EditCampaignPortletConfigurationIcon
	extends BasePortletConfigurationIcon {

	@Override
	public String getMessage(PortletRequest portletRequest) {
		return LanguageUtil.get(
			getResourceBundle(getLocale(portletRequest)), "edit");
	}

	@Override
	public String getMethod() {
		return "get";
	}

	@Override
	public String getURL(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long campaignId = ParamUtil.getLong(portletRequest, "campaignId");

		PortletURL portletURL = PortletURLFactoryUtil.create(
			themeDisplay.getRequest(), PortalUtil.getPortletId(portletRequest),
			themeDisplay.getLayout(), PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_CAMPAIGN);
		portletURL.setParameter(
			"backURL", PortalUtil.getCurrentURL(portletRequest));
		portletURL.setParameter("campaignId", String.valueOf(campaignId));
		portletURL.setParameter(
			"redirect", PortalUtil.getCurrentURL(portletRequest));

		return portletURL.toString();
	}

	@Override
	public double getWeight() {
		return 101;
	}

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		String tabs1 = ParamUtil.getString(portletRequest, "tabs1");

		return Objects.equals(tabs1, "summary");
	}

	public boolean isToolTip() {
		return false;
	}

}