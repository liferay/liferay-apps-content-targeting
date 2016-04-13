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

package com.liferay.content.targeting.web.display.context;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.content.targeting.util.CampaignConstants;
import com.liferay.content.targeting.util.UserSegmentConstants;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingEditReportDisplayContext {

	public ContentTargetingEditReportDisplayContext(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;

		_request = PortalUtil.getHttpServletRequest(renderRequest);
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
			backURLObject.setParameter("tabs1", "reports");
			backURLObject.setParameter("viewType", CampaignConstants.VIEW_TYPE);
		}
		else {
			backURLObject.setParameter(
				"mvcRenderCommandName",
				ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
			backURLObject.setParameter(
				"viewType", UserSegmentConstants.VIEW_TYPE);
		}

		backURLObject.setParameter(
			"classNameId", String.valueOf(getClassNameId()));
		backURLObject.setParameter("classPK", String.valueOf(getClassPK()));

		return backURLObject.toString();
	}

	public String getClassName() {
		if (Validator.isNotNull(_className)) {
			return _className;
		}

		_className = PortalUtil.getClassName(getClassNameId());

		return _className;
	}

	public long getClassNameId() {
		if (_classNameId != null) {
			return _classNameId;
		}

		_classNameId = ParamUtil.getLong(_request, "classNameId");

		return _classNameId;
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

		String redirectURL = ParamUtil.getString(_request, "redirect");

		if (Validator.isNull(redirectURL)) {
			PortletURL redirectURLObject = _renderResponse.createRenderURL();

			String className = getClassName();

			if (className.equals(Campaign.class.getName())) {
				redirectURLObject.setParameter(
					"mvcRenderCommandName",
					ContentTargetingMVCCommand.VIEW_REPORTS_CAMPAIGN);
				redirectURLObject.setParameter("tabs1", "reports");
				redirectURLObject.setParameter(
					"viewType", CampaignConstants.VIEW_TYPE);
			}
			else {
				redirectURLObject.setParameter(
					"mvcRenderCommandName",
					ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
				redirectURLObject.setParameter(
					"viewType", UserSegmentConstants.VIEW_TYPE);
			}

			redirectURLObject.setParameter(
				"classNameId", String.valueOf(getClassNameId()));
			redirectURLObject.setParameter(
				"classPK", String.valueOf(getClassPK()));

			redirectURL = redirectURLObject.toString();
		}

		_redirect = redirectURL;

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
			PortletConfig portletConfig =
				(PortletConfig)_renderRequest.getAttribute(
					JavaConstants.JAVAX_PORTLET_CONFIG);

			_reportTitle = LanguageUtil.get(
				portletConfig.getResourceBundle(themeDisplay.getLocale()),
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
	private Long _classNameId;
	private Long _classPK;
	private String _redirect;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private Report _report;
	private ReportInstance _reportInstance;
	private Long _reportInstanceId;
	private String _reportKey;
	private String _reportTitle;
	private final HttpServletRequest _request;
	private Map<String, Object> _templateContext;

}