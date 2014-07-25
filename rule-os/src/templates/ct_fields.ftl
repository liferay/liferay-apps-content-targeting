<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="" name="os">
	<#list operativeSystems as operativeSystem>
		<@aui["option"] label="${operativeSystem}" selected=(operativeSystem == os) value=operativeSystem />
	</#list>
</@>