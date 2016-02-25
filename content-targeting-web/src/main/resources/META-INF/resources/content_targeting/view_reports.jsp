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
String redirect = ParamUtil.getString(request, "redirect");
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

Group scopeGroup = GroupLocalServiceUtil.fetchGroup(scopeGroupId);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(LanguageUtil.get(portletConfig.getResourceBundle(locale), "reports"));
%>

<c:if test="<%= scopeGroup.isStagingGroup() %>">
	<div class="alert alert-warning">
		<liferay-ui:message key="the-staging-environment-is-activated-reports-data-refer-to-the-live-environment" />

		<c:if test="<%= classPK <= 0 %>">
			<strong><liferay-ui:message key="you-must-publish-to-live-before-you-can-view-any-reports" /></strong>
		</c:if>
	</div>
</c:if>

<liferay-portlet:renderURL var="searchURL">
	<portlet:param name="redirect" value="<%= redirect %>" />

	<c:choose>
		<c:when test="<%= Campaign.class.getName().equals(className) %>">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
			<portlet:param name="campaignId" value="<%= String.valueOf(classPK) %>" />
			<portlet:param name="tabs2" value="reports" />
		</c:when>
		<c:when test="<%= UserSegment.class.getName().equals(className) %>">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_REPORTS %>" />
			<portlet:param name="userSegmentId" value="<%= String.valueOf(classPK) %>" />
		</c:when>
		<c:otherwise>
			<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW_REPORTS %>" />
		</c:otherwise>
	</c:choose>

	<portlet:param name="className" value="<%= className %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="post" name="fmReports">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="reportInstanceIds" type="hidden" />

	<div id="<portlet:namespace />reportsPanel">
		<%@ include file="/content_targeting/report_toolbar.jspf" %>

		<liferay-util:include page="/content_targeting/view_reports_resources.jsp" servletContext="<%= application %>">
			<liferay-util:param name="className" value="<%= className %>" />
			<liferay-util:param name="classPK" value="<%= String.valueOf(classPK) %>" />
		</liferay-util:include>
	</div>
</aui:form>

<aui:script use="liferay-ajax-search">
	var reportsPanel = A.one('#<portlet:namespace />reportsPanel');
	var inputNode = A.one('#<portlet:namespace />reportkeywords');

	var search = new Liferay.AjaxContentSearch(
		{
			contentPanel: reportsPanel,
			inputNode: inputNode,
			resourceURL: '<liferay-portlet:resourceURL><portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW_REPORTS_RESOURCES %>" /><%= String.valueOf(classPK) %>" /></liferay-portlet:resourceURL>',
			namespace: '<portlet:namespace />'
		}
	);
</aui:script>