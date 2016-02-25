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
long userSegmentId = ParamUtil.getLong(request, "userSegmentId");

UserSegment userSegment = null;

String userSegmentTitle = LanguageUtil.get(portletConfig.getResourceBundle(locale), "new-user-segment");

String pills = "details";

if (userSegmentId > 0) {
	userSegment = UserSegmentLocalServiceUtil.fetchUserSegment(userSegmentId);

	userSegmentTitle = userSegment.getName(locale);

	pills = "details,reports";
}

if (Validator.isNull(backURL)) {
	PortletURL backURLObject = liferayPortletResponse.createRenderURL();

	backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);
	backURLObject.setParameter("tabs1", "user-segments");

	backURL = backURLObject.toString();
}

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(backURL.toString());

renderResponse.setTitle(userSegmentTitle);
%>

<liferay-portlet:renderURL varImpl="switchTabsURL">
	<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
	<portlet:param name="className" value="<%= UserSegment.class.getName() %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(userSegmentId) %>" />
	<portlet:param name="userSegmentId" value="<%= String.valueOf(userSegmentId) %>" />
</liferay-portlet:renderURL>

<liferay-ui:tabs
	names="<%= pills %>"
	param="tabs2"
	portletURL="<%= switchTabsURL %>"
	refresh="<%= true %>"
	type="pills"
	value="<%= tabs2 %>"
>
	<liferay-ui:section>
		<%@ include file="/content_targeting/user_segment_details.jspf" %>
	</liferay-ui:section>

	<c:if test="<%= userSegmentId > 0 %>">
		<liferay-ui:section>
			<liferay-util:include page="/content_targeting/view_reports.jsp" servletContext="<%= application %>">
			</liferay-util:include>
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>