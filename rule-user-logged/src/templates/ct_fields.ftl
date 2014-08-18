<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<div class="alert alert-info">
	<@liferay_ui["message"] key="this-rule-will-be-matched-if-the-user-is-signed-in" />
</div>