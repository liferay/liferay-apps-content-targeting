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

Map<String, Object> templateContext = (Map<String, Object>)request.getAttribute("templateContext");

templateContext.put("className", className);
templateContext.put("classPK", classPK);
templateContext.put("redirect", redirect);
templateContext.put("report", report);
templateContext.put("reportInstance", reportInstance);
templateContext.put("reportInstanceId", reportInstanceId);
templateContext.put("reportKey", reportKey);
%>

<div class="container-fluid-1280 report-preview">
	<c:if test="<%= scopeGroup.isStagingGroup() %>">
		<div class="alert alert-warning">
			<liferay-ui:message key="the-staging-environment-is-activated-reports-data-refer-to-the-live-environment" />
		</div>
	</c:if>

	<p class="text-default">
		<%= report.getDescription(locale) %>
	</p>

	<%= report.getHTML(reportInstance, templateContext) %>
</div>