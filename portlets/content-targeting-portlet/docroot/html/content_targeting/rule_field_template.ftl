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

<#list templates as template>
	<#assign rule = template.getRule()>
	<#assign templateKey = template.getTemplateKey()>

	var CT${templateKey}RuleFieldEditor = '${template.getTemplate()}';

	CT${templateKey}RuleFieldEditor = CT${templateKey}RuleFieldEditor.replace(/<!\[CDATA\[/g, '<![CDATA[\n');
	CT${templateKey}RuleFieldEditor = CT${templateKey}RuleFieldEditor.replace(/\/\/ ]]/g, '\n// ]]');

	var CT${templateKey}RuleField = A.Component.create({

		NAME: 'ct-${templateKey}-rule-field',

		EXTENDS: A.FormBuilderField,

		ATTRS: {
			acceptChildren: {
				readOnly: true,
				value: false
			}
		},

		prototype: {
			getHTML: function() {
				var instance = this;

				return A.Lang.sub(
					A.FormBuilder.CTRuleFieldTemplate,
					{
						description: '${rule.getDescription(locale)}',
						editor: CT${templateKey}RuleFieldEditor,
						icon: '${rule.getIcon()}',
						name: '${rule.getName(locale)}',
					}
				);
			},

			getNode: function(){
	            var instance = this,
	            	templateContainer = A.Node.create('<div></div>');

	            templateContainer.plug(A.Plugin.ParseContent);
	            templateContainer.setContent(instance.getHTML());

	            return templateContainer;
			}
		}
	});

	A.CT${templateKey}RuleField = CT${templateKey}RuleField;

	if (!A.FormBuilder.types.${templateKey}) {
		A.FormBuilder.types.${templateKey} = A.CT${templateKey}RuleField;
	}
</#list>