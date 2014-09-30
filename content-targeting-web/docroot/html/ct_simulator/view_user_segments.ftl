<#--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
<#include "macros.ftl" />

<@portlet["actionURL"] name="simulateUserSegment" var="simulateUserSegmentURL" />

<div id="<@portlet["namespace"] />userSegmentContainer">
	<@aui["form"] action="${simulateUserSegmentURL}" method="post" name="fm" onSubmit="event.preventDefault(); ${renderResponse.getNamespace()}saveUserSegments();">
		<@aui["input"] name="selectedUserSegmentIds" type="hidden" />
		<@aui["input"] name="stopSimulation" type="hidden" value="false" />

		<@renderSimulatorLists
			containerId="userSegmentContainer"
			elements=userSegments
			emptyMessage=languageUtil.get(locale, "the-current-user-does-not-belong-to-any-user-segment")
			name="user-segment"
			notMatchedElements=notMatchedUserSegments
			showSearch=showUserSegmentSearch
			simulatedElementsPKs=simulatedUserSegmentIds
		/>

		<@aui["button-row"] cssClass="button-holder">
			<@aui["button"] type="submit" value="simulate" />
			<@aui["button"] name="stopSimulationButton" value="stop-simulation" />
		</@>
	</@>
</div>

<@aui["script"] use="aui-toggler,liferay-simulator-search,liferay-util-list-fields">
	<@portlet["namespace"] />saveUserSegments = function() {
		document.<@portlet["namespace"] />fm.<@portlet["namespace"] />selectedUserSegmentIds.value = Liferay.Util.listChecked(document.<@portlet["namespace"] />fm);

		submitUserSegments();
	}

	var stopSimulationButton = A.one('#<@portlet["namespace"] />stopSimulationButton');

	stopSimulationButton.on(
		'click',
		function(event) {
			document.<@portlet["namespace"] />fm.<@portlet["namespace"] />stopSimulation.value = 'true';

			submitUserSegments();
		}
	);

	submitUserSegments = function() {
		var loadingMask = A.getBody().plug(A.LoadingMask).loadingmask;

		Liferay.Dockbar._togglePanel('simulatorPanel');

		loadingMask.show();

		var fm = A.one('#<@portlet["namespace"] />fm');

		A.io.request(
			fm.attr('action'),
			{
				dataType: 'JSON',
				form: {
					id: fm.attr('id')
				},
				after: {
					success: function(event, id, obj) {
						var response = this.get('responseData');

						loadingMask.hide();

					    window.location.href = '${refreshURL}';
					},
					failure: function(event) {
						loadingMask.hide();

						Liferay.Dockbar._togglePanel('simulatorPanel');
					}
				}
			}
		);
	}
</@>