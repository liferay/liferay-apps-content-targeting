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
long campaignId = ParamUtil.getLong(request, "campaignId", 0);

Campaign campaign = null;

if (campaignId > 0) {
	campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);
}
%>

<liferay-portlet:renderURL var="searchURL">
	<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_TACTICS %>" />
	<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(campaignId) %>" />
	<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
</liferay-portlet:renderURL>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="<%= currentURL %>" label="tactics" selected="<%= true %>" />
	</aui:nav>

	<%@ include file="/content_targeting/tactic_toolbar.jspf" %>

	<aui:nav-bar-search>
		<aui:form action="<%= searchURL %>" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" name="keywords" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<aui:form action="<%= searchURL %>" method="post" name="fmTactics">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="campaignId" type="hidden" value="<%= campaignId %>" />
	<aui:input name="tacticsIds" type="hidden" />

	<%
	String keywords = ParamUtil.getString(request, "keywords");

	SearchContainerIterator searchContainerIterator = new TacticSearchContainerIterator(campaignId, scopeGroupId, keywords);
	%>

	<liferay-portlet:renderURL varImpl="viewTacticsURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_TACTICS %>" />
		<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
		<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
		<portlet:param name="classPK" value="<%= String.valueOf(campaignId) %>" />
	</liferay-portlet:renderURL>

	<liferay-ui:search-container
		emptyResultsMessage="no-promotions-were-found"
		iteratorURL="<%= viewTacticsURL %>"
		rowChecker="<%= new RowChecker(liferayPortletResponse) %>"
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

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>

<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.UPDATE) %>">
	<liferay-portlet:renderURL var="addTacticURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_TACTIC %>" />
		<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</liferay-portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-promotion") %>' url="<%= addTacticURL %>" />
	</liferay-frontend:add-menu>
</c:if>

<aui:script use="liferay-util-list-fields">
	var deleteTactics = A.one('#<portlet:namespace />deleteTactics');

	if (deleteTactics) {
		A.one('#<portlet:namespace /><%= searchContainerReference.getId(request) %>SearchContainer').on(
			'click',
			function() {
				var hide = (Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmTactics, '<portlet:namespace />allRowIds').length == 0);

				deleteTactics.toggle(!hide);
			},
			'input[type=checkbox]'
		);

		deleteTactics.on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					document.<portlet:namespace />fmTactics.<portlet:namespace />tacticsIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmTactics, '<portlet:namespace />allRowIds');

					<portlet:actionURL name="deleteTactic" var="deleteTacticsURL">
						<portlet:param name="redirect" value="<%= currentURL %>" />
					</portlet:actionURL>

					submitForm(document.<portlet:namespace />fmTactics, '<%= deleteTacticsURL %>');
				}
			}
		);
	}
</aui:script>