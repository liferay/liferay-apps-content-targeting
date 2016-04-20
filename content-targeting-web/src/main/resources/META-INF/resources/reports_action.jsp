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
ContentTargetingViewReportsDisplayContext contentTargetingViewReportsDisplayContext = new ContentTargetingViewReportsDisplayContext(liferayPortletRequest, liferayPortletResponse);

long classNameId = ParamUtil.getLong(request, "classNameId");
long classPK = ParamUtil.getLong(request, "classPK");

String viewType = ParamUtil.getString(request, "viewType");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ReportInstance reportInstance = (ReportInstance)row.getObject();
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
	<c:if test="<%= reportInstance.isInstantiable() %>">
		<liferay-portlet:renderURL var="editReportURL">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_REPORT %>" />
			<portlet:param name="classNameId" value="<%= String.valueOf(classNameId) %>" />
			<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
			<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
			<portlet:param name="reportKey" value="<%= reportInstance.getReportKey() %>" />
			<portlet:param name="viewType" value="<%= viewType %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editReportURL %>"
		/>

		<liferay-portlet:actionURL name="deleteReportInstance" var="deleteReportURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
		</liferay-portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteReportURL %>"
		/>
	</c:if>

	<%
	List<BaseJSPPortletConfigurationIcon> configurationIcons = contentTargetingViewReportsDisplayContext.getConfigurationIcons(reportInstance);
	%>

	<c:if test="<%= ListUtil.isNotEmpty(configurationIcons) %>">

		<%
		for (BaseJSPPortletConfigurationIcon configurationIcon : configurationIcons) {
		%>

			<liferay-util:include page="<%= configurationIcon.getJspPath() %>" servletContext="<%= configurationIcon.getServletContext() %>" />

		<%
		}
		%>

	</c:if>

	<liferay-portlet:actionURL name="updateReport" var="updateReportURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
		<portlet:param name="reportKey" value="<%= reportInstance.getReportKey() %>" />
		<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
	</liferay-portlet:actionURL>

	<liferay-ui:icon
		message="update-report"
		method="post"
		url="<%= updateReportURL %>"
	/>
</liferay-ui:icon-menu>