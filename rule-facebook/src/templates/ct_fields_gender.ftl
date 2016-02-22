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

<#assign isMale = gender?string == "male" />

<@liferay_aui["input"]
	checked=isMale
	label="male"
	name="fbGender"
	type="radio"
	value="male"
/>

<#assign isFemale = gender?string == "female" />

<@liferay_aui["input"]
	checked=isFemale
	label="female"
	name="fbGender"
	type="radio"
	value="female"
/>

<#assign isCustom = gender?string == "custom" />

<@liferay_aui["input"]
	checked=isCustom
	label="custom-or-not-specified"
	name="fbGender"
	type="radio"
	value="custom"
/>