<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="" name="device">
	<#list devices as curDevice>
		<@aui["option"] label="${curDevice}" selected=(curDevice == device) value=curDevice />
	</#list>
</@>