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
AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

String displayStyle = ParamUtil.getString(request, "displayStyle", "full-content");

boolean showEditLink = ParamUtil.getBoolean(request, "showEditLink", false);
%>

<c:if test="<%= assetEntry != null %>">

	<%
	assetRenderer = assetEntry.getAssetRenderer();

	request.setAttribute("view.jsp-assetEntry", assetEntry);
	request.setAttribute("view.jsp-assetRendererFactory", assetEntry.getAssetRendererFactory());
	request.setAttribute("view.jsp-assetRenderer", assetRenderer);
	request.setAttribute("view.jsp-title", assetEntry.getTitle(themeDisplay.getLocale()));
	%>

</c:if>

<c:if test='<%= "full-content".equals(displayStyle) %>'>

	<%
	%>

</c:if>