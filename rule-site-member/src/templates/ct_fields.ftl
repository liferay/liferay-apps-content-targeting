<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="" name="siteId">
	<#list sites as site>
		<@aui["option"] label="${site.getDescriptiveName(locale)}" selected=(site.getGroupId() == siteId) value=site.getGroupId() />
	</#list>
</@>