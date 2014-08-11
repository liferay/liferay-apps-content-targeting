<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@aui["fieldset"]>
	<@aui["select"] name="educationLevel">
		<@aui["option"] label="any" selected=(educationLevel == "") value="" />
		<@aui["option"] label="high-school" selected=(educationLevel == "high-school") />
		<@aui["option"] label="college" selected=(educationLevel == "college") />
	</@>

	<@aui["input"] label="college-high-school-name" name="schoolName" type="text" value=schoolName />
</@>