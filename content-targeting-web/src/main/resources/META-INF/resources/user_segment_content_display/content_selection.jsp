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
List<UserSegmentQueryRule> userSegmentQueryRules = (List<UserSegmentQueryRule>)request.getAttribute("userSegmentQueryRules");
%>

<aui:fieldset-group markupView="lexicon">
	<aui:fieldset>
		<h4 class="text-default">
			<liferay-ui:message key="display-the-following-content" />

			<liferay-ui:icon-help message="the-following-conditions-will-be-evaluated-in-order" />
		</h4>

		<div class="rules-panel">
			<div id="<portlet:namespace />queryRules">

				<%
				for (UserSegmentQueryRule queryRule : userSegmentQueryRules) {
					int queryRule_index = userSegmentQueryRules.indexOf(queryRule);

					request.setAttribute("configuration.queryRule", queryRule);
					request.setAttribute("configuration.isFirst", queryRule_index == 0);
				%>

					<div class="lfr-form-row <%= queryRule.getCssClass(queryRule_index) %>">
						<div class="row-fields">
							<liferay-util:include page="/user_segment_content_display/edit_query_rule.jsp" servletContext="<%= application %>">
								<liferay-util:param name="portletResource" value="<%= portletName %>" />
							</liferay-util:include>
						</div>
					</div>

				<%
				}
				%>

			</div>
		</div>
	</aui:fieldset>
</aui:fieldset-group>

<liferay-portlet:renderURL portletName="<%= PortletKeys.CT_USERSEGMENT_DISPLAY %>" var="newUserSegmentRuleURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="<%= UserSegmentContentDisplayPath.EDIT_QUERY_RULE %>" />
	<portlet:param name="portletResource" value="<%= portletName %>" />
</liferay-portlet:renderURL>

<aui:script use="aui-base,liferay-auto-fields">
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: '#<portlet:namespace />queryRules',
			fieldIndexes: '<portlet:namespace />queryLogicIndexes',
			namespace: '<portlet:namespace />',
			sortable: true,
			sortableHandle: '.field-row',
			url: '<%= newUserSegmentRuleURL %>'
		}
	).render();

	var onAssetSelectorClick = function(event) {
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
				var index = currentTarget.attr('data-index');

				A.one('#<portlet:namespace />assetEntryId' + index).attr('value', event.assetentryid);

				A.one('#<portlet:namespace />assetTitleInfo' + index).html(event.assettitle);
				A.one('#<portlet:namespace />assetTypeInfo' + index).html(event.assettype);

				A.one('#<portlet:namespace />selectedContent' + index).show();
			}
		);
	};

	var onFormRowClick = function(event) {
		A.all('.lfr-form-row').each(
			function(row) {
				row.removeClass('active');

				var summaryContent = row.one('.summary-view');

				if (summaryContent) {
					var fullView = row.one('.full-view');

					if (fullView) {
						fullView.hide();
					}

					summaryContent.show();
				}
			}
		);

		var currentTarget = event.currentTarget;

		currentTarget.addClass('active');

		var fullView = currentTarget.one('.full-view');

		if (fullView) {
			fullView.show();
		}

		var summaryView = currentTarget.one('.summary-view');

		if (summaryView) {
			summaryView.hide();
		}
	};

	A.getBody().delegate(
		'click',
		function(event) {
			if (event.currentTarget.hasClass('lfr-form-row')) {
				onFormRowClick(event);
			}
			else {
				onAssetSelectorClick(event);
			}
		},
		'.asset-selector a, .lfr-form-row'
	);
</aui:script>