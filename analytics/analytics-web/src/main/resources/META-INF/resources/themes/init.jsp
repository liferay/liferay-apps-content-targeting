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
long[] analyticsReferrerIds = (long[])request.getAttribute("userSegmentIds");
String analyticsReferrerClassName = "com.liferay.content.targeting.model.UserSegment";

if (Validator.isNull(analyticsReferrerIds)) {
	analyticsReferrerIds = new long[] {layout.getPlid()};
	analyticsReferrerClassName = Layout.class.getName();
}

String analyticsReferrerClassPKs = StringUtil.merge(analyticsReferrerIds);

boolean analyticsContentEnabled = AnalyticsUtil.isAnalyticsContentEnabled(layout.getGroupId());
boolean analyticsLinkClickEnabled = AnalyticsUtil.isAnalyticsLinkClickEnabled(layout.getGroupId());
boolean analyticsLinkEnabled = AnalyticsUtil.isAnalyticsLinkEnabled(layout.getGroupId());
boolean analyticsFormEnabled = AnalyticsUtil.isAnalyticsFormEnabled(layout.getGroupId());
String analyticsFormExcludedIdsRegex = AnalyticsUtil.getAnalyticsFormExcludedIdsRegex(layout.getGroupId());
boolean analyticsFormInteractEnabled = AnalyticsUtil.isAnalyticsFormInteractEnabled(layout.getGroupId());
boolean analyticsFormSubmitEnabled = AnalyticsUtil.isAnalyticsFormSubmitEnabled(layout.getGroupId());
boolean analyticsFormViewEnabled = AnalyticsUtil.isAnalyticsFormViewEnabled(layout.getGroupId());
String analyticsLinkExcludedIdsRegex = AnalyticsUtil.getAnalyticsLinkExcludedIdsRegex(layout.getGroupId());
boolean analyticsPageEnabled = AnalyticsUtil.isAnalyticsPageEnabled(layout.getGroupId());
boolean analyticsYoutubeEnabled = AnalyticsUtil.isAnalyticsYoutubeEnabled(layout.getGroupId());
boolean includeAnalytics = AnalyticsUtil.isIncludeAnalytics(layout, request);
%>