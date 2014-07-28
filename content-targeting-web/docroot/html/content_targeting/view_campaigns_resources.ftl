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

<@portlet["renderURL"] varImpl="viewCampaignsURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
	<@portlet["param"] name="tabs1" value="campaigns" />
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-campaigns-were-found"
	iteratorURL=viewCampaignsURL
	rowChecker=rowChecker
	total=campaignSearchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=campaignSearchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.contenttargeting.model.Campaign"
		keyProperty="campaignId"
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

		<@liferay_ui["search-container-column-date"]
			name="start-date"
			value=campaign.getStartDate()
		/>

		<@liferay_ui["search-container-column-date"]
			name="end-date"
			value=campaign.getEndDate()
		/>

		<@liferay_ui["search-container-column-text"]
			name="priority"
			value=campaign.getPriority()?string
		/>

		<@liferay_ui["search-container-column-text"]
			name="status"
		>
			<span class="label ${campaignConstants.getStatusCssClass(campaign.getStatus())}">
				<@liferay_ui["message"] key="${campaign.getStatus()}" />
			</span>
		</@>

		<@liferay_ui["search-container-column-text"]
			align="right"
			name=""
		>
			<@liferay_ui["icon-menu"]>
				<@portlet["renderURL"] var="viewCampaignReportsURL">
					<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_CAMPAIGN_REPORTS}" />
					<@portlet["param"] name="redirect" value="${viewCampaignsURL}" />
					<@portlet["param"] name="campaignId" value="${campaign.getCampaignId()?string}" />
				</@>

				<@liferay_ui["icon"]
					image="view"
					label=true
					message="reports"
					method="get"
					url="${viewCampaignReportsURL}"
				/>

				<#if campaignPermission.contains(permissionChecker, campaign, actionKeys.UPDATE)>
					<@portlet["renderURL"] var="editCampaignURL">
						<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
						<@portlet["param"] name="redirect" value="${viewCampaignsURL}" />
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
						<@portlet["param"] name="redirect" value="${viewCampaignsURL}" />
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

<@aui["script"] use="liferay-util-list-fields">
	var deleteCampaigns = A.one('#<@portlet["namespace"] />deleteCampaigns');

	A.one('#<@portlet["namespace"] />${searchContainerReference.getId()}SearchContainer').on(
		'click',
		function() {
			var hide = (Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmCampaigns, '<@portlet["namespace"] />allRowIds').length == 0);

			deleteCampaigns.toggle(!hide);
		},
		'input[type=checkbox]'
	);

	deleteCampaigns.on(
		'click',
		function(event) {
			if (confirm('${languageUtil.get(locale, "are-you-sure-you-want-to-delete-this")}')) {
				document.<@portlet["namespace"] />fmCampaigns.<@portlet["namespace"] />campaignsIds.value = Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmCampaigns, '<@portlet["namespace"] />allRowIds');

				<@portlet["renderURL"] var="redirectURL">
					<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
					<@portlet["param"] name="tabs1" value="campaigns" />
				</@>

				<@portlet["actionURL"] name="deleteCampaign" var="deleteCampaignsURL">
					<@portlet["param"] name="redirect" value="${redirectURL}" />
				</@>

				submitForm(document.<@portlet["namespace"] />fmCampaigns, '${deleteCampaignsURL}');
			}
		}
	);
</@>