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
	title='${(campaign.getName(locale))!"new-campaign"}'
/>

<@portlet["actionURL"] name="updateCampaign" var="addCampaignURL" />

<@aui["form"] action="${addCampaignURL}" method="post" name="fm">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="campaignId" type="hidden" value=campaignId />

	<@aui["model-context"] bean=campaign model=campaignClass />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	<@aui["select"] label="user-segment" name="userSegmentId">
		<@aui["option"] label="" selected=(userSegmentId == -1) value="-1" />

		<#list userSegments as userSegment>
			<@aui["option"] label="${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" selected=(userSegmentId == userSegment.getUserSegmentId()) value="${userSegment.getUserSegmentId()}" />
		</#list>
	</@>

	<@aui["input"] name="startDate" />

	<@aui["input"] name="endDate" />

	<@aui["select"] name="priority">
		<#assign maxPriority=5>

		<#list 1..maxPriority as i>
			<#assign label="${i}" />

			<#if i == 1>
				<#assign label='${label} (${languageUtil.get(locale, "maximum")})' />
			<#elseif i == maxPriority>
				<#assign label='${label} (${languageUtil.get(locale, "minimum")})' />
			</#if>

			<@aui["option"] label="${label}" selected=(priority == i) value="${i}"/>
		</#list>
	</@>

	<@aui["button-row"]>
		<@aui["button"] type="submit" />
	</@>
</@>