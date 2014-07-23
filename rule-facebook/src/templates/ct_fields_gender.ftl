<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#assign isMale = gender?string == "male" />

<@aui["input"] checked=isMale label="male" name="gender" type="radio" value="male" />

<#assign isFemale = gender?string == "female" />

<@aui["input"] checked=isFemale label="female" name="gender" type="radio" value="female" />