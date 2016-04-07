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

<c:if test="<%= !formTrackingActionDisplayContext.isTrackingFormEnabled() %>">

	<%
	String enableLocationPortalLabel = LanguageUtil.get(request, "portal-settings-content-targeting-analytics");

	if (Validator.isNotNull(formTrackingActionDisplayContext.getPortalSettingsURL())) {
		enableLocationPortalLabel = "<a href=\"" + formTrackingActionDisplayContext.getPortalSettingsURL() + "\">" + enableLocationPortalLabel + "</a>";
	}

	String enableLocationSiteLabel = LanguageUtil.get(request, "site-settings-content-targeting-analytics");

	if (Validator.isNotNull(formTrackingActionDisplayContext.getSiteSettingsURL())) {
		enableLocationSiteLabel = "<a href=\"" + formTrackingActionDisplayContext.getSiteSettingsURL() + "\">" + enableLocationSiteLabel + "</a>";
	}
	%>

	<p class="text-default">
		<strong><liferay-ui:message key="this-metric-will-not-work-properly-because-form-tracking-is-not-enabled" /></strong>

		<liferay-ui:message arguments="<%= new String[] {enableLocationPortalLabel, enableLocationSiteLabel} %>" key="it-can-be-enabled-in-x-or-in-x" translateArguments="<%= false %>" />
	</p>
</c:if>

<aui:input helpMessage="name-help" label="name" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "alias" %>' type="text" value="<%= formTrackingActionDisplayContext.getAlias() %>">
	<aui:validator name="required" />
</aui:input>

<aui:input helpMessage="enter-the-id-of-the-form-to-be-tracked" label="form-id" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "elementId" %>' type="text" value="<%= formTrackingActionDisplayContext.getElementId() %>">
	<aui:validator name="required" />
</aui:input>

<c:if test="<%= ListUtil.isNotEmpty(formTrackingActionDisplayContext.getEventTypes()) %>">
	<aui:select label="event-type" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "eventType" %>'>

		<%
		for (String curEventType : formTrackingActionDisplayContext.getEventTypes()) {
		%>

			<aui:option label="<%= curEventType %>" selected="<%= Validator.equals(formTrackingActionDisplayContext.getEventType(), curEventType) %>" value="<%= curEventType %>" />

		<%
		}
		%>

	</aui:select>
</c:if>