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
	<c:when test="<%= ListUtil.isEmpty(ruleRoleDisplayContext.getSites()) %>">
		<div class="alert alert-info">
			<strong><liferay-ui:message key="there-are-no-sites-available" /></strong>

			<%
			String enableLocationLabel = LanguageUtil.get(resourceBundle, "control-panel-sites");

			if (Validator.isNotNull(ruleRoleDisplayContext.getSitesAdminURL())) {
				enableLocationLabel = "<a href=\"" + ruleRoleDisplayContext.getSitesAdminURL() + "\">" + enableLocationLabel + "</a>";
			}
			%>

			<liferay-ui:message arguments="<%= enableLocationLabel %>" key="sites-can-be-managed-in-x" />
		</div>
	</c:when>
	<c:otherwise>
		<aui:select label="site" name="siteId">

			<%
			for (Group site : ruleRoleDisplayContext.getSites()) {
			%>

				<aui:option label="<%= site.getDescriptiveName(locale) %>" selected="<%= site.getGroupId() == ruleRoleDisplayContext.getSiteId() %>" value="<%= site.getGroupId() %>" />

			<%
			}
			%>

		</aui:select>

		<aui:select label="role" name="roleId">

			<%
			for (Role role : ruleRoleDisplayContext.getSiteRoles()) {
			%>

				<aui:option label="<%= role.getTitle(locale) %>" selected="<%= role.getRoleId() == ruleRoleDisplayContext.getRoleId() %>" value="<%= role.getRoleId() %>" />

			<%
			}
			%>

		</aui:select>
	</c:otherwise>
</c:choose>