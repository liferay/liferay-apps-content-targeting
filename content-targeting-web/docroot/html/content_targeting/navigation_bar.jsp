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
String tabs1 = ParamUtil.getString(request, "tabs1", "user-segments");
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<portlet:renderURL var="userSegmentsURL">
			<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />
			<portlet:param name="tabs1" value="user-segments" />
		</portlet:renderURL>

		<aui:nav-item href="<%= userSegmentsURL.toString() %>" label="user-segments" selected='<%= tabs1.equals("user-segments") %>' />

		<portlet:renderURL var="campaignsURL">
			<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />
			<portlet:param name="tabs1" value="campaigns" />
		</portlet:renderURL>

		<aui:nav-item href="<%= campaignsURL.toString() %>" label="campaigns" selected='<%= tabs1.equals("campaigns") %>' />
	</aui:nav>

	<%
	boolean searchEnabled = ParamUtil.getBoolean(request, "searchEnabled");
	%>

	<c:if test="<%= searchEnabled %>">
		<portlet:renderURL var="searchURL">
			<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />

			<c:choose>
				<c:when test='<%= tabs1.equals("user-segments") %>'>
					<portlet:param name="tabs1" value="user-segments" />
				</c:when>
				<c:otherwise>
					<portlet:param name="tabs1" value="campaigns" />
				</c:otherwise>
			</c:choose>
		</portlet:renderURL>

		<aui:nav-bar-search>
			<aui:form action="<%= searchURL %>" name="searchFm">
				<liferay-ui:input-search markupView="lexicon" name="keywords" />
			</aui:form>
		</aui:nav-bar-search>
	</c:if>
</aui:nav-bar>