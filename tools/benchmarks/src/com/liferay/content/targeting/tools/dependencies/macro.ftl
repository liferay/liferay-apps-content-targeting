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

<#macro insertLayout
	_layoutModel
>
	insert into Layout values ('${_layoutModel.uuid}', ${_layoutModel.plid}, ${_layoutModel.groupId}, ${_layoutModel.companyId}, ${_layoutModel.userId}, '${_layoutModel.userName}', '${dataFactory.getDateString(_layoutModel.createDate)}', '${dataFactory.getDateString(_layoutModel.modifiedDate)}', ${_layoutModel.privateLayout?string}, ${_layoutModel.layoutId}, ${_layoutModel.parentLayoutId}, '${_layoutModel.name}', '${_layoutModel.title}', '${_layoutModel.description}', '${_layoutModel.keywords}', '${_layoutModel.robots}', '${_layoutModel.type}', '${_layoutModel.typeSettings}', ${_layoutModel.hidden?string}, '${_layoutModel.friendlyURL}', ${_layoutModel.iconImage?string}, ${_layoutModel.iconImageId}, '${_layoutModel.themeId}', '${_layoutModel.colorSchemeId}', '${_layoutModel.wapThemeId}', '${_layoutModel.wapColorSchemeId}', '${_layoutModel.css}', ${_layoutModel.priority}, '${_layoutModel.layoutPrototypeUuid}', ${_layoutModel.layoutPrototypeLinkEnabled?string}, '${_layoutModel.sourcePrototypeLayoutUuid}');

	<@insertResourcePermissions
		_entry = _layoutModel
	/>

	<#local layoutFriendlyURLModel = dataFactory.newLayoutFriendlyURLModel(_layoutModel)>

	insert into LayoutFriendlyURL values ('${layoutFriendlyURLModel.uuid}', ${layoutFriendlyURLModel.layoutFriendlyURLId}, ${layoutFriendlyURLModel.groupId}, ${layoutFriendlyURLModel.companyId}, ${layoutFriendlyURLModel.userId}, '${layoutFriendlyURLModel.userName}', '${dataFactory.getDateString(layoutFriendlyURLModel.createDate)}', '${dataFactory.getDateString(layoutFriendlyURLModel.modifiedDate)}', ${layoutFriendlyURLModel.plid}, ${layoutFriendlyURLModel.privateLayout?string}, '${layoutFriendlyURLModel.friendlyURL}', '${layoutFriendlyURLModel.languageId}');
</#macro>

<#macro insertPortletPreferences
	_portletPreferencesModel
>
	insert into PortletPreferences values (${_portletPreferencesModel.portletPreferencesId}, ${_portletPreferencesModel.ownerId}, ${_portletPreferencesModel.ownerType}, ${_portletPreferencesModel.plid}, '${_portletPreferencesModel.portletId}', '${_portletPreferencesModel.preferences}');

	<@insertResourcePermissions
		_entry = _portletPreferencesModel
	/>
</#macro>

<#macro insertResourcePermissions
	_entry
>
	<#local resourcePermissionModels = dataFactory.newResourcePermissionModels(_entry)>

	<#list resourcePermissionModels as resourcePermissionModel>
		insert into ResourcePermission values (${resourcePermissionModel.resourcePermissionId}, ${resourcePermissionModel.companyId}, '${resourcePermissionModel.name}', ${resourcePermissionModel.scope}, '${resourcePermissionModel.primKey}', ${resourcePermissionModel.roleId}, ${resourcePermissionModel.ownerId}, ${resourcePermissionModel.actionIds});
	</#list>
</#macro>