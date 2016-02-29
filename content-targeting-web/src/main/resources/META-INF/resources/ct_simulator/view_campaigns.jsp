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
boolean showCampaignsSearch = GetterUtil.getBoolean(request.getAttribute("showCampaignsSearch"));

List<Campaign> campaigns = (List<Campaign>)request.getAttribute("campaigns");
List<Campaign> notMatchedCampaigns = (List<Campaign>)request.getAttribute("notMatchedCampaigns");
%>

<div class="campaign" id="<portlet:namespace />campaignsContainer">

	<%
	request.setAttribute("elements", campaigns);
	request.setAttribute("notMatchedElements", notMatchedCampaigns);
	%>

	<liferay-util:include page="/ct_simulator/render_simulator_lists.jsp" servletContext="<%= application %>">
		<liferay-util:param name="className" value="<%= Campaign.class.getName() %>" />
		<liferay-util:param name="containerId" value="campaignsContainer" />
		<liferay-util:param name="emptyMessage" value="the-current-user-does-not-match-any-campaign" />
		<liferay-util:param name="name" value="campaign" />
		<liferay-util:param name="showSearch" value="<%= String.valueOf(showCampaignsSearch) %>" />
	</liferay-util:include>

</div>