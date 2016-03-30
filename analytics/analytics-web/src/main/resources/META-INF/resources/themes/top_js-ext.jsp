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

<c:if test="<%= trackAnalytics %>">
	<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/analytics.min.js", "minifierBundleId=content.targeting.files", javaScriptLastModified)) %>" type="text/javascript"></script>

	<!-- <script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/analytics.js", "minifierBundleId=content.targeting.files", javaScriptLastModified)) %>" type="text/javascript"></script> -->

	<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/liferay-analytics-api.js", "", javaScriptLastModified)) %>" type="text/javascript"></script>

	<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/integrations/liferay-analytics-processor.js", "", javaScriptLastModified)) %>" type="text/javascript"></script>

	<script>
		Liferay.Analytics.initialize(
			{
				'LiferayAnalyticsProcessor':
				{
					interval: <%= PropsUtil.get("analytics.flush.interval") %>,
					uri: '<%= request.getAttribute("analyticsProcessorURI") %>'
				}
			}
		);

		<c:if test="<%= trackAnalyticsPage %>">
			Liferay.Analytics.track(
				'view',
				{
					className: '<%= Layout.class.getName() %>',
					classPK: '<%= layout.getPlid() %>',
					referrers: [{
						referrerClassName: '<%= analyticsReferrerClassName %>',
						referrerClassPKs: '<%= analyticsReferrerClassPKs %>'
					}]
				}
			);
		</c:if>

		<c:if test="<%= trackAnalyticsYoutube %>">
			var A = AUI();

			A.applyConfig(
				{
					modules: {
						'youtube-iframe': {
							fullpath: '<%= HtmlUtil.escapeJS(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/integrations/youtube_iframe.js", "", javaScriptLastModified)) %>',
							requires: [
								'aui-base'
							]
						}
					}
				}
			)
		</c:if>
	</script>
</c:if>