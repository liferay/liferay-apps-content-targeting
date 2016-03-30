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
String friendlyURL = GetterUtil.getString(displayContext.get("friendlyURL"));
String friendlyURLBase = GetterUtil.getString(displayContext.get("friendlyURLBase"));
String friendlyURLPrivateBase = GetterUtil.getString(displayContext.get("friendlyURLPrivateBase"));
String friendlyURLPublicBase = GetterUtil.getString(displayContext.get("friendlyURLPublicBase"));

boolean privateLayout = GetterUtil.getBoolean(displayContext.get("privateLayout"));
%>

<c:if test="<%= !trackingPageEnabled %>">
	<div class="alert alert-error">
		<strong>
			<liferay-ui:message key="this-rule-will-not-work-properly-because-page-tracking-is-not-enabled" />
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

<aui:input
	checked="<%= !privateLayout %>"
	inlineField="<%= true %>"
	label="public-pages"
	name="privateLayout"
	onChange="if (this.checked) {<%= renderResponse.getNamespace() %>updateFriendlyURL('<%= HtmlUtil.escape(friendlyURLPublicBase) %>');}"
	type="radio"
	value="<%= false %>"
/>

<aui:input
	checked="<%= privateLayout %>"
	inlineField="<%= true %>"
	label="private-pages"
	name="privateLayout"
	onChange="if (this.checked) {<%= renderResponse.getNamespace() %>updateFriendlyURL('<%= HtmlUtil.escape(friendlyURLPrivateBase) %>');}"
	type="radio"
	value="<%= true %>"
/>

<aui:input helpMessage="enter-the-friendly-url-of-the-page-to-be-tracked" label="friendly-url" name="friendlyURL" prefix="<%= friendlyURLBase %>" style="width: auto;" type="text" value="<%= friendlyURL %>">
	<aui:validator name="required" />
</aui:input>

<aui:script>
	function #<portlet:namespace />updateFriendlyURL(value) {
		var A = AUI();

		A.one('#<portlet:namespace />friendlyURL').previous().setHTML(value);
	}
</aui:script>