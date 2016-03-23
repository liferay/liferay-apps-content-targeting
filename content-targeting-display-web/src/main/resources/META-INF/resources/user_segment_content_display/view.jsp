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
boolean isNotConfigured = GetterUtil.getBoolean(request.getAttribute("isNotConfigured"), true);

QueryRule queryRule = (QueryRule)request.getAttribute("queryRule");

List<QueryRule> userSegmentQueryRules = (List<QueryRule>)request.getAttribute("userSegmentQueryRules");

String portletDisplayTemplateHtml = GetterUtil.getString(request.getAttribute("portletDisplayTemplateHtml"));

int selectedIndex = GetterUtil.getInteger(request.getAttribute("selectedIndex"));

boolean showPreview = GetterUtil.getBoolean(request.getAttribute("showPreview"), false);
%>

<c:if test="<%= showPreview %>">

	<%
		request.setAttribute("queryRules", userSegmentQueryRules);
	%>

	<liferay-util:include page="/macros/preview_panel.jsp" servletContext="<%= application %>">
		<liferay-util:param name="selectedIndex" value="<%= String.valueOf(selectedIndex) %>" />
	</liferay-util:include>
</c:if>

<div class="content-container container-fluid-1280 " id="<portlet:namespace />previewPanel">
	<div class="<%= portletDisplay.isShowConfigurationIcon() ? "show-configuration" : StringPool.BLANK %>">
		<div class="full-content" id="<portlet:namespace />FullContent<%= selectedIndex %>">
			<c:choose>
				<c:when test="<%= isNotConfigured %>">
					<div class="alert alert-info">
						<liferay-ui:message key="configure-this-app-to-display-different-content-to-each-user-segment" />
					</div>
				</c:when>
				<c:when test="<%= queryRule.hasAssetEntry() %>">

					<%
					request.setAttribute("queryRule", queryRule);

					request.setAttribute("assetClassName", queryRule.getAssetClassName());
					request.setAttribute("assetClassPK", String.valueOf(queryRule.getAssetClassPK()));
					%>

					<liferay-util:dynamic-include key="com.liferay.content.targeting.display.web#/user_segment_content_display/view.jsp#pre" />

					<c:choose>
						<c:when test="<%= !Validator.isBlank(portletDisplayTemplateHtml) %>">
							<%= portletDisplayTemplateHtml %>
						</c:when>
						<c:otherwise>
							<liferay-ui:asset-display
								assetEntry="<%= queryRule.getAssetEntry() %>"
								template="full_content"
							/>
						</c:otherwise>
					</c:choose>

					<liferay-util:dynamic-include key="com.liferay.content.targeting.display.web#/user_segment_content_display/view.jsp#post" />
				</c:when>
				<c:otherwise>
					<div class="alert alert-info">
						<liferay-ui:message key="there-are-no-matching-rules" />
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>