<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@portlet["defineObjects"] />

<@liferay_theme["defineObjects"] />

<#-- This setting is necessary since we are not loading FTL_liferay.ftl in the reports or rules -->

<#setting number_format="computer">

<@portlet["renderURL"] varImpl="portletURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_USER_SEGMENT_REPORTS}" />
	<@portlet["param"] name="tabs1" value="${tabs1}" />
	<@portlet["param"] name="tabs2" value="${tabs2}" />
	<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()?string}" />
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-reports-for-user-segment-content-were-found"
	iteratorURL=portletURL
	total=searchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.contenttargeting.reports.usersegmentcontent.model.UserSegmentContent"
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