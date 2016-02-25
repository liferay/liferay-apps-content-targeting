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
String fieldName = ParamUtil.getString(request, "fieldName");
%>

<aui:script use="aui-base">
	var formBuilder = A.one('.form-builder-drop-container');

	formBuilder.delegate(
		'blur',
		function() {
			var node = this;

			var headerSpan = node.ancestor('.form-builder-field-content').one('span.field-description-alias');
			var headerInfoSpan = node.ancestor('.form-builder-field-content').one('span.field-description-info');

			if (node.val() && node.val() !== '') {
				var headerValue = node.val();

				if (headerInfoSpan.text() !== '') {
					headerValue += '. ';
				}

				headerSpan.text(headerValue);
			}
			else {
				headerSpan.text('');
			}
		},
		'[name*="<%= fieldName %>"]'
	);

	formBuilder.all('[name*="<%= fieldName %>"]').each(
		function(node) {
			var headerSpan = node.ancestor('.form-builder-field-content').one('span.field-description-alias');
			var headerInfoSpan = node.ancestor('.form-builder-field-content').one('span.field-description-info');

			if (node.val() && node.val() !== '') {
				var headerValue = node.val();

				if (headerInfoSpan.text() !== '') {
					headerValue += '. ';
				}

				headerSpan.text(headerValue);
			}
			else {
				headerSpan.text('');
			}
		}
	);
</aui:script>