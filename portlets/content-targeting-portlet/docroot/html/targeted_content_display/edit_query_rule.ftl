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

<#assign queryRule = queryRuleUtilClass.getQueryRule(portletPreferences, index, locale)>

<div class="lfr-form-row">
	<div class="row-fields">
		<div class="field-row form-inline query-row">
			<@aui["select"] inlineField=true label="user" name="queryContains${index}">
				<@aui["option"] label="belongs" selected=queryRule.isContains() value=true />
				<@aui["option"] label="does-not-belong" selected=!queryRule.isContains() value=false />
			</@>

			<@aui["select"] inlineField=true label="to" name="queryAndOperator${index}" suffix="of-the-following-user-segments">
				<@aui["option"] label="all" selected=queryRule.isAndOperator() value=true />
				<@aui["option"] label="any"selected=!queryRule.isAndOperator() value=false />
			</@>

			<div class="user-segment-selector">
				<div class="lfr-tags-selector-content" id="<@portlet["namespace"] />assetCategoriesSelector${index}">
					<@aui["input"] name="userSegmentAssetCategoryIds${index}" type="hidden" value="${queryRule.getUserSegmentAssetCategoryIdsAsString()}" />
				</div>

				<@aui["script"] use="liferay-asset-categories-selector">
					var assetCategoriesSelector = new Liferay.AssetCategoriesSelector(
						{
							contentBox: '#<@portlet["namespace"] />assetCategoriesSelector${index}',
							curEntries: '${queryRule.getUserSegmentAssetCategoryNames(locale)}',
							curEntryIds: '${queryRule.getUserSegmentAssetCategoryIdsAsString()}',
							hiddenInput: '#<@portlet["namespace"] />userSegmentAssetCategoryIds${index}',
							instanceVar: '<@portlet["namespace"] />',
							vocabularyGroupIds: '${vocabularyGroupIds}',
							vocabularyIds: '${vocabularyId}',
							title: '<@liferay_ui["message"] key="select-user-segments" />'
						}
					).render();

					var changeTitle = function() {
						assetCategoriesSelector._popup.titleNode.html(assetCategoriesSelector.get('title'));
					};

					A.Do.after(changeTitle, assetCategoriesSelector, '_showSelectPopup');
				</@>
			</div>

			<div class="select-asset-selector">
				<div class="lfr-meta-actions edit-controls">
					<@aui["input"] name="assetEntryId${index}" type="hidden" value=queryRule.getAssetEntryId() />

					<@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" message=languageUtil.get(locale, "select-content") showWhenSingleIcon=true>
						<#list assetRendererFactories as assetRendererFactory>
							<@liferay_ui["icon"]
								cssClass="asset-selector"
								data=targetedContentDisplayUtilClass.getAssetSelectorIconData(request, assetRendererFactory, "${index}")
								id="groupId_${assetRendererFactory.getTypeName(locale, false)}_${index}"
								message=assetRendererFactory.getTypeName(locale, false)
								src=assetRendererFactory.getIconPath(renderRequest)
								url="javascript:;"
							/>
						</#list>
					</@>
				</div>
			</div>

			<#assign cssClass = "">

			<#if !queryRule.isValid()>
				<#assign cssClass = "hide">
			</#if>

			<div class="selected-content ${cssClass}" id="<@portlet["namespace"] />selectedContent${index}">
				<table class="table table-bordered table-hover table-striped">
					<thead class="table-columns">
					<tr>
						<th class="table-first-header">${languageUtil.get(locale, "title")}</th>
						<th class="">${languageUtil.get(locale, "type")}</th>
						<th class="table-last-header">&nbsp;</th>
					</tr>
					</thead>
					<tbody class="table-data">
					<tr class="">
						<td class="table-cell first" id="<@portlet["namespace"] />assetTitleInfo${index}">${queryRule.getAssetTitle()}</td>
						<td class="table-cell" id="<@portlet["namespace"] />assetTypeInfo${index}">${queryRule.getAssetType()}</td>
						<td class="table-cell last">
							<@liferay_ui["icon"]
								cssClass="delete-selected-content"
								data={"index" : index}
								image="delete"
								url="javascript:;"
							/>
						</td>
					</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>