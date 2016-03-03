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
ContentTargetingEditReportDisplayContext contentTargetingEditReportDisplayContext = new ContentTargetingEditReportDisplayContext(liferayPortletResponse, portletConfig, request);

String className = contentTargetingEditReportDisplayContext.getClassName();

Report report = contentTargetingEditReportDisplayContext.getReport();

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingEditReportDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingEditReportDisplayContext.getReportTitle());
%>

<liferay-ui:error
	key="com.liferay.content.targeting.exception.InvalidReportException"
	message="there-is-an-error-in-one-of-your-report-elements"
/>

<liferay-portlet:actionURL name="updateReportInstance" var="addReportInstanceURL" />

<aui:form action="<%= addReportInstanceURL %>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<aui:input name="redirect" type="hidden" value="<%= contentTargetingEditReportDisplayContext.getRedirect() %>" />
	<aui:input name="backURL" type="hidden" value="<%= contentTargetingEditReportDisplayContext.getBackURL() %>" />
	<aui:input name="className" type="hidden" value="<%= className %>" />
	<aui:input name="classPK" type="hidden" value="<%= contentTargetingEditReportDisplayContext.getClassPK() %>" />
	<aui:input name="reportInstanceId" type="hidden" value="<%= contentTargetingEditReportDisplayContext.getReportInstanceId() %>" />
	<aui:input name="reportKey" type="hidden" value="<%= contentTargetingEditReportDisplayContext.getReportKey() %>" />
	<aui:input name="saveAndContinue" type="hidden" />

	<aui:model-context bean="<%= contentTargetingEditReportDisplayContext.getReportInstance() %>" model="<%= ReportInstance.class %>" />

	<liferay-ui:error key="com.liferay.content.targeting.exception.InvalidNameException">
		<c:choose>
			<c:when test="<%= ((InvalidNameException)errorException).isEmpty() %>">
				<liferay-ui:message key="the-name-can-not-be-empty" />
			</c:when>
			<c:when test="<%= ((InvalidNameException)errorException).isDuplicated() %>">
				<liferay-ui:message key="this-name-is-already-in-use-please-choose-a-different-one" />
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="please-enter-a-valid-name" />
			</c:otherwise>
		</c:choose>
	</liferay-ui:error>

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input name="name" />

			<aui:input name="description" />
		</aui:fieldset>

		<aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" helpMessage="metrics-help" label="metrics">
			<c:if test="<%= (report != null) && (contentTargetingEditReportDisplayContext.getReportInstance() != null) %>">
				<%= report.getEditHTML(contentTargetingEditReportDisplayContext.getReportInstance(), contentTargetingEditReportDisplayContext.getTemplateContext()) %>
			</c:if>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />

		<aui:button cssClass="btn-lg" onClick="saveAndContinue();" value="save-and-continue" />

		<aui:button cssClass="btn-lg" href="<%= contentTargetingEditReportDisplayContext.getRedirect() %>" type="cancel" />
	</aui:button-row>

	<aui:script use="aui-toggler,liferay-ct-form-builder">
		saveAndContinue = function() {
			A.one('#<portlet:namespace />saveAndContinue').val('true');

			submitForm(document.<portlet:namespace />fm);
		};

		saveFields = function() {
			A.one('#<portlet:namespace />saveAndContinue').val('false');

			submitForm(document.<portlet:namespace />fm);
		};
	</aui:script>
</aui:form>

<liferay-util:include page="/macros/field_header_listener.jsp" servletContext="<%= application %>">
	<liferay-util:param name="fieldName" value="alias" />
</liferay-util:include>

<liferay-util:include page="/macros/close_confirm.jsp" servletContext="<%= application %>">
	<liferay-util:param name="confirmMessage" value="leaving-this-window-deletes-all-unsaved-data" />
	<liferay-util:param name="controlCssClasses" value="control-button,tab" />
</liferay-util:include>