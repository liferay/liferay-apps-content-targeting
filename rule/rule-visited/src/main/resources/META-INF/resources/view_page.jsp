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

<c:if test="<%= !ruleVisitedDisplayContext.isTrackingPageEnabled() %>">
	<p class="text-default">
		<strong><liferay-ui:message key="this-rule-will-not-work-properly-because-page-tracking-is-not-enabled" /></strong>

		<%
		String enableLocationPortalLabel = LanguageUtil.get(resourceBundle, "portal-settings-content-targeting-analytics");

		if (Validator.isNotNull(ruleVisitedDisplayContext.getPortalSettingsAnalyticsURL())) {
			enableLocationPortalLabel = "<a href=\"" + ruleVisitedDisplayContext.getPortalSettingsAnalyticsURL() + "\">" + enableLocationPortalLabel + "</a>";
		}

		String enableLocationSiteLabel = LanguageUtil.get(resourceBundle, "site-settings-content-targeting-analytics");

		if (Validator.isNotNull(ruleVisitedDisplayContext.getSiteSettingsAnalyticsURL())) {
			enableLocationSiteLabel = "<a href=\"" + ruleVisitedDisplayContext.getSiteSettingsAnalyticsURL() + "\">" + enableLocationSiteLabel + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= new String[] {enableLocationPortalLabel, enableLocationSiteLabel} %>" key="it-can-be-enabled-in-x-or-in-x" translateArguments="<%= false %>" />
	</p>
</c:if>

<aui:input checked="<%= !ruleVisitedDisplayContext.isPrivateLayout() %>" inlineField="<%= true %>" label="public-pages" name="privateLayout" onChange="if (this.checked) {<%= renderResponse.getNamespace() %>updateFriendlyURL('<%= HtmlUtil.escape(ruleVisitedDisplayContext.getFriendlyURLPublicBase()) %>');}" type="radio" value="<%= false %>" />

<aui:input checked="<%= ruleVisitedDisplayContext.isPrivateLayout() %>" inlineField="<%= true %>" label="private-pages" name="privateLayout" onChange="if (this.checked) {<%= renderResponse.getNamespace() %>updateFriendlyURL('<%= HtmlUtil.escape(ruleVisitedDisplayContext.getFriendlyURLPrivateBase()) %>');}" type="radio" value="<%= true %>" />

<aui:input helpMessage="enter-the-friendly-url-of-the-page-to-be-tracked" label="friendly-url" name="friendlyURL" prefix="<%= ruleVisitedDisplayContext.getFriendlyURLBase() %>" type="text" value="<%= ruleVisitedDisplayContext.getFriendlyURL() %>">
	<aui:validator name="required" />
</aui:input>

<aui:script>
	function #<portlet:namespace />updateFriendlyURL(value) {
		var A = AUI();

		A.one('#<portlet:namespace />friendlyURL').previous().setHTML(value);
	}
</aui:script>