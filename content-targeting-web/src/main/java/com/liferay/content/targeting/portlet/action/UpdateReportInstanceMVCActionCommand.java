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

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.exception.InvalidDateRangeException;
import com.liferay.content.targeting.exception.InvalidNameException;
import com.liferay.content.targeting.exception.InvalidReportException;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.ReportInstanceService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.TransactionInvokerUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.UPDATE_REPORT_INSTANCE
	},
	service = MVCActionCommand.class
)
public class UpdateReportInstanceMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long reportInstanceId = ParamUtil.getLong(request, "reportInstanceId");
		String reportKey = ParamUtil.getString(request, "reportKey");
		String className = ParamUtil.getString(request, "className");
		long classPK = ParamUtil.getLong(request, "classPK");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			request, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(request, "description");

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		try {
			Callable<ReportInstance> reportInstanceCallable =
				new ReportInstanceCallable(
					request, response, themeDisplay.getUserId(),
					reportInstanceId, reportKey, className, classPK, nameMap,
					descriptionMap, serviceContext);

			ReportInstance reportInstance = TransactionInvokerUtil.invoke(
				_transactionConfig, reportInstanceCallable);

			boolean saveAndContinue = ParamUtil.get(
				request, "saveAndContinue", false);

			if (saveAndContinue) {
				String redirect = ParamUtil.get(request, "redirect", "");

				response.setRenderParameter("className", className);
				response.setRenderParameter("classPK", String.valueOf(classPK));
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_REPORT);
				response.setRenderParameter("redirect", redirect);
				response.setRenderParameter(
					"p_p_mode", PortletMode.VIEW.toString());
				response.setRenderParameter(
					"reportInstanceId",
					String.valueOf(reportInstance.getReportInstanceId()));
				response.setRenderParameter("reportKey", reportKey);

				addSuccessMessage(request, response);
			}
			else {
				sendRedirect(request, response);
			}
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(request, response);

			SessionErrors.add(request, e.getClass(), e);

			if (e instanceof InvalidDateRangeException ||
				e instanceof InvalidNameException ||
				e instanceof InvalidReportException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					request,
					PortalUtil.getPortletId(request) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_REPORT);
			}
			else {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
		}
		catch (Throwable t) {
			_log.error(t);

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
		}
	}

	@Reference(unbind = "unsetReportInstanceService")
	protected void setReportInstanceService(
		ReportInstanceService reportInstanceService) {

		_reportInstanceService = reportInstanceService;
	}

	@Reference(unbind = "unsetReportsRegistry")
	protected void setReportsRegistry(ReportsRegistry reportsRegistry) {
		_reportsRegistry = reportsRegistry;
	}

	protected void unsetReportInstanceService() {
		_reportInstanceService = null;
	}

	protected void unsetReportsRegistry() {
		_reportsRegistry = null;
	}

	protected void updateReportElements(
			ReportInstance reportInstance, PortletRequest request,
			PortletResponse response)
		throws InvalidReportException {

		Report report = _reportsRegistry.getReport(
			reportInstance.getReportKey());

		try {
			String typeSettings = report.processEditReport(
				request, response, reportInstance);

			reportInstance.setTypeSettings(typeSettings);

			_reportInstanceService.updateReportInstance(reportInstance);
		}
		catch (Exception e) {
			throw new InvalidReportException(e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UpdateReportInstanceMVCActionCommand.class);

	private ReportInstanceService _reportInstanceService;
	private ReportsRegistry _reportsRegistry;

	private class ReportInstanceCallable implements Callable<ReportInstance> {

		@Override
		public ReportInstance call() throws Exception {
			ReportInstance reportInstance = null;

			if (_reportInstanceId > 0) {
				reportInstance = _reportInstanceService.updateReportInstance(
					_reportInstanceId, _userId, _reportKey, _className,
					_classPK, _nameMap, _descriptionMap, "", _serviceContext);
			}
			else {
				reportInstance = _reportInstanceService.addReportInstance(
					_userId, _reportKey, _className, _classPK, _nameMap,
					_descriptionMap, "", _serviceContext);
			}

			updateReportElements(
				reportInstance, _portletRequest, _portletResponse);

			return reportInstance;
		}

		private ReportInstanceCallable(
			PortletRequest portletRequest, PortletResponse portletResponse,
			long userId, long reportInstanceId, String reportKey,
			String className, long classPK, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext) {

			_portletRequest = portletRequest;
			_portletResponse = portletResponse;
			_userId = userId;
			_reportInstanceId = reportInstanceId;
			_reportKey = reportKey;
			_className = className;
			_classPK = classPK;
			_nameMap = nameMap;
			_descriptionMap = descriptionMap;
			_serviceContext = serviceContext;
		}

		private final String _className;
		private final long _classPK;
		private final Map<Locale, String> _descriptionMap;
		private final Map<Locale, String> _nameMap;
		private final PortletRequest _portletRequest;
		private final PortletResponse _portletResponse;
		private final long _reportInstanceId;
		private final String _reportKey;
		private final ServiceContext _serviceContext;
		private final long _userId;

	}

}