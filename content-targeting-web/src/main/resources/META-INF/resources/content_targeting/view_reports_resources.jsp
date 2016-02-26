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
String backURL = ParamUtil.getString(request, "backURL");
String redirect = ParamUtil.getString(request, "redirect");
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");
String reportKeywords = ParamUtil.getString(request, "reportKeywords");

RowChecker reportsRowChecker = new RowChecker(liferayPortletResponse);

SearchContainerIterator searchContainerIterator = new ReportSearchContainerIterator(scopeGroupId, reportKeywords, className, classPK);
%>

<liferay-portlet:renderURL varImpl="viewReportsURL">
	<portlet:param name="redirect" value="<%= redirect %>" />
	<portlet:param name="backURL" value="<%= backURL %>" />

	<c:choose>
		<c:when test="<%= Campaign.class.getName().equals(className) %>">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
			<portlet:param name="campaignId" value="<%= String.valueOf(classPK) %>" />
			<portlet:param name="tabs2" value="reports" />
		</c:when>
		<c:when test="<%= UserSegment.class.getName().equals(className) %>">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
			<portlet:param name="userSegmentId" value="<%= String.valueOf(classPK) %>" />
			<portlet:param name="tabs2" value="reports" />
		</c:when>
		<c:otherwise>
			<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW_REPORTS %>" />
		</c:otherwise>
	</c:choose>

	<portlet:param name="className" value="<%= className %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
</liferay-portlet:renderURL>

<c:if test="<%= classPK > 0 %>">
	<liferay-ui:search-container
		emptyResultsMessage="no-reports-were-found"
		iteratorURL="<%= viewReportsURL %>"
		rowChecker="<%= reportsRowChecker %>"
		total="<%= searchContainerIterator.getTotal() %>"
	>
		<liferay-ui:search-container-results
			results="<%= searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.model.ReportInstance"
			keyProperty="reportInstanceId"
			modelVar="reportInstance"
		>

			<liferay-portlet:renderURL varImpl="viewReportURL">
				<portlet:param
					name="mvcRenderCommandName"
					value="<%= ContentTargetingMVCCommand.VIEW_REPORT %>"
				/>
				<portlet:param
					name="className"
					value="<%= className %>"
				/>
				<portlet:param
					name="classPK"
					value="<%= String.valueOf(classPK) %>"
				/>
				<portlet:param
					name="redirect"
					value="<%= viewReportsURL.toString() %>"
				/>
				<portlet:param
					name="reportKey"
					value="<%= reportInstance.getReportKey() %>"
				/>
				<portlet:param
					name="reportInstanceId"
					value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>"
				/>
			</liferay-portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= viewReportURL.toString() %>"
				name="type"
				value="<%= reportInstance.getTypeName(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= viewReportURL.toString() %>"
				name="name"
				value="<%= reportInstance.getName(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= viewReportURL.toString() %>"
				name="description"
				value="<%= reportInstance.getDescription(locale) %>"
			/>

			<liferay-ui:search-container-column-date
				name="last-update"
				value="<%= reportInstance.getModifiedDate() %>"
			/>

			<liferay-ui:search-container-column-jsp
				path="/content_targeting/reports_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</c:if>

<aui:script use="liferay-util-list-fields">
	var deleteReports = A.one('#<portlet:namespace />deleteReports');

	if (deleteReports) {
		A.one('#<portlet:namespace /><%= searchContainerReference.getId(request) %>SearchContainer').on(
			'click',
			function() {
				var hide = (Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmReports, '<portlet:namespace />allRowIds').length == 0);

				deleteReports.toggle(!hide);
			},
			'input[type=checkbox]'
		);

		deleteReports.on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					document.<portlet:namespace />fmReports.<portlet:namespace />reportInstanceIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmReports, '<portlet:namespace />allRowIds');

					<liferay-portlet:actionURL name="deleteReportInstance" var="deleteReportsURL">
						<portlet:param
							name="redirect"
							value="<%= viewReportsURL.toString() %>"
						/>
					</liferay-portlet:actionURL>

					submitForm(document.<portlet:namespace />fmReports, '<%= deleteReportsURL %>');
				}
			}
		);
	}
</aui:script>