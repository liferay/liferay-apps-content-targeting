<#--
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
-->

<#include "../init.ftl" />

<#include "report_toolbar.ftl" />

<@portlet["renderURL"] varImpl="viewReportsURL">
	<@portlet["param"] name="redirect" value="${redirect}" />
	<@portlet["param"] name="mvcPath" value="${consumerManagerPath.EDIT_CONSUMER}" />
	<@portlet["param"] name="consumerId" value="${consumerId?string}" />
	<@portlet["param"] name="tabs2" value="${reportCategoryKey}" />
</@>

<#if (consumerId > 0)>
	<@liferay_ui["search-container"]
		emptyResultsMessage="no-reports-were-found"
		iteratorURL=viewReportsURL
		rowChecker=reportsRowChecker
		total=reportSearchContainerIterator.getTotal(reportCategoryKey)
	>
		<@liferay_ui["search-container-results"]
			results=reportSearchContainerIterator.getResults(reportCategoryKey, searchContainer.getStart(), searchContainer.getEnd())
		/>

		<@liferay_ui["search-container-row"]
			className="com.liferay.consumer.manager.model.ConsumerReportInstance"
			keyProperty="consumerReportInstanceId"
			modelVar="consumerReportInstance"
		>

			<@portlet["renderURL"] varImpl="viewReportURL">
				<@portlet["param"] name="mvcPath" value="${consumerManagerPath.VIEW_REPORT}" />
				<@portlet["param"] name="consumerId" value="${consumerId?string}" />
				<@portlet["param"] name="redirect" value="${viewReportsURL}" />
				<@portlet["param"] name="reportKey" value="${consumerReportInstance.getReportKey()}" />
				<@portlet["param"] name="consumerReportInstanceId" value="${consumerReportInstance.getConsumerReportInstanceId()?string}" />
			</@>

			<@liferay_ui["search-container-column-text"]
				href=viewReportURL
				name="name"
				value=consumerReportInstance.getName(locale)
			/>

			<@liferay_ui["search-container-column-text"]
				href=viewReportURL
				name="description"
				value=consumerReportInstance.getDescription(locale)
			/>

			<@liferay_ui["search-container-column-date"]
				name="last-update"
				value=consumerReportInstance.getModifiedDate()
			/>

			<@liferay_ui["search-container-column-text"]
				align="right"
				name=""
			>
				<@liferay_ui["icon-menu"]>
					<#if consumerReportInstance.isInstantiable()>
						<@portlet["renderURL"] var="editReportURL">
							<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_REPORT}" />
							<@portlet["param"] name="consumerId" value="${consumerId?string}" />
							<@portlet["param"] name="redirect" value="${viewReportsURL}" />
							<@portlet["param"] name="consumerReportInstanceId" value="${consumerReportInstance.getConsumerReportInstanceId()?string}" />
							<@portlet["param"] name="reportKey" value="${consumerReportInstance.getReportKey()}" />
						</@>

						<#if editReportURL??>
							<@liferay_ui["icon"]
								image="edit"
								method="get"
								url="${editReportURL}"
							/>
						</#if>

						<@portlet["actionURL"] name="deleteReportInstance" var="deleteReportURL">
							<@portlet["param"] name="redirect" value="${viewReportsURL}" />
							<@portlet["param"] name="consumerReportInstance" value="${consumerReportInstance.getReportInstanceId()?string}" />
						</@>

						<@liferay_ui["icon-delete"]
							url="${deleteReportURL}"
						/>
					</#if>

					<@liferay_ui["icon"]
						image="view"
						label=true
						message="view-report"
						method="get"
						url="${viewReportURL}"
					/>

					<@portlet["actionURL"] name="updateReport" var="updateReportURL">
						<@portlet["param"] name="redirect" value="${viewReportsURL}" />
						<@portlet["param"] name="consumerReportInstanceId" value="${consumerReportInstance.getConsumerReportInstanceId()?string}" />
						<@portlet["param"] name="reportKey" value="${consumerReportInstance.getReportKey()}" />
						<@portlet["param"] name="consumerId" value="${consumerId?string}" />
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
</#if>

<@aui["script"] use="liferay-util-list-fields">
	var deleteReports = A.one('#<@portlet["namespace"] />deleteReports');

	if (deleteReports) {
		A.one('#<@portlet["namespace"] />${searchContainerReference.getId()}SearchContainer').on(
			'click',
			function() {
				var hide = (Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmReports, '<@portlet["namespace"] />allRowIds').length == 0);

				deleteReports.toggle(!hide);
			},
			'input[type=checkbox]'
		);

		deleteReports.on(
			'click',
			function(event) {
				if (confirm('<@liferay_ui["message"] key="are-you-sure-you-want-to-delete-this" />')) {
					document.<@portlet["namespace"] />fmReports.<@portlet["namespace"] />consumerReportInstanceIds.value = Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmReports, '<@portlet["namespace"] />allRowIds');

					<@portlet["actionURL"] name="deleteReportInstance" var="deleteReportsURL">
						<@portlet["param"] name="redirect" value="${viewReportsURL}" />
					</@>

					submitForm(document.<@portlet["namespace"] />fmReports, '${deleteReportsURL}');
				}
			}
		);
	}
</@>