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

<#if validator.isNull(redirect)>
	<@portlet["renderURL"] var="redirect">
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
	</@>
</#if>

<#if scopeGroup.isStagingGroup()>
	<div class="alert alert-warning">
		<@liferay_ui["message"] key="the-staging-environment-is-activated-reports-data-refer-to-the-live-environment" />

		<#if classPK <= 0>
			<strong><@liferay_ui["message"] key="you-must-publish-to-live-before-you-can-view-any-reports" /></strong>
		</#if>
	</div>
</#if>

<@portlet["renderURL"] varImpl="viewReportsURL">
	<@portlet["param"] name="redirect" value="${redirect}" />
	<@portlet["param"] name="backURL" value="${backURL}" />

	<#if className == campaignClass.getName()>
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
		<@portlet["param"] name="campaignId" value="${classPK?string}" />
		<@portlet["param"] name="tabs2" value="reports" />
	<#elseif className == userSegmentClass.getName()>
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_USER_SEGMENT}" />
		<@portlet["param"] name="userSegmentId" value="${classPK?string}" />
		<@portlet["param"] name="tabs2" value="reports" />
	<#else>
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_REPORTS}" />
	</#if>

	<@portlet["param"] name="className" value="${className}" />
	<@portlet["param"] name="classPK" value="${classPK?string}" />
</@>

<@aui["form"] action="${viewReportsURL}" method="post" name="fmReports">
	<@aui["input"] name="redirect" type="hidden" value="${viewReportsURL}" />
	<@aui["input"] name="reportInstanceIds" type="hidden" />

	<div id="<@portlet["namespace"] />reportsPanel">
		<#include "report_toolbar.ftl" />

		<#include "view_reports_resources.ftl" />
	</div>
</@>

<@aui["script"] use="liferay-ajax-search">
	var reportsPanel = A.one('#<@portlet["namespace"] />reportsPanel');
	var inputNode = A.one('#<@portlet["namespace"] />reportkeywords');

	var search = new Liferay.AjaxContentSearch(
		{
			contentPanel: reportsPanel,
			inputNode: inputNode,
			resourceURL: '<@portlet["resourceURL"]><@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_REPORTS_RESOURCES}" />${classPK?string}" /></@>',
			namespace: '<@portlet["namespace"] />'
		}
	);
</@>