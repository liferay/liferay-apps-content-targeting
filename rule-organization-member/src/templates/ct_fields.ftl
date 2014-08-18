<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#if !organizations?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-organizations-available" /></strong>

		<#assign enableLocationLabel = languageUtil.get(locale, "control-panel-users-and-organizations") />

		<#if usersAdminURL??>
			<#assign enableLocationLabel = "<a href=\"" + usersAdminURL + "\">" + enableLocationLabel + "</a>" />
		</#if>

		<@liferay_ui["message"] arguments=enableLocationLabel key="organizations-can-be-managed-in-x" />
	</div>
<#else>
	<@aui["select"] label="" name="organizationId">
		<#list organizations as organization>
			<@aui["option"] label="${organization.getName()}" selected=(organization.getOrganizationId() == organizationId) value=organization.getOrganizationId() />
		</#list>
	</@>
</#if>