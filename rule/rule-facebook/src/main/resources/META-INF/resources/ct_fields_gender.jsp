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
%>

<aui:input checked='<%= Validator.equals(gender, "male") %>' label="male" name="fbGender" type="radio" value="male" />

<aui:input checked='<%= Validator.equals(gender, "female") %>' label="female" name="fbGender" type="radio" value="female" />

<aui:input checked='<%= Validator.equals(gender, "custom") %>' label="custom-or-not-specified" name="fbGender" type="radio" value="custom" />