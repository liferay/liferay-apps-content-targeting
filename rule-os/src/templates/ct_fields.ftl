<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="" name="os">
	<#list operatingSystems as operatingSystem>
		<@aui["option"] label="${operatingSystem}" selected=(operatingSystem == os) value=operatingSystem />
	</#list>
</@>