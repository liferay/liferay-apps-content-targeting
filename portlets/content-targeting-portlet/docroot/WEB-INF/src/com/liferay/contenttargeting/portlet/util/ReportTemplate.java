/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.portlet.util;

import com.liferay.contenttargeting.api.model.Report;
import com.liferay.portal.kernel.util.LocaleThreadLocal;

/**
 * @author Eduardo Garcia
 */
public class ReportTemplate {

	public String getName() {
		return _report.getName(LocaleThreadLocal.getThemeDisplayLocale());
	}

	public Report getReport() {
		return _report;
	}

	public String getReportKey() {
		return _report.getReportKey();
	}

	public String getTemplate() {
		return _template;
	}

	public void setReport(Report report) {
		_report = report;
	}

	public void setTemplate(String template) {
		_template = template;
	}

	private Report _report;
	private String _template;

}