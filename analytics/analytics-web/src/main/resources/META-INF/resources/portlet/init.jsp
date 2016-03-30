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

<%@ include file="/init.jsp" %>

<%
boolean analyticsContentEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_CONTENT_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_CONTENT_ENABLED);
boolean analyticsLinkClickEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_CLICK_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_LINK_CLICK_ENABLED);
boolean analyticsLinkEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_LINK_ENABLED);
boolean analyticsFormEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_FORM_ENABLED);
String analyticsFormExcludedIdsRegex = PrefsPropsUtil.getString(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_EXCLUDED_IDS_REGEX, AnalyticsServiceConfigurationValues.ANALYTICS_FORM_EXCLUDED_IDS_REGEX);
boolean analyticsFormInteractEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_INTERACT_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_FORM_INTERACT_ENABLED);
boolean analyticsFormSubmitEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_SUBMIT_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_FORM_SUBMIT_ENABLED);
boolean analyticsFormViewEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_VIEW_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_FORM_VIEW_ENABLED);
String analyticsLinkExcludedIdsRegex = PrefsPropsUtil.getString(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_EXCLUDED_IDS_REGEX, AnalyticsServiceConfigurationValues.ANALYTICS_LINK_EXCLUDED_IDS_REGEX);
boolean analyticsPageEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_PAGE_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_PAGE_ENABLED);
boolean analyticsYoutubeEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), AnalyticsServiceConfigurationKeys.ANALYTICS_YOUTUBE_ENABLED, AnalyticsServiceConfigurationValues.ANALYTICS_YOUTUBE_ENABLED);
%>