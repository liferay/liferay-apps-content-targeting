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
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.content.targeting.rule.facebook.display.context.RuleFacebookDisplayContext" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
RuleFacebookDisplayContext ruleFacebookDisplayContext = new RuleFacebookDisplayContext(_liferayPortletResponse, request);
%>

<c:choose>
	<c:when test="<%= !ruleFacebookDisplayContext.isFbLoginEnabled() %>">
		<div class="alert alert-error">
			<strong>
				<liferay-ui:message key="this-rule-will-not-work-properly-because-login-through-facebook-is-not-enabled" />
			</strong>

			<%
			String enableLocationLabel = LanguageUtil.get(request, "portal-settings-authentication");

			if (Validator.isNotNull(ruleFacebookDisplayContext.getPortalSettingsURL())) {
				enableLocationLabel = "<a href=\"" + ruleFacebookDisplayContext.getPortalSettingsURL() + "\">" + enableLocationLabel + "</a>";
			}
			%>

			<liferay-ui:message arguments="<%= enableLocationLabel %>" key="this-rule-will-not-work-properly-because-login-through-facebook-is-not-enabled" />
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="this-information-can-only-be-obtained-from-users-who-log-in-through-facebook" />
		</div>
	</c:otherwise>
</c:choose>