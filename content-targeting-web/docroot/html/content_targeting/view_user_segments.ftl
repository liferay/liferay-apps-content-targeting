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

<#include "../init.ftl" />
<#include "../macros_exceptions.ftl" />

<@usedUserSegmentException />

<@portlet["renderURL"] var="searchURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
	<@portlet["param"] name="tabs1" value="user-segments" />
</@>

<@aui["form"] action="${searchURL}" method="post" name="fmUserSegment">
	<@aui["input"] name="redirect" type="hidden" value="${currentURL}" />
	<@aui["input"] name="userSegmentIds" type="hidden" />

	<@aui["nav-bar"]>
		<#include "user_segment_toolbar.ftl" />

		<@aui["nav-bar-search"] cssClass="pull-right">
			<div class="form-search">
				<@liferay_ui["input-search"] id="userSegmentKeywords" name="userSegmentKeywords" placeholder='${languageUtil.get(portletConfig, locale, "keywords")}' />
			</div>
		</@>
	</@>

	<div id="<@portlet["namespace"] />userSegmentsPanel">
		<#include "view_user_segments_resources.ftl" />
	</div>
</@>

<@aui["script"] use="liferay-ajax-search">
	var userSegmentsPanel = A.one('#<@portlet["namespace"] />userSegmentsPanel');
	var inputNode = A.one('#<@portlet["namespace"] />userSegmentKeywords');

	var search = new Liferay.AjaxContentSearch(
		{
			contentPanel: userSegmentsPanel,
			inputNode: inputNode,
			resourceURL: '<@portlet["resourceURL"]><@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_USER_SEGMENTS_RESOURCES}" /><@portlet["param"] name="tabs1" value="user-segments" /></@>',
			namespace: '<@portlet["namespace"] />'
		}
	);
</@>