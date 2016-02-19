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

<@portlet["renderURL"] varImpl="portletURL">
	<@portlet["param"]
		name="mvcRenderCommandName"
		value="${contentTargetingMVCCommand.VIEW_REPORT}"
	/>
	<@portlet["param"]
		name="redirect"
		value="${redirect}"
	/>
	<@portlet["param"]
		name="reportInstanceId"
		value="${reportInstanceId}"
	/>
	<@portlet["param"]
		name="reportKey"
		value="${report.getReportKey()}"
	/>
	<@portlet["param"]
		name="className"
		value="${className}"
	/>
	<@portlet["param"]
		name="classPK"
		value="${classPK?string}"
	/>
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="there-is-not-enough-data-to-generate-this-report"
	iteratorURL=portletURL
	total=searchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal"
		modelVar="ctActionTotal"
	>

		<#assign eventType = ctActionTotal.getEventType()>

		<#if ctActionTotal.getEventType() == "sending">
			<#assign eventType ="sent">
		<#elseif ctActionTotal.getEventType() == "click">
			<#assign eventType ="link-clicks">
		</#if>

		<@liferay_ui["search-container-column-text"]
			name="name"
			value=ctActionTotal.getAlias()
		/>

		<@liferay_ui["search-container-column-text"]
			name="event"
			value="${languageUtil.get(locale, eventType)}"
		/>

		<@liferay_ui["search-container-column-text"]
			name="count"
		>

			${ctActionTotal.getCount()}

			<#assign viewsByUserSegment = ctActionTotal.getViewsByUserSegment() />

			<#if viewsByUserSegment?has_content>
				<div class="pull-right">
					<i class="icon-info" data-id="${ctActionTotal.getCTActionTotalId()}" style="display: block;padding: 0 1em;"></i>

					<div class="hide" id="<@portlet["namespace"] />userSegmentViews${ctActionTotal.getCTActionTotalId()}">
						<#list viewsByUserSegment as ctAction>
							<p>${ctAction.getUserSegmentName(locale)} - ${ctAction.getCount()}</p>
						</#list>
					</div>
				</div>
			</#if>
		</@>

		<@liferay_ui["search-container-column-date"]
			name="last-update"
			value=ctActionTotal.getModifiedDate()
		/>
	</@>

	<#if searchContainer.getResults()?has_content>
		<#include "ct_chart.ftl" />
	</#if>

	<@liferay_ui["search-iterator"] />
</@>

<@liferay_aui["script"] use="aui-base,event-hover">
	A.one('#<@portlet["namespace"] />${searchContainerReference.getId(request)}SearchContainer').delegate(
		'hover',
		function(event) {
			var currentTarget = event.currentTarget;

			var id = currentTarget.attr('data-id');

			var userSegmentViews = A.one('#<@portlet["namespace"] />userSegmentViews' + id);

			Liferay.Portal.ToolTip.show(this, userSegmentViews.html());
		},
		'.icon-info'
	);
</@>