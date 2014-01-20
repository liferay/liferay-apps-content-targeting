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

<#assign redirect = paramUtil.getString(request, "redirect")>
<#assign userSegmentId = paramUtil.getLong(request, "userSegmentId")>

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

	<@liferay_ui["icon-menu"] direction="right" icon="../aui/plus" message="add-rule" showWhenSingleIcon=true>
		<#list rules as rule>
			<#assign addRuleInstanceURL = renderResponse.createRenderURL()>

			${addRuleInstanceURL.setParameter("mvcPath", contentTargetingPath.EDIT_RULE_INSTANCE)}
			${addRuleInstanceURL.setParameter("redirect", currentURL)}
			${addRuleInstanceURL.setParameter("ruleKey", rule.getRuleKey())}
			${addRuleInstanceURL.setParameter("userSegmentId", userSegmentId?string)}

			<@liferay_ui["icon"]
				image="${rule.getIcon()}"
				message="${rule.getName()}"
				url="${addRuleInstanceURL}"
			/>
		</#list>
	</@>

	<@liferay_ui["search-container"]
		emptyResultsMessage="no-rules-were-found-for-this-user-segment"
		iteratorURL=iteratorURL
	>
		<@liferay_ui["search-container-results"]
			results=ruleInstances
			total=ruleInstances ?size
		/>

		<@liferay_ui["search-container-row"]
			className="com.liferay.contenttargeting.model.RuleInstance"
			modelVar="ruleInstance"
		>

			<#assign rule = rulesRegistry.getRule(ruleInstance.getRuleKey())>

			<@liferay_ui["search-container-column-text"]
				name="summary"
				value=rule.getSummary(ruleInstance, locale)
			/>

			<@liferay_ui["search-container-column-text"]
				name=""
			>
				<@liferay_ui["icon-menu"]>
					<#assign editRuleInstanceURL = renderResponse.createRenderURL()>

					${editRuleInstanceURL.setParameter("mvcPath", contentTargetingPath.EDIT_RULE_INSTANCE)}
					${editRuleInstanceURL.setParameter("redirect", currentURL)}
					${editRuleInstanceURL.setParameter("ruleInstanceId", ruleInstance.getRuleInstanceId()?string)}
					${editRuleInstanceURL.setParameter("ruleKey", ruleInstance.getRuleKey()?string)}

					<@liferay_ui["icon"]
						image="edit"
						method="get"
						url="${editRuleInstanceURL}"
					/>

					<#assign deleteRuleInstanceURL = renderResponse.createActionURL()>

					${deleteRuleInstanceURL.setParameter("javax.portlet.action", "deleteRuleInstance")}
					${deleteRuleInstanceURL.setParameter("redirect", currentURL)}
					${deleteRuleInstanceURL.setParameter("ruleInstanceId", ruleInstance.getRuleInstanceId()?string)}

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