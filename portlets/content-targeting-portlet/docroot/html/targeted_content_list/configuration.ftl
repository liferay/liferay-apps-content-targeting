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

<@liferay_portlet["actionURL"] name="updatePreferences" var="configurationURL">
	<@portlet["param"] name="redirect" value="${currentURL}" />
</@>

<@aui["form"] action="${configurationURL}" method="post" name="fm" onSubmit="event.preventDefault();">
	<@aui["fieldset"] label="asset-entry-type">
		<@aui["select"] label="" name="anyAssetType">
			<@aui["option"] label="any" selected=anyAssetType value=true />

			<#assign selectedValue = false>

			<#if !anyAssetType && (classNameIds?size > 1)>
				<#assign selectedValue = true>
			</#if>

			<@aui["option"] label='${languageUtil.get(themeDisplay.getLocale(), "select-more-than-one")}...' selected=selectedValue value=false />

			<optgroup label="<@liferay_ui["message"] key="asset-type" />">
				<#assign i = 0>

				<#list availableClassNameIds as classNameId>
					<#assign selectedValue = false>

					<#if (classNameIds?size == 1) && (classNameId == classNameIds[0])>
						<#assign selectedValue = true>
					</#if>

					<@aui["option"] label=modelResources[i] selected=selectedValue value=classNameId />

					<#assign i = i + 1>
				</#list>
			</optgroup>
		</@>

		<@aui["input"] name="classNameIds" type="hidden" />

		<#assign cssClass = "">

		<#if anyAssetType>
			<#assign cssClass = "hide">
		</#if>

		<div class="${cssClass}" id="<@portlet["namespace"] />classNamesBoxes">
			<@liferay_ui["input-move-boxes"]
				leftBoxName="currentClassNameIds"
				leftList=typesLeftList
				leftReorder="true"
				leftTitle="selected"
				rightBoxName="availableClassNameIds"
				rightList=typesRightList
				rightTitle="available"
			/>
		</div>
	</@>

	<@aui["button-row"]>
		<#assign onClickValue = renderResponse.getNamespace() + "saveSelectBoxes();">

		<@aui["button"] onClick=onClickValue type="submit" />
	</@>
</@>

<@aui["script"]>
	Liferay.provide(
		window,
		'<@portlet["namespace"] />saveSelectBoxes',
		function() {
			if (document.<@portlet["namespace"] />fm.<@portlet["namespace"] />classNameIds) {
				document.<@portlet["namespace"] />fm.<@portlet["namespace"] />classNameIds.value = Liferay.Util.listSelect(document.<@portlet["namespace"] />fm.<@portlet["namespace"] />currentClassNameIds);
			}

			submitForm(document.<@portlet["namespace"] />fm);
		},
		['liferay-util-list-fields']
	);

	Liferay.Util.toggleSelectBox('<@portlet["namespace"] />anyAssetType', 'false', '<@portlet["namespace"] />classNamesBoxes');
</@>