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
	title='${(userSegment.getName(locale))!"new-user-segment"}'
/>

<@portlet["actionURL"] name="updateUserSegment" var="addUserSegmentURL" />

<@aui["form"] action="${addUserSegmentURL}" method="post" name="fm">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="userSegmentId" type="hidden" value=userSegmentId />

	<@aui["model-context"] bean=userSegment model=userSegmentClass />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	<#if userSegment??>
		<div id="formBuilder"></div>
	</#if>

	<@aui["button-row"]>
		<@aui["button"] type="submit" />
	</@>
</@>

<#if userSegment??>
	<@aui["script"] use="aui-form-builder">
		new A.FormBuilder(
			{
				boundingBox: '#formBuilder',

				availableFields:
				[
					<#list rules as rule>
						<@portlet["renderURL"] var="addRuleInstanceURL" windowState="${liferayWindowStatePopUp}">
							<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_RULE_INSTANCE}" />
							<@portlet["param"] name="redirect" value="${currentURL}" />
							<@portlet["param"] name="ruleKey" value="${rule.getRuleKey()}" />
							<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()?string}" />
						</@>

						<#assign options=rule.getEditorOptions()>

						{
							iconClass: '${rule.getIcon()}',
							label: '${rule.getName(locale)}',
							options: [
								<#list options?keys as option>
									{
										label: '${option}',
										value: '${options[option]}'
									}

									<#if option_has_next>,</#if>
								</#list>
							],
							type: '${rule.getEditorType()}'
						}

						<#if rule_has_next>,</#if>
					</#list>
				]
			}
		).render();
	</@>
</#if>