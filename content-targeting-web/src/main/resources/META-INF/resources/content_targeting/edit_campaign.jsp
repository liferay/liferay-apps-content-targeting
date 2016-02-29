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
long campaignId = ParamUtil.getLong(request, "campaignId", 0);
String userSegmentAssetCategoryIdsAsString = GetterUtil.getString(request.getAttribute("userSegmentAssetCategoryIdsAsString"));
String userSegmentAssetCategoryNames = GetterUtil.getString(request.getAttribute("userSegmentAssetCategoryNames"));
String vocabularyGroupIds = GetterUtil.getString(request.getAttribute("vocabularyGroupIds"));
String vocabularyIds = GetterUtil.getString(request.getAttribute("vocabularyIds"));

Campaign campaign = null;

if (campaignId > 0) {
	campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);
}

Calendar endDate = Calendar.getInstance();
Calendar startDate = Calendar.getInstance();

int priority = 1;

String timeZoneId = TimeZoneUtil.getDefault().getID();

if (campaign != null) {
	endDate.setTime(campaign.getEndDate());
	priority = campaign.getPriority();
	startDate.setTime(campaign.getStartDate());
	timeZoneId = campaign.getTimeZoneId();
}
else {
	endDate.add(Calendar.YEAR, 1);
}

String title = "new-campaign";

if (campaign != null) {
	title = campaign.getName(locale);
}

if (Validator.isNull(backURL)) {
	PortletURL backURLObject = liferayPortletResponse.createRenderURL();

	backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);
	backURLObject.setParameter("tabs1", "campaigns");

	backURL = backURLObject.toString();
}
%>

<liferay-ui:header
	backURL="<%= backURL.toString() %>"
	title="<%= title %>"
/>

<liferay-portlet:renderURL var="portletURL">
	<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
	<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(campaignId) %>" />
	<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="updateCampaign" var="addCampaignURL" />

<aui:form action="<%= addCampaignURL %>" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="campaignId" type="hidden" value="<%= String.valueOf(campaignId) %>" />
	<aui:input name="campaignTrackingActions" type="hidden" />
	<aui:input name="saveAndContinue" type="hidden" />

	<aui:model-context bean="<%= campaign %>" model="<%= Campaign.class %>" />

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

	<liferay-util:include page="/macros/user_segment_selector.jsp" servletContext="<%= application %>">
		<liferay-util:param name="assetCategoryIds" value="<%= userSegmentAssetCategoryIdsAsString %>" />
		<liferay-util:param name="assetCategoryNames" value="<%= userSegmentAssetCategoryNames %>" />
		<liferay-util:param name="hiddenInput" value="userSegmentAssetCategoryIds" />
		<liferay-util:param name="vocabularyGroupIds" value="<%= vocabularyGroupIds %>" />
		<liferay-util:param name="vocabularyIds" value="<%= vocabularyIds %>" />
		<liferay-util:param name="warningMessage" value="editing-user-segments-deletes-all-unsaved-campaign-data" />
	</liferay-util:include>

	<aui:input cssClass="slider-input" helpMessage="priority-help" inlineField="<%= true %>" maxlength="3" name="priority" size="2" type="text" value="<%= priority %>" />

	<span class="slider-holder"></span>

	<aui:input name="active" value="<%= true %>" />

	<liferay-ui:panel collapsible="<%= true %>" cssClass="dates-panel" defaultState="open" extended="<%= false %>" helpMessage="" id="datesPanel" persistState="<%= true %>" title="Dates">

		<liferay-ui:error
			key="com.liferay.content.targeting.exception.InvalidDateRangeException"
			message="please-enter-valid-date-range"
		/>

		<aui:input name="startDate" value="<%= startDate %>" />

		<aui:input name="endDate" value="<%= endDate %>" />

		<aui:input helpMessage="time-zone-help" label="time-zone" name="timeZoneId" type="timeZone" value="<%= timeZoneId %>" />
	</liferay-ui:panel>

	<aui:button-row>
		<aui:button cssClass="control-button" type="submit" />

		<aui:button cssClass="control-button" onClick="saveAndContinue();" value="save-and-continue" />

		<aui:button cssClass="control-button" href="<%= redirect %>" type="cancel" />
	</aui:button-row>

	<aui:script use="liferay-input-slider">
		new Liferay.InputSlider(
			{
				inputNode: '#<portlet:namespace />priority'
			}
		);

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

<liferay-util:include page="/macros/close_confirm.jsp" servletContext="<%= application %>">
	<liferay-util:param name="confirmMessage" value="leaving-this-window-deletes-all-unsaved-data" />
	<liferay-util:param name="controlCssClasses" value="control-button,tab" />
</liferay-util:include>