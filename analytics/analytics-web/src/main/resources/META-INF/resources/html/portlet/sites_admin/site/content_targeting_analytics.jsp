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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.content.targeting.analytics.configuration.AnalyticsServiceConfiguration" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.model.*" %>
<%@ page import="com.liferay.portal.kernel.model.impl.*" %>
<%@ page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortletKeys" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropertiesParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeProperties" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
AnalyticsServiceConfiguration analyticsServiceConfiguration = (AnalyticsServiceConfiguration)request.getAttribute(AnalyticsServiceConfiguration.class.getName());

Group liveGroup = (Group)request.getAttribute("site.liveGroup");

UnicodeProperties groupTypeSettings = null;

if (liveGroup != null) {
	groupTypeSettings = liveGroup.getTypeSettingsProperties();
}
else {
	groupTypeSettings = new UnicodeProperties();
}

boolean trackAnalyticsContent = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.content.enabled", analyticsServiceConfiguration.contentTrackingEnabled());
boolean trackAnalyticsLink = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.enabled", analyticsServiceConfiguration.linkTrackingEnabled());
boolean trackAnalyticsLinkClick = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.click.enabled", analyticsServiceConfiguration.linkClickTrackingEnabled());
boolean trackAnalyticsForm = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.enabled", analyticsServiceConfiguration.formTrackingEnabled());
boolean trackAnalyticsFormInteract = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.interact.enabled", analyticsServiceConfiguration.formInteractionTrackingEnabled());
boolean trackAnalyticsFormSubmit = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit.enabled", analyticsServiceConfiguration.formSubmitTrackingEnabled());
boolean trackAnalyticsFormView = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view.enabled", analyticsServiceConfiguration.formViewTrackingEnabled());
boolean trackAnalyticsPage = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.page.enabled", analyticsServiceConfiguration.pageTrackingEnabled());
boolean trackAnalyticsYoutube = PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.youtube.enabled", analyticsServiceConfiguration.youtubeTrackingEnabled());
%>

<h3><liferay-ui:message key="content-targeting-analytics" /></h3>

<div class="alert alert-info">
	<liferay-ui:message arguments="<%= liveGroup.getDescriptiveName(themeDisplay.getLocale()) %>" key="select-the-elements-and-actions-that-will-be-tracked-by-content-targeting-analytics-in-the-site-x" />

	<%
	String checkPortalAnalyticsLabel = LanguageUtil.get(locale, "portal-settings-content-targeting-analytics");
	String checkPortalAnalyticsOptionLabel = LanguageUtil.get(locale, "this-option-has-been-disabled-by-the-portal-administrator");
	%>

	<c:if test="<%= PortletPermissionUtil.hasControlPanelAccessPermission(permissionChecker, liveGroup.getGroupId(), PortletKeys.PORTAL_SETTINGS) %>">
		<liferay-portlet:renderURL plid="<%= PortalUtil.getControlPanelPlid(company.getCompanyId()) %>" portletName="<%= PortletKeys.PORTAL_SETTINGS %>" var="portalSettingsURL">
			<liferay-portlet:param name="historyKey" value="_130_contentTargetingAnalytics" />
		</liferay-portlet:renderURL>

		<%
		checkPortalAnalyticsLabel = "<a href=\"" + portalSettingsURL + "\">" + checkPortalAnalyticsLabel + "</a>";
		%>

	</c:if>

	<liferay-ui:message arguments="<%= checkPortalAnalyticsLabel %>" key="check-general-content-targeting-analytics-settings-in-x" />
</div>

<c:if test="<%= liveGroup.isStaged() %>">
	<div class="alert alert-block">
		<liferay-ui:message key="the-selected-elements-and-actions-will-be-tracked-in-the-live-site-only" />
	</div>
</c:if>

<aui:fieldset>
	<aui:input disabled="<%= !trackAnalyticsPage %>" label="pages" name="TypeSettingsProperties--content.targeting.analytics.page.enabled--" title="<%= trackAnalyticsPage ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsPage && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.page.enabled", analyticsServiceConfiguration.pageTrackingEnabled()) %>' />

	<aui:input disabled="<%= !trackAnalyticsContent %>" label="content" name="TypeSettingsProperties--content.targeting.analytics.content.enabled--" title="<%= trackAnalyticsContent ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsContent && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.content.enabled", analyticsServiceConfiguration.contentTrackingEnabled()) %>' />

	<aui:input disabled="<%= !trackAnalyticsForm %>" id="contentTargetingAnalyticsFormEnabled" label="forms" name="TypeSettingsProperties--content.targeting.analytics.form.enabled--" title="<%= trackAnalyticsForm ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsForm && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.form.enabled", analyticsServiceConfiguration.formTrackingEnabled()) %>' />

	<div class="staging-section" id="<portlet:namespace />formOptions">
		<aui:input disabled="<%= !trackAnalyticsFormView %>" label="form-views" name="TypeSettingsProperties--content.targeting.analytics.form.view.enabled--" title="<%= trackAnalyticsFormView ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsFormView && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.form.view.enabled", analyticsServiceConfiguration.formViewTrackingEnabled()) %>' />

		<aui:input disabled="<%= !trackAnalyticsFormInteract %>" label="form-interactions" name="TypeSettingsProperties--content.targeting.analytics.form.interact.enabled--" title="<%= trackAnalyticsFormInteract ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsFormInteract && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.form.interact.enabled", analyticsServiceConfiguration.formInteractionTrackingEnabled()) %>' />

		<aui:input disabled="<%= !trackAnalyticsFormSubmit %>" label="form-submits" name="TypeSettingsProperties--content.targeting.analytics.form.submit.enabled--" title="<%= trackAnalyticsFormSubmit ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsFormSubmit && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.form.submit.enabled", analyticsServiceConfiguration.formSubmitTrackingEnabled()) %>' />

		<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name="TypeSettingsProperties--content.targeting.analytics.form.excluded.ids.regex--" type="text" value='<%= PropertiesParamUtil.getString(groupTypeSettings, request, "content.targeting.analytics.form.excluded.ids.regex", PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.form.excluded.ids.regex", analyticsServiceConfiguration.formExcludedIdsRegExp())) %>' />
	</div>

	<aui:input disabled="<%= !trackAnalyticsLink %>" id="contentTargetingAnalyticsLinkEnabled" label="links" name="TypeSettingsProperties--content.targeting.analytics.link.enabled--" title="<%= trackAnalyticsLink ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsLink && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.link.enabled", analyticsServiceConfiguration.linkTrackingEnabled()) %>' />

	<div class="staging-section" id="<portlet:namespace />linkOptions">
		<aui:input disabled="<%= !trackAnalyticsLinkClick %>" label="link-clicks" name="TypeSettingsProperties--content.targeting.analytics.link.click.enabled--" title="<%= trackAnalyticsLinkClick ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsLinkClick && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.link.click.enabled", analyticsServiceConfiguration.linkClickTrackingEnabled()) %>' />

		<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name="TypeSettingsProperties--content.targeting.analytics.link.excluded.ids.regex--" type="text" value='<%= PropertiesParamUtil.getString(groupTypeSettings, request, "content.targeting.analytics.link.excluded.ids.regex", PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.link.excluded.ids.regex", analyticsServiceConfiguration.linkExcludedIdsRegExp())) %>' />
	</div>

	<aui:input disabled="<%= !trackAnalyticsYoutube %>" label="youtube-videos" name="TypeSettingsProperties--content.targeting.analytics.youtube.enabled--" title="<%= trackAnalyticsYoutube ? StringPool.BLANK : checkPortalAnalyticsOptionLabel %>" type="checkbox" value='<%= trackAnalyticsYoutube && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.youtube.enabled", analyticsServiceConfiguration.youtubeTrackingEnabled()) %>' />
</aui:fieldset>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsFormEnabledCheckbox','<portlet:namespace />formOptions');
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsLinkEnabledCheckbox','<portlet:namespace />linkOptions');
</aui:script>