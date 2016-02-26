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

<#if !trackingContentEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-content-tracking-is-not-enabled" /></strong>

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

<div class="select-asset-selector">
	<#assign cssClass = "">

	<#if (assetEntryId <= 0)>
		<#assign cssClass = "hide">
	</#if>

	<@liferay_aui["input"]
		name="assetEntryId"
		type="hidden"
		value=assetEntryId
	/>

	<div class="asset-preview ${cssClass}" id="<@portlet["namespace"] />assetPreview">
		<@liferay_aui["col"]>
			<img class="asset-image" id="<@portlet["namespace"] />assetImage" src="${assetImage}" />
		</@>
		<@liferay_aui["col"]>
			<div class="asset-title" id="<@portlet["namespace"] />assetTitleInfo">${assetTitle}</div>
			<div class="asset-type" id="<@portlet["namespace"] />assetTypeInfo"><@liferay_ui["message"] key="type" />: ${assetType}</div>
		</@>
	</div>

	<div class="edit-controls lfr-meta-actions">
		<@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" message=languageUtil.get(locale, "select-content") showWhenSingleIcon=true>
			<#list assetRendererFactories as assetRendererFactory>
				<@liferay_ui["icon"]
					cssClass="asset-selector"
					data=contentTargetingUtilClass.getAssetSelectorIconData(request, assetRendererFactory, '')
					id="groupId_${assetRendererFactory.getTypeName(locale, false)}"
					message=assetRendererFactory.getTypeName(locale, false)
					src=assetRendererFactory.getIconPath(renderRequest)
					url="javascript:;"
				/>
			</#list>
		</@>
	</div>
</div>

<@liferay_aui["script"] use="aui-base">
	A.getBody().delegate(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = event.currentTarget;

			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					eventName: 'selectContent',
					id: 'selectContent' + currentTarget.attr('id'),
					title: currentTarget.attr('data-title'),
					uri: currentTarget.attr('data-href')
				},
				function(event) {
					A.one('#<@portlet["namespace"] />assetEntryId').attr('value', event.assetentryid);
					A.one('#<@portlet["namespace"] />assetImage').attr('src', '');

					A.one('#<@portlet["namespace"] />assetTitleInfo').html(event.assettitle);
					A.one('#<@portlet["namespace"] />assetTypeInfo').html('<@liferay_ui["message"] key="type" />: ' + event.assettype);

					A.one('#<@portlet["namespace"] />assetPreview').show();
				}
			);
		},
		'.asset-selector a'
	);
</@>

<style>
	.asset-preview {
		overflow: hidden;
	}

	.asset-title {
		font-weight: 400;
		margin-top: 6px;
	}

	.asset-type {
		color: #8D8D8D;
		font-weight: 400;
	}
</style>