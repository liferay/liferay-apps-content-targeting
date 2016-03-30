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
Date now = (Date)displayContext.get("now");

int startTimeAmPm = GetterUtil.getInteger(displayContext.get("startTimeAmPm"));
int startTimeHour = GetterUtil.getInteger(displayContext.get("startTimeHour"));
int startTimeMinute = GetterUtil.getInteger(displayContext.get("startTimeMinute"));

int endTimeAmPm = GetterUtil.getInteger(displayContext.get("endTimeAmPm"));
int endTimeHour = GetterUtil.getInteger(displayContext.get("endTimeHour"));
int endTimeMinute = GetterUtil.getInteger(displayContext.get("endTimeMinute"));
%>

<div class="alert alert-info">
	<liferay-ui:message arguments="<%= timeFormat.format(now.getTime()) %>" key="this-rule-checks-the-server-time-which-currently-is-x" />
</div>

<aui:fieldset cssClass="time-selector" label="start-time">
	<liferay-ui:input-time
		amPmParam="startTimeAmPm"
		amPmValue="<%= startTimeAmPm %>"
		hourParam="startTimeHour"
		hourValue="<%= startTimeHour %>"
		minuteParam="startTimeMinute"
		minuteValue="<%= startTimeMinute %>"
		name="startTime"
	/>
</aui:fieldset>

<aui:fieldset cssClass="time-selector" label="end-time">
	<liferay-ui:input-time
		amPmParam="endTimeAmPm"
		amPmValue="<%= endTimeAmPm %>"
		hourParam="endTimeHour"
		hourValue="<%= endTimeHour %>"
		minuteParam="endTimeMinute"
		minuteValue="<%= endTimeMinute %>"
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