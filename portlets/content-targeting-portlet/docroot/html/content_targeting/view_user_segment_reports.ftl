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

<@liferay_ui["header"]
	backURL="${redirect}"
	title='${(userSegment.getName(locale))}'
/>

<#if validator.isNotNull(userSegmentReportsTabNames)>
	<@liferay_ui["tabs"]
		names="${userSegmentReportsTabNames}"
		refresh=false
		type="pills"
		value="${tabs2}"
	>
		<#list userSegmentReportsTemplates as template>
			<@liferay_ui["section"]>
				<@portlet["actionURL"] name="updateReport" var="updateReportURL">
					<@portlet["param"] name="redirect" value="${currentURL}" />
					<@portlet["param"] name="reportKey" value="${template.getReportKey()}" />
				</@>

				<@aui["button-row"]>
					<@aui["button"] href="${updateReportURL}" value="update-report"/>
				</@>

				${template.getTemplate()}
			</@>
		</#list>
	</@>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="no-reports-were-found" />
	</div>
</#if>