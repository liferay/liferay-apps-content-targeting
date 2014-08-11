<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />
<#assign liferay_util = PortletJspTagLibs["/META-INF/liferay-util.tld"] />

<@liferay_util["buffer"] var="selectorField" >
	<@aui["select"] inlineField=true label="" name="selector" style="width: auto;">
		<@aui["option"] label="more" selected=(selector == "more") />
		<@aui["option"] label="less" selected=(selector == "less") />
	</@>
</@>

<@aui["input"] inlineField=true inlineLabel="left" label=languageUtil.format(locale, "users-that-have-x-than", selectorField) name="numberOfFriends" style="width: auto;" suffix="friends"  type="text" value=numberOfFriends />