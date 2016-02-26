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
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ReportInstance reportInstance = (ReportInstance)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= reportInstance.isInstantiable() %>">
		<liferay-portlet:renderURL var="editReportURL">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_REPORT %>" />
			<portlet:param name="className" value="<%= className %>" />
			<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
			<portlet:param name="reportKey" value="<%= reportInstance.getReportKey() %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			method="get"
			url="<%= editReportURL.toString() %>"
		/>

		<liferay-portlet:actionURL name="deleteReportInstance" var="deleteReportURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
		</liferay-portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteReportURL.toString() %>"
		/>
	</c:if>

	<liferay-ui:icon
		image="view"
		label="<%= true %>"
		message="view-report"
		method="get"
		url="<%= viewReportURL.toString() %>"
	/>

	<liferay-portlet:actionURL name="updateReport" var="updateReportURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
		<portlet:param name="reportKey" value="<%= reportInstance.getReportKey() %>" />
		<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
	</liferay-portlet:actionURL>

	<liferay-ui:icon
		image="undo"
		label="<%= true %>"
		message="update-report"
		method="post"
		url="<%= updateReportURL.toString() %>"
	/>
</liferay-ui:icon-menu>