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

package com.liferay.content.targeting.api.model;

import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseReport implements Report {

	@Override
	public void activate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Report activate: " + getClass().getSimpleName());
		}
	}

	@Override
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Report deactivate: " + getClass().getSimpleName());
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String key = getClass().getName().concat(".description");

		String description = ContentTargetingUtil.getModelResource(
			locale, getClass(), key);

		if (description.equals(key)) {
			description = StringPool.BLANK;
		}

		return description;
	}

	@Override
	public String getEditHTML(
		ReportInstance reportInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateEditContext(reportInstance, context);

			content = ContentTargetingContextUtil.parseTemplate(
				getClass(), _EDIT_FORM_TEMPLATE_PATH, context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing edit report form template " +
					_EDIT_FORM_TEMPLATE_PATH,
				e);
		}

		return content;
	}

	@Override
	public String getHTML(Map<String, Object> context) {
		return getHTML(null, context);
	}

	@Override
	public String getHTML(
		ReportInstance reportInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateContext(reportInstance, context);

			content = ContentTargetingContextUtil.parseTemplate(
				getClass(), _FORM_TEMPLATE_PATH, context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing report form template " +
					_FORM_TEMPLATE_PATH,
				e);
		}

		return content;
	}

	@Override
	public String getIcon() {
		return "icon-file";
	}

	@Override
	public String getName(Locale locale) {
		return ContentTargetingUtil.getModelResource(
			locale, getClass(), getClass().getName());
	}

	@Override
	public String getReportKey() {
		return getClass().getSimpleName();
	}

	@Override
	public boolean isInstantiable() {
		return false;
	}

	@Override
	public boolean isVisible(long classPK) {
		return true;
	}

	@Override
	public String processEditReport(
			PortletRequest request, PortletResponse response,
			ReportInstance reportInstance)
		throws Exception {

		return StringPool.BLANK;
	}

	@Override
	public String updateReport(long classPK) {
		return StringPool.BLANK;
	}

	@Override
	public void updateReport(ReportInstance reportInstance) {
		updateReport(reportInstance.getClassPK());
	}

	protected void populateContext(Map<String, Object> context) {
	}

	protected void populateContext(
		ReportInstance reportInstance, Map<String, Object> context) {

		populateContext(context);
	}

	protected void populateEditContext(
		ReportInstance reportInstance, Map<String, Object> context) {
	}

	private static final String _EDIT_FORM_TEMPLATE_PATH =
		"templates/ct_edit_report.ftl";

	private static final String _FORM_TEMPLATE_PATH = "templates/ct_report.ftl";

	private static final Log _log = LogFactoryUtil.getLog(BaseReport.class);

}