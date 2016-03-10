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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.servlet.BufferCacheServletResponse;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.util.ThemeUtil;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseJSPReport extends BaseReport {

	@Override
	public String getEditHTML(
		ReportInstance reportInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateEditContext(reportInstance, context);

			content = ContentTargetingContextUtil.parseTemplate(
				getClass(), getEditTemplatePath(), context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing edit report form template " +
					getEditTemplatePath(),
				e);
		}

		return content;
	}

	@Override
	public String getHTML(
		ReportInstance reportInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateContext(reportInstance, context);

			HttpServletRequest request = (HttpServletRequest)context.get(
				"request");

			HttpServletResponse response = (HttpServletResponse)context.get(
				"response");

			Theme theme = (Theme)context.get(WebKeys.THEME);

			BufferCacheServletResponse bufferResponse =
				new BufferCacheServletResponse(response);

			request.setAttribute("displayContext", context);

			ThemeUtil.includeJSP(
				_servletContext, request, bufferResponse, getFormTemplatePath(),
				theme);

			content = bufferResponse.getString();
		}
		catch (Exception e) {
			_log.error(
				"Error while processing report form template " +
					getFormTemplatePath(),
				e);
		}

		return content;
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	protected String getEditTemplatePath() {
		return _EDIT_FORM_TEMPLATE_PATH;
	}

	@Override
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH;
	}

	private static final String _EDIT_FORM_TEMPLATE_PATH =
		"/templates/ct_edit_report.jsp";

	private static final String _FORM_TEMPLATE_PATH =
		"/templates/ct_report.jsp";

	private static final Log _log = LogFactoryUtil.getLog(BaseJSPReport.class);

	private ServletContext _servletContext;

}