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

List<AssetRendererFactory> assetRendererFactories = (List<AssetRendererFactory>)request.getAttribute("assetRendererFactories");

AssetQueryRule queryRule = (AssetQueryRule)request.getAttribute("queryRule");

String index = ParamUtil.getString(request, "index");

String cssClass = "";

if (!queryRule.hasAssetEntry()) {
	cssClass = "hide";
}
%>

<div class="asset-preview <%= cssClass %>" id='<%= portletNamespace + "selectedContent" + index %>'>
	<aui:col>
		<img class="asset-image" src="<%= queryRule.getAssetImage(renderRequest) %>" />
	</aui:col>

	<aui:col>
		<div class="asset-title" id='<%= portletNamespace + "assetTitleInfo" + index %>'><%= queryRule.getAssetTitle() %></div>
		<div class="asset-type" id='<%= portletNamespace + "assetTypeInfo" + index %>'><liferay-ui:message key="type" />: <%= queryRule.getAssetType() %></div>
	</aui:col>
</div>

<div class="edit-controls lfr-meta-actions">
	<aui:input name='<%= portletNamespace + "assetEntryId" + index %>' type="hidden" useNamespace="<%= false %>" value="<%= queryRule.getAssetEntryId() %>" />

	<liferay-ui:icon-menu cssClass="select-existing-selector" direction="right" icon='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>' message='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "select-content") %>' showWhenSingleIcon="<%= true %>">

		<%
		for (AssetRendererFactory assetRendererFactory : assetRendererFactories) {
		%>

			<liferay-ui:icon
				cssClass="asset-selector"
				data="<%= queryRule.getAssetSelectorIconData(request, assetRendererFactory, index) %>"
				id='<%= "groupId_" + assetRendererFactory.getTypeName(locale, false) + "_" + String.valueOf(index) %>'
				message="<%= assetRendererFactory.getTypeName(locale, false) %>"
				src="<%= assetRendererFactory.getIconPath(renderRequest) %>"
				url="javascript:;"
			/>

		<%
		}
		%>

	</liferay-ui:icon-menu>
</div>