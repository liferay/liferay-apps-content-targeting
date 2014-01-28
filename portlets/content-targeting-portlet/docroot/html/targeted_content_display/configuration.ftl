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

<@liferay_ui["header"]
	backURL="${redirect}"
	title="configuration"
/>

<@liferay_portlet["actionURL"] name="updatePreferences" var="configurationURL" />

<@aui["form"] action="${configurationURL}" method="post" name="fm">
	<div id="<@portlet["namespace"] />queryRules">
		<@aui["fieldset"] label="displayed-assets-must-match-these-rules">
			<div class="lfr-form-row">
				<div class="row-fields">
					<#list queryLogicIndexes as queryLogicIndex>
						${request.setAttribute("configuration.index", queryLogicIndex)}

						<#include "edit_rule.ftl" />
					</#list>
				</div>
			</div>
		</@>
	</div>

	<@aui["button-row"]>
		<@aui["button"] type="submit" value="save" />
	</@>
</@>

<@portlet["renderURL"] var="newUserSegmentRuleURL" windowState=liferayWindowStateExclusive.toString()>
	<@portlet["param"] name="mvcPath" value="${targetedContentDisplayPath.EDIT_RULE}" />
</@>

<@aui["script"] use="aui-base,liferay-auto-fields">
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: '#<@portlet["namespace"] />queryRules > fieldset',
			fieldIndexes: '<@portlet["namespace"] />queryLogicIndexes',
			namespace: '<@portlet["namespace"] />',
			url: '${newUserSegmentRuleURL}'
		}
	).render();

	function selectAsset(assetEntryId, assetClassName, assetType, assetEntryTitle, index) {
		A.one('#<@portlet["namespace"] />assetEntryId' + index).attr('value', assetEntryId);

		A.one('#<@portlet["namespace"] />assetTitleInfo' + index).html(assetEntryTitle);
		A.one('#<@portlet["namespace"] />assetTypeInfo' + index).html(assetType);

		A.one('#<@portlet["namespace"] />selectedContent' + index).show();
	}

	function removeSelectedContent(index) {
		A.one('#<@portlet["namespace"] />assetEntryId' + index).attr('value', '');

		A.one('#<@portlet["namespace"] />assetTitleInfo' + index).html('');
		A.one('#<@portlet["namespace"] />assetTypeInfo' + index).html('');

		A.one('#<@portlet["namespace"] />selectedContent' + index).hide();
	}

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
					selectAsset(event.assetentryid, event.assetclassname, event.assettype, event.assettitle, currentTarget.attr('data-index'));
				}
			);
		},
		'.asset-selector a'
	);

	A.getBody().delegate(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = event.currentTarget;

			removeSelectedContent(currentTarget.attr('data-index'));
		},
		'.delete-selected-content a'
	);
</@>