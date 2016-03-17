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
long javaScriptLastModified = PortalWebResourcesUtil.getLastModified(PortalWebResourceConstants.RESOURCE_TYPE_JS);

String tabs1 = ParamUtil.getString(request, "tabs1");

ServletContext simulatorServletContext = (ServletContext)request.getAttribute("simulatorServletContext");
%>

<c:if test="<%= simulatorServletContext != null %>">
	<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(simulatorServletContext.getContextPath()) + "/js/main.js", "minifierBundleId=content.targeting.files", javaScriptLastModified)) %>" type="text/javascript"></script>
	<link href="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(simulatorServletContext.getContextPath()) + "/css/main.css", "minifierBundleId=content.targeting.files", javaScriptLastModified)) %>" rel="stylesheet" type="text/css">
</c:if>

<h3 class="list-group-heading"><liferay-ui:message key="category.ct" /></h3>

<div class="container-fluid content-targeting-simulator">
	<div aria-multiselectable="true" class="panel-group" data-qa-id="contentTargetingSimulatorBody" id="<portlet:namespace />Accordion" role="tablist">
		<div class="panel">
			<div class="panel-heading" id="<portlet:namespace />UserSegmentsHeading" role="tab">
				<div class="panel-title">
					<div aria-controls="#<portlet:namespace />UserSegmentsCollapse" aria-expanded="<%= true %>" class="collapse-icon collapse-icon-middle panel-toggler" data-parent="#<portlet:namespace />Accordion" data-toggle="collapse" href="#<portlet:namespace />UserSegmentsCollapse" role="button">
						<span class="category-name truncate-text"><%= LanguageUtil.get(resourceBundle, "user-segments") %></span>

						<aui:icon cssClass="collapse-icon-closed" image="angle-right" markupView="lexicon" />

						<aui:icon cssClass="collapse-icon-open" image="angle-down" markupView="lexicon" />
					</div>
				</div>
			</div>

			<div aria-expanded="false" aria-labelledby="<portlet:namespace />UserSegmentsHeading" class="collapse in panel-collapse" id="<portlet:namespace />UserSegmentsCollapse" role="tabpanel">
				<div class="panel-body">
					<liferay-util:include page="/view_user_segments.jsp" servletContext="<%= application %>" />
				</div>
			</div>
		</div>

		<div class="panel">
			<div class="panel-heading" id="<portlet:namespace />CampaignsHeading" role="tab">
				<div class="panel-title">
					<div aria-controls="#<portlet:namespace />CampaignsCollapse" aria-expanded="<%= true %>" class="collapse-icon collapse-icon-middle collapsed panel-toggler" data-parent="#<portlet:namespace />Accordion" data-toggle="collapse" href="#<portlet:namespace />CampaignsCollapse" role="button">
						<span class="category-name truncate-text"><%= LanguageUtil.get(resourceBundle, "campaigns") %></span>

						<aui:icon cssClass="collapse-icon-closed" image="angle-right" markupView="lexicon" />

						<aui:icon cssClass="collapse-icon-open" image="angle-down" markupView="lexicon" />
					</div>
				</div>
			</div>

			<div aria-expanded="false" aria-labelledby="<portlet:namespace />CampaignsHeading" class="collapse panel-collapse" id="<portlet:namespace />CampaignsCollapse" role="tabpanel">
				<div class="panel-body">
					<liferay-util:include page="/view_campaigns.jsp" servletContext="<%= application %>" />
				</div>
			</div>
		</div>
	</div>
</div>