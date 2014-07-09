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

<%@ include file="/html/portlet/portal_settings/init.jsp" %>

<h3><liferay-ui:message key="content-targeting-analytics" /></h3>

<aui:fieldset>
	<aui:input label="form-view" name="settings--content.targeting.analytics.form.view--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view") %>' />

	<aui:input label="form-fill" name="settings--content.targeting.analytics.form.fill--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.fill") %>' />

	<aui:input label="form-submit" name="settings--content.targeting.analytics.form.submit--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit") %>' />

	<aui:input label="page-view" name="settings--content.targeting.analytics.page.view--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.page.view") %>' />

	<aui:input label="web-content-view" name="settings--content.targeting.analytics.web.content.view--" type="checkbox" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.web.content.view") %>' />
</aui:fieldset>