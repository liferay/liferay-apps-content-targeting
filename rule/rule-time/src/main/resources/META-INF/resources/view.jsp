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

<p class="text-default">
	<liferay-ui:message arguments="<%= ruleTimeDisplayContext.getInfoMessage() %>" key="this-rule-checks-the-server-time-which-currently-is-x" />
</p>

<aui:fieldset cssClass="time-selector" label="start-time">
	<liferay-ui:input-time
		amPmParam="startTimeAmPm"
		amPmValue="<%= ruleTimeDisplayContext.getStartTimeAmPm() %>"
		hourParam="startTimeHour"
		hourValue="<%= ruleTimeDisplayContext.getStartTimeHour() %>"
		minuteParam="startTimeMinute"
		minuteValue="<%= ruleTimeDisplayContext.getStartTimeMinute() %>"
		name="startTime"
	/>
</aui:fieldset>

<aui:fieldset cssClass="time-selector" label="end-time">
	<liferay-ui:input-time
		amPmParam="endTimeAmPm"
		amPmValue="<%= ruleTimeDisplayContext.getEndTimeAmPm() %>"
		hourParam="endTimeHour"
		hourValue="<%= ruleTimeDisplayContext.getEndTimeHour() %>"
		minuteParam="endTimeMinute"
		minuteValue="<%= ruleTimeDisplayContext.getEndTimeMinute() %>"
		name="endTime"
	/>
</aui:fieldset>

<style>
	.time-selector legend {
		border: none;
		font-weight: bold;
		font-size: 15px;
		line-height: 30px;
		margin-bottom: 0;
	}
</style>