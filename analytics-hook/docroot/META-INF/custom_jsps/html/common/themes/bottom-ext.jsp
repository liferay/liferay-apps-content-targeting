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
long[] userSegmentIds = (long[])request.getAttribute("userSegmentIds");

String modules = "aui-base";

if (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.youtube.enabled")) {
	modules += ",youtube-iframe";
}
%>

<aui:script position="inline" use="<%= modules %>">
	var trackElementEvent = function(eventType, elementId) {
		Liferay.Analytics.track(
			eventType,
			{
				className: '<%= Layout.class.getName() %>',
				classPK: '<%= plid %>',
				elementId: elementId,
				referrerClassName: 'com.liferay.contenttargeting.model.UserSegment',
				referrerClassPK: '<%= StringUtil.merge(userSegmentIds) %>'
			}
		);
	};

	var DOC = A.getDoc();

	<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.enabled") %>'>
		var formExcludedIdsRegexStr = '<%= PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.form.excluded.ids.regex") %>';

		<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view.enabled") %>'>
			var trackingForms = [];

			A.all('form').each(
				function(item) {
					var itemId = item.attr('id');

				   if (!formExcludedIdsRegexStr || !new RegExp(formExcludedIdsRegexStr).test(itemId)) {
					   trackingForms.push(itemId);
				   }
				}
			);

			A.Array.each(
				trackingForms,
				A.bind(trackElementEvent, this, 'view')
			);
		</c:if>

		<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit.enabled") %>'>
			Liferay.on(
				'submitForm',
				function(event) {
					var formId = event.form.attr('id');

					if (!formExcludedIdsRegexStr || !new RegExp(formExcludedIdsRegexStr).test(formId)) {
						trackElementEvent('submit', formId);
					}
				}
			);
		</c:if>

		<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.interact.enabled") %>'>
			var interactedForms = [];

			DOC.delegate(
				['change', 'input'],
				function(event) {
					var form = event.currentTarget;

					var formId = form.attr('id');

					if ((!formExcludedIdsRegexStr || !new RegExp(formExcludedIdsRegexStr).test(formId)) && (interactedForms.indexOf(formId) === -1)) {
						interactedForms.push(formId);

						trackElementEvent('interact', formId);
					}
				},
				'form'
			);
		</c:if>
	</c:if>

	<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.enabled") && PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.click.enabled") %>'>
		DOC.delegate(
			'click',
			function(event) {
				var linkExcludedIdsRegexStr = '<%= PrefsPropsUtil.getString(company.getCompanyId(), "content.targeting.analytics.link.excluded.ids.regex") %>';

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

	<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.youtube.enabled") %>'>
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