<#--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
-->

<#include "../init.ftl" />

<#if validator.isNull(redirect)>
	<@portlet["renderURL"] var="redirect">
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
	</@>
</#if>

<@liferay_ui["header"]
	backURL="${redirect}"
	title="${title}"
/>

<@portlet["renderURL"] varImpl="viewReportsURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_REPORTS}" />
	<@portlet["param"] name="redirect" value="${redirect}" />
	<@portlet["param"] name="className" value="${className}" />
	<@portlet["param"] name="classPK" value="${classPK?string}" />
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-reports-were-found"
	iteratorURL=viewReportsURL
	rowChecker=rowChecker
	total=reportSearchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=reportSearchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.content.targeting.model.api.Report"
		keyProperty="reportKey"
		modelVar="report"
	>

		<@portlet["renderURL"] varImpl="viewReportURL">
			<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_REPORT}" />
			<@portlet["param"] name="backURL" value="${currentURL}" />
			<@portlet["param"] name="className" value="${className}" />
			<@portlet["param"] name="classPK" value="${classPK}" />
			<@portlet["param"] name="reportKey" value="${report.getReportKey()}" />
		</@>

		<@liferay_ui["search-container-column-text"]
			href=viewReportURL
			name="name"
			value=report.getName(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			href=viewReportURL
			name="description"
			value=report.getDescription(locale)
		/>

		<@liferay_ui["search-container-column-date"]
			href=viewReportURL
			name="last-update"
			value=reportInstanceService.getModifiedDate(report.getReportKey(), className, classPK)
		/>

		<@liferay_ui["search-container-column-text"]
			align="right"
			name=""
		>
			<@liferay_ui["icon-menu"]>
				<@liferay_ui["icon"]
					image="view"
					label=true
					message="view-report"
					method="get"
					url="${viewReportURL}"
				/>

				<@portlet["actionURL"] name="updateReport" var="updateReportURL">
					<@portlet["param"] name="redirect" value="${currentURL}" />
					<@portlet["param"] name="reportKey" value="${report.getReportKey()}" />
					<@portlet["param"] name="classPK" value="${classPK?string}" />
				</@>

				<@liferay_ui["icon"]
					image="undo"
					label=true
					message="update-report"
					method="post"
					url="${updateReportURL}"
				/>
			</@>
		</@>
	</@>

	<@liferay_ui["search-iterator"] />
</@>