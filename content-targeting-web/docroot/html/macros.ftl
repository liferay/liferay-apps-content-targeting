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

<#macro breadcrumb>
	<@liferay_ui["breadcrumb"] showCurrentGroup=false showCurrentPortlet=false showLayout=false />
</#macro>

<#macro closeConfirm
	confirmMessage
	controlCssClasses=[]
>
	<#assign controlCssClassesSelector="">

	<#list controlCssClasses as controlCssClass>
		<#if (controlCssClassesSelector?length > 0)>
			<#assign controlCssClassesSelector=controlCssClassesSelector + ",">
		</#if>

		<#assign controlCssClassesSelector=controlCssClassesSelector + "." + controlCssClass>
	</#list>

	<@aui["input"] type="hidden" name="closeConfirm" value="true" />

	<@aui["script"] use="aui-base">
		A.all('${controlCssClassesSelector}').on(
			'mouseup',
			function(event) {
				var closeConfirmElement = A.one('#<@portlet["namespace"] />closeConfirm');

				closeConfirmElement.val('false');
			}
		);

		A.on(
			'beforeunload',
			function(event) {
				var closeConfirmElement = A.one('#<@portlet["namespace"] />closeConfirm');

				if (closeConfirmElement.val() === 'true') {
					event.preventDefault('<@liferay_ui["message"] key="${confirmMessage}" />');
				}
			}
		);
	</@>
</#macro>

<#macro fieldHeaderListener
	fieldName
>
	<@aui["script"] use="aui-base">
		var formBuilder = A.one('.form-builder-drop-container');

		formBuilder.delegate(
			'blur',
			function(){
				var node = this;

				var headerSpan = node.ancestor('.form-builder-field-content').one('span.field-description-alias');
				var headerInfoSpan = node.ancestor('.form-builder-field-content').one('span.field-description-info');

				if (node.val() && node.val() !== '') {
					var headerValue = node.val();

					if (headerInfoSpan.text() !== '') {
						headerValue += '. ';
					}

					headerSpan.text(headerValue);
				}
				else {
					headerSpan.text('');
				}
			},
			'[name*="${fieldName}"]'
		);

		formBuilder.all('[name*="${fieldName}"]').each(
			function(node) {
				var headerSpan = node.ancestor('.form-builder-field-content').one('span.field-description-alias');
				var headerInfoSpan = node.ancestor('.form-builder-field-content').one('span.field-description-info');

				if (node.val() && node.val() !== '') {
					var headerValue = node.val();

					if (headerInfoSpan.text() !== '') {
						headerValue += '. ';
					}

					headerSpan.text(headerValue);
				}
				else {
					headerSpan.text('');
				}
			}
		);
	</@>
</#macro>

<#macro getEditIconLink
	assetEntry
	cssClass
	index
>
	<#assign assetRenderer = assetEntry.getAssetRenderer() />

	<#if assetRenderer.hasEditPermission(permissionChecker)>
		<@portlet["renderURL"] copyCurrentRenderParameters=false varImpl="redirectURL" windowState=windowStateFactory.getWindowState("pop_up").toString()>
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
		<#assign renderResult = assetRenderer.include(request, response, "full_content")>
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

		<@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" message=languageUtil.get(portletConfig.getResourceBundle(locale), "select-content") showWhenSingleIcon=true>
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
	<@portlet["renderURL"] copyCurrentRenderParameters=false var="viewUserSegments">
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
					var closeConfirmElement = A.one('#<@portlet["namespace"] />closeConfirm');

					if (closeConfirmElement) {
						closeConfirmElement.val('false');
					}

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

				var modalBody = assetCategoriesSelector._popup.getStdModNode(A.WidgetStdMod.BODY);

				modalBody.append('<div style="position: absolute; bottom: 15px; right: 15px;"><button class="btn btn-primary close-popup-button"><@liferay_ui["message"] key="ok" /></button></div>');

				modalBody.one('.close-popup-button').on(
					'click',
					function() {
						assetCategoriesSelector._popup.hide();
						this.ancestor('div').remove();
					}
				);
			};

			A.Do.after(changeTitle, assetCategoriesSelector, '_showSelectPopup');
		</@>
	</div>
</#macro>