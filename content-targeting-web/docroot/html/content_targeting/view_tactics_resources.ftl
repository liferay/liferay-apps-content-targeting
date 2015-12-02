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

<#include "../init.ftl" />

<@portlet["renderURL"] varImpl="viewTacticsURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
	<@portlet["param"] name="campaignId" value="${campaignId}" />
	<@portlet["param"] name="tabs2" value="promotions" />
	<@portlet["param"] name="className" value="${campaignClass.getName()}" />
	<@portlet["param"] name="classPK" value="${campaignId}" />
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-promotions-were-found"
	iteratorURL=viewTacticsURL
	rowChecker=tacticsRowChecker
	total=tacticSearchContainerIterator.getTotal(campaignId)
>
	<@liferay_ui["search-container-results"]
		results=tacticSearchContainerIterator.getResults(campaignId, searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.content.targeting.model.Tactic"
		keyProperty="tacticId"
		modelVar="tactic"
	>

		<#if campaignPermission.contains(permissionChecker, campaign, actionKeys.UPDATE)>
			<@portlet["renderURL"] var="editTacticURL">
				<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_TACTIC}" />
				<@portlet["param"] name="redirect" value="${viewTacticsURL}" />
				<@portlet["param"] name="tacticId" value="${tactic.getTacticId()?string}" />
				<@portlet["param"] name="campaignId" value="${tactic.getCampaignId()}" />
			</@>
		</#if>

		<@liferay_ui["search-container-column-text"]
			href=editTacticURL
			name="name"
			value=tactic.getName(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			href=editTacticURL
			name="description"
			value=tactic.getDescription(locale)
		/>

		<#if editTacticURL??>
			<@liferay_ui["search-container-column-text"]
				align="right"
				name=""
			>
				<@liferay_ui["icon-menu"]>
					<@liferay_ui["icon"]
						image="edit"
						method="get"
						url="${editTacticURL}"
					/>

					<@portlet["actionURL"] name="deleteTactic" var="deleteTacticURL">
						<@portlet["param"] name="redirect" value="${viewTacticsURL}" />
						<@portlet["param"] name="tacticId" value="${tactic.getTacticId()?string}" />
					</@>

					<@liferay_ui["icon-delete"]
						url="${deleteTacticURL}"
					/>
				</@>
			</@>
		</#if>
	</@>

	<@liferay_ui["search-iterator"] />
</@>

<@aui["script"] use="liferay-util-list-fields">
	var deleteTactics = A.one('#<@portlet["namespace"] />deleteTactics');

	if (deleteTactics) {
		A.one('#<@portlet["namespace"] />${searchContainerReference.getId()}SearchContainer').on(
			'click',
			function() {
				var hide = (Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmTactics, '<@portlet["namespace"] />allRowIds').length == 0);

				deleteTactics.toggle(!hide);
			},
			'input[type=checkbox]'
		);

		deleteTactics.on(
			'click',
			function(event) {
				if (confirm('<@liferay_ui["message"] key="are-you-sure-you-want-to-delete-this" />')) {
					document.<@portlet["namespace"] />fmTactics.<@portlet["namespace"] />tacticsIds.value = Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmTactics, '<@portlet["namespace"] />allRowIds');

					<@portlet["renderURL"] var="redirectURL">
						<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
						<@portlet["param"] name="campaignId" value="${campaignId}" />
						<@portlet["param"] name="tabs2" value="promotions" />
						<@portlet["param"] name="className" value="${campaignClass.getName()}" />
						<@portlet["param"] name="classPK" value="${campaignId}" />
					</@>

					<@portlet["actionURL"] name="deleteTactic" var="deleteTacticsURL">
						<@portlet["param"] name="redirect" value="${redirectURL}" />
					</@>

					submitForm(document.<@portlet["namespace"] />fmTactics, '${deleteTacticsURL}');
				}
			}
		);
	}
</@>