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
String educationLevel = GetterUtil.getString(displayContext.get("educationLevel"));

String schoolName = GetterUtil.getString(displayContext.get("schoolName"));
%>

<aui:fieldset>
	<aui:select name="education">
		<aui:option label="any" selected="<%= Validator.equals(educationLevel, StringPool.BLANK) %>" value="<%= StringPool.BLANK %>" />
		<aui:option label="high-school" selected='<%= Validator.equals(educationLevel, "high-school") %>' value="high-school" />
		<aui:option label="college" selected='<%= Validator.equals(educationLevel, "college") %>' value="college" />
	</aui:select>

	<aui:input label="college-high-school-name" name="schoolName" type="text" value="<%= schoolName %>" />
</aui:fieldset>