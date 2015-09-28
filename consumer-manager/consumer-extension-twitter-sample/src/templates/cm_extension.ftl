<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<@aui["input"] label="access-key" name="twitterAccessKey" type="text" value=twitterAccessKey>
	<@aui["validator"] name="required" />
</@>

<@aui["input"] label="access-secret" name="twitterAccessSecret" type="text" value=twitterAccessSecret>
	<@aui["validator"] name="required" />
</@>

<@aui["input"] label="consumer-key" name="twitterConsumerKey" type="text" value=twitterConsumerKey>
	<@aui["validator"] name="required" />
</@>

<@aui["input"] label="consumer-secret" name="twitterConsumerSecret" type="text" value=twitterConsumerSecret>
	<@aui["validator"] name="required" />
</@>