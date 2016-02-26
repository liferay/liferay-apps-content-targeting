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

<@portlet["defineObjects"] />

<#setting number_format="computer">

<#if !trackingPageEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-page-tracking-is-not-enabled" /></strong>

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

<@liferay_aui["input"]
	inlineField=true
	checked=!privateLayout
	label="public-pages"
	name="privateLayout"
	onChange="if (this.checked) {${renderResponse.getNamespace()}updateFriendlyURL('${htmlUtil.escape(friendlyURLPublicBase)}');}"
	type="radio"
	value=false
/>

<@liferay_aui["input"]
	inlineField=true
	checked=privateLayout
	label="private-pages"
	name="privateLayout"
	onChange="if (this.checked) {${renderResponse.getNamespace()}updateFriendlyURL('${htmlUtil.escape(friendlyURLPrivateBase)}');}"
	type="radio"
	value=true
/>

<@liferay_aui["input"] helpMessage="enter-the-friendly-url-of-the-page-to-be-tracked" label="friendly-url" name="friendlyURL" prefix=friendlyURLBase style="width: auto;" type="text" value=friendlyURL>
	<@liferay_aui["validator"] name="required" />
</@>

<@liferay_aui["script"]>
	function <@portlet["namespace"] />updateFriendlyURL(value) {
		var A = AUI();

		A.one('#<@portlet["namespace"] />friendlyURL').previous().setHTML(value);
	}
</@>