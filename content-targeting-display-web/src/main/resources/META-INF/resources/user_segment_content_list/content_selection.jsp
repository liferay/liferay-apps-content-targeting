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
List<KeyValuePair> typesLeftList = (List<KeyValuePair>)request.getAttribute("typesLeftList");
List<KeyValuePair> typesRightList = (List<KeyValuePair>)request.getAttribute("typesRightList");

boolean anyAssetType = GetterUtil.getBoolean(request.getAttribute("anyAssetType"));

long[] availableClassNameIds = GetterUtil.getLongValues(request.getAttribute("availableClassNameIds"));
long[] classNameIds = GetterUtil.getLongValues(request.getAttribute("classNameIds"));

List<String> modelResources = (List<String>)request.getAttribute("modelResources");

boolean selectedValue = !anyAssetType && (classNameIds.length > 1);
%>

<aui:fieldset-group markupView="lexicon">
	<aui:fieldset>
		<aui:select label="asset-entry-type" name="anyAssetType">
			<aui:option label="any" selected="<%= anyAssetType %>" value="<%= true %>" />

			<aui:option label='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "select-more-than-one") + "..." %>' selected="<%= selectedValue %>" value="<%= false %>" />

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

		<div class="<%= anyAssetType ? "hide" : StringPool.BLANK %>" id="<portlet:namespace />classNamesBoxes">
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
</aui:fieldset-group>

<aui:script use="liferay-util-list-fields">
	var Util = Liferay.Util;

	var form = $('#<portlet:namespace />fm');

	form.on(
		'submit',
		function(event) {
			event.preventDefault();

			if (document.<portlet:namespace />fm.<portlet:namespace />classNameIds) {
				document.<portlet:namespace />fm.<portlet:namespace />classNameIds.value = Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentClassNameIds);
			}

			submitForm(form);
		}
	);

	Util.toggleSelectBox('<portlet:namespace />anyAssetType', 'false', '<portlet:namespace />classNamesBoxes');
</aui:script>