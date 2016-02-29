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
String portletResource = ParamUtil.getString(request, "portletResource");
String portletNamespace = PortalUtil.getPortletNamespace(portletResource);

List<Campaign> campaigns = (List<Campaign>)request.getAttribute("campaigns");

CampaignQueryRule campaignQueryRule = (CampaignQueryRule)request.getAttribute("configuration.queryRule");

if (campaignQueryRule == null) {
	campaignQueryRule = new CampaignQueryRule();
}

int index = ParamUtil.getInteger(request, "index", campaignQueryRule.getIndex());

boolean isFirst = GetterUtil.getBoolean(request.getAttribute("configuration.isFirst"));

String fullViewClass = "";
String summaryViewClass = "hide";

if (campaignQueryRule.isValid() && !isFirst) {
	fullViewClass = "hide";
	summaryViewClass = "";
}
%>

<div class="field-row query-row">
	<c:choose>
		<c:when test="<%= campaignQueryRule.isDefaultRule() %>">
			<aui:input name='<%= portletNamespace + "queryIndex" + index %>' type="hidden" usenamespace="<%= false %>" />

			<%
				request.setAttribute("queryRule", campaignQueryRule);
			%>

			<liferay-util:include page="/macros/render_default_query_rule.jsp" servletContext="<%= application %>">
				<liferay-util:param name="index" value="<%= String.valueOf(index) %>" />
				<liferay-util:param name="portletNamespace" value="<%= portletNamespace %>" />
			</liferay-util:include>
		</c:when>
		<c:otherwise>
			<div class="full-view <%= fullViewClass %>">
				<aui:col width="50">

				<span class="query-contains-text"><liferay-ui:message key="if-the-user-matches-this-campaign" /></span>

				<div class="campaign-selector">
					<aui:select label="" name='<%= portletNamespace + "campaignId" + index %>' useNamespace="<%= false %>">

						<%
						for (Campaign campaign : campaigns) {
						%>

						<aui:option label="<%= campaign.getNameWithGroupName(locale, themeDisplay.getScopeGroupId()) %>" selected="<%= (campaignQueryRule.getCampaignId() == campaign.getCampaignId()) %>" value="<%= campaign.getCampaignId() %>" />

						<%
						}
						%>

					</aui:select>
				</div>
				</aui:col>

				<aui:col width="45">
					<div class="select-asset-selector">
						<span class="query-and-operator-text"><liferay-ui:message key="display-this-content" /></span>

						<%
							request.setAttribute("queryRule", campaignQueryRule);
						%>

						<liferay-util:include page="/macros/render_asset_entry_selector.jsp" servletContext="<%= application %>">
							<liferay-util:param name="portletNamespace" value="<%= portletNamespace %>" />
							<liferay-util:param name="index" value="<%= String.valueOf(index) %>" />
						</liferay-util:include>
					</div>
				</aui:col>
			</div>

			<c:if test="<%= campaignQueryRule.isValid() %>">
				<div class="summary-view <%= summaryViewClass %>">
					<aui:col width="50">
						<span class="query-content-text"><liferay-ui:message key="if-the-user-matches-this-campaign" /></span>
						<span class="query-content-value"><%= campaignQueryRule.getCampaignName(locale) %> (<liferay-ui:message key="priority" /> <%= campaignQueryRule.getCampaignPriority() %>)</span>
					</aui:col>

				<aui:col width="45">
					<span class="query-content-text"><liferay-ui:message key="display-this-content" /></span>
					<span class="query-content-value"><%= campaignQueryRule.getAssetTitle() %> (<span class="query-content-value-type"><%= campaignQueryRule.getAssetType() %></span>)</span>
				</aui:col>
				</div>
			</c:if>
		</c:otherwise>
	</c:choose>
</div>