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

<#include "init.ftl" />

<@liferay_util["buffer"] var="selectorField" >
	<@liferay_aui["select"] inlineField=true label="" name="selector" style="width: auto;">
		<@liferay_aui["option"]
			label="more"
			selected=(selector
			== "more")
		/>
		<@liferay_aui["option"]
			label="less"
			selected=(selector
			== "less")
		/>
	</@>
</@>

<@liferay_ui["message"]
	arguments=selectorField
	key="users-that-have-x-than"
/>

<@liferay_aui["input"] inlineField=true label="" name="numberOfFriends" style="margin-bottom: 0; width: auto;" suffix="friends" title="number-of-friends" type="text" value=numberOfFriends>
	<@liferay_aui["validator"] name="number" />
</@>