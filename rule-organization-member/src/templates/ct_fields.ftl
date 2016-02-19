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

<#if !organizations?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-organizations-available" /></strong>

		<#assign enableLocationLabel = languageUtil.get(locale, "control-panel-users-and-organizations") />

		<#if usersAdminURL??>
			<#assign enableLocationLabel = "<a href=\"" + usersAdminURL + "\">" + enableLocationLabel + "</a>" />
		</#if>

		<@liferay_ui["message"]
			arguments=enableLocationLabel
			key="organizations-can-be-managed-in-x"
		/>
	</div>
<#else>
	<@liferay_aui["select"] label="" name="organizationId">
		<#list organizations as organization>
			<@liferay_aui["option"]
				label="${organization.getName()}"
				selected=(organization.getOrganizationId()
				== organizationId) value=organization.getOrganizationId()
			/>
		</#list>
	</@>
</#if>