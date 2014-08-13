<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_portlet = PortletJspTagLibs["/META-INF/liferay-portlet-ext.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#if !genderEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-the-gender-field-has-been-removed" /></strong>

		<#assign enableLocationLabel = languageUtil.get(locale, "portal-settings-users") />

		<#if hasPortalSettingsViewPermission>
			<@liferay_portlet["renderURL"] plid=portalUtil.getControlPanelPlid(company.getCompanyId()) portletName="130" var="portalSettingsURL">
				<@liferay_portlet["param"] name="historyKey" value="_130_users" />
			</@>

			<#assign enableLocationLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationLabel + "</a>" />
		</#if>

		<@liferay_ui["message"] arguments=enableLocationLabel key="it-can-be-enabled-in-x" />
	</div>
</#if>

<#assign isMale = gender?string == "male" />

<@aui["input"] checked=isMale label="male" name="gender" type="radio" value="male" />

<#assign isFemale = gender?string == "female" />

<@aui["input"] checked=isFemale label="female" name="gender" type="radio" value="female" />