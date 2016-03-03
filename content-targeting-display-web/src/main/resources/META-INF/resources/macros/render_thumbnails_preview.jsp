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

int selectedIndex = ParamUtil.getInteger(request, "selectedIndex");
%>

<c:if test="<%= queryRules.size() > 0 %>">

	<%
	for (QueryRule queryRule : queryRules) {
		int queryRule_index = queryRules.indexOf(queryRule);
	%>

		<c:if test="<%= selectedIndex != queryRule_index %>">
			<div class="full-content hide" id="<portlet:namespace />FullContent<%= queryRule_index %>">
				<c:if test="<%= queryRule.hasAssetEntry() %>">
					<c:choose>
						<c:when test="<%= queryRule.getTemplate() != null %>">

							<%= queryRule.getTemplate() %>

						</c:when>
						<c:otherwise>

							<%
							queryRule.setAssetAttributes(renderRequest);
							%>

							<liferay-util:include page="/macros/render_asset_entry.jsp" servletContext="<%= application %>" />
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>
		</c:if>

	<%
	}
	%>

	<div class="content-preview-container lfr-meta-actions" id="<portlet:namespace />contentPreviewContainer">

		<%
		for (QueryRule queryRule : queryRules) {
			int queryRule_index = queryRules.indexOf(queryRule);

			String cssClass = "";

			if (selectedIndex == queryRule_index) {
				cssClass = "selected";
			}
		%>

			<div class="content-preview <%= cssClass %>" data-index="<%= queryRule_index %>" id="<portlet:namespace />PreviewContent<%= queryRule_index %>">
				<div class="query-rule-image" style="background-image: url(<%= queryRule.getAssetImage(renderRequest) %>);"></div>

				<div class="query-rule-summary"><%= queryRule.getSummary(portletConfig, locale) %></div>
			</div>

		<%
		}
		%>

	</div>

	<aui:script use="liferay-thumbnails-preview">
	new Liferay.ThumbnailsPreview(
		{
			selectedIndex: <%= selectedIndex %>,
			namespace: '<portlet:namespace />'
		}
	);
	</aui:script>
</c:if>