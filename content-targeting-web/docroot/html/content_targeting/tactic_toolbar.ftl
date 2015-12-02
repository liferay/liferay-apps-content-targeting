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

<#include "../init.ftl" />

<@aui["nav"]>

	<#if campaignPermission.contains(permissionChecker, campaign, actionKeys.UPDATE)>
		<@portlet["renderURL"] var="redirectURL">
			<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
			<@portlet["param"] name="campaignId" value="${campaignId}" />
			<@portlet["param"] name="className" value="${campaignClass.getName()}" />
			<@portlet["param"] name="classPK" value="${campaignId}" />
			<@portlet["param"] name="tabs2" value="promotions" />
		</@>

		<@portlet["renderURL"] var="addTacticURL">
			<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_TACTIC}" />
			<@portlet["param"] name="campaignId" value="${campaignId}" />
			<@portlet["param"] name="redirect" value="${redirectURL}" />
		</@>

		<@aui["nav-item"] href="${addTacticURL}" iconCssClass="icon-plus" label='${languageUtil.get(portletConfig, locale, "add-promotion")}' />

		<@aui["nav-item"] cssClass="hide" iconCssClass="icon-remove" id="deleteTactics" label='${languageUtil.get(portletConfig, locale, "delete")}' />
	</#if>
</@>