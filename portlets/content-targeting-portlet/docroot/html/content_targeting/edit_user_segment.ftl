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

	<div id="formBuilder"></div>

	<@aui["button-row"]>
		<@aui["button"] type="submit" />
	</@>
</@>

<@aui["script"] use="aui-form-builder">

	<#list ruleTemplates?keys as ruleKey>
		<#assign rule=rulesRegistry.getRule(ruleKey)>

		var CT${ruleKey}RuleField = A.Component.create({

			NAME: 'ct-${ruleKey}-rule-field',

			EXTENDS: A.FormBuilderField,

			prototype: {
				getHTML: function() {
					var instance = this;

					return '<div> \
						<div class="rule-header"> \
							<i class="${rule.getIcon()} rule-icon"></i> \
							<div class="row rule-info"> \
								<div class="rule-title">${rule.getName(locale)}</div> \
								<div class="rule-description">${rule.getDescription(locale)}</div> \
							</div> \
						</div> \
						<div class="rule-editor"> \
							${ruleTemplates[ruleKey]} \
						</div> \
					</div>';
				}
			}

		});

		A.CT${ruleKey}RuleField = CT${ruleKey}RuleField;

		if (!A.FormBuilder.types.${ruleKey}) {
			A.FormBuilder.types.${ruleKey} = A.CT${ruleKey}RuleField;
		}
	</#list>
	;

	var userSegmentBuilder = new A.FormBuilder(
		{
			boundingBox: '#formBuilder',

			availableFields:
			[
				<#list rules as rule>
					{

						acceptChildren: false,
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
			],

			fields:
			[
				<#list ruleInstances as ruleInstance>
					<#assign rule = rulesRegistry.getRule(ruleInstance.getRuleKey())>

					{
						acceptChildren: false,
						iconClass: '${rule.getIcon()}',

						<#if !rule.isInstantiable()>
							id: '${rule.getRuleKey()}Unique',
						</#if>

						label: '${rule.getName(locale)}',
						type: '${rule.getRuleKey()}',
						unique: ${(!rule.isInstantiable())?string}
					}

					<#if ruleInstance_has_next>,</#if>
				</#list>
			]
		}
	).render();

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