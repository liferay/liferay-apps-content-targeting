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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="java.util.Map" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
Map<String, Object> displayContext = (Map<String, Object>)request.getAttribute("displayContext");

String alias = GetterUtil.getString(displayContext.get("alias"), "");
String eventType = GetterUtil.getString(displayContext.get("eventType"), "view");
String[] eventTypes = GetterUtil.getStringValues(displayContext.get("eventTypes"), new String[] {"view"});
String friendlyURL = GetterUtil.getString(displayContext.get("friendlyURL"));
String friendlyURLBase = GetterUtil.getString(displayContext.get("friendlyURLBase"));
String friendlyURLPrivateBase = GetterUtil.getString(displayContext.get("friendlyURLPrivateBase"));
String friendlyURLPublicBase = GetterUtil.getString(displayContext.get("friendlyURLPublicBase"));
boolean privateLayout = GetterUtil.getBoolean(displayContext.get("privateLayout"), false);
boolean trackingPageEnabled = GetterUtil.getBoolean(displayContext.get("trackingPageEnabled"), false);

String enableLocationPortalLabel = LanguageUtil.get(request, "portal-settings-content-targeting-analytics");
String enableLocationSiteLabel = LanguageUtil.get(request, "site-settings-content-targeting-analytics");

String portalSettingsURL = GetterUtil.getString(displayContext.get("portalSettingsURL"));
String siteSettingsURL = GetterUtil.getString(displayContext.get("siteSettingsURL"));

if (Validator.isNotNull(portalSettingsURL)) {
	enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>";
}

if (Validator.isNotNull(siteSettingsURL)) {
	enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>";
}

String[] enableLocationLabels = new String[] {
	enableLocationPortalLabel, enableLocationSiteLabel
};

String onClickPrivateInput = "if (this.checked) {" + renderResponse.getNamespace() + "updateFriendlyURL('" + HtmlUtil.escape(friendlyURLPrivateBase) + "');}";
String onClickPublicInput = "if (this.checked) {" + renderResponse.getNamespace() + "updateFriendlyURL('" + HtmlUtil.escape(friendlyURLPublicBase) + "');}";
%>

<c:if test="<%= !trackingPageEnabled %>">
	<div class="alert alert-error">
		<strong><liferay-ui:message key="this-metric-will-not-work-properly-because-page-tracking-is-not-enabled" /></strong>

		<liferay-ui:message
			arguments="<%= enableLocationLabels %>"
			key="it-can-be-enabled-in-x-or-in-x"
			translateArguments="<%= false %>"
		/>
	</div>
</c:if>

<aui:input helpMessage="name-help" label="name" name="{ct_field_guid}alias" type="text" value="<%= alias %>">
	<aui:validator name="required" />
</aui:input>

<aui:input
	checked="<%= !privateLayout %>"
	inlineField="<%= true %>"
	label="public-pages"
	name="privateLayout"
	onChange="<%= onClickPublicInput %>"
	type="radio"
	value="<%= false %>"
/>

<aui:input
	checked="<%= privateLayout %>"
	inlineField="<%= true %>"
	label="private-pages"
	name="privateLayout"
	onChange="<%= onClickPrivateInput %>"
	type="radio"
	value="<%= true %>"
/>

<aui:input helpMessage="enter-the-friendly-url-of-the-page-to-be-tracked" label="friendly-url" name="friendlyURL" prefix="<%= friendlyURLBase %>" style="width: auto;" type="text" value="<%= friendlyURL %>">
	<aui:validator name="required" />
</aui:input>

<c:choose>
	<c:when test="<%= eventTypes.length > 0 %>">
		<aui:select label="event-type" name="{ct_field_guid}eventType">

			<%
			for (String curEventType : eventTypes) {
			%>

				<aui:option
					label="<%= curEventType %>"
					selected="<%= (eventType == curEventType) %>"
					value="<%= curEventType %>"
				/>

			<%
			}
			%>

		</aui:select>
	</c:when>
	<c:otherwise>

		<%
		for (String curEventType : eventTypes) {
		%>

			<aui:input
				disabled="<%= true %>"
				label="event-type"
				name="{ct_field_guid}eventType"
				type="text"
				value="<%= curEventType %>"
			/>

		<%
		}
		%>

	</c:otherwise>
</c:choose>

<aui:script>
	function <portlet:namespace />updateFriendlyURL(value) {
		var A = AUI();

		A.one('#<portlet:namespace />friendlyURL').previous().setHTML(value);
	}
</aui:script>