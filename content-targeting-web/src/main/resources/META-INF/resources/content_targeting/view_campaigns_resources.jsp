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
String keywords = ParamUtil.getString(request, "keywords");

SearchContainerIterator searchContainerIterator = new CampaignSearchContainerIterator(scopeGroupId, keywords);
%>

<liferay-portlet:renderURL varImpl="viewCampaignsURL">
	<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />
	<portlet:param name="tabs1" value="campaigns" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	emptyResultsMessage="no-campaigns-were-found"
	id="campaigns"
	iteratorURL="<%= viewCampaignsURL %>"
	rowChecker="<%= new EmptyOnClickRowChecker(liferayPortletResponse) %>"
	total="<%= searchContainerIterator.getTotal() %>"
>
	<liferay-ui:search-container-results
		results="<%= searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

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
			path="/content_targeting/campaign_action.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>