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

<@aui["form"] action="${configurationURL}" method="post" name="fm">
	<div id="<@portlet["namespace"] />queryRules">
		<@aui["fieldset"] label="display-the-following-content">
			<#list queryLogicIndexes as queryLogicIndex>
				${request.setAttribute("configuration.index", queryLogicIndex)}

				<#include "edit_query_rule.ftl" />
			</#list>
		</@>
	</div>

	<div class="default-content">
		<@aui["select"] label="default-content" name="contentDefaultValue">
			<@aui["option"] label="dont-display-anything" selected=!contentDefaultValue value=false />
			<@aui["option"] label="select" selected=contentDefaultValue value=true />
		</@>

		<div id="<@portlet["namespace"] />contentDefaultBox">
			<div class="select-asset-selector">
				<div class="lfr-meta-actions edit-controls">
					<@aui["input"] name="assetEntryIdDefault" type="hidden" value=assetEntryIdDefault />

					<@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" message=languageUtil.get(locale, "select-content") showWhenSingleIcon=true>
						<#list assetRendererFactories as assetRendererFactory>
							<@liferay_ui["icon"]
								cssClass="asset-selector"
								data=targetedContentDisplayUtilClass.getAssetSelectorIconData(request, assetRendererFactory, "Default")
								id="groupId_${assetRendererFactory.getTypeName(locale, false)}_Default"
								message=assetRendererFactory.getTypeName(locale, false)
								src=assetRendererFactory.getIconPath(renderRequest)
								url="javascript:;"
							/>
						</#list>
					</@>
				</div>
			</div>

			<#assign cssClass = "">

			<#if (assetEntryIdDefault <= 0)>
				<#assign cssClass = "hide">
			</#if>

			<div class="selected-content ${cssClass}" id="<@portlet["namespace"] />selectedContentDefault">
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
						<td class="table-cell first" id="<@portlet["namespace"] />assetTitleInfoDefault">${assetTitleDefault}</td>
						<td class="table-cell" id="<@portlet["namespace"] />assetTypeInfoDefault">${assetTypeDefault}</td>
						<td class="table-cell last">
							<@liferay_ui["icon"]
								cssClass="delete-selected-content"
								data={"index" : "Default"}
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

	<@aui["button-row"]>
		<@aui["button"] type="submit" value="save" />
	</@>
</@>

<@portlet["renderURL"] var="newUserSegmentRuleURL" windowState=liferayWindowStateExclusive.toString()>
	<@portlet["param"] name="mvcPath" value="${targetedContentDisplayPath.EDIT_QUERY_RULE}" />
</@>

<@aui["script"] use="aui-base,liferay-auto-fields">
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: '#<@portlet["namespace"] />queryRules > fieldset',
			fieldIndexes: '<@portlet["namespace"] />queryLogicIndexes',
			namespace: '<@portlet["namespace"] />',
			sortable: true,
			sortableHandle: '.field-row',
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

	A.one('#<@portlet["namespace"] />fm').delegate(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = event.currentTarget;

			var index = currentTarget.attr('data-index');

			A.one('#<@portlet["namespace"] />assetEntryId' + index).attr('value', '');

			A.one('#<@portlet["namespace"] />assetTitleInfo' + index).html('');
			A.one('#<@portlet["namespace"] />assetTypeInfo' + index).html('');

			A.one('#<@portlet["namespace"] />selectedContent' + index).hide();
		},
		'.delete-selected-content a'
	);

	Liferay.Util.toggleSelectBox('<@portlet["namespace"] />contentDefaultValue', 'true', '<@portlet["namespace"] />contentDefaultBox');
</@>