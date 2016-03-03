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
String orderByCol = ParamUtil.getString(request, "orderByCol", "modified-date");
String orderByType = ParamUtil.getString(request, "orderByType", "asc");

boolean includeCheckBox = ContentTargetingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_CAMPAIGN);

String keywords = ParamUtil.getString(request, "keywords");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", ContentTargetingPath.VIEW);
portletURL.setParameter("tabs1", "campaigns");

if (Validator.isNotNull(keywords)) {
	portletURL.setParameter("keywords", keywords);
}

SearchContainer campaignSearchContainer = new SearchContainer(renderRequest, PortletURLUtil.clone(portletURL, renderResponse), null, "no-campaigns-were-found");

campaignSearchContainer.setId("campaigns");
campaignSearchContainer.setRowChecker(new EmptyOnClickRowChecker(renderResponse));
campaignSearchContainer.setSearch(Validator.isNotNull(keywords));

boolean orderByAsc = false;

if (orderByType.equals("asc")) {
	orderByAsc = true;
}

OrderByComparator<Campaign> orderByComparator = new CampaignModifiedDateComparator(orderByAsc);

campaignSearchContainer.setOrderByCol(orderByCol);
campaignSearchContainer.setOrderByComparator(orderByComparator);
campaignSearchContainer.setOrderByType(orderByType);

if (Validator.isNotNull(keywords)) {
	Sort sort = new Sort(Field.MODIFIED_DATE, Sort.LONG_TYPE, orderByAsc);

	BaseModelSearchResult<Campaign> searchResults = CampaignLocalServiceUtil.searchCampaigns(scopeGroupId, keywords, campaignSearchContainer.getStart(), campaignSearchContainer.getEnd(), sort);

	campaignSearchContainer.setTotal(searchResults.getLength());
	campaignSearchContainer.setResults(searchResults.getBaseModels());
}
else {
	int total = CampaignLocalServiceUtil.getCampaignsCount(scopeGroupId);

	campaignSearchContainer.setTotal(total);

	List results = CampaignLocalServiceUtil.getCampaigns(scopeGroupId, campaignSearchContainer.getStart(), campaignSearchContainer.getEnd(), campaignSearchContainer.getOrderByComparator());

	campaignSearchContainer.setResults(results);
}

boolean isDisabledManagementBar = (campaignSearchContainer.getTotal() <= 0) && Validator.isNull(keywords);
%>

<liferay-util:include page="/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= String.valueOf(!isDisabledManagementBar) %>" />
</liferay-util:include>

<liferay-frontend:management-bar
	disabled="<%= isDisabledManagementBar %>"
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

		<liferay-frontend:management-bar-sort
			orderByCol="<%= orderByCol %>"
			orderByType="<%= orderByType %>"
			orderColumns='<%= new String[] {"modified-date"} %>'
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
	<liferay-ui:search-container
		searchContainer="<%= campaignSearchContainer %>"
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

<c:if test="<%= ContentTargetingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CAMPAIGN) %>">
	<portlet:renderURL var="addCampaignURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-campaign") %>' url="<%= addCampaignURL.toString() %>" />
	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= includeCheckBox %>">
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