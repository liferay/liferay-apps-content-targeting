<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] name="gender">
	<#assign isMale = gender?string == "male" />

	<@aui["option"] label="male" selected=isMale />

	<#assign isFemale = gender?string == "female" />

	<@aui["option"] label="female" selected=isFemale />
</@>