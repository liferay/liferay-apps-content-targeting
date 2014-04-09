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

<@liferay_ui["header"]
	backURL="${redirect}"
	title='${(userSegment.getName(locale))!"new-user-segment"}'
/>

<@portlet["actionURL"] name="updateUserSegment" var="addUserSegmentURL" />

<@aui["form"] action="${addUserSegmentURL}" method="post" name="fm" onSubmit="event.preventDefault(); saveRules();">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="userSegmentId" type="hidden" value=userSegmentId />
	<@aui["input"] name="userSegmentRules" type="hidden" />

	<@aui["model-context"] bean=userSegment model=userSegmentClass />

	<@aui["input"] name="name" />

	<@aui["input"] name="description" />

	<@aui["field-wrapper"] label="Rules">
		<div id="formBuilderBB" class="yui3-widget component diagram-builder form-builder liferayctformbuilder">
			<div id="formBuilderCB" class="diagram-builder-content form-builder-content">
				<div class="tabbable">
					<div class="tabbable-content">
						<ul class="nav nav-tabs">
							<li class="active"><a href="javascript:;">Add node</a></li>
							<li><a href="javascript:;">Settings</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane">
								<div class="panel-page-menu hide" id="formBuilderSB">
									<div class="search-panels">
										<i class="icon-search"></i>

										<div class="search-panels-bar">
											<@aui["input"] cssClass="search-panels-input search-query" label="" name="searchPanel" type="text" />
										</div>
									</div>
								</div>

								<ul class="diagram-builder-fields-container form-builder-fields-container clearfix">
									<#list ruleTemplates as template>
										<#assign rule = template.getRule()>
										<#assign templateKey = template.getTemplateKey()>

										<li class="diagram-builder-field form-builder-field hide" data-icon="${rule.getIcon()}" data-key="${templateKey}" data-template="${template.getTemplate()}" data-unique="${(!rule.isInstantiable())?string}">
											<span class="icon diagram-builder-field-icon ${rule.getIcon()}"></span>
											<div class="diagram-builder-field-label">
												<div class="row">
													<div class="rule-title">${rule.getName(locale)}</div>
													<div class="rule-description">${rule.getDescription(locale)}</div>
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
					<div class="diagram-builder-canvas form-builder-canvas">
						<div class="diagram-builder-drop-container form-builder-drop-container">
							<#if userSegment??>
								<#list addedRuleTemplates as template>
									<#assign rule = template.getRule()>
									<#assign templateKey = template.getTemplateKey()>

									<div class="widget component form-builder-field yui3-widget hide" data-icon="${rule.getIcon()}" data-key="${templateKey}" data-template="${template.getTemplate()}" data-unique="${(!rule.isInstantiable())?string}">
										<div>
											<div>
												<div class="rule-header">
													<div class="rule-icon"><i class="${rule.getIcon()}"></i></div>
													<div class="row rule-info">
														<div class="rule-title">${rule.getName(locale)}</div>
														<div class="rule-description">${rule.getDescription(locale)}</div>
													</div>
												</div>
												<div class="rule-editor">
												</div>
											</div>
										</div>
									</div>
								</#list>
							</#if>
						</div>
					</div>
				</div>

			</div>
		</div>
	</@>

	<@aui["button-row"]>
		<@aui["button"] type="submit" />
		<@aui["button"] href="${redirect}" type="cancel" />
	</@>
</@>

<@aui["script"] use="liferay-ct-form-builder">
	var userSegmentBuilder = new A.LiferayCTFormBuilder(
		{
			boundingBox: '#formBuilderBB',
			contentBox: '#formBuilderCB',
			searchBox: '#formBuilderSB'
		}
	).render();

	saveRules = function() {
		document.<@portlet["namespace"] />fm.<@portlet["namespace"] />userSegmentRules.value = userSegmentBuilder.exportAsJSON();

		submitForm(document.<@portlet["namespace"] />fm);
	};
</@>