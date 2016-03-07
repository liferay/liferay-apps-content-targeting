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
List<AssetEntry> assetEntries = (List<AssetEntry>)request.getAttribute("assetEntries");

String portletDisplayTemplateHtml = GetterUtil.getString(request.getAttribute("portletDisplayTemplateHtml"));
%>

<c:choose>
	<c:when test="<%= ListUtil.isNotEmpty(assetEntries) %>">
		<c:choose>
			<c:when test="<%= !Validator.isBlank(portletDisplayTemplateHtml) %>">
				<%= portletDisplayTemplateHtml %>
			</c:when>
			<c:otherwise>

				<%
				for (AssetEntry assetEntry : assetEntries) {
					request.setAttribute("view.jsp-assetEntry", assetEntry);
					request.setAttribute("view.jsp-assetRenderer", assetEntry.getAssetRenderer());
				%>

					<div class="asset-entry">
						<div class="asset-display">
							<liferay-ui:asset-display
								assetEntry="<%= assetEntry %>"
								template="abstract"
							/>
						</div>

						<portlet:renderURL var="viewContentURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
							<portlet:param name="mvcPath" value="/user_segment_content_list/view_content.jsp" />
							<portlet:param name="assetEntryId" value="<%= String.valueOf(assetEntry.getEntryId()) %>" />
						</portlet:renderURL>

						<a href="<%= viewContentURL %>"><liferay-ui:message key="read-more" /></a>
					</div>

				<%
				}
				%>

			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
	<div class="alert alert-info">
		<liferay-ui:message key="there-is-no-content-categorized-for-your-user-segments" />
	</div>
	</c:otherwise>
</c:choose>