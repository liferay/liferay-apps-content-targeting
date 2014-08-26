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

package com.liferay.portal.contenttargeting.api.model;

import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.contenttargeting.model.ReportInstance;
import com.liferay.portal.contenttargeting.service.ReportInstanceLocalService;
import com.liferay.portal.contenttargeting.util.ContentTargetingContextUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.ResourceActionsUtil;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

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

		String description = ResourceActionsUtil.getModelResource(locale, key);

		if (description.equals(key)) {
			description = StringPool.BLANK;
		}

		return description;
	}

	@Override
	public String getHTML(Map<String, Object> context) {
		String content = StringPool.BLANK;

		try {
			populateContext(context);

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
	public Date getModifiedDate(long classPK) {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		ReportInstanceLocalService reportInstanceLocalService =
			ServiceTrackerUtil.getService(
				ReportInstanceLocalService.class, bundle.getBundleContext());

		try {
			ReportInstance reportInstance =
				reportInstanceLocalService.fetchReportInstance(
					getReportKey(), getReportType(), classPK);

			if (reportInstance != null) {
				return reportInstance.getModifiedDate();
			}
		}
		catch (SystemException se) {
			_log.error(se);
		}

		return null;
	}

	@Override
	public String getName(Locale locale) {
		return ResourceActionsUtil.getModelResource(
			locale, getClass().getName());
	}

	@Override
	public String getReportKey() {
		return getClass().getSimpleName();
	}

	protected void populateContext(Map<String, Object> context) {
	}

	protected static final String _FORM_TEMPLATE_PATH =
		"templates/ct_report.ftl";

	private static Log _log = LogFactoryUtil.getLog(BaseReport.class);

}