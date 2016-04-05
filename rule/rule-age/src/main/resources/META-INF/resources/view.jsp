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

<c:if test="<%= !ruleAgeDisplayContext.isBirthDayEnabled() %>">

	<%
	String enableLocationLabel = LanguageUtil.get(locale, "portal-settings-users");

	if (Validator.isNotNull(ruleAgeDisplayContext.getPortalSettingsUsersURL())) {
		enableLocationLabel = "<a href=\"" + ruleAgeDisplayContext.getPortalSettingsUsersURL() + "\">" + enableLocationLabel + "</a>";
	}
	%>

	<div class="alert alert-info">
		<strong><liferay-ui:message key="this-rule-will-not-work-properly-because-the-age-field-has-been-removed" /></strong>

		<liferay-ui:message arguments="<%= enableLocationLabel %>" key="it-can-be-enabled-in-x" />
	</div>
</c:if>

<aui:input cssClass="slider-input" inlineField="<%= true %>" maxlength="3" name="olderThan" size="3" value="<%= ruleAgeDisplayContext.getOlderThan() %>" />

<aui:input cssClass="slider-input" inlineField="<%= true %>" maxlength="3" name="youngerThan" size="3" value="<%= ruleAgeDisplayContext.getYoungerThan() %>">
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