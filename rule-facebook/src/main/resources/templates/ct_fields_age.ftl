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

<@liferay_aui["input"]
	cssClass="slider-input"
	inlineField=true
	label="older-than"
	maxlength="3"
	name="fbOlderThan"
	size="2"
	value=fbOlderThan
/> <span class="older slider-holder"></span>

<@liferay_aui["input"]
	cssClass="slider-input"
	inlineField=true
	label="younger-than"
	maxlength="3"
	name="fbYoungerThan"
	size="2"
	value=fbYoungerThan
/> <span class="slider-holder younger"></span>

<@liferay_aui["script"] use="liferay-input-slider">
	new Liferay.InputSlider(
		{
			inputNode: '#<@portlet["namespace"] />fbOlderThan'
		}
	);

	new Liferay.InputSlider(
		{
			inputNode: '#<@portlet["namespace"] />fbYoungerThan'
		}
	);
</@>