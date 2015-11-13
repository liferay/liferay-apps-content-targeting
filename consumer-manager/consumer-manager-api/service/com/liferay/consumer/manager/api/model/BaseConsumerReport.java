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

package com.liferay.consumer.manager.api.model;

import com.liferay.consumer.manager.model.ConsumerReportInstance;
import com.liferay.consumer.manager.util.ConsumerManagerContextUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.ResourceActionsUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseConsumerReport implements ConsumerReport {

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

		String description = ResourceActionsUtil.getModelResource(locale, key);

		if (description.equals(key)) {
			description = StringPool.BLANK;
		}

		return description;
	}

	@Override
	public String getEditHTML(
		ConsumerReportInstance reportInstance,
		Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateEditContext(reportInstance, context);

			content = ConsumerManagerContextUtil.parseTemplate(
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
	public String getHTML(
		ConsumerReportInstance reportInstance,
		Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateContext(reportInstance, context);

			content = ConsumerManagerContextUtil.parseTemplate(
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
	public String getHTML(Map<String, Object> context) {
		return getHTML(null, context);
	}

	@Override
	public String getIcon() {
		return "icon-file";
	}

	@Override
	public String getName(Locale locale) {
		return ResourceActionsUtil.getModelResource(
			locale, getClass().getName());
	}

	@Override
	public String getReportCategoryKey() {
		return REPORTS_CATEGORY_KEY;
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
	public boolean isVisible(long consumerId) {
		return true;
	}

	@Override
	public String processEditReport(
			PortletRequest request, PortletResponse response,
			ConsumerReportInstance reportInstance)
		throws Exception {

		return StringPool.BLANK;
	}

	@Override
	public void updateReport(ConsumerReportInstance reportInstance) {
		updateReport(reportInstance.getConsumerId());
	}

	@Override
	public String updateReport(long consumerId) {
		return StringPool.BLANK;
	}

	protected void populateContext(
		ConsumerReportInstance reportInstance,
		Map<String, Object> context) {

		populateContext(context);
	}

	protected void populateContext(Map<String, Object> context) {
	}

	protected void populateEditContext(
		ConsumerReportInstance reportInstance,
		Map<String, Object> context) {
	}

	protected static final String _EDIT_FORM_TEMPLATE_PATH =
		"templates/ct_edit_report.ftl";

	protected static final String _FORM_TEMPLATE_PATH =
		"templates/ct_report.ftl";

	private static Log _log = LogFactoryUtil.getLog(BaseConsumerReport.class);

}