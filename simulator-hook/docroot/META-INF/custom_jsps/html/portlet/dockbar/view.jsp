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

<%@ include file="/html/portlet/dockbar/init.jsp" %>

<liferay-util:buffer var="html">
	<liferay-util:include page="/html/portlet/dockbar/view.portal.jsp" />
</liferay-util:buffer>

<liferay-util:buffer var="customHTML">

	<%
	Group group = null;

	if (layout != null) {
		group = layout.getGroup();
	}
	%>

	<c:if test="<%= (group != null) && !group.isControlPanel() && user.isSetupComplete() %>">
		<liferay-portlet:renderURL portletName="ctsimulator_WAR_contenttargetingweb" var="simulatorURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="mvcPath" value="html/ct_simulator/view.ftl" />
		</liferay-portlet:renderURL>

		<aui:nav-item anchorId="simulatorPanel" cssClass="page-edit-controls" href="<%= simulatorURL %>" iconCssClass="icon-screenshot" label="simulator" title="simulator" useDialog="<%= true %>" />
	</c:if>
</liferay-util:buffer>

<%
int x = html.lastIndexOf("<li class=\"toggle-controls \" id=\"_145_toggleControls\" role=\"presentation\"  >");

if (x > 0) {
	StringBundler sb = new StringBundler(3);

	sb.append(html.substring(0, x));
	sb.append(customHTML);
	sb.append(html.substring(x));

	html = sb.toString();
}
%>

<%= html %>