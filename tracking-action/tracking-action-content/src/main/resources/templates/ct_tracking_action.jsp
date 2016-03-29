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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.asset.kernel.model.AssetRendererFactory" %>
<%@ page import="com.liferay.content.targeting.util.ContentTargetingUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
Map<String, Object> displayContext = (Map<String, Object>)request.getAttribute("displayContext");

String alias = GetterUtil.getString(displayContext.get("alias"), "");
long assetEntryId = GetterUtil.getLong(displayContext.get("assetEntryId"), 0L);
List<AssetRendererFactory> assetRendererFactories = (List<AssetRendererFactory>)displayContext.get("assetRendererFactories");
String assetImagePreview = GetterUtil.getString(displayContext.get("assetImagePreview"));
String assetTitlePreview = GetterUtil.getString(displayContext.get("assetTitlePreview"));
String assetTypePreview = GetterUtil.getString(displayContext.get("assetTypePreview"));
String eventType = GetterUtil.getString(displayContext.get("eventType"), "view");
String[] eventTypes = GetterUtil.getStringValues(displayContext.get("eventTypes"), new String[] {"view"});
boolean trackingContentEnabled = GetterUtil.getBoolean(displayContext.get("trackingContentEnabled"), false);

String enableLocationPortalLabel = LanguageUtil.get(request, "portal-settings-content-targeting-analytics");
String enableLocationSiteLabel = LanguageUtil.get(request, "site-settings-content-targeting-analytics");

String portalSettingsURL = GetterUtil.getString(displayContext.get("portalSettingsURL"));
String siteSettingsURL = GetterUtil.getString(displayContext.get("siteSettingsURL"));

if (Validator.isNotNull(portalSettingsURL)) {
	enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>";
}

if (Validator.isNotNull(siteSettingsURL)) {
	enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>";
}

String[] enableLocationLabels = new String[] {
	enableLocationPortalLabel, enableLocationSiteLabel
};

String cssClass = "";

if (assetEntryId <= 0) {
	cssClass ="hide";
}
%>

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

<aui:input helpMessage="name-help" label="name" name="{ct_field_guid}alias" type="text" value="<%= alias %>">
	<aui:validator name="required" />
</aui:input>

<div style="background-color:transparent; margin:0px;">
	<div class="control-group select-asset-selector">
		<div class="edit-controls lfr-meta-actions">
			<aui:input
				name="{ct_field_guid}assetEntryId"
				type="hidden"
				value="<%= assetEntryId %>"
			/>

			<label class="control-label"><liferay-ui:message key="select-the-content-to-be-tracked" /></label>

			<liferay-ui:icon-menu cssClass="select-existing-selector" direction="right" icon='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>' id="{ct_field_guid}assetSelector" message='<%= LanguageUtil.get(request, "select-content") %>' showWhenSingleIcon="<%= true %>">

				<%
				for (AssetRendererFactory assetRendererFactory : assetRendererFactories) {
				%>

					<liferay-ui:icon
						cssClass="asset-selector"
						data='<%= ContentTargetingUtil.getAssetSelectorIconData(request, assetRendererFactory, "", true) %>'
						id='<%= "{ct_field_guid}groupId_" + assetRendererFactory.getTypeName(locale, false) %>'
						message="<%= assetRendererFactory.getTypeName(locale, false) %>"
						src="<%= assetRendererFactory.getIconPath(renderRequest) %>"
						url="javascript:;"
					/>

				<%
				}
				%>

			</liferay-ui:icon-menu>
		</div>

		<div class="asset-preview <%= cssClass %>" id="<portlet:namespace />{ct_field_guid}selectedContentPreview">
			<aui:col>
				<img class="asset-image" src="<%= assetImagePreview %>" />
			</aui:col>

			<aui:col>
				<div class="asset-title" id="<portlet:namespace />{ct_field_guid}assetTitlePreview"><%= assetTitlePreview %></div>
				<div class="asset-type" id="<portlet:namespace />{ct_field_guid}assetTypePreview"><liferay-ui:message key="type" />: <%= assetTypePreview %></div>
			</aui:col>
		</div>
	</div>
</div>

<c:choose>
	<c:when test="<%= eventTypes.length > 0 %>">
		<aui:select label="event-type" name="{ct_field_guid}eventType">

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
				name="{ct_field_guid}eventType"
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
				eventName: '{ct_field_guid}selectContent',
				id: 'selectContent' + currentTarget.attr('id'),
				title: currentTarget.attr('data-title'),
				uri: currentTarget.attr('data-href')
			},
			function(event) {
				A.one('#<portlet:namespace />{ct_field_guid}assetEntryId').attr('value', event.assetentryid);

				A.one('#<portlet:namespace />{ct_field_guid}assetTitlePreview').html(event.assettitle);
				A.one('#<portlet:namespace />{ct_field_guid}assetTypePreview').html(event.assettype);

				A.one('#<portlet:namespace />{ct_field_guid}selectedContentPreview').show();
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