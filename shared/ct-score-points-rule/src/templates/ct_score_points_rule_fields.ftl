<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["input"] name="scorePoints" type="text" value=scorePoints>
	<@aui["validator"] name="number" />
</@>