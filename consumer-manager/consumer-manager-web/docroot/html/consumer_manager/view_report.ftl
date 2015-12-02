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
<#include "../macros.ftl" />

<#if validator.isNull(backURL)>
	<@portlet["renderURL"] var="backURL">
		<@portlet["param"] name="tabs2" value="${reportCategoryKey}" />
		<@portlet["param"] name="mvcPath" value="${consumerManagerPath.EDIT_CONSUMER}" />
		<@portlet["param"] name="consumerId" value="${consumerId}" />
	</@>
</#if>

<@liferay_ui["header"]
	backURL="${backURL}"
	title=consumerReport.getName(locale)
/>

<#if scopeGroup.isStagingGroup()>
	<div class="alert alert-warning">
		<@liferay_ui["message"] key="the-staging-environment-is-activated-reports-data-refer-to-the-live-environment" />
	</div>
</#if>

<@portlet["actionURL"] name="updateReport" var="updateReportURL">
	<@portlet["param"] name="backURL" value="${backURL}" />
	<@portlet["param"] name="redirect" value="${currentURL}" />
	<@portlet["param"] name="consumerReportInstanceId" value="${consumerReportInstanceId?string}" />
	<@portlet["param"] name="reportKey" value="${consumerReport.getReportKey()}" />
	<@portlet["param"] name="consumerId" value="${consumerId?string}" />
</@>

<@liferay_ui["icon"]
	cssClass="pull-right"
	image="../aui/repeat"
	label=false
	linkCssClass="btn"
	message="update-report"
	url=updateReportURL
/>

<div class="report-description">
	${consumerReport.getDescription(locale)}
</div>

${reportHtml}