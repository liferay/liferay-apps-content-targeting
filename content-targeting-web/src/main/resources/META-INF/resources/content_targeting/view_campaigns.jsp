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
String displayStyle = ParamUtil.getString(request, "displayStyle", "list");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", ContentTargetingPath.VIEW);
portletURL.setParameter("tabs1", "campaigns");
%>

<liferay-util:include page="/content_targeting/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= Boolean.TRUE.toString() %>" />
</liferay-util:include>

<liferay-frontend:management-bar>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"list"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
			selectedDisplayStyle="<%= displayStyle %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
		/>
	</liferay-frontend:management-bar-filters>
</liferay-frontend:management-bar>

<aui:form action="<%= portletURL %>" cssClass="container-fluid-1280" method="post" name="fmCampaigns">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="campaignsIds" type="hidden" />

	<aui:nav-bar>
		<%@ include file="/content_targeting/campaign_toolbar.jspf" %>
	</aui:nav-bar>

	<div id="<portlet:namespace />campaignsPanel">
		<liferay-util:include page="/content_targeting/view_campaigns_resources.jsp" servletContext="<%= application %>" />
	</div>
</aui:form>

<c:if test="<%= ContentTargetingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CAMPAIGN) %>">
	<portlet:renderURL var="addCampaignURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-campaign") %>' url="<%= addCampaignURL.toString() %>" />
	</liferay-frontend:add-menu>
</c:if>

<aui:script use="liferay-ajax-search">
	var campaignsPanel = A.one('#<portlet:namespace />campaignsPanel');
	var inputNode = A.one('#<portlet:namespace />keywords');

	var search = new Liferay.AjaxContentSearch(
		{
			contentPanel: campaignsPanel,
			inputNode: inputNode,
			resourceURL: '<portlet:resourceURL><portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW_CAMPAIGNS_RESOURCES %>" /><portlet:param name="tabs1" value="campaigns" /></portlet:resourceURL>',
			namespace: '<portlet:namespace />'
		}
	);
</aui:script>