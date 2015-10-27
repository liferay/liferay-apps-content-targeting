<#macro consumerTable chartId iterator chartTemplate>

	<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
	<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
	<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
	<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

	<@liferay_ui["search-container"]
	emptyResultsMessage=languageUtil.format(locale, "there-is-not-enough-data-to-generate-a-content-views-report-for-the-campaign-x", name)
	iteratorURL=portletURL
	total=formIterator.getTotal()>

		<@liferay_ui["search-container-results"]
		results=formIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())/>

		<@liferay_ui["search-container-row"]
		className="com.liferay.content.targeting.report.views.by.segment.and.channel.model.CampaignViewsBySegmentAndChannelModel"
		modelVar="campaignMobile">

			<@liferay_ui["search-container-column-text"]
			name="consumer"
			value=campaignMobile.getConsumerName(locale)/>

			<@liferay_ui["search-container-column-text"]
			name="event"
			value="${languageUtil.get(locale, campaignMobile.getEventType())}"/>

			<@liferay_ui["search-container-column-text"]
			name="count"
			value=campaignMobile.getCount()?string/>

			<@liferay_ui["search-container-column-date"]
			name="last-update"
			value=campaignMobile.getModifiedDate()/>
		</@>

		<#if searchContainer.getResults()?has_content>
			<#import chartTemplate as consumerChart />
			<@consumerChart.mobileChart id=chartId data = iterator/>
		</#if>

		<@liferay_ui["search-iterator"] />

	</@>

<p/>

</#macro>