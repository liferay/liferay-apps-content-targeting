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
String gender = GetterUtil.getString(displayContext.get("gender"));

boolean genderEnabled = GetterUtil.getBoolean(displayContext.get("genderEnabled"), false);
%>

<c:if test="<%= genderEnabled %>">
	<div class="alert alert-error">
		<strong><liferay-ui:message key="this-rule-will-not-work-properly-because-the-gender-field-has-been-removed" /></strong>

		<%
		String enableLocationLabel = LanguageUtil.get(locale, "portal-settings-users");

		String portalSettingsURL = GetterUtil.getString(displayContext.get("portalSettingsURL"));

		if (Validator.isNotNull(portalSettingsURL)) {
			enableLocationLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationLabel + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= enableLocationLabel %>" key="it-can-be-enabled-in-x" />
	</div>
</c:if>

<aui:input checked='<%= Validator.equals(gender, "male") %>' label="male" name="gender" type="radio" value="male" />

<aui:input checked='<%= Validator.equals(gender, "female") %>' label="female" name="gender" type="radio" value="female" />