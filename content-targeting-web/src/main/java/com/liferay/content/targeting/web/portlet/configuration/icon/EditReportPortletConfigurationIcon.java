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

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
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

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
public class EditReportPortletConfigurationIcon
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

		String className = ParamUtil.getString(portletRequest, "className");
		long classNameId = ParamUtil.getLong(portletRequest, "classNameId");

		if (classNameId <= 0) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		long classPK = ParamUtil.getLong(portletRequest, "classPK");
		long reportInstanceId = ParamUtil.getLong(
			portletRequest, "reportInstanceId");
		String reportKey = ParamUtil.getString(portletRequest, "reportKey");

		PortletURL portletURL = PortletURLFactoryUtil.create(
			themeDisplay.getRequest(), PortalUtil.getPortletId(portletRequest),
			themeDisplay.getLayout(), PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_REPORT);
		portletURL.setParameter(
			"backURL", PortalUtil.getCurrentURL(portletRequest));
		portletURL.setParameter("classNameId", String.valueOf(classNameId));
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
		return 101;
	}

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		String reportKey = ParamUtil.getString(portletRequest, "reportKey");

		Report report = _reportsRegistry.getReport(reportKey);

		return report.isInstantiable();
	}

	public boolean isToolTip() {
		return false;
	}

	@Reference(unbind = "-")
	protected void setReportsRegistry(ReportsRegistry reportsRegistry) {
		_reportsRegistry = reportsRegistry;
	}

	private ReportsRegistry _reportsRegistry;

}