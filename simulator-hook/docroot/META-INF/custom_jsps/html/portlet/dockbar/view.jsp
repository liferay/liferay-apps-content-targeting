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

		<%
		String cssClass = "page-edit-controls";

		boolean isSimulatedUserSegments = GetterUtil.getBoolean(request.getAttribute("isSimulatedUserSegments"));

		if (isSimulatedUserSegments) {
			cssClass = "page-edit-controls simulated";
		}
		%>

		<liferay-portlet:renderURL portletName="ctsimulator_WAR_contenttargetingweb" var="simulatorURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
			<portlet:param name="mvcPath" value="html/ct_simulator/view.ftl" />
		</liferay-portlet:renderURL>

		<aui:nav-item anchorId="simulatorPanel" cssClass="<%= cssClass %>" data-panelURL="<%= simulatorURL %>" href="javascript:;" iconCssClass="icon-screenshot" label="simulator" title="simulator" />
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

<aui:script use="liferay-dockbar">
	Liferay.Dockbar.DOCKBAR_PANELS.simulatorPanel = {
		css: 'lfr-has-simulator',
		id: 'simulatorPanel',
		node: null,
		showFn: A.bind(Liferay.Dockbar._showPanel, Liferay.Dockbar),
		tpl: '<div class="lfr-add-panel lfr-admin-panel" id="{0}" />'
	};
</aui:script>

<script type="text/javascript">
	AUI().applyConfig(
		{
			modules: {
				'liferay-simulator': {
					fullpath: '/o/content-targeting-web/js/ct_simulator/simulator.js'
				}
			}
		}
	);
</script>

<%
String href = HtmlUtil.escapeAttribute(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNDynamicResourcesHost() + themeDisplay.getPathContext() + "/o/content-targeting-web/css/ct_simulator/main.css"));
%>

<link href="<%= href %>" rel="stylesheet" type="text/css">

<style type="text/css">
	.aui .lfr-has-simulator {
		padding-left: 350px;
	}

	.aui .dockbar-split.lfr-has-simulator .nav-add-controls {
		left: 350px;
	}

	.aui .dockbar-split .dockbar .navbar-inner .nav-add-controls > li.simulated > a {
		background-color: #92F545;
	}

	.aui .dockbar-split .dockbar .navbar-inner .nav-add-controls > li.simulated > a [class^="icon-"] {
		color: #000;
	}
</style>