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
String portletNamespace = ParamUtil.getString(request, "portletNamespace");

if (Validator.isBlank(portletNamespace)) {
	String portletId = PortalUtil.getPortletId(request);

	portletNamespace = PortalUtil.getPortletNamespace(portletId);
}

QueryRule queryRule = (QueryRule)request.getAttribute("queryRule");

String index = ParamUtil.getString(request, "index");
%>

<div class="default-content">
	<div class="full-view hide">
		<aui:col width="60">
			<span class="otherwise-text"><liferay-ui:message key="otherwise" /></span>
		</aui:col>

		<aui:col width="35">
			<aui:input checked="<%= !queryRule.hasAssetEntry() %>" id="contentDefaultValueDont" label="dont-display-anything" name="contentDefaultValue" type="radio" value="<%= false %>" />

			<aui:input checked="<%= queryRule.hasAssetEntry() %>" id="contentDefaultValueDo" label="display-this-content" name="contentDefaultValue" type="radio" value="<%= true %>" />

			<div id="<portlet:namespace />contentDefaultBox">
				<div class="select-asset-selector">

					<%
					request.setAttribute("queryRule", queryRule);
					%>

					<liferay-util:include page="/macros/render_asset_entry_selector.jsp" servletContext="<%= application %>">
						<liferay-util:param name="index" value="Default" />
						<liferay-util:param name="portletNamespace" value="<%= portletNamespace %>" />
					</liferay-util:include>
				</div>
			</div>
		</aui:col>
	</div>

	<div class="summary-view">
		<aui:col width="50">
			<span class="otherwise-text"><liferay-ui:message key="otherwise" /></span>
		</aui:col>

		<aui:col width="45">
			<span class="default-content-value-text">
				<c:choose>
					<c:when test="<%= queryRule.hasAssetEntry() %>">
						<liferay-ui:message key="display-this-content" />
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="dont-display-anything" />
					</c:otherwise>
				</c:choose>
			</span>

			<c:if test="<%= queryRule.hasAssetEntry() %>">
				<span class="query-content-value"><%= queryRule.getAssetTitle() %> (<span class="query-content-value-type"><%= queryRule.getAssetType() %></span>)</span>
			</c:if>
		</aui:col>
	</div>
</div>