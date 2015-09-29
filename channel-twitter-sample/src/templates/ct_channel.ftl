<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<@aui["input"] label="message" name="{ct_field_guid}message" type="textarea" value=message>
	<@aui["validator"] name="required" />
</@>