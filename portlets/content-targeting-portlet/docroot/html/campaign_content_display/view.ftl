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
		<@portlet["param"] name="mvcPath" value="${campaignContentDisplayPath.CONFIGURATION}" />
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

<#if isMatchingRule>
	<div>
		<@liferay_util["include"] page="/html/portlet/asset_publisher/display/full_content.jsp">
			<@liferay_util["param"] name="showExtraInfo" value="false" />
		</@>
	</div>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="there-are-no-matching-rules" />
	</div>
</#if>