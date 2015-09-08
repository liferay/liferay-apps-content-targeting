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

<%@ include file="/html/common/analytics/init.jsp" %>

<%
String analyticsClassName = HtmlUtil.escapeJS(ParamUtil.getString(request, "analyticsClassName"));
String analyticsClassPK = HtmlUtil.escapeJS(ParamUtil.getString(request, "analyticsClassPK"));

analyticsReferrerClassName = HtmlUtil.escapeJS(ParamUtil.getString(request, "analyticsReferrerClassName", analyticsReferrerClassName));
analyticsReferrerClassPKs = HtmlUtil.escapeJS(ParamUtil.getString(request, "analyticsReferrerClassPKs", analyticsReferrerClassPKs));

String analyticsEvent = HtmlUtil.escapeJS(ParamUtil.getString(request, "analyticsEvent", "view"));
%>

<c:if test="<%= trackAnalyticsContent %>">
	<aui:script position="inline">
		Liferay.Analytics.track(
			'<%= analyticsEvent %>',
			{
				className: '<%= analyticsClassName %>',
				classPK: '<%= analyticsClassPK %>',
				referrers: [{
					referrerClassName: '<%= analyticsReferrerClassName %>',
					referrerClassPKs: '<%= analyticsReferrerClassPKs %>'
				}]
			}
		);
	</aui:script>
</c:if>