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

package com.liferay.content.targeting.portlet.action;

import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

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
		"mvc.command.name=" + ContentTargetingMVCCommand.DELETE_REPORT_INSTANCE
	},
	service = MVCActionCommand.class
)
public class DeleteReportInstanceMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest request, ActionResponse response)
		throws Exception {

		try {
			long[] deleteReportInstanceIds = null;

			long reportInstanceId = ParamUtil.getLong(
				request, "reportInstanceId");

			if (reportInstanceId > 0) {
				deleteReportInstanceIds = new long[] {reportInstanceId};
			}
			else {
				deleteReportInstanceIds = StringUtil.split(
					ParamUtil.getString(request, "reportInstanceIds"), 0L);
			}

			for (long deleteReportInstanceId : deleteReportInstanceIds) {
				_reportInstanceLocalService.deleteReportInstance(
					deleteReportInstanceId);
			}

			sendRedirect(request, response);
		}
		catch (Exception e) {
			_log.error("Unable to delete report instance", e);

			SessionErrors.add(request, e.getClass(), e);

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

	@Reference(unbind = "unsetReportInstanceLocalService")
	protected void setReportInstanceLocalService(
		ReportInstanceLocalService reportInstanceLocalService) {

		_reportInstanceLocalService = reportInstanceLocalService;
	}

	protected void unsetReportInstanceLocalService() {
		_reportInstanceLocalService = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DeleteReportInstanceMVCActionCommand.class);

	private ReportInstanceLocalService _reportInstanceLocalService;

}