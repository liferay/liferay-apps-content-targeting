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
int reportsCount = GetterUtil.getInteger(request.getAttribute("reportsCount"));

String keywords = ParamUtil.getString(request, "keywords");

RowChecker userSegmentsRowChecker = new RowChecker(liferayPortletResponse);

SearchContainerIterator searchContainerIterator = new UserSegmentSearchContainerIterator(scopeGroupId, keywords);
%>

<liferay-portlet:renderURL varImpl="viewUserSegmentsURL">
	<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />
	<portlet:param name="tabs1" value="user-segments" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	emptyResultsMessage="no-user-segments-were-found"
	iteratorURL="<%= viewUserSegmentsURL %>"
	rowChecker="<%= userSegmentsRowChecker %>"
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

		<%
		String editUserSegmentURL = null;
		%>

		<c:if test="<%= UserSegmentPermission.contains(permissionChecker, userSegment, ActionKeys.UPDATE) %>">

			<%
			PortletURL editUserSegmentURLObject = liferayPortletResponse.createRenderURL();
			editUserSegmentURLObject.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_USER_SEGMENT);
			editUserSegmentURLObject.setParameter("redirect", viewUserSegmentsURL.toString());
			editUserSegmentURLObject.setParameter("className", UserSegment.class.getName());
			editUserSegmentURLObject.setParameter("classPK", String.valueOf(userSegment.getUserSegmentId()));
			editUserSegmentURLObject.setParameter("userSegmentId", String.valueOf(userSegment.getUserSegmentId()));

			editUserSegmentURL = editUserSegmentURLObject.toString();
			%>

		</c:if>

		<liferay-ui:search-container-column-text
			href="<%= editUserSegmentURL %>"
			name="name"
			value="<%= userSegment.getName(locale) %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= editUserSegmentURL %>"
			name="description"
			value="<%= userSegment.getDescription(locale) %>"
		/>

		<liferay-ui:search-container-column-text
			align="right"
			name=""
		>
			<liferay-ui:icon-menu>
				<c:if test="<%= editUserSegmentURL != null %>">
					<liferay-ui:icon
						image="edit"
						method="get"
						url="<%= editUserSegmentURL %>"
					/>

					<c:if test="<%= reportsCount > 0 %>">
						<liferay-portlet:renderURL var="viewUserSegmentReportsURL">
							<portlet:param
								name="mvcRenderCommand"
								value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>"
							/>
							<portlet:param
								name="redirect"
								value="<%= viewUserSegmentsURL.toString() %>"
							/>
							<portlet:param
								name="className"
								value="<%= UserSegment.class.getName() %>"
							/>
							<portlet:param
								name="classPK"
								value="<%= String.valueOf(userSegment.getUserSegmentId()) %>"
							/>
							<portlet:param
								name="userSegmentId"
								value="<%= String.valueOf(userSegment.getUserSegmentId()) %>"
							/>
							<portlet:param
								name="tabs2"
								value="reports"
							/>
						</liferay-portlet:renderURL>

						<liferay-ui:icon
							image="view"
							label="<%= true %>"
							message="reports"
							method="get"
							url="<%= viewUserSegmentReportsURL.toString() %>"
						/>
					</c:if>
				</c:if>

				<c:if test="<%= UserSegmentPermission.contains(permissionChecker, userSegment, ActionKeys.DELETE) %>">
					<liferay-portlet:actionURL name="deleteUserSegment" var="deleteUserSegmentURL">
						<portlet:param
							name="redirect"
							value="<%= viewUserSegmentsURL.toString() %>"
						/>
						<portlet:param
							name="userSegmentId"
							value="<%= String.valueOf(userSegment.getUserSegmentId()) %>"
						/>
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
						image="permissions"
						method="get"
						url="<%= permissionsEntryURL.toString() %>"
						useDialog="<%= true %>"
					/>
				</c:if>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script use="liferay-util-list-fields">
	var deleteUserSegments = A.one('#<portlet:namespace />deleteUserSegments');

	if (deleteUserSegments) {
		A.one('#<portlet:namespace /><%= searchContainerReference.getId(request) %>SearchContainer').on(
			'click',
			function() {
				var hide = (Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmUserSegment, '<portlet:namespace />allRowIds').length == 0);

				deleteUserSegments.toggle(!hide);
			},
			'input[type=checkbox]'
		);

		deleteUserSegments.on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					document.<portlet:namespace />fmUserSegment.<portlet:namespace />userSegmentIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmUserSegment, '<portlet:namespace />allRowIds');

					<liferay-portlet:renderURL var="redirectURL">
						<portlet:param
							name="mvcPath"
							value="<%= ContentTargetingPath.VIEW %>"
						/>
						<portlet:param
							name="tabs1"
							value="user-segments"
						/>
					</liferay-portlet:renderURL>

					<liferay-portlet:actionURL name="deleteUserSegment" var="deleteUserSegmentURL">
						<portlet:param
							name="redirect"
							value="<%= redirectURL %>"
						/>
					</liferay-portlet:actionURL>

					submitForm(document.<portlet:namespace />fmUserSegment, '<%= deleteUserSegmentURL %>');
				}
			}
		);
	}
</aui:script>