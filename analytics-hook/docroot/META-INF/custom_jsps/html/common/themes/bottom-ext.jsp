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

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<aui:script position="inline" use="aui-base">
	var DOC = A.getDoc();

	var trackFormEvent = function(eventType, form) {
		Liferay.Analytics.track(
			eventType,
			{
				elementId: form.attr('id')
			}
		);
	};

	A.all('form').each(A.bind(trackFormEvent, this, 'view'));

	Liferay.on(
		'submitForm',
		function(event) {
			trackFormEvent('submit', event.form);
			Liferay.Analytics.flush();
		}
	);

	var interactedForms = [];

	DOC.delegate(
		['change', 'input'],
		function(event) {
			var form = event.currentTarget;

			var formId = form.attr('id');

			if (interactedForms.indexOf(formId) === -1) {
				interactedForms.push(formId);

				trackFormEvent('fill', form);
			}
		},
		'form'
	);

	Liferay.Analytics.flush();
</aui:script>