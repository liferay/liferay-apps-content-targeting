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
boolean simulationEnabled = GetterUtil.getBoolean(request.getAttribute("isSimulatedUserSegments"));

List<QueryRule> queryRules = (List<QueryRule>)request.getAttribute("queryRules");

int selectedIndex = ParamUtil.getInteger(request, "selectedIndex");

for (QueryRule queryRule : queryRules) {
	int queryRule_index = queryRules.indexOf(queryRule);
%>

	<div class="full-content hide" id="<portlet:namespace />FullContentHidden<%= queryRule_index %>">
		<c:if test="<%= queryRule.hasAssetEntry() %>">
			<c:choose>
				<c:when test="<%= queryRule.getTemplate() != null %>">
					<%= queryRule.getTemplate() %>
				</c:when>
				<c:otherwise>
					<liferay-ui:asset-display
						assetEntry="<%= queryRule.getAssetEntry() %>"
						template="full_content"
					/>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>

<%
}
%>

<c:if test="<%= !simulationEnabled %>">
	<div class="content-preview-button dropdown visible-interaction-button">
		<button class="btn btn-default dropdown-toggle icon-monospaced" data-toggle="dropdown" type="button">
			<aui:icon image="simulation-menu" markupView="lexicon" />
		</button>

		<ul class="dropdown-menu dropdown-menu-content dropdown-menu-right" id="<portlet:namespace />contentPreviewContainer">

			<%
			for (QueryRule queryRule : queryRules) {
				int queryRule_index = queryRules.indexOf(queryRule);

				request.setAttribute("queryRule", queryRule);
			%>

			<li class="<%= (selectedIndex == queryRule_index) ? "active" : StringPool.BLANK %>" data-index="<%= queryRule_index %>" id="<portlet:namespace />PreviewContent<%= queryRule_index %>">
				<div class="content-preview-link list-group-item-field">
					<div class=" sticker-default sticker-lg" style="background-image: url(<%= queryRule.getAssetImage(renderRequest) %>);"></div>
				</div>

				<div class="content-preview-link list-group-item-content">
					<div class="clamp-container">
						<a class="text-default truncate-text" href="javascript:;"><%= queryRule.getSummary(portletConfig, locale) %></a>
					</div>
				</div>

				<c:if test="<%= queryRule.getAssetClassPK() > 0 %>">
					<div class="list-group-item-field">
						<liferay-util:include page="/macros/edit_icon_link.jsp" servletContext="<%= application %>" />
					</div>
				</c:if>
			</li>

			<%
			}
			%>

		</ul>
	</div>

	<aui:script use="liferay-thumbnails-preview">
		new Liferay.ThumbnailsPreview(
			{
				namespace: '<portlet:namespace />',
				selectedIndex: <%= selectedIndex %>
			}
		);
	</aui:script>
</c:if>