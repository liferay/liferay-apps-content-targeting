<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="" name="roleId">
	<#list roles as role>
		<@aui["option"] label="${role.getTitle(locale)}" selected=(role.getRoleId() == roleId) value=role.getRoleId() />
	</#list>
</@>

<@aui["select"] label="" name="organizationId">
	<#list organizations as organization>
		<@aui["option"] label="${organization.getName()}" selected=(organization.getOrganizationId() == organizationId) value=organization.getOrganizationId() />
	</#list>
</@>