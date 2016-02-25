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
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Campaign campaign = (Campaign)row.getObject();

int channelsCount = GetterUtil.getInteger(request.getAttribute("channelsCount"));

int reportsCount = GetterUtil.getInteger(request.getAttribute("reportsCount"));
%>

<liferay-ui:icon-menu>
	<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editCampaignURL">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
			<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
			<portlet:param name="classPK" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			method="get"
			url="<%= editCampaignURL %>"
		/>

		<c:if test="<%= reportsCount > 0 %>">
			<portlet:renderURL var="viewCampaignReportsURL">
				<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
				<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
				<portlet:param name="classPK" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
				<portlet:param name="tabs2" value="reports" />
			</portlet:renderURL>

			<liferay-ui:icon
				image="view"
				label="<%= true %>"
				message="reports"
				method="get"
				url="<%= viewCampaignReportsURL %>"
			/>
		</c:if>

		<c:if test="<%= channelsCount > 0 %>">
			<portlet:renderURL var="viewCampaignTacticsURL">
				<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
				<portlet:param name="classPK" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
				<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
				<portlet:param name="tabs2" value="promotions" />
			</portlet:renderURL>

			<liferay-ui:icon
				image="sitemap"
				label="<%= true %>"
				message="promotions"
				method="get"
				url="<%= viewCampaignTacticsURL %>"
			/>
		</c:if>
	</c:if>

	<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteCampaign" var="deleteCampaignURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteCampaignURL %>"
		/>
	</c:if>

	<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Campaign.class.getName() %>"
			modelResourceDescription="<%= campaign.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(campaign.getCampaignId()) %>"
			var="permissionsEntryURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
		/>

		<liferay-ui:icon
			image="permissions"
			method="get"
			url="<%= permissionsEntryURL %>"
			useDialog="<%= true %>"
		/>
	</c:if>
</liferay-ui:icon-menu>