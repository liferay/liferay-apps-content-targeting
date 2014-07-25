<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="" name="browser">
	<#list browsers as curBrowser>
		<@aui["option"] label="${curBrowser}" selected=(curBrowser == browser) value=curBrowser />
	</#list>
</@>