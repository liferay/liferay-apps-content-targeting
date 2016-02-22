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

<#if !sites?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-sites-available" /></strong>

		<#assign enableLocationLabel = languageUtil.get(locale, "control-panel-sites") />

		<#if sitesAdminURL??>
			<#assign enableLocationLabel = "<a href=\"" + sitesAdminURL + "\">" + enableLocationLabel + "</a>" />
		</#if>

		<@liferay_ui["message"]
			arguments=enableLocationLabel
			key="sites-can-be-managed-in-x"
		/>
	</div>
<#else>
	<@liferay_aui["select"] label="" name="siteId">
		<#list sites as site>
			<@liferay_aui["option"]
				label="${site.getDescriptiveName(locale)}"
				selected=(site.getGroupId()
				== siteId) value=site.getGroupId()
			/>
		</#list>
	</@>
</#if>