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

TemplateHandler templateHandler = (TemplateHandler)request.getAttribute("templateHandler");

List<KeyValuePair> typesLeftList = (List<KeyValuePair>)request.getAttribute("typesLeftList");
List<KeyValuePair> typesRightList = (List<KeyValuePair>)request.getAttribute("typesRightList");

boolean anyAssetType = GetterUtil.getBoolean(request.getAttribute("anyAssetType"));

long[] availableClassNameIds = GetterUtil.getLongValues(request.getAttribute("availableClassNameIds"));
long[] classNameIds = GetterUtil.getLongValues(request.getAttribute("classNameIds"));

List<String> modelResources = (List<String>)request.getAttribute("modelResources");

boolean selectedValue = !anyAssetType && (classNameIds.length > 1);

String cssClass = "";

if (anyAssetType) {
	cssClass = "hide";
}
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationURL">
	<portlet:param name="cmd" value="update" />
</liferay-portlet:actionURL>

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit="event.preventDefault();">
	<liferay-ui:tabs
		names="content-selection,display-settings"
		param="tabs2"
		refresh="<%= false %>"
	>

		<liferay-ui:section>
			<aui:fieldset label="asset-entry-type">
				<aui:select label="" name="anyAssetType">
					<aui:option
						label="any"
						selected="<%= anyAssetType %>"
						value="<%= true %>"
					/>

					<aui:option
						label='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "select-more-than-one") + "..." %>'
						selected="<%= selectedValue %>"
						value="<%= false %>"
					/>

					<optgroup label="<liferay-ui:message key="asset-type" />">

						<%
						int i = 0;

						for (long classNameId : availableClassNameIds) {
							selectedValue = (classNameIds.length == 1) && (classNameId == classNameIds[0]);
						%>

							<aui:option label="<%= modelResources.get(i) %>" selected="<%= selectedValue %>" value="<%= classNameId %>" />

						<%
							i++;
						}
						%>

					</optgroup>
				</aui:select>

				<aui:input name="classNameIds" type="hidden" />

				<div class="<%= cssClass %>" id="<portlet:namespace />classNamesBoxes">
					<liferay-ui:input-move-boxes
						leftBoxName="currentClassNameIds"
						leftList="<%= typesLeftList %>"
						leftReorder="true"
						leftTitle="selected"
						rightBoxName="availableClassNameIds"
						rightList="<%= typesRightList %>"
						rightTitle="available"
					/>
				</div>
			</aui:fieldset>
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
		<aui:button onClick='<%= renderResponse.getNamespace() + "saveSelectBoxes();" %>' type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />saveSelectBoxes',
		function() {
			if (document.<portlet:namespace />fm.<portlet:namespace />classNameIds) {
				document.<portlet:namespace />fm.<portlet:namespace />classNameIds.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentClassNameIds);
			}

			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);

	Liferay.Util.toggleSelectBox('<portlet:namespace />anyAssetType', 'false', '<portlet:namespace />classNamesBoxes');
</aui:script>