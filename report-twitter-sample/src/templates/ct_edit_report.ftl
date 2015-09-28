<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<@aui["input"] label="topic" name="topic" type="text" value=topic>
	<@aui["validator"] name="required" />
</@>