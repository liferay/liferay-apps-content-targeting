<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<@aui["fieldset"]>
	<@aui["select"] name="weather">
		<@aui["option"] label="sunny" selected=(weather == "sunny") value="sunny" />
		<@aui["option"] label="clouds" selected=(weather == "clouds") value="clouds" />
		<@aui["option"] label="mist" selected=(weather == "mist") value="mist" />
		<@aui["option"] label="snow" selected=(weather == "snow") value="snow" />
		<@aui["option"] label="rain" selected=(weather == "rain") value="rain" />
		<@aui["option"] label="drizzle" selected=(weather == "drizzle") value="drizzle" />
		<@aui["option"] label="storm" selected=(weather == "storm") value="storm" />
	</@>
</@>