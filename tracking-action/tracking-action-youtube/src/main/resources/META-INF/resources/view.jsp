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

<c:if test="<%= !youtubeTrackingActionDisplayContext.isTrackingYoutubeEnabled() %>">

	<%
	String enableLocationPortalLabel = LanguageUtil.get(request, "portal-settings-content-targeting-analytics");

	if (Validator.isNotNull(youtubeTrackingActionDisplayContext.getPortalSettingsURL())) {
		enableLocationPortalLabel = "<a href=\"" + youtubeTrackingActionDisplayContext.getPortalSettingsURL() + "\">" + enableLocationPortalLabel + "</a>";
	}

	String enableLocationSiteLabel = LanguageUtil.get(request, "site-settings-content-targeting-analytics");

	if (Validator.isNotNull(youtubeTrackingActionDisplayContext.getSiteSettingsURL())) {
		enableLocationSiteLabel = "<a href=\"" + youtubeTrackingActionDisplayContext.getSiteSettingsURL() + "\">" + enableLocationSiteLabel + "</a>";
	}
	%>

	<p class="text-default">
		<strong><liferay-ui:message key="this-metric-will-not-work-properly-because-youtube-videos-tracking-is-not-enabled" /></strong>

		<liferay-ui:message arguments="<%= new String[] {enableLocationPortalLabel, enableLocationSiteLabel} %>" key="it-can-be-enabled-in-x-or-in-x" translateArguments="<%= false %>" />
	</p>
</c:if>

<aui:input helpMessage="name-help" label="name" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "alias" %>' type="text" value="<%= youtubeTrackingActionDisplayContext.getAlias() %>">
	<aui:validator name="required" />
</aui:input>

<aui:input helpMessage="enter-the-id-of-the-youtube-video-to-be-tracked" label="youtube-video-id" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "elementId" %>' type="text" value="<%= youtubeTrackingActionDisplayContext.getElementId() %>">
	<aui:validator name="required" />
</aui:input>

<c:if test="<%= ListUtil.isNotEmpty(youtubeTrackingActionDisplayContext.getEventTypes()) %>">
	<aui:select label="event-type" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "eventType" %>'>

		<%
		for (String curEventType : youtubeTrackingActionDisplayContext.getEventTypes()) {
		%>

			<aui:option label="<%= curEventType %>" selected="<%= curEventType.equals(youtubeTrackingActionDisplayContext.getEventType()) %>" value="<%= curEventType %>" />

		<%
		}
		%>

	</aui:select>
</c:if>