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
long mdrGroupId = GetterUtil.getLong("mdrGroupId");

List<MDRRuleGroup> mdrRuleGroups = (List<MDRRuleGroup>)displayContext.get("mdrRuleGroups");
%>

<liferay-util:buffer var="infoMessage">

	<%
	String enableLocationLabel = LanguageUtil.get(request, "site-administration-mdr");

	String mDRURL = GetterUtil.getString(displayContext.get("mDRURL"));

	if (Validator.isNotNull(mDRURL)) {
		enableLocationLabel = "<a href=\"" + mDRURL + "\">" + enableLocationLabel + "</a>";
	}
	%>

	<liferay-ui:message arguments="<%= enableLocationLabel %>" key="device-families-can-be-managed-in-x" />

</liferay-util:buffer>

<c:choose>
	<c:when test="<%= ListUtil.isEmpty(mdrRuleGroups) %>">
		<div class="alert alert-warning">
			<strong>
				<liferay-ui:message key="there-are-no-device-families-available" />
			</strong>

			<%= infoMessage %>
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<%= infoMessage %>
		</div>

		<aui:select label="device-family" name="mdrRuleGroupId">

			<%
			for (MDRRuleGroup mdrRuleGroup : mdrRuleGroups) {
			%>

				<aui:option label="<%= mdrRuleGroup.getName(locale) %>" selected="<%= mdrGroupId == mdrRuleGroup.getRuleGroupId() %>" value="<%= mdrRuleGroup.getRuleGroupId() %>" />

			<%
			}
			%>

		</aui:select>
	</c:otherwise>
</c:choose>