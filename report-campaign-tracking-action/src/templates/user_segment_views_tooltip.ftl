<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@portlet["defineObjects"] />

<@liferay_theme["defineObjects"] />

<#-- This setting is necessary since we are not loading FTL_liferay.ftl in the reports or rules -->

<#setting number_format="computer">

<i class="icon-info" data-id="${campaignTrackingActionTotal.getCampaignTrackingActionId()}"></i>

<div class="hide" id="<@portlet["namespace"] />userSegmentViews${campaignTrackingActionTotal.getCampaignTrackingActionId()}">
	<#list campaignTrackingActionTotal.getViewsByUserSegment() as campaignTrackingAction>
		<p>${campaignTrackingAction.getUserSegmentName(locale)} - ${campaignTrackingAction.getCount()}</p>
	</#list>
</div>