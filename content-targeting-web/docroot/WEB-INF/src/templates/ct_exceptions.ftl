<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#list exceptions as exception>
	<div class="alert alert-error">
		<@liferay_ui["message"] key=exception.getMessage() />
	</div>
</#list>