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
List<QueryRule> queryRules = (List<QueryRule>)request.getAttribute("queryRules");

String actionsCssClass = "hide";

int selectedIndex = ParamUtil.getInteger(request, "selectedIndex");

QueryRule selectedQueryRule = null;

if (ListUtil.isNotEmpty(queryRules) && (queryRules.size() <= selectedIndex)) {
	selectedQueryRule = queryRules.get(selectedIndex);

	if (selectedQueryRule.hasAssetEntry()) {
		actionsCssClass = "";
	}
}
%>

<liferay-portlet:renderURL copyCurrentRenderParameters="<%= false %>" varImpl="redirectURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcPath" value="/add_asset_redirect.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</liferay-portlet:renderURL>

<c:if test="<%= portletDisplay.isShowConfigurationIcon() && (selectedQueryRule != null) && ListUtil.isNotEmpty(queryRules) %>">
	<div class="icons-container lfr-meta-actions">
		<div class="lfr-icon-actions <%= actionsCssClass %>">

			<%
			for (QueryRule queryRule : queryRules) {
				int queryRule_index = queryRules.indexOf(queryRule);
				String cssClass = "";

				if (queryRule_index == selectedIndex) {
					cssClass = "hide";
				}

				if (queryRule.hasAssetEntry()) {
					AssetRenderer assetRenderer = queryRule.getAssetEntry().getAssetRenderer();

					PortletURL editPortletURL = assetRenderer.getURLEdit(liferayPortletRequest, liferayPortletResponse, LiferayWindowState.POP_UP, redirectURL);

					String title = LanguageUtil.format(locale, "edit-x", HtmlUtil.escape(assetRenderer.getTitle(locale)));
			%>

				<c:if test="<%= assetRenderer.hasEditPermission(permissionChecker) && Validator.isNotNull(editPortletURL) %>">
					<span class="<%= cssClass %>" id="<portlet:namespace />editLink<%= queryRule_index %>">
						<liferay-ui:icon
							cssClass="lfr-icon-action lfr-icon-action-edit"
							image="edit"
							label="<%= true %>"
							message="<%= title %>"
							url='<%= "javascript:Liferay.Util.openWindow({id:'" + renderResponse.getNamespace() + "editAsset', title: '" + title + "', uri:'" + HtmlUtil.escapeURL(editPortletURL.toString()) + "'});" %>'
						/>
					</span>
				</c:if>

			<%
				}
			}
			%>

		</div>
	</div>
</c:if>