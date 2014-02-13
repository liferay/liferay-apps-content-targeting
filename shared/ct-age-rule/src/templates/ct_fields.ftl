<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#if !birthdayEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-the-age-field-has-been-removed" /></strong>

		<@liferay_ui["message"] key="it-can-be-enabled-in-portal-settings-users" />
	</div>
</#if>

<@aui["input"] name="olderThan" value=olderThan />

<@aui["input"] name="youngerThan" value=youngerThan />