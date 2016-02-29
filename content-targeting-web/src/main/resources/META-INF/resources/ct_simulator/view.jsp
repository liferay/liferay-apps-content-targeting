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
long javaScriptLastModified = PortalWebResourcesUtil.getLastModified(PortalWebResourceConstants.RESOURCE_TYPE_JS);

String tabs1 = ParamUtil.getString(request, "tabs1");

ServletContext simulatorServletContext = (ServletContext)request.getAttribute("simulatorServletContext");
%>

<c:if test="<%= simulatorServletContext != null %>">
	<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(simulatorServletContext.getContextPath()) + "/js/ct_simulator/simulator.js", "minifierBundleId=content.targeting.files", javaScriptLastModified)) %>" type="text/javascript"></script>
</c:if>

<h3 class="list-group-heading"><liferay-ui:message key="category.ct" /></h3>

<div class="container-fluid content-targeting-simulator">
	<liferay-ui:tabs
		names='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "user-segments") + "," + LanguageUtil.get(portletConfig.getResourceBundle(locale), "campaigns") %>'
		refresh="<%= false %>"
		type="pills"
		value="<%= tabs1 %>"
	>
		<liferay-ui:section>
			<liferay-util:include page="/ct_simulator/view_user_segments.jsp" servletContext="<%= application %>">
			</liferay-util:include>
		</liferay-ui:section>

		<liferay-ui:section>
			<liferay-util:include page="/ct_simulator/view_campaigns.jsp" servletContext="<%= application %>">
			</liferay-util:include>
		</liferay-ui:section>
	</liferay-ui:tabs>
</div>