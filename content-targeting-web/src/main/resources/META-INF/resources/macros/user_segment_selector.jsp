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
String assetCategoryIds = HtmlUtil.escapeJS(ParamUtil.getString(request, "assetCategoryIds"));
String assetCategoryNames = HtmlUtil.escapeJS(ParamUtil.getString(request, "assetCategoryNames"));
String hiddenInput = ParamUtil.getString(request, "hiddenInput");
String vocabularyGroupIds = HtmlUtil.escapeJS(ParamUtil.getString(request, "vocabularyGroupIds"));
String vocabularyIds = HtmlUtil.escapeJS(ParamUtil.getString(request, "vocabularyIds"));
String warningMessage = ParamUtil.getString(request, "warningMessage");
String filterIds = HtmlUtil.escapeJS(ParamUtil.getString(request, "filterIds", ""));
%>

<liferay-portlet:renderURL var="viewUserSegments">
	<portlet:param
		name="mvcPath"
		value="<%= ContentTargetingPath.VIEW %>"
	/>
	<portlet:param
		name="tabs1"
		value="user-segments"
	/>
</liferay-portlet:renderURL>

<div class="user-segment-selector">
	<span class="control-label query-and-operator-text"><liferay-ui:message key="user-segments" /></span>

	<liferay-ui:icon
		id="manageUserSegments"
		image="configuration"
		label="<%= false %>"
		message="manage-user-segments"
		url="javascript:;"
	/>

	<div class="lfr-tags-selector-content" id="<portlet:namespace />assetCategorySelector">
		<aui:input
			name="<%= hiddenInput %>"
			type="hidden"
			value="<%= assetCategoryIds %>"
		/>
	</div>

	<aui:script use="liferay-asset-categories-selector">
		var manageUserSegmentsLink = A.one('#<portlet:namespace />manageUserSegments');

		manageUserSegmentsLink.on(
			'click',
			function() {
				var closeConfirmElement = A.one('#<portlet:namespace />closeConfirm');

				if (closeConfirmElement) {
					closeConfirmElement.val('false');
				}

				if (confirm('<liferay-ui:message key="<%= warningMessage %>" />')) {
					window.location.href = "<%= viewUserSegments %>";
				}
			}
		);

		var assetCategoriesSelector = new Liferay.AssetCategoriesSelector(
			{
				contentBox: '#<portlet:namespace />assetCategorySelector',
				curEntries: '<%= assetCategoryNames %>',
				curEntryIds: '<%= assetCategoryIds %>',
				<c:if test="<%= !Validator.isBlank(filterIds) %>">
					filterIds: '<%= filterIds %>',
				</c:if>
				hiddenInput: '#<portlet:namespace /><%= hiddenInput %>',
				instanceVar: '<portlet:namespace />',
				vocabularyGroupIds: '<%= vocabularyGroupIds %>',
				vocabularyIds: '<%= vocabularyIds %>',
				title: '<liferay-ui:message key="select-user-segments" />'
			}
		).render();

		var changeTitle = function() {
			assetCategoriesSelector._popup.titleNode.html(assetCategoriesSelector.get('title'));

			var modalBody = assetCategoriesSelector._popup.getStdModNode(A.WidgetStdMod.BODY);

			modalBody.append('<div style="position: absolute; bottom: 15px; right: 15px;"><button class="btn btn-primary close-popup-button"><liferay-ui:message key="ok" /></button></div>');

			modalBody.one('.close-popup-button').on(
				'click',
				function() {
					assetCategoriesSelector._popup.hide();
					this.ancestor('div').remove();
				}
			);
		};

		A.Do.after(changeTitle, assetCategoriesSelector, '_showSelectPopup');
	</aui:script>
</div>