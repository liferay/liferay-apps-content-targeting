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

<#assign instantiableExists = false>

<#assign reports=consumerReportsRegistry.getReportsByCategoryKey(reportCategoryKey)?values>

<#list reports as report>
	<#if report.isInstantiable()>
		<#assign instantiableExists = true>
	</#if>
</#list>

<@aui["nav-bar"]>
	<@aui["nav"]>
		<#if consumerPermission.contains(permissionChecker, consumerId, actionKeys.UPDATE) && instantiableExists>
			<@portlet["renderURL"] var="redirectURL">
				<@portlet["param"] name="mvcPath" value="${consumerManagerPath.EDIT_CONSUMER}" />
				<@portlet["param"] name="consumerId" value="${consumerId}" />
				<@portlet["param"] name="tabs2" value="reports" />
			</@>

			<@aui["nav-item"] dropdown=true iconCssClass="icon-plus" id="addButtonContainer" label='${languageUtil.get(portletConfig, locale, "add")}'>
				<#list reports as report>
					<#if report.isInstantiable()>
						<@portlet["renderURL"] var="addReportURL">
							<@portlet["param"] name="mvcPath" value="${consumerManagerPath.EDIT_REPORT}" />
							<@portlet["param"] name="redirect" value="${redirectURL}" />
							<@portlet["param"] name="consumerId" value="${consumerId}" />
							<@portlet["param"] name="reportKey" value="${report.getReportKey()}" />
						</@>

						<@aui["nav-item"] href="${addReportURL}" iconCssClass="${report.getIcon()}" id="add-${report.getReportKey()}" label="${report.getName(locale)}" />
					</#if>
				</#list>
			</@>

			<@aui["nav-item"] cssClass="hide" iconCssClass="icon-remove" id="deleteReports" label='${languageUtil.get(portletConfig, locale, "delete")}' />
		</#if>
	</@>


	<@aui["nav-bar-search"] cssClass="pull-right">
		<div class="form-search">
			<@liferay_ui["input-search"] id="_${reportCategoryKey}_reportKeywords" name="_${reportCategoryKey}_reportKeywords" placeholder='${languageUtil.get(portletConfig, locale, "keywords")}' />
		</div>
	</@>
</@>