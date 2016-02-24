<#--
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
-->

<@portlet["defineObjects"] />

<@liferay_theme["defineObjects"] />

<#-- This setting is necessary since we are not loading FTL_liferay.ftl in the reports or rules -->

<#setting number_format="computer">

<@liferay_aui["input"]
	name="reportTrackingActions"
	type="hidden"
/>

<@liferay_ui["panel"] cssClass="tracking-actions-panel" collapsible=false defaultState="open" extended=false id="trackingActionPanel" helpMessage="metrics-help" persistState=true title="metrics">
	<div class="component property-builder form-builder liferayctformbuilder yui3-widget" id="formBuilderBB">
		<div class="property-builder-content form-builder-content" id="formBuilderCB">
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
										<@liferay_aui["input"]
											cssClass="search-panels-input search-query"
											label=""
											name="searchPanel"
											type="text"
										/>
									</div>
								</div>
							</div>

							<ul class="clearfix property-builder-fields-container form-builder-fields-container">
								<#list trackingActionTemplates as template>
									<#assign trackingAction = template.getTrackingAction()>
									<#assign templateKey = template.getTemplateKey()>

									<#if trackingAction.isVisible(className?string, classPK?long)>
										<li class="property-builder-field form-builder-field hide" data-icon="${trackingAction.getIcon()}" data-key="${templateKey}" data-template="${template.getTemplate()}" data-unique="${(!trackingAction.isInstantiable())?string}">
											<span class="property-builder-field-icon icon ${trackingAction.getIcon()}"></span>
											<div class="property-builder-field-label">
												<div class="row">
													<div class="field-title">${trackingAction.getName(locale)}</div>
													<div class="field-description">${trackingAction.getDescription(locale)}</div>
													<div class="field-short-description">${trackingAction.getShortDescription(locale)}</div>
												</div>
											</div>
										</li>
									</#if>
								</#list>
							</ul>
						</div>

						<div class="tab-pane"></div>
					</div>
				</div>
			</div>

			<div class="property-builder-content-container form-builder-content-container">
				<#assign cssHasItemsClass = "">

				<#if (addedTrackingActionTemplates?size > 0)>
					<#assign cssHasItemsClass = "has-items">
				</#if>

				<div class="property-builder-canvas form-builder-canvas ${cssHasItemsClass}">
					<div class="alert alert-info alert-no-items">
						<@liferay_ui["message"] key="drag-actions-to-track-in-this-report" />
					</div>

					<div class="property-builder-drop-container form-builder-drop-container">
						<#list addedTrackingActionTemplates as template>
							<#assign trackingAction = template.getTrackingAction()>
							<#assign templateKey = template.getTemplateKey()>

							<#if trackingAction.isVisible(className?string, classPK?long)>
								<div class="component form-builder-field hide widget yui3-widget" data-icon="${trackingAction.getIcon()}" data-key="${templateKey}" data-template="${template.getTemplate()}" data-unique="${(!trackingAction.isInstantiable())?string}">
									<div>
										<div>
											<div class="field-header">
												<div class="field-icon"><i class="${trackingAction.getIcon()}"></i></div>
												<div class="field-info row">
													<div class="field-title">${trackingAction.getName(locale)}</div>
													<div class="field-description">${trackingAction.getDescription(locale)}</div>
													<div class="field-short-description">${trackingAction.getShortDescription(locale)}</div>
												</div>4
											</div>
											<div class="field-editor">
											</div>
										</div>
									</div>
								</div>
							</#if>
						</#list>
					</div>
				</div>
			</div>

		</div>
	</div>
</@>

<@liferay_aui["script"] use="liferay-ct-form-builder">
	var reportBuilder = new A.LiferayCTFormBuilder(
		{
			boundingBox: '#formBuilderBB',
			contentBox: '#formBuilderCB',
			searchBox: '#formBuilderSB'
		}
	).render();

	<@portlet["namespace"] />_saveMetrics = function() {
		document.<@portlet["namespace"] />fm.<@portlet["namespace"] />reportTrackingActions.value = reportBuilder.exportAsJSON();
	};

	var form = A.one('#<@portlet["namespace"] />fm');

	Liferay.before(
		'submitForm',
		function(data) {
			if (data.form === form) {
				<@portlet["namespace"] />_saveMetrics();
			}
		}
	);
</@>