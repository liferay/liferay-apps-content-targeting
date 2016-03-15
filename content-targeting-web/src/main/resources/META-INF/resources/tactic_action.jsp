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

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Tactic tactic = (Tactic)row.getObject();
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
	<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editTacticURL">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_TACTIC %>" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="tacticId" value="<%= String.valueOf(tactic.getTacticId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editTacticURL %>"
		/>

		<portlet:actionURL name="deleteTactic" var="deleteTacticURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="tacticId" value="<%= String.valueOf(tactic.getTacticId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteTacticURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>