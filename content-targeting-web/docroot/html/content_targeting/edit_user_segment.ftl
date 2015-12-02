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
<#include "../macros_exceptions.ftl" />

<#if validator.isNull(backURL)>
	<@portlet["renderURL"] var="backURL">
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
		<@portlet["param"] name="tabs1" value="user-segments" />
	</@>
</#if>

<@liferay_ui["header"]
	backURL="${backURL}"
	title='${(userSegment.getName(locale))!"new-user-segment"}'
/>

<#if (userSegmentId > 0)>
	<#assign userSegmentTabs="details,reports">
<#else>
	<#assign userSegmentTabs="details">
</#if>

<@portlet["renderURL"] var="portletURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_USER_SEGMENT}" />
	<@portlet["param"] name="userSegmentId" value="${userSegmentId}" />
</@>

<@liferay_ui["tabs"]
	names="${userSegmentTabs}"
	param="tabs2"
	type="pills"
	url=portletURL
	value="${tabs2}"
>
	<@liferay_ui["section"]>
		<#include "user_segment_details.ftl" />
	</@>

	<#if (userSegmentId > 0)>
		<@liferay_ui["section"]>
			<#include "view_reports.ftl" />
		</@>
	</#if>
</@>