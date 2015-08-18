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
<#include "../macros.ftl" />
<#include "../macros_exceptions.ftl" />

<@liferay_ui["header"]
	backURL="${redirect}"
	title='${(tactic.getName(locale))!"new-tactic"}'
/>

<@invalidChannelsException />

<@portlet["actionURL"] name="updateTactic" var="addTacticURL" />

<@aui["form"] action="${addTacticURL}" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="campaignId" type="hidden" value="${campaignId}" />
	<@aui["input"] name="tacticId" type="hidden" value="${tacticId}" />
	<@aui["input"] name="tacticChannels" type="hidden" />

	<@aui["model-context"] bean=tactic model=tacticClass />

	<@invalidNameException />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	<@userSegmentSelector
		assetCategoryIds="${userSegmentAssetCategoryIdsAsString}"
		assetCategoryNames="${userSegmentAssetCategoryNames}"
		filterIds="${campaignUserSegmentsIds}"
		hiddenInput="userSegmentAssetCategoryIds"
		vocabularyGroupIds="${vocabularyGroupIds}"
		vocabularyIds="${vocabularyIds}"
		warningMessage="editing-user-segments-deletes-all-unsaved-tactic-data"
	/>

	<span class="slider-holder"></span>

	<@liferay_ui["panel"] cssClass="channel-panel" collapsible=true defaultState="open" extended=false id="channelPanel" helpMessage="channels-help" persistState=true title="channels">
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
									<div class="form-builder-search-panels">
										<i class="icon-search"></i>

										<div class="search-panels-bar">
											<@aui["input"] cssClass="search-panels-input search-query" label="" name="searchPanel" type="text" />
										</div>
									</div>
								</div>

								<ul class="clearfix diagram-builder-fields-container form-builder-fields-container">
									<#list channelsTemplates as template>
										<#assign channel = template.getChannel()>
										<#assign templateKey = template.getTemplateKey()>

										<li class="diagram-builder-field form-builder-field hide" data-icon="${channel.getIcon()}" data-key="${templateKey}" data-template="${template.getTemplate()}" data-unique="${(!channel.isInstantiable())?string}">
											<span class="diagram-builder-field-icon icon ${channel.getIcon()}"></span>

											<div class="diagram-builder-field-label">
												<div class="row">
													<div class="field-title">${channel.getName(locale)}</div>
													<div class="field-description">${channel.getDescription(locale)}</div>
													<div class="field-short-description">${channel.getShortDescription(locale)}</div>
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

					<#if (addedChannelsTemplates?size > 0)>
						<#assign cssHasItemsClass = "has-items">
					</#if>

					<div class="diagram-builder-canvas form-builder-canvas ${cssHasItemsClass}">
						<div class="alert alert-info alert-no-items">
							<@liferay_ui["message"] key="drag-and-drop-the-different-channels-you-want-to-use-for-this-tactic" />
						</div>

						<div class="diagram-builder-drop-container form-builder-drop-container">
							<#list addedChannelsTemplates as template>
								<#assign channel = template.getChannel()>
								<#assign templateKey = template.getTemplateKey()>

								<div class="component form-builder-field hide widget yui3-widget" data-icon="${channel.getIcon()}" data-key="${templateKey}" data-template="${template.getTemplate()}" data-unique="${(!channel.isInstantiable())?string}">
									<div>
										<div>
											<div class="field-header">
												<div class="field-icon"><i
														class="${channel.getIcon()}"></i>
												</div>
												<div class="field-info row">
													<div class="field-title">${channel.getName(locale)}</div>
													<div class="field-description">${channel.getDescription(locale)}</div>
													<div class="field-short-description">${channel.getShortDescription(locale)}</div>
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

	<@aui["script"]>
		function viewUserSegments() {
			if (confirm('<@liferay_ui["message"] key="editing-user-segments-deletes-all-unsaved-campaign-data" />')) {
				window.location.href = "${viewUserSegments}";
			}
		}
	</@>

	<@aui["script"] use="liferay-ct-form-builder">
		var tacticBuilder = new A.LiferayCTFormBuilder(
			{
				boundingBox: '#formBuilderBB',
				contentBox: '#formBuilderCB',
				searchBox: '#formBuilderSB'
			}
		).render();

		saveFields = function() {
			document.<@portlet["namespace"] />fm.<@portlet["namespace"] />tacticChannels.value = tacticBuilder.exportAsJSON();

			submitForm(document.<@portlet["namespace"] />fm);
		};
	</@>
</@>