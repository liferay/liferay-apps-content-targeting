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
String refreshURL = GetterUtil.getString(request.getAttribute("refreshURL"));
boolean showUserSegmentSearch = GetterUtil.getBoolean(request.getAttribute("showUserSegmentSearch"));
long[] simulatedUserSegmentIds = GetterUtil.getLongValues(request.getAttribute("simulatedUserSegmentIds"));

List<UserSegment> userSegments = (List<UserSegment>)request.getAttribute("userSegments");
List<UserSegment> notMatchedUserSegments = (List<UserSegment>)request.getAttribute("notMatchedUserSegments");

String portletNamespace = PortalUtil.getPortletNamespace(PortletKeys.CT_SIMULATOR);
%>

<liferay-portlet:actionURL name="simulateUserSegment" portletName="<%= PortletKeys.CT_SIMULATOR %>" var="simulateUserSegmentURL" />

<div id="<portlet:namespace />userSegmentContainer">
	<aui:form action="<%= simulateUserSegmentURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" + renderResponse.getNamespace() + "saveUserSegments();" %>'>
		<aui:input name='<%= portletNamespace + "selectedUserSegmentIds" %>' type="hidden" useNamespace="<%= false %>" />
		<aui:input name='<%= portletNamespace + "stopSimulation" %>' type="hidden" useNamespace="<%= false %>" value="false" />

		<%
		request.setAttribute("elements", userSegments);
		request.setAttribute("notMatchedElements", notMatchedUserSegments);
		request.setAttribute("simulatedElementsPKs", simulatedUserSegmentIds);
		%>

		<liferay-util:include page="/ct_simulator/render_simulator_lists.jsp" servletContext="<%= application %>">
			<liferay-util:param name="className" value="<%= UserSegment.class.getName() %>" />
			<liferay-util:param name="containerId" value="userSegmentContainer" />
			<liferay-util:param name="emptyMessage" value="the-current-user-does-not-belong-to-any-user-segment" />
			<liferay-util:param name="name" value="user-segment" />
			<liferay-util:param name="showSearch" value="<%= String.valueOf(showUserSegmentSearch) %>" />
		</liferay-util:include>

		<aui:button-row cssClass="button-holder">
			<aui:button
				type="submit"
				value="simulate"
			/>
			<aui:button
				name="stopSimulationButton"
				value="stop-simulation"
			/>
		</aui:button-row>
	</aui:form>
</div>

<aui:script use="aui-toggler,liferay-simulator-search,liferay-util-list-fields">
	<portlet:namespace />saveUserSegments = function() {
		document.<portlet:namespace />fm.<%= portletNamespace %>selectedUserSegmentIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm);

		submitUserSegments();
	}

	var stopSimulationButton = A.one('#<portlet:namespace/>stopSimulationButton');

	stopSimulationButton.on(
		'click',
		function(event) {
			document.<portlet:namespace />fm.<%= portletNamespace %>stopSimulation.value = 'true';

			submitUserSegments();
		}
	);

	submitUserSegments = function() {
		var loadingMask = A.getBody().plug(A.LoadingMask).loadingmask;

		loadingMask.show();

		var fm = A.one('#<portlet:namespace />fm');

		A.io.request(
			fm.attr('action'),
			{
				dataType: 'JSON',
				form: {
					id: fm.attr('id')
				},
				after: {
					success: function(event, id, obj) {
						var response = this.get('responseData');

						loadingMask.hide();

						window.location.href = '<%= refreshURL %>';
					},
					failure: function(event) {
						loadingMask.hide();
					}
				}
			}
		);
	}
</aui:script>