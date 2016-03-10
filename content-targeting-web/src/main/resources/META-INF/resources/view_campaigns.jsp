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
ContentTargetingViewCampaignDisplayContext contentTargetingViewCampaignDisplayContext = new ContentTargetingViewCampaignDisplayContext(renderRequest, renderResponse);
%>

<liferay-util:include page="/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= String.valueOf(contentTargetingViewCampaignDisplayContext.isSearchEnabled()) %>" />
</liferay-util:include>

<liferay-frontend:management-bar
	disabled="<%= contentTargetingViewCampaignDisplayContext.isDisabledManagementBar() %>"
	includeCheckBox="<%= contentTargetingViewCampaignDisplayContext.isIncludeCheckBox() %>"
	searchContainerId="campaigns"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"list"} %>'
			portletURL="<%= contentTargetingViewCampaignDisplayContext.getPortletURL() %>"
			selectedDisplayStyle="<%= contentTargetingViewCampaignDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= contentTargetingViewCampaignDisplayContext.getPortletURL() %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= contentTargetingViewCampaignDisplayContext.getOrderByCol() %>"
			orderByType="<%= contentTargetingViewCampaignDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"modified-date"} %>'
			portletURL="<%= contentTargetingViewCampaignDisplayContext.getPortletURL() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test="<%= contentTargetingViewCampaignDisplayContext.isIncludeCheckBox() %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteCampaigns" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<portlet:actionURL name="deleteCampaign" var="deleteCampaignsURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteCampaignsURL %>" cssClass="container-fluid-1280" method="post" name="fmCampaigns">
	<liferay-ui:search-container
		searchContainer="<%= contentTargetingViewCampaignDisplayContext.getCampaignSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.model.Campaign"
			keyProperty="campaignId"
			modelVar="campaign"
		>
			<liferay-ui:search-container-column-text
				cssClass="text-strong"
				name="name"
				value="<%= campaign.getName(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="description"
				value="<%= campaign.getDescription(locale) %>"
			/>

			<liferay-ui:search-container-column-date
				name="modified-date"
				value="<%= campaign.getModifiedDate() %>"
			/>

			<liferay-ui:search-container-column-date
				name="start-date"
				value="<%= campaign.getStartDate() %>"
			/>

			<liferay-ui:search-container-column-date
				name="end-date"
				value="<%= campaign.getEndDate() %>"
			/>

			<liferay-ui:search-container-column-text
				name="priority"
				value="<%= String.valueOf(campaign.getPriority()) %>"
			/>

			<liferay-ui:search-container-column-text
				name="status"
			>
				<span class="label <%= CampaignConstants.getStatusCssClass(campaign.getStatus()) %>">
					<liferay-ui:message key="<%= campaign.getStatus() %>" />
				</span>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-jsp
				path="/campaign_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<c:if test="<%= contentTargetingViewCampaignDisplayContext.showAddButton() %>">
	<portlet:renderURL var="addCampaignURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-campaign") %>' url="<%= addCampaignURL.toString() %>" />
	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= contentTargetingViewCampaignDisplayContext.isIncludeCheckBox() %>">
	<aui:script>
		$('#<portlet:namespace />deleteCampaigns').on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					submitForm(document.<portlet:namespace />fmCampaigns);
				}
			}
		);
	</aui:script>
</c:if>