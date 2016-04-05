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

<c:choose>
	<c:when test="<%= !ruleFacebookDisplayContext.isFbLoginEnabled() %>">
		<div class="alert alert-info">
			<strong>
				<liferay-ui:message key="this-rule-will-not-work-properly-because-login-through-facebook-is-not-enabled" />
			</strong>

			<%
			String enableLocationLabel = LanguageUtil.get(request, "portal-settings-authentication");

			if (Validator.isNotNull(ruleFacebookDisplayContext.getPortalSettingsAuthenticationURL())) {
				enableLocationLabel = "<a href=\"" + ruleFacebookDisplayContext.getPortalSettingsAuthenticationURL() + "\">" + enableLocationLabel + "</a>";
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