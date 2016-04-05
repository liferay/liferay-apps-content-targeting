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

<p class="text-muted">
	<liferay-ui:message key="select-the-elements-and-actions-that-will-be-tracked-by-content-targeting-analytics" />
</p>

<aui:fieldset>
	<aui:input label="pages" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_PAGE_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsPageEnabled %>" />

	<aui:input label="content" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_CONTENT_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsContentEnabled %>" />

	<aui:input id="contentTargetingAnalyticsFormEnabled" label="forms" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsFormEnabled %>" />

	<div id="<portlet:namespace />formOptions">
		<aui:input label="form-views" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_VIEW_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsFormViewEnabled %>" />

		<aui:input label="form-interactions" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_INTERACT_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsFormInteractEnabled %>" />

		<aui:input label="form-submits" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_SUBMIT_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsFormSubmitEnabled %>" />

		<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_EXCLUDED_IDS_REGEX + "--" %>' type="text" value="<%= analyticsFormExcludedIdsRegex %>" />
	</div>

	<aui:input id="contentTargetingAnalyticsLinkEnabled" label="links" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsLinkEnabled %>" />

	<div id="<portlet:namespace />linkOptions">
		<aui:input label="link-clicks" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_CLICK_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsLinkClickEnabled %>" />

		<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_EXCLUDED_IDS_REGEX + "--" %>' type="text" value="<%= analyticsLinkExcludedIdsRegex %>" />
	</div>

	<aui:input label="youtube-videos" name='<%= "settings--" + AnalyticsServiceConfigurationKeys.ANALYTICS_YOUTUBE_ENABLED + "--" %>' type="toggle-switch" value="<%= analyticsYoutubeEnabled %>" />
</aui:fieldset>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsFormEnabledCheckbox','<portlet:namespace />formOptions');
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsLinkEnabledCheckbox','<portlet:namespace />linkOptions');
</aui:script>