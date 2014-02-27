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

<@liferay_ui["header"]
	backURL="${redirect}"
	title='${languageUtil.format(locale, "edit-x", userSegment.getName(locale))}'
/>

<@aui["nav-bar"]
	cssClass="add-rule-bar"
>
	<@aui["nav"]>
		<@aui["nav-item"]
			dropdown=true
			iconCssClass="icon-plus"
			label="add-rule"
		>
			<#list rules as rule>
				<@portlet["renderURL"] var="addRuleInstanceURL" windowState="${liferayWindowStatePopUp}">
					<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_RULE_INSTANCE}" />
					<@portlet["param"] name="redirect" value="${currentURL}" />
					<@portlet["param"] name="ruleKey" value="${rule.getRuleKey()}" />
					<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()?string}" />
				</@>

				<@aui["nav-item"]
					anchorId="ruleItem-${rule.getRuleKey()}"
					anchorCssClass="new-rule"
					cssClass="${userSegment.isRuleEnabled(rule)?string('rule-item enabled','rule-item disabled')}"
					href="${userSegment.isRuleEnabled(rule)?string(addRuleInstanceURL,'javascript:;')}"
					iconCssClass="${rule.getIcon()}"
					label="${rule.getName(locale)}"
				/>
			</#list>
		</@>
	</@>
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-rules-were-found-for-this-user-segment"
	iteratorURL=iteratorURL
>
	<@liferay_ui["search-container-results"]
		results=ruleInstances
		total=ruleInstances?size
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.contenttargeting.model.RuleInstance"
		modelVar="ruleInstance"
	>
		<#assign rule = rulesRegistry.getRule(ruleInstance.getRuleKey())>

		<@liferay_ui["search-container-column-text"]
			name="name"
			value=rule.getName(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			name="summary"
			value=rule.getSummary(ruleInstance, locale)
		/>

		<@liferay_ui["search-container-column-text"]
			align="right"
			name=""
		>
			<@liferay_ui["icon-menu"]>
				<@portlet["renderURL"] var="editRuleInstanceURL" windowState="${liferayWindowStatePopUp}">
					<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_RULE_INSTANCE}" />
					<@portlet["param"] name="redirect" value="${currentURL}" />
					<@portlet["param"] name="ruleInstanceId" value="${ruleInstance.getRuleInstanceId()?string}" />
				</@>

				<@liferay_ui["icon"]
					cssClass="rule-item enabled"
					id="ruleItem-${rule.getRuleKey()}"
					image="edit"
					method="get"
					url="${editRuleInstanceURL}"
				/>

				<@portlet["actionURL"] name="deleteRuleInstance" var="deleteRuleInstanceURL">
					<@portlet["param"] name="redirect" value="${currentURL}" />
					<@portlet["param"] name="ruleInstanceId" value="${ruleInstance.getRuleInstanceId()?string}" />
				</@>

				<@liferay_ui["icon-delete"]
					url="${deleteRuleInstanceURL}"
				/>
			</@>
		</@>
	</@>

	<@liferay_ui["search-iterator"] />
</@>

<@aui["script"] use="aui-base">
	A.getBody().delegate(
		'click',
		function(event){
			event.preventDefault();

			var title;

			if (event.currentTarget.hasClass('new-rule')) {
				title = '<@liferay_ui["message"] key="new-rule" />' + ': ' +  event.currentTarget.html();
			}
			else {
				title = '<@liferay_ui["message"] key="edit-rule" />';
			}

			Liferay.Util.openWindow(
				{
					dialog:
						{
							destroyOnHide: true
						},
					id: 'dialog_' + event.currentTarget.attr('id'),
					title: title,
					uri: event.currentTarget.attr('href')
				}
			);
		},
		'.rule-item.enabled a'
	);
</@>