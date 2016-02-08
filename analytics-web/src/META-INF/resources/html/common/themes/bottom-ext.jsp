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

<c:if test="<%= trackAnalytics %>">

	<%
	String modules = "aui-base";

	if (trackAnalyticsYoutube) {
		modules += ",youtube-iframe";
	}
	%>

	<aui:script position="inline" use="<%= modules %>">
		var trackElementEvent = function(eventType, elementId) {
			Liferay.Analytics.track(
				eventType,
				{
					elementId: elementId,
					referrers: [{
						referrerClassName: '<%= analyticsReferrerClassName %>',
						referrerClassPKs: '<%= analyticsReferrerClassPKs %>'
					}]
				}
			);
		};

		var DOC = A.getDoc();

		<c:if test="<%= trackAnalyticsForm %>">
			var formExcludedIdsRegexStr = '<%= analyticsFormExcludedIdsRegex %>';

			var defaultFormExcludedIdsRegex = /^hrefFm.*/;

			<c:if test="<%= trackAnalyticsFormView %>">
				var trackingForms = [];

				A.all('form').each(
					function(item) {
						var formId = item.attr('id');

						if (!defaultFormExcludedIdsRegex.test(formId) && (!formExcludedIdsRegexStr || !new RegExp(formExcludedIdsRegexStr).test(formId))) {
							trackingForms.push(formId);
						}
					}
				);

				A.Array.each(
					trackingForms,
					A.bind(trackElementEvent, this, 'view')
				);
			</c:if>

			<c:if test="<%= trackAnalyticsFormSubmit %>">
				Liferay.on(
					'submitForm',
					function(event) {
						var formId = event.form.attr('id');

						if (!defaultFormExcludedIdsRegex.test(formId) && (!formExcludedIdsRegexStr || !new RegExp(formExcludedIdsRegexStr).test(formId))) {
							trackElementEvent('submit', formId);
						}
					}
				);
			</c:if>

			<c:if test="<%= trackAnalyticsFormInteract %>">
				var interactedForms = [];

				DOC.delegate(
					['change', 'input'],
					function(event) {
						var form = event.currentTarget;

						var formId = form.attr('id');

						if (!defaultFormExcludedIdsRegex.test(formId) && (!formExcludedIdsRegexStr || !new RegExp(formExcludedIdsRegexStr).test(formId)) && (interactedForms.indexOf(formId) === -1)) {
							interactedForms.push(formId);

							trackElementEvent('interact', formId);
						}
					},
					'form'
				);
			</c:if>
		</c:if>

		<c:if test="<%= trackAnalyticsLinkClick %>">
			DOC.delegate(
				'click',
				function(event) {
					var linkExcludedIdsRegexStr = '<%= analyticsLinkExcludedIdsRegex %>';

					var defaultLinkExcludedIdsRegex = /^yui_.*/;

					var link = event.currentTarget;

					var linkId = link.attr('id');

					if (!defaultLinkExcludedIdsRegex.test(linkId) && (!linkExcludedIdsRegexStr || !new RegExp(linkExcludedIdsRegexStr).test(linkId))) {
						trackElementEvent('click', linkId);

						if (link.hasClass('outbound-link')) {
							event.preventDefault();

							Liferay.Analytics.flush(
								function() {
									document.location = link.attr('href');
								}
							);
						}
					}
				},
				'a'
			);
		</c:if>

		<c:if test="<%= trackAnalyticsYoutube %>">
			var yt = new Liferay.YoutubeIframe(
				{
					on: {
						stateChange: function(event) {
							trackElementEvent(event.state, event.playerId);

							Liferay.Analytics.flush();
						}
					}
				}
			);
		</c:if>

		Liferay.Analytics.flush();
	</aui:script>
</c:if>