<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@aui["script"] use="aui-base,aui-form-validator">
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