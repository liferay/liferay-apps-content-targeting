<#macro campaignTable chartId iterator>

	<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
	<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
	<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
	<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

	<@liferay_ui["search-container"]
	emptyResultsMessage=languageUtil.format(locale, "there-is-not-enough-data-to-generate-a-content-views-report-for-the-campaign-x", name)
	iteratorURL=portletURL
	total=iterator.getTotal()>

		<@liferay_ui["search-container-results"]
		results=iterator.getResults(searchContainer.getStart(), searchContainer.getEnd())/>

		<@liferay_ui["search-container-row"]
		className="com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile"
		modelVar="campaignMobile">

			<@liferay_ui["search-container-column-text"]
			name="consumer"
			value=campaignMobile.getConsumerName(locale)/>

			<@liferay_ui["search-container-column-text"]
			name="placeholder"
			value=campaignMobile.getPlaceholderName(locale)/>

			<@liferay_ui["search-container-column-text"]
			name="user-segment"
			value=campaignMobile.getUserSegmentName(locale)/>

			<@liferay_ui["search-container-column-text"]
			name="asset"
			value=campaignMobile.getTitle(locale)/>

			<@liferay_ui["search-container-column-text"]
			name="type"
			value=campaignMobile.getType(locale)/>

			<@liferay_ui["search-container-column-text"]
			name="element-id"
			value=campaignMobile.getElementId()?string/>

			<@liferay_ui["search-container-column-text"]
			name="view-count"
			value=campaignMobile.getCount()?string/>

			<@liferay_ui["search-container-column-date"]
			name="view-date"
			value=campaignMobile.getModifiedDate()/>
		</@>

		<#if searchContainer.getResults()?has_content>
			<#import "ct_chart_with_consumer_data.ftl" as campaignChart />
			<@campaignChart.mobileChart id = chartId data = iterator/>
		</#if>

		<@liferay_ui["search-iterator"] />
	</@>

	<p/>
</#macro>