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
String backURL = ParamUtil.getString(request, "backURL");

String displayStyle = ParamUtil.getString(request, "displayStyle", "list");

String keywords = ParamUtil.getString(request, "keywords");

long campaignId = ParamUtil.getLong(request, "campaignId", 0);

Campaign campaign = null;

if (campaignId > 0) {
	campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);
}

if (Validator.isNull(backURL)) {
	PortletURL backURLObject = liferayPortletResponse.createRenderURL();

	backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);
	backURLObject.setParameter("tabs1", "campaigns");

	backURL = backURLObject.toString();
}

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.VIEW_TACTICS);
portletURL.setParameter("className", Campaign.class.getName());
portletURL.setParameter("classPK", String.valueOf(campaignId));
portletURL.setParameter("campaignId", String.valueOf(campaignId));

SearchContainerIterator searchContainerIterator = new TacticSearchContainerIterator(campaignId, scopeGroupId, keywords);

boolean hasUpdatePermission = CampaignPermission.contains(permissionChecker, campaign, ActionKeys.UPDATE);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(backURL);

renderResponse.setTitle(campaign.getName(locale));
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="<%= currentURL %>" label="promotions" selected="<%= true %>" />
	</aui:nav>

	<aui:nav-bar-search>
		<aui:form action="<%= portletURL %>" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" name="keywords" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<liferay-frontend:management-bar
	includeCheckBox="<%= hasUpdatePermission %>"
	searchContainerId="tactics"
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

	<c:if test="<%= hasUpdatePermission %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteTactics" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<portlet:actionURL name="deleteTactic" var="deleteTacticsURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteTacticsURL %>" cssClass="container-fluid-1280" method="post" name="fmTactics">
	<liferay-ui:search-container
		emptyResultsMessage="no-promotions-were-found"
		id="tactics"
		iteratorURL="<%= portletURL %>"
		rowChecker="<%= new EmptyOnClickRowChecker(liferayPortletResponse) %>"
		total="<%= searchContainerIterator.getTotal() %>"
	>
		<liferay-ui:search-container-results
			results="<%= searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.model.Tactic"
			keyProperty="tacticId"
			modelVar="tactic"
		>
			<liferay-ui:search-container-column-text
				cssClass="text-strong"
				name="name"
				value="<%= tactic.getName(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="description"
				value="<%= tactic.getDescription(locale) %>"
			/>

			<liferay-ui:search-container-column-jsp
				path="/content_targeting/tactic_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator displayStyle="<%= displayStyle %>" markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<c:if test="<%= hasUpdatePermission %>">
	<liferay-portlet:renderURL var="addTacticURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_TACTIC %>" />
		<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</liferay-portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-promotion") %>' url="<%= addTacticURL %>" />
	</liferay-frontend:add-menu>

	<aui:script use="liferay-util-list-fields">
		$('#<portlet:namespace />deleteTactics').on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					submitForm(document.<portlet:namespace />fmTactics);
				}
			}
		);
	</aui:script>
</c:if>