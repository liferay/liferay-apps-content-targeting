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

<@portlet["actionURL"] name="simulateUserSegment" var="simulateUserSegmentURL" />

<div id="<@portlet["namespace"] />userSegmentContainer">
	<@aui["form"] action="${simulateUserSegmentURL}" method="post" name="fm" onSubmit="event.preventDefault(); ${renderResponse.getNamespace()}saveUserSegments();">
		<@aui["input"] name="selectedUserSegmentIds" type="hidden" />

		<#if showUserSegmentSearch>
			<div class="row-fluid search-panels">
				<i class="search-panel-icon"></i>

				<div class="search-panels-bar">
					<@aui["input"] cssClass="search-panels-input search-query span12" label="" name="searchUserSegmentPanel" type="text" />
				</div>
			</div>
		</#if>

		<div class="category-wrapper">
			<div class="category-header">
				<div class="category-icon">
					<i class="icon-check"></i>
				</div>
				<div class="category-info">
					<div class="category-title">
						<@liferay_ui["message"] key="matched" />
					</div>
					<div class="category-description">
						<@liferay_ui["message"] key="user-segments" />
					</div>
				</div>
			</div>

			<div class="category-content">
				<#if userSegments?has_content>
					<#list userSegments as userSegment>
						<@aui["input"] cssClass="user-segment" label="${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" name="userSegment${userSegment.getUserSegmentId()}" type="checkbox" checked=simulatedUserSegmentIds?seq_contains(userSegment.getUserSegmentId()) value=userSegment.getUserSegmentId() />
					</#list>
				<#else>
					<div class="alert alert-info">
						<@liferay_ui["message"] key="the-current-user-does-not-match-any-user-segment" />
					</div>
				</#if>
			</div>

			<div class="category-header">
				<div class="category-icon">
					<i class="icon-check-empty"></i>
				</div>
				<div class="category-info">
					<div class="category-title">
						<@liferay_ui["message"] key="other" />
					</div>
					<div class="category-description">
						<@liferay_ui["message"] key="user-segments" />
					</div>
				</div>
			</div>

			<div class="category-content">
				<#list notMatchedUserSegments as userSegment>
					<@portlet["actionURL"] name="simulateUserSegment" var="simulateUserSegmentURL">
						<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()}" />
						<@portlet["param"] name="redirect" value="${currentURL}" />
					</@>

					<@aui["input"] cssClass="user-segment" label="${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" name="userSegment${userSegment.getUserSegmentId()}" type="checkbox" checked=simulatedUserSegmentIds?seq_contains(userSegment.getUserSegmentId()) value=userSegment.getUserSegmentId() />
				</#list>
			</div>
        </div>

		<@aui["button-row"] cssClass="button-holder">
			<@aui["button"] type="submit" value="simulate" />
			<@aui["button"] onClick="${renderResponse.getNamespace()}stopSimulation();" value="stop-simulation" />
		</@>
	</@>
</div>

<@aui["script"] use="aui-toggler,liferay-simulator-search,liferay-util-list-fields">
	var inputNode = A.one('#<@portlet["namespace"] />searchUserSegmentPanel');
	var userSegmentContainer = A.one('#<@portlet["namespace"] />userSegmentContainer');

	var togglerDelegate = new A.TogglerDelegate(
		{
			animated: true,
			closeAllOnExpand: false,
			container: userSegmentContainer,
			content: '.category-content',
			expanded: true,
			header: '.category-header'
		}
	);

	new Liferay.SimulatorSearch(
		{
			contentPanel: userSegmentContainer,
			inputNode: inputNode,
			namespace: '<@portlet["namespace"] />',
			togglerDelegate: togglerDelegate
		}
	);

	<@portlet["namespace"] />saveUserSegments = function() {
		document.<@portlet["namespace"] />fm.<@portlet["namespace"] />selectedUserSegmentIds.value = Liferay.Util.listChecked(document.<@portlet["namespace"] />fm);

		submitUserSegments();
	}

	<@portlet["namespace"] />stopSimulation = function() {
		document.<@portlet["namespace"] />fm.<@portlet["namespace"] />selectedUserSegmentIds.value = '';

		submitUserSegments();
	}

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