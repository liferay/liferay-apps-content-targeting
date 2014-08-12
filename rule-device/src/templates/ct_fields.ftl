<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["select"] label="device-family" name="mdrRuleGroupId">
	<#list mdrRuleGroups as mdrRuleGroup>
		<@aui["option"] label="${mdrRuleGroup.getName(locale)}" selected=(mdrRuleGroupId == mdrRuleGroup.getRuleGroupId()) value=mdrRuleGroup.getRuleGroupId() />
	</#list>
</@>