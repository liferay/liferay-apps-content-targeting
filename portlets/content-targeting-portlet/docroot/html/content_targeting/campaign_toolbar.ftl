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

<@aui["nav"]>
	<#if contentTargetingPermission.contains(permissionChecker, scopeGroupId, actionKeys.ADD_CAMPAIGN)>
		<@portlet["renderURL"] var="addCampaignURL">
			<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
			<@portlet["param"] name="redirect" value="${viewCampaignsURL}" />
		</@>

		<@aui["nav-item"] href="${addCampaignURL}" iconCssClass="icon-plus" label="add-campaign" />
	</#if>
</@>
