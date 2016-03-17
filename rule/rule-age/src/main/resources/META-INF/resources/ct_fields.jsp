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

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="java.util.Map" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
Map<String, Object> displayContext = (Map<String, Object>)request.getAttribute("displayContext");

boolean birthdayEnabled = GetterUtil.getBoolean(displayContext.get("birthdayEnabled"), true);

String enableLocationLabel = LanguageUtil.get(locale, "portal-settings-users");

String portalSettingsURL = GetterUtil.getString(displayContext.get("portalSettingsURL"), null);

if (Validator.isNotNull(portalSettingsURL)) {
	enableLocationLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationLabel + "</a>";
}

int olderThan = GetterUtil.getInteger(displayContext.get("olderThan"), 0);
int youngerThan = GetterUtil.getInteger(displayContext.get("youngerThan"), 100);
%>

<c:if test="<%= !birthdayEnabled %>">
	<div class="alert alert-error">
		<strong><liferay-ui:message key="this-rule-will-not-work-properly-because-the-age-field-has-been-removed" /></strong>

		<liferay-ui:message arguments="<%= enableLocationLabel %>" key="it-can-be-enabled-in-x" />
	</div>
</c:if>

<aui:input cssClass="slider-input" inlineField="<%= true %>" maxlength="3" name="olderThan" size="2" value="<%= olderThan %>" />

<aui:input cssClass="slider-input" inlineField="<%= true %>" maxlength="3" name="youngerThan" size="2" value="<%= youngerThan %>">
	<aui:validator errorMessage="the-age-range-is-invalid" name="custom">
		function(val, fieldNode, ruleValue) {
			if (!val) {
				return false;
			}

			var olderThan = A.one('#<portlet:namespace />olderThan');

			if (!olderThan.val()) {
				return false;
			}

			var youngerThanValue = parseInt(val);
			var olderThanValue = parseInt(olderThan.val());

			return (olderThanValue < youngerThanValue);
		}
	</aui:validator>
</aui:input>

<aui:script use="liferay-input-slider">
	new Liferay.InputSlider(
		{
			inputNode: '#<portlet:namespace />olderThan'
		}
	);

	new Liferay.InputSlider(
		{
			inputNode: '#<portlet:namespace />youngerThan'
		}
	);
</aui:script>