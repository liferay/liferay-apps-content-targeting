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
String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
String orderByCol = ParamUtil.getString(request, "orderByCol", "modified-date");
String orderByType = ParamUtil.getString(request, "orderByType", "asc");

String backURL = ParamUtil.getString(request, "backURL");
String keywords = ParamUtil.getString(request, "keywords");
String redirect = ParamUtil.getString(request, "redirect");
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

if (Validator.isNull(backURL)) {
	PortletURL backURLObject = liferayPortletResponse.createRenderURL();

	backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);

	if (Campaign.class.getName().equals(className)) {
		backURLObject.setParameter("tabs1", "campaigns");
	}
	else {
		backURLObject.setParameter("tabs1", "user-segments");
	}

	backURL = backURLObject.toString();
}

Group scopeGroup = GroupLocalServiceUtil.fetchGroup(scopeGroupId);

boolean instantiableExists = false;

Collection<Report> reports = (Collection<Report>)request.getAttribute("reports");

for (Report report : reports) {
	if (report.isInstantiable()) {
		instantiableExists = true;

		break;
	}
}

boolean hasUpdatePermission = false;

if (instantiableExists) {
	if (Campaign.class.getName().equals(className) && CampaignPermission.contains(permissionChecker, classPK, ActionKeys.UPDATE)) {
		hasUpdatePermission = true;
	}
	else if (UserSegment.class.getName().equals(className) && UserSegmentPermission.contains(permissionChecker, classPK, ActionKeys.UPDATE)) {
		hasUpdatePermission = true;
	}
}

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("backURL", backURL);
portletURL.setParameter("redirect", redirect);

if (Campaign.class.getName().equals(className)) {
	portletURL.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.VIEW_REPORTS_CAMPAIGN);
	portletURL.setParameter("campaignId", String.valueOf(classPK));
}
else if (UserSegment.class.getName().equals(className)) {
	portletURL.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
	portletURL.setParameter("userSegmentId", String.valueOf(classPK));
}
else {
	portletURL.setParameter("mvcPath", ContentTargetingPath.VIEW_REPORTS);
}

portletURL.setParameter("className", className);
portletURL.setParameter("classPK", String.valueOf(classPK));

if (Validator.isNotNull(keywords)) {
	portletURL.setParameter("keywords", keywords);
}

SearchContainer reportsSearchContainer = new SearchContainer(renderRequest, PortletURLUtil.clone(portletURL, renderResponse), null, "no-reports-were-found");

reportsSearchContainer.setId("reports");
reportsSearchContainer.setRowChecker(new ReportInstanceRowChecker(liferayPortletResponse));
reportsSearchContainer.setSearch(true);

boolean orderByAsc = false;

if (orderByType.equals("asc")) {
	orderByAsc = true;
}

OrderByComparator<ReportInstance> orderByComparator = new ReportInstanceModifiedDateComparator(orderByAsc);

reportsSearchContainer.setOrderByCol(orderByCol);
reportsSearchContainer.setOrderByComparator(orderByComparator);
reportsSearchContainer.setOrderByType(orderByType);

if (Validator.isNotNull(keywords)) {
	Sort sort = new Sort(Field.MODIFIED_DATE, Sort.LONG_TYPE, orderByAsc);

	BaseModelSearchResult<ReportInstance> searchResults = ReportInstanceLocalServiceUtil.searchReportInstances(scopeGroupId, className, classPK, keywords, reportsSearchContainer.getStart(), reportsSearchContainer.getEnd(), sort);

	reportsSearchContainer.setTotal(searchResults.getLength());
	reportsSearchContainer.setResults(searchResults.getBaseModels());
}
else {
	int total = ReportInstanceLocalServiceUtil.getReportInstancesCount(className, classPK);

	reportsSearchContainer.setTotal(total);

	List results = ReportInstanceLocalServiceUtil.getReportInstances(className, classPK, reportsSearchContainer.getStart(), reportsSearchContainer.getEnd(), reportsSearchContainer.getOrderByComparator());

	reportsSearchContainer.setResults(results);
}

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(backURL);

renderResponse.setTitle(LanguageUtil.get(portletConfig.getResourceBundle(locale), "reports"));

boolean isDisabledManagementBar = (reportsSearchContainer.getTotal() <= 0) && Validator.isNull(keywords);
%>

<c:if test="<%= scopeGroup.isStagingGroup() %>">
	<div class="alert alert-warning">
		<liferay-ui:message key="the-staging-environment-is-activated-reports-data-refer-to-the-live-environment" />

		<c:if test="<%= classPK <= 0 %>">
			<strong><liferay-ui:message key="you-must-publish-to-live-before-you-can-view-any-reports" /></strong>
		</c:if>
	</div>
</c:if>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="<%= currentURL %>" label="reports" selected="<%= true %>" />
	</aui:nav>

	<c:if test="<%= !isDisabledManagementBar %>">
		<aui:nav-bar-search>
			<aui:form action="<%= portletURL %>" name="searchFm">
				<liferay-ui:input-search markupView="lexicon" name="keywords" />
			</aui:form>
		</aui:nav-bar-search>
	</c:if>
</aui:nav-bar>

<liferay-frontend:management-bar
	disabled="<%= isDisabledManagementBar %>"
	includeCheckBox="<%= hasUpdatePermission %>"
	searchContainerId="reports"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"list"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
			selectedDisplayStyle="<%= displayStyle %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= orderByCol %>"
			orderByType="<%= orderByType %>"
			orderColumns='<%= new String[] {"modified-date"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test="<%= hasUpdatePermission %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteReports" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<c:if test="<%= classPK > 0 %>">
	<portlet:actionURL name="deleteReportInstance" var="deleteReportsURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:actionURL>

	<aui:form action="<%= deleteReportsURL %>" cssClass="container-fluid-1280" method="post" name="fmReports">
		<liferay-ui:search-container
			searchContainer="<%= reportsSearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.content.targeting.model.ReportInstance"
				keyProperty="reportInstanceId"
				modelVar="reportInstance"
			>

				<portlet:renderURL var="viewReportURL">
					<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_REPORT %>" />
					<portlet:param name="className" value="<%= className %>" />
					<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="reportKey" value="<%= reportInstance.getReportKey() %>" />
					<portlet:param name="reportInstanceId" value="<%= String.valueOf(reportInstance.getReportInstanceId()) %>" />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text
					cssClass="text-strong"
					href="<%= viewReportURL %>"
					name="name"
					value="<%= reportInstance.getName(locale) %>"
				/>

				<liferay-ui:search-container-column-text
					name="description"
					value="<%= reportInstance.getDescription(locale) %>"
				/>

				<liferay-ui:search-container-column-text
					name="type"
					value="<%= reportInstance.getTypeName(locale) %>"
				/>

				<liferay-ui:search-container-column-date
					name="modified-date"
					value="<%= reportInstance.getModifiedDate() %>"
				/>

				<liferay-ui:search-container-column-jsp
					path="/content_targeting/reports_action.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>
	</aui:form>
</c:if>

<c:if test="<%= hasUpdatePermission %>">
	<liferay-frontend:add-menu>

		<%
		for (Report report : reports) {
			if (!report.isInstantiable()) {
				continue;
			}
		%>

			<portlet:renderURL var="addReportURL">
				<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_REPORT %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />

				<c:choose>
					<c:when test="<%= Campaign.class.getName().equals(className) %>">
						<portlet:param name="campaignId" value="<%= String.valueOf(classPK) %>" />
					</c:when>
					<c:otherwise>
						<portlet:param name="userSegmentId" value="<%= String.valueOf(classPK) %>" />
					</c:otherwise>
				</c:choose>

				<portlet:param name="className" value="<%= className %>" />
				<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
				<portlet:param name="reportKey" value="<%= report.getReportKey() %>" />
			</portlet:renderURL>

			<liferay-frontend:add-menu-item title="<%= report.getName(locale) %>" url="<%= addReportURL %>" />

		<%
		}
		%>

	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= hasUpdatePermission %>">
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