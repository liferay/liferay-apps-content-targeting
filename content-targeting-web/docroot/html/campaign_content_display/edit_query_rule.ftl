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

<#assign configurationIndex = getterUtil.getInteger(request.getAttribute("configuration.index"))>
<#assign index = paramUtil.getInteger(request, "index", configurationIndex)>

<#assign isFirst = getterUtil.getBoolean(request.getAttribute("configuration.isFirst"))>

<#assign queryRule = campaignQueryRuleUtilClass.getQueryRule(portletPreferences, index, locale)>

<div class="field-row query-row">
	<@aui["input"] name="queryIndex${index}" type="hidden" />

	<#assign fullViewClass = "">
	<#assign summaryViewClass = "hide">

	<#if queryRule.isValid() && !isFirst >
		<#assign fullViewClass = "hide">
		<#assign summaryViewClass = "">
	</#if>

	<div class="full-view ${fullViewClass}">
		<@aui["column"] columnWidth=50>
			<span class="query-contains-text"><@liferay_ui["message"] key="if-the-user-belongs-to-this-campaign" /></span>

			<div class="campaign-selector">
				<@aui["select"] label="" name="campaignId${index}">
					<#list campaigns as campaign>
						<@aui["option"] label="${campaign.getName(locale)}" selected=(queryRule.getCampaignId() == campaign.getCampaignId()) value="${campaign.getCampaignId()}" />
					</#list>
				</@>
			</div>
		</@>

		<@aui["column"] columnWidth=50>
			<div class="select-asset-selector">
				<span class="query-and-operator-text"><@liferay_ui["message"] key="display-this-content" /></span>

				<#assign cssClass = "">

				<#if !queryRule.isValid()>
					<#assign cssClass = "hide">
				</#if>

				<div class="asset-preview ${cssClass}" id="<@portlet["namespace"] />selectedContent${index}">
					<@aui["column"]>
						<img class="asset-image" src="${queryRule.getAssetImage(renderRequest)}" />
					</@>
					<@aui["column"]>
						<div class="asset-title" id="<@portlet["namespace"] />assetTitleInfo${index}">${queryRule.getAssetTitle()}</div>
						<div class="asset-type" id="<@portlet["namespace"] />assetTypeInfo${index}"><@liferay_ui["message"] key="type" />: ${queryRule.getAssetType()}</div>
					</@>
				</div>

				<div class="edit-controls lfr-meta-actions">
					<@aui["input"] name="assetEntryId${index}" type="hidden" value=queryRule.getAssetEntryId() />

					<@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" message=languageUtil.get(locale, "select-content") showWhenSingleIcon=true>
						<#list assetRendererFactories as assetRendererFactory>
							<@liferay_ui["icon"]
								cssClass="asset-selector"
								data=userSegmentContentDisplayUtilClass.getAssetSelectorIconData(request, assetRendererFactory, "${index}")
								id="groupId_${assetRendererFactory.getTypeName(locale, false)}_${index}"
								message=assetRendererFactory.getTypeName(locale, false)
								src=assetRendererFactory.getIconPath(renderRequest)
								url="javascript:;"
							/>
						</#list>
					</@>
				</div>
			</div>
		</@>
	</div>

	<#if queryRule.isValid()>
		<div class="summary-view ${summaryViewClass}">
			<@aui["column"] columnWidth=50>
				<span class="query-content-text"><@liferay_ui["message"] key="if-the-user-belongs-to-this-campaign" /></span>
				<span class="query-content-value">${queryRule.getCampaignName(locale)} (${languageUtil.get(locale, "priority")} ${queryRule.getCampaignPriority()})</span>
			</@>

			<@aui["column"] columnWidth=50>
				<span class="query-content-text"><@liferay_ui["message"] key="display-this-content" /></span>
				<span class="query-content-value">${queryRule.getAssetTitle()} (<span class="query-content-value-type">${queryRule.getAssetType()}</span>)</span>
			</@>
		</div>
	</#if>
</div>