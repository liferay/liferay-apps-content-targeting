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

<%@ include file="/templates/init.jsp" %>

<%
Map<String, Object> displayContext = (Map<String, Object>)request.getAttribute("displayContext");

String redirect = GetterUtil.getString(displayContext.get("redirect"));
Report report = (Report)displayContext.get("report");
String className = GetterUtil.getString(displayContext.get("className"));
long classPK = GetterUtil.getLong(displayContext.get("classPK"));
String name = GetterUtil.getString(displayContext.get("name"));

SearchContainerIterator<UserSegmentContent> searchContainerIterator = (SearchContainerIterator<UserSegmentContent>)displayContext.get("searchContainerIterator");
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
			<%@ include file="/templates/ct_chart.jsp" %>
		</c:if>
	</liferay-ui:search-container>
</div>