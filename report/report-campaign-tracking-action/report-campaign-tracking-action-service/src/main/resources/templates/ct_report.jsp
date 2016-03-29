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

<%@ include file="/templates/init.jsp" %>

<%
Map<String, Object> displayContext = (Map<String, Object>)request.getAttribute("displayContext");

String redirect = GetterUtil.getString(displayContext.get("redirect"));
Report report = (Report)displayContext.get("report");
String className = GetterUtil.getString(displayContext.get("className"));
long classPK = GetterUtil.getLong(displayContext.get("classPK"));
String name = GetterUtil.getString(displayContext.get("name"));

SearchContainerIterator<CTActionTotal> searchContainerIterator = (SearchContainerIterator<CTActionTotal>)displayContext.get("searchContainerIterator");
%>

<liferay-portlet:renderURL varImpl="portletURL">
	<portlet:param
		name="mvcRenderCommandName"
		value="viewReport"
	/>
	<portlet:param
		name="redirect"
		value="<%= redirect %>"
	/>
	<portlet:param
		name="reportKey"
		value="<%= report.getReportKey() %>"
	/>
	<portlet:param
		name="className"
		value="<%= className %>"
	/>
	<portlet:param
		name="classPK"
		value="<%= String.valueOf(classPK) %>"
	/>
</liferay-portlet:renderURL>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		emptyResultsMessage="there-is-not-enough-data-to-generate-this-report"
		iteratorURL="<%= portletURL %>"
		total="<%= searchContainerIterator.getTotal() %>"
	>
		<liferay-ui:search-container-results
			results="<%= searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

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

			List<CTAction> viewsByUserSegment = ctActionTotal.getViewsByUserSegment();
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

				<c:if test="<%= viewsByUserSegment.size() > 0 %>">
					<div class="pull-right">
						<i class="icon-info" data-id="<%= ctActionTotal.getCTActionTotalId() %>" style="display: block;padding: 0 1em;"></i>

						<div class="hide" id="<portlet:namespace /><%= "userSegmentViews" + ctActionTotal.getCTActionTotalId() %>">

							<%
							for (CTAction ctAction : viewsByUserSegment) {
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

		<c:if test="<%= searchContainer.getResults().size() > 0 %>">
			<%@ include file="/templates/ct_chart.jsp" %>
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