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

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

UserSegment userSegment = (UserSegment)row.getObject();

int reportsCount = GetterUtil.getInteger(request.getAttribute("reportsCount"));
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
	<c:if test="<%= UserSegmentPermission.contains(permissionChecker, userSegment, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editUserSegmentURL">
			<portlet:param name="mvcRenderCommand" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="className" value="<%= UserSegment.class.getName() %>" />
			<portlet:param name="classPK" value="<%= String.valueOf(userSegment.getUserSegmentId()) %>" />
			<portlet:param name="userSegmentId" value="<%= String.valueOf(userSegment.getUserSegmentId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editUserSegmentURL.toString() %>"
		/>

		<c:if test="<%= reportsCount > 0 %>">
			<portlet:renderURL var="viewUserSegmentReportsURL">
				<portlet:param name="mvcRenderCommand" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="className" value="<%= UserSegment.class.getName() %>" />
				<portlet:param name="classPK" value="<%= String.valueOf(userSegment.getUserSegmentId()) %>" />
				<portlet:param name="userSegmentId" value="<%= String.valueOf(userSegment.getUserSegmentId()) %>" />
				<portlet:param name="tabs2" value="reports" />
			</portlet:renderURL>

			<liferay-ui:icon
				message="reports"
				url="<%= viewUserSegmentReportsURL.toString() %>"
			/>
		</c:if>
	</c:if>

	<c:if test="<%= UserSegmentPermission.contains(permissionChecker, userSegment, ActionKeys.DELETE) %>">
		<liferay-portlet:actionURL name="deleteUserSegment" var="deleteUserSegmentURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="userSegmentId" value="<%= String.valueOf(userSegment.getUserSegmentId()) %>" />
		</liferay-portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteUserSegmentURL.toString() %>"
		/>
	</c:if>

	<c:if test="<%= UserSegmentPermission.contains(permissionChecker, userSegment, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= UserSegment.class.getName() %>"
			modelResourceDescription="<%= userSegment.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(userSegment.getUserSegmentId()) %>"
			var="permissionsEntryURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
		/>

		<liferay-ui:icon
			message="permissions"
			url="<%= permissionsEntryURL.toString() %>"
			useDialog="<%= true %>"
		/>
	</c:if>
</liferay-ui:icon-menu>