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

	A.one('#<@portlet["namespace"] />queryRules').delegate(
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
</@>