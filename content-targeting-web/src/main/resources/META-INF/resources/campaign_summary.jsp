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
ContentTargetingViewCampaignDisplayContext contentTargetingViewCampaignDisplayContext = (ContentTargetingViewCampaignDisplayContext)renderRequest.getAttribute("contentTargetingViewCampaignDisplayContext");
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

								<aui:icon image="campaigns" markupView="lexicon" />
							</span>
						</div>
					</div>
				</aui:col>

				<aui:col cssClass="small" width="<%= 80 %>">
					<h1><%= contentTargetingViewCampaignDisplayContext.getCampaignTitle() %></h1>

					<aui:row>
						<aui:col width="20"><liferay-ui:message key="status" /></aui:col>
						<aui:col width="20"><liferay-ui:message key="priority" /></aui:col>
						<aui:col width="20"><liferay-ui:message key="start-date" /></aui:col>
						<aui:col width="20"><liferay-ui:message key="end-date" /></aui:col>
						<aui:col width="20"><liferay-ui:message key="time-zone" /></aui:col>
					</aui:row>

					<aui:row>
						<aui:col width="20"><span class="text-default"><liferay-ui:message key="<%= contentTargetingViewCampaignDisplayContext.getStatus() %>" /></span></aui:col>
						<aui:col width="20"><span class="text-default"><%= contentTargetingViewCampaignDisplayContext.getPriority() %></span></aui:col>
						<aui:col width="20"><span class="text-default"><%= dateFormatDateTime.format(contentTargetingViewCampaignDisplayContext.getStartDate()) %></span></aui:col>
						<aui:col width="20"><span class="text-default"><%= dateFormatDateTime.format(contentTargetingViewCampaignDisplayContext.getEndDate()) %></span></aui:col>
						<aui:col width="20"><span class="text-default"><%= contentTargetingViewCampaignDisplayContext.getTimeZoneId() %></span></aui:col>
					</aui:row>
				</aui:col>
			</aui:row>

			<br />

			<h3 class="h5"><liferay-ui:message key="description" /></h3>

			<div class="small text-default">
				<%= contentTargetingViewCampaignDisplayContext.getDescription() %>
			</div>

			<br />

			<h3 class="h5"><liferay-ui:message key="user-segments" /></h3>

			<%
			String[] userSegmentAssetCategories = StringUtil.split(contentTargetingViewCampaignDisplayContext.getUserSegmentAssetCategoryNames(), StringPool.COMMA);

			for (String userSegmentAssetCategory : userSegmentAssetCategories) {
			%>

				<span class="badge badge-default"><%= userSegmentAssetCategory %></span>

			<%
			}
			%>

		</div>
	</aui:fieldset-group>
</div>