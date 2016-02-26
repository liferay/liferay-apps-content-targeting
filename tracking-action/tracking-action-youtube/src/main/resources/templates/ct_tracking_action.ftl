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

<#if !trackingYoutubeEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-metric-will-not-work-properly-because-youtube-videos-tracking-is-not-enabled" /></strong>

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

<@liferay_aui["input"] helpMessage="name-help" label="name" name="{ct_field_guid}alias" type="text" value=alias>
	<@liferay_aui["validator"] name="required" />
</@>

<@liferay_aui["input"] helpMessage="enter-the-id-of-the-youtube-video-to-be-tracked" label="youtube-video-id" name="{ct_field_guid}elementId" type="text" value=elementId>
	<@liferay_aui["validator"] name="required" />
</@>

<#if eventTypes?has_content && (eventTypes?size > 1)>
	<@liferay_aui["select"] helpMessage="youtube-event-type-help" label="event-type" name="{ct_field_guid}eventType">
		<@liferay_aui["option"]
			label="all"
			selected=(eventType
			== "all") value="all"
		/>

		<#list eventTypes as curEventType>
			<@liferay_aui["option"]
				label="${curEventType}"
				selected=(eventType
				== curEventType) value=curEventType
			/>
		</#list>
	</@>
<#else>
	<#list eventTypes as curEventType>
		<@liferay_aui["input"]
			disabled=true
			helpMessage="youtube-event-type-help"
			label="event-type"
			name="{ct_field_guid}eventType"
			type="text"
			value=curEventType
		/>
	</#list>
</#if>