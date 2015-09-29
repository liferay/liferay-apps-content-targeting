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
<#include "../macros.ftl" />

<#assign containerCssClass = "" />

<#if portletDisplay.isShowConfigurationIcon()>
	<#assign containerCssClass = "show-configuration" />
</#if>

<div class="content-container ${containerCssClass}">
	<div class="full-content" id="<@portlet["namespace"] />FullContent${selectedIndex}">
		<#if isNotConfigured>
			<div class="alert alert-info">
				<@liferay_ui["message"] key="configure-this-app-to-display-different-content-to-each-user-segment" />
			</div>
		<#elseif queryRule.hasAssetEntry()>
			<#if portletDisplayTemplateHtml??>
				${portletDisplayTemplateHtml}
			<#else>
				<@renderAssetEntry />
			</#if>

			<@liferay_util["include"] page="/html/common/analytics/track_content.jsp">
				<@liferay_util["param"] name="analyticsClassName" value=queryRule.getAssetClassName() />
				<@liferay_util["param"] name="analyticsClassPK" value=queryRule.getAssetClassPK()?string />
			</@>
		<#else>
			<div class="alert alert-info">
				<@liferay_ui["message"] key="there-are-no-matching-rules" />
			</div>
		</#if>
	</div>

	<#if showPreview>
		<@renderThumbnailsPreview queryRules=userSegmentQueryRules selectedIndex=selectedIndex />
	</#if>
</div>

<@getEditIconLinks queryRules=userSegmentQueryRules />