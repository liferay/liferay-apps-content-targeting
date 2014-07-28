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

<@portlet["renderURL"] varImpl="viewUserSegmentsURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
	<@portlet["param"] name="tabs1" value="user-segments" />
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-user-segments-were-found"
	iteratorURL=viewUserSegmentsURL
	rowChecker=rowChecker
	total=userSegmentSearchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=userSegmentSearchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.contenttargeting.model.UserSegment"
		keyProperty="userSegmentId"
		modelVar="userSegment"
	>

	<@liferay_ui["search-container-column-text"]
		name="name"
		value=userSegment.getName(locale)
	/>

		<@liferay_ui["search-container-column-text"]
			name="description"
			value=userSegment.getDescription(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			align="right"
			name=""
		>
			<@liferay_ui["icon-menu"]>
				<@portlet["renderURL"] var="viewUserSegmentReportsURL">
					<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_USER_SEGMENT_REPORTS}" />
					<@portlet["param"] name="redirect" value="${viewUserSegmentsURL}" />
					<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()?string}" />
				</@>

				<@liferay_ui["icon"]
					image="view"
					label=true
					message="reports"
					method="get"
					url="${viewUserSegmentReportsURL}"
				/>

				<#if userSegmentPermission.contains(permissionChecker, userSegment, actionKeys.UPDATE)>
					<@portlet["renderURL"] var="editUserSegmentURL">
						<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_USER_SEGMENT}" />
						<@portlet["param"] name="redirect" value="${viewUserSegmentsURL}" />
						<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()?string}" />
					</@>

					<@liferay_ui["icon"]
						image="edit"
						method="get"
						url="${editUserSegmentURL}"
					/>
				</#if>

				<#if userSegmentPermission.contains(permissionChecker, userSegment, actionKeys.DELETE)>
					<@portlet["actionURL"] name="deleteUserSegment" var="deleteUserSegmentURL">
						<@portlet["param"] name="redirect" value="${viewUserSegmentsURL}" />
						<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()?string}" />
					</@>

					<@liferay_ui["icon-delete"]
						url="${deleteUserSegmentURL}"
					/>
				</#if>

				<#if userSegmentPermission.contains(permissionChecker, userSegment, actionKeys.PERMISSIONS)>
					<@liferay_security["permissionsURL"]
						modelResource="${userSegmentClass.getName()}"
						modelResourceDescription="${userSegment.getName(locale)}"
						resourcePrimKey="${userSegment.getUserSegmentId()}"
						var="permissionsEntryURL"
						windowState="${liferayWindowStatePopUp}"
					/>

					<@liferay_ui["icon"]
						image="permissions"
						method="get"
						url="${permissionsEntryURL}"
						useDialog=true
					/>
				</#if>
			</@>
		</@>
	</@>

	<@liferay_ui["search-iterator"] />
</@>

<@aui["script"] use="liferay-util-list-fields">
	var deleteUserSegments = A.one('#<@portlet["namespace"] />deleteUserSegments');

	A.one('#<@portlet["namespace"] />${searchContainerReference.getId()}SearchContainer').on(
		'click',
		function() {
			var hide = (Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmUserSegment, '<@portlet["namespace"] />allRowIds').length == 0);

			deleteUserSegments.toggle(!hide);
		},
		'input[type=checkbox]'
	);

	deleteUserSegments.on(
		'click',
		function(event) {
			if (confirm('${languageUtil.get(locale, "are-you-sure-you-want-to-delete-this")}')) {
				document.<@portlet["namespace"] />fmUserSegment.<@portlet["namespace"] />userSegmentIds.value = Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmUserSegment, '<@portlet["namespace"] />allRowIds');

				<@portlet["renderURL"] var="redirectURL">
					<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
					<@portlet["param"] name="tabs1" value="user-segments" />
				</@>

				<@portlet["actionURL"] name="deleteUserSegment" var="deleteUserSegmentURL">
					<@portlet["param"] name="redirect" value="${redirectURL}" />
				</@>

				submitForm(document.<@portlet["namespace"] />fmUserSegment, '${deleteUserSegmentURL}');
			}
		}
	);
</@>