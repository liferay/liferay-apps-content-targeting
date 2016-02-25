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

<%@ include file="/html/init.jsp" %>

<liferay-ui:error key="com.liferay.content.targeting.exception.UsedUserSegmentException">
	<liferay-ui:message key="the-following-user-segments" />

	<ul>

		<%
		List<UserSegment> usedUserSegments = (List<UserSegment>)SessionMessages.get(request, "usedUserSegments");

		for (UserSegment userSegment : usedUserSegments) {
		%>

			<li><%= userSegment.getName(locale) %></li>

		<%
		}
		%>

	</ul>

	<liferay-ui:message key="cannot-be-deleted-because-they-are-used-in-the-following-campaigns" />

	<ul>

		<%
		for (Campaign campaign : ((UsedUserSegmentException)errorException).getCampaigns()) {
		%>

			<li><%= campaign.getName(locale) %></li>

		<%
		}
		%>

	</ul>
</liferay-ui:error>

<liferay-util:include page="/html/content_targeting/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= Boolean.TRUE.toString() %>" />
</liferay-util:include>

<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />
	<portlet:param name="tabs1" value="user-segments" />
</portlet:renderURL>

<aui:form action="<%= searchURL %>" method="post" name="fmUserSegment">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="userSegmentIds" type="hidden" />

	<aui:nav-bar>
		<%@ include file="/html/content_targeting/user_segment_toolbar.jspf" %>
	</aui:nav-bar>

	<div id="<portlet:namespace />userSegmentsPanel">
		<liferay-util:include page="/html/content_targeting/view_user_segments_resources.jsp" servletContext="<%= application %>">
		</liferay-util:include>
	</div>
</aui:form>

<c:if test="<%= ContentTargetingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_USER_SEGMENT) %>">
	<portlet:renderURL var="addUserSegmentURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-user-segment") %>' url="<%= addUserSegmentURL.toString() %>" />
	</liferay-frontend:add-menu>
</c:if>

<aui:script use="liferay-ajax-search">
	var userSegmentsPanel = A.one('#<portlet:namespace />userSegmentsPanel');
	var inputNode = A.one('#<portlet:namespace />keywords');

	var search = new Liferay.AjaxContentSearch(
		{
			contentPanel: userSegmentsPanel,
			inputNode: inputNode,
			resourceURL: '<liferay-portlet:resourceURL><portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW_USER_SEGMENTS_RESOURCES %>" /><portlet:param name="tabs1" value="user-segments" /></liferay-portlet:resourceURL>',
			namespace: '<portlet:namespace />'
		}
	);
</aui:script>