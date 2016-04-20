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

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT
	},
	service = MVCRenderCommand.class
)
public class ViewReportsUserSegmentMVCRenderCommand
	extends BaseMVCRenderCommand {

	@Override
	public String doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long userSegmentId = ParamUtil.getLong(renderRequest, "classPK");

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

		Map<String, Report> reports = _reportsRegistry.getReports(
			UserSegment.class.getName());

		renderRequest.setAttribute("reports", new ArrayList(reports.values()));
		renderRequest.setAttribute("reportsRegistry", _reportsRegistry);

		if (userSegmentId > 0) {
			for (Report report : reports.values()) {
				if (report.isInstantiable()) {
					continue;
				}

				if (_reportInstanceLocalService.getReportInstanceCount(
						report.getReportKey(), UserSegment.class.getName(),
						userSegmentId) > 0) {

					continue;
				}

				_reportInstanceLocalService.addReportInstance(
					themeDisplay.getUserId(), report.getReportKey(),
					UserSegment.class.getName(), userSegmentId,
					StringPool.BLANK, serviceContext);
			}
		}

		return "/view_user_segment.jsp";
	}

	@Reference(unbind = "-")
	protected void setReportInstanceLocalService(
		ReportInstanceLocalService reportInstanceLocalService) {

		_reportInstanceLocalService = reportInstanceLocalService;
	}

	@Reference
	protected void setReportsRegistry(ReportsRegistry reportsRegistry) {
		_reportsRegistry = reportsRegistry;
	}

	protected void unsetReportsRegistry(ReportsRegistry reportsRegistry) {
		_reportsRegistry = null;
	}

	private ReportInstanceLocalService _reportInstanceLocalService;
	private ReportsRegistry _reportsRegistry;

}