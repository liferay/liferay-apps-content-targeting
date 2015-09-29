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

<#include "../init.ftl" />

<@liferay_portlet["actionURL"] name="updatePreferences" var="configurationURL">
	<@portlet["param"] name="redirect" value="${currentURL}" />
</@>

<@aui["form"] action="${configurationURL}" method="post" name="fm">
	<@liferay_ui["tabs"]
		names="content-selection,display-settings"
		param="tabs2"
		refresh=false
	>

		<@liferay_ui["section"]>
			<span class="title">
				<@liferay_ui["message"] key="display-the-following-content"/>

				<@liferay_ui["icon-help"] message="the-following-conditions-will-be-evaluated-in-order" />
			</span>

			<div class="rules-panel">
				<div id="<@portlet["namespace"] />queryRules">
					<@aui["fieldset"] label="">
						<#list userSegmentQueryRules as queryRule>
							${request.setAttribute("configuration.queryRule", queryRule)}
							${request.setAttribute("configuration.isFirst", queryRule_index == 0)}

							<div class="lfr-form-row ${queryRule.getCssClass(queryRule_index)}">
								<div class="row-fields">
									<#include "edit_query_rule.ftl" />
								</div>
							</div>
						</#list>
					</@>
				</div>
			</div>
		</@>

		<@liferay_ui["section"]>
			<div class="display-template">
				<@liferay_ui["ddm-template-selector"]
					classNameId=portalUtil.getClassNameId(templateHandler.getClassName())
					displayStyle=displayStyle
					displayStyleGroupId=displayStyleGroupId
					displayStyles=displayStyles
					label="display-template"
					refreshURL=configurationURL
				/>
			</div>
		</@>
	</@>

	<@aui["button-row"]>
		<@aui["button"] type="submit" value="save" />
	</@>
</@>

<@portlet["renderURL"] var="newUserSegmentRuleURL" windowState=windowStateFactory.getWindowState("EXCLUSIVE").toString()>
	<@portlet["param"] name="mvcPath" value="${userSegmentContentDisplayPath.EDIT_QUERY_RULE}" />
</@>


<@aui["script"] use="dd-proxy">

	// This code is only needed to fix a YUI issue. See WCM-42
	// It should be removed once this plugin is migrated to 7.0

	A.Plugin.DDProxy.prototype.clone = function() {
	   var host = this.get('host'),
		   n = host.get('node'),
		   c = n.cloneNode(true);

	   c.all('input[type="radio"]').removeAttribute('name');

	   delete c._yuid;
	   c.setAttribute('id', A.guid());
	   c.setStyle('position', 'absolute');
	   n.get('parentNode').appendChild(c);
	   host.set('dragNode', c);
	   return c;
	}
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

	var onAssetSelectorClick = function(event) {
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
	};

	var onFormRowClick = function(event) {
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
	};

	A.getBody().delegate(
		'click',
		function(event) {
			if (event.currentTarget.hasClass('lfr-form-row')) {
				onFormRowClick(event);
			}
			else {
				onAssetSelectorClick(event);
			}
		},
		'.asset-selector a, .lfr-form-row'
	);

	Liferay.Util.toggleRadio('<@portlet["namespace"] />contentDefaultValueDo', '<@portlet["namespace"] />contentDefaultBox', '');
	Liferay.Util.toggleRadio('<@portlet["namespace"] />contentDefaultValueDont', '', '<@portlet["namespace"] />contentDefaultBox');
</@>