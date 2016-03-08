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

package com.liferay.content.targeting.portlet.display.context;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingEditReportDisplayContext {

	public ContentTargetingEditReportDisplayContext(
		RenderResponse renderResponse, PortletConfig portletConfig,
		HttpServletRequest request) {

		_renderResponse = renderResponse;
		_portletConfig = portletConfig;
		_request = request;
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(_request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = _renderResponse.createRenderURL();

		String className = getClassName();

		if (className.equals(Campaign.class.getName())) {
			backURLObject.setParameter(
				"mvcRenderCommandName",
				ContentTargetingMVCCommand.VIEW_REPORTS_CAMPAIGN);
			backURLObject.setParameter(
				"campaignId", String.valueOf(getClassPK()));
		}
		else {
			backURLObject.setParameter(
				"mvcRenderCommandName",
				ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
			backURLObject.setParameter(
				"userSegmentId", String.valueOf(getClassPK()));
		}

		backURLObject.setParameter("className", className);
		backURLObject.setParameter("classPK", String.valueOf(getClassPK()));

		return backURLObject.toString();
	}

	public String getClassName() {
		if (Validator.isNotNull(_className)) {
			return _className;
		}

		_className = ParamUtil.getString(_request, "className");

		return _className;
	}

	public long getClassPK() {
		if (_classPK != null) {
			return _classPK;
		}

		_classPK = ParamUtil.getLong(_request, "classPK");

		return _classPK;
	}

	public String getRedirect() {
		if (Validator.isNotNull(_redirect)) {
			return _redirect;
		}

		_redirect = ParamUtil.getString(_request, "redirect");

		return _redirect;
	}

	public Report getReport() {
		if (_report != null) {
			return _report;
		}

		ReportsRegistry reportsRegistry =
			(ReportsRegistry)_request.getAttribute("reportsRegistry");

		_report = reportsRegistry.getReport(getReportKey());

		return _report;
	}

	public ReportInstance getReportInstance() {
		if (_reportInstance != null) {
			return _reportInstance;
		}

		long reportInstanceId = getReportInstanceId();

		if (reportInstanceId > 0) {
			_reportInstance =
				ReportInstanceLocalServiceUtil.fetchReportInstance(
					reportInstanceId);
		}

		return _reportInstance;
	}

	public long getReportInstanceId() {
		if (_reportInstanceId != null) {
			return _reportInstanceId;
		}

		_reportInstanceId = ParamUtil.getLong(_request, "reportInstanceId");

		return _reportInstanceId;
	}

	public String getReportKey() {
		if (Validator.isNotNull(_reportKey)) {
			return _reportKey;
		}

		_reportKey = ParamUtil.getString(_request, "reportKey");

		return _reportKey;
	}

	public String getReportTitle() {
		if (Validator.isNotNull(_reportTitle)) {
			return _reportTitle;
		}

		ReportInstance reportInstance = getReportInstance();

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (reportInstance != null) {
			_reportTitle = reportInstance.getName(themeDisplay.getLocale());
		}
		else {
			_reportTitle = LanguageUtil.get(
				_portletConfig.getResourceBundle(themeDisplay.getLocale()),
				"new-report");
		}

		return _reportTitle;
	}

	public Map<String, Object> getTemplateContext() {
		if (_templateContext != null) {
			return _templateContext;
		}

		Map<String, Object> templateContext =
			(Map<String, Object>)_request.getAttribute("templateContext");

		templateContext.put("className", getClassName());
		templateContext.put("classPK", getClassPK());
		templateContext.put("reportInstance", getReportInstance());
		templateContext.put("reportInstanceId", getReportInstanceId());
		templateContext.put("reportKey", getReportKey());

		_templateContext = templateContext;

		return _templateContext;
	}

	private String _className;
	private Long _classPK;
	private final PortletConfig _portletConfig;
	private String _redirect;
	private final RenderResponse _renderResponse;
	private Report _report;
	private ReportInstance _reportInstance;
	private Long _reportInstanceId;
	private String _reportKey;
	private String _reportTitle;
	private final HttpServletRequest _request;
	private Map<String, Object> _templateContext;

}