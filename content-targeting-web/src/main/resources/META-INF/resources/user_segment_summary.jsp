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
ContentTargetingViewUserSegmentDisplayContext contentTargetingViewUserSegmentDisplayContext = (ContentTargetingViewUserSegmentDisplayContext)renderRequest.getAttribute("contentTargetingViewUserSegmentDisplayContext");
%>

<liferay-util:include page="/view_user_segment_toolbar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="showSearch" value="<%= Boolean.FALSE.toString() %>" />
</liferay-util:include>

<div class="container-fluid-1280" id="<portlet:namespace />summary">
	<aui:fieldset-group markupView="lexicon">
		<div class="panel-body">
			<aui:row>
				<aui:col width="<%= 20 %>">
					<div class="taglib-vertical-card">
						<div class="aspect-ratio icon-vertical-card-container">
							<span class="icon-vertical-card-image">

								<%
								request.setAttribute("aui:icon:src:ext", PortalUtil.getPathContext(request) + "/icons/audience-targeting.svg");
								%>

								<aui:icon image="user-segments" markupView="lexicon" />
							</span>
						</div>
					</div>
				</aui:col>

				<aui:col cssClass="small" width="<%= 80 %>">
					<h1><%= contentTargetingViewUserSegmentDisplayContext.getUserSegmentTitle() %></h1>

					<aui:row>
						<aui:col width="100"><liferay-ui:message key="number-of-users-in-this-segment" /></aui:col>
					</aui:row>

					<aui:row>
						<aui:col width="100"><span class="text-default"><%= contentTargetingViewUserSegmentDisplayContext.getUsersNumber() %></aui:col>
					</aui:row>
				</aui:col>
			</aui:row>

			<br />

			<h3 class="h5"><liferay-ui:message key="description" /></h3>

			<div class="small text-default">
				<c:choose>
					<c:when test="<%= Validator.isNotNull(contentTargetingViewUserSegmentDisplayContext.getDescription()) %>">
						<%= contentTargetingViewUserSegmentDisplayContext.getDescription() %>
					</c:when>
					<c:otherwise>
						<%= StringPool.DASH %>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<%
		Map<String, List<RuleInstance>> ruleCategoriesMap = contentTargetingViewUserSegmentDisplayContext.getRuleInstanceMap();

		for (Map.Entry<String, List<RuleInstance>> ruleCategory : ruleCategoriesMap.entrySet()) {
		%>

			<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="<%= ruleCategory.getKey() %>">
				<div class="row">
					<ul class="list-unstyled">

						<%
						List<RuleInstance> ruleInstances = ListUtil.sort(ruleCategory.getValue(), contentTargetingViewUserSegmentDisplayContext.getRuleInstancesComparator());

						for (RuleInstance ruleInstance : ruleInstances) {
							Rule rule = contentTargetingViewUserSegmentDisplayContext.getRuleByRuleInstance(ruleInstance);
						%>

							<li class="col-md-3 small text-default">
								<div>
									<strong><%= rule.getName(locale) %></strong>
								</div>

								<%= rule.getSummary(ruleInstance, locale) %>
							</li>

						<%
						}
						%>

					</ul>
				</div>
			</aui:fieldset>

		<%
		}
		%>

	</aui:fieldset-group>
</div>