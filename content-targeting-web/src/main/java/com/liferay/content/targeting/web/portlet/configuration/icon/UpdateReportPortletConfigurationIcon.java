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

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"path=" + ContentTargetingMVCCommand.VIEW_REPORT
	},
	service = PortletConfigurationIcon.class
)
public class UpdateReportPortletConfigurationIcon
	extends BasePortletConfigurationIcon {

	@Override
	public String getMessage(PortletRequest portletRequest) {
		return LanguageUtil.get(
			getResourceBundle(getLocale(portletRequest)), "update");
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

		String backURL = ParamUtil.getString(portletRequest, "backURL");
		String className = ParamUtil.getString(portletRequest, "className");
		long classPK = ParamUtil.getLong(portletRequest, "classPK");
		long reportInstanceId = ParamUtil.getLong(
			portletRequest, "reportInstanceId");
		String reportKey = ParamUtil.getString(portletRequest, "reportKey");

		PortletURL portletURL = PortletURLFactoryUtil.create(
			themeDisplay.getRequest(), PortalUtil.getPortletId(portletRequest),
			themeDisplay.getLayout(), PortletRequest.ACTION_PHASE);

		portletURL.setParameter(
			ActionRequest.ACTION_NAME,
			ContentTargetingMVCCommand.UPDATE_REPORT);
		portletURL.setParameter("backURL", backURL);
		portletURL.setParameter("className", className);
		portletURL.setParameter("classPK", String.valueOf(classPK));
		portletURL.setParameter(
			"redirect", PortalUtil.getCurrentURL(portletRequest));
		portletURL.setParameter(
			"reportInstanceId", String.valueOf(reportInstanceId));
		portletURL.setParameter("reportKey", reportKey);

		return portletURL.toString();
	}

	@Override
	public double getWeight() {
		return 100;
	}

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		return true;
	}

	public boolean isToolTip() {
		return false;
	}

}