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
ContentTargetingViewReportsDisplayContext contentTargetingViewReportsDisplayContext = new ContentTargetingViewReportsDisplayContext(liferayPortletRequest, liferayPortletResponse);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingViewReportsDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingViewReportsDisplayContext.getReportsTitle());
%>

<c:if test="<%= contentTargetingViewReportsDisplayContext.isStagingGroup() %>">
	<div class="alert alert-warning">
		<liferay-ui:message key="the-staging-environment-is-activated-reports-data-refer-to-the-live-environment" />

		<c:if test="<%= !contentTargetingViewReportsDisplayContext.hasReports() %>">
			<strong><liferay-ui:message key="you-must-publish-to-live-before-you-can-view-any-reports" /></strong>
		</c:if>
	</div>
</c:if>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="<%= currentURL %>" label="reports" selected="<%= true %>" />
	</aui:nav>

	<c:if test="<%= !contentTargetingViewReportsDisplayContext.isDisabledManagementBar() %>">
		<aui:nav-bar-search>
			<aui:form action="<%= contentTargetingViewReportsDisplayContext.getPortletURL() %>" name="searchFm">
				<liferay-ui:input-search markupView="lexicon" name="keywords" />
			</aui:form>
		</aui:nav-bar-search>
	</c:if>
</aui:nav-bar>

<liferay-frontend:management-bar
	disabled="<%= contentTargetingViewReportsDisplayContext.isDisabledManagementBar() %>"
	includeCheckBox="<%= contentTargetingViewReportsDisplayContext.isIncludeCheckBox() %>"
	searchContainerId="reports"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-portlet:actionURL name="<%= ContentTargetingMVCCommand.UPDATE_DISPLAY_VIEW %>" varImpl="updateDisplayStyleURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</liferay-portlet:actionURL>

		<liferay-frontend:management-bar-display-buttons
			displayViews="<%= contentTargetingViewReportsDisplayContext.getDisplayViews() %>"
			portletURL="<%= updateDisplayStyleURL %>"
			selectedDisplayStyle="<%= contentTargetingViewReportsDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= contentTargetingViewReportsDisplayContext.getPortletURL() %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= contentTargetingViewReportsDisplayContext.getOrderByCol() %>"
			orderByType="<%= contentTargetingViewReportsDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"modified-date"} %>'
			portletURL="<%= contentTargetingViewReportsDisplayContext.getPortletURL() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test="<%= contentTargetingViewReportsDisplayContext.isIncludeCheckBox() %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteReports" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<c:if test="<%= contentTargetingViewReportsDisplayContext.hasReports() %>">
	<portlet:actionURL name="deleteReportInstance" var="deleteReportsURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:actionURL>

	<aui:form action="<%= deleteReportsURL %>" cssClass="container-fluid-1280" method="post" name="fmReports">
		<liferay-ui:search-container
			searchContainer="<%= contentTargetingViewReportsDisplayContext.getReportsSearchContainer() %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.content.targeting.model.ReportInstance"
				keyProperty="reportInstanceId"
				modelVar="reportInstance"
			>

				<portlet:renderURL var="viewReportURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_REPORT %>" />
					<portlet:param name="className" value="<%= contentTargetingViewReportsDisplayContext.getClassName() %>" />
					<portlet:param name="classPK" value="<%= String.valueOf(contentTargetingViewReportsDisplayContext.getClassPK()) %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="reportKey" value="<%= reportInstance.getReportKey() %>" />
					<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
				</portlet:renderURL>

				<%
				request.setAttribute("aui:icon:src:ext", PortalUtil.getPathContext(request) + "/icons/audience-targeting.svg");
				%>

				<c:choose>
					<c:when test="<%= contentTargetingViewReportsDisplayContext.isDescriptiveView() %>">
						<liferay-ui:search-container-column-icon
							icon="reports"
							toggleRowChecker="<%= true %>"
						/>

						<liferay-ui:search-container-column-text
							colspan="<%= 2 %>"
						>
							<h4 class="preview" data-title="<%= reportInstance.getName(locale) %>" data-url="<%= viewReportURL %>">
								<a href="javascript:;"><%= reportInstance.getName(locale) %></a>
							</h4>

							<p class="text-default">
								<%= HtmlUtil.escape(reportInstance.getDescription(locale)) %>
							</p>

							<div class="text-default">
								<%= reportInstance.getTypeName(locale) %>
							</div>
						</liferay-ui:search-container-column-text>

						<liferay-ui:search-container-column-jsp
							path="/reports_action.jsp"
						/>
					</c:when>
					<c:when test="<%= contentTargetingViewReportsDisplayContext.isIconView() %>">

						<%
						row.setCssClass("col-md-2 col-sm-4 col-xs-6");

						Map<String, Object> data = new HashMap<String, Object>();

						data.put("url", viewReportURL.toString());
						data.put("title", reportInstance.getName(locale));
						%>

						<liferay-ui:search-container-column-text>
							<liferay-frontend:icon-vertical-card
								actionJsp="/reports_action.jsp"
								actionJspServletContext="<%= application %>"
								cssClass="preview"
								data="<%= data %>"
								icon="reports"
								resultRow="<%= row %>"
								rowChecker="<%= searchContainer.getRowChecker() %>"
								title="<%= reportInstance.getName(locale) %>"
								url="javascript:;"
							/>
						</liferay-ui:search-container-column-text>
					</c:when>
					<c:otherwise>
						<liferay-ui:search-container-column-text
							cssClass="content-column name-column title-column"
							name="name"
							truncate="<%= true %>"
						>
							<span class="preview" data-title="<%= reportInstance.getName(locale) %>" data-url="<%= viewReportURL %>">
								<a href="javascript:;"><%= reportInstance.getName(locale) %></a>
							</span>

						</liferay-ui:search-container-column-text>

						<liferay-ui:search-container-column-text
							cssClass="content-column description-column"
							name="description"
							truncate="<%= true %>"
							value="<%= HtmlUtil.escape(reportInstance.getDescription(locale)) %>"
						/>

						<liferay-ui:search-container-column-text
							cssClass="text-column type-column"
							name="type"
							value="<%= reportInstance.getTypeName(locale) %>"
						/>

						<liferay-ui:search-container-column-date
							cssClass="modified-date-column text-column"
							name="modified-date"
							value="<%= reportInstance.getModifiedDate() %>"
						/>

						<liferay-ui:search-container-column-jsp
							cssClass="entry-action-column"
							path="/reports_action.jsp"
						/>
					</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="<%= contentTargetingViewReportsDisplayContext.getDisplayStyle() %>" markupView="lexicon" />
		</liferay-ui:search-container>
	</aui:form>
</c:if>

<c:if test="<%= contentTargetingViewReportsDisplayContext.showAddButton() %>">
	<liferay-frontend:add-menu>

		<%
		for (Report report : contentTargetingViewReportsDisplayContext.getReports()) {
			PortletURL addReportURL = contentTargetingViewReportsDisplayContext.getAddReportURL();

			addReportURL.setParameter("reportKey", report.getReportKey());
		%>

			<liferay-frontend:add-menu-item title="<%= report.getName(locale) %>" url="<%= addReportURL.toString() %>" />

		<%
		}
		%>

	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= contentTargetingViewReportsDisplayContext.isIncludeCheckBox() %>">
	<aui:script>
		$('#<portlet:namespace />deleteReports').on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					submitForm(document.<portlet:namespace />fmReports);
				}
			}
		);
	</aui:script>
</c:if>

<c:if test="<%= contentTargetingViewReportsDisplayContext.hasReports() %>">
	<aui:script use="aui-base,liferay-url-preview">
		A.one('#<portlet:namespace />fmReports').delegate(
			'click',
			function(event) {
				var currentTarget = event.currentTarget;

				var parent = currentTarget.ancestor('.preview');

				var urlPreview = new Liferay.UrlPreview(
					{
						title: parent.attr('data-title'),
						url: parent.attr('data-url')
					}
				);

				urlPreview.open();
			},
			'.preview a'
		);
	</aui:script>
</c:if>