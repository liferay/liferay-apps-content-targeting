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

<#setting number_format="computer">

<#if !trackingContentEnabled || !trackingPageEnabled>
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-content-tracking-or-page-tracking-are-not-enabled" /></strong>

		<#assign enableLocationPortalLabel = languageUtil.get(resourceBundle, "portal-settings-content-targeting-analytics") />

		<#if portalSettingsURL??>
			<#assign enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>" />
		</#if>

		<#assign enableLocationSiteLabel = languageUtil.get(resourceBundle, "site-settings-content-targeting-analytics") />

		<#if siteSettingsURL??>
			<#assign enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>" />
		</#if>

		<@liferay_ui["message"]
			arguments=stringUtil.split(enableLocationPortalLabel + "," + enableLocationSiteLabel)
			key="it-can-be-enabled-in-x-or-in-x"
			translateArguments=false
		/>
	</div>
</#if>

<div class="alert alert-info">
	<#if userSegment??>
		<@liferay_ui["message"]
			arguments=userSegment.getName(locale)
			key="users-will-receive-1-point-for-this-user-segment-every-time-they-visit-a-page-or-content-categorized-under-x"
		/>
	<#else>
		<@liferay_ui["message"] key="users-will-receive-1-point-for-this-user-segment-every-time-they-visit-a-page-or-content-categorized-under-this-user-segment" />
	</#if>
</div>

<@liferay_aui["input"] helpMessage="set-a-threshold-of-points-that-users-should-meet-in-order-to-be-assigned-to-this-user-segment" label="score-points-threshold" name="scorePoints" type="text" value=scorePoints>
	<@liferay_aui["validator"] name="number" />
</@>