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

<%@ include file="/html/portlet/sites_admin/init.jsp" %>

<%
Group liveGroup = (Group)request.getAttribute("site.liveGroup");

UnicodeProperties groupTypeSettings = null;

if (liveGroup != null) {
	groupTypeSettings = liveGroup.getTypeSettingsProperties();
}
else {
	groupTypeSettings = new UnicodeProperties();
}
%>

<h3><liferay-ui:message key="content-targeting-analytics" /></h3>

<div class="alert alert-info">
	<liferay-ui:message arguments="<%= liveGroup.getDescriptiveName(themeDisplay.getLocale()) %>" key="select-the-elements-and-actions-that-will-be-tracked-by-content-targeting-analytics-in-the-site-x" />

	<%
	String checkPortalAnalyticsLabel = LanguageUtil.get(locale, "portal-settings-content-targeting-analytics");
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

<aui:fieldset>
	<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.page.enabled") %>' label="pages" name="TypeSettingsProperties--content.targeting.analytics.page.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.page.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.page.enabled", true) %>' />

	<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.content.enabled") %>' label="content" name="TypeSettingsProperties--content.targeting.analytics.content.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.content.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.content.enabled", true) %>' />

	<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.enabled") %>' id="contentTargetingAnalyticsFormEnabled" label="forms" name="TypeSettingsProperties--content.targeting.analytics.form.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.form.enabled", true) %>' />

	<div class="staging-section" id="<portlet:namespace />formOptions">
		<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view.enabled") %>' label="form-views" name="TypeSettingsProperties--content.targeting.analytics.form.view.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.form.view.enabled", true) %>' />

		<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.interact.enabled") %>' label="form-interactions" name="TypeSettingsProperties--content.targeting.analytics.form.interact.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.interact.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.form.interact.enabled", true) %>' />

		<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit.enabled") %>' label="form-submits" name="TypeSettingsProperties--content.targeting.analytics.form.submit.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.form.submit.enabled", true) %>' />

		<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.enabled") %>' helpMessage="excluded-ids-help" label="excluded-ids" name="TypeSettingsProperties--content.targeting.analytics.form.excluded.ids.regex--" type="text" value='<%= PropertiesParamUtil.getString(groupTypeSettings, request, "content.targeting.analytics.form.excluded.ids.regex", PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.form.excluded.ids.regex")) %>' />
	</div>

	<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.enabled") %>' id="contentTargetingAnalyticsLinkEnabled" label="links" name="TypeSettingsProperties--content.targeting.analytics.link.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.link.enabled", true) %>' />

	<div class="staging-section" id="<portlet:namespace />linkOptions">
		<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.click.enabled") %>' label="link-clicks" name="TypeSettingsProperties--content.targeting.analytics.link.click.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.click.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.link.click.enabled", true) %>' />

		<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.enabled") %>' helpMessage="excluded-ids-help" label="excluded-ids" name="TypeSettingsProperties--content.targeting.analytics.link.excluded.ids.regex--" type="text" value='<%= PropertiesParamUtil.getString(groupTypeSettings, request, "content.targeting.analytics.link.excluded.ids.regex", PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.link.excluded.ids.regex")) %>' />
	</div>

	<aui:input disabled='<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.youtube.enabled") %>' label="youtube-videos" name="TypeSettingsProperties--content.targeting.analytics.youtube.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.youtube.enabled") && PropertiesParamUtil.getBoolean(groupTypeSettings, request, "content.targeting.analytics.youtube.enabled", true) %>' />
</aui:fieldset>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsFormEnabledCheckbox','<portlet:namespace />formOptions');
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsLinkEnabledCheckbox','<portlet:namespace />linkOptions');
</aui:script>