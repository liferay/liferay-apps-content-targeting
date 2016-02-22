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
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/staging" prefix="liferay-staging" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<h3><liferay-ui:message key="content-targeting-analytics" /></h3>

<div class="alert alert-info">
	<liferay-ui:message key="select-the-elements-and-actions-that-will-be-tracked-by-content-targeting-analytics" />
</div>

<aui:fieldset>
	<aui:input label="pages" name="settings--content.targeting.analytics.page.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.page.enabled") %>' />

	<aui:input label="content" name="settings--content.targeting.analytics.content.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.content.enabled") %>' />

	<aui:input id="contentTargetingAnalyticsFormEnabled" label="forms" name="settings--content.targeting.analytics.form.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.enabled") %>' />

	<div class="organization-details" id="<portlet:namespace />formOptions">
		<aui:input label="form-views" name="settings--content.targeting.analytics.form.view.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view.enabled") %>' />

		<aui:input label="form-interactions" name="settings--content.targeting.analytics.form.interact.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.interact.enabled") %>' />

		<aui:input label="form-submits" name="settings--content.targeting.analytics.form.submit.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit.enabled") %>' />

		<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name="settings--content.targeting.analytics.form.excluded.ids.regex--" type="text" value='<%= PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.form.excluded.ids.regex") %>' />
	</div>

	<aui:input id="contentTargetingAnalyticsLinkEnabled" label="links" name="settings--content.targeting.analytics.link.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.enabled") %>' />

	<div class="organization-details" id="<portlet:namespace />linkOptions">
		<aui:input label="link-clicks" name="settings--content.targeting.analytics.link.click.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.click.enabled") %>' />

		<aui:input helpMessage="excluded-ids-help" label="excluded-ids" name="settings--content.targeting.analytics.link.excluded.ids.regex--" type="text" value='<%= PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.link.excluded.ids.regex") %>' />
	</div>

	<aui:input label="youtube-videos" name="settings--content.targeting.analytics.youtube.enabled--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.youtube.enabled") %>' />
</aui:fieldset>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsFormEnabledCheckbox','<portlet:namespace />formOptions');
	Liferay.Util.toggleBoxes('<portlet:namespace />contentTargetingAnalyticsLinkEnabledCheckbox','<portlet:namespace />linkOptions');
</aui:script>