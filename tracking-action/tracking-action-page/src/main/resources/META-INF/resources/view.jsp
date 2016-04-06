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

<c:if test="<%= !pageTrackingActionDisplayContext.isTrackingPageEnabled() %>">

	<%
	String enableLocationPortalLabel = LanguageUtil.get(request, "portal-settings-content-targeting-analytics");

	if (Validator.isNotNull(pageTrackingActionDisplayContext.getPortalSettingsAnalyticsURL())) {
		enableLocationPortalLabel = "<a href=\"" + pageTrackingActionDisplayContext.getPortalSettingsAnalyticsURL() + "\">" + enableLocationPortalLabel + "</a>";
	}

	String enableLocationSiteLabel = LanguageUtil.get(request, "site-settings-content-targeting-analytics");

	if (Validator.isNotNull(pageTrackingActionDisplayContext.getSiteSettingsAnalyticsURL())) {
		enableLocationSiteLabel = "<a href=\"" + pageTrackingActionDisplayContext.getSiteSettingsAnalyticsURL() + "\">" + enableLocationSiteLabel + "</a>";
	}
	%>

	<p class="text-default">
		<strong><liferay-ui:message key="this-metric-will-not-work-properly-because-page-tracking-is-not-enabled" /></strong>

		<liferay-ui:message arguments="<%= new String[] {enableLocationPortalLabel, enableLocationSiteLabel} %>" key="it-can-be-enabled-in-x-or-in-x" translateArguments="<%= false %>" />
	</p>
</c:if>

<aui:input helpMessage="name-help" label="name" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "alias" %>' type="text" value="<%= pageTrackingActionDisplayContext.getAlias() %>">
	<aui:validator name="required" />
</aui:input>

<%
String onClickPublicInput = "if (this.checked) {" + renderResponse.getNamespace() + "updateFriendlyURL('" + HtmlUtil.escape(pageTrackingActionDisplayContext.getFriendlyURLPublicBase()) + "');}";
%>

<aui:input checked="<%= !pageTrackingActionDisplayContext.isPrivateLayout() %>" inlineField="<%= true %>" label="public-pages" name="privateLayout" onChange="<%= onClickPublicInput %>" type="radio" value="<%= false %>" />

<%
String onClickPrivateInput = "if (this.checked) {" + renderResponse.getNamespace() + "updateFriendlyURL('" + HtmlUtil.escape(pageTrackingActionDisplayContext.getFriendlyURLPrivateBase()) + "');}";
%>

<aui:input checked="<%= pageTrackingActionDisplayContext.isPrivateLayout() %>" inlineField="<%= true %>" label="private-pages" name="privateLayout" onChange="<%= onClickPrivateInput %>" type="radio" value="<%= true %>" />

<aui:input helpMessage="enter-the-friendly-url-of-the-page-to-be-tracked" label="friendly-url" name="friendlyURL" prefix="<%= pageTrackingActionDisplayContext.getFriendlyURLBase() %>" style="width: auto;" type="text" value="<%= pageTrackingActionDisplayContext.getFriendlyURL() %>">
	<aui:validator name="required" />
</aui:input>

<c:if test="<%= ListUtil.isNotEmpty(pageTrackingActionDisplayContext.getEventTypes()) %>">
	<aui:select label="event-type" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "eventType" %>'>

		<%
		for (String curEventType : pageTrackingActionDisplayContext.getEventTypes()) {
		%>

			<aui:option label="<%= curEventType %>" selected="<%= Validator.equals(pageTrackingActionDisplayContext.getEventType(), curEventType) %>" value="<%= curEventType %>" />

		<%
		}
		%>

	</aui:select>
</c:if>

<aui:script>
	function <portlet:namespace />updateFriendlyURL(value) {
		var A = AUI();

		A.one('#<portlet:namespace />friendlyURL').previous().setHTML(value);
	}
</aui:script>