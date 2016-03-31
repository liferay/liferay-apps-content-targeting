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

<c:if test="<%= !trackingPageEnabled %>">
	<div class="alert alert-error">
		<strong><liferay-ui:message key="this-metric-will-not-work-properly-because-page-tracking-is-not-enabled" /></strong>

		<liferay-ui:message
			arguments="<%= enableLocationLabels %>"
			key="it-can-be-enabled-in-x-or-in-x"
			translateArguments="<%= false %>"
		/>
	</div>
</c:if>

<aui:input helpMessage="name-help" label="name" name="{ct_field_guid}alias" type="text" value="<%= alias %>">
	<aui:validator name="required" />
</aui:input>

<aui:input
	checked="<%= !privateLayout %>"
	inlineField="<%= true %>"
	label="public-pages"
	name="privateLayout"
	onChange="<%= onClickPublicInput %>"
	type="radio"
	value="<%= false %>"
/>

<aui:input
	checked="<%= privateLayout %>"
	inlineField="<%= true %>"
	label="private-pages"
	name="privateLayout"
	onChange="<%= onClickPrivateInput %>"
	type="radio"
	value="<%= true %>"
/>

<aui:input helpMessage="enter-the-friendly-url-of-the-page-to-be-tracked" label="friendly-url" name="friendlyURL" prefix="<%= friendlyURLBase %>" style="width: auto;" type="text" value="<%= friendlyURL %>">
	<aui:validator name="required" />
</aui:input>

<c:choose>
	<c:when test="<%= eventTypes.length > 0 %>">
		<aui:select label="event-type" name="{ct_field_guid}eventType">

			<%
			for (String curEventType : eventTypes) {
			%>

				<aui:option
					label="<%= curEventType %>"
					selected="<%= (eventType == curEventType) %>"
					value="<%= curEventType %>"
				/>

			<%
			}
			%>

		</aui:select>
	</c:when>
	<c:otherwise>

		<%
		for (String curEventType : eventTypes) {
		%>

			<aui:input
				disabled="<%= true %>"
				label="event-type"
				name="{ct_field_guid}eventType"
				type="text"
				value="<%= curEventType %>"
			/>

		<%
		}
		%>

	</c:otherwise>
</c:choose>

<aui:script>
	function <portlet:namespace />updateFriendlyURL(value) {
		var A = AUI();

		A.one('#<portlet:namespace />friendlyURL').previous().setHTML(value);
	}
</aui:script>