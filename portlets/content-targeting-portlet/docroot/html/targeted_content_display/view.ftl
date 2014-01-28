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

<@portlet["renderURL"] var="configurationURL">
	<@portlet["param"] name="mvcPath" value="${targetedContentDisplayPath.CONFIGURATION}" />
	<@portlet["param"] name="redirect" value="${currentURL}" />
</@>

<@aui["a"] href="${configurationURL}">${languageUtil.get(locale, "configuration")}</@>

<#if isMatchingRule>
	<div>
		<@liferay_util["include"] page="/html/portlet/asset_publisher/display/full_content.jsp" />
	</div>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="no-matching-rules" />
	</div>
</#if>