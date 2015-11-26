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

<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<#if !trackingLinkEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-metric-will-not-work-properly-because-link-tracking-is-not-enabled" /></strong>

		<#assign enableLocationPortalLabel = languageUtil.get(locale, "portal-settings-content-targeting-analytics") />

		<#if portalSettingsURL??>
			<#assign enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>" />
		</#if>

		<#assign enableLocationSiteLabel = languageUtil.get(locale, "site-settings-content-targeting-analytics") />

		<#if siteSettingsURL??>
			<#assign enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>" />
		</#if>

		<#assign enableLocationLabels = [enableLocationPortalLabel, enableLocationSiteLabel] />

		${languageUtil.format(locale, "it-can-be-enabled-in-x-or-in-x", enableLocationLabels)}
	</div>
</#if>

<@aui["input"] helpMessage="name-help" label="name" name="{ct_field_guid}alias" type="text" value=alias>
	<@aui["validator"] name="required" />
</@>

<@aui["input"] helpMessage="enter-the-id-of-the-link-to-be-tracked" label="link-id" name="{ct_field_guid}elementId" type="text" value=elementId>
	<@aui["validator"] name="required" />
</@>

<#if eventTypes?has_content && (eventTypes?size > 1)>
	<@aui["select"] label="event-type" name="{ct_field_guid}eventType">
		<#list eventTypes as curEventType>
			<@aui["option"] label="${curEventType}" selected=(eventType == curEventType) value=curEventType />
		</#list>
	</@>
<#else>
	<#list eventTypes as curEventType>
		<@aui["input"] disabled=true label="event-type" name="{ct_field_guid}eventType" type="text" value=curEventType />
	</#list>
</#if>