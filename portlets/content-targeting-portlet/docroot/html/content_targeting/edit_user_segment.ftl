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
	title="new-user-segment"
/>

<@portlet["actionURL"] name="updateUserSegment" var="addUserSegmentURL" />

<@aui["form"] action="${addUserSegmentURL}" method="post" name="fm">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="userSegmentId" type="hidden" value=userSegmentId />

	<@aui["model-context"] bean=userSegment model=userSegmentClass />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	<h4><@liferay_ui["message"] key="rules" /></h4>

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
						<@portlet["param"] name="userSegmentId" value="${userSegmentId?string}" />
					</@>

					<@aui["nav-item"]
						anchorId="ruleItem-${rule.getRuleKey()}"
						anchorCssClass="new-rule"
						cssClass="rule-item"
						href="${addRuleInstanceURL}"
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
						<@portlet["param"] name="ruleKey" value="${rule.getRuleKey()}" />
					</@>

					<@liferay_ui["icon"]
						cssClass="rule-item"
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

	<@aui["button-row"]>
		<@aui["button"] type="submit" />
	</@>
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
		'.rule-item a'
	);
</@>