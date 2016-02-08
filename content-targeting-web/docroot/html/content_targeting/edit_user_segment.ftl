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
	<@portlet["renderURL"] copyCurrentRenderParameters=false var="backURL">
		<@portlet["param"]
			name="mvcPath"
			value="${contentTargetingPath.VIEW}"
		/>
		<@portlet["param"]
			name="tabs1"
			value="user-segments"
		/>
	</@>
</#if>

<@liferay_ui["header"]
	backURL="${backURL}"
	title='${(userSegment.getName(locale))!"new-user-segment"}'
/>

<#assign classPK = userSegmentId>
<#assign className = userSegmentClass.getName()>

<#if (userSegmentId > 0)>
	<#assign pills ="details,reports">
<#else>
	<#assign pills ="details">
</#if>

<@portlet["renderURL"] copyCurrentRenderParameters=false varImpl="switchTabsURL">
	<@portlet["param"]
		name="mvcPath"
		value="${contentTargetingPath.EDIT_USER_SEGMENT}"
	/>
	<@portlet["param"]
		name="userSegmentId"
		value="${userSegmentId}"
	/>
</@>

<@liferay_ui["tabs"]
	names="${pills}"
	param="userSegmentTabs"
	portletURL=switchTabsURL
	refresh=true
	type="pills"
	value="${userSegmentTabs}"
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