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

<%@ include file="/html/common/init.jsp" %>

<%
long [] analyticsReferrerIds = (long[])request.getAttribute("userSegmentIds");
String analyticsReferrerClassName = "com.liferay.content.targeting.model.UserSegment";

if (Validator.isNull(analyticsReferrerIds)) {
	analyticsReferrerIds = new long[]{layout.getPlid()};
	analyticsReferrerClassName = Layout.class.getName();
}

String analyticsReferrerClassPKs = StringUtil.merge(analyticsReferrerIds);

// See com.liferay.content.targeting.analytics.util.AnalyticsUtil

String analyticsLinkExcludedIdsRegex = StringPool.BLANK;
String analyticsFormExcludedIdsRegex = StringPool.BLANK;

boolean trackAnalytics = false;
boolean trackAnalyticsContent = false;
boolean trackAnalyticsLink = false;
boolean trackAnalyticsLinkClick = false;
boolean trackAnalyticsForm = false;
boolean trackAnalyticsFormInteract = false;
boolean trackAnalyticsFormSubmit = false;
boolean trackAnalyticsFormView = false;
boolean trackAnalyticsPage = false;
boolean trackAnalyticsYoutube = false;

Group analyticsGroup = layout.getGroup();

if (!analyticsGroup.isStagingGroup() && !analyticsGroup.isLayoutSetPrototype() && !analyticsGroup.isLayoutPrototype() && !layout.isTypeControlPanel() && !GetterUtil.getBoolean(request.getAttribute("isSimulatedUserSegments"))) {
	trackAnalytics = true;

	UnicodeProperties analyticsGroupTypeSettingsProperties = analyticsGroup.getParentLiveGroupTypeSettingsProperties();

	if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.content.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.content.enabled"), true)) {
		trackAnalyticsContent = true;
	}

	if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.form.enabled"), true)) {
		trackAnalyticsForm = true;

		analyticsFormExcludedIdsRegex = GetterUtil.getString(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.form.excluded.ids.regex"), PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.form.excluded.ids.regex"));

		if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.interact.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.form.interact.enabled"), true)) {
			trackAnalyticsFormInteract = true;
		}

		if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.form.submit.enabled"), true)) {
			trackAnalyticsFormSubmit = true;
		}

		if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.form.view.enabled"), true)) {
			trackAnalyticsFormView = true;
		}
	}

	if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.link.enabled"), true)) {
		trackAnalyticsLink = true;

		analyticsLinkExcludedIdsRegex = GetterUtil.getString(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.link.excluded.ids.regex"), PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.link.excluded.ids.regex"));

		if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.click.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.link.click.enabled"), true)) {
			trackAnalyticsLinkClick = true;
		}
	}

	if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.page.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.page.enabled"), true)) {
		trackAnalyticsPage = true;
	}

	if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.youtube.enabled") && GetterUtil.getBoolean(analyticsGroupTypeSettingsProperties.getProperty("content.targeting.analytics.youtube.enabled"), true)) {
		trackAnalyticsYoutube = true;
	}
}
%>