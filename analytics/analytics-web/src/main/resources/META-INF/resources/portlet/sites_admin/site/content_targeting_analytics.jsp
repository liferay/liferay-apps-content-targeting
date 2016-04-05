<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/portlet/init.jsp" %>

<%
Group liveGroup = (Group)request.getAttribute("site.liveGroup");

long groupId = 0;

if (liveGroup != null) {
	groupId = liveGroup.getGroupId();
}
%>

<p class="text-muted">
	<liferay-ui:message arguments="<%= liveGroup.getDescriptiveName(themeDisplay.getLocale()) %>" key="select-the-elements-and-actions-that-will-be-tracked-by-content-targeting-analytics-in-the-site-x" />
</p>

<%
String checkPortalAnalyticsLabel = LanguageUtil.get(locale, "content-targeting-analytics");

String checkPortalAnalyticsOptionLabel = LanguageUtil.get(locale, "this-option-has-been-disabled-by-the-portal-administrator");

if (PortletPermissionUtil.hasControlPanelAccessPermission(permissionChecker, liveGroup.getGroupId(), PortletKeys.PORTAL_SETTINGS)) {
	PortletURL portalSettingsURL = PortalUtil.getControlPanelPortletURL(request, PortletKeys.PORTAL_SETTINGS, PortletRequest.RENDER_PHASE);

	portalSettingsURL.setParameter("historyKey", "_130_contentTargetingAnalytics");

	checkPortalAnalyticsLabel = "<a href=\"" + portalSettingsURL.toString() + "\">" + checkPortalAnalyticsLabel + "</a>";
}
%>

<p class="text-muted">
	<liferay-ui:message arguments="<%= checkPortalAnalyticsLabel %>" key="check-general-content-targeting-analytics-settings-in-x" />
</p>

<c:if test="<%= liveGroup.isStaged() %>">
	<div class="alert alert-block">
		<liferay-ui:message key="the-selected-elements-and-actions-will-be-tracked-in-the-live-site-only" />
	</div>
</c:if>

<aui:input disabled="<%= !analyticsPageEnabled %>" label="pages" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_PAGE_ENABLED + "--" %>' title="<%= analyticsPageEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsPageEnabled(groupId) %>" />

<aui:input disabled="<%= !analyticsContentEnabled %>" label="content" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_CONTENT_ENABLED + "--" %>' title="<%= analyticsContentEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsContentEnabled(groupId) %>" />

<aui:input disabled="<%= !analyticsFormEnabled %>" id="contentTargetingAnalyticsFormEnabled" label="forms" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_ENABLED + "--" %>' title="<%= analyticsFormEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsFormEnabled(groupId) %>" />

<div id="<portlet:namespace />formOptions">
	<aui:input disabled="<%= !analyticsFormViewEnabled %>" label="form-views" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_VIEW_ENABLED + "--" %>' title="<%= analyticsFormViewEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsFormViewEnabled(groupId) %>" />

	<aui:input disabled="<%= !analyticsFormInteractEnabled %>" label="form-interactions" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_INTERACT_ENABLED + "--" %>' title="<%= analyticsFormInteractEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsFormInteractEnabled(groupId) %>" />

	<aui:input disabled="<%= !analyticsFormSubmitEnabled %>" label="form-submits" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_SUBMIT_ENABLED + "--" %>' title="<%= analyticsFormSubmitEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsFormSubmitEnabled(groupId) %>" />

	<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_EXCLUDED_IDS_REGEX + "--" %>' type="text" value="<%= AnalyticsUtil.getAnalyticsFormExcludedIdsRegex(groupId) %>" />
</div>

<aui:input disabled="<%= !analyticsLinkEnabled %>" id="contentTargetingAnalyticsLinkEnabled" label="links" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_ENABLED + "--" %>' title="<%= analyticsLinkEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsLinkEnabled(groupId) %>" />

<div id="<portlet:namespace />linkOptions">
	<aui:input disabled="<%= !analyticsLinkClickEnabled %>" label="link-clicks" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_CLICK_ENABLED + "--" %>' title="<%= analyticsLinkClickEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsLinkClickEnabled(groupId) %>" />

	<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_EXCLUDED_IDS_REGEX + "--" %>' type="text" value="<%= AnalyticsUtil.getAnalyticsLinkExcludedIdsRegex(groupId) %>" />
</div>

<aui:input disabled="<%= !analyticsYoutubeEnabled %>" label="youtube-videos" name='<%= "TypeSettingsProperties--" + AnalyticsServiceConfigurationKeys.ANALYTICS_YOUTUBE_ENABLED + "--" %>' title="<%= analyticsYoutubeEnabled ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="toggle-switch" value="<%= AnalyticsUtil.isAnalyticsYoutubeEnabled(groupId) %>" />

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsFormEnabled', '<portlet:namespace />formOptions');
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsLinkEnabled', '<portlet:namespace />linkOptions');
</aui:script>