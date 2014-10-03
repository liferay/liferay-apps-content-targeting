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
	emptyResultsMessage="there-is-not-enough-data-to-generate-a-report-for-the-newsletters-of-this-campaign"
	iteratorURL=portletURL
>
	<@liferay_ui["search-container-results"]
		results=newsletters
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter"
		modelVar="newsletter"
	>

		<@liferay_ui["search-container-column-text"]
			name="alias"
			value=newsletter.getAlias()
		/>

		<@liferay_ui["search-container-column-text"]
			name="event"
			value="${languageUtil.get(locale, newsletter.getEventType())}"
		/>

		<@liferay_ui["search-container-column-text"]
			name="count"
			value=newsletter.getCount()?string
		/>

		<@liferay_ui["search-container-column-date"]
			name="last-update"
			value=newsletter.getModifiedDate()
		/>
	</@>

	<@liferay_ui["search-iterator"] />
</@>