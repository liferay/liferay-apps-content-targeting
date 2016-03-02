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
String displayStyle = GetterUtil.getString(request.getAttribute("displayStyle"));
String[] displayStyles = GetterUtil.getStringValues(request.getAttribute("displayStyles"));
long displayStyleGroupId = GetterUtil.getLong(request.getAttribute("displayStyleGroupId"));

TemplateHandler templateHandler = (TemplateHandler)request.getAttribute("templateHandler");
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationURL">
	<portlet:param name="cmd" value="update" />
</liferay-portlet:actionURL>

<div class="display-template">
	<liferay-ddm:template-selector
		className="<%= templateHandler.getClassName() %>"
		displayStyle="<%= displayStyle %>"
		displayStyleGroupId="<%= displayStyleGroupId %>"
		displayStyles="<%= ListUtil.toList(displayStyles) %>"
		label="display-template"
		refreshURL="<%= configurationURL %>"
	/>
</div>