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
		<strong><@liferay_ui["message"] key="this-metric-will-not-work-properly-because-content-tracking-is-not-enabled" /></strong>

		<#assign enableLocationPortalLabel = languageUtil.get(resourceBundle, "portal-settings-content-targeting-analytics") />

		<#if portalSettingsURL??>
			<#assign enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>" />
		</#if>

		<#assign enableLocationSiteLabel = languageUtil.get(resourceBundle, "site-settings-content-targeting-analytics") />

		<#if siteSettingsURL??>
			<#assign enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>" />
		</#if>

		<#assign enableLocationLabels = [enableLocationPortalLabel, enableLocationSiteLabel] />

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

<div class="rules-panel" style="background-color:transparent; margin:0px;">
	<div class="control-group select-asset-selector">
		<div class="edit-controls lfr-meta-actions">
			<@liferay_aui["input"]
				name="{ct_field_guid}assetEntryId"
				type="hidden"
				value=assetEntryId
			/>

			<label class="control-label"><@liferay_ui["message"] key="select-the-content-to-be-tracked" /></label>

			<@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" id="{ct_field_guid}assetSelector" message=languageUtil.get(locale, "select-content") showWhenSingleIcon=true>
				<#list assetRendererFactories as assetRendererFactory>
					<@liferay_ui["icon"]
						cssClass="asset-selector"
						data=contentTargetingUtilClass.getAssetSelectorIconData(request, assetRendererFactory, '', true)
						id="{ct_field_guid}groupId_${assetRendererFactory.getTypeName(locale, false)}"
						message=assetRendererFactory.getTypeName(locale, false)
						src=assetRendererFactory.getIconPath(renderRequest)
						url="javascript:;"
					/>
				</#list>
			</@>
		</div>

		<#assign cssClass = "">

		<#if (assetEntryId <= 0)>
			<#assign cssClass = "hide">
		</#if>

		<div class="asset-preview ${cssClass}" id="<@portlet["namespace"] />{ct_field_guid}selectedContentPreview">
			<@liferay_aui["col"]>
				<img class="asset-image" src="${assetImagePreview}" />
			</@>
			<@liferay_aui["col"]>
				<div class="asset-title" id="<@portlet["namespace"] />{ct_field_guid}assetTitlePreview">${assetTitlePreview}</div>
				<div class="asset-type" id="<@portlet["namespace"] />{ct_field_guid}assetTypePreview"><@liferay_ui["message"] key="type" />: ${assetTypePreview}</div>
			</@>
		</div>
	</div>
</div>

<#if eventTypes?has_content && (eventTypes?size > 1)>
	<@liferay_aui["select"] label="event-type" name="{ct_field_guid}eventType">
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
			label="event-type"
			name="{ct_field_guid}eventType"
			type="text"
			value=curEventType
		/>
	</#list>
</#if>


<@liferay_aui["script"] use="aui-base">
	var onAssetSelectorClick = function(event) {
		event.preventDefault();

		var currentTarget = event.currentTarget;

		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true
				},
				eventName: '{ct_field_guid}selectContent',
				id: 'selectContent' + currentTarget.attr('id'),
				title: currentTarget.attr('data-title'),
				uri: currentTarget.attr('data-href')
			},
			function(event) {
				A.one('#<@portlet["namespace"] />{ct_field_guid}assetEntryId').attr('value', event.assetentryid);

				A.one('#<@portlet["namespace"] />{ct_field_guid}assetTitlePreview').html(event.assettitle);
				A.one('#<@portlet["namespace"] />{ct_field_guid}assetTypePreview').html(event.assettype);

				A.one('#<@portlet["namespace"] />{ct_field_guid}selectedContentPreview').show();
			}
		);
	};

	A.getBody().delegate(
		'click',
		function(event) {
			onAssetSelectorClick(event);
		},
		'.asset-selector a'
	);
</@>