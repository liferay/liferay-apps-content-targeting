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
ContentTargetingEditUserSegmentDisplayContext contentTargetingEditUserSegmentDisplayContext = new ContentTargetingEditUserSegmentDisplayContext(renderRequest, renderResponse);

RuleCategoriesRegistry ruleCategoriesRegistry = contentTargetingEditUserSegmentDisplayContext.getRuleCategoriesRegistry();

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingEditUserSegmentDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingEditUserSegmentDisplayContext.getUserSegmentTitle());
%>

<liferay-ui:error key="com.liferay.content.targeting.exception.InvalidRulesException" message="there-is-an-error-in-one-of-your-rules" />

<liferay-portlet:actionURL name="updateUserSegment" var="addUserSegmentURL" />

<aui:form action="<%= addUserSegmentURL %>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<aui:input name="redirect" type="hidden" value="<%= contentTargetingEditUserSegmentDisplayContext.getRedirect() %>" />
	<aui:input name="userSegmentId" type="hidden" value="<%= String.valueOf(contentTargetingEditUserSegmentDisplayContext.getUserSegmentId()) %>" />
	<aui:input name="userSegmentRules" type="hidden" />
	<aui:input name="saveAndContinue" type="hidden" />

	<aui:model-context bean="<%= contentTargetingEditUserSegmentDisplayContext.getUserSegment() %>" model="<%= UserSegment.class %>" />

	<liferay-ui:error key="com.liferay.content.targeting.exception.InvalidNameException">
		<c:choose>
			<c:when test="<%= ((InvalidNameException)errorException).isEmpty() %>">
				<liferay-ui:message key="the-name-can-not-be-empty" />
			</c:when>
			<c:when test="<%= ((InvalidNameException)errorException).isDuplicated() %>">
				<liferay-ui:message key="this-name-is-already-in-use-please-choose-a-different-one" />
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="please-enter-a-valid-name" />
			</c:otherwise>
		</c:choose>
	</liferay-ui:error>

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input name="name" />

			<aui:input name="description" />
		</aui:fieldset>

		<aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" label="rules">
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
											<aui:icon cssClass="search-icon" image="search" markupView="lexicon" />

											<div class="search-panels-bar">
												<aui:input cssClass="search-panels-input search-query" label="" name="searchPanel" type="text" />
											</div>
										</div>
									</div>

									<ul class="clearfix form-builder-fields-container property-builder-fields-container">

										<%
										for (RuleTemplate template : contentTargetingEditUserSegmentDisplayContext.getRuleTemplates()) {
											Rule rule = template.getRule();

											RuleCategory ruleCategory = ruleCategoriesRegistry.getRuleCategory(rule.getRuleCategoryKey());
										%>

											<li class="form-builder-field hide property-builder-field" data-categorydescription="<%= ruleCategory.getDescription(locale) %>" data-categorykey="<%= ruleCategory.getCategoryKey() %>" data-categoryname="<%= ruleCategory.getName(locale) %>" data-key="<%= template.getTemplateKey() %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !rule.isInstantiable() %>">
												<div class="property-builder-field-label">
													<h4 class="field-title">
														<%= rule.getName(locale) %>
													</h4>

													<div class="field-description small text-default">
														<%= rule.getDescription(locale) %>
													</div>

													<div class="field-short-description small text-default">
														<%= rule.getShortDescription(locale) %>
													</div>
												</div>
											</li>

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
						<div class="property-builder-canvas form-builder-canvas <%= contentTargetingEditUserSegmentDisplayContext.getCssItemsClass() %>">
							<div class="alert alert-info alert-no-items">
								<liferay-ui:message key="drag-rules-here-to-configure-this-user-segment" />
							</div>

							<div class="form-builder-drop-container property-builder-drop-container">

								<%
								for (RuleTemplate template : contentTargetingEditUserSegmentDisplayContext.getAddedRuleTemplates()) {
									Rule rule = template.getRule();
								%>

									<div class="component form-builder-field hide widget yui3-widget" data-key="<%= template.getTemplateKey() %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !rule.isInstantiable() %>">
										<div>
											<div>
												<div class="field-header">
													<div class="field-info">
														<h2 class="field-title">
															<%= rule.getName(locale) %>
														</h2>

														<p class="field-description text-default">
															<%= rule.getDescription(locale) %>
														</p>

														<p class="field-short-description text-default">
															<%= rule.getShortDescription(locale) %>
														</p>
													</div>
												</div>

												<div class="field-editor"></div>
											</div>
										</div>
									</div>

								<%
								}
								%>

							</div>
						</div>
					</div>

				</div>
			</div>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />

		<aui:button cssClass="btn-lg" onClick="saveAndContinue();" value="save-and-continue" />

		<aui:button cssClass="btn-lg" href="<%= contentTargetingEditUserSegmentDisplayContext.getRedirect() %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-toggler,liferay-ct-form-builder">
	var userSegmentBuilder = new A.LiferayCTFormBuilder(
		{
			boundingBox: '#formBuilderBB',
			contentBox: '#formBuilderCB',
			searchBox: '#formBuilderSB'
		}
	).render();

	saveAndContinue = function() {
		document.<portlet:namespace />fm.<portlet:namespace />userSegmentRules.value = userSegmentBuilder.exportAsJSON();

		A.one('#<portlet:namespace />saveAndContinue').val('true');

		submitForm(document.<portlet:namespace />fm);
	};

	saveFields = function() {
		document.<portlet:namespace />fm.<portlet:namespace />userSegmentRules.value = userSegmentBuilder.exportAsJSON();

		A.one('#<portlet:namespace />saveAndContinue').val('false');

		submitForm(document.<portlet:namespace />fm);
	};
</aui:script>

<liferay-util:include page="/macros/close_confirm.jsp" servletContext="<%= application %>">
	<liferay-util:param name="confirmMessage" value="leaving-this-window-deletes-all-unsaved-data" />
	<liferay-util:param name="controlCssClasses" value="control-button,tab" />
</liferay-util:include>