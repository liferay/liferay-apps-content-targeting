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
%>

<aui:script position="inline" use="aui-base">
	var trackElementEvent = function(eventType, element) {
		Liferay.Analytics.track(
			eventType,
			{
				className: '<%= Layout.class.getName() %>',
				classPK: '<%= plid %>',
				elementId: element.attr('id'),
				referrerClassName: 'com.liferay.contenttargeting.model.UserSegment',
				referrerClassPK: '<%= StringUtil.merge(userSegmentIds) %>'
			}
		);
	};

	var DOC = A.getDoc();

	<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.view") %>'>
		A.all('form').each(A.bind(trackElementEvent, this, 'view'));
	</c:if>

	<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.submit") %>'>
		Liferay.on(
			'submitForm',
			function(event) {
				trackElementEvent('submit', event.form);
				Liferay.Analytics.flush();
			}
		);
	</c:if>

	<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.form.interact") %>'>
		var interactedForms = [];

		DOC.delegate(
			['change', 'input'],
			function(event) {
				var form = event.currentTarget;

				var formId = form.attr('id');

				if (interactedForms.indexOf(formId) === -1) {
					interactedForms.push(formId);

					trackElementEvent('interact', form);
				}
			},
			'form'
		);
	</c:if>

	<c:if test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.link.click") %>'>
		DOC.delegate(
			'click',
			function(event) {
				event.preventDefault();

				var link = event.currentTarget;

				trackElementEvent('click', link);

				Liferay.Analytics.flush();

				document.location = link.attr('href');
			},
			'a'
		);
	</c:if>

	Liferay.Analytics.flush();
</aui:script>