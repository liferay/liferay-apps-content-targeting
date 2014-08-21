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

<div id="<@portlet["namespace"] />userSegmentContainer">
	<div class="category-header">
		<div class="category-icon">
			<i class="icon-check"></i>
		</div>
		<div class="category-info">
			<div class="category-title">
				<@liferay_ui["message"] key="matched" />
			</div>
			<div class="category-description">
				<@liferay_ui["message"] key="user-segments" />
			</div>
		</div>
	</div>

	<div class="category-content">
		<#if userSegments?has_content>
			<#list userSegments as userSegment>
				<@aui["input"] cssClass="user-segment" label="${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" name="userSegment${userSegment.getUserSegmentId()}" type="checkbox" checked=simulatedUserSegmentIds?seq_contains(userSegment.getUserSegmentId()) value=userSegment.getUserSegmentId() />
			</#list>
		<#else>
			<div class="alert alert-info">
				<@liferay_ui["message"] key="the-current-user-does-not-match-any-user-segment" />
			</div>
		</#if>
	</div>

	<div class="category-header">
		<div class="category-icon">
			<i class="icon-check-empty"></i>
		</div>
		<div class="category-info">
			<div class="category-title">
				<@liferay_ui["message"] key="other" />
			</div>
			<div class="category-description">
				<@liferay_ui["message"] key="user-segments" />
			</div>
		</div>
	</div>

	<div class="category-content">
		<#list notMatchedUserSegments as userSegment>
			<@portlet["actionURL"] name="simulateUserSegment" var="simulateUserSegmentURL">
				<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()}" />
				<@portlet["param"] name="redirect" value="${currentURL}" />
			</@>

			<@aui["input"] cssClass="user-segment" label="${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" name="userSegment${userSegment.getUserSegmentId()}" type="checkbox" checked=simulatedUserSegmentIds?seq_contains(userSegment.getUserSegmentId()) value=userSegment.getUserSegmentId() />
		</#list>
	</div>
</div>

<@aui["script"] use="aui-toggler">
	var userSegmentContainer = A.one('#<@portlet["namespace"] />userSegmentContainer');

	var togglerDelegate = new A.TogglerDelegate(
		{
			animated: true,
			closeAllOnExpand: false,
			container: userSegmentContainer,
			content: '.category-content',
			expanded: true,
			header: '.category-header'
		}
	);
</@>