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

<#assign instantiableExists = false>

<#list reports as report>
	<#if report.isInstantiable()>
		<#assign instantiableExists = true>
	</#if>
</#list>

<@aui["nav-bar"]>
	<@aui["nav"]>
		<#if className == campaignClass.getName()>
			<#if campaignPermission.contains(permissionChecker, classPK?long, actionKeys.UPDATE) && instantiableExists>
				<@portlet["renderURL"] var="redirectURL">
					<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
					<@portlet["param"] name="backURL" value="${redirect}" />
					<@portlet["param"] name="campaignId" value="${classPK}" />
					<@portlet["param"] name="className" value="${campaignClass.getName()}" />
					<@portlet["param"] name="classPK" value="${classPK}" />
					<@portlet["param"] name="campaignTabs" value="reports" />
				</@>

				<@aui["nav-item"] dropdown=true id="addButtonContainer" label="add" iconCssClass="icon-plus" label="add">
					<#list reports as report>
						<#if report.isInstantiable()>
							<@portlet["renderURL"] var="addReportURL">
								<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_REPORT}" />
								<@portlet["param"] name="redirect" value="${redirectURL}" />
								<@portlet["param"] name="campaignId" value="${classPK}" />
								<@portlet["param"] name="className" value="${campaignClass.getName()}" />
								<@portlet["param"] name="classPK" value="${classPK}" />
								<@portlet["param"] name="reportKey" value="${report.getReportKey()}" />
							</@>

							<@aui["nav-item"] id="add-${report.getReportKey()}" href="${addReportURL}" label="${report.getName(locale)}" iconCssClass="${report.getIcon()}"/>
						</#if>
					</#list>
				</@>

				<@aui["nav-item"] cssClass="hide" iconCssClass="icon-remove" id="deleteReports" label="delete" />
			</#if>
		<#else>
			<#if userSegmentPermission.contains(permissionChecker, classPK?long, actionKeys.UPDATE) && instantiableExists>
				<@portlet["renderURL"] var="redirectURL">
					<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_REPORTS}" />
					<@portlet["param"] name="backURL" value="${redirect}" />
					<@portlet["param"] name="userSegmentId" value="${classPK}" />
					<@portlet["param"] name="className" value="${userSegmentClass.getName()}" />
					<@portlet["param"] name="classPK" value="${classPK}" />
				</@>

				<@aui["nav-item"] dropdown=true id="addButtonContainer" label="add" iconCssClass="icon-plus" label="add">
					<#list reports as report>
						<#if report.isInstantiable()>
							<@portlet["renderURL"] var="addReportURL">
								<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_REPORT}" />
								<@portlet["param"] name="redirect" value="${redirectURL}" />
								<@portlet["param"] name="userSegmentId" value="${classPK}" />
								<@portlet["param"] name="className" value="${userSegmentClass.getName()}" />
								<@portlet["param"] name="classPK" value="${classPK}" />
								<@portlet["param"] name="reportKey" value="${report.getReportKey()}" />
							</@>

							<@aui["nav-item"] id="add-${report.getReportKey()}" href="${addReportURL}" label="${report.getName(locale)}" iconCssClass="${report.getIcon()}"/>
						</#if>
					</#list>
				</@>

				<@aui["nav-item"] cssClass="hide" iconCssClass="icon-remove" id="deleteReports" label="delete" />
			</#if>
		</#if>
	</@>


	<@aui["nav-bar-search"] cssClass="pull-right">
		<div class="form-search">
			<@liferay_ui["input-search"] id="reportkeywords" name="reportKeywords" placeholder='${languageUtil.get(themeDisplay.getLocale(), "keywords")}' />
		</div>
	</@>
</@>