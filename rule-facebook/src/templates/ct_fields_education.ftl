<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@aui["fieldset"]>
	<@aui["input"] label="user-attended-high-school" name="highSchool" type="checkbox" value=highSchool />

	<@aui["input"] label="user-attended-college" name="college" type="checkbox" value=college />

	<@aui["input"] label="college-school-name" name="schoolName" type="text" value=schoolName />
</@>