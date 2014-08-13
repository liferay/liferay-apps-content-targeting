<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#assign isMale = gender?string == "male" />

<@aui["input"] checked=isMale label="male" name="fbGender" type="radio" value="male" />

<#assign isFemale = gender?string == "female" />

<@aui["input"] checked=isFemale label="female" name="fbGender" type="radio" value="female" />

<#assign isCustom = gender?string == "custom" />

<@aui["input"] checked=isCustom label="custom-or-not-specified" name="fbGender" type="radio" value="custom" />