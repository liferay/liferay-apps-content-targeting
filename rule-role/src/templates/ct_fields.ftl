<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="" name="roleId">
	<#list roles as role>
		<@aui["option"] label="${role.getTitle(locale)}" selected=(role.getRoleId() == roleId) value=role.getRoleId() />
	</#list>
</@>