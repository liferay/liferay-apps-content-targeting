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
String redirect = ParamUtil.getString(request, "redirect");
String tabs2 = ParamUtil.getString(request, "tabs2");
long campaignId = ParamUtil.getLong(request, "campaignId", 0);

Campaign campaign = null;

String title = "new-campaign";

if (campaignId > 0) {
	campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);

	title = campaign.getName(locale);
}

String campaignTabs ="details";

if (campaign != null) {
	campaignTabs ="details,promotions";
}

if (Validator.isNull(backURL)) {
	PortletURL backURLObject = liferayPortletResponse.createRenderURL();

	backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);
	backURLObject.setParameter("tabs1", "campaigns");

	backURL = backURLObject.toString();
}
%>

<liferay-ui:header
	backURL="<%= backURL.toString() %>"
	title="<%= title %>"
/>

<liferay-portlet:renderURL var="portletURL">
	<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
	<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(campaignId) %>" />
	<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
</liferay-portlet:renderURL>

<liferay-ui:tabs
	names="<%= campaignTabs %>"
	param="tabs2"
	type="pills"
	url="<%= portletURL %>"
	value="<%= tabs2 %>"
>
	<liferay-ui:section>
		<%@ include file="/content_targeting/campaign_details.jspf" %>
	</liferay-ui:section>

	<c:if test="<%= campaign != null %>">
		<liferay-ui:section>
			<liferay-util:include page="/content_targeting/view_tactics.jsp" servletContext="<%= application %>">
			</liferay-util:include>
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>