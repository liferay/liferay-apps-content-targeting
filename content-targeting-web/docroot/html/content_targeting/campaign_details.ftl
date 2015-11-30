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

<@portlet["actionURL"] name="updateCampaign" var="addCampaignURL" />

<@aui["form"] action="${addCampaignURL}" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="campaignId" type="hidden" value=campaignId />
	<@aui["input"] name="campaignTrackingActions" type="hidden" />
	<@aui["input"] name="saveAndContinue" type="hidden" />

	<@aui["model-context"] bean=campaign model=campaignClass />

	<@invalidNameException />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	<@userSegmentSelector
		assetCategoryIds="${userSegmentAssetCategoryIdsAsString}"
		assetCategoryNames="${userSegmentAssetCategoryNames}"
		hiddenInput="userSegmentAssetCategoryIds"
		vocabularyGroupIds="${vocabularyGroupIds}"
		vocabularyIds="${vocabularyIds}"
		warningMessage="editing-user-segments-deletes-all-unsaved-campaign-data"
	/>

	<@aui["input"] cssClass="slider-input" helpMessage="priority-help" inlineField=true name="priority" size="2" maxlength="3" type="text" value="${priority}" />

	<span class="slider-holder"></span>

	<@aui["input"] name="active" value=true />

	<@liferay_ui["panel"] cssClass="dates-panel" collapsible=true defaultState="open" extended=false id="datesPanel" helpMessage="" persistState=true title="Dates">
		<@invalidDateRangeException />

		<@aui["input"] name="startDate" value=startDate />

		<@aui["input"] name="endDate" value=endDate />

		<@aui["input"] helpMessage="time-zone-help" label="time-zone" name="timeZoneId" type="timeZone" value=timeZoneId />
	</@>

	<@aui["button-row"]>
		<@aui["button"] cssClass="control-button" type="submit" />

		<@aui["button"] cssClass="control-button" type="button" value="save-and-continue" onClick="saveAndContinue();" />

		<@aui["button"] cssClass="control-button" href="${redirect}" type="cancel" />
	</@>

	<@aui["script"] use="liferay-input-slider">
		new Liferay.InputSlider(
			{
				inputNode: '#<@portlet["namespace"] />priority'
			}
		);

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

<@closeConfirm confirmMessage="leaving-this-window-deletes-all-unsaved-data" controlCssClasses=["control-button"] />