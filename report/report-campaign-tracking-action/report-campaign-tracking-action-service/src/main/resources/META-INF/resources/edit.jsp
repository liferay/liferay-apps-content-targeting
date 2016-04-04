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

<aui:input name="reportTrackingActions" type="hidden" />

<div class="tracking-actions-panel">
	<div class="component form-builder liferayctformbuilder property-builder yui3-widget" id="formBuilderBB">
		<div class="form-builder-content property-builder-content" id="formBuilderCB">
			<div class="tabbable">
				<div class="tabbable-content">
					<ul class="nav nav-tabs">
						<li class="active">
							<a href="javascript:;"><liferay-ui:message key="add-node" /></a>
						</li>

						<li>
							<a href="javascript:;"><liferay-ui:message key="settings" /></a>
						</li>
					</ul>

					<div class="tab-content">
						<div class="tab-pane">
							<div class="hide panel-page-menu" id="formBuilderSB">
								<div class="form-builder-search-panels">
									<i class="icon-search"></i>

									<div class="search-panels-bar">
										<aui:input cssClass="search-panels-input search-query" label="" name="searchPanel" type="text" />
									</div>
								</div>
							</div>

							<ul class="clearfix form-builder-fields-container property-builder-fields-container">

								<%
								for (TrackingActionTemplate template : campaignTrackingActionReportDisplayContext.getTrackingActionTemplates()) {
									TrackingAction trackingAction = template.getTrackingAction();

									String templateKey = template.getTemplateKey();
								%>

									<c:if test="<%= trackingAction.isVisible(campaignTrackingActionReportDisplayContext.getClassName(), campaignTrackingActionReportDisplayContext.getClassPK()) %>">
										<li class="form-builder-field hide property-builder-field" data-icon="<%= trackingAction.getIcon() %>" data-key="<%= templateKey %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !trackingAction.isInstantiable() %>">
											<span class="property-builder-field-icon icon <%= trackingAction.getIcon() %>"></span>

											<div class="property-builder-field-label">
												<div class="row">
													<div class="field-title">
														<%= trackingAction.getName(locale) %>
													</div>

													<div class="field-description">
														<%= trackingAction.getDescription(locale) %>
													</div>

													<div class="field-short-description">
														<%= trackingAction.getShortDescription(locale) %>
													</div>
												</div>
											</div>
										</li>
									</c:if>

								<%
								}
								%>

							</ul>
						</div>

						<div class="tab-pane"></div>
					</div>
				</div>
			</div>

			<div class="form-builder-content-container property-builder-content-container">
				<div class="property-builder-canvas form-builder-canvas <%= ListUtil.isNotEmpty(campaignTrackingActionReportDisplayContext.getAddedTrackingActionTemplates()) ? "has-items" : StringPool.BLANK %>">
					<div class="alert alert-info alert-no-items">
						<liferay-ui:message key="drag-actions-to-track-in-this-report" />
					</div>

					<div class="form-builder-drop-container property-builder-drop-container">

						<%
						for (TrackingActionTemplate template : campaignTrackingActionReportDisplayContext.getAddedTrackingActionTemplates()) {
							TrackingAction trackingAction = template.getTrackingAction();

							String templateKey = template.getTemplateKey();
						%>

							<c:if test="<%= trackingAction.isVisible(campaignTrackingActionReportDisplayContext.getClassName(), campaignTrackingActionReportDisplayContext.getClassPK()) %>">
								<div class="component form-builder-field hide widget yui3-widget" data-icon="<%= trackingAction.getIcon() %>" data-key="<%= templateKey %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !trackingAction.isInstantiable() %>">
									<div>
										<div>
											<div class="field-header">
												<div class="field-icon">
													<i class="<%= trackingAction.getIcon() %>"></i>
												</div>

												<div class="field-info row">
													<div class="field-title">
														<%= trackingAction.getName(locale) %>
													</div>

													<div class="field-description">
														<%= trackingAction.getDescription(locale) %>
													</div>

													<div class="field-short-description">
														<%= trackingAction.getShortDescription(locale) %>
													</div>
												</div>4
											</div>

											<div class="field-editor"></div>
										</div>
									</div>
								</div>
							</c:if>

						<%
						}
						%>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<aui:script use="liferay-ct-form-builder">
	var reportBuilder = new A.LiferayCTFormBuilder(
		{
			boundingBox: '#formBuilderBB',
			contentBox: '#formBuilderCB',
			searchBox: '#formBuilderSB'
		}
	).render();

	<portlet:namespace />_saveMetrics = function() {
		document.<portlet:namespace />fm.<portlet:namespace />reportTrackingActions.value = reportBuilder.exportAsJSON();
	};

	var form = A.one('#<portlet:namespace />fm');

	Liferay.before(
		'submitForm',
		function(data) {
			if (data.form === form) {
				<portlet:namespace />_saveMetrics();
			}
		}
	);
</aui:script>