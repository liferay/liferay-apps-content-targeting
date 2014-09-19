<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<#if !userGroups?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-user-groups-available" /></strong>

		<#assign enableLocationLabel = languageUtil.get(locale, "control-panel-user-groups") />

		<#if userGroupsAdminURL??>
			<#assign enableLocationLabel = "<a href=\"" + userGroupsAdminURL + "\">" + enableLocationLabel + "</a>" />
		</#if>

		<@liferay_ui["message"] arguments=enableLocationLabel key="user-groups-can-be-managed-in-x" />
	</div>
<#else>
	<@aui["select"] label="" name="userGroupId">
		<#list userGroups as userGroup>
			<@aui["option"] label="${userGroup.getName()}" selected=(userGroup.getUserGroupId() == userGroupId) value=userGroup.getUserGroupId() />
		</#list>
	</@>
</#if>