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
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.util.StringPool;

import java.util.ArrayList;
import java.util.List;
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
			Class<?> clazz = getClass();

			_log.debug("Report activate: " + clazz.getSimpleName());
		}
	}

	@Override
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			Class<?> clazz = getClass();

			_log.debug("Report deactivate: " + clazz.getSimpleName());
		}
	}

	public List<PortletConfigurationIcon> getConfigurationIcons() {
		return new ArrayList<>();
	}

	@Override
	public String getDescription(Locale locale) {
		return ContentTargetingUtil.getDescription(getClass(), locale);
	}

	@Override
	public String getEditHTML(
		ReportInstance reportInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateEditContext(reportInstance, context);

			content = ContentTargetingContextUtil.parseTemplate(
				getClass(), getEditFormTemplatePath(), context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing edit report form template " +
					getEditFormTemplatePath(),
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
				getClass(), getFormTemplatePath(), context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing report form template " +
					getFormTemplatePath(),
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
		return ContentTargetingUtil.getName(getClass(), locale);
	}

	@Override
	public String getReportKey() {
		Class<?> clazz = getClass();

		return clazz.getSimpleName();
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
			PortletRequest portletRequest, PortletResponse portletResponse,
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

	protected String getEditFormTemplatePath() {
		return _EDIT_FORM_TEMPLATE_PATH;
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH;
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

	private static final String _EDIT_FORM_TEMPLATE_PATH = "templates/edit.ftl";

	private static final String _FORM_TEMPLATE_PATH = "templates/view.ftl";

	private static final Log _log = LogFactoryUtil.getLog(BaseReport.class);

}