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

<div class="campaign" id="<@portlet["namespace"] />campaignsContainer">
	<div class="category-header">
		<div class="category-icon">
			<i class="icon-check"></i>
		</div>
		<div class="category-info">
			<div class="category-title">
				<@liferay_ui["message"] key="matched" />
			</div>
			<div class="category-description">
				<@liferay_ui["message"] key="campaigns" />
			</div>
		</div>
	</div>

	<div class="category-content">
		<#if campaigns?has_content>
			<#list campaigns as campaign>
				<@aui["input"] cssClass="user-segment" label="${campaign.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" name="campaign${campaign.getCampaignId()}" type="checkbox" checked=false value="" />
			</#list>
		<#else>
			<div class="alert alert-info">
				<@liferay_ui["message"] key="the-current-user-does-not-match-any-campaign" />
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
				<@liferay_ui["message"] key="campaigns" />
			</div>
		</div>
	</div>

	<div class="category-content">
		<#list notMatchedCampaigns as campaign>
			<@aui["input"] cssClass="user-segment" label="${campaign.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" name="campaign${campaign.getCampaignId()}" type="checkbox" checked=false value="" />
		</#list>
	</div>
</div>

<@aui["script"] use="aui-toggler">
	var campaignsContainer = A.one('#<@portlet["namespace"] />campaignsContainer');

	var togglerDelegate = new A.TogglerDelegate(
		{
			animated: true,
			closeAllOnExpand: false,
			container: campaignsContainer,
			content: '.category-content',
			expanded: true,
			header: '.category-header'
		}
	);
</@>