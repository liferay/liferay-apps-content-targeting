<#--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
-->

<#include "../init.ftl" />
<#include "../macros_exceptions.ftl" />

<@liferay_ui["header"]
	backURL="${redirect}"
	title='${(campaign.getName(locale))!"new-campaign"}'
/>

<@invalidTrackingActionsException />

<@portlet["actionURL"] name="updateCampaign" var="addCampaignURL" />

<@aui["form"] action="${addCampaignURL}" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="campaignId" type="hidden" value=campaignId />
	<@aui["input"] name="campaignTrackingActions" type="hidden" />

	<@aui["model-context"] bean=campaign model=campaignClass />

	<@invalidNameException />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	<@aui["select"] inlineField=true label="user-segment" name="userSegmentId">
		<@aui["option"] label="any" selected=(userSegmentId == -1) value="-1" />

		<#list userSegments as userSegment>
			<@aui["option"] label="${userSegment.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" selected=(userSegmentId == userSegment.getUserSegmentId()) value="${userSegment.getUserSegmentId()}" />
		</#list>
	</@>

	<@portlet["renderURL"] var="viewUserSegments">
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
		<@portlet["param"] name="tabs1" value="user-segments" />
	</@>

	<script>

		function confirmToSegments() {

            if (confirm('${htmlUtil.escapeJS(languageUtil.get(themeDisplay.getLocale(), "editing-segments-will-delete-unsaved-campaign"))}')) {
                window.location.href = "${viewUserSegments}";
            } else {
				return false;
			}

		}

	</script>

	<@liferay_ui["icon"]
		id="manageUserSegments"
		image="configuration"
		label=false
		message="manage-user-segments"
		url="javascript:confirmToSegments();"
	/>

	<@invalidDateRangeException />

	<@aui["input"] name="startDate" value=startDate />

	<@aui["input"] name="endDate" value=endDate />

	<@aui["input"] cssClass="slider-input" helpMessage="priority-help" inlineField=true name="priority" size="2" maxlength="3" type="text" value="${priority}" />

	<span class="slider-holder"></span>

	<@aui["input"] name="active" value=true />

	<@liferay_ui["panel"] cssClass="tracking-actions-panel" collapsible=true defaultState="open" extended=false id="trackingActionPanel" helpMessage="tracking-actions-help" persistState=true title="tracking-actions">
		<div class="component diagram-builder form-builder liferayctformbuilder yui3-widget" id="formBuilderBB">
			<div class="diagram-builder-content form-builder-content" id="formBuilderCB">
				<div class="tabbable">
					<div class="tabbable-content">
						<ul class="nav nav-tabs">
							<li class="active"><a href="javascript:;">Add node</a></li>
							<li><a href="javascript:;">Settings</a></li>
						</ul>

						<div class="tab-content">
							<div class="tab-pane">
								<div class="hide panel-page-menu" id="formBuilderSB">
									<div class="search-panels">
										<i class="icon-search"></i>

										<div class="search-panels-bar">
											<@aui["input"] cssClass="search-panels-input search-query" label="" name="searchPanel" type="text" />
										</div>
									</div>
								</div>

								<ul class="clearfix diagram-builder-fields-container form-builder-fields-container">
									<#list trackingActionTemplates as template>
										<#assign trackingAction = template.getTrackingAction()>
										<#assign templateKey = template.getTemplateKey()>

										<li class="diagram-builder-field form-builder-field hide" data-icon="${trackingAction.getIcon()}" data-key="${templateKey}" data-template="${template.getTemplate()}" data-unique="${(!trackingAction.isInstantiable())?string}">
											<span class="diagram-builder-field-icon icon ${trackingAction.getIcon()}"></span>
											<div class="diagram-builder-field-label">
												<div class="row">
													<div class="field-title">${trackingAction.getName(locale)}</div>
													<div class="field-description">${trackingAction.getDescription(locale)}</div>
													<div class="field-short-description">${trackingAction.getShortDescription(locale)}</div>
												</div>
											</div>
										</li>
									</#list>
								</ul>
							</div>

							<div class="tab-pane"></div>
						</div>
					</div>
				</div>

				<div class="diagram-builder-content-container form-builder-content-container">
					<#assign cssHasItemsClass = "">

					<#if (addedTrackingActionTemplates?size > 0)>
						<#assign cssHasItemsClass = "has-items">
					</#if>

					<div class="diagram-builder-canvas form-builder-canvas ${cssHasItemsClass}">
						<div class="alert alert-info alert-no-items">
							<@liferay_ui["message"] key="drag-actions-to-track-in-the-reports-of-this-campaign" />
						</div>

						<div class="diagram-builder-drop-container form-builder-drop-container">
							<#list addedTrackingActionTemplates as template>
								<#assign trackingAction = template.getTrackingAction()>
								<#assign templateKey = template.getTemplateKey()>

								<div class="component form-builder-field hide widget yui3-widget" data-icon="${trackingAction.getIcon()}" data-key="${templateKey}" data-template="${template.getTemplate()}" data-unique="${(!trackingAction.isInstantiable())?string}">
									<div>
										<div>
											<div class="field-header">
												<div class="field-icon"><i class="${trackingAction.getIcon()}"></i></div>
												<div class="field-info row">
													<div class="field-title">${trackingAction.getName(locale)}</div>
													<div class="field-description">${trackingAction.getDescription(locale)}</div>
													<div class="field-short-description">${trackingAction.getShortDescription(locale)}</div>
												</div>
											</div>
											<div class="field-editor">
											</div>
										</div>
									</div>
								</div>
							</#list>
						</div>
					</div>
				</div>

			</div>
		</div>
	</@>

	<@aui["button-row"]>
		<@aui["button"] type="submit" />
	</@>

	<@aui["script"] use="liferay-ct-form-builder,liferay-input-slider">
		new Liferay.InputSlider(
			{
				inputNode: '#<@portlet["namespace"] />priority'
			}
		);

		var campaignBuilder = new A.LiferayCTFormBuilder(
			{
				boundingBox: '#formBuilderBB',
				contentBox: '#formBuilderCB',
				searchBox: '#formBuilderSB'
			}
		).render();

		saveFields = function() {
			document.<@portlet["namespace"] />fm.<@portlet["namespace"] />campaignTrackingActions.value = campaignBuilder.exportAsJSON();

			submitForm(document.<@portlet["namespace"] />fm);
		};
	</@>
</@>