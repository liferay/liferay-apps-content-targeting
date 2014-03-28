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

				return '<div> \
					<div class="rule-header"> \
						<div class="rule-icon"> \
							<i class="${rule.getIcon()}"></i> \
						</div> \
						<div class="row rule-info"> \
							<div class="rule-title">${rule.getName(locale)}</div> \
							<div class="rule-description">${rule.getDescription(locale)}</div> \
						</div> \
					</div> \
					<div class="rule-editor"> \
						${template.getTemplate()} \
					</div> \
				</div>';
			}
		}
	});

	A.CT${templateKey}RuleField = CT${templateKey}RuleField;

	if (!A.FormBuilder.types.${templateKey}) {
		A.FormBuilder.types.${templateKey} = A.CT${templateKey}RuleField;
	}
</#list>