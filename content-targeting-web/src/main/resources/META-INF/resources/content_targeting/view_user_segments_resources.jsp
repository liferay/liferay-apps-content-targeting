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
String keywords = ParamUtil.getString(request, "keywords");

SearchContainerIterator searchContainerIterator = new UserSegmentSearchContainerIterator(scopeGroupId, keywords);
%>

<liferay-portlet:renderURL varImpl="viewUserSegmentsURL">
	<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />
	<portlet:param name="tabs1" value="user-segments" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	emptyResultsMessage="no-user-segments-were-found"
	id="userSegments"
	iteratorURL="<%= viewUserSegmentsURL %>"
	rowChecker="<%= new EmptyOnClickRowChecker(liferayPortletResponse) %>"
	total="<%= searchContainerIterator.getTotal() %>"
>
	<liferay-ui:search-container-results
		results="<%= searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.content.targeting.model.UserSegment"
		keyProperty="userSegmentId"
		modelVar="userSegment"
	>
		<liferay-ui:search-container-column-text
			cssClass="text-strong"
			name="name"
			value="<%= userSegment.getName(locale) %>"
		/>

		<liferay-ui:search-container-column-text
			name="description"
			value="<%= userSegment.getDescription(locale) %>"
		/>

		<liferay-ui:search-container-column-jsp
			path="/content_targeting/user_segments_action.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>