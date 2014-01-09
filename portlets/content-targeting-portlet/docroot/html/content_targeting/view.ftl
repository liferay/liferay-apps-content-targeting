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

<#assign userSegmentResults = userSegmentService.getUserSegments(themeDisplay.getScopeGroupId())>

<@aui["nav-bar"]>
	<@aui["nav"]>
		<#assign editUserSegmentURL = renderResponse.createRenderURL()>

		${editUserSegmentURL.setParameter("mvcPath", "html/content_targeting/edit_user_segment.ftl")}
		${editUserSegmentURL.setParameter("redirect", portalUtil.getCurrentURL(request))}

		<@aui["nav-item"] href="${editUserSegmentURL}" iconCssClass="icon-plus" label="add-user-segment" />
	</@>
</@>

<#assign iteratorURL = renderResponse.createRenderURL()>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-user-segment-were-found"
	iteratorURL=iteratorURL
>
	<@liferay_ui["search-container-results"]
		results=userSegmentResults
		total=userSegmentResults?size
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.contenttargeting.model.UserSegment"
		modelVar="userSegment"
	>

		<#assign rowURL = renderResponse.createRenderURL()>

		${rowURL.setParameter("mvcPath", "html/content_targeting/edit_user_segment.ftl")}
		${rowURL.setParameter("redirect", portalUtil.getCurrentURL(request))}
		${rowURL.setParameter("userSegmentId", userSegment.getSegmentId()?string)}

		<@liferay_ui["search-container-column-text"]
			name="name"
			href=rowURL
			value=userSegment.getName()
		/>

		<@liferay_ui["search-container-column-text"]
			name="description"
			href=rowURL
			value=userSegment.getDescription()
		/>
	</@>

	<@liferay_ui["search-iterator"] />
</@>