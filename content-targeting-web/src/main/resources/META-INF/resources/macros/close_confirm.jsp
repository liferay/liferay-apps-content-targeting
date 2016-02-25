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
String confirmMessage = ParamUtil.getString(request, "confirmMessage");
String[] controlCssClasses = ParamUtil.getStringValues(request, "controlCssClasses");

String controlCssClassesSelector = "";
StringBundler stringBundler = new StringBundler(controlCssClasses.length*3 - 1);

for (String cssClass : controlCssClasses) {
	if (stringBundler.length() > 0) {
		stringBundler.append(", ");
	}
	stringBundler.append(".");
	stringBundler.append(cssClass);
}

controlCssClassesSelector = stringBundler.toString();
%>

<aui:input
	name="closeConfirm"
	type="hidden"
	value="true"
/>

<aui:script use="aui-base">
	A.all('<%= controlCssClassesSelector %>').on(
		'mouseup',
		function(event) {
			var closeConfirmElement = A.one('#<portlet:namespace />closeConfirm');

			closeConfirmElement.val('false');
		}
	);

	A.on(
		'beforeunload',
		function(event) {
			var closeConfirmElement = A.one('#<portlet:namespace />closeConfirm');

			if (closeConfirmElement.val() === 'true') {
				event.preventDefault('<liferay-ui:message key="<%= confirmMessage %>" />');
			}
		}
	);
</aui:script>