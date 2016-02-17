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

<%@ include file="/html/init.jsp" %>

<liferay-ui:error key="com.liferay.content.targeting.exception.UsedUserSegmentException">
	<liferay-ui:message key="the-following-user-segments" />

	<ul>

		<%
		List<UserSegment> usedUserSegments = (List<UserSegment>)SessionMessages.get(request, "usedUserSegments");

		for (UserSegment userSegment : usedUserSegments) {
		%>

			<li><%= userSegment.getName(locale) %></li>

		<%
		}
		%>

	</ul>

	<liferay-ui:message key="cannot-be-deleted-because-they-are-used-in-the-following-campaigns" />

	<ul>

		<%
		for (Campaign campaign : ((UsedUserSegmentException)errorException).getCampaigns()) {
		%>

			<li><%= campaign.getName(locale) %></li>

		<%
		}
		%>

	</ul>
</liferay-ui:error>

<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />
	<portlet:param name="tabs1" value="user-segments" />
</portlet:renderURL>

<aui:form action="<%= searchURL %>" method="post" name="fmUserSegment">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="userSegmentIds" type="hidden" />

	<aui:nav-bar>
		<%@ include file="/html/content_targeting/user_segment_toolbar.jsp" %>

		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search
					id="userSegmentKeywords"
					name="userSegmentKeywords"
					placeholder='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "keywords") %>'
				/>
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>

	<div id="<portlet:namespace />userSegmentsPanel">
		<%@ include file="/html/content_targeting/view_user_segments_resources.jsp" %>
	</div>
</aui:form>

<aui:script use="liferay-ajax-search">
	var userSegmentsPanel = A.one('#<portlet:namespace />userSegmentsPanel');
	var inputNode = A.one('#<portlet:namespace />userSegmentKeywords');

	var search = new Liferay.AjaxContentSearch(
		{
			contentPanel: userSegmentsPanel,
			inputNode: inputNode,
			resourceURL: '<liferay-portlet:resourceURL><portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW_USER_SEGMENTS_RESOURCES %>" /><portlet:param name="tabs1" value="user-segments" /></liferay-portlet:resourceURL>',
			namespace: '<portlet:namespace />'
		}
	);
</aui:script>