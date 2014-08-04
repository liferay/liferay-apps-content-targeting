<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#if !trackingPageEnabled>
	<div class="alert alert-warning">
		<@liferay_ui["message"] key="analytics-are-disabled-for-page" />
	</div>
<#else>
	<@aui["input"] helpMessage="enter-the-friendly-url-of-the-page-to-be-tracked" label="friendly-url" name="friendlyURL" type="text" value=friendlyURL />
</#if>