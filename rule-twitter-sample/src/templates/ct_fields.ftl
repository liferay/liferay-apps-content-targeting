<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_portlet = PortletJspTagLibs["/META-INF/liferay-portlet-ext.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign liferay_util = PortletJspTagLibs["/META-INF/liferay-util.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<#setting number_format="computer">

<@liferay_ui["message"] arguments=selectorField key="users-that-have-more-than" />

<@aui["input"] inlineField=true label="" name="followersThreshold" style="margin-bottom: 0; width: auto;" suffix="followers" title="number-of-followers" type="text" value=followersThreshold>
	<@aui["validator"] name="number" />
</@>