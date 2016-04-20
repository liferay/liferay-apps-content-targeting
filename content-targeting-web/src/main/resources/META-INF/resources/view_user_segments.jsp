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
ContentTargetingViewUserSegmentsDisplayContext contentTargetingViewUserSegmentsDisplayContext = new ContentTargetingViewUserSegmentsDisplayContext(liferayPortletRequest, liferayPortletResponse);
%>

<liferay-ui:error key="com.liferay.content.targeting.exception.UsedUserSegmentException">
	<liferay-ui:message key="the-following-user-segments" />

	<ul>

		<%
		List<UserSegment> usedUserSegments = (List<UserSegment>)SessionMessages.get(request, "usedUserSegments");

		for (UserSegment userSegment : usedUserSegments) {
		%>

			<li><%= userSegment.getName(locale) %></li>

		<%
		}
		%>

	</ul>

	<liferay-ui:message key="cannot-be-deleted-because-they-are-used-in-the-following-campaigns" />

	<ul>

		<%
		for (Campaign campaign : ((UsedUserSegmentException)errorException).getCampaigns()) {
		%>

			<li><%= campaign.getName(locale) %></li>

		<%
		}
		%>

	</ul>
</liferay-ui:error>

<liferay-util:include page="/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= String.valueOf(contentTargetingViewUserSegmentsDisplayContext.isSearchEnabled()) %>" />
</liferay-util:include>

<liferay-frontend:management-bar
	disabled="<%= contentTargetingViewUserSegmentsDisplayContext.isDisabledManagementBar() %>"
	includeCheckBox="<%= contentTargetingViewUserSegmentsDisplayContext.isIncludeCheckBox() %>"
	searchContainerId="userSegments"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-portlet:actionURL name="<%= ContentTargetingMVCCommand.UPDATE_DISPLAY_VIEW %>" varImpl="updateDisplayStyleURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</liferay-portlet:actionURL>

		<liferay-frontend:management-bar-display-buttons
			displayViews="<%= contentTargetingViewUserSegmentsDisplayContext.getDisplayViews() %>"
			portletURL="<%= updateDisplayStyleURL %>"
			selectedDisplayStyle="<%= contentTargetingViewUserSegmentsDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all", "recent", "mine"} %>'
			portletURL="<%= contentTargetingViewUserSegmentsDisplayContext.getPortletURL() %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= contentTargetingViewUserSegmentsDisplayContext.getOrderByCol() %>"
			orderByType="<%= contentTargetingViewUserSegmentsDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"modified-date"} %>'
			portletURL="<%= contentTargetingViewUserSegmentsDisplayContext.getPortletURL() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test="<%= contentTargetingViewUserSegmentsDisplayContext.isIncludeCheckBox() %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteUserSegments" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<portlet:actionURL name="deleteUserSegment" var="deleteUserSegmentURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteUserSegmentURL %>" cssClass="container-fluid-1280" name="fmUserSegment">
	<liferay-ui:search-container
		id="userSegments"
		searchContainer="<%= contentTargetingViewUserSegmentsDisplayContext.getUserSegmentSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.model.UserSegment"
			keyProperty="userSegmentId"
			modelVar="userSegment"
		>
			<portlet:renderURL var="userSegmentSummaryURL">
				<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_USER_SEGMENT %>" />
				<portlet:param name="tabs1" value="summary" />
				<portlet:param name="userSegmentId" value="<%= String.valueOf(userSegment.getUserSegmentId()) %>" />
			</portlet:renderURL>

			<c:choose>
				<c:when test="<%= contentTargetingViewUserSegmentsDisplayContext.isDescriptiveView() %>">
					<liferay-ui:search-container-column-text>

						<%
						request.setAttribute("aui:icon:src:ext", PortalUtil.getPathContext(request) + "/icons/audience-targeting.svg");
						%>

						<div class="click-selector sticker-default sticker-lg">
							<aui:icon cssClass="text-default" image="user-segments" markupView="lexicon" />
						</div>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h4>
							<aui:a href="<%= userSegmentSummaryURL.toString() %>"><%= HtmlUtil.escape(userSegment.getName(locale)) %></aui:a>
						</h4>

						<p class="text-default">
							<%= HtmlUtil.escape(userSegment.getDescription(locale)) %>
						</p>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						path="/user_segments_action.jsp"
					/>
				</c:when>
				<c:when test="<%= contentTargetingViewUserSegmentsDisplayContext.isIconView() %>">

					<%
					request.setAttribute("aui:icon:src:ext", PortalUtil.getPathContext(request) + "/icons/audience-targeting.svg");

					row.setCssClass("entry-card lfr-asset-item");
					%>

					<liferay-ui:search-container-column-text>
						<liferay-frontend:icon-vertical-card
							actionJsp="/user_segments_action.jsp"
							actionJspServletContext="<%= application %>"
							icon="user-segments"
							resultRow="<%= row %>"
							rowChecker="<%= searchContainer.getRowChecker() %>"
							title="<%= userSegment.getName(locale) %>"
						/>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:otherwise>
					<liferay-ui:search-container-column-text
						cssClass="content-column name-column title-column"
						name="name"
						truncate="<%= true %>"
					>
						<aui:a href="<%= userSegmentSummaryURL.toString() %>"><%= HtmlUtil.escape(userSegment.getName(locale)) %></aui:a>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="content-column description-column"
						name="description"
						truncate="<%= true %>"
						value="<%= userSegment.getDescription(locale) %>"
					/>

					<liferay-ui:search-container-column-date
						cssClass="status-column text-column"
						name="modified-date"
						value="<%= userSegment.getModifiedDate() %>"
					/>

					<liferay-ui:search-container-column-jsp
						cssClass="entry-action-column"
						path="/user_segments_action.jsp"
					/>
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator displayStyle="<%= contentTargetingViewUserSegmentsDisplayContext.getDisplayStyle() %>" markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<c:if test="<%= contentTargetingViewUserSegmentsDisplayContext.showAddButton() %>">
	<portlet:renderURL var="addUserSegmentURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-user-segment") %>' url="<%= addUserSegmentURL %>" />
	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= contentTargetingViewUserSegmentsDisplayContext.isIncludeCheckBox() %>">
	<aui:script>
		$('#<portlet:namespace />deleteUserSegments').on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					submitForm(document.<portlet:namespace />fmUserSegment);
				}
			}
		);
	</aui:script>
</c:if>