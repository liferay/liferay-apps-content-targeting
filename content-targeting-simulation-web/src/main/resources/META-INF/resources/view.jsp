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
long cssLastModified = PortalWebResourcesUtil.getLastModified(PortalWebResourceConstants.RESOURCE_TYPE_CSS);
long javaScriptLastModified = PortalWebResourcesUtil.getLastModified(PortalWebResourceConstants.RESOURCE_TYPE_JS);

ServletContext simulatorServletContext = (ServletContext)request.getAttribute("simulatorServletContext");
%>

<c:if test="<%= simulatorServletContext != null %>">
	<liferay-util:html-top>
		<link href="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(simulatorServletContext.getContextPath()) + "/css/main.css", "minifierBundleId=content.targeting.files", cssLastModified)) %>" rel="stylesheet" type="text/css">
		<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(simulatorServletContext.getContextPath()) + "/js/main.js", "minifierBundleId=content.targeting.files", javaScriptLastModified)) %>" type="text/javascript"></script>
	</liferay-util:html-top>
</c:if>

<h3 class="list-group-heading"><liferay-ui:message key="user-segments" /></h3>

<div class="container-fluid content-targeting-simulator">
	<liferay-util:include page="/view_user_segments.jsp" servletContext="<%= application %>" />
</div>