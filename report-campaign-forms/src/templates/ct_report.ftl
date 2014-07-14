<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@portlet["defineObjects"] />

<@liferay_theme["defineObjects"] />

<#-- This setting is necessary since we are not loading FTL_liferay.ftl in the reports or rules -->

<#setting number_format="computer">

<@portlet["renderURL"] varImpl="portletURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_CAMPAIGN_REPORTS}" />
	<@portlet["param"] name="tabs1" value="${tabs1}" />
	<@portlet["param"] name="tabs2" value="${tabs2}" />
	<@portlet["param"] name="campaignId" value="${campaign.getCampaignId()?string}" />
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-reports-for-campaign-forms-were-found"
	iteratorURL=portletURL
	total=searchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.contenttargeting.reports.campaignform.model.CampaignForm"
		modelVar="campaignForm"
	>

		<@liferay_ui["search-container-column-text"]
			name="alias"
			value=campaignForm.getAlias()
		/>

		<@liferay_ui["search-container-column-text"]
			name="event"
			value="${languageUtil.get(locale, campaignForm.getEventType())}"
		/>

		<@liferay_ui["search-container-column-text"]
			name="user-segment"
			value=campaignForm.getUserSegmentName(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			name="count"
			value=campaignForm.getCount()?string
		/>

		<@liferay_ui["search-container-column-date"]
			name="last-update"
			value=campaignForm.getModifiedDate()
		/>
	</@>

	<#if searchContainer.getResults()?has_content>
		<#include "ct_chart.ftl" />
	</#if>

	<@liferay_ui["search-iterator"] />
</@>