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
ContentTargetingViewCampaignDisplayContext contentTargetingViewCampaignDisplayContext = new ContentTargetingViewCampaignDisplayContext(liferayPortletRequest, liferayPortletResponse);
%>

<liferay-util:include page="/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= String.valueOf(contentTargetingViewCampaignDisplayContext.isSearchEnabled()) %>" />
</liferay-util:include>

<liferay-frontend:management-bar
	disabled="<%= contentTargetingViewCampaignDisplayContext.isDisabledManagementBar() %>"
	includeCheckBox="<%= contentTargetingViewCampaignDisplayContext.isIncludeCheckBox() %>"
	searchContainerId="campaigns"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-portlet:actionURL name="<%= ContentTargetingMVCCommand.UPDATE_DISPLAY_VIEW %>" varImpl="updateDisplayStyleURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</liferay-portlet:actionURL>

		<liferay-frontend:management-bar-display-buttons
			displayViews="<%= contentTargetingViewCampaignDisplayContext.getDisplayViews() %>"
			portletURL="<%= updateDisplayStyleURL %>"
			selectedDisplayStyle="<%= contentTargetingViewCampaignDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all", "recent", "mine"} %>'
			portletURL="<%= contentTargetingViewCampaignDisplayContext.getPortletURL() %>"
		/>

		<liferay-frontend:management-bar-filter
			label="status"
			managementBarFilterItems="<%= contentTargetingViewCampaignDisplayContext.getManagementBarStatusFilterItems() %>"
			value="<%= contentTargetingViewCampaignDisplayContext.getStatus() %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= contentTargetingViewCampaignDisplayContext.getOrderByCol() %>"
			orderByType="<%= contentTargetingViewCampaignDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"modified-date", "start-date", "priority"} %>'
			portletURL="<%= contentTargetingViewCampaignDisplayContext.getPortletURL() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test="<%= contentTargetingViewCampaignDisplayContext.isIncludeCheckBox() %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteCampaigns" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<portlet:actionURL name="deleteCampaign" var="deleteCampaignsURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteCampaignsURL %>" cssClass="container-fluid-1280" method="post" name="fmCampaigns">
	<liferay-ui:search-container
		searchContainer="<%= contentTargetingViewCampaignDisplayContext.getCampaignSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.model.Campaign"
			keyProperty="campaignId"
			modelVar="campaign"
		>

			<%
			request.setAttribute("aui:icon:src:ext", PortalUtil.getPathContext(request) + "/icons/audience-targeting.svg");
			%>

			<c:choose>
				<c:when test="<%= contentTargetingViewCampaignDisplayContext.isDescriptiveView() %>">
					<liferay-ui:search-container-column-icon
						icon="campaigns"
						toggleRowChecker="<%= true %>"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h4>
							<%= HtmlUtil.escape(campaign.getName(locale)) %>
						</h4>

						<c:if test="<%= Validator.isNotNull(campaign.getDescription(locale)) %>">
							<p class="text-default">
								<%= HtmlUtil.escape(campaign.getDescription(locale)) %>
							</p>
						</c:if>

						<div class="text-default">
							<span class="label text-default">
								<strong>
									<liferay-ui:message key="<%= campaign.getStatus() %>" />
								</strong>
							</span>

							<span class="label text-default">
								<strong>
									<liferay-ui:message key="priority" />:
								</strong>

								<%= campaign.getPriority() %>
							</span>

							<span class="label text-default">
								<strong>
									<liferay-ui:message key="start-date" />:
								</strong>

								<%= dateFormatDateTime.format(campaign.getStartDate()) %>
							</span>

							<span class="label text-default">
								<strong>
									<liferay-ui:message key="end-date" />:
								</strong>

								<%= dateFormatDateTime.format(campaign.getEndDate()) %>
							</span>
						</div>

					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						path="/campaign_action.jsp"
					/>
				</c:when>
				<c:when test="<%= contentTargetingViewCampaignDisplayContext.isIconView() %>">

					<%
					row.setCssClass("col-md-2 col-sm-4 col-xs-6");
					%>

					<liferay-ui:search-container-column-text>
						<liferay-frontend:icon-vertical-card
							actionJsp="/campaign_action.jsp"
							actionJspServletContext="<%= application %>"
							icon="campaigns"
							resultRow="<%= row %>"
							rowChecker="<%= searchContainer.getRowChecker() %>"
							title="<%= campaign.getName(locale) %>"
						>
							<liferay-frontend:vertical-card-footer>
								<liferay-ui:message key="<%= campaign.getStatus() %>" />
								<p>
									<liferay-ui:message key="priority" />: <%= campaign.getPriority() %>
								</p>
							</liferay-frontend:vertical-card-footer>
						</liferay-frontend:icon-vertical-card>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:otherwise>
					<liferay-ui:search-container-column-text
						cssClass="content-column name-column title-column"
						name="name"
						truncate="<%= true %>"
						value="<%= campaign.getName(locale) %>"
					/>

					<liferay-ui:search-container-column-text
						cssClass="content-column description-column"
						name="description"
						truncate="<%= true %>"
						value="<%= campaign.getDescription(locale) %>"
					/>

					<liferay-ui:search-container-column-date
						cssClass="modified-date-column text-column"
						name="modified-date"
						value="<%= campaign.getModifiedDate() %>"
					/>

					<liferay-ui:search-container-column-date
						cssClass="start-date-column text-column"
						name="start-date"
						value="<%= campaign.getStartDate() %>"
					/>

					<liferay-ui:search-container-column-date
						cssClass="end-date-column text-column"
						name="end-date"
						value="<%= campaign.getEndDate() %>"
					/>

					<liferay-ui:search-container-column-text
						cssClass="priority-column text-column"
						name="priority"
						value="<%= String.valueOf(campaign.getPriority()) %>"
					/>

					<liferay-ui:search-container-column-text
						cssClass="status-column text-column"
						name="status"
					>
						<liferay-ui:message key="<%= campaign.getStatus() %>" />
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						cssClass="entry-action-column"
						path="/campaign_action.jsp"
					/>
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator displayStyle="<%= contentTargetingViewCampaignDisplayContext.getDisplayStyle() %>" markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<c:if test="<%= contentTargetingViewCampaignDisplayContext.showAddButton() %>">
	<portlet:renderURL var="addCampaignURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-campaign") %>' url="<%= addCampaignURL.toString() %>" />
	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= contentTargetingViewCampaignDisplayContext.isIncludeCheckBox() %>">
	<aui:script>
		$('#<portlet:namespace />deleteCampaigns').on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					submitForm(document.<portlet:namespace />fmCampaigns);
				}
			}
		);
	</aui:script>
</c:if>