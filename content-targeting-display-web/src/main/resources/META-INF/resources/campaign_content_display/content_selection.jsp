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
List<QueryRule> campaignQueryRules = (List<QueryRule>)request.getAttribute("campaignQueryRules");
%>

<aui:fieldset-group markupView="lexicon">
	<aui:fieldset>
		<h4 class="text-default">
			<liferay-ui:message key="display-the-following-content" />

			<liferay-ui:icon-help message="the-following-conditions-will-be-evaluated-by-priority" />
		</h4>

		<div class="rules-panel">
			<div id="<portlet:namespace />queryRules">

				<%
				for (QueryRule queryRule : campaignQueryRules) {
					if (queryRule.isDefaultRule()) {
						continue;
					}

					int queryRule_index = campaignQueryRules.indexOf(queryRule);

					request.setAttribute("configuration.queryRule", queryRule);
					request.setAttribute("configuration.isFirst", queryRule_index == 0);
				%>

					<div class="lfr-form-row <%= queryRule.getCssClass(queryRule_index) %>">
						<div class="row-fields">
							<liferay-util:include page="/campaign_content_display/edit_query_rule.jsp" servletContext="<%= application %>">
								<liferay-util:param name="portletResource" value="<%= portletName %>" />
							</liferay-util:include>
						</div>
					</div>

				<%
				}
				%>

			</div>

			<%
			for (QueryRule queryRule : campaignQueryRules) {
				if (!queryRule.isDefaultRule()) {
					continue;
				}

				int queryRule_index = campaignQueryRules.indexOf(queryRule);

				request.setAttribute("queryRule", queryRule);
			%>

				<div class="lfr-form-row <%= queryRule.getCssClass(queryRule_index) %>">
					<div class="row-fields">
						<div class="field-row query-row">
							<liferay-util:include page="/macros/render_default_query_rule.jsp" servletContext="<%= application %>" />
						</div>
					</div>
				</div>

			<%
			}
			%>

		</div>
	</aui:fieldset>
</aui:fieldset-group>

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="newCampaignRuleURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="<%= Constants.CMD %>" value="edit_query_rule" />
</liferay-portlet:renderURL>

<aui:script use="aui-base,liferay-auto-fields">
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: '#<portlet:namespace />queryRules',
			fieldIndexes: '<portlet:namespace />queryLogicIndexes',
			namespace: '<portlet:namespace />',
			sortable: false,
			url: '<%= newCampaignRuleURL %>'
		}
	).render();

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
					var index = currentTarget.attr('data-index');

					A.one('#<portlet:namespace />assetEntryId' + index).attr('value', event.assetentryid);

					<liferay-portlet:renderURL portletName="<%= PortletKeys.CT_CAMPAIGN_DISPLAY %>" var="previewAssetEntryURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="mvcPath" value="/macros/asset_entry.jsp" />
					</liferay-portlet:renderURL>

					var uri = '<%= previewAssetEntryURL %>';

					uri = Liferay.Util.addParams('<%= PortalUtil.getPortletNamespace(PortletKeys.CT_CAMPAIGN_DISPLAY) %>assetEntryId=' + event.assetentryid, uri);

					A.io.request(
						uri,
						{
							on: {
								success: function(event, id, obj) {
									var responseData = this.get('responseData');

									A.one('#<portlet:namespace />assetEntryContent' + index).setContent(responseData);
								}
							}
						}
					);
				}
			);
		},
		'.asset-selector a'
	);

	A.getBody().delegate(
		'click',
		function(event) {
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
		},
		'.lfr-form-row'
	);
</aui:script>