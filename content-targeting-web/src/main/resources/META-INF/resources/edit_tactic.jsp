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
ContentTargetingEditTacticsDisplayContext contentTargetingEditTacticsDisplayContext = (ContentTargetingEditTacticsDisplayContext)request.getAttribute("contentTargetingEditTacticsDisplayContext");

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingEditTacticsDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingEditTacticsDisplayContext.getTacticName());
%>

<liferay-ui:error key="com.liferay.content.targeting.exception.InvalidChannelsException" message="there-is-an-error-in-one-of-your-channels" />

<portlet:actionURL name="updateTactic" var="addTacticURL" />

<aui:form action="<%= addTacticURL %>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<aui:input name="redirect" type="hidden" value="<%= contentTargetingEditTacticsDisplayContext.getRedirect() %>" />
	<aui:input name="campaignId" type="hidden" value="<%= contentTargetingEditTacticsDisplayContext.getCampaignId() %>" />
	<aui:input name="campaignUserSegmentsIds" type="hidden" value="<%= contentTargetingEditTacticsDisplayContext.getCampaignUserSegmentsIds() %>" />
	<aui:input name="vocabularyGroupIds" type="hidden" value="<%= contentTargetingEditTacticsDisplayContext.getVocabularyGroupIds() %>" />
	<aui:input name="vocabularyIds" type="hidden" value="<%= contentTargetingEditTacticsDisplayContext.getVocabularyIds() %>" />
	<aui:input name="tacticId" type="hidden" value="<%= contentTargetingEditTacticsDisplayContext.getTacticId() %>" />
	<aui:input name="tacticChannels" type="hidden" />
	<aui:input name="saveAndContinue" type="hidden" />

	<aui:model-context bean="<%= contentTargetingEditTacticsDisplayContext.getTactic() %>" model="<%= Tactic.class %>" />

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

			<liferay-util:include page="/macros/user_segment_selector.jsp" servletContext="<%= application %>">
				<liferay-util:param name="assetCategoryIds" value="<%= contentTargetingEditTacticsDisplayContext.getUserSegmentAssetCategoryIdsAsString() %>" />
				<liferay-util:param name="assetCategoryNames" value="<%= contentTargetingEditTacticsDisplayContext.getUserSegmentAssetCategoryNames() %>" />
				<liferay-util:param name="filterIds" value="<%= contentTargetingEditTacticsDisplayContext.getCampaignUserSegmentsIds() %>" />
				<liferay-util:param name="hiddenInput" value="userSegmentAssetCategoryIds" />
				<liferay-util:param name="vocabularyGroupIds" value="<%= contentTargetingEditTacticsDisplayContext.getVocabularyGroupIds() %>" />
				<liferay-util:param name="vocabularyIds" value="<%= contentTargetingEditTacticsDisplayContext.getVocabularyIds() %>" />
				<liferay-util:param name="warningMessage" value="editing-user-segments-deletes-all-unsaved-promotion-data" />
			</liferay-util:include>

			<span class="slider-holder"></span>
		</aui:fieldset>

		<aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" cssClass="channel-panel" helpMessage="channels-help" label="channels">
			<div class="component form-builder liferayctformbuilder property-builder yui3-widget" id="formBuilderBB">
				<div class="form-builder-content property-builder-content" id="formBuilderCB">
					<div class="tabbable">
						<div class="tabbable-content">
							<ul class="nav nav-tabs">
								<li class="active"><a href="javascript:;">Add node</a></li>
								<li><a href="javascript:;">Settings</a></li>
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
										for (ChannelTemplate template : contentTargetingEditTacticsDisplayContext.getChannelTemplates()) {
											Channel channel = template.getChannel();
										%>

											<li class="form-builder-field hide property-builder-field" data-icon="<%= channel.getIcon() %>" data-key="<%= template.getTemplateKey() %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !channel.isInstantiable() %>">
												<span class="property-builder-field-icon icon <%= channel.getIcon() %>"></span>

												<div class="property-builder-field-label">
													<div class="row">
														<div class="field-title"><%= channel.getName(locale) %></div>
														<div class="field-description"><%= channel.getDescription(locale) %></div>
														<div class="field-short-description"><%= channel.getShortDescription(locale) %></div>
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
						<div class="property-builder-canvas form-builder-canvas <%= contentTargetingEditTacticsDisplayContext.getCssItemsClass() %>">
							<div class="alert alert-info alert-no-items">
								<liferay-ui:message key="drag-and-drop-the-different-channels-you-want-to-use-for-this-promotion" />
							</div>

							<div class="form-builder-drop-container property-builder-drop-container">

								<%
								for (ChannelTemplate template : contentTargetingEditTacticsDisplayContext.getAddedChannelTemplates()) {
									Channel channel = template.getChannel();
								%>

									<div class="component form-builder-field hide widget yui3-widget" data-icon="<%= channel.getIcon() %>" data-key="<%= template.getTemplateKey() %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !channel.isInstantiable() %>">
										<div>
											<div>
												<div class="field-header">
													<div class="field-icon"><i
															class="<%= channel.getIcon() %>"></i>
													</div>
													<div class="field-info row">
														<div class="field-title"><%= channel.getName(locale) %></div>
														<div class="field-description"><%= channel.getDescription(locale) %></div>
														<div class="field-short-description"><%= channel.getShortDescription(locale) %></div>
													</div>
												</div>
												<div class="field-editor">
												</div>
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

		<aui:button cssClass="btn-lg" href="<%= contentTargetingEditTacticsDisplayContext.getRedirect() %>" type="cancel" />
	</aui:button-row>

	<aui:script use="aui-toggler,liferay-ct-form-builder">
		var tacticBuilder = new A.LiferayCTFormBuilder(
			{
				boundingBox: '#formBuilderBB',
				contentBox: '#formBuilderCB',
				searchBox: '#formBuilderSB'
			}
		).render();

		saveAndContinue = function() {
			document.<portlet:namespace />fm.<portlet:namespace />tacticChannels.value = tacticBuilder.exportAsJSON();

			A.one('#<portlet:namespace />saveAndContinue').val('true');

			submitForm(document.<portlet:namespace />fm);
		};

		saveFields = function() {
			document.<portlet:namespace />fm.<portlet:namespace />tacticChannels.value = tacticBuilder.exportAsJSON();

			A.one('#<portlet:namespace />saveAndContinue').val('false');

			submitForm(document.<portlet:namespace />fm);
		};
	</aui:script>
</aui:form>

<liferay-util:include page="/macros/field_header_listener.jsp" servletContext="<%= application %>">
	<liferay-util:param name="fieldName" value="alias" />
</liferay-util:include>

<liferay-util:include page="/macros/close_confirm.jsp" servletContext="<%= application %>">
	<liferay-util:param name="confirmMessage" value="leaving-this-window-deletes-all-unsaved-data" />
	<liferay-util:param name="controlCssClasses" value="control-button" />
</liferay-util:include>