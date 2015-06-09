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

<#macro invalidDateRangeException>
	<@liferay_ui["error"] key="com.liferay.content.targeting.InvalidDateRangeException" message="please-enter-valid-date-range" />
</#macro>

<#macro invalidNameException>
	<@liferay_ui["error"] key="com.liferay.content.targeting.InvalidNameException">
		<#if errorException.isEmpty()>
			<@liferay_ui["message"] key="the-name-can-not-be-empty" />
		<#elseif errorException.isDuplicated()>
			<@liferay_ui["message"] key="this-name-is-already-in-use-please-choose-a-different-one" />
		<#else>
			<@liferay_ui["message"] key="please-enter-a-valid-name" />
		</#if>
	</@>
</#macro>

<#macro invalidRulesException>
	<@liferay_ui["error"] key="com.liferay.content.targeting.InvalidRulesException" message="there-is-an-error-in-one-of-your-rules" />
</#macro>

<#macro invalidTrackingActionsException>
	<@liferay_ui["error"] key="com.liferay.content.targeting.InvalidTrackingActionsException" message="there-is-an-error-in-one-of-your-tracking-actions" />
</#macro>

<#macro invalidChannelsException>
	<@liferay_ui["error"] key="com.liferay.content.targeting.InvalidChannelsException" message="there-is-an-error-in-one-of-your-channels" />
</#macro>

<#macro usedUserSegmentException>
	<@liferay_ui["error"] key="com.liferay.content.targeting.UsedUserSegmentException">
		<@liferay_ui["message"] key="this-user-segment-can-not-be-deleted-because-it-is-used-by-the-following-campaigns" />

		<ul>
			<#list errorException.getCampaigns() as campaign>
				<li>${campaign.getName(locale)}</li>
			</#list>
		</ul>
	</@>
</#macro>