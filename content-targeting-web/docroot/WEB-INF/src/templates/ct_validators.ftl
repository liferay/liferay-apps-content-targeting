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

<@liferay_aui["script"] use="aui-base,aui-form-validator">
	var form = Liferay.Form.get('<@portlet["namespace"] />fm');
	var validator = form.formValidator;
	var rules = validator.get('rules');
	var strings = validator.get('fieldStrings');

	<#list validatorTagsMap?keys as fieldName>
		<#assign validatorTags = validatorTagsMap[fieldName] />

		rules['<@portlet["namespace"] />${fieldName}'] = {
			<#list validatorTags as validatorTag>
				<#assign value = "true" />

				<#if (!validatorTag.isCustom() && validatorTag.getBody()?? && validatorTag.getBody() != "''")>
					<#assign value = validatorTag.getBody() />
				</#if>

				${validatorTag.getName()}: ${value} <#if validatorTag_has_next>,</#if>
			</#list>
		}

		var fieldStrings;

		<#list validatorTags as validatorTag>
			<#if validatorTag.isCustom()>
				A.config.FormValidator.RULES['${validatorTag.getName()}'] = ${validatorTag.getBody()};
			</#if>

			<#if validatorTag.getErrorMessage()??>
				var fieldStrings = strings['<@portlet["namespace"] />${fieldName}'];

				if (!fieldStrings) {
					fieldStrings = {};

					strings['<@portlet["namespace"] />${fieldName}'] = fieldStrings;
				}

				fieldStrings['${validatorTag.getName()}'] = '<@liferay_ui["message"] key=validatorTag.getErrorMessage() />';
			</#if>
		</#list>
	</#list>
</@>