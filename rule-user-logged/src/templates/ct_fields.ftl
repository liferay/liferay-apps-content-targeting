<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="" name="userGroupId">
	<#list userGroups as userGroup>
		<@aui["option"] label="${userGroup.getName()}" selected=(userGroup.getUserGroupId() == userGroupId) value=userGroup.getUserGroupId() />
	</#list>
</@>