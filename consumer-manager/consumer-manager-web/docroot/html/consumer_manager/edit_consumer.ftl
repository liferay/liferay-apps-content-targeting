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
<#include "../macros.ftl" />
<#include "../macros_exceptions.ftl" />

<#if validator.isNull(redirect)>
	<@portlet["renderURL"] var="redirect">
		<@portlet["param"] name="mvcPath" value="${consumerManagerPath.VIEW_CONSUMERS}" />
	</@>
</#if>

<@liferay_ui["header"]
	backURL="${redirect}"
	title='${(consumer.getName(locale))!"new-consumer"}'
/>

<#assign consumerManagerTabs="details">

<#if (consumerId > 0)>
	<#list consumerReportCategories as consumerReportCategoryKey>
		<#assign consumerManagerTabs=consumerManagerTabs + "," + consumerReportCategoryKey>
	</#list>
</#if>

<@portlet["renderURL"] var="portletURL">
	<@portlet["param"] name="mvcPath" value="${consumerManagerPath.EDIT_CONSUMER}" />
	<@portlet["param"] name="consumerId" value="${consumerId}" />
</@>

<@liferay_ui["tabs"]
	names="${consumerManagerTabs}"
	param="tabs2"
	type="pills"
	url=portletURL
	value="${tabs2}"
>
	<@liferay_ui["section"]>
		<#include "consumer_details.ftl" />
	</@>

	<#list consumerReportCategories as consumerReportCategoryKey>
		<@liferay_ui["section"]>
			<#assign reportCategoryKey=consumerReportCategoryKey>

			<#include "view_reports.ftl" />
		</@>
	</#list>
</@>

<@fieldHeaderListener fieldName="alias" />