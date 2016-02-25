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
String displayStyle = GetterUtil.getString(request.getAttribute("displayStyle"));
String[] displayStyles = GetterUtil.getStringValues(request.getAttribute("displayStyles"));
long displayStyleGroupId = GetterUtil.getLong(request.getAttribute("displayStyleGroupId"));

List<QueryRule> campaignQueryRules = (List<QueryRule>)request.getAttribute("campaignQueryRules");

TemplateHandler templateHandler = (TemplateHandler)request.getAttribute("templateHandler");
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationURL">
	<portlet:param name="cmd" value="update" />
</liferay-portlet:actionURL>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<liferay-ui:tabs
		names="content-selection,display-settings"
		param="tabs2"
		refresh="<%= false %>"
	>

		<liferay-ui:section>
			<span class="title">
				<liferay-ui:message key="display-the-following-content" />

				<liferay-ui:icon-help message="the-following-conditions-will-be-evaluated-by-priority" />
			</span>

			<div class="rules-panel">
				<div id="<portlet:namespace />queryRules">
					<aui:fieldset label="">

						<%
						for (QueryRule queryRule : campaignQueryRules) {
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

					</aui:fieldset>
				</div>
			</div>
		</liferay-ui:section>

		<liferay-ui:section>
			<div class="display-template">
				<liferay-ddm:template-selector
					className="<%= templateHandler.getClassName() %>"
					displayStyle="<%= displayStyle %>"
					displayStyleGroupId="<%= displayStyleGroupId %>"
					displayStyles="<%= ListUtil.toList(displayStyles) %>"
					label="display-template"
					refreshURL="<%= configurationURL %>"
				/>
			</div>
		</liferay-ui:section>
	</liferay-ui:tabs>

	<aui:button-row>
		<aui:button type="submit" value="save" />
	</aui:button-row>
</aui:form>

<liferay-portlet:renderURL portletName="<%= PortletKeys.CT_CAMPAIGN_DISPLAY %>" var="newCampaignRuleURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="<%= CampaignContentDisplayPath.EDIT_QUERY_RULE %>" />
	<portlet:param name="portletResource" value="<%= portletName %>" />
</liferay-portlet:renderURL>

<aui:script use="aui-base,liferay-auto-fields">
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: '#<portlet:namespace />queryRules > fieldset',
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

					A.one('#<portlet:namespace />assetTitleInfo' + index).html(event.assettitle);
					A.one('#<portlet:namespace />assetTypeInfo' + index).html(event.assettype);

					A.one('#<portlet:namespace />selectedContent' + index).show();
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

	Liferay.Util.toggleRadio('<portlet:namespace />contentDefaultValueDo', '<portlet:namespace />contentDefaultBox', '');
	Liferay.Util.toggleRadio('<portlet:namespace />contentDefaultValueDont', '', '<portlet:namespace />contentDefaultBox');
</aui:script>