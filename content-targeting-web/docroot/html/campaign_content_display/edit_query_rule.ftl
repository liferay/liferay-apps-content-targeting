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
<#include "../macros.ftl" />

<#assign index = paramUtil.getInteger(request, "index", queryRule.getIndex())>

<#assign isFirst = getterUtil.getBoolean(request.getAttribute("configuration.isFirst"))>

<div class="field-row query-row">
	<#if !queryRule.isDefaultRule()>
		<@aui["input"] name="queryIndex${index}" type="hidden" />
	</#if>

	<#assign fullViewClass = "">
	<#assign summaryViewClass = "hide">

	<#if queryRule.isValid() && !isFirst >
		<#assign fullViewClass = "hide">
		<#assign summaryViewClass = "">
	</#if>

	<#if !queryRule.isDefaultRule()>
		<div class="full-view ${fullViewClass}">
			<@aui["column"] columnWidth=50>
				<span class="query-contains-text"><@liferay_ui["message"] key="if-the-user-matches-this-campaign" /></span>

				<div class="campaign-selector">
					<@aui["select"] label="" name="campaignId${index}">
						<#list campaigns as campaign>
							<@aui["option"] label="${campaign.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" selected=(queryRule.getCampaignId() == campaign.getCampaignId()) value="${campaign.getCampaignId()}" />
						</#list>
					</@>
				</div>
			</@>

			<@aui["column"] columnWidth=50>
				<div class="select-asset-selector">
					<span class="query-and-operator-text"><@liferay_ui["message"] key="display-this-content" /></span>

					<@renderAssetEntrySelector queryRule=queryRule index=index />
				</div>
			</@>
		</div>

		<#if queryRule.isValid()>
			<div class="summary-view ${summaryViewClass}">
				<@aui["column"] columnWidth=50>
					<span class="query-content-text"><@liferay_ui["message"] key="if-the-user-matches-this-campaign" /></span>
					<span class="query-content-value">${queryRule.getCampaignName(locale)} (${languageUtil.get(locale, "priority")} ${queryRule.getCampaignPriority()})</span>
				</@>

				<@aui["column"] columnWidth=50>
					<span class="query-content-text"><@liferay_ui["message"] key="display-this-content" /></span>
					<span class="query-content-value">${queryRule.getAssetTitle()} (<span class="query-content-value-type">${queryRule.getAssetType()}</span>)</span>
				</@>
			</div>
		</#if>
	<#else>
		<@renderDefaultQueryRule queryRule=queryRule />
	</#if>
</div>