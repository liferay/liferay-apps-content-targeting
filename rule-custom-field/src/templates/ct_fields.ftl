<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<#setting number_format="computer">

<@aui["input"] name="classPK" type="hidden" value=classPK />

<#if attributeNames?has_content>
	<@aui["select"] label="user-custom-fields" name="attributeName">
		<#list attributeNames as curAttributeName>
			<@aui["option"] label="${curAttributeName}" value="${curAttributeName}" selected=(curAttributeName == attributeName) />
		</#list>
	</@>

	<#list attributeNames as curAttributeName>
		<div class='atributte-name-value ${((curAttributeName == attributeName) || (validator.isNull(attributeName) && (curAttributeName_index == 0)))?string("","hide")}' id="<@portlet["namespace"] />attributeName_${curAttributeName_index}">
			<@aui["field-wrapper"] label="value">
				<@liferay_ui["custom-attribute"]
					className=className
					classPK=classPK
					editable=true
					label=false
					name=curAttributeName
				/>
			</@>
		</div>
	</#list>

	<@aui["script"] use="aui-base">
		A.one('#<@portlet["namespace"] />attributeName').on(
			'change',
			function(event) {
				A.all('.atributte-name-value').hide();

				var currentTarget = event.currentTarget;

				A.one('#<@portlet["namespace"] />attributeName_' + currentTarget.get("selectedIndex")).show();
			}
		);
	</@>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] arguments=modelResourceName key="no-custom-fields-are-defined-for-x" />
	</div>
</#if>