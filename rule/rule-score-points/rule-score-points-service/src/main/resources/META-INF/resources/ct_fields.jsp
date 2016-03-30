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
int scorePoints = GetterUtil.getInteger(displayContext.get("scorePoints"));

boolean trackingContentEnabled = GetterUtil.getBoolean(displayContext.get("trackingContentEnabled"));

boolean trackingPageEnabled = GetterUtil.getBoolean(displayContext.get("trackingPageEnabled"));

UserSegment userSegment = (UserSegment)displayContext.get("userSegment");
%>

<c:if test="<%= !trackingContentEnabled || !trackingPageEnabled %>">
	<div class="alert alert-error">
		<strong>
			<liferay-ui:message key="this-rule-will-not-work-properly-because-content-tracking-or-page-tracking-are-not-enabled" />
		</strong>

		<%
		String enableLocationPortalLabel = LanguageUtil.get(resourceBundle, "portal-settings-content-targeting-analytics");

		String portalSettingsURL = GetterUtil.getString(displayContext.get("portalSettingsURL"));

		if (Validator.isNotNull(portalSettingsURL)) {
			enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>";
		}

		String enableLocationSiteLabel = LanguageUtil.get(resourceBundle, "site-settings-content-targeting-analytics");

		String siteSettingsURL = GetterUtil.getString(displayContext.get("siteSettingsURL"));

		if (Validator.isNotNull(siteSettingsURL)) {
			enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>";
		}
		%>

		<liferay-ui:message arguments='<%= StringUtil.split(enableLocationPortalLabel + "," + enableLocationSiteLabel) %>' key="it-can-be-enabled-in-x-or-in-x" translateArguments="<%= false %>" />
	</div>
</c:if>

<div class="alert alert-info">
	<c:choose>
		<c:when test="<%= userSegment != null %>">
			<liferay-ui:message arguments="<%= userSegment.getName(locale) %>" key="users-will-receive-1-point-for-this-user-segment-every-time-they-visit-a-page-or-content-categorized-under-x" />
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="users-will-receive-1-point-for-this-user-segment-every-time-they-visit-a-page-or-content-categorized-under-this-user-segment" />
		</c:otherwise>
	</c:choose>
</div>

<aui:input helpMessage="set-a-threshold-of-points-that-users-should-meet-in-order-to-be-assigned-to-this-user-segment" label="score-points-threshold" name="scorePoints" type="text" value="<%= scorePoints %>">
	<aui:validator name="number" />
</aui:input>