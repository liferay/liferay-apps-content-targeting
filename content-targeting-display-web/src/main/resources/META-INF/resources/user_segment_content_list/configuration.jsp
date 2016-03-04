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

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationURL">
	<portlet:param name="cmd" value="update" />
</liferay-portlet:actionURL>

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit="event.preventDefault();">
	<liferay-ui:tabs
		names="content-selection,display-settings"
		param="tabs2"
		refresh="<%= false %>"
		type="tabs nav-tabs-default"
	>

		<liferay-ui:section>
			<liferay-util:include page="/user_segment_content_list/content_selection.jsp" servletContext="<%= application %>" />
		</liferay-ui:section>

		<liferay-ui:section>
			<liferay-util:include page="/user_segment_content_list/display_settings.jsp" servletContext="<%= application %>" />
		</liferay-ui:section>
	</liferay-ui:tabs>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />

		<aui:button cssClass="btn-lg" type="cancel" />
	</aui:button-row>
</aui:form>