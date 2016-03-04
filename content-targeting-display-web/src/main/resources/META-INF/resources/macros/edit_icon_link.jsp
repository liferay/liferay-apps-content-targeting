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
QueryRule queryRule = (QueryRule)request.getAttribute("queryRule");

PortletURL redirectURL = renderResponse.createRenderURL();

redirectURL.setParameter("mvcPath", "/add_asset_redirect.jsp");
redirectURL.setParameter("redirect", currentURL);

redirectURL.setWindowState(LiferayWindowState.POP_UP);

AssetRenderer assetRenderer = queryRule.getAssetEntry().getAssetRenderer();

PortletURL editPortletURL = assetRenderer.getURLEdit(liferayPortletRequest, liferayPortletResponse, LiferayWindowState.POP_UP, redirectURL);
%>

<c:if test="<%= portletDisplay.isShowConfigurationIcon() && assetRenderer.hasEditPermission(permissionChecker) && Validator.isNotNull(editPortletURL) %>">

	<%
	String title = LanguageUtil.format(locale, "edit-x", HtmlUtil.escape(assetRenderer.getTitle(locale)));
	%>

	<liferay-ui:icon
		icon="pencil"
		markupView="lexicon"
		url='<%= "javascript:Liferay.Util.openWindow({id:'" + renderResponse.getNamespace() + "editAsset', title: '" + title + "', uri:'" + HtmlUtil.escapeURL(editPortletURL.toString()) + "'});" %>'
	/>
</c:if>