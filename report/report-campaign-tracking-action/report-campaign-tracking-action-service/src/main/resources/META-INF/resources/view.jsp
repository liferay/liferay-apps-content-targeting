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

<div class="container-fluid-1280">
	<liferay-ui:search-container
		searchContainer="<%= campaignTrackingActionReportDisplayContext.getSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal"
			modelVar="ctActionTotal"
		>

			<%
			String eventType = ctActionTotal.getEventType();

			if (eventType.equals("sending")) {
				eventType = "sent";
			}
			else if (eventType.equals("click")) {
				eventType = "link-clicks";
			}
			%>

			<liferay-ui:search-container-column-text
				name="name"
				value="<%= ctActionTotal.getAlias() %>"
			/>

			<liferay-ui:search-container-column-text
				name="event"
				value="<%= LanguageUtil.get(resourceBundle, eventType) %>"
			/>

			<liferay-ui:search-container-column-text
				name="count"
			>

				<%= ctActionTotal.getCount() %>

				<c:if test="<%= ListUtil.isNotEmpty(ctActionTotal.getViewsByUserSegment()) %>">
					<div class="pull-right">
						<i class="icon-info" data-id="<%= ctActionTotal.getCTActionTotalId() %>" style="display: block;padding: 0 1em;"></i>

						<div class="hide" id="<portlet:namespace /><%= "userSegmentViews" + ctActionTotal.getCTActionTotalId() %>">

							<%
							for (CTAction ctAction : ctActionTotal.getViewsByUserSegment()) {
							%>

								<p><%= ctAction.getUserSegmentName(locale) %> - <%= ctAction.getCount() %></p>

							<%
							}
							%>

						</div>
					</div>
				</c:if>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-date
				name="last-update"
				value="<%= ctActionTotal.getModifiedDate() %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />

		<c:if test="<%= searchContainer.getTotal() > 0 %>">
			<liferay-util:include page="/chart.jsp" servletContext="<%= application %>" />
		</c:if>
	</liferay-ui:search-container>

	<aui:script use="aui-base,event-hover">
		A.one('#<portlet:namespace /><%= searchContainerReference.getId(request) %>SearchContainer').delegate(
			'hover',
			function(event) {
				var currentTarget = event.currentTarget;

				var id = currentTarget.attr('data-id');

				var userSegmentViews = A.one('#<portlet:namespace />userSegmentViews' + id);

				Liferay.Portal.ToolTip.show(this, userSegmentViews.html());
			},
			'.icon-info'
		);
	</aui:script>
</div>