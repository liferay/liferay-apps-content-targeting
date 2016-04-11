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
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

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
		"mvc.command.name=" + ContentTargetingMVCCommand.UPDATE_REPORT
	},
	service = MVCActionCommand.class
)
public class UpdateReportMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long reportInstanceId = ParamUtil.getLong(
			actionRequest, "reportInstanceId");
		String reportKey = ParamUtil.getString(actionRequest, "reportKey");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ReportInstance.class.getName(), actionRequest);

			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			serviceContext.setScopeGroupId(
				themeDisplay.getSiteGroupIdOrLiveGroupId());

			ReportInstance reportInstance =
				_reportInstanceLocalService.fetchReportInstance(
					reportInstanceId);

			if (reportInstance != null) {
				Report report = _reportsRegistry.getReport(reportKey);

				report.updateReport(reportInstance);

				reportInstance.setModifiedDate(new Date());

				_reportInstanceLocalService.updateReportInstance(
					reportInstance);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass(), e);

			if (e instanceof PrincipalException) {
				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					ContentTargetingMVCCommand.VIEW_REPORT);
			}
			else {
				_log.error("Unable to update report", e);

				actionResponse.setRenderParameter("mvcPath", "/error.jsp");
			}
		}
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

	private static final Log _log = LogFactoryUtil.getLog(
		UpdateReportMVCActionCommand.class);

	private static volatile ReportInstanceLocalService
		_reportInstanceLocalService;
	private static volatile ReportsRegistry _reportsRegistry;

}