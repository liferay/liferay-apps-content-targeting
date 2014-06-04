<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#if !genderEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-the-gender-field-has-been-removed" /></strong>

		<@liferay_ui["message"] key="it-can-be-enabled-in-portal-settings-users" />
	</div>
</#if>

<#assign isMale = gender?string == "male" />

<@aui["input"] checked=isMale label="male" name="gender" type="radio" value="male" />

<#assign isFemale = gender?string == "female" />

<@aui["input"] checked=isFemale label="female" name="gender" type="radio" value="female" />