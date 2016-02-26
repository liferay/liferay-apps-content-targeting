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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.content.targeting.analytics.configuration.AnalyticsServiceConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>

<%
AnalyticsServiceConfiguration analyticsServiceConfiguration = (AnalyticsServiceConfiguration)request.getAttribute(AnalyticsServiceConfiguration.class.getName());
%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<h3><liferay-ui:message key="content-targeting-analytics" /></h3>

<div class="alert alert-info">
	<liferay-ui:message key="select-the-elements-and-actions-that-will-be-tracked-by-content-targeting-analytics" />
</div>

<aui:fieldset>
	<aui:input label="pages" name="settings--content.targeting.analytics.page.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.page.enabled", analyticsServiceConfiguration.pageTrackingEnabled()) %>' />

	<aui:input label="content" name="settings--content.targeting.analytics.content.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.content.enabled", analyticsServiceConfiguration.contentTrackingEnabled()) %>' />

	<aui:input id="contentTargetingAnalyticsFormEnabled" label="forms" name="settings--content.targeting.analytics.form.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.enabled", analyticsServiceConfiguration.formTrackingEnabled()) %>' />

	<div class="organization-details" id="<portlet:namespace />formOptions">
		<aui:input label="form-views" name="settings--content.targeting.analytics.form.view.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view.enabled", analyticsServiceConfiguration.formViewTrackingEnabled()) %>' />

		<aui:input label="form-interactions" name="settings--content.targeting.analytics.form.interact.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.interact.enabled", analyticsServiceConfiguration.formInteractionTrackingEnabled()) %>' />

		<aui:input label="form-submits" name="settings--content.targeting.analytics.form.submit.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit.enabled", analyticsServiceConfiguration.formSubmitTrackingEnabled()) %>' />

		<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name="settings--content.targeting.analytics.form.excluded.ids.regex--" type="text" value='<%= PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.form.excluded.ids.regex", analyticsServiceConfiguration.formExcludedIdsRegExp()) %>' />
	</div>

	<aui:input id="contentTargetingAnalyticsLinkEnabled" label="links" name="settings--content.targeting.analytics.link.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.enabled", analyticsServiceConfiguration.linkTrackingEnabled()) %>' />

	<div class="organization-details" id="<portlet:namespace />linkOptions">
		<aui:input label="link-clicks" name="settings--content.targeting.analytics.link.click.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.click.enabled", analyticsServiceConfiguration.linkClickTrackingEnabled()) %>' />

		<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name="settings--content.targeting.analytics.link.excluded.ids.regex--" type="text" value='<%= PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.link.excluded.ids.regex", analyticsServiceConfiguration.linkExcludedIdsRegExp()) %>' />
	</div>

	<aui:input label="youtube-videos" name="settings--content.targeting.analytics.youtube.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.youtube.enabled", analyticsServiceConfiguration.youtubeTrackingEnabled()) %>' />
</aui:fieldset>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsFormEnabledCheckbox','<portlet:namespace />formOptions');
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsLinkEnabledCheckbox','<portlet:namespace />linkOptions');
</aui:script>