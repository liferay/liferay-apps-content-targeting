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

<@breadcrumb />

<#if validator.isNull(redirect)>
	<@portlet["renderURL"] var="redirect">
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
		<@portlet["param"] name="tabs1" value="campaigns" />
	</@>
</#if>

<@liferay_ui["header"]
	backURL="${redirect}"
	title="${title}"
/>

<@portlet["renderURL"] var="searchURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_TACTICS}" />
	<@portlet["param"] name="campaignId" value="${campaignId}" />
</@>

<@aui["form"] action="${searchURL}" method="post" name="fm">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="campaignId" type="hidden" value="${campaignId}" />
	<@aui["input"] name="tacticsIds" type="hidden" />

	<@aui["nav-bar"]>
		<#include "tactic_toolbar.ftl" />

		<@aui["nav-bar-search"] cssClass="pull-right">
			<div class="form-search">
				<@liferay_ui["input-search"] id="tacticskeywords" name="keywords" placeholder='${languageUtil.get(themeDisplay.getLocale(), "keywords")}' />
			</div>
		</@>
	</@>

	<div id="<@portlet["namespace"] />tacticsPanel">
		<#include "view_tactics_resources.ftl" />
	</div>
</@>

<@aui["script"] use="liferay-ajax-search">
	var tacticsPanel = A.one('#<@portlet["namespace"] />tacticsPanel');
	var inputNode = A.one('#<@portlet["namespace"] />tacticskeywords');

	var search = new Liferay.AjaxContentSearch(
		{
			contentPanel: tacticsPanel,
			inputNode: inputNode,
			resourceURL: '<@portlet["resourceURL"]><@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW_TACTICS_RESOURCES}" /></@>',
			namespace: '<@portlet["namespace"] />'
		}
	);
</@>