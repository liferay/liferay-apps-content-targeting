<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<#if (topic??)>
	<iframe scrolling="no" src="http://topsy.com/analytics?q1=${topic}&via=Topsy#module-activityhistory" style="border:0px; min-height:600px; width:100%;" />
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="edit-the-report-and-enter-a-topic-to-filter" />
	</div>
</#if>