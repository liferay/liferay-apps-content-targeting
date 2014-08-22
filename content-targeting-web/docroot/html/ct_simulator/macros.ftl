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

<#macro renderSimulatorLists
	containerId
	elements
	name
	notMatchedElements
	showSearch
	simulatedElementsPKs = []
>
	<#if showSearch>
		<div class="row-fluid search-panels">
			<i class="search-panel-icon"></i>

			<div class="search-panels-bar">
				<@aui["input"] cssClass="search-panels-input search-query span12" label="" name="search${name}Panel" type="text" />
			</div>
		</div>
	</#if>

	<div class="category-wrapper">
		<div class="category-header">
			<div class="category-icon">
				<i class="icon-check"></i>
			</div>
			<div class="category-info">
				<div class="category-title">
					<@liferay_ui["message"] key="matched" />
				</div>
				<div class="category-description">
					<@liferay_ui["message"] key="${name}" />
				</div>
			</div>
		</div>

		<div class="category-content">
			<#if userSegments?has_content>
				<#list elements as element>
					<@aui["input"] cssClass="element" label="${element.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" name="element${element.getPrimaryKey()}" type="checkbox" checked=simulatedElementsPKs?seq_contains(element.getPrimaryKey()) value=element.getPrimaryKey() />
				</#list>
			<#else>
				<div class="alert alert-info">
					<@liferay_ui["message"] arguments="${name}" key="the-current-user-does-not-match-any-x" />
				</div>
			</#if>
		</div>

		<div class="category-header">
			<div class="category-icon">
				<i class="icon-check-empty"></i>
			</div>
			<div class="category-info">
				<div class="category-title">
					<@liferay_ui["message"] key="other" />
				</div>
				<div class="category-description">
					<@liferay_ui["message"] key="${name}" />
				</div>
			</div>
		</div>

		<div class="category-content">
			<#list notMatchedElements as notMatchedElement>
				<@aui["input"] cssClass="element" label="${notMatchedElement.getNameWithGroupName(locale, themeDisplay.getScopeGroupId())}" name="notMatchedElement${notMatchedElement.getPrimaryKey()}" type="checkbox" checked=simulatedElementsPKs?seq_contains(notMatchedElement.getPrimaryKey()) value=notMatchedElement.getPrimaryKey() />
			</#list>
		</div>
	</div>

	<@aui["script"] use="aui-toggler,liferay-simulator-search">
		var inputNode = A.one('#<@portlet["namespace"] />search${name}Panel');
		var elementContainer = A.one('#<@portlet["namespace"] />${containerId}');

		var togglerDelegate = new A.TogglerDelegate(
			{
				animated: true,
				closeAllOnExpand: false,
				container: elementContainer,
				content: '.category-content',
				expanded: true,
				header: '.category-header'
			}
		);

		new Liferay.SimulatorSearch(
			{
				contentPanel: elementContainer,
				inputNode: inputNode,
				namespace: '<@portlet["namespace"] />',
				togglerDelegate: togglerDelegate
			}
		);
	</@>
</#macro>