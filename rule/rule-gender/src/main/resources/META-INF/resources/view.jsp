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

<c:if test="<%= !ruleGenderDisplayContext.isGenderEnabled() %>">
	<p class="text-default">
		<strong><liferay-ui:message key="this-rule-will-not-work-properly-because-the-gender-field-has-been-removed" /></strong>

		<%
		String enableLocationLabel = LanguageUtil.get(resourceBundle, "portal-settings-users");

		if (Validator.isNotNull(ruleGenderDisplayContext.getPortalSettingsURL())) {
			enableLocationLabel = "<a href=\"" + ruleGenderDisplayContext.getPortalSettingsURL() + "\">" + enableLocationLabel + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= enableLocationLabel %>" key="it-can-be-enabled-in-x" />
	</p>
</c:if>

<aui:input checked='<%= "male".equals(ruleGenderDisplayContext.getGender()) %>' label="male" name="gender" type="radio" value="male" />

<aui:input checked='<%= "female".equals(ruleGenderDisplayContext.getGender()) %>' label="female" name="gender" type="radio" value="female" />