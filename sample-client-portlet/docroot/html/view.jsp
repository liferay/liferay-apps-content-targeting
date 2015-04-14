<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

<%@ include file="init.jsp" %>

<h2>User Segments</h2>

<ul>

<%
List<UserSegment> userSegments = (List<UserSegment>)request.getAttribute("userSegments");

for (UserSegment userSegment : userSegments) {

%>

	<li><%= userSegment.getName(locale) %></li>

<%
}
%>

</ul>

<h2>Campaigns</h2>

<ul id="<portlet:namespace/>campaigns">
</ul>

<aui:script use="aui-base">
	var campaignsList = A.one('#<portlet:namespace/>campaigns');

	Liferay.Service(
		'content-targeting-api.campaign/get-campaigns',
		{
	    	groupId: '<%= scopeGroupId %>'
		},
		function(response) {
			if (response.length) {
				A.Array.each(response, function(item) {
					campaignsList.append('<li>' + item.name + '</li>');
				});
			}
		}
	);
</aui:script>
