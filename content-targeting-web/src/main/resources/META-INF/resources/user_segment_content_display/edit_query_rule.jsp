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
String vocabularyGroupIds = GetterUtil.getString(request.getAttribute("vocabularyGroupIds"));
String vocabularyIds = GetterUtil.getString(request.getAttribute("vocabularyIds"));

UserSegmentQueryRule editQueryRule = (UserSegmentQueryRule)request.getAttribute("configuration.queryRule");

if (editQueryRule == null) {
	editQueryRule = new UserSegmentQueryRule();
}

int index = ParamUtil.getInteger(request, "index", editQueryRule.getIndex());

boolean isFirst = GetterUtil.getBoolean(request.getAttribute("configuration.isFirst"));

String fullViewClass = "";
String summaryViewClass = "hide";

if (editQueryRule.isValid() && !isFirst) {
	fullViewClass = "hide";
	summaryViewClass = "";
}
%>

<aui:input name='<%= "queryIndex" + index %>' type="hidden" />

<div class="field-row query-row">
	<div class="full-view <%= fullViewClass %>">
		<aui:row>
			<aui:col span="<%= 2 %>">
				<p class="text-default"><liferay-ui:message key="if-the-user" /></p>

				<aui:input checked="<%= editQueryRule.isContains() %>" label="belongs" name='<%= "queryContains" + index %>' type="radio" value="<%= true %>" />

				<aui:input checked="<%= !editQueryRule.isContains() %>" label="does-not-belong" name='<%= "queryContains" + index %>' type="radio" value="<%= false %>" />
			</aui:col>

			<aui:col span="<%= 2 %>">
				<p class="text-default"><liferay-ui:message key="to" /></p>

				<aui:input checked="<%= !editQueryRule.isAndOperator() %>" label="any" name='<%= "queryAndOperator" + index %>' type="radio" value="<%= false %>" />

				<aui:input checked="<%= editQueryRule.isAndOperator() %>" label="all" name='<%= "queryAndOperator" + index %>' type="radio" value="<%= true %>" />
			</aui:col>

			<aui:col span="<%= 4 %>">
				<div class="user-segment-selector">
					<p class="text-default"><liferay-ui:message key="of-the-following-user-segments" /></p>

					<div class="lfr-tags-selector-content" id='<portlet:namespace /><%= "assetCategoriesSelector" + index %>'>
						<aui:input name='<%= "userSegmentAssetCategoryIds" + index %>' type="hidden" value="<%= editQueryRule.getUserSegmentAssetCategoryIdsAsString() %>" />
					</div>

					<aui:script use="liferay-asset-categories-selector">
						var assetCategoriesSelector = new Liferay.AssetCategoriesSelector(
							{
								contentBox: '#<portlet:namespace /><%= "assetCategoriesSelector" + index %>',
								curEntries: '<%= editQueryRule.getUserSegmentAssetCategoryNames(locale) %>',
								curEntryIds: '<%= editQueryRule.getUserSegmentAssetCategoryIdsAsString() %>',
								hiddenInput: '#<portlet:namespace /><%= "userSegmentAssetCategoryIds" + index %>',
								instanceVar: '<portlet:namespace />',
								vocabularyGroupIds: '<%= vocabularyGroupIds %>',
								vocabularyIds: '<%= vocabularyIds %>',
								title: '<liferay-ui:message key="select-user-segments" />'
							}
						).render();

						var changeTitle = function() {
							assetCategoriesSelector._popup.titleNode.html(assetCategoriesSelector.get('title'));
						};

						A.Do.after(changeTitle, assetCategoriesSelector, '_showSelectPopup');
					</aui:script>
				</div>
			</aui:col>

			<aui:col span="<%= 4 %>">
				<p class="text-default"><liferay-ui:message key="display-this-content" /></p>

				<%
				request.setAttribute("queryRule", editQueryRule);
				%>

				<liferay-util:include page="/macros/render_asset_entry_selector.jsp" servletContext="<%= application %>">
					<liferay-util:param name="index" value="<%= String.valueOf(index) %>" />
				</liferay-util:include>
			</aui:col>
		</aui:row>
	</div>

	<c:if test="<%= editQueryRule.isValid() %>">
		<div class="summary-view <%= summaryViewClass %>">
			<aui:row>
				<aui:col span="<%= 2 %>">
					<span class="text-default"><liferay-ui:message key="if-the-user" />:</span>

					<strong class="text-default">
						<c:choose>
							<c:when test="<%= editQueryRule.isContains() %>">
								<liferay-ui:message key="belongs" />
							</c:when>
							<c:otherwise>
								<liferay-ui:message key="does-not-belong" />
							</c:otherwise>
						</c:choose>
					</strong>
				</aui:col>

				<aui:col span="<%= 2 %>">
					<span class="text-default"><liferay-ui:message key="to" />:</span>

					<strong class="text-default">
						<c:choose>
							<c:when test="<%= editQueryRule.isAndOperator() %>">
								<liferay-ui:message key="all" />
							</c:when>
							<c:otherwise>
								<liferay-ui:message key="any" />
							</c:otherwise>
						</c:choose>
					</strong>
				</aui:col>

				<aui:col span="<%= 4 %>">
					<span class="text-default"><liferay-ui:message key="of-the-following-user-segments" /></span>

					<strong class="text-default"><%= editQueryRule.getUserSegmentNames(locale) %></strong>
				</aui:col>

				<aui:col span="<%= 4 %>">
					<span class="text-default"><liferay-ui:message key="display-this-content" /></span>

					<strong class="text-default"><%= editQueryRule.getAssetTitle() %> (<span class="small"><%= editQueryRule.getAssetType() %></span>)</strong>
				</aui:col>
			</aui:row>
		</div>
	</c:if>
</div>