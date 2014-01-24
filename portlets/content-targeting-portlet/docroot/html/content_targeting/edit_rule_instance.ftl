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

<@portlet["actionURL"] name="updateRuleInstance" var="editRuleInstanceURL" />

<@aui["form"] action="${editRuleInstanceURL}" method="post" name="fm">
	<@portlet["renderURL"] var="redirectURL">
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_RULE_INSTANCE_REDIRECT}" />
		<@portlet["param"] name="ruleKey" value="${ruleKey}" />
	</@>

	<@aui["input"] name="redirect" type="hidden" value="${redirectURL}" />
	<@aui["input"] name="ruleInstanceId" type="hidden" value=ruleInstanceId />
	<@aui["input"] name="ruleKey" type="hidden" value="${ruleKey}" />
	<@aui["input"] name="userSegmentId" type="hidden" value=userSegmentId />

	${ruleFormHTML}

	<@aui["button-row"]>
		<@aui["button"] type="submit" />
	</@>
</@>