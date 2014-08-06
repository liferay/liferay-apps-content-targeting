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

<#if portletDisplay.isShowConfigurationIcon()>
	<@portlet["renderURL"] var="configurationURL" windowState=liferayWindowStatePopUp.toString()>
		<@portlet["param"] name="mvcPath" value="${userSegmentContentDisplayPath.CONFIGURATION}" />
		<@portlet["param"] name="redirect" value="${currentURL}" />
	</@>

	<@liferay_ui["icon"]
		cssClass="lfr-meta-actions pull-right"
		image="../aui/wrench"
		label=true
		message="configuration"
		useDialog=true
		url="${configurationURL}"
	/>
</#if>

<#if isMatchingRule>
	<#if portletDisplay.isShowConfigurationIcon() && userSegmentQueryRules?has_content>
		<div class="content-preview-container">
			<#list userSegmentQueryRules as userSegmentQueryRule>
				<#assign assetEntry = userSegmentQueryRule.getAssetEntry() />

				<#assign cssClass = "" />

				<#if selectedIndex == userSegmentQueryRule_index>
					<#assign cssClass = "selected" />
				</#if>

				<#assign userSegmentQueryRuleContains = "belongs" />

				<#if !userSegmentQueryRule.isContains()>
					<#assign userSegmentQueryRuleContains = "does-not-belong" />
				</#if>

				<#assign userSegmentQueryRuleAndOperator = "all" />

				<#if !userSegmentQueryRule.isAndOperator()>
					<#assign userSegmentQueryRuleAndOperator = "any" />
				</#if>

				<#assign toolTipMessage = userSegmentQueryRule.getSummary(locale) />

				<#if !userSegmentQueryRule_has_next>
					<#assign toolTipMessage = languageUtil.get(locale, "default") />
				</#if>

				<span class="content-preview ${cssClass}" data-index="${userSegmentQueryRule_index}" id="<@portlet["namespace"] />PreviewContent${userSegmentQueryRule_index}" onmouseover="Liferay.Portal.ToolTip.show(this, '${toolTipMessage}');">
					<#assign assetRenderer = assetEntry.getAssetRenderer() />

					<img class="asset-image" src="${assetRenderer.getThumbnailPath(renderRequest)}" />
				</span>
			</#list>
		</div>
	</#if>

	<div class="full-content" id="<@portlet["namespace"] />FullContent${selectedIndex}">
		<@liferay_util["include"] page="/html/portlet/asset_publisher/display/full_content.jsp">
			<@liferay_util["param"] name="showExtraInfo" value="false" />
		</@>
	</div>

	<#if portletDisplay.isShowConfigurationIcon() && userSegmentQueryRules?has_content>
		<#list userSegmentQueryRules as userSegmentQueryRule>
			<#if selectedIndex != userSegmentQueryRule_index>
				<#assign assetEntry = userSegmentQueryRule.getAssetEntry() />

	            <div class="hide full-content" id="<@portlet["namespace"] />FullContent${userSegmentQueryRule_index}">
					${request.setAttribute("view.jsp-assetEntry", assetEntry)}
					${request.setAttribute("view.jsp-assetRendererFactory", assetEntry.getAssetRendererFactory())}
					${request.setAttribute("view.jsp-assetRenderer", assetEntry.getAssetRenderer())}
					${request.setAttribute("view.jsp-title", assetEntry.getTitle(themeDisplay.getLocale()))}

					<@liferay_util["include"] page="/html/portlet/asset_publisher/display/full_content.jsp">
						<@liferay_util["param"] name="showExtraInfo" value="false" />
					</@>
				</div>
			</#if>
		</#list>

		<@aui["script"] use="aui-base">
			var lastSelectedIndex = ${selectedIndex};

			A.one('.content-preview-container').delegate(
				'hover',
				function(event) {
					var currentTarget = event.currentTarget;

					var index = currentTarget.attr('data-index');

					A.one('#<@portlet["namespace"] />FullContent' + lastSelectedIndex).hide();
			        A.one('#<@portlet["namespace"] />PreviewContent' + lastSelectedIndex).removeClass('selected');

					A.one('#<@portlet["namespace"] />FullContent' + index).show();
					A.one('#<@portlet["namespace"] />PreviewContent' + index).addClass('selected');

					lastSelectedIndex = index;
				},
				'.content-preview'
		    );
		</@>
	</#if>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="there-are-no-matching-rules" />
	</div>
</#if>