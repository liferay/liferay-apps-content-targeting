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
	title='${(userSegment.getName(locale))!"new-user-segment"}'
/>

<@portlet["actionURL"] name="updateUserSegment" var="addUserSegmentURL" />

<@aui["form"] action="${addUserSegmentURL}" method="post" name="fm" onSubmit="event.preventDefault(); saveRules();">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="userSegmentId" type="hidden" value=userSegmentId />
	<@aui["input"] name="userSegmentRules" type="hidden" />

	<@aui["model-context"] bean=userSegment model=userSegmentClass />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	<div class="panel-page-menu rules-search hide">
		<div class="search-panels">
			<i class="icon-search"></i>

			<div class="search-panels-bar">
				<@aui["input"] cssClass="search-panels-input search-query span12" label="" name="searchPanel" type="text" />
			</div>
		</div>
	</div>

	<div id="formBuilder"></div>

	<@aui["button-row"]>
		<@aui["button"] cssClass="pull-right" type="submit" />
	</@>
</@>

<@aui["script"] use="aui-form-builder,autocomplete-base,autocomplete-filters">

	A.FormBuilder.prototype._onClickField = function(event) {
		var instance = this,
			field = A.Widget.getByNode(event.target);

		instance.simulateFocusField(field, event.target);

		event.stopPropagation();
	};

	A.FormBuilder.prototype.simulateFocusField = function(field, target) {
		var instance = this,
			lastFocusedField = instance.lastFocusedField;

		if (lastFocusedField) {
			lastFocusedField.blur();
		}

		instance.lastFocusedField = field.focus();

		if (target) {
			target.focus();
		}
	};

	<#assign templates = ruleTemplates>

	<#include "rule_field_template.ftl" />

	<#if userSegment??>
		<#assign templates = addedRuleTemplates>

		<#include "rule_field_template.ftl" />
	</#if>

	var userSegmentBuilder = new A.FormBuilder(
		{
			boundingBox: '#formBuilder',

			availableFields:
			[
				<#list rules as rule>
					{
						iconClass: '${rule.getIcon()}',

						<#if !rule.isInstantiable()>
							id: '${rule.getRuleKey()}Unique',
						</#if>

						label: '<div class="row"><div class="rule-title">${rule.getName(locale)}</div><div class="rule-description">${rule.getDescription(locale)}</div></div>',
						type: '${rule.getRuleKey()}',
						unique: ${(!rule.isInstantiable())?string}
					}

					<#if rule_has_next>,</#if>
				</#list>
			]

			<#if userSegment??>
				,

				fields:
				[
					<#list ruleInstances as ruleInstance>
						<#assign rule = rulesRegistry.getRule(ruleInstance.getRuleKey())>

						{
							iconClass: '${rule.getIcon()}',

							<#if !rule.isInstantiable()>
								id: '${rule.getRuleKey()}Unique',
							</#if>

							label: '${rule.getName(locale)}',
							type: '${rule.getRuleKey()}_${ruleInstance.getRuleInstanceId()}',
							unique: ${(!rule.isInstantiable())?string}
						}

						<#if ruleInstance_has_next>,</#if>
					</#list>
				]
			</#if>
		}
	).render();

	A.one('.tab-pane.active').insertBefore(
		A.one('.rules-search'),
		A.one('.diagram-builder-fields-container')
	).removeClass('hide');

	var RuleSearch = A.Base.create('ruleSearch', A.Base, [A.AutoCompleteBase],
		{
			initializer: function () {
				this._bindUIACBase();
				this._syncUIACBase();
			}
		}
	);

	var ruleFilter = new RuleSearch(
		{
			inputNode: '.rules-search .search-panels-input',
			minQueryLength: 0,
			queryDelay: 0,

			source: (function () {
				var results = [];

				A.all('.diagram-builder-fields-container .rule-title').each(function (node) {
					results.push({
						node: node,
						searchData: node.text()
					});
				});

	  			return results;
			}()),

			resultTextLocator: 'searchData',

			resultFilters: 'phraseMatch'
		}
	);

	ruleFilter.on(
		'results',
		function (e) {
			A.all('.diagram-builder-field').addClass('hide');

			A.Array.each(
				e.results,
				function (result) {
					result.raw.node.ancestor('.diagram-builder-field').removeClass('hide');
				}
			);
		}
	);

	saveRules = function() {
		var userSegment = {
			rules: []
		};

		userSegmentBuilder.get('fields').each(
			function(item) {
				var rule = {
					id: item.get('id'),
					data: [],
					type: item.get('type')
				};

				var contentBox = item.get('contentBox');

				contentBox.all('input').each(
					function(input) {
						rule.data.push(
							{
								name: input.attr('name'),
								value: input.val()
							}
						);
					}
				);

				userSegment.rules.push(rule);
			}
		);

		document.<@portlet["namespace"] />fm.<@portlet["namespace"] />userSegmentRules.value = JSON.stringify(userSegment);
		submitForm(document.<@portlet["namespace"] />fm);
	};
</@>