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



<#macro breadcrumb>
	<@liferay_ui["breadcrumb"] showCurrentGroup=false showCurrentPortlet=false showLayout=false />
</#macro>

<#macro getEditIconLink
	assetEntry
	cssClass
	index
>
	<#assign assetRenderer = assetEntry.getAssetRenderer() />

	<#if assetRenderer.hasEditPermission(permissionChecker)>
		<@portlet["renderURL"] varImpl="redirectURL" windowState=windowStateFactory.getWindowState("pop_up").toString()>
			<@portlet["param"] name="mvcPath" value="html/add_asset_redirect.ftl" />
			<@portlet["param"] name="redirect" value="${currentURL}" />
		</@>

		<#assign editPortletURL = assetRenderer.getURLEdit(renderRequest, renderResponse, windowStateFactory.getWindowState("pop_up"), redirectURL)!"" />

		<#if validator.isNotNull(editPortletURL)>
			<#assign entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale)) />
			<#assign title = languageUtil.format(locale, "edit-x", entryTitle) />

			<span class="${cssClass}" id="<@portlet["namespace"] />editLink${index}">
				<@liferay_ui["icon"]
					cssClass="lfr-icon-action lfr-icon-action-edit"
					image="edit"
					label=true
					message=title
					url="javascript:Liferay.Util.openWindow({id:'" + renderResponse.getNamespace() + "editAsset', title: '" + title + "', uri:'" + htmlUtil.escapeURL(editPortletURL.toString()) + "'});"
				/>
			</span>
		</#if>
	</#if>
</#macro>

<#macro getEditIconLinks
	queryRules
>
	<#if portletDisplay.isShowConfigurationIcon()>
		<#if queryRules?has_content>
			<div class="icons-container lfr-meta-actions">

				<#assign actionsCssClass = "hide" />
				<#assign selectedQueryRule = queryRules[selectedIndex] />

				<#if selectedQueryRule.hasAssetEntry()>
					<#assign actionsCssClass = "" />
				</#if>

				<div class="lfr-icon-actions ${actionsCssClass}">
					<#list queryRules as queryRule>
						<#if queryRule.hasAssetEntry()>
							<#assign cssClass = "" />

							<#if selectedIndex != queryRule_index>
								<#assign cssClass = "hide" />
							</#if>

							<@getEditIconLink assetEntry=queryRule.getAssetEntry() cssClass=cssClass index=queryRule_index />
						</#if>
					</#list>
				</div>
			</div>
		</#if>
	</#if>
</#macro>

<#macro renderAssetEntry
	assetEntry=""
	displayStyle="full-content"
	showEditLink=false
>
	<#if assetEntry?has_content>
		<#assign assetRenderer = assetEntry.getAssetRenderer() />

		${request.setAttribute("view.jsp-assetEntry", assetEntry)}
		${request.setAttribute("view.jsp-assetRendererFactory", assetEntry.getAssetRendererFactory())}
		${request.setAttribute("view.jsp-assetRenderer", assetRenderer)}
		${request.setAttribute("view.jsp-title", assetEntry.getTitle(themeDisplay.getLocale()))}
	<#else>
		<#assign assetRenderer = request.getAttribute("view.jsp-assetRenderer") />
	</#if>

	<#if displayStyle == "full-content">
		<#assign path = assetRenderer.render(renderRequest, renderResponse, "full_content") />

		<div class="asset-content">
			<@liferay_util["include"] page=path>
				<@liferay_util["param"] name="showEditURL" value=showEditLink?string />
				<@liferay_util["param"] name="showExtraInfo" value="false" />
				<@liferay_util["param"] name="showHeader" value="false" />
			</@>
		</div>
	<#else>
		<@liferay_util["include"] page="/html/portlet/asset_publisher/display/${stringUtil.replace(displayStyle, '-', '_')}.jsp">
			<@liferay_util["param"] name="showEditURL" value=showEditLink?string />
			<@liferay_util["param"] name="showExtraInfo" value="false" />
		</@>
	</#if>
</#macro>

<#macro renderAssetEntrySelector
	queryRule
	index
>
	<#assign cssClass = "">

	<#if !queryRule.hasAssetEntry()>
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
					data=queryRule.getAssetSelectorIconData(request, assetRendererFactory, "${index}")
					id="groupId_${assetRendererFactory.getTypeName(locale, false)}_${index}"
					message=assetRendererFactory.getTypeName(locale, false)
					src=assetRendererFactory.getIconPath(renderRequest)
					url="javascript:;"
				/>
			</#list>
		</@>
	</div>
</#macro>

<#macro renderDefaultQueryRule
	queryRule
>
	<div class="default-content">
		<div class="full-view hide">
			<@aui["column"] columnWidth=60>
				<span class="otherwise-text"><@liferay_ui["message"] key="otherwise" /></span>
			</@>

			<@aui["column"] columnWidth=40>
				<@aui["input"] checked=!queryRule.hasAssetEntry() id="contentDefaultValueDont" label="dont-display-anything" name="contentDefaultValue" type="radio" value=false />

				<@aui["input"] checked=queryRule.hasAssetEntry() id="contentDefaultValueDo" label="display-this-content" name="contentDefaultValue" type="radio" value=true />

				<div id="<@portlet["namespace"] />contentDefaultBox">
					<div class="select-asset-selector">
						<@renderAssetEntrySelector queryRule=queryRule index="Default" />
					</div>
				</div>
			</@>
		</div>

		<div class="summary-view">
			<@aui["column"] columnWidth=50>
				<span class="otherwise-text"><@liferay_ui["message"] key="otherwise" /></span>
			</@>

			<@aui["column"] columnWidth=50>
				<span class="default-content-value-text">
					<#if queryRule.hasAssetEntry()>
						<@liferay_ui["message"] key="display-this-content" />
					<#else>
						<@liferay_ui["message"] key="dont-display-anything" />
					</#if>
				</span>

				<#if queryRule.hasAssetEntry()>
					<span class="query-content-value">${queryRule.getAssetTitle()} (<span class="query-content-value-type">${queryRule.getAssetType()}</span>)</span>
				</#if>
			</@>
		</div>
	</div>
</#macro>

<#macro renderThumbnailsPreview
	queryRules
	selectedIndex
>
	<#if queryRules?has_content && (queryRules?size > 1)>
		<#list queryRules as queryRule>
			<#if (selectedIndex != queryRule_index)>
				<div class="hide full-content" id="<@portlet["namespace"] />FullContent${queryRule_index}">
					<#if queryRule.hasAssetEntry()>
						<#if queryRule.getTemplate()??>
							${queryRule.getTemplate()}
						<#else>
							${queryRule.setAssetAttributes(renderRequest)}

							<@renderAssetEntry />
						</#if>
					</#if>
				</div>
			</#if>
		</#list>

		<div class="lfr-meta-actions content-preview-container" id="<@portlet["namespace"] />contentPreviewContainer">
			<#list queryRules as queryRule>
				<#assign cssClass = "" />

				<#if selectedIndex == queryRule_index>
					<#assign cssClass = "selected" />
				</#if>

				<div class="content-preview ${cssClass}" data-index="${queryRule_index}" id="<@portlet["namespace"] />PreviewContent${queryRule_index}">
					<div class="query-rule-image" style="background-image: url(${queryRule.getAssetImage(renderRequest)});"></div>

					<div class="query-rule-summary">${queryRule.getSummary(portletConfig, locale)}</div>
				</div>
			</#list>
		</div>

		<@aui["script"] use="liferay-thumbnails-preview">
			new Liferay.ThumbnailsPreview(
				{
					selectedIndex: ${selectedIndex},
					namespace: '<@portlet["namespace"] />'
				}
			);
		</@>
	</#if>
</#macro>

<#macro userSegmentSelector
	assetCategoryIds
	assetCategoryNames
	hiddenInput
	vocabularyGroupIds
	vocabularyIds
	warningMessage
	filterIds=""
>
	<@portlet["renderURL"] var="viewUserSegments">
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
		<@portlet["param"] name="tabs1" value="user-segments" />
	</@>

	<div class="user-segment-selector">
		<span class="query-and-operator-text"><@liferay_ui["message"] key="user-segments" /></span>

		<@liferay_ui["icon"]
			id="manageUserSegments"
			image="configuration"
			label=false
			message="manage-user-segments"
			url="javascript:;"
		/>

		<div class="lfr-tags-selector-content" id="<@portlet["namespace"] />assetCategorySelector">
			<@aui["input"] name="${hiddenInput}" type="hidden" value="${assetCategoryIds}" />
		</div>

		<@aui["script"] use="liferay-asset-categories-selector">
			var manageUserSegmentsLink = A.one('#<@portlet["namespace"] />manageUserSegments');

			manageUserSegmentsLink.on(
				'click',
				function() {
					if (confirm('<@liferay_ui["message"] key="${warningMessage}" />')) {
						window.location.href = "${viewUserSegments}";
					}
				}
			);

			var assetCategoriesSelector = new Liferay.AssetCategoriesSelector(
				{
					contentBox: '#<@portlet["namespace"] />assetCategorySelector',
					curEntries: '${assetCategoryNames}',
					curEntryIds: '${assetCategoryIds}',
					<#if (filterIds?has_content)>
						filterIds: '${filterIds}',
					</#if>
					hiddenInput: '#<@portlet["namespace"] />${hiddenInput}',
					instanceVar: '<@portlet["namespace"] />',
					vocabularyGroupIds: '${vocabularyGroupIds}',
					vocabularyIds: '${vocabularyIds}',
					title: '<@liferay_ui["message"] key="select-user-segments" />'
				}
			).render();

			var changeTitle = function() {
				assetCategoriesSelector._popup.titleNode.html(assetCategoriesSelector.get('title'));
			};

			A.Do.after(changeTitle, assetCategoriesSelector, '_showSelectPopup');
		</@>
	</div>
</#macro>