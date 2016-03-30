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

<%@ include file="/templates/init.jsp" %>

<c:if test="<%= !trackingContentEnabled %>">
	<div class="alert alert-error">
		<strong><liferay-ui:message key="this-metric-will-not-work-properly-because-content-tracking-is-not-enabled" /></strong>

		<liferay-ui:message
			arguments="<%= enableLocationLabels %>"
			key="it-can-be-enabled-in-x-or-in-x"
			translateArguments="<%= false %>"
		/>
	</div>
</c:if>

<aui:input helpMessage="name-help" label="name" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "alias" %>' type="text" value="<%= alias %>">
	<aui:validator name="required" />
</aui:input>

<div style="background-color:transparent; margin:0px;">
	<div class="control-group select-asset-selector">
		<div class="edit-controls lfr-meta-actions">
			<aui:input
				name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "assetEntryId" %>'
				type="hidden"
				value="<%= assetEntryId %>"
			/>

			<label class="control-label"><liferay-ui:message key="select-the-content-to-be-tracked" /></label>

			<liferay-ui:icon-menu cssClass="select-existing-selector" direction="right" icon='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>' id='<%= ContentTargetingUtil.GUID_REPLACEMENT + "assetSelector" %>' message='<%= LanguageUtil.get(request, "select-content") %>' showWhenSingleIcon="<%= true %>">

				<%
				for (AssetRendererFactory assetRendererFactory : assetRendererFactories) {
				%>

					<liferay-ui:icon
						cssClass="asset-selector"
						data='<%= ContentTargetingUtil.getAssetSelectorIconData(request, assetRendererFactory, "", true) %>'
						id='<%= ContentTargetingUtil.GUID_REPLACEMENT + "groupId_" + assetRendererFactory.getTypeName(locale, false) %>'
						message="<%= assetRendererFactory.getTypeName(locale, false) %>"
						src="<%= assetRendererFactory.getIconPath(renderRequest) %>"
						url="javascript:;"
					/>

				<%
				}
				%>

			</liferay-ui:icon-menu>
		</div>

		<div class="asset-preview <%= cssClass %>" id="<portlet:namespace /><%= ContentTargetingUtil.GUID_REPLACEMENT %>selectedContentPreview">
			<aui:col>
				<img class="asset-image" src="<%= assetImagePreview %>" />
			</aui:col>

			<aui:col>
				<div class="asset-title" id="<portlet:namespace /><%= ContentTargetingUtil.GUID_REPLACEMENT %>assetTitlePreview"><%= assetTitlePreview %></div>
				<div class="asset-type" id="<portlet:namespace /><%= ContentTargetingUtil.GUID_REPLACEMENT %>assetTypePreview"><liferay-ui:message key="type" />: <%= assetTypePreview %></div>
			</aui:col>
		</div>
	</div>
</div>

<c:choose>
	<c:when test="<%= eventTypes.length > 0 %>">
		<aui:select label="event-type" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "eventType" %>'>

			<%
			for (String curEventType : eventTypes) {
			%>

				<aui:option
					label="<%= curEventType %>"
					selected="<%= (eventType == curEventType) %>"
					value="<%= curEventType %>"
				/>

			<%
			}
			%>

		</aui:select>
	</c:when>
	<c:otherwise>

		<%
		for (String curEventType : eventTypes) {
		%>

			<aui:input
				disabled="<%= true %>"
				label="event-type"
				name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "eventType" %>'
				type="text"
				value="<%= curEventType %>"
			/>

		<%
		}
		%>

	</c:otherwise>
</c:choose>

<aui:script use="aui-base">
	var onAssetSelectorClick = function(event) {
		event.preventDefault();

		var currentTarget = event.currentTarget;

		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true
				},
				eventName: '<%= ContentTargetingUtil.GUID_REPLACEMENT %>selectContent',
				id: 'selectContent' + currentTarget.attr('id'),
				title: currentTarget.attr('data-title'),
				uri: currentTarget.attr('data-href')
			},
			function(event) {
				A.one('#<portlet:namespace /><%= ContentTargetingUtil.GUID_REPLACEMENT %>assetEntryId').attr('value', event.assetentryid);

				A.one('#<portlet:namespace /><%= ContentTargetingUtil.GUID_REPLACEMENT %>assetTitlePreview').html(event.assettitle);
				A.one('#<portlet:namespace /><%= ContentTargetingUtil.GUID_REPLACEMENT %>assetTypePreview').html(event.assettype);

				A.one('#<portlet:namespace /><%= ContentTargetingUtil.GUID_REPLACEMENT %>selectedContentPreview').show();
			}
		);
	};

	A.getBody().delegate(
		'click',
		function(event) {
			onAssetSelectorClick(event);
		},
		'.asset-selector a'
	);
</aui:script>