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

<@liferay_ui["search-container"]
	emptyResultsMessage=languageUtil.format(locale, "there-is-not-enough-data-to-generate-a-tracking-actions-report-for-the-campaign-x", name)
	iteratorURL=portletURL
	total=searchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal"
		modelVar="campaignTrackingActionTotal"
	>

		<@liferay_ui["search-container-column-text"]
			name="alias"
			value=campaignTrackingActionTotal.getAlias()
		/>

		<@liferay_ui["search-container-column-text"]
			name="event"
			value="${languageUtil.get(locale, campaignTrackingActionTotal.getEventType())}"
		/>

		<@liferay_ui["search-container-column-text"]
			name="count"
		>

			${campaignTrackingActionTotal.getCount()}

			<#assign viewsByUserSegment = campaignTrackingActionTotal.getViewsByUserSegment() />

			<#if viewsByUserSegment?has_content>
				<div class="pull-right">
					<i class="icon-info" data-id="${campaignTrackingActionTotal.getCampaignTrackingActionId()}" style="display: block;padding: 0 1em;"></i>

					<div class="hide" id="<@portlet["namespace"] />userSegmentViews${campaignTrackingActionTotal.getCampaignTrackingActionId()}">
						<#list viewsByUserSegment as campaignTrackingAction>
							<p>${campaignTrackingAction.getUserSegmentName(locale)} - ${campaignTrackingAction.getCount()}</p>
						</#list>
					</div>
				</div>
			</#if>
		</@>

		<@liferay_ui["search-container-column-date"]
			name="last-update"
			value=campaignTrackingActionTotal.getModifiedDate()
		/>
	</@>

	<#if searchContainer.getResults()?has_content>
		<#include "ct_chart.ftl" />
	</#if>

	<@liferay_ui["search-iterator"] />
</@>

<@aui["script"] use="aui-base,event-hover">
	A.one('#<@portlet["namespace"] />${searchContainerReference.getId()}SearchContainer').delegate(
		'hover',
		function(event) {
			var currentTarget = event.currentTarget;

			var id = currentTarget.attr('data-id');

			var userSegmentViews = A.one('#<@portlet["namespace"] />userSegmentViews' + id);

			Liferay.Portal.ToolTip.show(this, userSegmentViews.html());
		},
		'.icon-info'
	);
</@>