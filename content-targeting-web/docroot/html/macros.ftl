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

<#macro getConfigurationIconLink
	mvcPath
>
	<@portlet["renderURL"] var="configurationURL" windowState=liferayWindowStatePopUp.toString()>
		<@portlet["param"] name="mvcPath" value="${mvcPath}" />
		<@portlet["param"] name="redirect" value="${currentURL}" />
	</@>

	<@liferay_ui["icon"]
		cssClass="lfr-icon-action lfr-icon-action-configuration"
		image="configuration"
		label=true
		message="configuration"
		useDialog=true
		url="${configurationURL}"
	/>
</#macro>

<#macro getEditIconLink
	assetEntry
	cssClass
	index
>
	<#assign assetRenderer = assetEntry.getAssetRenderer() />

	<#if assetRenderer.hasEditPermission(permissionChecker)>
		<#assign redirectURL = renderResponse.createRenderURL() />

		<#assign editPortletURL = assetRenderer.getURLEdit(renderRequest, renderResponse, windowStateFactory.getWindowState("pop_up"), redirectURL)!"" />

		<#if validator.isNotNull(editPortletURL)>
			<#assign entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale)) />
			<#assign title = languageUtil.format(locale, "edit-x", entryTitle) />

			<span class="${cssClass}" id="<@portlet["namespace"] />editLink${index}">
				<@liferay_ui["icon"]
					cssClass="lfr-icon-action lfr-icon-action-edit"
					image="edit"
					label=true
					message=title
					url="javascript:Liferay.Util.openWindow({dialog: {width: 960}, id:'" + renderResponse.getNamespace() + "editAsset', title: '" + title + "', uri:'" + htmlUtil.escapeURL(editPortletURL.toString()) + "'});"
				/>
			</span>
		</#if>
	</#if>
</#macro>