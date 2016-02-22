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

<#if !userGroups?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-user-groups-available" /></strong>

		<#assign enableLocationLabel = languageUtil.get(locale, "control-panel-user-groups") />

		<#if userGroupsAdminURL??>
			<#assign enableLocationLabel = "<a href=\"" + userGroupsAdminURL + "\">" + enableLocationLabel + "</a>" />
		</#if>

		<@liferay_ui["message"]
			arguments=enableLocationLabel
			key="user-groups-can-be-managed-in-x"
		/>
	</div>
<#else>
	<@liferay_aui["select"] label="" name="userGroupId">
		<#list userGroups as userGroup>
			<@liferay_aui["option"]
				label="${userGroup.getName()}"
				selected=(userGroup.getUserGroupId()
				== userGroupId) value=userGroup.getUserGroupId()
			/>
		</#list>
	</@>
</#if>