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

<aui:input name='<%= "queryIndex" + index %>' type="hidden" />

<div class="field-row query-row">
	<div class="full-view <%= fullViewClass %>">
		<aui:row>
			<aui:col width="<%= 50 %>">
				<p class="text-default"><liferay-ui:message key="if-the-user-matches-this-campaign" /></p>

				<aui:select label="" name='<%= "campaignId" + index %>'>

					<%
					for (Campaign campaign : campaigns) {
					%>

						<aui:option label="<%= campaign.getNameWithGroupName(locale, themeDisplay.getScopeGroupId()) %>" selected="<%= (campaignQueryRule.getCampaignId() == campaign.getCampaignId()) %>" value="<%= campaign.getCampaignId() %>" />

					<%
					}
					%>

				</aui:select>
			</aui:col>

			<aui:col width="<%= 50 %>">
				<p class="text-default"><liferay-ui:message key="display-this-content" /></p>

				<%
				request.setAttribute("queryRule", campaignQueryRule);
				%>

				<liferay-util:include page="/macros/render_asset_entry_selector.jsp" servletContext="<%= application %>">
					<liferay-util:param name="index" value="<%= String.valueOf(index) %>" />
				</liferay-util:include>
			</aui:col>
		</aui:row>
	</div>

	<c:if test="<%= campaignQueryRule.isValid() %>">
		<div class="summary-view <%= summaryViewClass %>">
			<aui:row>
				<aui:col width="<%= 50 %>">
					<span class="text-default"><liferay-ui:message key="if-the-user-matches-this-campaign" /></span>
					<strong class="text-default"><%= campaignQueryRule.getCampaignName(locale) %> (<span class="small"><liferay-ui:message key="priority" /> <%= campaignQueryRule.getCampaignPriority() %></span>)</strong>
				</aui:col>

				<aui:col width="<%= 50 %>">
					<span class="text-default"><liferay-ui:message key="display-this-content" /></span>
					<strong class="text-default"><%= campaignQueryRule.getAssetTitle() %> (<span class="small"><%= campaignQueryRule.getAssetType() %></span>)</strong>
				</aui:col>
			</aui:row>
		</div>
	</c:if>
</div>