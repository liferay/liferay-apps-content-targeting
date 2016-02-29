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
String backURL = ParamUtil.getString(request, "backURL");
String redirect = ParamUtil.getString(request, "redirect");
String reportKey = ParamUtil.getString(request, "reportKey");
long reportInstanceId = ParamUtil.getLong(request, "reportInstanceId");
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

ReportsRegistry reportsRegistry = (ReportsRegistry)request.getAttribute("reportsRegistry");

Report report = reportsRegistry.getReport(reportKey);

ReportInstance reportInstance = null;

if (reportInstanceId > 0) {
	reportInstance = ReportInstanceLocalServiceUtil.fetchReportInstance(reportInstanceId);
}
String reportName = (reportInstance != null) ? reportInstance.getName(locale) : "new-report";

if (Validator.isNull(backURL)) {
	PortletURL backURLObject = liferayPortletResponse.createRenderURL();

	if (Campaign.class.getName().equals(className)) {
		backURLObject.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.VIEW_REPORTS_CAMPAIGN);
		backURLObject.setParameter("campaignId", String.valueOf(classPK));
	}
	else {
		backURLObject.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
		backURLObject.setParameter("userSegmentId", String.valueOf(classPK));
	}

	backURL = backURLObject.toString();
}

Map<String, Object> templateContext = (Map<String, Object>)request.getAttribute("templateContext");
templateContext.put("className", className);
templateContext.put("classPK", classPK);
templateContext.put("reportInstance", reportInstance);
templateContext.put("reportInstanceId", reportInstanceId);
templateContext.put("reportKey", reportKey);
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title="<%= reportName %>"
/>

<liferay-ui:error
	key="com.liferay.content.targeting.exception.InvalidReportException"
	message="there-is-an-error-in-one-of-your-report-elements"
/>

<liferay-portlet:actionURL name="updateReportInstance" var="addReportInstanceURL" />

<aui:form action="<%= addReportInstanceURL %>" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="className" type="hidden" value="<%= className %>" />
	<aui:input name="classPK" type="hidden" value="<%= classPK %>" />
	<aui:input name="reportInstanceId" type="hidden" value="<%= reportInstanceId %>" />
	<aui:input name="reportKey" type="hidden" value="<%= reportKey %>" />
	<aui:input name="saveAndContinue" type="hidden" />

	<aui:model-context bean="<%= reportInstance %>" model="<%= ReportInstance.class %>" />

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

	<aui:input name="name" />

	<aui:input name="description" />

	<%= report.getEditHTML(reportInstance, templateContext) %>

	<aui:button-row>
		<aui:button cssClass="control-button" type="submit" />

		<aui:button cssClass="control-button" onClick="saveAndContinue();" value="save-and-continue" />

		<aui:button cssClass="control-button" href="<%= redirect %>" type="cancel" />
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