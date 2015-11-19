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

<@aui["nav"]>
	<#if consumerManagerPermission.contains(permissionChecker, 0, actionKeys.ADD_CONSUMER)>
		<@portlet["renderURL"] var="redirectURL">
			<@portlet["param"] name="mvcPath" value="${consumerManagerPath.VIEW_CONSUMERS}" />
		</@>

		<@portlet["renderURL"] var="addConsumerURL">
			<@portlet["param"] name="mvcPath" value="${consumerManagerPath.EDIT_CONSUMER}" />
			<@portlet["param"] name="redirect" value="${redirectURL}" />
		</@>

		<@aui["nav-item"] href="${addConsumerURL}" iconCssClass="icon-plus" label='${languageUtil.get(portletConfig, locale, "add-consumer")}' />
	</#if>

	<#if consumerPermission.contains(permissionChecker, 0, actionKeys.DELETE)>
		<@aui["nav-item"] cssClass="hide" iconCssClass="icon-remove" id="deleteConsumers" label='${languageUtil.get(portletConfig, locale, "delete")}' />
	</#if>
</@>