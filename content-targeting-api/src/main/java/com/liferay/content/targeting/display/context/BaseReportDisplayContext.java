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

package com.liferay.content.targeting.display.context;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public class BaseReportDisplayContext {

	public BaseReportDisplayContext(
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request) {

		this.liferayPortletResponse = liferayPortletResponse;
		this.request = request;

		displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = liferayPortletResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", "/view_reports.jsp");
		backURLObject.setParameter("className", getClassName());
		backURLObject.setParameter("classPK", String.valueOf(getClassPK()));

		if (Campaign.class.getName().equals(getClassName())) {
			backURLObject.setParameter(
				"campaignId", String.valueOf(getClassPK()));
		}
		else {
			backURLObject.setParameter(
				"userSegmentId", String.valueOf(getClassPK()));
		}

		return backURLObject.toString();
	}

	public String getClassName() {
		if (_className != null) {
			return _className;
		}

		_className = GetterUtil.getString(displayContext.get("className"));

		return _className;
	}

	public long getClassPK() {
		if (_classPK != null) {
			return _classPK;
		}

		_classPK = GetterUtil.getLong(displayContext.get("classPK"));

		return _classPK;
	}

	public String getName() {
		if (_name != null) {
			return _name;
		}

		_name = GetterUtil.getString(displayContext.get("name"));

		return _name;
	}

	public String getRedirect() {
		if (_redirect != null) {
			return _redirect;
		}

		_redirect = GetterUtil.getString(displayContext.get("redirect"));

		return _redirect;
	}

	public Report getReport() {
		if (_report != null) {
			return _report;
		}

		_report = (Report)displayContext.get("report");

		if (_report == null) {
			String reportKey = GetterUtil.getString(
				displayContext.get("reportKey"));

			_report = getReportsRegistry().getReport(reportKey);
		}

		return _report;
	}

	public ReportInstance getReportInstance() {
		if (_reportInstance != null) {
			return _reportInstance;
		}

		_reportInstance = (ReportInstance)displayContext.get("reportInstance");

		return _reportInstance;
	}

	public long getReportInstanceId() {
		if (_reportInstanceId != null) {
			return _reportInstanceId;
		}

		_reportInstanceId = GetterUtil.getLong(
			displayContext.get("reportInstanceId"));

		return _reportInstanceId;
	}

	public ReportsRegistry getReportsRegistry() {
		if (_reportsRegistry != null) {
			return _reportsRegistry;
		}

		_reportsRegistry = (ReportsRegistry)displayContext.get(
			"reportsRegistry");

		return _reportsRegistry;
	}

	protected PortletURL getPortletURL() {
		Report report = getReport();

		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "viewReport");
		portletURL.setParameter("redirect", getRedirect());
		portletURL.setParameter("reportKey", report.getReportKey());
		portletURL.setParameter("className", getClassName());
		portletURL.setParameter("classPK", String.valueOf(getClassPK()));

		return portletURL;
	}

	protected final Map<String, Object> displayContext;
	protected final LiferayPortletResponse liferayPortletResponse;
	protected final HttpServletRequest request;

	private String _className;
	private Long _classPK;
	private String _name;
	private String _redirect;
	private Report _report;
	private ReportInstance _reportInstance;
	private Long _reportInstanceId;
	private ReportsRegistry _reportsRegistry;

}