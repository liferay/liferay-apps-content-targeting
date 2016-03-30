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
long assetEntryId = GetterUtil.getLong(displayContext.get("assetEntryId"));

String assetImage = GetterUtil.getString(displayContext.get("assetImage"));
String assetTitle = GetterUtil.getString(displayContext.get("assetTitle"));
String assetType = GetterUtil.getString(displayContext.get("assetType"));
%>

<c:if test="<%= !trackingPageEnabled %>">
	<div class="alert alert-error">
		<strong>
			<liferay-ui:message key="this-rule-will-not-work-properly-because-page-tracking-is-not-enabled" />
		</strong>

		<%
		String enableLocationPortalLabel = LanguageUtil.get(resourceBundle, "portal-settings-content-targeting-analytics");

		String portalSettingsURL = GetterUtil.getString(displayContext.get("portalSettingsURL"));

		if (Validator.isNotNull(portalSettingsURL)) {
			enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>";
		}

		String enableLocationSiteLabel = LanguageUtil.get(resourceBundle, "site-settings-content-targeting-analytics");

		String siteSettingsURL = GetterUtil.getString(displayContext.get("siteSettingsURL"));

		if (Validator.isNotNull(siteSettingsURL)) {
			enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>";
		}
		%>

		<liferay-ui:message arguments='<%= StringUtil.split(enableLocationPortalLabel + "," + enableLocationSiteLabel) %>' key="it-can-be-enabled-in-x-or-in-x" translateArguments="<%= false %>" />
	</div>
</c:if>

<div class="select-asset-selector">

	<%
	String cssClass = StringPool.BLANK;

	if (assetEntryId <= 0) {
		cssClass = "hide";
	}
	%>

	<aui:input name="assetEntryId" type="hidden" value="<%= assetEntryId %>" />

	<div class="asset-preview <%= cssClass %>" id="<portlet:namespace /> />assetPreview">
		<aui:col>
			<img class="asset-image" id="<portlet:namespace /> />assetImage" src="<%= assetImage %>" />
		</aui:col>

		<aui:col>
			<div class="asset-title" id="<portlet:namespace /> />assetTitleInfo"><%= assetTitle %></div>
			<div class="asset-type" id="<portlet:namespace /> />assetTypeInfo">
				<liferay-ui:message key="type" />: <%= assetType %>
			</div>
		</aui:col>
	</div>

	<div class="edit-controls lfr-meta-actions">

		<%
		String pathThemeImagesAddIcon = themeDisplay.getPathThemeImages() + "/common/add.png";
		%>

		<liferay-ui:icon-menu cssClass="select-existing-selector" direction="right" icon="<%= pathThemeImagesAddIcon %>" message='<%= LanguageUtil.get(request, "select-content") %>' showWhenSingleIcon="<%= true %>">

			<%
			List<AssetRendererFactory> assetRendererFactories = (List<AssetRendererFactory>)displayContext.get("assetRendererFactories");

			for (AssetRendererFactory assetRendererFactory : assetRendererFactories) {
			%>

				<liferay-ui:icon
					cssClass="asset-selector"
					data="<%= ContentTargetingUtil.getAssetSelectorIconData(request, assetRendererFactory, StringPool.BLANK) %>"
					id="groupId_<%= assetRendererFactory.getTypeName(locale, false) %>"
					message="<%= assetRendererFactory.getTypeName(locale, false) %>"
					src="<%= assetRendererFactory.getIconPath(renderRequest) %>"
					url="javascript:;"
				/>

			<%
			}
			%>

		</liferay-ui:icon-menu>
	</div>
</div>

<aui:script use="aui-base">
	A.getBody().delegate(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = event.currentTarget;

			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					eventName: 'selectContent',
					id: 'selectContent' + currentTarget.attr('id'),
					title: currentTarget.attr('data-title'),
					uri: currentTarget.attr('data-href')
				},
				function(event) {
					A.one('#<portlet:namespace />assetEntryId').attr('value', event.assetentryid);
					A.one('#<portlet:namespace />assetImage').attr('src', '');

					A.one('#<portlet:namespace />assetTitleInfo').html(event.assettitle);
					A.one('#<portlet:namespace />assetTypeInfo').html('<liferay-ui:message key="type" />: ' + event.assettype);

					A.one('#<portlet:namespace />assetPreview').show();
				}
			);
		},
		'.asset-selector a'
	);
</aui:script>

<style>
	.asset-preview {
		overflow: hidden;
	}

	.asset-title {
		font-weight: 400;
		margin-top: 6px;
	}

	.asset-type {
		color: #8D8D8D;
		font-weight: 400;
	}
</style>