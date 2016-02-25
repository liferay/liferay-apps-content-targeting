<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String backURL = ParamUtil.getString(request, "backURL");
String redirect = ParamUtil.getString(request, "redirect", currentURL);
String reportKey = ParamUtil.getString(request, "reportKey");
long reportInstanceId = ParamUtil.getLong(request, "reportInstanceId");
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

Group scopeGroup = GroupLocalServiceUtil.fetchGroup(scopeGroupId);

ReportsRegistry reportsRegistry = (ReportsRegistry)request.getAttribute("reportsRegistry");

Report report = reportsRegistry.getReport(reportKey);

ReportInstance reportInstance = null;

if (reportInstanceId > 0) {
	reportInstance = ReportInstanceLocalServiceUtil.fetchReportInstance(reportInstanceId);
}

if (Validator.isBlank(backURL)) {
	PortletURL backURLObject = liferayPortletResponse.createRenderURL();

	if (Campaign.class.getName().equals(className)) {
		backURLObject.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_CAMPAIGN);
		backURLObject.setParameter("className", Campaign.class.getName());
		backURLObject.setParameter("classPK", String.valueOf(classPK));
		backURLObject.setParameter("campaignId", String.valueOf(classPK));
	}
	else {
		backURLObject.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_USER_SEGMENT);
		backURLObject.setParameter("className", UserSegment.class.getName());
		backURLObject.setParameter("classPK", String.valueOf(classPK));
		backURLObject.setParameter("userSegmentId", String.valueOf(classPK));
	}

	backURLObject.setParameter("tabs2", "reports");

	backURL = backURLObject.toString();
}

Map<String, Object> templateContext = (Map<String, Object>)request.getAttribute("templateContext");
templateContext.put("className", className);
templateContext.put("classPK", classPK);
templateContext.put("redirect", redirect);
templateContext.put("report", report);
templateContext.put("reportInstance", reportInstance);
templateContext.put("reportInstanceId", reportInstanceId);
templateContext.put("reportKey", reportKey);
%>

<liferay-ui:breadcrumb
	showCurrentGroup="<%= false %>"
	showLayout="<%= false %>"
/>

<liferay-ui:header
	backURL="<%= backURL.toString() %>"
	title="<%= reportInstance.getReportName(locale) %>"
/>

<c:if test="<%= scopeGroup.isStagingGroup() %>">
	<div class="alert alert-warning">
		<liferay-ui:message key="the-staging-environment-is-activated-reports-data-refer-to-the-live-environment" />
	</div>
</c:if>

<liferay-portlet:actionURL name="updateReport" var="updateReportURL">
	<portlet:param name="backURL" value="<%= backURL.toString() %>" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstanceId) %>" />
	<portlet:param name="reportKey" value="<%= report.getReportKey() %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
</liferay-portlet:actionURL>

<liferay-ui:icon
	cssClass="pull-right"
	image="../aui/repeat"
	label="<%= false %>"
	linkCssClass="btn"
	message="update-report"
	url="<%= updateReportURL %>"
/>

<div class="report-description">
	<%= report.getDescription(locale) %>
</div>

<%= report.getHTML(reportInstance, templateContext) %>