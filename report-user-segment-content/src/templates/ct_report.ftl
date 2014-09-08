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
	emptyResultsMessage=languageUtil.format(locale, "there-is-not-enough-data-to-generate-a-content-views-report-for-the-user-segment-x", name)
	iteratorURL=portletURL
	total=searchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent"
		modelVar="userSegmentContent"
	>

		<@liferay_ui["search-container-column-text"]
			name="title"
			value=userSegmentContent.getTitle(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			name="type"
			value=userSegmentContent.getType(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			name="event"
			value="${languageUtil.get(locale, userSegmentContent.getEventType())}"
		/>

		<@liferay_ui["search-container-column-text"]
			name="count"
			value=userSegmentContent.getCount()?string
		/>

		<@liferay_ui["search-container-column-date"]
			name="last-update"
			value=userSegmentContent.getModifiedDate()
		/>
	</@>

	<#if searchContainer.getResults()?has_content>
		<#include "ct_chart.ftl" />
	</#if>

	<@liferay_ui["search-iterator"] />
</@>