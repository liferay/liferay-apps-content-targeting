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
long siteId = GetterUtil.getLong(displayContext.get("siteId"));

List<Group> sites = (List<Group>)displayContext.get("sites");
%>

<c:choose>
	<c:when test="<%= ListUtil.isNull(sites) %>">
		<div class="alert alert-warning">
			<strong>
				<liferay-ui:message key="there-are-no-sites-available" />
			</strong>

			<%
			String enableLocationLabel = LanguageUtil.get(locale, "control-panel-sites");

			String sitesAdminURL = GetterUtil.getString(displayContext.get("sitesAdminURL"));

			if (Validator.isNotNull(sitesAdminURL)) {
				enableLocationLabel = "<a href=\"" + sitesAdminURL + "\">" + enableLocationLabel + "</a>";
			}
			%>

			<liferay-ui:message arguments="<%= enableLocationLabel %>" key="sites-can-be-managed-in-x" />
		</div>
	</c:when>
	<c:otherwise>
		<aui:select label="" name="siteId">

			<%
			for (Group site : sites) {
			%>

				<aui:option label="<%= site.getDescriptiveName(locale) %>" selected="<%= site.getGroupId() == siteId %>" value="<%= site.getGroupId() %>" />

			<%
				}
			%>

		</aui:select>
	</c:otherwise>
</c:choose>