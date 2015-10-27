<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@portlet["defineObjects"] />

<@liferay_theme["defineObjects"] />

<#-- This setting is necessary since we are not loading FTL_liferay.ftl in the reports or rules -->

<#setting number_format="computer">

<@portlet["renderURL"] varImpl="portletURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_REPORT}" />
	<@portlet["param"] name="redirect" value="${redirect}" />
	<@portlet["param"] name="reportKey" value="${report.getReportKey()}" />
	<@portlet["param"] name="className" value="${className}" />
	<@portlet["param"] name="classPK" value="${classPK?string}" />
</@>

<style>
    .charts {
        height: 400px;
        min-width: 600px;
        width: 100%;
    }
</style>

<@liferay_ui["tabs"]
portletURL=portletURL
names="campaign-report,app-report"
refresh=true
type="pills"
value="${tabs1}"
>
	<@liferay_ui["section"]>
		<#include "ct_campaign_report.ftl" />
	</@>

	<@liferay_ui["section"]>
		<#include "ct_consumer_report.ftl" />
	</@>

</@>