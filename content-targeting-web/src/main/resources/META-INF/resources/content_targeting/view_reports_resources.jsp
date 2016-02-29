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
String redirect = ParamUtil.getString(request, "redirect");
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");
String keywords = ParamUtil.getString(request, "keywords");

RowChecker reportsRowChecker = new ReportInstanceRowChecker(liferayPortletResponse);

SearchContainerIterator searchContainerIterator = new ReportSearchContainerIterator(scopeGroupId, keywords, className, classPK);
%>

<liferay-portlet:renderURL varImpl="viewReportsURL">
	<portlet:param name="redirect" value="<%= redirect %>" />
	<portlet:param name="backURL" value="<%= backURL %>" />

	<c:choose>
		<c:when test="<%= Campaign.class.getName().equals(className) %>">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
			<portlet:param name="campaignId" value="<%= String.valueOf(classPK) %>" />
			<portlet:param name="tabs2" value="reports" />
		</c:when>
		<c:when test="<%= UserSegment.class.getName().equals(className) %>">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
			<portlet:param name="userSegmentId" value="<%= String.valueOf(classPK) %>" />
			<portlet:param name="tabs2" value="reports" />
		</c:when>
		<c:otherwise>
			<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW_REPORTS %>" />
		</c:otherwise>
	</c:choose>

	<portlet:param name="className" value="<%= className %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
</liferay-portlet:renderURL>

<c:if test="<%= classPK > 0 %>">
	<liferay-ui:search-container
		emptyResultsMessage="no-reports-were-found"
		id="reports"
		iteratorURL="<%= viewReportsURL %>"
		rowChecker="<%= reportsRowChecker %>"
		total="<%= searchContainerIterator.getTotal() %>"
	>
		<liferay-ui:search-container-results
			results="<%= searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.model.ReportInstance"
			keyProperty="reportInstanceId"
			modelVar="reportInstance"
		>

			<portlet:renderURL var="viewReportURL">
				<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_REPORT %>" />
				<portlet:param name="className" value="<%= className %>" />
				<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
				<portlet:param name="redirect" value="<%= viewReportsURL.toString() %>" />
				<portlet:param name="reportKey" value="<%= reportInstance.getReportKey() %>" />
				<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				cssClass="text-strong"
				href="<%= viewReportURL %>"
				name="name"
				value="<%= reportInstance.getName(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="description"
				value="<%= reportInstance.getDescription(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="type"
				value="<%= reportInstance.getTypeName(locale) %>"
			/>

			<liferay-ui:search-container-column-date
				name="last-update"
				value="<%= reportInstance.getModifiedDate() %>"
			/>

			<liferay-ui:search-container-column-jsp
				path="/content_targeting/reports_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</c:if>