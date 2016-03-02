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
ContentTargetingEditCampaignDisplayContext contentTargetingEditCampaignDisplayContext = new ContentTargetingEditCampaignDisplayContext(liferayPortletResponse, portletConfig, request);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingEditCampaignDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingEditCampaignDisplayContext.getCampaignTitle());
%>

<portlet:renderURL var="portletURL">
	<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
	<portlet:param name="className" value="<%= Campaign.class.getName() %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(contentTargetingEditCampaignDisplayContext.getCampaignId()) %>" />
	<portlet:param name="campaignId" value="<%= String.valueOf(contentTargetingEditCampaignDisplayContext.getCampaignId()) %>" />
</portlet:renderURL>

<portlet:actionURL name="updateCampaign" var="addCampaignURL" />

<aui:form action="<%= addCampaignURL %>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<aui:input name="redirect" type="hidden" value="<%= contentTargetingEditCampaignDisplayContext.getRedirect() %>" />
	<aui:input name="campaignId" type="hidden" value="<%= String.valueOf(contentTargetingEditCampaignDisplayContext.getCampaignId()) %>" />
	<aui:input name="campaignTrackingActions" type="hidden" />
	<aui:input name="saveAndContinue" type="hidden" />

	<aui:model-context bean="<%= contentTargetingEditCampaignDisplayContext.getCampaign() %>" model="<%= Campaign.class %>" />

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

			<liferay-util:include page="/macros/user_segment_selector.jsp" servletContext="<%= application %>">
				<liferay-util:param name="assetCategoryIds" value="<%= contentTargetingEditCampaignDisplayContext.getUserSegmentAssetCategoryIdsAsString() %>" />
				<liferay-util:param name="assetCategoryNames" value="<%= contentTargetingEditCampaignDisplayContext.getUserSegmentAssetCategoryNames() %>" />
				<liferay-util:param name="hiddenInput" value="userSegmentAssetCategoryIds" />
				<liferay-util:param name="vocabularyGroupIds" value="<%= contentTargetingEditCampaignDisplayContext.getVocabularyGroupIds() %>" />
				<liferay-util:param name="vocabularyIds" value="<%= contentTargetingEditCampaignDisplayContext.getVocabularyIds() %>" />
				<liferay-util:param name="warningMessage" value="editing-user-segments-deletes-all-unsaved-campaign-data" />
			</liferay-util:include>

			<aui:input cssClass="slider-input" helpMessage="priority-help" inlineField="<%= true %>" maxlength="3" name="priority" size="2" type="text" value="<%= contentTargetingEditCampaignDisplayContext.getPriority() %>" />

			<span class="slider-holder"></span>

			<aui:input name="active" type="toggle-switch" value="<%= contentTargetingEditCampaignDisplayContext.isActiveCampaign() %>" />
		</aui:fieldset>

		<aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" cssClass="dates-panel" label="Dates">
			<liferay-ui:error key="com.liferay.content.targeting.exception.InvalidDateRangeException" message="please-enter-valid-date-range" />

			<aui:input name="startDate" value="<%= contentTargetingEditCampaignDisplayContext.getStartDate() %>" />

			<aui:input name="endDate" value="<%= contentTargetingEditCampaignDisplayContext.getEndDate() %>" />

			<aui:input helpMessage="time-zone-help" label="time-zone" name="timeZoneId" type="timeZone" value="<%= contentTargetingEditCampaignDisplayContext.getTimeZoneId() %>" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />

		<aui:button cssClass="btn-lg" onClick="saveAndContinue();" value="save-and-continue" />

		<aui:button cssClass="btn-lg" href="<%= contentTargetingEditCampaignDisplayContext.getRedirect() %>" type="cancel" />
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