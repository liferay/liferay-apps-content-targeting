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
ContentTargetingViewReportsDisplayContext contentTargetingViewReportsDisplayContext = new ContentTargetingViewReportsDisplayContext(liferayPortletRequest, liferayPortletResponse);

String tabs1 = ParamUtil.getString(request, "tabs1", "summary");

long campaignId = ParamUtil.getLong(request, "campaignId");
long classPK = ParamUtil.getLong(request, "classPK");

if (Validator.equals(tabs1, "reports")) {
	campaignId = ParamUtil.getLong(request, "classPK");
}
else {
	classPK = campaignId;
}
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<portlet:renderURL var="summaryURL">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_CAMPAIGN %>" />
			<portlet:param name="tabs1" value="summary" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
		</portlet:renderURL>

		<aui:nav-item href="<%= summaryURL %>" label="summary" selected='<%= tabs1.equals("summary") %>' />

		<portlet:renderURL var="viewCampaignReportsURL">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_REPORTS_CAMPAIGN %>" />
			<portlet:param name="tabs1" value="reports" />
			<portlet:param name="classNameId" value="<%= String.valueOf(PortalUtil.getClassNameId(Campaign.class.getName())) %>" />
			<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
			<portlet:param name="viewType" value="<%= CampaignConstants.VIEW_TYPE %>" />
		</portlet:renderURL>

		<aui:nav-item href="<%= viewCampaignReportsURL %>" label="reports" selected='<%= tabs1.equals("reports") %>' />
	</aui:nav>

	<c:if test='<%= Validator.equals(tabs1, "reports") && !contentTargetingViewReportsDisplayContext.isDisabledManagementBar() %>'>
		<aui:nav-bar-search>
			<aui:form action="<%= contentTargetingViewReportsDisplayContext.getPortletURL() %>" name="searchFm">
				<liferay-ui:input-search markupView="lexicon" name="keywords" />
			</aui:form>
		</aui:nav-bar-search>
	</c:if>
</aui:nav-bar>

<c:choose>
	<c:when test='<%= tabs1.equals("summary") %>'>
		<liferay-util:include page="/campaign_summary.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= tabs1.equals("reports") %>'>
		<liferay-util:include page="/view_reports.jsp" servletContext="<%= application %>" />
	</c:when>
</c:choose>