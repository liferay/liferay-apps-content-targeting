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

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.content.targeting.util.ContentTargetingUtil" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.util.ArrayUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="java.util.Map" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
Map<String, Object> displayContext = (Map<String, Object>)request.getAttribute("displayContext");

String alias = GetterUtil.getString(displayContext.get("alias"), StringPool.BLANK);
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