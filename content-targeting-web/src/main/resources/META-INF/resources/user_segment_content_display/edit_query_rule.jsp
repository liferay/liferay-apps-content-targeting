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
String portletResource = ParamUtil.getString(request, "portletResource");
String portletNamespace = PortalUtil.getPortletNamespace(portletResource);

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

<div class="field-row query-row">
	<c:if test="<%= !editQueryRule.isDefaultRule() %>">
		<aui:input name='<%= portletNamespace + "queryIndex" + index %>' type="hidden" useNamespace="<%= false %>" />
	</c:if>

	<c:choose>
		<c:when test="<%= !editQueryRule.isDefaultRule() %>">
			<div class="full-view <%= fullViewClass %>">
				<aui:col width="15">
					<span class="query-contains-text"><liferay-ui:message key="if-the-user" /></span>

					<aui:input
						checked="<%= editQueryRule.isContains() %>"
						label="belongs"
						name='<%= portletNamespace + "queryContains" + index %>'
						type="radio"
						useNamespace="<%= false %>"
						value="<%= true %>"
					/>

					<aui:input
						checked="<%= !editQueryRule.isContains() %>"
						label="does-not-belong"
						name='<%= portletNamespace + "queryContains" + index %>'
						type="radio"
						useNamespace="<%= false %>"
						value="<%= false %>"
					/>
				</aui:col>

				<aui:col width="15">
					<span class="query-and-operator-text"><liferay-ui:message key="to" /></span>

					<aui:input
						checked="<%= !editQueryRule.isAndOperator() %>"
						label="any"
						name='<%= portletNamespace + "queryAndOperator" + index %>'
						type="radio"
						useNamespace="<%= false %>"
						value="<%= false %>"
					/>

					<aui:input
						checked="<%= editQueryRule.isAndOperator() %>"
						label="all"
						name='<%= portletNamespace + "queryAndOperator" + index %>'
						type="radio"
						useNamespace="<%= false %>"
						value="<%= true %>"
					/>
				</aui:col>

				<aui:col width="30">
					<div class="user-segment-selector">
						<span class="query-and-operator-text"><liferay-ui:message key="of-the-following-user-segments" /></span>

						<div class="lfr-tags-selector-content" id='<%= portletNamespace + "assetCategoriesSelector" + index %>'>
							<aui:input
								name='<%= portletNamespace + "userSegmentAssetCategoryIds" + index %>'
								type="hidden"
								useNamespace="<%= false %>"
								value="<%= editQueryRule.getUserSegmentAssetCategoryIdsAsString() %>"
							/>
						</div>

						<aui:script use="liferay-asset-categories-selector">
							var assetCategoriesSelector = new Liferay.AssetCategoriesSelector(
								{
									contentBox: '#<%= portletNamespace + "assetCategoriesSelector" + index %>',
									curEntries: '<%= editQueryRule.getUserSegmentAssetCategoryNames(locale) %>',
									curEntryIds: '<%= editQueryRule.getUserSegmentAssetCategoryIdsAsString() %>',
									hiddenInput: '#<%= portletNamespace + "userSegmentAssetCategoryIds" + index %>',
									instanceVar: '<%= portletNamespace %>',
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

				<aui:col width="35">
					<div class="select-asset-selector">
						<span class="query-and-operator-text"><liferay-ui:message key="display-this-content" /></span>

						<%
						request.setAttribute("queryRule", editQueryRule);
						%>

						<liferay-util:include page="/macros/render_asset_entry_selector.jsp" servletContext="<%= application %>">
							<liferay-util:param name="portletNamespace" value="<%= portletNamespace %>" />
							<liferay-util:param name="index" value="<%= String.valueOf(index) %>" />
						</liferay-util:include>
					</div>
				</aui:col>
			</div>

			<c:if test="<%= editQueryRule.isValid() %>">
				<div class="summary-view <%= summaryViewClass %>">
					<aui:col width="15">
						<span class="query-contains-text"><liferay-ui:message key="if-the-user" /></span>:
						<span class="query-contains-value">
							<c:choose>
								<c:when test="<%= editQueryRule.isContains() %>">
									<liferay-ui:message key="belongs" />
								</c:when>
								<c:otherwise>
									<liferay-ui:message key="does-not-belong" />
								</c:otherwise>
							</c:choose>
						</span>
					</aui:col>

					<aui:col width="15">
						<span class="query-and-operator-text"><liferay-ui:message key="to" /></span>:
						<span class="query-and-operator-value">
							<c:choose>
								<c:when test="<%= editQueryRule.isAndOperator() %>">
									<liferay-ui:message key="all" />
								</c:when>
								<c:otherwise>
									<liferay-ui:message key="any" />
								</c:otherwise>
							</c:choose>
						</span>
					</aui:col>

					<aui:col width="30">
						<span class="query-content-text"><liferay-ui:message key="of-the-following-user-segments" /></span>
						<span class="query-content-value"><%= editQueryRule.getUserSegmentNames(locale) %></span>
					</aui:col>

					<aui:col width="35">
						<span class="query-content-text"><liferay-ui:message key="display-this-content" /></span>
						<span class="query-content-value"><%= editQueryRule.getAssetTitle() %> (<span class="query-content-value-type"><%= editQueryRule.getAssetType() %></span>)</span>
					</aui:col>
				</div>
			</c:if>
		</c:when>
		<c:otherwise>

			<%
			request.setAttribute("queryRule", editQueryRule);
			%>

			<liferay-util:include page="/macros/render_default_query_rule.jsp" servletContext="<%= application %>">
				<liferay-util:param name="index" value="<%= String.valueOf(index) %>" />
				<liferay-util:param name="portletNamespace" value="<%= portletNamespace %>" />
			</liferay-util:include>
		</c:otherwise>
	</c:choose>

</div>