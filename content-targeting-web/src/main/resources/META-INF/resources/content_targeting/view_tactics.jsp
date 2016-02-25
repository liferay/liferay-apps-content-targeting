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
String redirect = ParamUtil.getString(request, "redirect");
long campaignId = ParamUtil.getLong(request, "campaignId", 0);

Campaign campaign = null;

if (campaignId > 0) {
	campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);
}
%>

<liferay-portlet:renderURL var="searchURL">
	<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
	<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(campaignId) %>" />
	<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
	<portlet:param name="tabs2" value="promotions" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="post" name="fmTactics">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="campaignId" type="hidden" value="<%= campaignId %>" />
	<aui:input name="tacticsIds" type="hidden" />

	<aui:nav-bar>
		<%@ include file="/content_targeting/tactic_toolbar.jspf" %>

		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search
					id="tacticskeywords"
					name="tacticKeywords"
					placeholder='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "keywords") %>'
				/>
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>

	<div id="<portlet:namespace />tacticsPanel">
		<liferay-util:include page="/content_targeting/view_tactics_resources.jsp" servletContext="<%= application %>">
		</liferay-util:include>
	</div>
</aui:form>

<aui:script use="liferay-ajax-search">
	var tacticsPanel = A.one('#<portlet:namespace />tacticsPanel');
	var inputNode = A.one('#<portlet:namespace />tacticskeywords');

	var search = new Liferay.AjaxContentSearch(
		{
			contentPanel: tacticsPanel,
			inputNode: inputNode,
			resourceURL: '<liferay-portlet:resourceURL><portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW_TACTICS_RESOURCES %>" /></liferay-portlet:resourceURL>',
			namespace: '<portlet:namespace />'
		}
	);
</aui:script>