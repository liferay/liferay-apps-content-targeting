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

<c:if test="<%= !ruleVisitedDisplayContext.isTrackingContentEnabled() %>">
	<div class="alert alert-info">
		<strong><liferay-ui:message key="this-rule-will-not-work-properly-because-page-tracking-is-not-enabled" /></strong>

		<%
		String enableLocationPortalLabel = LanguageUtil.get(resourceBundle, "portal-settings-content-targeting-analytics");

		if (Validator.isNotNull(ruleVisitedDisplayContext.getPortalSettingsAnalyticsURL())) {
			enableLocationPortalLabel = "<a href=\"" + ruleVisitedDisplayContext.getPortalSettingsAnalyticsURL() + "\">" + enableLocationPortalLabel + "</a>";
		}

		String enableLocationSiteLabel = LanguageUtil.get(resourceBundle, "site-settings-content-targeting-analytics");

		if (Validator.isNotNull(ruleVisitedDisplayContext.getSiteSettingsAnalyticsURL())) {
			enableLocationSiteLabel = "<a href=\"" + ruleVisitedDisplayContext.getSiteSettingsAnalyticsURL() + "\">" + enableLocationSiteLabel + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= new String[] {enableLocationPortalLabel, enableLocationSiteLabel} %>" key="it-can-be-enabled-in-x-or-in-x" translateArguments="<%= false %>" />
	</div>
</c:if>

<div class="select-asset-selector">
	<aui:input name="assetEntryId" type="hidden" value="<%= ruleVisitedDisplayContext.getAssetEntryId() %>" />

	<div class="row">
		<div class="col-md-4 <%= (ruleVisitedDisplayContext.getAssetEntryId() <= 0) ? "hide" : StringPool.BLANK %>" id="<portlet:namespace />assetPreview">
			<c:if test="<%= ruleVisitedDisplayContext.getAssetEntryId() > 0 %>">
				<liferay-util:include page="/asset_entry.jsp" servletContext="<%= application %>" />
			</c:if>
		</div>
	</div>

	<div class="edit-controls">
		<liferay-ui:icon-menu cssClass="select-existing-selector" direction="right" message="select-content" showArrow="<%= false %>" showWhenSingleIcon="<%= true %>">

			<%
			for (AssetRendererFactory assetRendererFactory : ruleVisitedDisplayContext.getAssetRendererFactories()) {
			%>

				<liferay-ui:icon
					cssClass="asset-selector"
					data="<%= ContentTargetingUtil.getAssetSelectorIconData(request, assetRendererFactory, StringPool.BLANK) %>"
					id="groupId_<%= assetRendererFactory.getTypeName(locale) %>"
					message="<%= assetRendererFactory.getTypeName(locale) %>"
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

					var assetPreview = A.one('#<portlet:namespace />assetPreview');

					assetPreview.setContent('<p>' + event.assettitle + ', ' + event.assettype + '</p>');

					assetPreview.show();
				}
			);
		},
		'.asset-selector a'
	);
</aui:script>