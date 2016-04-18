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
long cssLastModified = PortalWebResourcesUtil.getLastModified(PortalWebResourceConstants.RESOURCE_TYPE_CSS);
long javaScriptLastModified = PortalWebResourcesUtil.getLastModified(PortalWebResourceConstants.RESOURCE_TYPE_JS);

String refreshURL = GetterUtil.getString(request.getAttribute("refreshURL"));

String portletNamespace = PortalUtil.getPortletNamespace(PortletKeys.CT_SIMULATOR);

ServletContext simulatorServletContext = (ServletContext)request.getAttribute("simulatorServletContext");
%>

<c:if test="<%= simulatorServletContext != null %>">
	<liferay-util:html-top>
		<link href="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(simulatorServletContext.getContextPath()) + "/css/main.css", "minifierBundleId=content.targeting.files", cssLastModified)) %>" rel="stylesheet" type="text/css">
		<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(simulatorServletContext.getContextPath()) + "/js/main.js", "minifierBundleId=content.targeting.files", javaScriptLastModified)) %>" type="text/javascript"></script>
	</liferay-util:html-top>
</c:if>

<h3 class="list-group-heading"><liferay-ui:message key="user-segments" /></h3>

<div class="container-fluid content-targeting-simulator">
	<liferay-portlet:actionURL name="simulateUserSegment" portletName="<%= PortletKeys.CT_SIMULATOR %>" var="simulateUserSegmentURL" />

	<div class="container-fluid" id="<portlet:namespace />userSegmentContainer">
		<aui:form action="<%= simulateUserSegmentURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" + renderResponse.getNamespace() + "saveUserSegments();" %>'>
			<aui:input name='<%= portletNamespace + "selectedUserSegmentIds" %>' type="hidden" useNamespace="<%= false %>" />
			<aui:input name='<%= portletNamespace + "stopSimulation" %>' type="hidden" useNamespace="<%= false %>" value="false" />

			<liferay-util:include page="/simulation_options.jsp" servletContext="<%= application %>" />
		</aui:form>
	</div>

	<aui:script use="aui-toggler,liferay-simulator-search,liferay-util-list-fields">
		<portlet:namespace />updateSimulation = function() {
			document.<portlet:namespace />fm.<%= portletNamespace %>selectedUserSegmentIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm);

			submitUserSegments();
		}

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
</div>