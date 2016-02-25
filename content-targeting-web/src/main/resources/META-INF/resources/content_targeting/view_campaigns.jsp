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

boolean includeCheckBox = ContentTargetingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_CAMPAIGN);

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", ContentTargetingPath.VIEW);
portletURL.setParameter("tabs1", "campaigns");
%>

<liferay-util:include page="/content_targeting/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= Boolean.TRUE.toString() %>" />
</liferay-util:include>

<liferay-frontend:management-bar
	includeCheckBox="<%= includeCheckBox %>"
	searchContainerId="campaigns"
>
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

	<c:if test="<%= includeCheckBox %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteCampaigns" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<portlet:actionURL name="deleteCampaign" var="deleteCampaignsURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteCampaignsURL %>" cssClass="container-fluid-1280" method="post" name="fmCampaigns">
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

	<c:if test="<%= includeCheckBox %>">
		A.one('#<portlet:namespace />deleteCampaigns').on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					submitForm(document.<portlet:namespace />fmCampaigns);
				}
			}
		);
	</c:if>
</aui:script>