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

<#if contentTargetingPermission.contains(permissionChecker, scopeGroupId, actionKeys.ADD_CAMPAIGN)>
	<@aui["nav-bar"]>
		<@aui["nav"]>
			<@portlet["renderURL"] var="addCampaignURL">
				<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
				<@portlet["param"] name="redirect" value="${currentURL}" />
			</@>

			<@aui["nav-item"] href="${addCampaignURL}" iconCssClass="icon-plus" label="add-campaign" />
		</@>
	</@>
</#if>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-campaigns-were-found"
	iteratorURL=renderResponse.createRenderURL()
>
	<@liferay_ui["search-container-results"]
		results=campaigns
		total=campaigns ?size
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.contenttargeting.model.Campaign"
		modelVar="campaign"
	>

		<@liferay_ui["search-container-column-text"]
			name="name"
			value=campaign.getName(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			name="description"
			value=campaign.getDescription(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			name="start-date"
			value=displayFormatDate.format(campaign.getStartDate())
		/>

		<@liferay_ui["search-container-column-text"]
			name="end-date"
			value=displayFormatDate.format(campaign.getEndDate())
		/>

		<@liferay_ui["search-container-column-text"]
			name="priority"
			value=campaign.getPriority()?string
		/>

		<@liferay_ui["search-container-column-text"]
			align="right"
			name=""
		>
			<@liferay_ui["icon-menu"]>
				<#if campaignPermission.contains(permissionChecker, campaign, actionKeys.UPDATE)>
					<@portlet["renderURL"] var="editCampaignURL">
						<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
						<@portlet["param"] name="redirect" value="${currentURL}" />
						<@portlet["param"] name="campaignId" value="${campaign.getCampaignId()?string}" />
					</@>

					<@liferay_ui["icon"]
						image="edit"
						method="get"
						url="${editCampaignURL}"
					/>
				</#if>

				<#if campaignPermission.contains(permissionChecker, campaign, actionKeys.DELETE)>
					<@portlet["actionURL"] name="deleteCampaign" var="deleteCampaignURL">
						<@portlet["param"] name="redirect" value="${currentURL}" />
						<@portlet["param"] name="campaignId" value="${campaign.getCampaignId()?string}" />
					</@>

					<@liferay_ui["icon-delete"]
						url="${deleteCampaignURL}"
					/>
				</#if>

				<#if campaignPermission.contains(permissionChecker, campaign, actionKeys.PERMISSIONS)>
					<@liferay_security["permissionsURL"]
						modelResource="${campaignClass.getName()}"
						modelResourceDescription="${campaign.getName(locale)}"
						resourcePrimKey="${campaign.getCampaignId()}"
						var="permissionsEntryURL"
						windowState="${liferayWindowStatePopUp}"
					/>

					<@liferay_ui["icon"]
						image="permissions"
						method="get"
						url="${permissionsEntryURL}"
						useDialog=true
					/>
				</#if>
			</@>
		</@>
	</@>

	<@liferay_ui["search-iterator"] />
</@>