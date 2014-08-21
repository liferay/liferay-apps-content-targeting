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

<#if isMatchingRule>
	<div class="content-container">
		<div class="full-content" id="<@portlet["namespace"] />FullContent${selectedIndex}">
			<@renderAssetEntry />
		</div>

		<#if portletDisplay.isShowConfigurationIcon() && userSegmentQueryRules?has_content && (userSegmentQueryRules?size > 1)>
			<#list userSegmentQueryRules as userSegmentQueryRule>
				<#if selectedIndex != userSegmentQueryRule_index>
					<#assign assetEntry = userSegmentQueryRule.getAssetEntry() />

					<div class="hide full-content" id="<@portlet["namespace"] />FullContent${userSegmentQueryRule_index}">
						<@renderAssetEntry assetEntry=assetEntry />
					</div>
				</#if>
			</#list>

			<@aui["script"] use="aui-base">
				var lastSelectedIndex = ${selectedIndex};

				A.one('#<@portlet["namespace"] />contentPreviewContainer').delegate(
					'hover',
					function(event) {
						var currentTarget = event.currentTarget;

						var index = currentTarget.attr('data-index');

						A.one('#<@portlet["namespace"] />FullContent' + lastSelectedIndex).hide();
						A.one('#<@portlet["namespace"] />PreviewContent' + lastSelectedIndex).removeClass('selected');

						var editLink = A.one('#<@portlet["namespace"] />editLink' + lastSelectedIndex);

						if (editLink) {
							editLink.hide();
						}

						A.one('#<@portlet["namespace"] />FullContent' + index).show();
						A.one('#<@portlet["namespace"] />PreviewContent' + index).addClass('selected');

						editLink = A.one('#<@portlet["namespace"] />editLink' + index);

						if (editLink) {
							editLink.show();
						}

						lastSelectedIndex = index;
					},
					'.content-preview'
				);
			</@>

			<div class="lfr-meta-actions content-preview-container" id="<@portlet["namespace"] />contentPreviewContainer">
				<#list userSegmentQueryRules as userSegmentQueryRule>
					<#assign assetEntry = userSegmentQueryRule.getAssetEntry() />

					<#assign cssClass = "" />

					<#if selectedIndex == userSegmentQueryRule_index>
						<#assign cssClass = "selected" />
					</#if>

					<div class="content-preview ${cssClass}" data-index="${userSegmentQueryRule_index}" id="<@portlet["namespace"] />PreviewContent${userSegmentQueryRule_index}">
						<#assign assetRenderer = assetEntry.getAssetRenderer() />

						<div class="asset-image" style="background-image: url(${assetRenderer.getThumbnailPath(renderRequest)});">
						</div>

						<div class="user-segment-summary">${userSegmentQueryRule.getSummary(portletConfig, locale)}</div>
					</div>
				</#list>
			</div>
		</#if>
	</div>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="there-are-no-matching-rules" />
	</div>
</#if>

<#if portletDisplay.isShowConfigurationIcon()>
	<div class="lfr-meta-actions icons-container">
		<div class="lfr-icon-actions">
			<@getConfigurationIconLink mvcPath=userSegmentContentDisplayPath.CONFIGURATION />

			<#if userSegmentQueryRules?has_content>
				<#list userSegmentQueryRules as userSegmentQueryRule>
					<#assign assetEntry = userSegmentQueryRule.getAssetEntry() />

					<#assign cssClass = "" />

					<#if selectedIndex != userSegmentQueryRule_index>
						<#assign cssClass = "hide" />
					</#if>

					<@getEditIconLink assetEntry=assetEntry cssClass=cssClass index=userSegmentQueryRule_index />
				</#list>
			</#if>
		</div>
	</div>
</#if>