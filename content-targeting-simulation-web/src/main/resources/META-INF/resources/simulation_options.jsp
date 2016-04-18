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
boolean showUserSegmentSearch = GetterUtil.getBoolean(request.getAttribute("showUserSegmentSearch"));

List<UserSegment> userSegments = (List<UserSegment>)request.getAttribute("userSegments");
%>

<c:if test="<%= showUserSegmentSearch %>">
	<div class="row-fluid search-panels">
		<i class="search-panel-icon"></i>

		<div class="search-panels-bar">
			<aui:input cssClass="search-panels-input search-query span12" label="" name="searchUserSegmentPanel" placeholder='<%= LanguageUtil.get(request, "search") + "..." %>' type="text" />
		</div>
	</div>
</c:if>

<div class="category-wrapper row">
	<div class="category-content flex-container">
		<c:choose>
			<c:when test="<%= ListUtil.isNotEmpty(userSegments) %>">

				<%
				for (UserSegment userSegment : userSegments) {
				%>

					<div class="col-md-6 element flex-container not-matched text-center" data-elementId="<%= userSegment.getUserSegmentId() %>">
						<div class="flex-item-center text-center"><%= StringUtil.shorten(userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId()), 30) %></div>
					</div>

				<%
				}
				%>

			</c:when>
			<c:otherwise>
				<div class="alert alert-info">
					<liferay-ui:message key="the-current-user-does-not-belong-to-any-user-segment" />
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div id="<portlet:namespace /><%= "paginatorUserSegmentsContainer" %>"></div>
</div>

<liferay-portlet:actionURL name="simulateUserSegment" portletName="<%= PortletKeys.CT_SIMULATOR %>" var="simulateUserSegmentURL" />

<aui:script use="liferay-simulator">
	new Liferay.Simulator(
		{
			containerId: 'userSegmentContainer',
			namespace: '<portlet:namespace />',
			portletNamespace: '<%= PortalUtil.getPortletNamespace(PortletKeys.CT_SIMULATOR) %>',
			portletURL: '<%= simulateUserSegmentURL %>',
			searchPanelName: 'searchUserSegmentPanel'
		}
	);
</aui:script>