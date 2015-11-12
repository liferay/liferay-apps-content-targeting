<#--
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
-->

<#include "../init.ftl" />
<#include "../macros.ftl" />
<#include "../macros_exceptions.ftl" />

<@liferay_ui["header"]
	backURL="${backURL}"
	title='${(report.getName(locale))!"new-report"}'
/>

<@invalidConsumerReportException />

<@portlet["actionURL"] name="updateReportInstance" var="addReportInstanceURL" />

<@aui["form"] action="${addReportInstanceURL}" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="backURL" type="hidden" value="${backURL}" />
	<@aui["input"] name="consumerId" type="hidden" value="${consumerId}" />
	<@aui["input"] name="consumerReportInstanceId" type="hidden" value="${consumerReportInstanceId}" />
	<@aui["input"] name="reportKey" type="hidden" value="${reportKey}" />
	<@aui["input"] name="saveAndContinue" type="hidden" />

	<@invalidNameException />

	<@aui["model-context"] bean=consumerReportInstance model=consumerReportInstanceClass />

	<@invalidNameException />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	${reportEditHtml}

	<@aui["button-row"]>
		<@aui["button"] type="submit" />

		<@aui["button"] type="button" value="save-and-continue" onClick="saveAndContinue();" />

		<@aui["button"] href="${redirect}" type="cancel" />
	</@>

	<@aui["script"] use="aui-toggler,liferay-ct-form-builder">
		saveAndContinue = function() {
			A.one('#<@portlet["namespace"] />saveAndContinue').val('true');

			submitForm(document.<@portlet["namespace"] />fm);
		};

		saveFields = function() {
			A.one('#<@portlet["namespace"] />saveAndContinue').val('false');

			submitForm(document.<@portlet["namespace"] />fm);
		};
	</@>
</@>

<@fieldHeaderListener fieldName="alias" />