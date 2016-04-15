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
String containerId = HtmlUtil.escapeJS(ParamUtil.getString(request, "containerId"));
String emptyMessage = ParamUtil.getString(request, "emptyMessage");
String name = HtmlUtil.escapeJS(ParamUtil.getString(request, "name"));
boolean showSearch = ParamUtil.getBoolean(request, "showSearch");

List<UserSegment> userSegments = (List<UserSegment>)request.getAttribute("userSegments");
List<Object> elements = (List<Object>)request.getAttribute("elements");
List<Object> notMatchedElements = (List<Object>)request.getAttribute("notMatchedElements");
%>

<c:if test="<%= showSearch %>">
	<div class="row-fluid search-panels">
		<i class="search-panel-icon"></i>

		<div class="search-panels-bar">
			<aui:input cssClass="search-panels-input search-query span12" label="" name='<%= "search" + name + "Panel" %>' placeholder='<%= LanguageUtil.get(request, "search") + "..." %>' type="text" />
		</div>
	</div>
</c:if>

<div class="category-wrapper">
	<div class="category-content flex-container">
		<c:choose>
			<c:when test="<%= ListUtil.isNotEmpty(elements) || ListUtil.isNotEmpty(notMatchedElements) %>">

				<%
				for (Object element : elements) {
					long primaryKey = 0;
					String nameWithGroup = StringPool.BLANK;

					if (className.equals(Campaign.class.getName())) {
						nameWithGroup = ((Campaign)element).getNameWithGroupName(locale, themeDisplay.getScopeGroupId());
						primaryKey = ((Campaign)element).getPrimaryKey();
					}
					else {
						nameWithGroup = ((UserSegment)element).getNameWithGroupName(locale, themeDisplay.getScopeGroupId());
						primaryKey = ((UserSegment)element).getPrimaryKey();
					}

					nameWithGroup = StringUtil.shorten(nameWithGroup, 30);
				%>

					<div class="col-md-6 element flex-container matched text-center" data-elementId="<%= primaryKey %>">
						<div class="flex-item-center text-center"><%= nameWithGroup %></div>
					</div>

				<%
				}

				for (Object element : notMatchedElements) {
					long primaryKey = 0;
					String nameWithGroup = StringPool.BLANK;

					if (className.equals(Campaign.class.getName())) {
						nameWithGroup = ((Campaign)element).getNameWithGroupName(locale, themeDisplay.getScopeGroupId());
						primaryKey = ((Campaign)element).getPrimaryKey();
					}
					else {
						nameWithGroup = ((UserSegment)element).getNameWithGroupName(locale, themeDisplay.getScopeGroupId());
						primaryKey = ((UserSegment)element).getPrimaryKey();
					}

					nameWithGroup = StringUtil.shorten(nameWithGroup, 30);
				%>

					<div class="col-md-6 element flex-container text-center" data-elementId="<%= primaryKey %>">
						<div class="flex-item-center text-center"><%= nameWithGroup %></div>
					</div>

				<%
				}
				%>

			</c:when>
			<c:otherwise>
				<div class="alert alert-info">
					<liferay-ui:message key="<%= emptyMessage %>" />
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div id="<portlet:namespace /><%= "paginator" + name + "UserSegmentsContainer" %>"></div>
</div>

<liferay-portlet:actionURL name="simulateUserSegment" portletName="<%= PortletKeys.CT_SIMULATOR %>" var="simulateUserSegmentURL" />

<aui:script use="liferay-simulator">
	new Liferay.Simulator(
		{
			containerId: '<%= containerId %>',
			name: '<%= name %>',
			namespace: '<portlet:namespace />',
			portletNamespace: '<%= PortalUtil.getPortletNamespace(PortletKeys.CT_SIMULATOR) %>',
			portletURL: '<%= simulateUserSegmentURL %>'
		}
	);
</aui:script>