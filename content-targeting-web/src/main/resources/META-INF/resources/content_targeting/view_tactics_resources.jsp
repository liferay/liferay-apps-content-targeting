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
long campaignId = ParamUtil.getLong(request, "campaignId", 0);

Campaign campaign = null;

if (campaignId > 0) {
	campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);
}

String tacticKeywords = ParamUtil.getString(request, "tacticKeywords");

RowChecker tacticsRowChecker = new RowChecker(liferayPortletResponse);

SearchContainerIterator searchContainerIterator = new TacticSearchContainerIterator(campaignId, scopeGroupId, tacticKeywords);
%>

<liferay-portlet:renderURL varImpl="viewTacticsURL">
	<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
	<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
	<portlet:param name="tabs2" value="promotions" />
	<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(campaignId) %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	emptyResultsMessage="no-promotions-were-found"
	iteratorURL="<%= viewTacticsURL %>"
	rowChecker="<%= tacticsRowChecker %>"
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

		<%
		String editTacticURL = null;
		%>

		<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.UPDATE) %>">

			<%
			PortletURL editTacticURLObject = liferayPortletResponse.createRenderURL();
			editTacticURLObject.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_TACTIC);
			editTacticURLObject.setParameter("redirect", viewTacticsURL.toString());
			editTacticURLObject.setParameter("tacticId", String.valueOf(tactic.getTacticId()));

			editTacticURL = editTacticURLObject.toString();
			%>

		</c:if>

		<liferay-ui:search-container-column-text
			href="<%= editTacticURL %>"
			name="name"
			value="<%= tactic.getName(locale) %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= editTacticURL %>"
			name="description"
			value="<%= tactic.getDescription(locale) %>"
		/>

		<c:if test="<%= editTacticURL != null %>">
			<liferay-ui:search-container-column-text
				align="right"
				name=""
			>
				<liferay-ui:icon-menu>
					<liferay-ui:icon
						image="edit"
						method="get"
						url="<%= editTacticURL %>"
					/>

					<liferay-portlet:actionURL name="deleteTactic" var="deleteTacticURL">
						<portlet:param
							name="redirect"
							value="<%= viewTacticsURL.toString() %>"
						/>
						<portlet:param
							name="tacticId"
							value="<%= String.valueOf(tactic.getTacticId()) %>"
						/>
					</liferay-portlet:actionURL>

					<liferay-ui:icon-delete
						url="<%= deleteTacticURL %>"
					/>
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

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

					<liferay-portlet:renderURL var="redirectURL">
						<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
						<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
						<portlet:param name="tabs2" value="promotions" />
						<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
						<portlet:param name="classPK" value="<%= String.valueOf(campaignId) %>" />
					</liferay-portlet:renderURL>

					<liferay-portlet:actionURL name="deleteTactic" var="deleteTacticsURL">
						<portlet:param
							name="redirect"
							value="<%= redirectURL.toString() %>"
						/>
					</liferay-portlet:actionURL>

					submitForm(document.<portlet:namespace />fmTactics, '<%= deleteTacticsURL %>');
				}
			}
		);
	}
</aui:script>