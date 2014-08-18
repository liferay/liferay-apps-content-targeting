<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign liferay_util = PortletJspTagLibs["/META-INF/liferay-util.tld"] />

<@liferay_util["buffer"] var="infoMessage" >
	<#assign enableLocationLabel = languageUtil.get(locale, "site-administration-mdr") />

	<#if mDRURL??>
		<#assign enableLocationLabel = "<a href=\"" + mDRURL + "\">" + enableLocationLabel + "</a>" />
	</#if>

	<@liferay_ui["message"] arguments=enableLocationLabel key="device-families-can-be-managed-in-x" />
</@>

<#if !mdrRuleGroups?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-device-families-available" /></strong>

		${infoMessage}
	</div>
<#else>
	<div class="alert alert-info">${infoMessage}</div>

	<@aui["select"] label="device-family" name="mdrRuleGroupId">
		<#list mdrRuleGroups as mdrRuleGroup>
			<@aui["option"] label="${mdrRuleGroup.getName(locale)}" selected=(mdrRuleGroupId == mdrRuleGroup.getRuleGroupId()) value=mdrRuleGroup.getRuleGroupId() />
		</#list>
	</@>
</#if>