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
List<AssetRendererFactory> assetRendererFactories = (List<AssetRendererFactory>)request.getAttribute("assetRendererFactories");

AssetQueryRule queryRule = (AssetQueryRule)request.getAttribute("queryRule");

String index = ParamUtil.getString(request, "index");
%>

<aui:input name='<%= "assetEntryId" + index %>' type="hidden" value="<%= queryRule.getAssetEntryId() %>" />

<div class="col-md-6">
	<div id="<portlet:namespace /><%= "assetEntryContent" + index %>">
		<c:choose>
			<c:when test="<%= queryRule.hasAssetEntry() %>">
				<liferay-util:include page="/macros/asset_entry.jsp" servletContext="<%= application %>">
					<liferay-util:param name="assetEntryId" value="<%= String.valueOf(queryRule.getAssetEntryId()) %>" />
				</liferay-util:include>
			</c:when>
			<c:otherwise>
				<p class="text-default">
					<liferay-ui:message key="none" />
				</p>
			</c:otherwise>
		</c:choose>
	</div>

	<liferay-ui:icon-menu direction="right" message='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "select-content") %>' showArrow="<%= false %>" showWhenSingleIcon="<%= true %>">

		<%
		for (AssetRendererFactory assetRendererFactory : assetRendererFactories) {
		%>

			<liferay-ui:icon
				cssClass="asset-selector"
				data="<%= queryRule.getAssetSelectorIconData(request, assetRendererFactory, index) %>"
				id='<%= "groupId_" + assetRendererFactory.getTypeName(locale) + "_" + String.valueOf(index) %>'
				message="<%= assetRendererFactory.getTypeName(locale) %>"
				url="javascript:;"
			/>

		<%
		}
		%>

	</liferay-ui:icon-menu>
</div>