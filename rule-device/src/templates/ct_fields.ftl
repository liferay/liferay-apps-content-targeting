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

<@liferay_util["buffer"] var="infoMessage" >
	<#assign enableLocationLabel = languageUtil.get(request, "site-administration-mdr") />

	<#if mDRURL??>
		<#assign enableLocationLabel = "<a href=\"" + mDRURL + "\">" + enableLocationLabel + "</a>" />
	</#if>

	<@liferay_ui["message"]
		arguments=enableLocationLabel
		key="device-families-can-be-managed-in-x"
	/>
</@>

<#if !mdrRuleGroups?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-device-families-available" /></strong>

		${infoMessage}
	</div>
<#else>
	<div class="alert alert-info">${infoMessage}</div>

	<@liferay_aui["select"] label="device-family" name="mdrRuleGroupId">
		<#list mdrRuleGroups as mdrRuleGroup>
			<@liferay_aui["option"]
				label="${mdrRuleGroup.getName(locale)}"
				selected=(mdrRuleGroupId
				== mdrRuleGroup.getRuleGroupId()) value=mdrRuleGroup.getRuleGroupId()
			/>
		</#list>
	</@>
</#if>