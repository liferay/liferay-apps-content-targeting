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
ContentTargetingViewTacticsDisplayContext contentTargetingViewTacticsDisplayContext = new ContentTargetingViewTacticsDisplayContext(liferayPortletRequest, liferayPortletResponse);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingViewTacticsDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingViewTacticsDisplayContext.getCampaignTitle());
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="<%= currentURL %>" label="promotions" selected="<%= true %>" />
	</aui:nav>

	<c:if test="<%= contentTargetingViewTacticsDisplayContext.isSearchEnabled() %>">
		<aui:nav-bar-search>
			<aui:form action="<%= contentTargetingViewTacticsDisplayContext.getPortletURL() %>" name="searchFm">
				<liferay-ui:input-search markupView="lexicon" name="keywords" />
			</aui:form>
		</aui:nav-bar-search>
	</c:if>
</aui:nav-bar>

<liferay-frontend:management-bar
	disabled="<%= contentTargetingViewTacticsDisplayContext.isDisabledManagementBar() %>"
	includeCheckBox="<%= contentTargetingViewTacticsDisplayContext.isIncludeCheckbox() %>"
	searchContainerId="tactics"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews="<%= contentTargetingViewTacticsDisplayContext.getDisplayViews() %>"
			portletURL="<%= contentTargetingViewTacticsDisplayContext.getPortletURL() %>"
			selectedDisplayStyle="<%= contentTargetingViewTacticsDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= contentTargetingViewTacticsDisplayContext.getPortletURL() %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= contentTargetingViewTacticsDisplayContext.getOrderByCol() %>"
			orderByType="<%= contentTargetingViewTacticsDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"modified-date"} %>'
			portletURL="<%= contentTargetingViewTacticsDisplayContext.getPortletURL() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test="<%= contentTargetingViewTacticsDisplayContext.isIncludeCheckbox() %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteTactics" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<portlet:actionURL name="deleteTactic" var="deleteTacticsURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteTacticsURL %>" cssClass="container-fluid-1280" method="post" name="fmTactics">
	<liferay-ui:search-container
		searchContainer="<%= contentTargetingViewTacticsDisplayContext.getTacticSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.model.Tactic"
			keyProperty="tacticId"
			modelVar="tactic"
		>
			<c:choose>
				<c:when test="<%= contentTargetingViewTacticsDisplayContext.isDescriptiveView() %>">
					<liferay-ui:search-container-column-icon
						icon="page"
						toggleRowChecker="<%= true %>"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h4>
							<%= HtmlUtil.escape(tactic.getName(locale)) %>
						</h4>

						<p class="text-default">
							<%= HtmlUtil.escape(tactic.getDescription(locale)) %>
						</p>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						path="/tactic_action.jsp"
					/>
				</c:when>
				<c:when test="<%= contentTargetingViewTacticsDisplayContext.isIconView() %>">

					<%
					row.setCssClass("col-md-2 col-sm-4 col-xs-6");
					%>

					<liferay-ui:search-container-column-text>
						<liferay-frontend:icon-vertical-card
						actionJsp="/tactic_action.jsp"
						actionJspServletContext="<%= application %>"
						icon="page"
						resultRow="<%= row %>"
						rowChecker="<%= contentTargetingViewTacticsDisplayContext.getRowChecker() %>"
						title="<%= tactic.getName(locale) %>"
						/>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:otherwise>
					<liferay-ui:search-container-column-text
						cssClass="content-column name-column title-column"
						name="name"
						truncate="<%= true %>"
						value="<%= tactic.getName(locale) %>"
					/>

					<liferay-ui:search-container-column-text
						cssClass="content-column description-column"
						name="description"
						truncate="<%= true %>"
						value="<%= tactic.getDescription(locale) %>"
					/>

					<liferay-ui:search-container-column-jsp
						cssClass="entry-action-column"
						path="/tactic_action.jsp"
					/>
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator displayStyle="<%= contentTargetingViewTacticsDisplayContext.getDisplayStyle() %>" markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<c:if test="<%= contentTargetingViewTacticsDisplayContext.showAddButton() %>">
	<liferay-portlet:renderURL var="addTacticURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_TACTIC %>" />
		<portlet:param name="campaignId" value="<%= String.valueOf(contentTargetingViewTacticsDisplayContext.getCampaignId()) %>" />
	</liferay-portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-promotion") %>' url="<%= addTacticURL %>" />
	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= contentTargetingViewTacticsDisplayContext.isIncludeCheckbox() %>">
	<aui:script use="liferay-util-list-fields">
		$('#<portlet:namespace />deleteTactics').on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					submitForm(document.<portlet:namespace />fmTactics);
				}
			}
		);
	</aui:script>
</c:if>