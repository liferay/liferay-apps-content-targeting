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

<#if isSimulatedUserSegments>
	<h2><@liferay_ui["message"] key="simulated-user-segments" /></h2>

	<ul>
		<#list userSegments as userSegment>
			<li>
				${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}

				<@portlet["actionURL"] name="removeSimulateUserSegment" var="removeSimulateUserSegmentURL">
					<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()}" />
					<@portlet["param"] name="redirect" value="${currentURL}" />
				</@>

				<@liferay_ui["icon"]
					iconCssClass="icon-minus"
					label=true
					message="remove"
					url="${removeSimulateUserSegmentURL}"
				/>
			</li>
		</#list>
	</ul>

	<@portlet["actionURL"] name="stopSimulation" var="stopSimulationURL">
		<@portlet["param"] name="redirect" value="${currentURL}" />
	</@>

	<a class="btn" href="${stopSimulationURL}"><@liferay_ui["message"] key="clear-simulated-user-segments" /></a>
<#elseif userSegments?has_content>
	<h2><@liferay_ui["message"] key="matched-user-segments" /></h2>

	<ul>
		<#list userSegments as userSegment>
			<li>${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}</li>
		</#list>
	</ul>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="the-current-user-does-not-match-any-user-segment" />
	</div>
</#if>

<h2><@liferay_ui["message"] key="not-matched-user-segments" /></h2>

<ul>
	<#list notMatchedUserSegments as userSegment>
		<@portlet["actionURL"] name="simulateUserSegment" var="simulateUserSegmentURL">
			<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()}" />
			<@portlet["param"] name="redirect" value="${currentURL}" />
		</@>

		<li>

		${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}

		<@liferay_ui["icon"]
			iconCssClass="icon-plus"
			label=true
			message="simulate"
			url="${simulateUserSegmentURL}"
		/>

		</li>
	</#list>
</ul>