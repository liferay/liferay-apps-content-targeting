<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<#if !sites?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-sites-available" /></strong>

		<#assign enableLocationLabel = languageUtil.get(locale, "control-panel-sites") />

		<#if sitesAdminURL??>
			<#assign enableLocationLabel = "<a href=\"" + sitesAdminURL + "\">" + enableLocationLabel + "</a>" />
		</#if>

		<@liferay_ui["message"] arguments=enableLocationLabel key="sites-can-be-managed-in-x" />
	</div>
<#else>
	<@aui["select"] label="" name="siteId">
		<#list sites as site>
			<@aui["option"] label="${site.getDescriptiveName(locale)}" selected=(site.getGroupId() == siteId) value=site.getGroupId() />
		</#list>
	</@>
</#if>