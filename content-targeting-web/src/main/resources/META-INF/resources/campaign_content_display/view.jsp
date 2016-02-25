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
ServletContext analyticsServletContext = (ServletContext)request.getAttribute("analyticsServletContext");

String containerCssClass = "";

if (portletDisplay.isShowConfigurationIcon()) {
	containerCssClass = "show-configuration";
}

boolean isNotConfigured = GetterUtil.getBoolean(request.getAttribute("isNotConfigured"), true);

CampaignQueryRule queryRule = (CampaignQueryRule)request.getAttribute("queryRule");

List<CampaignQueryRule> campaignQueryRules = (List<CampaignQueryRule>)request.getAttribute("campaignQueryRules");

String portletDisplayTemplateHtml = GetterUtil.getString(request.getAttribute("portletDisplayTemplateHtml"));

int selectedIndex = GetterUtil.getInteger(request.getAttribute("selectedIndex"));

boolean showPreview = GetterUtil.getBoolean(request.getAttribute("showPreview"), false);
%>

<div class="content-container <%= containerCssClass %>">
	<div class="full-content" id="<portlet:namespace />FullContent<%= selectedIndex %>">
		<c:choose>
			<c:when test="<%= isNotConfigured %>">
				<div class="alert alert-info">
					<liferay-ui:message key="configure-this-app-to-display-different-content-per-campaign" />
				</div>
			</c:when>
			<c:when test="<%= !isNotConfigured && queryRule.hasAssetEntry() %>">
				<c:choose>
					<c:when test="<%= !Validator.isBlank(portletDisplayTemplateHtml) %>">
						<%= portletDisplayTemplateHtml %>
					</c:when>
					<c:otherwise>

						<%
						queryRule.setAssetAttributes(renderRequest);
						%>

						<liferay-util:include page="/macros/render_asset_entry.jsp" servletContext="<%= application %>" />
					</c:otherwise>
				</c:choose>

				<liferay-util:include page="/common/analytics/track_content.jsp" servletContext="<%= analyticsServletContext %>">
					<liferay-util:param name="analyticsClassName" value="<%= queryRule.getAssetClassName() %>" />
					<liferay-util:param name="analyticsClassPK" value="<%= String.valueOf(queryRule.getAssetClassPK()) %>" />
					<liferay-util:param name="analyticsReferrerClassName" value="<%= Campaign.class.getName() %>" />
					<liferay-util:param name="analyticsReferrerClassPKs" value="<%= String.valueOf(queryRule.getCampaignId()) %>" />
				</liferay-util:include>
			</c:when>
			<c:otherwise>
				<div class="alert alert-info">
					<liferay-ui:message key="there-are-no-matching-rules" />
				</div>
			</c:otherwise>
		</c:choose>

	</div>

	<c:if test="<%= showPreview %>">

		<%
		request.setAttribute("queryRules", campaignQueryRules);
		%>

		<liferay-util:include page="/macros/render_thumbnails_preview.jsp" servletContext="<%= application %>">
			<liferay-util:param name="selectedIndex" value="<%= String.valueOf(selectedIndex) %>" />
		</liferay-util:include>
	</c:if>
</div>

<%
request.setAttribute("queryRules", campaignQueryRules);
%>

<liferay-util:include page="/macros/edit_icon_links.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedIndex" value="<%= String.valueOf(selectedIndex) %>" />
</liferay-util:include>