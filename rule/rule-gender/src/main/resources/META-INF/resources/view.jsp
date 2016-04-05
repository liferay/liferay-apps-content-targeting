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

<c:if test="<%= ruleGenderDisplayContext.isGenderEnabled() %>">
	<div class="alert alert-info">
		<strong><liferay-ui:message key="this-rule-will-not-work-properly-because-the-gender-field-has-been-removed" /></strong>

		<%
		String enableLocationLabel = LanguageUtil.get(locale, "portal-settings-users");

		if (Validator.isNotNull(ruleGenderDisplayContext.getPortalSettingsUsersURL())) {
			enableLocationLabel = "<a href=\"" + ruleGenderDisplayContext.getPortalSettingsUsersURL() + "\">" + enableLocationLabel + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= enableLocationLabel %>" key="it-can-be-enabled-in-x" />
	</div>
</c:if>

<aui:input checked='<%= Validator.equals(ruleGenderDisplayContext.getGender(), "male") %>' label="male" name="gender" type="radio" value="male" />

<aui:input checked='<%= Validator.equals(ruleGenderDisplayContext.getGender(), "female") %>' label="female" name="gender" type="radio" value="female" />