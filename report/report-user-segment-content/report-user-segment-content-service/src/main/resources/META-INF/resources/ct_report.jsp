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
String redirect = userSegmentContentReportDisplayContext.getRedirect();
Report report = userSegmentContentReportDisplayContext.getReport();
String className = userSegmentContentReportDisplayContext.getClassName();
long classPK = userSegmentContentReportDisplayContext.getClassPK();
String name = userSegmentContentReportDisplayContext.getName();

SearchContainerIterator<UserSegmentContent> searchContainerIterator = userSegmentContentReportDisplayContext.getSearchContainerIterator();
%>

<liferay-portlet:renderURL varImpl="portletURL">
	<portlet:param
		name="mvcRenderCommandName"
		value="viewReport"
	/>
	<portlet:param
		name="redirect"
		value="<%= redirect %>"
	/>
	<portlet:param
		name="reportKey"
		value="<%= report.getReportKey() %>"
	/>
	<portlet:param
		name="className"
		value="<%= className %>"
	/>
	<portlet:param
		name="classPK"
		value="<%= String.valueOf(classPK) %>"
	/>
</liferay-portlet:renderURL>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		emptyResultsMessage='<%= LanguageUtil.format(resourceBundle, "there-is-not-enough-data-to-generate-a-content-views-report-for-the-user-segment-x", name) %>'
		iteratorURL="<%= portletURL %>"
		total="<%= searchContainerIterator.getTotal() %>"
	>

		<liferay-ui:search-container-results
			results="<%= searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent"
			modelVar="userSegmentContent"
		>

			<liferay-ui:search-container-column-text
				name="title"
				value="<%= userSegmentContent.getTitle(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="type"
				value="<%= userSegmentContent.getType(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="event"
				value="<%= LanguageUtil.get(request, userSegmentContent.getEventType()) %>"
			/>

			<liferay-ui:search-container-column-text
				name="count"
				value="<%= String.valueOf(userSegmentContent.getCount()) %>"
			/>

			<liferay-ui:search-container-column-date
				name="last-update"
				value="<%= userSegmentContent.getModifiedDate() %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />

		<c:if test="<%= searchContainer.getResults().size() > 0 %>">
			<liferay-util:include page="/ct_chart.jsp" servletContext="<%= application %>">
				<liferay-util:param name="start" value="<%= String.valueOf(searchContainer.getStart()) %>" />
				<liferay-util:param name="end" value="<%= String.valueOf(searchContainer.getEnd()) %>" />
			</liferay-util:include>
		</c:if>
	</liferay-ui:search-container>
</div>