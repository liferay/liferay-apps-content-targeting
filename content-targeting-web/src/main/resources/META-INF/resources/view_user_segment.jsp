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
ContentTargetingViewUserSegmentDisplayContext contentTargetingViewUserSegmentDisplayContext = new ContentTargetingViewUserSegmentDisplayContext(liferayPortletRequest, liferayPortletResponse);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingViewUserSegmentDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingViewUserSegmentDisplayContext.getUserSegmentTitle());
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="<%= contentTargetingViewUserSegmentDisplayContext.getSummaryURL() %>" label="summary" selected="<%= contentTargetingViewUserSegmentDisplayContext.isShowSummary() %>" />

		<aui:nav-item href="<%= contentTargetingViewUserSegmentDisplayContext.getReportsURL() %>" label="reports" selected="<%= contentTargetingViewUserSegmentDisplayContext.isShowReports() %>" />
	</aui:nav>

	<c:if test="<%= contentTargetingViewUserSegmentDisplayContext.isDisabledReportsManagementBar() %>">
		<aui:nav-bar-search>
			<aui:form action="<%= contentTargetingViewUserSegmentDisplayContext.getReportsURL() %>" name="searchFm">
				<liferay-ui:input-search markupView="lexicon" name="keywords" />
			</aui:form>
		</aui:nav-bar-search>
	</c:if>
</aui:nav-bar>

<c:choose>
	<c:when test="<%= contentTargetingViewUserSegmentDisplayContext.isShowSummary() %>">
		<liferay-util:include page="/user_segment_summary.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test="<%= contentTargetingViewUserSegmentDisplayContext.isShowReports() %>">
		<liferay-util:include page="/view_reports.jsp" servletContext="<%= application %>" />
	</c:when>
</c:choose>