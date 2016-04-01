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
long userGroupId = GetterUtil.getLong(displayContext.get("userGroupId"));

List<UserGroup> userGroups = (List<UserGroup>)displayContext.get("userGroups");
%>

<c:choose>
	<c:when test="<%= ListUtil.isNull(userGroups) %>">
		<div class="alert alert-warning">
			<strong>
				<liferay-ui:message key="there-are-no-user-groups-available" />
			</strong>

			<%
			String enableLocationLabel = LanguageUtil.get(locale, "control-panel-user-groups");

			String userGroupsAdminURL = GetterUtil.getString(displayContext.get("userGroupsAdminURL"));

			if (Validator.isNotNull(userGroupsAdminURL)) {
				enableLocationLabel = "<a href=\"" + userGroupsAdminURL + "\">" + enableLocationLabel + "</a>";
			}
			%>

			<liferay-ui:message arguments="<%= enableLocationLabel %>" key="user-groups-can-be-managed-in-x" />
		</div>
	</c:when>
	<c:otherwise>
		<aui:select label="" name="userGroupId">

			<%
			for (UserGroup userGroup : userGroups) {
			%>

				<aui:option label="<%= userGroup.getName() %>" selected="<%= userGroup.getUserGroupId() == userGroupId %>" value="<%= userGroup.getUserGroupId() %>" />

			<%
			}
			%>

		</aui:select>
	</c:otherwise>
</c:choose>