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
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public class BaseReportDisplayContext {

	public BaseReportDisplayContext(HttpServletRequest request) {
		this.request = request;

		displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public String getClassName() {
		if (Validator.isBlank(_className)) {
			_className = GetterUtil.getString(displayContext.get("className"));
		}

		return _className;
	}

	public long getClassPK() {
		if (_classPK <= 0) {
			_classPK = GetterUtil.getLong(displayContext.get("classPK"));
		}

		return _classPK;
	}

	public String getName() {
		if (Validator.isBlank(_name)) {
			_name = GetterUtil.getString(displayContext.get("name"));
		}

		return _name;
	}

	public String getRedirect() {
		if (Validator.isBlank(_redirect)) {
			_redirect = GetterUtil.getString(displayContext.get("redirect"));
		}

		return _redirect;
	}

	public Report getReport() {
		if (_report == null) {
			_report = (Report)displayContext.get("report");
		}

		return _report;
	}

	public ReportInstance getReportInstance() {
		if (_reportInstance == null) {
			_reportInstance = (ReportInstance)displayContext.get(
				"reportInstance");
		}

		return _reportInstance;
	}

	public long getReportInstanceId() {
		if (_reportInstanceId <= 0) {
			_reportInstanceId = GetterUtil.getLong(
				displayContext.get("reportInstanceId"));
		}

		return _reportInstanceId;
	}

	public ReportsRegistry getReportsRegistry() {
		if (_reportsRegistry == null) {
			_reportsRegistry = (ReportsRegistry)displayContext.get(
				"reportsRegistry");
		}

		return _reportsRegistry;
	}

	protected final Map<String, Object> displayContext;
	protected final HttpServletRequest request;

	private String _className;
	private long _classPK;
	private String _name;
	private String _redirect;
	private Report _report;
	private ReportInstance _reportInstance;
	private long _reportInstanceId;
	private ReportsRegistry _reportsRegistry;

}