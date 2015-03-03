<#include "init.ftl" />

<@liferay_util["buffer"] var="selectorField" >
	<@aui["select"] inlineField=true label="" name="selector" style="width: auto;">
		<@aui["option"] label="more" selected=(selector == "more") />
		<@aui["option"] label="less" selected=(selector == "less") />
	</@>
</@>

<@liferay_ui["message"] arguments=selectorField key="users-that-have-x-than" />

<@aui["input"] inlineField=true label="" name="numberOfFriends" style="margin-bottom: 0; width: auto;" suffix="friends" title="number-of-friends" type="text" value=numberOfFriends>
	<@aui["validator"] name="number" />
</@>