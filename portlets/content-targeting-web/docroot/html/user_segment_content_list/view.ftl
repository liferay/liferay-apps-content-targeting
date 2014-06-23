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

<#if portletDisplay.isShowConfigurationIcon()>
	<@portlet["renderURL"] var="configurationURL" windowState=liferayWindowStatePopUp.toString()>
		<@portlet["param"] name="mvcPath" value="${userSegmentContentListPath.CONFIGURATION}" />
		<@portlet["param"] name="redirect" value="${currentURL}" />
	</@>

	<@liferay_ui["icon"]
		cssClass="lfr-meta-actions pull-right"
		image="../aui/wrench"
		label=true
		message="configuration"
		useDialog=true
		url="${configurationURL}"
	/>
</#if>

<#if assetEntries?has_content>
	<#list assetEntries as assetEntry>
		<div class="asset-entry">
			<#assign assetRendererFactory = assetRendererFactoryRegistryUtilClass.getAssetRendererFactoryByClassName(assetEntry.getClassName())>

			${request.setAttribute("view.jsp-assetEntry", assetEntry)}
			${request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory)}
			${request.setAttribute("view.jsp-assetRenderer", assetRendererFactory.getAssetRenderer(assetEntry.getClassPK()))}
			${request.setAttribute("view.jsp-title", assetEntry.getTitle(themeDisplay.getLocale()))}

			<@liferay_util["include"] page="/html/portlet/asset_publisher/display/abstracts.jsp" />
		</div>
	</#list>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="there-are-no-matching-rules" />
	</div>
</#if>