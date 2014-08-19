<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#if !trackingContentEnabled || !trackingPageEnabled>
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-content-tracking-or-page-tracking-are-not-enabled" /></strong>

		<#assign enableLocationPortalLabel = languageUtil.get(locale, "portal-settings-content-targeting-analytics") />

		<#if portalSettingsURL??>
			<#assign enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>" />
		</#if>

		<#assign enableLocationSiteLabel = languageUtil.get(locale, "site-settings-content-targeting-analytics") />

		<#if siteSettingsURL??>
			<#assign enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>" />
		</#if>

		<#assign enableLocationLabels = [enableLocationPortalLabel, enableLocationSiteLabel] />

		${languageUtil.format(locale, "they-can-be-enabled-in-x-or-in-x", enableLocationLabels)}
	</div>
</#if>

<div class="alert alert-info">
	<#if userSegment??>
		<@liferay_ui["message"] arguments=userSegment.getName(locale) key="users-will-receive-1-point-for-this-user-segment-every-time-they-visit-a-page-or-content-categorized-under-x" />
	<#else>
		<@liferay_ui["message"] key="users-will-receive-1-point-for-this-user-segment-every-time-they-visit-a-page-or-content-categorized-under-this-user-segment" />
	</#if>
</div>

<@aui["input"] helpMessage="set-a-threshold-of-points-that-users-should-meet-in-order-to-be-assigned-to-this-user-segment" label="score-points-threshold" name="scorePoints" type="text" value=scorePoints>
	<@aui["validator"] name="number" />
</@>