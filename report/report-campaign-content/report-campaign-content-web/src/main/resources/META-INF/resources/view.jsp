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

<c:if test="<%= campaignContentSearchContainer.getTotal() > 0 %>">
	<liferay-util:include page="/chart.jsp" servletContext="<%= application %>" />
</c:if>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		searchContainer="<%= campaignContentSearchContainer %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.report.campaign.content.model.CampaignContent"
			modelVar="campaignContent"
		>
			<liferay-ui:search-container-column-text
				name="title"
				value="<%= campaignContent.getTitle(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="type"
				value="<%= campaignContent.getType(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="event"
				value="<%= LanguageUtil.get(request, campaignContent.getEventType()) %>"
			/>

			<liferay-ui:search-container-column-text
				name="count"
				value="<%= String.valueOf(campaignContent.getCount()) %>"
			/>

			<liferay-ui:search-container-column-date
				name="last-update"
				value="<%= campaignContent.getModifiedDate() %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</div>