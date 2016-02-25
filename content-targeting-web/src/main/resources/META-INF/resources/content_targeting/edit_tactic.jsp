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
String backURL = ParamUtil.getString(request, "backURL");
String redirect = ParamUtil.getString(request, "redirect");

String campaignUserSegmentsIds = GetterUtil.getString(request.getAttribute("campaignUserSegmentsIds"));
String userSegmentAssetCategoryIdsAsString = GetterUtil.getString(request.getAttribute("userSegmentAssetCategoryIdsAsString"));
String userSegmentAssetCategoryNames = GetterUtil.getString(request.getAttribute("userSegmentAssetCategoryNames"));
String vocabularyGroupIds = GetterUtil.getString(request.getAttribute("vocabularyGroupIds"));
String vocabularyIds = GetterUtil.getString(request.getAttribute("vocabularyIds"));

List<ChannelTemplate> addedChannelTemplates = (List<ChannelTemplate>)request.getAttribute("addedChannelTemplates");
List<ChannelTemplate> channelTemplates = (List<ChannelTemplate>)request.getAttribute("channelTemplates");

String cssHasItemsClass = "";

if (addedChannelTemplates.size() > 0) {
	cssHasItemsClass = "has-items";
}

long campaignId = ParamUtil.getLong(request, "campaignId");
long tacticId = ParamUtil.getLong(request, "tacticId");

Tactic tactic = null;

String title = "new-promotion";

if (tacticId > 0) {
	tactic = TacticLocalServiceUtil.fetchTactic(tacticId);

	title = tactic.getName(locale);
}

if (Validator.isNull(backURL)) {
	PortletURL backURLObject = liferayPortletResponse.createRenderURL();

	backURLObject.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_CAMPAIGN);
	backURLObject.setParameter("campaignId", String.valueOf(campaignId));
	backURLObject.setParameter("className", Campaign.class.getName());
	backURLObject.setParameter("classPK", String.valueOf(campaignId));
	backURLObject.setParameter("tabs2", "promotions");

	backURL = backURLObject.toString();
}
%>

<liferay-ui:header
	backURL="<%= backURL.toString() %>"
	title="<%= title %>"
/>

<liferay-ui:error
	key="com.liferay.content.targeting.exception.InvalidChannelsException"
	message="there-is-an-error-in-one-of-your-channels"
/>

<liferay-portlet:actionURL name="updateTactic" var="addTacticURL" />

<aui:form action="<%= addTacticURL %>" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="campaignId" type="hidden" value="<%= campaignId %>" />
	<aui:input name="campaignUserSegmentsIds" type="hidden" value="<%= campaignUserSegmentsIds %>" />
	<aui:input name="vocabularyGroupIds" type="hidden" value="<%= vocabularyGroupIds %>" />
	<aui:input name="vocabularyIds" type="hidden" value="<%= vocabularyIds %>" />
	<aui:input name="tacticId" type="hidden" value="<%= tacticId %>" />
	<aui:input name="tacticChannels" type="hidden" />
	<aui:input name="saveAndContinue" type="hidden" />

	<aui:model-context bean="<%= tactic %>" model="<%= Tactic.class %>" />

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

	<aui:input name="name" />

	<aui:input name="description" />

	<liferay-util:include page="/macros/user_segment_selector.jsp" servletContext="<%= application %>">
		<liferay-util:param name="assetCategoryIds" value="<%= userSegmentAssetCategoryIdsAsString %>" />
		<liferay-util:param name="assetCategoryNames" value="<%= userSegmentAssetCategoryNames %>" />
		<liferay-util:param name="filterIds" value="<%= campaignUserSegmentsIds %>" />
		<liferay-util:param name="hiddenInput" value="userSegmentAssetCategoryIds" />
		<liferay-util:param name="vocabularyGroupIds" value="<%= vocabularyGroupIds %>" />
		<liferay-util:param name="vocabularyIds" value="<%= vocabularyIds %>" />
		<liferay-util:param name="warningMessage" value="editing-user-segments-deletes-all-unsaved-promotion-data" />
	</liferay-util:include>

	<span class="slider-holder"></span>

	<liferay-ui:panel collapsible="<%= false %>" cssClass="channel-panel" defaultState="open" extended="<%= false %>" helpMessage="channels-help" id="channelPanel" persistState="<%= true %>" title="channels">
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
									for (ChannelTemplate template : channelTemplates) {
										Channel channel = template.getChannel();

										String templateKey = template.getTemplateKey();
									%>

										<li class="form-builder-field hide property-builder-field" data-icon="<%= channel.getIcon() %>" data-key="<%= templateKey %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !channel.isInstantiable() %>">
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
					<div class="property-builder-canvas form-builder-canvas <%= cssHasItemsClass %>">
						<div class="alert alert-info alert-no-items">
							<liferay-ui:message key="drag-and-drop-the-different-channels-you-want-to-use-for-this-promotion" />
						</div>

						<div class="form-builder-drop-container property-builder-drop-container">

							<%
							for (ChannelTemplate template : addedChannelTemplates) {
								Channel channel = template.getChannel();

								String templateKey = template.getTemplateKey();
							%>

								<div class="component form-builder-field hide widget yui3-widget" data-icon="<%= channel.getIcon() %>" data-key="<%= templateKey %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !channel.isInstantiable() %>">
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
	</liferay-ui:panel>

	<aui:button-row>
		<aui:button cssClass="control-button" type="submit" />

		<aui:button cssClass="control-button" onClick="saveAndContinue();" value="save-and-continue" />

		<aui:button cssClass="control-button" href="<%= redirect %>" type="cancel" />
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