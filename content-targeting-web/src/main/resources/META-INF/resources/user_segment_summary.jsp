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
	</aui:fieldset-group>
</div>