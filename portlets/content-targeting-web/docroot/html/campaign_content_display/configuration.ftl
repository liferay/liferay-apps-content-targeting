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

<@liferay_portlet["actionURL"] name="updatePreferences" var="configurationURL">
	<@portlet["param"] name="redirect" value="${currentURL}" />
</@>

<span class="title"><@liferay_ui["message"] key="display-the-following-content"/></span>

<@aui["form"] action="${configurationURL}" method="post" name="fm">
	<div class="rules-panel">
		<div id="<@portlet["namespace"] />queryRules">
			<@aui["fieldset"] label="">
				<#assign rowClass = "first active" />
				<#assign isFirst = true />

				<#list queryLogicIndexes as queryLogicIndex>
					${request.setAttribute("configuration.index", queryLogicIndex)}
					${request.setAttribute("configuration.isFirst", isFirst)}

					<div class="lfr-form-row ${rowClass}">
						<div class="row-fields">
							<#include "edit_query_rule.ftl" />
						</div>
					</div>

					<#assign rowClass = "" />
					<#assign isFirst = false />
				</#list>
			</@>
		</div>

		<div class="lfr-form-row last">
			<div class="row-fields">
				<div class="default-content">
					<div class="full-view hide">
						<@aui["column"] columnWidth=60>
							<span class="otherwise-text"><@liferay_ui["message"] key="otherwise" /></span>
						</@>

						<@aui["column"] columnWidth=40>
							<@aui["input"] checked=!contentDefaultValue label="dont-display-anything" name="contentDefaultValue" type="radio" value=false />

							<@aui["input"] checked=contentDefaultValue label="display-this-content" name="contentDefaultValue" type="radio" value=true />

							<div id="<@portlet["namespace"] />contentDefaultBox">
								<div class="select-asset-selector">
									<#assign cssClass = "">

									<#if (assetEntryIdDefault <= 0)>
										<#assign cssClass = "hide">
									</#if>

									<div class="asset-preview ${cssClass}" id="<@portlet["namespace"] />selectedContentDefault">
										<@aui["column"]>
											<img class="asset-image" src="${assetImageDefault}" />
										</@>
										<@aui["column"]>
											<div class="asset-title" id="<@portlet["namespace"] />assetTitleInfoDefault">${assetTitleDefault}</div>
											<div class="asset-type" id="<@portlet["namespace"] />assetTypeInfoDefault"><@liferay_ui["message"] key="type" />: ${assetTypeDefault}</div>
										</@>
									</div>

									<@aui["input"] name="assetEntryIdDefault" type="hidden" value=assetEntryIdDefault />

									<div class="lfr-meta-actions edit-controls">
										<@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" message=languageUtil.get(locale, "select-content") showWhenSingleIcon=true>
											<#list assetRendererFactories as assetRendererFactory>
												<@liferay_ui["icon"]
													cssClass="asset-selector"
													data=userSegmentContentDisplayUtilClass.getAssetSelectorIconData(request, assetRendererFactory, "Default")
													id="groupId_${assetRendererFactory.getTypeName(locale, false)}_Default"
													message=assetRendererFactory.getTypeName(locale, false)
													src=assetRendererFactory.getIconPath(renderRequest)
													url="javascript:;"
												/>
											</#list>
										</@>
									</div>
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
								<#if (!contentDefaultValue)>
									<@liferay_ui["message"] key="dont-display-anything" />
								<#else>
									<@liferay_ui["message"] key="display-this-content" />
								</#if>
							</span>

							<#if (contentDefaultValue && (assetEntryIdDefault > 0))>
								<span class="default-content-value">${assetTitleDefault} (<span class="default-content-value-type">${assetTypeDefault}</span>)</span>
							</#if>
						</@>
					</div>
				</div>
			</div>
		</div>
	</div>

	<@aui["button-row"]>
		<@aui["button"] type="submit" value="save" />
	</@>
</@>

<@portlet["renderURL"] var="newUserSegmentRuleURL" windowState=liferayWindowStateExclusive.toString()>
	<@portlet["param"] name="mvcPath" value="${campaignContentDisplayPath.EDIT_QUERY_RULE}" />
</@>

<@aui["script"] use="aui-base,liferay-auto-fields">
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: '#<@portlet["namespace"] />queryRules > fieldset',
			fieldIndexes: '<@portlet["namespace"] />queryLogicIndexes',
			namespace: '<@portlet["namespace"] />',
			sortable: false,
			url: '${newUserSegmentRuleURL}'
		}
	).render();

	A.getBody().delegate(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = event.currentTarget;

			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					eventName: 'selectContent',
					id: 'selectContent' + currentTarget.attr('id'),
					title: currentTarget.attr('data-title'),
					uri: currentTarget.attr('data-href')
				},
				function(event) {
					var index = currentTarget.attr('data-index');

					A.one('#<@portlet["namespace"] />assetEntryId' + index).attr('value', event.assetentryid);

					A.one('#<@portlet["namespace"] />assetTitleInfo' + index).html(event.assettitle);
					A.one('#<@portlet["namespace"] />assetTypeInfo' + index).html(event.assettype);

					A.one('#<@portlet["namespace"] />selectedContent' + index).show();
				}
			);
		},
		'.asset-selector a'
	);

	A.getBody().delegate(
		'click',
		function(event) {
			A.all('.lfr-form-row').each(
				function(row) {
					row.removeClass('active');

					var summaryContent = row.one('.summary-view');

					if (summaryContent) {
						var fullView = row.one('.full-view');

						if (fullView) {
							fullView.hide();
						}

						summaryContent.show();
					}
				}
			);

			var currentTarget = event.currentTarget;

			currentTarget.addClass('active');

			var fullView = currentTarget.one('.full-view');

			if (fullView) {
				fullView.show();
			}

			var summaryView = currentTarget.one('.summary-view');

			if (summaryView) {
				summaryView.hide();
			}
		},
		'.lfr-form-row'
	);

	Liferay.Util.toggleSelectBox('<@portlet["namespace"] />contentDefaultValue', 'true', '<@portlet["namespace"] />contentDefaultBox');
</@>