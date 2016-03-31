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

<c:if test="<%= contentTrackingActionDisplayContext.isTrackingContentEnabled() %>">

	<%
	String enableLocationPortalLabel = LanguageUtil.get(request, "portal-settings-content-targeting-analytics");

	if (Validator.isNotNull(contentTrackingActionDisplayContext.getPortalSettingsURL())) {
		enableLocationPortalLabel = "<a href=\"" + contentTrackingActionDisplayContext.getPortalSettingsURL() + "\">" + enableLocationPortalLabel + "</a>";
	}

	String enableLocationSiteLabel = LanguageUtil.get(request, "site-settings-content-targeting-analytics");

	if (Validator.isNotNull(contentTrackingActionDisplayContext.getSiteSettingsURL())) {
		enableLocationSiteLabel = "<a href=\"" + contentTrackingActionDisplayContext.getSiteSettingsURL() + "\">" + enableLocationSiteLabel + "</a>";
	}
	%>

	<div class="alert alert-info">
		<strong><liferay-ui:message key="this-metric-will-not-work-properly-because-content-tracking-is-not-enabled" /></strong>

		<liferay-ui:message arguments="<%= new String[] {enableLocationPortalLabel, enableLocationSiteLabel} %>" key="it-can-be-enabled-in-x-or-in-x" translateArguments="<%= false %>" />
	</div>
</c:if>

<aui:input helpMessage="name-help" label="name" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "alias" %>' type="text" value="<%= contentTrackingActionDisplayContext.getAlias() %>">
	<aui:validator name="required" />
</aui:input>

<div class="select-asset-selector">
	<div class="edit-controls">
		<aui:input name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "assetEntryId" %>' type="hidden" value="<%= contentTrackingActionDisplayContext.getAssetEntryId() %>" />

		<h4 class="text-default">
			<liferay-ui:message key="select-the-content-to-be-tracked" />
		</h4>

		<liferay-ui:icon-menu direction="right" id='<%= ContentTargetingUtil.GUID_REPLACEMENT + "assetSelector" %>' message="select-content" showArrow="<%= false %>" showWhenSingleIcon="<%= true %>">

			<%
			for (AssetRendererFactory assetRendererFactory : contentTrackingActionDisplayContext.getSelectableAssetRendererFactories()) {
			%>

				<liferay-ui:icon
					cssClass="asset-selector"
					data="<%= ContentTargetingUtil.getAssetSelectorIconData(request, assetRendererFactory, StringPool.BLANK, true) %>"
					id='<%= ContentTargetingUtil.GUID_REPLACEMENT + "groupId_" + assetRendererFactory.getTypeName(locale, false) %>'
					message="<%= assetRendererFactory.getTypeName(locale, false) %>"
					url="javascript:;"
				/>

			<%
			}
			%>

		</liferay-ui:icon-menu>
	</div>

	<div class="row">
		<div class="col-md-4 <%= (contentTrackingActionDisplayContext.getAssetEntryId() <= 0) ? "hide" : StringPool.BLANK %>" id="<%= renderResponse.getNamespace() + ContentTargetingUtil.GUID_REPLACEMENT + "selectedContentPreview" %>">
			<c:if test="<%= contentTrackingActionDisplayContext.getAssetEntryId() > 0 %>">
				<liferay-util:include page="/asset_entry.jsp" servletContext="<%= application %>" />
			</c:if>
		</div>
	</div>
</div>

<c:if test="<%= contentTrackingActionDisplayContext.getEventTypes().length > 0 %>">
	<aui:select label="event-type" name='<%= ContentTargetingUtil.GUID_REPLACEMENT + "eventType" %>'>

		<%
		for (String curEventType : contentTrackingActionDisplayContext.getEventTypes()) {
		%>

			<aui:option label="<%= curEventType %>" selected="<%= Validator.equals(contentTrackingActionDisplayContext.getEventType(), curEventType) %>" value="<%= curEventType %>" />

		<%
		}
		%>

	</aui:select>
</c:if>

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
				eventName: '_<%= ContentTargetingUtil.GUID_REPLACEMENT %>_selectContent',
				id: 'selectContent' + currentTarget.attr('id'),
				title: currentTarget.attr('data-title'),
				uri: currentTarget.attr('data-href')
			},
			function(event) {
				A.one('#<%= renderResponse.getNamespace() + ContentTargetingUtil.GUID_REPLACEMENT %>assetEntryId').attr('value', event.assetentryid);

				A.one('#<%= renderResponse.getNamespace() + ContentTargetingUtil.GUID_REPLACEMENT %>selectedContentPreview').setContent('<p>' + event.assettitle + ', ' + event.assettype + '</p>');
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